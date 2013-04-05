/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security.test;


/**
 * @author Scott Miller
 *
 */
public class LdapLoginModuleTest extends LoginModuleTest {

    public void testIncorrectPasswordLoginAgainstLdap() throws Exception {
        validateFailedLogin("protExpressTestUser1", "unknownPassowrd");
    }

    public void testSuccessfulLoginAgainstLdapWithLocalAccount() throws Exception {
        validateSuccessfulLogin("protExpressTestUser1", "Sm0704**", true);
    }

    public void testSuccessfulLoginAgainstLdapWithNoLocalAccount() throws Exception {
        validateSuccessfulLogin("protExpressTestUser1", "Sm0704**", false);
    }
    
}
