/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The caarray-war
 * Software was developed in conjunction with the National Cancer Institute
 * (NCI) by NCI employees and 5AM Solutions, Inc. (5AM). To the extent
 * government employees are authors, any rights in such works shall be subject
 * to Title 17 of the United States Code, section 105.
 *
 * This caarray-war Software License (the License) is between NCI and You. You (or
 * Your) shall mean a person or an entity, and all other entities that control,
 * are controlled by, or are under common control with the entity. Control for
 * purposes of this definition means (i) the direct or indirect power to cause
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares,
 * or (iii) beneficial ownership of such entity.
 *
 * This License is granted provided that You agree to the conditions described
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up,
 * no-charge, irrevocable, transferable and royalty-free right and license in
 * its rights in the caarray-war Software to (i) use, install, access, operate,
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the caarray-war Software; (ii) distribute and
 * have distributed to and by third parties the caarray-war Software and any
 * modifications and derivative works thereof; and (iii) sublicense the
 * foregoing rights set out in (i) and (ii) to third parties, including the
 * right to license such rights to further third parties. For sake of clarity,
 * and not by way of limitation, NCI shall have no right of accounting or right
 * of payment from You or Your sub-licensees for the rights granted under this
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the
 * above copyright notice, this list of conditions and the disclaimer and
 * limitation of liability of Article 6, below. Your redistributions in object
 * code form must reproduce the above copyright notice, this list of conditions
 * and the disclaimer of Article 6 in the documentation and/or other materials
 * provided with the distribution, if any.
 *
 * Your end-user documentation included with the redistribution, if any, must
 * include the following acknowledgment: This product includes software
 * developed by 5AM and the National Cancer Institute. If You do not include
 * such end-user documentation, You shall include this acknowledgment in the
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "5AM"
 * to endorse or promote products derived from this Software. This License does
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or 5AM, except as required to comply with the
 * terms of this License.
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this
 * Software into Your proprietary programs and into any third party proprietary
 * programs. However, if You incorporate the Software into third party
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software
 * into such third party proprietary programs and for informing Your
 * sub-licensees, including without limitation Your end-users, of their
 * obligation to secure any required permissions from such third parties before
 * incorporating the Software into such third party proprietary software
 * programs. In the event that You fail to obtain such permissions, You agree
 * to indemnify NCI for any claims against NCI by such third parties, except to
 * the extent prohibited by law, resulting from Your failure to obtain such
 * permissions.
 *
 * For sake of clarity, and not by way of limitation, You may add Your own
 * copyright statement to Your modifications and to the derivative works, and
 * You may provide additional or different license terms and conditions in Your
 * sublicenses of modifications of the Software, or any derivative works of the
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, 5AM SOLUTIONS, INC. OR THEIR
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.protexpress.ui.actions.registration;

import static gov.nih.nci.protexpress.ProtExpressRegistry.getRegistrationService;
import static gov.nih.nci.protexpress.ProtExpressRegistry.getUserProvisioningManager;
import gov.nih.nci.protexpress.domain.ConfigParamEnum;
import gov.nih.nci.protexpress.domain.register.Country;
import gov.nih.nci.protexpress.domain.register.RegistrationRequest;
import gov.nih.nci.protexpress.domain.register.State;
import gov.nih.nci.protexpress.util.ConfigurationHelper;
import gov.nih.nci.security.authentication.helper.LDAPHelper;
import gov.nih.nci.security.authorization.domainobjects.User;
import gov.nih.nci.security.dao.UserSearchCriteria;
import gov.nih.nci.security.exceptions.internal.CSInternalConfigurationException;
import gov.nih.nci.security.exceptions.internal.CSInternalInsufficientAttributesException;
import gov.nih.nci.security.exceptions.internal.CSInternalLoginException;

import java.util.List;

import javax.mail.MessagingException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.fiveamsolutions.nci.commons.web.struts2.action.ActionHelper;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
/**
 * Registration action.  Handles saving and email sending.
 */
