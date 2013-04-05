/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment;

import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;

import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * An abstract base action class for all actions related to the Experiment Tree.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public abstract class AbstractExperimentTreeAction extends ProtExpressBaseAction {
    private static final long serialVersionUID = 1L;

    private String selectedNodeId;

    /**
     * Action Constructor.
     */
    public AbstractExperimentTreeAction() {
        super();
    }

    /**
     * Gets the selectedNodeId.
     *
     * @return the selectedNodeId.
     */
    public String getSelectedNodeId() {
        return selectedNodeId;
    }

    /**
     * Sets the selectedNodeId.
     *
     * @param selectedNodeId the selectedNodeId to set.
     */
    public void setSelectedNodeId(String selectedNodeId) {
        this.selectedNodeId = selectedNodeId;
    }


}