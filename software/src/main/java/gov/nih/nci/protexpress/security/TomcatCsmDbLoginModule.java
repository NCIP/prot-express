/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security;

import gov.nih.nci.security.authentication.loginmodules.RDBMSLoginModule;
import gov.nih.nci.security.exceptions.internal.CSInternalConfigurationException;
import gov.nih.nci.security.exceptions.internal.CSInternalInsufficientAttributesException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/**
 * Implementation of the CSM login module that adds the correct principles to the subject for tomcat.
 *
 * @author Scott Miller
 */
public class TomcatCsmDbLoginModule extends RDBMSLoginModule {

    private TomcatAuthenticationStacker authenticationStacker;
    private Subject subject;
    private boolean authenticated;
    private String username;
    private List<String> roles;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Subject theSubject, CallbackHandler callbackHandler, Map sharedState, Map options) {
        super.initialize(theSubject, callbackHandler, sharedState, options);
        this.subject = theSubject;
        this.authenticated = false;
        this.username = null;
        this.roles = null;
        this.authenticationStacker = new TomcatAuthenticationStacker(sharedState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean validate(Map options, String user, char[] password, Subject theSubject)
            throws CSInternalConfigurationException, CSInternalInsufficientAttributesException {
        this.username = user;
        if (super.validate(options, user, password, theSubject)) {
            this.authenticationStacker.addAuthenticatedUserToSharedState(this.username);
            this.authenticated = true;
            this.roles = getRoles(options);
        } else {
            this.authenticated = false;
            if (this.authenticationStacker.isUserAlreadyAuthenticated(this.username)) {
                this.roles = getRoles(options);
            } else {
                this.roles = null;
            }
        }
        return this.authenticationStacker.isUserAlreadyAuthenticated(this.username);
    }

    private List<String> getRoles(Map connectionProperties) throws CSInternalConfigurationException {
        List<String> retrievedRoles = new ArrayList<String>();
        String driver = (String) connectionProperties.get("driver");
        String url = (String) connectionProperties.get("url");
        String user = (String) connectionProperties.get("user");
        String passwd = (String) connectionProperties.get("passwd");
        String rolesQuery = (String) connectionProperties.get("rolesQuery");

        // load the driver, if it is not loaded
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new CSInternalConfigurationException("Unable to Load Driver for Authentication Database");
        }

        // Get the connection to the database
        try {
            Connection connection = DriverManager.getConnection(url, user, passwd);
            PreparedStatement stmt = connection.prepareStatement(rolesQuery);
            stmt.setString(1, this.username);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                retrievedRoles.add(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new CSInternalConfigurationException("Unable to execute user exists query!");
        }
        return retrievedRoles;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean commit() throws LoginException {
        if (this.authenticated) {
            this.subject.getPrincipals().add(new UserPrincipal(this.username));
        }
        if (this.authenticationStacker.isUserAlreadyAuthenticated(this.username)) {
            for (String role : this.roles) {
                this.subject.getPrincipals().add(new RolePrincipal(role));
            }
        }
        return super.commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean logout() throws LoginException {
        this.subject = null;
        this.authenticated = false;
        this.username = null;
        this.roles = null;
        this.authenticationStacker.removeUserFromSharedState();
        this.authenticationStacker = null;
        return super.logout();
    }
}