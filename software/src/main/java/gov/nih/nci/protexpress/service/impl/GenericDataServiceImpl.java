/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

import gov.nih.nci.protexpress.service.GenericDataService;

/**
 *  Implementation for the generic data service. 
 */
public class GenericDataServiceImpl extends HibernateDaoSupport implements GenericDataService {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <T extends PersistentObject> T getPersistentObject(Class<T> toClass, Long id) {
        return (T) getSessionFactory().getCurrentSession().get(toClass, id);
    }

}
