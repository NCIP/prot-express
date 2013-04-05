/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.service.ProtocolService;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.util.SearchCriteriaHelper;
import gov.nih.nci.protexpress.util.UserHolder;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default hibernate backed implementation of the protocol service.
 *
 * @author Scott Miller
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class ProtocolServiceImpl extends HibernateDaoSupport implements ProtocolService {

    /**
     * {@inheritDoc}
     */
    public int countMatchingProtocols(SearchParameters params) {
        return (Integer) getProtocolSearchQuery(params, true, null, null).uniqueResult();
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Protocol> searchForProtocols(SearchParameters params, int maxResults, int firstResult,
            String sortProperty, SortOrderEnum sortDir) {
        return getProtocolSearchQuery(params, false, sortProperty, sortDir).setMaxResults(maxResults).setFirstResult(
                firstResult).list();
    }

    private Criteria getProtocolSearchQuery(SearchParameters params, boolean onlyCount, String sortProperty,
            SortOrderEnum sortDir) {
        Criteria crit = getHibernateTemplate().getSessionFactory().getCurrentSession().createCriteria(Protocol.class);
        crit = SearchCriteriaHelper.getCriteria(crit, params, onlyCount, sortProperty, sortDir);
        return crit;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Protocol> getMostRecentProtocolsforUser(String username, int numberOfProtocols) {
        String hql = "from " + Protocol.class.getName()
                + " where creator = :username order by auditInfo.lastModifiedDate desc";
        Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
        query.setString("username", username);
        return query.setMaxResults(numberOfProtocols).list();
    }

    /**
     * {@inheritDoc}
     */
    public Protocol getProtocolById(Long id) {
        return (Protocol) getHibernateTemplate().load(Protocol.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteProtocol(Protocol protocol) {
        getHibernateTemplate().delete(protocol);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Protocol> getProtocolsForCurrentUserByName(String protocolName) {
        String protocolNameParam = protocolName + "%";
        String hql = "from " + Protocol.class.getName()  + " where lower(name) like ? "
                + "and auditInfo.creator = ? order by name asc";
        return getHibernateTemplate().find(hql, new Object[] {protocolNameParam.toLowerCase(),
                UserHolder.getUsername()});
    }
}