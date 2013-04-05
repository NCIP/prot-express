/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security;

import gov.nih.nci.security.authentication.loginmodules.LDAPLoginModule;
import gov.nih.nci.security.exceptions.internal.CSInternalConfigurationException;
import gov.nih.nci.security.exceptions.internal.CSInternalInsufficientAttributesException;
import gov.nih.nci.security.exceptions.internal.CSInternalLoginException;

import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.LoginException;

/**
 * Login module for ldap under tomcat, using password stacking.
 *
 * @author Scott Miller
 */
public class TomcatCsmLdapLoginModule extends LDAPLoginModule {

    private Subject subject;
    private boolean authenticated;
    private String username;
    private TomcatAuthenticationStacker authenticationStacker;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize(Subject theSubject, CallbackHandler callbackHandler, Map sharedState, Map options) {
        super.initialize(theSubject, callbackHandler, sharedState, options);
        this.subject = theSubject;
        this.authenticated = false;
        this.username = null;
        this.authenticationStacker = new TomcatAuthenticationStacker(sharedState);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean validate(Map options, String user, char[] password, Subject theSubject)
            throws CSInternalConfigurationException, CSInternalLoginException,
            CSInternalInsufficientAttributesException {
        this.username = user;
        if (super.validate(options, user, password, theSubject)) {
            this.authenticationStacker.addAuthenticatedUserToSharedState(this.username);
            this.authenticated = true;
        } else {
            this.authenticated = false;
        }
        return this.authenticationStacker.isUserAlreadyAuthenticated(this.username);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean commit() throws LoginException {
        if (this.authenticated) {
            this.subject.getPrincipals().add(new UserPrincipal(this.username));
        }
        return super.commit();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean logout() throws LoginException {
        this.authenticationStacker.removeUserFromSharedState();
        this.subject = null;
        this.authenticated = false;
        this.username = null;
        this.authenticationStacker = null;
        return super.logout();
    }
}