// CSM requires Hashtable, servletcontext untyped
@SuppressWarnings({ "PMD.ReplaceHashtableWithMap", "unchecked", "PMD.CyclomaticComplexity" })
@Validation
public class RegistrationAction extends ActionSupport implements Preparable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RegistrationAction.class);

    private RegistrationRequest registrationRequest;
    private String password;
    private String passwordConfirm;
    private Boolean ldapAuthenticate;
    private List<Country> countryList;
    private List<State> stateList;
    private String successMessage;

    /**
     * {@inheritDoc}
     */
    public void prepare() {
        setCountryList(getRegistrationService().getCountries());
        setStateList(getRegistrationService().getStates());
        registrationRequest = new RegistrationRequest();
        ldapAuthenticate = Boolean.TRUE;
    }

    /**
     * Action to actually save the registration with authentication.
     * @return the directive for the next action / page to be directed to
     */
    public String save() {
        try {
            // We call the service to save, then send email.  This is non-transactional behavior,
            // but it's okay in this case.  The request gets logged to our db, but if email doesn't
            // send, we tell the user to retry.  (We don't send email in service because Email helper
            // makes assumptions about the environment that are inappropriate for the service tier.)
            getRegistrationService().register(getRegistrationRequest());
            LOGGER.debug("done saving registration request; sending email");
            EmailHelper.registerEmail(getRegistrationRequest());
            EmailHelper.registerEmailAdmin(getRegistrationRequest());
            setSuccessMessage(ConfigurationHelper.getConfigurationStringValue(
                    ConfigParamEnum.REGISTRATION_SUCCESS_MESSAGE));
            return Action.SUCCESS;
        } catch (MessagingException me) {
            LOGGER.error("Failed to send an email", me);
            ActionHelper.saveMessage(getText("registration.emailFailure"));
            addActionError(getText("registration.emailFailure"));
            return Action.INPUT;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() {
        super.validate();
        if (ConfigurationHelper.isLdapInstallation()) {
            validateLdap();
        } else {
            validateNonLdap();
        }
    }

    private void validateLdap() {
        try {
            if (ldapAuthenticate
                    && (StringUtils.isBlank(getPassword())
                            || !LDAPHelper.authenticate(ConfigurationHelper.getLdapContextParameters() ,
                                    registrationRequest.getLoginName(),
                                                        getPassword().toCharArray(), null))) {
                addActionError(getText("registration.ldapLookupFailure"));
            }
        } catch (CSInternalLoginException e) {
            // CSM throws this exception on valid user / wrong pass
            addActionError(getText("registration.ldapLookupFailure"));
        } catch (CSInternalConfigurationException e) {
            addActionError(e.getMessage());
            LOGGER.error("Unable to validate", e);
        } catch (CSInternalInsufficientAttributesException e) {
            addActionError(e.getMessage());
            LOGGER.error("Unable to validate", e);
        }
    }

    private void validateNonLdap() {
        if (StringUtils.isNotBlank(getRegistrationRequest().getLoginName())
                && (getUserProvisioningManager()
                                .getUser(getRegistrationRequest().getLoginName()) != null)) {
            addActionError(getText("registration.usernameInUse"));
        }
        if (StringUtils.isNotBlank(getRegistrationRequest().getEmail())) {
            User searchUser = new User();
            searchUser.setEmailId(getRegistrationRequest().getEmail());
            if (!getUserProvisioningManager()
                             .getObjects(new UserSearchCriteria(searchUser)).isEmpty()) {
                addActionError(getText("registration.emailAddressInUse"));
            }
        }
    }

    /*
     *
     * Getters / setters below here
     *
     */

    /**
     * @return the user
     */
    @CustomValidator(type = "hibernate")
    public RegistrationRequest getRegistrationRequest() {
        return this.registrationRequest;
    }

    /**
     * @param registrationRequest the request to set
     */
    public void setRegistrationRequest(RegistrationRequest registrationRequest) {
        this.registrationRequest = registrationRequest;
    }

    /**
     * @return the countryList
     */
    public List<Country> getCountryList() {
        return countryList;
    }

    /**
     * @param countryList the countryList to set
     */
    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    /**
     * @return the stateList
     */
    public List<State> getStateList() {
        return stateList;
    }

    /**
     * @param stateList the stateList to set
     */
    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the passwordConfirmation
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * @param passwordConfirm the passwordConfirmation to set
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * @return the ldapAuthenticate
     */
    public Boolean getLdapAuthenticate() {
        return ldapAuthenticate;
    }

    /**
     * @param ldapAuthenticate the ldapAuthenticate to set
     */
    public void setLdapAuthenticate(Boolean ldapAuthenticate) {
        this.ldapAuthenticate = ldapAuthenticate;
    }

    /**
     * @return the successMessage
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * @param successMessage the successMessage to set
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    /**
     * @return is ldap install?
     */
    public boolean isLdapInstall() {
        return ConfigurationHelper.isLdapInstallation();
    }
}

