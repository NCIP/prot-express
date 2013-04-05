/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.service.ExperimentService;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.util.SearchCriteriaHelper;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default hibernate backed implementation of the experiment service.
 *
 * @author Scott Miller, Krishna Kanchinadam
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ExperimentServiceImpl extends HibernateDaoSupport implements ExperimentService {

    /**
     * {@inheritDoc}
     */
    public int countMatchingExperiments(SearchParameters params) {
        return (Integer) getExperimentSearchQuery(params, true, null, null).uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Experiment> searchForExperiments(SearchParameters params, int maxResults, int firstResult,
            String sortProperty, SortOrderEnum sortDir) {
        return getExperimentSearchQuery(params, false, sortProperty, sortDir).setMaxResults(maxResults).setFirstResult(
                firstResult).list();
    }

    private Criteria getExperimentSearchQuery(SearchParameters params, boolean onlyCount,
            String sortProperty, SortOrderEnum sortDir) {
        Criteria crit = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Experiment.class);

        crit = SearchCriteriaHelper.getCriteria(crit, params, onlyCount, sortProperty, sortDir);
        return crit;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Experiment> getMostRecentExperimentsforUser(String username, int numberOfExperiments) {
        String hql = "from " + Experiment.class.getName()
                + " where creator = :username order by auditInfo.lastModifiedDate desc";
        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString("username", username);
        return query.setMaxResults(numberOfExperiments).list();
    }

    /**
     * {@inheritDoc}
     */
    public Experiment getExperimentById(Long id) {
        return (Experiment) getHibernateTemplate().load(Experiment.class, id);
    }

    /**
     * {@inheritDoc}
     */
    public ExperimentRun getExperimentRunById(Long id) {
        return (ExperimentRun) getHibernateTemplate().load(ExperimentRun.class, id);
    }

    /**
     * {@inheritDoc}
     */
    public InputOutputObject getInputOutputObjectById(Long id) {
        return (InputOutputObject) getHibernateTemplate().load(InputOutputObject.class, id);
    }

    /**
     * {@inheritDoc}
     */
    public ProtocolApplication getProtocolApplicationById(Long id) {
        return (ProtocolApplication) getHibernateTemplate().load(ProtocolApplication.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteExperiment(Experiment experiment) {
        getHibernateTemplate().delete(experiment);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteExperimentRun(ExperimentRun experimentRun) {
        getHibernateTemplate().delete(experimentRun);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteInputOutputObject(InputOutputObject inputOutputObject) {
        getHibernateTemplate().delete(inputOutputObject);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProtocolApplication(ProtocolApplication protocolApplication) {
        getHibernateTemplate().delete(protocolApplication);
    }
}