/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import java.util.List;

import gov.nih.nci.security.authorization.domainobjects.User;

/**
 * Provides account information management functionality to the application.
 */
public interface AccountInformationService {

     /**
     * Retrieve the User with the given login name.
     *
     * @param loginName the id of the experiment to retrive
     * @return the {@link User}
     */
    List<User> getUserByLoginName(String loginName);
}
