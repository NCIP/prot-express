/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.protocol;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;

import java.text.MessageFormat;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
import com.opensymphony.xwork2.validator.annotations.Validations;

/**
 * Action for managing protocols.
 *
 * @author Scott Miller
 */
@Validation
public class ProtocolManagementAction extends ProtExpressBaseAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private Protocol protocol = new Protocol(null);
    private String cancelResult = "search";
    private String successMessage = null;

    private String actionResultViewProtocolDetails = "viewProtocolDetails";
    private String actionResultEditProtocolDetails = "editProtocolDetails";
    private String actionResultDeleteProtocol = "deleteProtocol";
    private String actionResultCancel = "cancel";


    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getProtocol() != null && getProtocol().getId() != null) {
            setProtocol(ProtExpressRegistry.getProtocolService().getProtocolById(getProtocol().getId()));
        }
    }

    /**
     * loads the protocols.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        return ActionSupport.INPUT;
    }

    /**
     * Loads the protocol and directs to the view/readonly page.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String viewProtocolDetails() {
        return this.actionResultViewProtocolDetails;
    }

    /**
     * Loads the protocol and directs to the edit page.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String editProtocolDetails() {
        return this.actionResultEditProtocolDetails;
    }

    /**
     * The action for deleting a protocol.
     * @return the forward to go to.
     */
    @SkipValidation
    public String deleteProtocol() {
        String msg = ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.delete.success");
        setSuccessMessage(MessageFormat.format(msg, getProtocol().getName()));
        ProtExpressRegistry.getProtocolService().deleteProtocol(getProtocol());

        return this.actionResultDeleteProtocol;
    }

    /**
     * The action for handling a cancel.
     * @return the forward to go to.
     */
    @SkipValidation
    public String cancel() {
        return this.actionResultCancel;
    }

    /**
     * Saves or updates the protocols.
     *
     * @return the directive for the next action / page to be directed to
     */
    @Validations(
            emails = {@EmailValidator(fieldName = "contactPerson.email",
                    key = "validator.email", message = "") }
    )
    public String save() {
        if (getProtocol().getId() == null) {
            setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.save.success"));
        } else {
            setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.update.success"));
        }
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocol());
        return ActionSupport.SUCCESS;
    }

    /**
     * @return the protocol
     */
    @CustomValidator(type = "hibernate")
    public Protocol getProtocol() {
        return this.protocol;
    }

    /**
     * @param protocol the protocol to set
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * @return the cancelResult
     */
    public String getCancelResult() {
        return this.cancelResult;
    }

    /**
     * @param cancelResult the cancelResult to set
     */
    public void setCancelResult(String cancelResult) {
        this.cancelResult = cancelResult;
    }

    /**
     * @return the successMessage
     */
    public String getSuccessMessage() {
        return this.successMessage;
    }

    /**
     * @param successMessage the successMessage to set
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}