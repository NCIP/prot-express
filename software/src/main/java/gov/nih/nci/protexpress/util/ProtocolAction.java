/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class to maintain the protocol action hierarchy.
 *
 * @author Krishna Kanchinadam
 */

public final class ProtocolAction {

    private int actionSequenceNumber = 0;
    private ProtocolApplication protocolApplication = null;
    private List<Integer> predecessorActionNumbers = new ArrayList<Integer>();

    /**
     * Default constructor.
     * @param protocolApplication the protocol application.
     * @param actionSequenceNumber the action sequence number.
     */
    public ProtocolAction(ProtocolApplication protocolApplication, int actionSequenceNumber) {
        this.protocolApplication = protocolApplication;
        this.actionSequenceNumber = actionSequenceNumber;
    }

    /**
     * Gets the actionSequenceNumber.
     *
     * @return the actionSequenceNumber.
     */
    public int getActionSequenceNumber() {
        return actionSequenceNumber;
    }

    /**
     * Sets the actionSequenceNumber.
     *
     * @param actionSequenceNumber the actionSequenceNumber to set.
     */
    public void setActionSequenceNumber(int actionSequenceNumber) {
        this.actionSequenceNumber = actionSequenceNumber;
    }

    /**
     * Gets the protocolApplication.
     *
     * @return the protocolApplication.
     */
    public ProtocolApplication getProtocolApplication() {
        return protocolApplication;
    }

    /**
     * Sets the protocolApplication.
     *
     * @param protocolApplication the protocolApplication to set.
     */
    public void setProtocolApplication(ProtocolApplication protocolApplication) {
        this.protocolApplication = protocolApplication;
    }

    /**
     * Gets the predecessorActionNumbers.
     *
     * @return the predecessorActionNumbers.
     */
    public List<Integer> getPredecessorActionNumbers() {
        return predecessorActionNumbers;
    }

    /**
     * Sets the predecessorActionNumbers.
     *
     * @param predecessorActionNumbers the predecessorActionNumbers to set.
     */
    public void setPredecessorActionNumbers(List<Integer> predecessorActionNumbers) {
        this.predecessorActionNumbers = predecessorActionNumbers;
    }
}