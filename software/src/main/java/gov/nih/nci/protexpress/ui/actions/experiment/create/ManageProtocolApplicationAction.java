/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.ui.actions.ActionResultEnum;
import gov.nih.nci.protexpress.util.SessionHelper;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * Action for managing protocols in an experiment.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ManageProtocolApplicationAction extends AbstractProtocolApplicationAction implements Preparable {
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        this.prepareProtocolInputOutputAction();
        if (getProtocolApplication() != null) {
            setProtocol(getProtocolApplication().getProtocol());
        }
    }

    /**
     * Review Protocol Summary information.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String viewProtocolSummary() {
        return getActionResult(ActionResultEnum.VIEW_PROTOCOL_SUMMARY);
    }

    /**
     * Loads the protocol and directs to the edit page.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String editProtocol() {
        return getActionResult(ActionResultEnum.EDIT_PROTOCOL);
    }

    /**
     * Save/Updates the protocol application and protocol information.
     *
     * @return the directive for the next action / page to be directed to
     */
    @Validations(
            requiredStrings = {@RequiredStringValidator(fieldName = "protocolApplication.protocol.name",
                    key = "validator.notEmpty", message = "") }
    )
    private void saveProtocol() {
        if (getProtocolApplication().getId() == null) {
            setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.save.success"));
        } else {
            setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.update.success"));
        }

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocol());
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocolApplication());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
    }

    /**
     * Saves the protocol application and protocol information, redirects to the view protocol screen.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveAndViewProtocol() {
        this.saveProtocol();
        return getActionResult(ActionResultEnum.VIEW_PROTOCOL_SUMMARY);
    }

    /**
     * Updates the protocol application and protocol information.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String updateProtocol() {
        this.saveProtocol();
        return getActionResult(ActionResultEnum.EDIT_PROTOCOL);
    }

    /**
     * Save/Updates the protocol application and protocol information, redirects to the add new protocol screen.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveAndAddNewProtocol() {
        this.saveProtocol();
        SessionHelper.removeProtocolApplicationFromSession();
        return getActionResult(ActionResultEnum.SAVE_AND_ADD_NEW_PROTOCOL);
    }

    /**
     * Save/Updates the protocol application and protocol information, redirects to the experiment summary screen.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveAndViewExperimentSummary() {
        this.saveProtocol();
        SessionHelper.removeProtocolApplicationFromSession();
        return getActionResult(ActionResultEnum.SAVE_AND_VIEW_EXPERIMENT_SUMMARY);
    }

}































