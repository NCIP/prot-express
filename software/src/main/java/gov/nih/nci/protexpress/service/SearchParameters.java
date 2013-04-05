/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import java.util.Date;

/**
 * The parameters for experiment searches.
 *
 * @author Krishna Kanchinadam
 */
public class SearchParameters {

    private SearchType searchType = SearchType.EXPERIMENTS;
    private String name;
    private Boolean searchAllUsers = false;
    private Date fromDate;
    private Date toDate;

    /**
     * The Constructor.
     */
    public SearchParameters() {
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the searchType.
     *
     * @return the searchType.
     */
    public SearchType getSearchType() {
        return searchType;
    }

    /**
     * Sets the searchType.
     *
     * @param searchType the searchType to set.
     */
    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    /**
     * Gets the searchAllUsers.
     *
     * @return the searchAllUsers.
     */
    public Boolean getSearchAllUsers() {
        return searchAllUsers;
    }

    /**
     * Sets the searchAllUsers.
     *
     * @param searchAllUsers the searchAllUsers to set.
     */
    public void setSearchAllUsers(Boolean searchAllUsers) {
        this.searchAllUsers = searchAllUsers;
    }

    /**
     * Gets the fromDate.
     *
     * @return the fromDate.
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * Sets the fromDate.
     *
     * @param fromDate the fromDate to set.
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Gets the toDate.
     *
     * @return the toDate.
     */
    public Date getToDate() {
        return toDate;
    }

    /**
     * Sets the toDate.
     *
     * @param toDate the toDate to set.
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

}
