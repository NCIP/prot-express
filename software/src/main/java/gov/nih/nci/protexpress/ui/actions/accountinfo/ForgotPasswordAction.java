/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.accountinfo;

import gov.nih.nci.protexpress.domain.ConfigParamEnum;
import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;
import gov.nih.nci.protexpress.ui.actions.registration.EmailHelper;
import gov.nih.nci.protexpress.util.ConfigurationHelper;

import javax.mail.MessagingException;

import org.apache.commons.lang.StringUtils;

import com.fiveamsolutions.nci.commons.web.struts2.action.ActionHelper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class to handle Change/Forgot Password functionality.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ForgotPasswordAction extends ProtExpressBaseAction {
    private static final long serialVersionUID = 1L;

    private String loginName;
    private String emailId;

    /**
     * Action Constructor.
     */
    public ForgotPasswordAction() {
        super();
    }

    /**
     * Method to submit the forgot password request.
     * @return the directive for the next action/page to be directed to.
     */
    public String submitRequest() {
        try {
            if (StringUtils.isBlank(getLoginName())) {
                addActionError(getText("forgotpassword.userNameNotSpecified"));
                return Action.INPUT;
            }

            if (StringUtils.isBlank(getEmailId())) {
                addActionError(getText("forgotpassword.emailIdNotSpecified"));
                return Action.INPUT;
            }

            //Send email to user and admin
            EmailHelper.sendPasswordRequestConfirmationEmailToUser(getEmailId());
             EmailHelper.sendPasswordRequestEmailToAdmin(getLoginName(), getEmailId());
             setSuccessMessage(ConfigurationHelper.getConfigurationStringValue(
                        ConfigParamEnum.FORGOT_PASSWORD_SUCCESS_MESSAGE));
             return Action.SUCCESS;
        } catch (MessagingException me) {
            ActionHelper.saveMessage(getText("forgotpassword.emailFailure"));
            addActionError(getText(getText("forgotpassword.emailFailure")));
            return Action.INPUT;
        }
    }

    /**
     * Gets the loginName.
     *
     * @return the loginName.
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * Sets the loginName.
     *
     * @param loginName the loginName to set.
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * Gets the emailId.
     *
     * @return the emailId.
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the emailId.
     *
     * @param emailId the emailId to set.
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}