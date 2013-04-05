/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;



/**
 * Class that holds experiment, protocol, input and output information in session, during the Create Experiment process.
 *
 * @author Krishna Kanchinadam
 */

public final class SessionHelper {
    private static final String SESSION_EXPERIMENT_ID = "sessionExperimentId";
    private static final String SESSION_PROTOCOL_APPLICATION = "sessionProtocolApplication";

    /**
     * Default constructor.
     *
     */
    private SessionHelper() {
    }

    /**
     * Gets the Experiment Id from Session.
     *
     * @return the experiment id stored in session.
     */
    public static Long getExperimentIdFromSession() {
        return (Long) retrieveFromSession(getSessionExperimentIdKey());
    }

    /**
     * Save Experiment Id in session.
     *
     * @param experimentId the experiment id.
     */
    public static void saveExperimentIdInSession(Long experimentId) {
        saveInSession(getSessionExperimentIdKey(), experimentId);
    }

    /**
     * Remove Experiment Id from session.
     */
    public static void removeExperimentIdFromSession() {
        removeFromSession(getSessionExperimentIdKey());
    }

    /**
     * Gets the Protocol Application from Session.
     *
     * @return the protocol application object stored in session.
     */
    public static ProtocolApplication getProtocolApplicationFromSession() {
        return (ProtocolApplication) retrieveFromSession(getSessionProtocolApplicationKey());
    }

    /**
     * Save Protocol Application in Session.
     *
     * @param protocolApplication the protocol application object.
     */
    public static void saveProtocolApplicationInSession(ProtocolApplication protocolApplication) {
        saveInSession(getSessionProtocolApplicationKey(), protocolApplication);
    }

    /**
     * Removes the Protocol Application from Session.
     */
    public static void removeProtocolApplicationFromSession() {
        removeFromSession(getSessionProtocolApplicationKey());
    }

    /**
     * Removes Experiment and Protocol Information from session.
     */
    public static void removeExperimentAndProtocolInformationFromSession() {
        removeExperimentIdFromSession();
        removeProtocolApplicationFromSession();
    }

    /**
     * Retrieves the object stored in session..
     *
     * @param sessionKey the key for which value is to be retreived.
     * @return the value corresponding to the key or null.
     */
    private static Object retrieveFromSession(String sessionKey) {
        Object returnObject = null;
        Map session = ActionContext.getContext().getSession();
        if ((session != null) && (session.get(sessionKey) != null)) {
            returnObject = session.get(sessionKey);
        }
        return returnObject;
    }

    /**
     * Saves the specified value in session.
     *
     * @param sessionKey the key.
     * @param sessionValue the value to be saved.
     */
    private static void saveInSession(String sessionKey, Object sessionValue) {
        Map session = ActionContext.getContext().getSession();
        if (session != null) {
            removeFromSession(sessionKey);
            session.put(sessionKey, sessionValue);
        }
    }

    /**
     * Removes the specified value in session.
     *
     * @param sessionKey the key.
     *
     */
    private static void removeFromSession(String sessionKey) {
        Map session = ActionContext.getContext().getSession();
        if ((session != null)) {
            session.remove(sessionKey);
        }
    }

    /**
     * Gets the sessionExperimentId.
     *
     * @return the sessionExperimentId.
     */
    private static String getSessionExperimentIdKey() {
        return SESSION_EXPERIMENT_ID;
    }

    /**
     * Gets the sessionProtocolApplication.
     *
     * @return the sessionProtocolApplication.
     */
    private static String getSessionProtocolApplicationKey() {
        return SESSION_PROTOCOL_APPLICATION;
    }

}