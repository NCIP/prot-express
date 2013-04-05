/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.registration;

import gov.nih.nci.protexpress.domain.ConfigParamEnum;
import gov.nih.nci.protexpress.domain.register.RegistrationRequest;
import gov.nih.nci.protexpress.util.ConfigurationHelper;

import java.text.MessageFormat;
import java.util.Collections;

import javax.mail.MessagingException;

/**
 * @author John Hedden (Amentra, Inc.)
 *
 */
public final class EmailHelper {

    private EmailHelper() {
        // nothing here.
    }

    /**
     * Sends the password request to user.
     *
     * @param userEmailId the user email id.
     * @throws MessagingException on other error
     */
    public static void sendPasswordRequestConfirmationEmailToUser(String userEmailId) throws MessagingException {
        String from = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.SYS_ADMIN_EMAIL);
        String subject = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.FORGOT_PASSWORD_EMAIL_SUBJECT);
        String mailBody = ConfigurationHelper.getConfigurationStringValue(
                ConfigParamEnum.FORGOT_PASSWORD_EMAIL_TO_USER_BODY_CONTENT);

        EmailUtil.sendMail(Collections.singletonList(userEmailId), from, subject, mailBody);
    }

    /**
     * Sends the password request to admin.
     *
     * @param loginName login name of the user.
     * @param emailId user email id.
     * @throws MessagingException on other error
     */
    public static void sendPasswordRequestEmailToAdmin(String loginName, String emailId) throws MessagingException {
         String subject = ConfigurationHelper.getConfigurationStringValue(
                 ConfigParamEnum.FORGOT_PASSWORD_EMAIL_SUBJECT);
         String admin = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.SYS_ADMIN_EMAIL);

         String mailBody = "Password Reset Request:\n"
             + "Login Name: " + loginName + "\n";

         EmailUtil.sendMail(Collections.singletonList(admin), emailId, subject, mailBody);
    }

    /**
     * @param registrationRequest request
     * @throws MessagingException on other error
     */
    public static void registerEmail(RegistrationRequest registrationRequest) throws MessagingException {
        String from = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.SYS_ADMIN_EMAIL);
        String subject = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.REGISTRATION_EMAIL_SUBJECT);
        String mailBodyPattern = ConfigurationHelper.getConfigurationStringValue(
                ConfigParamEnum.REGISTRATION_EMAIL_TO_USER_BODY_CONTENT);
        String mailBody = MessageFormat.format(mailBodyPattern, registrationRequest.getId());

        EmailUtil.sendMail(Collections.singletonList(registrationRequest.getEmail()), from, subject, mailBody);
    }

    /**
     * @param registrationRequest request
     * @throws MessagingException on error
     */
    public static void registerEmailAdmin(RegistrationRequest registrationRequest) throws MessagingException {
        String from = registrationRequest.getEmail();
        String subject = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.REGISTRATION_EMAIL_SUBJECT);
        String admin = ConfigurationHelper.getConfigurationStringValue(ConfigParamEnum.SYS_ADMIN_EMAIL);

        String mailBody = "Registration Request:\n"
            + "First Name: " + registrationRequest.getFirstName() + "\n"
            + "Middle Initial: " + registrationRequest.getMiddleInitial() + "\n"
            + "Last Name: " + registrationRequest.getLastName() + "\n"
            + "Email: " + registrationRequest.getEmail() + "\n"
            + "Phone: " + registrationRequest.getPhone() + "\n"
            + "Fax: " + registrationRequest.getFax() + "\n"
            + "Organization: " + registrationRequest.getOrganization() + "\n"
            + "Address1: " + registrationRequest.getAddress1() + "\n"
            + "Address2: " + registrationRequest.getAddress2() + "\n"
            +  "City: " + registrationRequest.getCity() + "\n"
            + "State: " + ((registrationRequest.getState() != null)? registrationRequest.getState().getName() : "")
                + "\n"
            + "Province: " + registrationRequest.getProvince() + "\n"
            + "Country: " + registrationRequest.getCountry().getPrintableName() + "\n"
            + "Zip: " + registrationRequest.getZip() + "\n"
            + "Role: " + registrationRequest.getRole();

        EmailUtil.sendMail(Collections.singletonList(admin), from, subject, mailBody);
    }

}
