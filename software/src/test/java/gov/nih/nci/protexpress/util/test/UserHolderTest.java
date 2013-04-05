/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.util.test;

import gov.nih.nci.protexpress.util.UserHolder;
import gov.nih.nci.security.authorization.domainobjects.User;
import junit.framework.TestCase;

/**
 * @author Scott Miller
 *
 */
public class UserHolderTest extends TestCase {

    public void testEmptyUserHolder() {
        assertEquals(null, UserHolder.getUser());
        assertEquals(null, UserHolder.getUsername());
        assertEquals(null, UserHolder.getDisplayNameForUser());
    }

    public void testFilledUserHolder() {
        User u = new User();
        u.setLoginName("foo");
        UserHolder.setUser(u);

        assertEquals("foo", UserHolder.getUser().getLoginName());
        assertEquals("foo", UserHolder.getUsername());
        assertEquals("foo", UserHolder.getDisplayNameForUser());

        u.setFirstName("");
        assertEquals("foo", UserHolder.getUsername());
        assertEquals("foo", UserHolder.getDisplayNameForUser());

        u.setLastName("");
        assertEquals("foo", UserHolder.getUsername());
        assertEquals("foo", UserHolder.getDisplayNameForUser());

        u.setFirstName("Test");
        assertEquals("foo", UserHolder.getUsername());
        assertEquals("foo", UserHolder.getDisplayNameForUser());

        u.setLastName("User");
        assertEquals("foo", UserHolder.getUsername());
        assertEquals("Test User", UserHolder.getDisplayNameForUser());
    }
}