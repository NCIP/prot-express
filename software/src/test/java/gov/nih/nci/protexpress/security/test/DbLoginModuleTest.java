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
public class DbLoginModuleTest extends LoginModuleTest {

    public void testUnknownUserLogin() throws Exception {
        validateFailedLogin("unknownUser", "unknownPassowrd");
    }

    public void testIncorrectPasswordLoginAgainstDb() throws Exception {
        validateFailedLogin("user1", "unknownPassowrd");
    }

    public void testSuccessfulLoginAgainstDb() throws Exception {
        validateSuccessfulLogin("user1", "password", true);
    }
}
