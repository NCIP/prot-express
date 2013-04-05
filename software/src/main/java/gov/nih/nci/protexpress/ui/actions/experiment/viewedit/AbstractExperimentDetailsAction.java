/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ui.actions.experiment.AbstractExperimentTreeAction;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * An abstract base action class for all actions related to the Edit Experiment process.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public abstract class AbstractExperimentDetailsAction extends AbstractExperimentTreeAction {
    private static final long serialVersionUID = 1L;
    private String successMessage = null;
    private String actionResultRefreshTree = "refreshTree";


    /**
     * Action Constructor.
     */
    public AbstractExperimentDetailsAction() {
        super();
    }

    /**
     * Loads the data..
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        return ActionSupport.INPUT;
    }

    /**
     * Refresh the tree data.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String refreshTree() {
        return this.actionResultRefreshTree;
    }

    /**
     * Gets the successMessage.
     *
     * @return the successMessage.
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * Sets the successMessage.
     *
     * @param successMessage the successMessage to set.
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }


}