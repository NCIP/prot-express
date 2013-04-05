/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security;

import gov.nih.nci.protexpress.util.UserHolder;

/**
 * Exception to indicate that a user attempted to make an illegal modification.
 * @author Scott Miller
 */
public class IllegalModificationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public IllegalModificationException() {
        super(UserHolder.getUsername() + " attempted to modify an object they can not edit.");
    }
}
