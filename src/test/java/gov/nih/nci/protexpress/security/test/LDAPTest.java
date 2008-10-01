package gov.nih.nci.protexpress.security.test;

import gov.nih.nci.security.authentication.helper.LDAPHelper;
import gov.nih.nci.security.exceptions.internal.CSInternalConfigurationException;

import java.util.Hashtable;

import junit.framework.TestCase;

public class LDAPTest extends TestCase {
    private static final String PROT_EXPRESS_TEST_USER1_PASSWD = "Sm0704**";
    private static final String PROT_EXPRESS_TEST_USER1 = "protExpressTestUser1";

    public void testWorkingNCICBLdap() throws Exception {
        Hashtable<String, String> ldapContextParams = new Hashtable<String, String>();
        ldapContextParams.put("ldapHost", "ldaps://ncids4a.nci.nih.gov:636/");
        ldapContextParams.put("ldapSearchableBase", "ou=nci,o=nih");
        ldapContextParams.put("ldapUserIdLabel", "cn");

        assertTrue(LDAPHelper.authenticate(ldapContextParams, PROT_EXPRESS_TEST_USER1, PROT_EXPRESS_TEST_USER1_PASSWD.toCharArray(), null));
        assertTrue(LDAPHelper.authenticate(ldapContextParams, "protExpressTestUser2", PROT_EXPRESS_TEST_USER1_PASSWD.toCharArray(), null));
        assertTrue(LDAPHelper.authenticate(ldapContextParams, "protExpressTestUser3", PROT_EXPRESS_TEST_USER1_PASSWD.toCharArray(), null));
    }

    /**
     * A special test method that should be modified down the road once better information is gathered about the NCI's
     * LDAP servers and accessibility
     * 
     * @throws Exception
     */
    public void testShouldWorkUsingNCICBLdap() throws Exception {
        Hashtable<String, String> ldapContextParams = new Hashtable<String, String>();
        ldapContextParams.put("ldapHost", "ldaps://cbioweb-stage-ldap.nci.nih.gov:636/");
        ldapContextParams.put("ldapSearchableBase", "ou=nci,o=nih");
        ldapContextParams.put("ldapUserIdLabel", "cn");

        try {
            assertTrue("This fails when executing from a developer's sandbox", LDAPHelper.authenticate(
                    ldapContextParams, PROT_EXPRESS_TEST_USER1, PROT_EXPRESS_TEST_USER1_PASSWD.toCharArray(), null));
            fail("This fails when executing from a developer's sandbox");
        } catch (CSInternalConfigurationException e) {
            assertEquals("Error occured in connecting to the directory server", e.getMessage());
        } catch (Exception e) {
            throw e;
        }

        ldapContextParams.put("ldapHost", "ldaps://cbioweb.nci.nih.gov:636/");
        try {
            assertTrue("This fails when executing from a developer's sandbox", LDAPHelper.authenticate(
                    ldapContextParams, PROT_EXPRESS_TEST_USER1, PROT_EXPRESS_TEST_USER1_PASSWD.toCharArray(), null));
            fail("This fails when executing from a developer's sandbox");
        } catch (CSInternalConfigurationException e) {
            assertEquals("Error occured in connecting to the directory server", e.getMessage());
        } catch (Exception e) {
            throw e;
        }
    }

//    public void testFirebirdLdap() throws Exception {
//        Hashtable<String, String> ldapContextParams = new Hashtable<String, String>();
//        ldapContextParams.put("ldapHost", "ldap://cbioapp501.nci.nih.gov:389");
//        ldapContextParams.put("ldapSearchableBase", "ou=Users,dc=firebird,dc=nci,dc=nih,dc=gov");
//        ldapContextParams.put("ldapUserIdLabel", "uid");
//        ldapContextParams.put("ldapAdminUserName", "cn=Manager,dc=firebird,dc=nci,dc=nih,dc=gov");
//        ldapContextParams.put("ldapAdminPassword", "firebird");
//
//        assertTrue(LDAPHelper.authenticate(ldapContextParams, "fb_inv1", "f1rebird05".toCharArray(), null));
//    }
}
