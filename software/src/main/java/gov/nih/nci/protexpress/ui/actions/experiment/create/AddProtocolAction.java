/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.service.SearchType;
import gov.nih.nci.protexpress.ui.actions.ActionResultEnum;
import gov.nih.nci.protexpress.ui.pagination.PaginatedListImpl;
import gov.nih.nci.protexpress.util.SessionHelper;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.displaytag.properties.SortOrderEnum;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action for managing create experiment process.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class AddProtocolAction extends AbstractProtocolApplicationAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private Long protocolId;
    private SearchParameters searchParameters = new SearchParameters();
    private PaginatedListImpl<Protocol> protocols = new PaginatedListImpl<Protocol>(
            0, null, ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name",
            SortOrderEnum.ASCENDING);

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        Long expId = getExperimentId();
        if (expId == null) {
            expId = SessionHelper.getExperimentIdFromSession();
        }

        if (expId != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(expId));
            setExperimentRun(getExperiment().getExperimentRuns().get(0));
        }

        if (SessionHelper.getProtocolApplicationFromSession() != null) {
            setProtocolApplication(SessionHelper.getProtocolApplicationFromSession());
        } else {
            logDebugMessage("No Protocol application object in session.");
        }
    }

    /**
     * Add or select a protocol.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addOrSelectProtocol() {
        SessionHelper.removeProtocolApplicationFromSession();
        setProtocolApplication(new ProtocolApplication(null, null, null));
        return ActionSupport.INPUT;
    }

    /**
     * Add a new protocol to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewProtocol() {
        setProtocolApplication(new ProtocolApplication(null, null, null));
        SessionHelper.removeProtocolApplicationFromSession();
        return getActionResult(ActionResultEnum.ADD_NEW_PROTOCOL);
    }

    /**
     * Action for adding another protocol to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addAnotherProtocol() {
        return addNewProtocol();
    }

    /**
     * select an existing protocol to add to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String selectExistingProtocol() {
        protocols = new PaginatedListImpl<Protocol>(0, null,
                ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name",
                SortOrderEnum.ASCENDING);

        doSearch();
        return getActionResult(ActionResultEnum.SELECT_EXISTING_PROTOCOL);
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
        getSearchParameters().setSearchType(SearchType.PROTOCOLS);
        count = ProtExpressRegistry.getProtocolService()
                .countMatchingProtocols(getSearchParameters());
        getProtocols().setFullListSize(count);
        getProtocols().setList(
                ProtExpressRegistry.getProtocolService().searchForProtocols(
                        getSearchParameters(),
                        getProtocols().getObjectsPerPage(),
                        getProtocols().getObjectsPerPage()
                                * (getProtocols().getPageNumber() - 1),
                        getProtocols().getSortCriterion(),
                        getProtocols().getSortDirection()));

        return getActionResult(ActionResultEnum.PROTOCOL_SEARCH_RESULTS);
    }

    /**
     * Creates a new Protocol, and adds it to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String save() {
        if (getExperimentRun() != null) {
            getProtocol().setContactPerson(ContactPerson.getCopy(getExperimentRun()
                    .getExperiment().getContactPerson()));
            return saveProtocolApplicationInformation();
        }

        return ActionSupport.INPUT;
    }

    /**
     * Selects a protocol, and adds it to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String selectProtocolAndContinue() {
        if (getExperimentRun() != null) {
            Protocol sourceProtocol = null;
            if (getProtocolId() != null) {
                sourceProtocol = ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId());
                setProtocol(sourceProtocol);
            }

            return saveProtocolApplicationInformation();
        }

        return ActionSupport.INPUT;
    }

    /**
     * Copies a protocol, and adds the copied protocol to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String copyProtocolAndContinue() {
        if (getExperimentRun() != null) {
            Protocol sourceProtocol = null;
            if (getProtocolId() != null) {
                sourceProtocol = ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId());
                setProtocol(Protocol.getCopy(sourceProtocol));
            }

            return saveProtocolApplicationInformation();
        }
        return ActionSupport.INPUT;
    }

    /**
     * Create/Select/Copy a protocol, and save protocol application information.
     *
     * @return the directive for the next action / page to be directed to
     */
    private String saveProtocolApplicationInformation() {
        if (getExperimentRun() != null) {
            getProtocolApplication().setDatePerformed(getExperimentRun().getDatePerformed());
            getProtocolApplication().setNotes(getProtocol().getNotes());
            getProtocolApplication().setProtocol(getProtocol());
            getProtocolApplication().setExperimentRun(getExperimentRun());
            getExperimentRun().getProtocolApplications().add(getProtocolApplication());

            SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * loads the protocol.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        return ActionSupport.INPUT;
    }

    /**
     * @return the protocols
     */
    public PaginatedListImpl<Protocol> getProtocols() {
        return this.protocols;
    }

    /**
     * @param protocols
     *            the protocols to set
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
     * @param searchParameters
     *            the searchParameters to set
     */
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    /**
     * Gets the protocolId.
     *
     * @return the protocolId.
     */
    public Long getProtocolId() {
        return protocolId;
    }

    /**
     * Sets the protocolId.
     *
     * @param protocolId the protocolId to set.
     */
    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

}