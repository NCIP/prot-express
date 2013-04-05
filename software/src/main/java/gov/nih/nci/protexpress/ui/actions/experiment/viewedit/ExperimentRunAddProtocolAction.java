/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.service.SearchType;
import gov.nih.nci.protexpress.ui.pagination.PaginatedListImpl;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.displaytag.properties.SortOrderEnum;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class for adding a new protocol to an experiment run.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ExperimentRunAddProtocolAction extends ExperimentRunDetailsAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private Long newProtAppId;
    private Protocol protocol = new Protocol(null);
    private Long protocolId;
    private SearchParameters searchParameters = new SearchParameters();
    private PaginatedListImpl<Protocol> protocols = new PaginatedListImpl<Protocol>(
            0, null, ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name",
            SortOrderEnum.ASCENDING);

    private String actionResultAddNewProtocol = "addNewProtocol";
    private String actionResultSelectExistingProtocol = "selectExistingProtocol";
    private String actionResultEditProtocolApplicationDetails = "editProtocolApplication";

    /**
     * Action Constructor.
     */
    public ExperimentRunAddProtocolAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getExperimentRunId() != null) {
            setExperimentRun(ProtExpressRegistry.getExperimentService().getExperimentRunById(getExperimentRunId()));
        }
        if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }
        if (getProtocolId() != null) {
            setProtocol(ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId()));
        }
    }

    /**
     * Add a new protocol.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewProtocol() {
        return actionResultAddNewProtocol;
    }

    /**
     * select an existing protocol to add to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String selectExistingProtocol() {
        getSearchParameters().setSearchAllUsers(false);
        protocols = new PaginatedListImpl<Protocol>(0, null,
                ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name",
                SortOrderEnum.ASCENDING);

        searchProtocols();
        return this.actionResultSelectExistingProtocol;
    }

    /**
     * Perform Search for Protocols.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String searchProtocols() {
        getSearchParameters().setSearchType(SearchType.PROTOCOLS);

        int count = 0;
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

        return actionResultSelectExistingProtocol;
    }

    /**
     * Gets the protocol.
     *
     * @return the protocol.
     */
    @CustomValidator(type = "hibernate")
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the protocol.
     *
     * @param protocol the protocol to set.
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
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

    /**
     * Gets the searchParameters.
     *
     * @return the searchParameters.
     */
    public SearchParameters getSearchParameters() {
        return searchParameters;
    }

    /**
     * Sets the searchParameters.
     *
     * @param searchParameters the searchParameters to set.
     */
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    /**
     * Gets the protocols.
     *
     * @return the protocols.
     */
    public PaginatedListImpl<Protocol> getProtocols() {
        return protocols;
    }

    /**
     * Sets the protocols.
     *
     * @param protocols the protocols to set.
     */
    public void setProtocols(PaginatedListImpl<Protocol> protocols) {
        this.protocols = protocols;
    }

    /**
     * Creates a new Protocol, and adds it to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveNewProtocol() {
        getProtocol().setContactPerson(ContactPerson.getCopy(getExperimentRun().getExperiment().getContactPerson()));
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocol());
        return  saveProtocolApplicationInformation();
    }

    /**
     * Selects a protocol, and adds it to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String selectProtocolAndContinue() {
        Protocol sourceProtocol = null;
        if (getProtocolId() != null) {
            sourceProtocol = ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId());
            setProtocol(sourceProtocol);
        }

        return saveProtocolApplicationInformation();
    }

    /**
     * Copies a protocol, and adds the copied protocol to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String copyProtocolAndContinue() {
        Protocol sourceProtocol = null;
        if (getProtocolId() != null) {
            sourceProtocol = ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId());
            setProtocol(Protocol.getCopy(sourceProtocol));
        }

        return saveProtocolApplicationInformation();
    }

    /**
     * Create/Select/Copy a protocol, and save protocol application information.
     *
     * @return the directive for the next action / page to be directed to
     */
    private String saveProtocolApplicationInformation() {
         ProtocolApplication protApplication = new ProtocolApplication(getExperimentRun().getDatePerformed(),
                 getExperimentRun(), getProtocol());
             protApplication.setNotes(getProtocol().getNotes());
             ProtExpressRegistry.getProtExpressService().saveOrUpdate(protApplication.getProtocol());
             ProtExpressRegistry.getProtExpressService().saveOrUpdate(protApplication);
             ProtExpressRegistry.getProtExpressService().clear();

             // set the appropriate id's to pass as parameters to the next action.
             setNewProtAppId(protApplication.getId());
             setExperimentRunId(getExperimentRun().getId());
             setExperimentId(getExperiment().getId());
             return actionResultEditProtocolApplicationDetails;
    }

    /**
     * Gets the newProtAppId.
     *
     * @return the newProtAppId.
     */
    public Long getNewProtAppId() {
        return newProtAppId;
    }

    /**
     * Sets the newProtAppId.
     *
     * @param newProtAppId the newProtAppId to set.
     */
    public void setNewProtAppId(Long newProtAppId) {
        this.newProtAppId = newProtAppId;
    }
}