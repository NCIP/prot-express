/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security;

import java.security.Principal;

/**
 * The principal for a tomcat user.
 * @author Scott Miller
 */
public class UserPrincipal implements Principal {

    private String username;

    /**
     * Constructor.
     * @param username the username
     */
    public UserPrincipal(String username) {
        this.username = username;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.username;
    }
}