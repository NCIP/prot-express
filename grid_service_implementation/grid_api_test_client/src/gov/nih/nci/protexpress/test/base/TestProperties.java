/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test.base;

/**
 * Environment properties passed in to tests.
 */
public final class TestProperties {

    public static final String SERVER_HOSTNAME_KEY = "server.hostname";
    public static final String SERVER_PORT_KEY = "server.port";
    public static final String GRID_SERVER_HOSTNAME_KEY = "grid.server.hostname";
    public static final String GRID_SERVER_PORT_KEY = "grid.server.port";

    public static final String SERVER_HOSTNAME_DEFAULT = "protexpress.nci.nih.gov";
    public static final String SERVER_PORT_DEFAULT = "28080";
    public static final String GRID_SERVER_HOSTNAME_DEFAULT = "protexpress.nci.nih.gov";
    public static final String GRID_SERVER_PORT_DEFAULT = "28080";
    public static final String GRID_SERVICE_PROTOCOL = "http";
    public static final String GRID_SERVICE_URL = "/wsrf/services/cagrid/ProtExpressGridService";

    // Object Ids used in API tests
    public static final String EXPERIMENT_ID_KEY = "experiment.id";
    public static final String EXPERIMENT_RUN_ID_KEY = "experimentrun.id";
    public static final String PROTOCOL_ID_KEY = "protocol.id";
    public static final String PROTOCOL_APPLICATION_ID_KEY = "protocolapplication.id";
    public static final String INPUT_OUTPUT_ID_KEY = "inputoutput.id";
    public static final String CONTACT_PERSON_ID_KEY = "contactperson.id";

    public static final String EXPERIMENT_ID = "1";
    public static final String EXPERIMENT_RUN_ID = "4";
    public static final String PROTOCOL_ID = "7";
    public static final String PROTOCOL_APPLICATION_ID = "18";
    public static final String INPUT_OUTPUT_ID = "34";
    public static final String CONTACT_PERSON_ID = "69";

    public static String getServerHostname() {
        return System.getProperty(SERVER_HOSTNAME_KEY, SERVER_HOSTNAME_DEFAULT);
    }

    public static int getServerPort() {
        return Integer.parseInt(System.getProperty(SERVER_PORT_KEY, SERVER_PORT_DEFAULT));
    }

    public static String getGridServerHostname() {
        return System.getProperty(GRID_SERVER_HOSTNAME_KEY, GRID_SERVER_HOSTNAME_DEFAULT);
    }

    public static int getGridServerPort() {
        return Integer.parseInt(System.getProperty(GRID_SERVER_PORT_KEY, GRID_SERVER_PORT_DEFAULT));
    }

    public static String getGridServiceUrl() {
        return (GRID_SERVICE_PROTOCOL + "://" + getGridServerHostname() + ":" + getGridServerPort() + GRID_SERVICE_URL);
    }

    public static String getExperimentId() {
        return System.getProperty(EXPERIMENT_ID_KEY, EXPERIMENT_ID);
    }

    public static String getExperimentRunId() {
        return System.getProperty(EXPERIMENT_RUN_ID_KEY, EXPERIMENT_RUN_ID);
    }

    public static String getProtocolId() {
        return System.getProperty(PROTOCOL_ID_KEY, PROTOCOL_ID);
    }

    public static String getProtocolApplicationId() {
        return System.getProperty(PROTOCOL_APPLICATION_ID_KEY, PROTOCOL_APPLICATION_ID);
    }

    public static String getInputOutputObjectId() {
        return System.getProperty(INPUT_OUTPUT_ID_KEY, INPUT_OUTPUT_ID);
    }

    public static String getContactPersonId() {
        return System.getProperty(CONTACT_PERSON_ID_KEY, CONTACT_PERSON_ID);
    }
}
