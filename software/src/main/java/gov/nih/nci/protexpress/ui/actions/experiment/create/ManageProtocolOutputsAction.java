/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.ui.actions.ActionResultEnum;
import gov.nih.nci.protexpress.util.ManageProtAppInputOutputHelper;
import gov.nih.nci.protexpress.util.SessionHelper;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action for managing create experiment protocol outputs.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ManageProtocolOutputsAction extends AbstractProtocolApplicationAction  implements Preparable {
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        this.prepareProtocolInputOutputAction();
    }

    /**
     * Loads Protocol Outputs data.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        if (getProtocolApplication().getOutputs().size() == 0) {
            ManageProtAppInputOutputHelper.addNewOutput(getProtocolApplication().getOutputs());
        }
        return ActionSupport.INPUT;
    }

    /**
     * Updates protocol outputs.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String update() {
        return ActionSupport.INPUT;
    }

    /**
     * Creates a new output and adds to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewOutput() {
        ManageProtAppInputOutputHelper.addNewOutput(getProtocolApplication().getOutputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return getActionResult(ActionResultEnum.ADD_NEW_OUTPUT);
    }

    /**
     * Deletes the specified input from the protocol application.
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String deleteOutput() {
        ManageProtAppInputOutputHelper.deleteOutput(getProtocolApplication().getOutputs(), getDeleteIndex());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return getActionResult(ActionResultEnum.ADD_NEW_OUTPUT);
    }

    /**
     * Saves the outputs to the session.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String saveOutputsToSession() {
       return save();
    }

    /**
     * Persists the outputs to the database.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String saveOutputs() {
       return save();
    }

    /**
     * Saves the outputs to session or db.
     *
     * @return the directive for the next action / page to be directed to
     */
    private String save() {
        ManageProtAppInputOutputHelper.removeInvalidItems(getProtocolApplication().getOutputs());
        if (!ManageProtAppInputOutputHelper.isNameEmpty(getProtocolApplication().getOutputs())) {
            addActionError(getText("protexpress.page.manageoutputs.error.name.empty"));
            return getActionResult(ActionResultEnum.ADD_NEW_OUTPUT);
        }

        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.update.success"));
        if (getProtocolApplication().getId() != null) {
            ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocolApplication());
            ProtExpressRegistry.getProtExpressService().clear();
            setProtocolApplicationId(getProtocolApplication().getId());
            return getActionResult(ActionResultEnum.EDIT_PROTOCOL);
        } else {
            SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        }

        return ActionSupport.SUCCESS;
    }
}