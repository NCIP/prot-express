/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.register.Country;
import gov.nih.nci.protexpress.domain.register.RegistrationRequest;
import gov.nih.nci.protexpress.domain.register.State;
import gov.nih.nci.protexpress.service.RegistrationService;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation for the registration service.
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class RegistratationServiceImpl extends HibernateDaoSupport implements RegistrationService {

    /**
     * {@inheritDoc}
     */
    public void register(RegistrationRequest registrationRequest) {
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(registrationRequest);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Country> getCountries() {
        String query = "from " + Country.class.getName() + " c order by c.name asc";
        return getCurrentSession().createQuery(query).setCacheable(true).list();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<State> getStates() {
        String query = "from " + State.class.getName() + " s order by s.name asc";
        return getCurrentSession().createQuery(query).setCacheable(true).list();
    }

    private Session getCurrentSession() {
        return getHibernateTemplate().getSessionFactory().getCurrentSession();
    }
    
}
