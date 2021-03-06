/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.register;

import junit.framework.TestCase;

/**
 *
 */
public class RegistrationRequestTest extends TestCase {
    public void testRegistrationRequest() {
        RegistrationRequest r = new RegistrationRequest();
        Country c = new Country();
        State s = new State();
        r.setAddress1("address1");
        r.setAddress2("address2");
        r.setCity("city");
        r.setCountry(c);
        r.setEmail("email");
        r.setFax("fax");
        r.setFirstName("firstName");
        r.setLastName("lastName");
        r.setLoginName("loginName");
        r.setMiddleInitial("middleInitial");
        r.setOrganization("organization");
        r.setPhone("phone");
        r.setProvince("province");
        r.setRole("role");
        r.setState(s);
        r.setZip("zip");
        assertEquals("address1", r.getAddress1());
        assertEquals("address2", r.getAddress2());
        assertEquals("city", r.getCity());
        assertEquals(c, r.getCountry());
        assertEquals("email", r.getEmail());
        assertEquals("fax", r.getFax());
        assertEquals("firstName", r.getFirstName());
        assertEquals("lastName", r.getLastName());
        assertEquals("loginName", r.getLoginName());
        assertEquals("middleInitial", r.getMiddleInitial());
        assertEquals("organization", r.getOrganization());
        assertEquals("phone", r.getPhone());
        assertEquals("province", r.getProvince());
        assertEquals("role", r.getRole());
        assertEquals(s, r.getState());
        assertEquals("zip", r.getZip());
    }
}
