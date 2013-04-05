/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain;

/**
 * Various configuration parameters.
 */
public enum ConfigParamEnum {
    /**
     * System Admin email id.
     */
    SYS_ADMIN_EMAIL,
    /**
     * Registration Email subject line.
     */
    REGISTRATION_EMAIL_SUBJECT,
    /**
     * Registration Email Body Content, sent to the new user.
     */
    REGISTRATION_EMAIL_TO_USER_BODY_CONTENT,
    /**
     * Registration success message.
     */
    REGISTRATION_SUCCESS_MESSAGE,
    /**
     * Forgot Password Email Subject Line.
     */
    FORGOT_PASSWORD_EMAIL_SUBJECT,
    /**
     * Forgot Password Email Body Content, sent to the user.
     */
    FORGOT_PASSWORD_EMAIL_TO_USER_BODY_CONTENT,
    /**
     * Forgot Password Success Message.
     */
    FORGOT_PASSWORD_SUCCESS_MESSAGE,
    /**
     * Development mode flag.  Should only be true for local development purposes.
     */
    DEVELOPMENT_MODE,
    /**
     * protExpress version number, for schema migration purposes.
     */
    SCHEMA_VERSION,
    /**
     * Lsid Base.
     */
    LSID_BASE,
    /**
     * Lsid Separator.
     */
    LSID_SEPARATOR,
    /**
     * Lsid Authority.
     */
    LSID_AUTHORITY,
    /**
     * Lsid Revision.
     */
    LSID_REVISION,
    /**
     * Lsid Protocol Namespace.
     */
    LSID_NAMESPACE_PROTOCOL,
    /**
     * Lsid Experiment Namespace.
     */
    LSID_NAMESPACE_EXPERIMENT,
    /**
     * Lsid ExperimentRun Namespace.
     */
    LSID_NAMESPACE_EXPERIMENT_RUN,
    /**
     * Lsid InputOutput Namespace.
     */
    LSID_NAMESPACE_INPUT_OUTPUT,
    /**
     * Lsid ProtocolApplication Namespace.
     */
    LSID_NAMESPACE_PROTOCOL_APPLICATION,
    /**
     * Ontology Entry URI String value.
     */
    ONTOLOGY_ENTRY_URI;
}











































