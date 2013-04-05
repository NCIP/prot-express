/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.pagination;

import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

/**
 * @param <T> the type of the object stored in the embedded list
 * @author Scott Miller
 */
public class PaginatedListImpl<T> implements PaginatedList {

    private int fullListSize;
    private List<T> list;
    private int objectsPerPage;
    private int pageNumber;
    private String searchId;
    private String sortCriterion;
    private SortOrderEnum sortDirection;

    /**
     * Constructs a paginated list.
     *
     * @param fullListSize the full list size
     * @param list the data in the current page of items
     * @param objectsPerPage the number of objects per page
     * @param pageNumber the current page number
     * @param searchId the search id
     * @param sortCriterion the sort criterion
     * @param sortDirection the sort direction
     */
    public PaginatedListImpl(int fullListSize, List<T> list, int objectsPerPage, int pageNumber, String searchId,
            String sortCriterion, SortOrderEnum sortDirection) {
        super();
        this.fullListSize = fullListSize;
        this.list = list;
        this.objectsPerPage = objectsPerPage;
        this.pageNumber = pageNumber;
        this.searchId = searchId;
        this.sortCriterion = sortCriterion;
        this.sortDirection = sortDirection;
    }

    /**
     * {@inheritDoc}
     */
    public int getFullListSize() {
        return this.fullListSize;
    }

    /**
     * @param fullListSize the fullListSize to set
     */
    public void setFullListSize(int fullListSize) {
        this.fullListSize = fullListSize;
    }

    /**
     * @return the list
     */
    public List<T> getList() {
        return this.list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    /**
     * @return the objectsPerPage
     */
    public int getObjectsPerPage() {
        return this.objectsPerPage;
    }

    /**
     * @param objectsPerPage the objectsPerPage to set
     */
    public void setObjectsPerPage(int objectsPerPage) {
        this.objectsPerPage = objectsPerPage;
    }

    /**
     * @return the pageNumber
     */
    public int getPageNumber() {
        return this.pageNumber;
    }

    /**
     * @param pageNumber the pageNumber to set
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * @return the searchId
     */
    public String getSearchId() {
        return this.searchId;
    }

    /**
     * @param searchId the searchId to set
     */
    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    /**
     * @return the sortCriterion
     */
    public String getSortCriterion() {
        return this.sortCriterion;
    }

    /**
     * @param sortCriterion the sortCriterion to set
     */
    public void setSortCriterion(String sortCriterion) {
        this.sortCriterion = sortCriterion;
    }

    /**
     * @return the sortDirection
     */
    public SortOrderEnum getSortDirection() {
        return this.sortDirection;
    }

    /**
     * @param sortDirection the sortDirection to set
     */
    public void setSortDirection(SortOrderEnum sortDirection) {
        this.sortDirection = sortDirection;
    }
}
