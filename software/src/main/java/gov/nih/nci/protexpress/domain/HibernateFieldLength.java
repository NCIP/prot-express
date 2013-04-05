/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain;

/**
 * @author Krishna Kanchinadam
 *
 */
@SuppressWarnings("PMD")
public final class HibernateFieldLength {
    /**
     * Field Length for Audit Creator.
     */
    public static final int AUDIT_CREATOR_LENGTH = 100;

    /**
     * Field Length for Experiment Name.
     */
    public static final int EXPERIMENT_NAME_LENGTH = 200;
    /**
     * Field Length for Experiment Description.
     */
    public static final int EXPERIMENT_DESCRIPTION_LENGTH = 2000;
    /**
     * Field Length for Experiment Hypothesis.
     */
    public static final int EXPERIMENT_HYPOTHESIS_LENGTH = 500;
    /**
     * Field Length for Experiment URL.
     */
    public static final int EXPERIMENT_URL_LENGTH = 200;

    /**
     * Field Length for Experiment Notes field.
     */
    public static final int EXPERIMENT_NOTES_LENGTH = 2000;

    /**
     * Field Length for Experiment Run Name.
     */
    public static final int EXPRUN_NAME_LENGTH = 50;
    /**
     * Field Length for Experiment Run Comments.
     */
    public static final int EXPRUN_NOTES_LENGTH = 2000;

    /**
     * Field Length for Input Output Object Name.
     */
    public static final int IO_NAME_LENGTH = 200;
    /**
     * Field Length for Input Output Object Data File Name.
     */
    public static final int IO_DATA_FILE_URL_LENGTH = 200;
    /**
     * Field Length for Input Output Object Additional information field.
     */
    public static final int IO_NOTES_LENGTH = 2000;

    /**
     * Field Length for Protocol Name.
     */
    public static final int PROTOCOL_NAME_LENGTH = 200;
    /**
     * Field Length for Protocol Description.
     */
    public static final int PROTOCOL_DESCRIPTION_LENGTH = 2000;
    /**
     * Field Length for Protocol Software field.
     */
    public static final int PROTOCOL_SOFTWARE_LENGTH = 200;
    /**
     * Field Length for Protocol Instrument field.
     */
    public static final int PROTOCOL_INSTRUMENT_LENGTH = 200;
    /**
     * Field Length for Protocol Notes field.
     */
    public static final int PROTOCOL_NOTES_LENGTH = 2000;

    /**
     * Field Length for Protocol Application Name.
     */
    public static final int PROTAPP_NAME_LENGTH = 200;
    /**
     * Field Length for Protocol Application Comments.
     */
    public static final int PROTAPP_COMMENTS_LENGTH = 2000;
    /**
     * Field Length for Protocol Application Additional Information Field.
     */
    public static final int PROTAPP_NOTES_LENGTH = 2000;
    /**
     * Field Length for Contact Person First Name.
     */
    public static final int CONTACT_PERSON_FIRST_NAME = 100;
    /**
     * Field Length for Contact Person Last Name.
     */
    public static final int CONTACT_PERSON_LAST_NAME = 100;
    /**
     * Field Length for Contact Person Email.
     */
    public static final int CONTACT_PERSON_EMAIL_LENGTH = 100;
    /**
     * Field Length for Contact Person Notes.
     */
    public static final int CONTACT_PERSON_NOTES_LENGTH = 2000;


    /**
     * Private Constructor.
     */
    private HibernateFieldLength() {

    }

    /**
     * Static method for returning a string representation of the integer values.
     * @param intValue the integer value to be converted to String.
     * @return the String value.
     */
    public static String getStringValue(int intValue) {
        return intValue + "";
    }
}
