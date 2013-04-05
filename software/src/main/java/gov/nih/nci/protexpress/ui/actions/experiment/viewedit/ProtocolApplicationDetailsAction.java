/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.util.ManageProtAppInputOutputHelper;
import gov.nih.nci.protexpress.util.SessionHelper;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class for editing protocol application details.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ProtocolApplicationDetailsAction extends ExperimentRunDetailsAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private ProtocolApplication protocolApplication = null;
    private Long protocolApplicationId;
    private Long deleteIndex;
    private Long selectedInputId;

    private List<InputOutputObject> potentialInputs = new ArrayList<InputOutputObject>();

    private String actionResultManageInputs = "manageInputs";
    private String actionResultAddInputs = "addInputs";
    private String actionResultAddOutputs = "addOutputs";
    private String actionResultDelete = "delete";


    /**
     * Action Constructor.
     */
    public ProtocolApplicationDetailsAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getProtocolApplicationId() != null) {
            setProtocolApplication(ProtExpressRegistry.getExperimentService().
                    getProtocolApplicationById(getProtocolApplicationId()));
        } else if (SessionHelper.getProtocolApplicationFromSession() != null) {
            setProtocolApplication(SessionHelper.getProtocolApplicationFromSession());
        }

        if (getExperimentRunId() != null) {
            setExperimentRun(ProtExpressRegistry.getExperimentService().getExperimentRunById(getExperimentRunId()));
        }
        if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }

        if (getProtocolApplication() != null) {
            setPotentialInputs();
        }
    }

    /**
     * Manage Inputs.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String manageInputs() {
        SessionHelper.removeProtocolApplicationFromSession();
        ManageProtAppInputOutputHelper.addNewInput(getProtocolApplication().getInputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultManageInputs;
    }

    /**
     * Manage Outputs.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String manageOutputs() {
        SessionHelper.removeProtocolApplicationFromSession();
        ManageProtAppInputOutputHelper.addNewOutput(getProtocolApplication().getOutputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddOutputs;
    }

    /**
     * Creates a new input, adds to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewInput() {
        ManageProtAppInputOutputHelper.addNewInput(getProtocolApplication().getInputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddInputs;
    }

    /**
     * Creates a new output, adds to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewOutput() {
        ManageProtAppInputOutputHelper.addNewOutput(getProtocolApplication().getOutputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddOutputs;
    }

    /**
     * Adds a potential input (output of another protocol) to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addExistingInput() {
        ManageProtAppInputOutputHelper.addExistingInput(getProtocolApplication().getInputs(), getSelectedInputId());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        setPotentialInputs();
        return this.actionResultAddInputs;
    }

    /**
     * Deletes the specified input from the protocol application.
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String deleteInput() {
        ManageProtAppInputOutputHelper.deleteInput(getProtocolApplication().getInputs(), getDeleteIndex());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        setPotentialInputs();
        return this.actionResultAddInputs;
    }

    /**
     * Deletes the specified output from the protocol application.
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String deleteOutput() {
        ManageProtAppInputOutputHelper.deleteOutput(getProtocolApplication().getOutputs(), getDeleteIndex());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddOutputs;
    }

    /**
     * Updates the inputs for the protocol application. .
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String updateInputs() {
        ManageProtAppInputOutputHelper.removeInvalidItems(getProtocolApplication().getInputs());
        if (!ManageProtAppInputOutputHelper.isNameEmpty(getProtocolApplication().getInputs())) {
            addActionError(getText("protexpress.page.manageinputs.error.name.empty"));
            return this.actionResultAddInputs;
        }
        return save("protocol.inputs.update.success");
    }

    /**
     * Updates the inputs for the protocol application. .
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String updateOutputs() {
        ManageProtAppInputOutputHelper.removeInvalidItems(getProtocolApplication().getOutputs());
        if (!ManageProtAppInputOutputHelper.isNameEmpty(getProtocolApplication().getOutputs())) {
            addActionError(getText("protexpress.page.manageoutputs.error.name.empty"));
            return this.actionResultAddOutputs;
        }
        return save("protocol.outputs.update.success");
    }

    /**
     * Save the Protocol Application.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveProtocolApplication() {
        return save("protocol.update.success");
    }

    /**
     * save the protocol application.
     *
     * @param messageKey the success update message key.
     * @return the directive for the next action / page to be directed to
     */
    private String save(String messageKey) {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString(messageKey));
        ProtExpressRegistry.getProtExpressService().merge(getProtocolApplication());
        ProtExpressRegistry.getProtExpressService().clear();
        SessionHelper.removeProtocolApplicationFromSession();
        return ActionSupport.SUCCESS;
    }

    /**
     * Gets the protocolApplication.
     *
     * @return the protocolApplication.
     */
    @CustomValidator(type = "hibernate")
    public ProtocolApplication getProtocolApplication() {
        return protocolApplication;
    }

    /**
     * Sets the protocolApplication.
     *
     * @param protocolApplication the protocolApplication to set.
     */
    public void setProtocolApplication(ProtocolApplication protocolApplication) {
        this.protocolApplication = protocolApplication;
    }

    /**
     * Gets the protocolApplicationId.
     *
     * @return the protocolApplicationId.
     */
    public Long getProtocolApplicationId() {
        return protocolApplicationId;
    }

    /**
     * Sets the protocolApplicationId.
     *
     * @param protocolApplicationId the protocolApplicationId to set.
     */
    public void setProtocolApplicationId(Long protocolApplicationId) {
        this.protocolApplicationId = protocolApplicationId;
    }

    /**
     * Gets the deleteIndex.
     *
     * @return the deleteIndex.
     */
    public Long getDeleteIndex() {
        return deleteIndex;
    }

    /**
     * Sets the deleteIndex.
     *
     * @param deleteIndex the deleteIndex to set.
     */
    public void setDeleteIndex(Long deleteIndex) {
        this.deleteIndex = deleteIndex;
    }

    /**
     * Gets the potentialInputs.
     *
     * @return the potentialInputs.
     */
    public List<InputOutputObject> getPotentialInputs() {
        return potentialInputs;
    }

    /**
     * Sets the potentialInputs.
     *
     */
    public void setPotentialInputs() {
        setPotentialInputs(ManageProtAppInputOutputHelper
                .getPotentialInputs(getExperimentRun().getId(), getProtocolApplication()));
    }

    /**
     * Sets the potentialInputs.
     *
     * @param potentialInputs the potentialInputs to set.
     */
    public void setPotentialInputs(List<InputOutputObject> potentialInputs) {
        this.potentialInputs = potentialInputs;
    }

    /**
     * Gets the selectedInputId.
     *
     * @return the selectedInputId.
     */
    public Long getSelectedInputId() {
        return selectedInputId;
    }

    /**
     * Sets the selectedInputId.
     *
     * @param selectedInputId the selectedInputId to set.
     */
    public void setSelectedInputId(Long selectedInputId) {
        this.selectedInputId = selectedInputId;
    }

    /**
     * Deletes the protocol application from the run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String delete() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.delete.success"));
        getProtocolApplication().getExperimentRun().getProtocolApplications().remove(getProtocolApplication());
        ProtExpressRegistry.getExperimentService().deleteProtocolApplication(getProtocolApplication());
        return actionResultDelete;
    }
}