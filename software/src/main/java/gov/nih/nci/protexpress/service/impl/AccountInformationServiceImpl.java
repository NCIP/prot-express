/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import gov.nih.nci.protexpress.service.AccountInformationService;
import gov.nih.nci.security.authorization.domainobjects.User;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default hibernate backed implementation of the account information service.
 *
 * @author  Krishna Kanchinadam
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class AccountInformationServiceImpl extends HibernateDaoSupport implements AccountInformationService {

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<User> getUserByLoginName(String loginName) {
        String hql = "from " + User.class.getName() + " where login_name = ? ";
        return getHibernateTemplate().find(hql, new Object[] {loginName});
    }
}
