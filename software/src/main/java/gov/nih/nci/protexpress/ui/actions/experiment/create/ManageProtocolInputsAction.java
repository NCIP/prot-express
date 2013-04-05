/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.ui.actions.ActionResultEnum;
import gov.nih.nci.protexpress.util.ManageProtAppInputOutputHelper;
import gov.nih.nci.protexpress.util.SessionHelper;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action for managing create experiment protocol inputs process.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ManageProtocolInputsAction extends AbstractProtocolApplicationAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private List<InputOutputObject> potentialInputs = new ArrayList<InputOutputObject>();
    private Long selectedInputId;

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        this.prepareProtocolInputOutputAction();
    }

    /**
     * Loads Protocol Inputs data.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        if (getProtocolApplication().getInputs().size() == 0) {
            ManageProtAppInputOutputHelper.addNewInput(getProtocolApplication().getInputs());
        }
        setPotentialInputs();
        return ActionSupport.INPUT;
    }

    /**
     * Updates protocol inputs.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String update() {
        setPotentialInputs();
        return ActionSupport.INPUT;
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

        setPotentialInputs();
        return getActionResult(ActionResultEnum.ADD_NEW_INPUT);
    }

    /**
     * Adds a potential input (output of another protocol) to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addExistingInput() {
        ManageProtAppInputOutputHelper.addExistingInput(getProtocolApplication().getInputs(), getSelectedInputId());
        setPotentialInputs();
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return getActionResult(ActionResultEnum.ADD_NEW_INPUT);
    }

    /**
     * Deletes the specified input from the protocol application.
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String deleteInput() {
        ManageProtAppInputOutputHelper.deleteInput(getProtocolApplication().getInputs(), getDeleteIndex());
        setPotentialInputs();
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return getActionResult(ActionResultEnum.ADD_NEW_INPUT);
    }

    /**
     * Saves the inputs to the session.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String saveInputsToSession() {
        return save();
    }

    /**
     * Persists the inputs to the database.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String saveInputs() {
        return save();
    }

    /**
     * Saves the inputs to session or db.
     *
     * @return the directive for the next action / page to be directed to
     */
    private String save() {
        ManageProtAppInputOutputHelper.removeInvalidItems(getProtocolApplication().getInputs());
        if (!ManageProtAppInputOutputHelper.isNameEmpty(getProtocolApplication().getInputs())) {
            addActionError(getText("protexpress.page.manageinputs.error.name.empty"));
            return getActionResult(ActionResultEnum.ADD_NEW_INPUT);
        }

        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.update.success"));
        if (getProtocolApplication().getId() != null) {
            ProtExpressRegistry.getProtExpressService().merge(getProtocolApplication());
            ProtExpressRegistry.getProtExpressService().clear();
            setProtocolApplicationId(getProtocolApplication().getId());
            return getActionResult(ActionResultEnum.EDIT_PROTOCOL);
        } else {
            SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
            setPotentialInputs();
        }

        return ActionSupport.SUCCESS;
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
}