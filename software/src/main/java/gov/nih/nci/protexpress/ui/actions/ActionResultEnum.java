/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions;

/**
 * Enum for managing all action results.
 * @author Krishna Kanchinadam
 *
 */


public enum ActionResultEnum {
    /**
     * View Experiment Summary.
     */
    VIEW_EXPERIMENT_SUMMARY("viewExperimentSummary"),
    /**
     * Edit Experiment.
     */
    EDIT_EXPERIMENT("editExperiment"),
    /**
     * View Protocol.
     */
    VIEW_PROTOCOL("viewProtocol"),
    /**
     * Edit Protocol.
     */
    EDIT_PROTOCOL("editProtocol"),
    /**
     * Add New Protocol.
     */
    ADD_NEW_PROTOCOL("addNewProtocol"),
    /**
     * Add New Protocol.
     */
    SELECT_EXISTING_PROTOCOL("selectExistingProtocol"),
    /**
     * Add New Protocol.
     */
    PROTOCOL_SEARCH_RESULTS("protocolSearchResults"),
    /**
     * Save and add new protocol.
     */
    SAVE_AND_ADD_NEW_PROTOCOL("saveAndAddNewProtocol"),
    /**
     * Save and view protocol summary.
     */
    VIEW_PROTOCOL_SUMMARY("viewProtocolSummary"),
    /**
     * Save and view experiment Summary.
     */
    SAVE_AND_VIEW_EXPERIMENT_SUMMARY("saveAndViewExperimentSummary"),
    /**
     * Add New Input.
     */
    ADD_NEW_INPUT("addNewInput"),
    /**
     * Select Existing Input.
     */
    SELECT_EXISTING_INPUT("selectExistingInput"),
    /**
     * Add New Output.
     */
    ADD_NEW_OUTPUT("addNewOutput"),
    /**
     * Forgot Password Action.
     */
    FORGOT_PASSWORD("forgotPassword");

    private String displayName;

    /**
     * Constructor for ActionResultEnum.
     *
     * @param displayname the action result string.
     */
    private ActionResultEnum(String displayname) {
        this.displayName = displayname;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return this.displayName;
    }
}
