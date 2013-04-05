/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security;

import java.security.Principal;

/**
 * The principal type for a role in tomcat.
 * @author Scott Miller
 */
public class RolePrincipal implements Principal {

    private String roleName;

    /**
     * Constructor.
     * @param roleName the name of the role
     */
    public RolePrincipal(String roleName) {
        this.roleName = roleName;
    }

    /**
     * {@inheritDoc}
     */
    public String getName() {
        return this.roleName;
    }
}