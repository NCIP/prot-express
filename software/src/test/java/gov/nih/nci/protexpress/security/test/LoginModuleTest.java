/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security.test;

import gov.nih.nci.protexpress.security.RolePrincipal;
import gov.nih.nci.protexpress.security.UserPrincipal;
import gov.nih.nci.protexpress.test.ProtExpressBaseCsmTest;
import gov.nih.nci.security.authentication.callback.CSMCallbackHandler;

import java.util.Iterator;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * Tests the custom jaas login modules.
 *
 * @author Scott Miller
 */
public abstract class LoginModuleTest extends ProtExpressBaseCsmTest {

    protected void validateFailedLogin(String username, String password) throws LoginException {
        CSMCallbackHandler csmCallbackHandler = new CSMCallbackHandler(username, password);
        LoginContext loginContext = new LoginContext("protExpress", csmCallbackHandler);
        try {
            loginContext.login();
            fail("Invalid login did not cause exception.");
        } catch (LoginException e) {
            // expected
        }
    }

    protected void validateSuccessfulLogin(String username, String password, boolean hasRole) throws LoginException {
        CSMCallbackHandler csmCallbackHandler = new CSMCallbackHandler(username, password);
        LoginContext loginContext = new LoginContext("protExpress", csmCallbackHandler);
        loginContext.login();

        if ((loginContext != null) && (loginContext.getSubject() != null)) {
            Iterator principals = loginContext.getSubject().getPrincipals().iterator();
            UserPrincipal up = (UserPrincipal) principals.next();
            assertEquals(username, up.getName());

            if (hasRole) {
                RolePrincipal rp = (RolePrincipal) principals.next();
                assertEquals("protExpressUser", rp.getName());
            }

            loginContext.logout();
        }
    }
}