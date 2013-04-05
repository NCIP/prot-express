/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.service.SearchParameters;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 * Helper class to return the Search Parameters criteria.
 *
 * @author Krishna Kanchinadam
 */

public final class SearchCriteriaHelper {
    /**
     * Default constructor.
     *
     */
    private SearchCriteriaHelper() {
    }

    /**
     * Given a Date object, returns a Calendar.
     *
     * @param crit the Criteria
     * @param params the search parameters
     * @param onlyCount parameter for getting the count only
     * @param sortProperty the sort property
     * @param sortDir the sort order
     * @return the Criteria
     */
    public static Criteria getCriteria(Criteria crit, SearchParameters params, boolean onlyCount, String sortProperty,
            SortOrderEnum sortDir) {

        if (onlyCount) {
            crit.setProjection(Projections.rowCount());
        }

        if (!onlyCount && sortDir != null && StringUtils.isNotBlank(sortProperty)) {
            if (SortOrderEnum.ASCENDING.equals(sortDir)) {
                crit.addOrder(Order.asc(sortProperty));
            } else {
                crit.addOrder(Order.desc(sortProperty));
            }
        }

        if ((params != null) && (StringUtils.isNotEmpty(params.getName()))) {
            crit.add(Restrictions.like("name", "%" + params.getName() + "%").ignoreCase());
        }

       // crit.createAlias("auditInfo", "audit");
        if ((params != null) && !params.getSearchAllUsers()) {
            crit.add(Restrictions.eq("auditInfo.creator", UserHolder.getUsername()));
        }

        if ((params != null) && (params.getFromDate() != null)) {
            crit.add(Restrictions.ge("auditInfo.lastModifiedDate", DateHelper.getDate(params.getFromDate())));
        }

        if ((params != null) && (params.getToDate() != null)) {
            crit.add(Restrictions.le("auditInfo.lastModifiedDate", DateHelper.getDate(params.getToDate())));
        }

        return crit;
    }

}