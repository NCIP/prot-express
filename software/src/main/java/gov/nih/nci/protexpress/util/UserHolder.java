/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.util;

import org.apache.commons.lang.StringUtils;

import gov.nih.nci.security.authorization.domainobjects.User;

/**
 * Utility class to store the threads current user.
 * @author Scott Miller
 */
public final class UserHolder {
    private static ThreadLocal<User> tlocal = new ThreadLocal<User>();

    private UserHolder() {
        // No constructor for util class
    }

    /**
     * @param user the user to set for the current thread
     */
    public static void setUser(User user) {
        tlocal.set(user);
    }

    /**
     * @return the currently logged in user for this thread, or null
     */
    public static User getUser() {
        return tlocal.get();
    }

    /**
     * Return the currently logged in users username, or null.
     * @return the username, or null
     */
    public static String getUsername() {
        if (UserHolder.getUser() != null) {
            return UserHolder.getUser().getLoginName();
        }
        return null;
    }

    /**
     * @return the display name of the currently logged in user, or null
     */
    public static String getDisplayNameForUser() {
        String name = null;
        User user = UserHolder.getUser();
        if (user != null) {
            if (StringUtils.isNotBlank(user.getFirstName()) && StringUtils.isNotBlank(user.getLastName())) {
                name =  user.getFirstName() + " " + user.getLastName();
            } else {
                name = user.getLoginName();
            }
        }
        return name;
    }
}
