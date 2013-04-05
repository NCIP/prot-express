/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import gov.nih.nci.protexpress.service.ProtExpressService;

import java.util.List;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Implementation of the {@link ProtExpressService}.
 *
 * @author Scott Miller
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProtExpressServiceImpl extends HibernateDaoSupport implements ProtExpressService {

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveOrUpdate(Object object) {
        getHibernateTemplate().saveOrUpdate(object);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void merge(Object object) {
        getHibernateTemplate().merge(object);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void clear() {
        getHibernateTemplate().clear();
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean isFieldUnique(PersistentObject bean, String fieldName, Object fieldValue) {
        Class persistentClass = bean.getClass();
        if (bean instanceof HibernateProxy) {
            persistentClass = ((HibernateProxy) bean).getHibernateLazyInitializer().getPersistentClass();
        }
        StringBuffer hql = new StringBuffer("from " + persistentClass.getName() + " where " + fieldName + " = ?");
        Object[] args = null;
        if (bean.getId() != null) {
            hql.append(" and id != ?");
            args = new Object[]{fieldValue, bean.getId()};
        } else {
            args = new Object[]{fieldValue};
        }
        List objects = getHibernateTemplate().find(hql.toString(), args);
        if (objects.size() > 0) {
            return false;
        }
        return true;
    }
}