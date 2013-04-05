/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Service of utility methods that are not attached to a specific class.
 *
 * @author Scott Miller
 */
public interface ProtExpressService {

    /**
     * Saves or updates the given hibernate object.
     *
     * @param object the object to save
     */
    void saveOrUpdate(Object object);

    /**
     * Merges the given hibernate object.
     *
     * @param object the object to save
     */
    void merge(Object object);

    /**
     * Is the object the one and only object with the value for the given field.
     *
     * @param bean the object to check for uniqueness with
     * @param fieldName the fieldName of the unique field in question
     * @param fieldValue the value of the field
     * @return true if the object is the one and only object with the given value for the given field
     */
    boolean isFieldUnique(PersistentObject bean, String fieldName, Object fieldValue);
    /**
     * clear the hibernate session.
     *
     */
    void clear();
}