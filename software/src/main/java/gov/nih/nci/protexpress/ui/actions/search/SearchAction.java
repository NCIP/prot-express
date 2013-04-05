/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.search;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.service.SearchType;
import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;
import gov.nih.nci.protexpress.ui.pagination.PaginatedListImpl;

import java.util.Map;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.displaytag.properties.SortOrderEnum;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Krishna Kanchinadam
 */
public class SearchAction extends ProtExpressBaseAction {
    private static final long serialVersionUID = 1L;

    private SearchParameters searchParameters = new SearchParameters();

    private PaginatedListImpl<Protocol> protocols = new PaginatedListImpl<Protocol>(0, null,
            ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name", SortOrderEnum.ASCENDING);

    private PaginatedListImpl<Experiment> experiments = new PaginatedListImpl<Experiment>(0, null,
            ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name", SortOrderEnum.ASCENDING);

    private Map session;
    private final String searchCriteria = "searchCriteria";
    private final String actionResultLoadSearchForm = "loadSearchForm";

    /**
     * load the search page.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String loadSearch() {
        session = ActionContext.getContext().getSession();
        if ((session != null) && (session.get(this.searchCriteria) != null)) {
            session.remove(this.searchCriteria);
        }

        protocols = new PaginatedListImpl<Protocol>(0, null,
                ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name", SortOrderEnum.ASCENDING);
        experiments = new PaginatedListImpl<Experiment>(0, null,
                ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name", SortOrderEnum.ASCENDING);
        doSearch();
        return actionResultLoadSearchForm;
    }

    /**
     * re-load the search page, based on the previous criteria.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String reloadSearch() {
        session = ActionContext.getContext().getSession();
        if ((session != null) && (session.get(this.searchCriteria) != null)) {
            setSearchParameters((SearchParameters) session.get(this.searchCriteria));
        }

        doSearch();
        return actionResultLoadSearchForm;
    }

    /**
     * Perform Search for Protocols/Experiments.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String doSearch() {
        int count = 0;

        if (session != null) {
            session = ActionContext.getContext().getSession();
            session.put(this.searchCriteria, getSearchParameters());
        }

        SearchType searchType = getSearchParameters().getSearchType();
        if (searchType.equals(SearchType.EXPERIMENTS)) {
            count = ProtExpressRegistry.getExperimentService().countMatchingExperiments(getSearchParameters());
            getExperiments().setFullListSize(count);
            getExperiments().setList(
                    ProtExpressRegistry.getExperimentService().searchForExperiments(getSearchParameters(),
                            getExperiments().getObjectsPerPage(),
                            getExperiments().getObjectsPerPage() * (getExperiments().getPageNumber() - 1),
                            getExperiments().getSortCriterion(), getExperiments().getSortDirection()));
        }

        if (searchType.equals(SearchType.PROTOCOLS)) {
            count = ProtExpressRegistry.getProtocolService().countMatchingProtocols(getSearchParameters());
            getProtocols().setFullListSize(count);
            getProtocols().setList(
                    ProtExpressRegistry.getProtocolService().searchForProtocols(getSearchParameters(),
                            getProtocols().getObjectsPerPage(),
                            getProtocols().getObjectsPerPage() * (getProtocols().getPageNumber() - 1),
                            getProtocols().getSortCriterion(), getProtocols().getSortDirection()));
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * @return the experiments
     */
    public PaginatedListImpl<Experiment> getExperiments() {
        return this.experiments;
    }

    /**
     * @param experiments the experiments to set
     */
    public void setExperiments(PaginatedListImpl<Experiment> experiments) {
        this.experiments = experiments;
    }

    /**
     * @return the protocols
     */
    public PaginatedListImpl<Protocol> getProtocols() {
        return this.protocols;
    }

    /**
     * @param protocols the protocols to set
     */
    public void setProtocols(PaginatedListImpl<Protocol> protocols) {
        this.protocols = protocols;
    }

    /**
     * @return the searchParameters
     */
    public SearchParameters getSearchParameters() {
        return this.searchParameters;
    }

    /**
     * @param searchParameters the searchParameters to set
     */
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }
}