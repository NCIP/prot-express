/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.util.HashMap;

/**
 * Helper class to maintain the Experiment Run, Protocol Application and Action
 * Set information.
 *
 * @author Krishna Kanchinadam
 */
public final class ExperimentRunHolder {

    private ExperimentRun experimentRun;
    private Protocol startProtocol;
    private Protocol endProtocol;
    private String startProtocolLsidString;
    private String endProtocolLsidString;

    private ProtocolApplication startProtocolApplication;
    private ProtocolApplication endProtocolApplication;
    private String startProtocolApplicationLsidString;
    private String endProtocolApplicationLsidString;

    private HashMap<Integer, ProtocolAction> protocolActionSequenceNumberMap = new HashMap<Integer, ProtocolAction>();
    private HashMap<Long, ProtocolAction> protocolApplicationIdMap = new HashMap<Long, ProtocolAction>();

    private final Integer initialActionSequenceNumber = 1;
    private final Integer incrementActionSequence = 5;
    private Integer currentSequenceNumber = 1;

    private ProtocolAction startProtocolAction;
    private ProtocolAction endProtocolAction;

    /**
     * Default constructor.
     *
     * @param experimentRun
     *            the experiment run.
     */
    public ExperimentRunHolder(ExperimentRun experimentRun) {
        this.experimentRun = experimentRun;
        this.initStartAndEndProtocolsAndApplications();
        this.initProtocolActions();
    }

    private void initStartAndEndProtocolsAndApplications() {
        initStartProtocolAndApplication();
        initEndProtocolAndApplication();
    }

    private void initStartProtocolAndApplication() {
        String lsidString = "ExperimentRun." + getExperimentRun().getId().toString() + ".StartProtocol";
        setStartProtocolLsidString(lsidString);

        startProtocol = new Protocol(getStartProtocolLsidString());
        startProtocol.setDescription("This protocol is the 'parent' protocol of the experiment run.");

        lsidString = "ExperimentRun." + getExperimentRun().getId().toString() + ".StartProtocolApplication";
        startProtocolApplication = new ProtocolApplication(
                getExperimentRun().getDatePerformed(), getExperimentRun(), startProtocol);
        setStartProtocolApplicationLsidString(lsidString);

        // set starting inputs for the start protocol application.
        for (ProtocolApplication protApp : getExperimentRun().getProtocolApplications()) {
            for (InputOutputObject input : protApp.getInputs()) {
                if (input.getOutputOfProtocolApplication() == null) {
                    startProtocolApplication.getInputs().add(input);
                }
            }
        }
    }

    private void initEndProtocolAndApplication() {
        String lsidString = "ExperimentRun." + getExperimentRun().getId().toString() + ".EndProtocol";
        setEndProtocolLsidString(lsidString);

        endProtocol = new Protocol(getEndProtocolLsidString());
        String description = "Mark the output data or materials for the experiment run.  "
                + "Any and all inputs to an application of this type are considered outputs of the experiment run.";
        endProtocol.setDescription(description);

        lsidString = "ExperimentRun." + getExperimentRun().getId().toString() + ".EndProtocolApplication";
        endProtocolApplication = new ProtocolApplication(
                getExperimentRun().getDatePerformed(), getExperimentRun(), endProtocol);
        setEndProtocolApplicationLsidString(lsidString);

     // set final outputs for the end protocol application.
        for (ProtocolApplication protApp : getExperimentRun().getProtocolApplications()) {
            for (InputOutputObject output : protApp.getOutputs()) {
                if (output.getInputToProtocolApplication() == null) {
                    endProtocolApplication.getInputs().add(output);
                }
            }
        }
    }

    /**
     * Initializes the protocolActions.
     */
    private void initProtocolActions() {
        this.initStartProtocolAction();
        // Determine the protocol actions.
        setCurrentSequenceNumber(getInitialActionSequenceNumber());
        for (ProtocolApplication protocolApplication : getExperimentRun().getProtocolApplications()) {
            initProtocolAction(protocolApplication, getCurrentSequenceNumber());
        }
        this.initEndProtocolAction();

        // By now, all protocol actions (type=protocol application) should have been setup properly.
        // Determine Predecessor actions.
        for (ProtocolAction protAction : getProtocolActionSequenceNumberMap().values()) {
            boolean includeStartPredecessor = false;
            for (InputOutputObject input : protAction.getProtocolApplication().getInputs()) {
                if (input.getOutputOfProtocolApplication() != null) {
                    ProtocolAction predecessorAction = getProtocolActionFromProtocolApplicationIdMap(
                            input.getOutputOfProtocolApplication().getId());
                    Integer predecessorActionNum = predecessorAction.getActionSequenceNumber();
                    if (!protAction.getPredecessorActionNumbers().contains(predecessorActionNum)) {
                        protAction.getPredecessorActionNumbers().add(predecessorActionNum);
                    }
                } else {
                    includeStartPredecessor = true;
                }
            }
            // If at least one starting input, have the start protocol action as a predecessor.
            if (includeStartPredecessor) {
                protAction.getPredecessorActionNumbers().add(getInitialActionSequenceNumber());
            }
        }
    }

    private void initStartProtocolAction() {
        ProtocolApplication protApp = new ProtocolApplication(
                getExperimentRun().getDatePerformed(), getExperimentRun(), getStartProtocol());
        startProtocolAction = new ProtocolAction(protApp, getInitialActionSequenceNumber());
        startProtocolAction.getPredecessorActionNumbers().add(getInitialActionSequenceNumber());
    }

    private void initEndProtocolAction() {
        ProtocolApplication protApp = new ProtocolApplication(
                getExperimentRun().getDatePerformed(), getExperimentRun(), getEndProtocol());
        endProtocolAction = new ProtocolAction(protApp, getCurrentSequenceNumber() + getIncrementActionSequence());
        // All prot apps with "orphan" outputs are predecessors to this one.
        for (ProtocolAction protAction : getProtocolActionSequenceNumberMap().values()) {
            for (InputOutputObject output : protAction.getProtocolApplication().getOutputs()) {
                if (output.getInputToProtocolApplication() == null) {
                    ProtocolAction predecessorAction = getProtocolActionFromProtocolApplicationIdMap(
                            output.getOutputOfProtocolApplication().getId());
                    Integer predecessorActionNum = predecessorAction.getActionSequenceNumber();
                    if (!endProtocolAction.getPredecessorActionNumbers().contains(predecessorActionNum)) {
                        endProtocolAction.getPredecessorActionNumbers().add(predecessorActionNum);
                    }
                }
            }
        }
        // If no "orphan" outputs, then list all protocols with no outputs as predecessors.
        // This will ensure that the end protocol action has at least one predecessor (start protocol).
        // and avoid an error with parsing the xar file when importing to cpas.
        if (endProtocolAction.getPredecessorActionNumbers().size() == 0) {
            for (ProtocolAction protAction : getProtocolActionSequenceNumberMap().values()) {
                if (protAction.getProtocolApplication().getOutputs().size() == 0) {
                    endProtocolAction.getPredecessorActionNumbers().add(protAction.getActionSequenceNumber());
                }
            }
            if (startProtocolAction.getProtocolApplication().getOutputs().size() == 0) {
                endProtocolAction.getPredecessorActionNumbers().add(startProtocolAction.getActionSequenceNumber());
            }
        }
    }

    private void initProtocolAction(ProtocolApplication protocolApplication, int parentSequenceNumber) {
        if (!getProtocolApplicationIdMap().containsKey(protocolApplication.getId())) {
            // check for parents. if a parent not processed, return.
            for (InputOutputObject input : protocolApplication.getInputs()) {
                if ((input.getOutputOfProtocolApplication() != null)
                        &&
                        (!getProtocolApplicationIdMap().containsKey(input.getOutputOfProtocolApplication().getId()))) {
                    return;
                }
            }

            setCurrentSequenceNumber(parentSequenceNumber + getIncrementActionSequence());
            ProtocolAction protAction = new ProtocolAction(protocolApplication,  getCurrentSequenceNumber());

            // Setup the maps.
            addToProtocolActionSequenceNumberMap(getCurrentSequenceNumber(), protAction);
            addToProtocolApplicationIdMap(protocolApplication.getId(), protAction);

            // Recurse through the child protocols.
            for (InputOutputObject output : protocolApplication.getOutputs()) {
                if (output.getInputToProtocolApplication() != null) {
                    initProtocolAction(output.getInputToProtocolApplication(), getCurrentSequenceNumber());
                }
            }
        }
    }

    private void addToProtocolActionSequenceNumberMap(Integer actionSequenceNumber, ProtocolAction protAction) {
            getProtocolActionSequenceNumberMap().put(actionSequenceNumber, protAction);
    }

    private void addToProtocolApplicationIdMap(Long protAppId, ProtocolAction protAction) {
            getProtocolApplicationIdMap().put(protAppId, protAction);
    }

    private ProtocolAction getProtocolActionFromProtocolApplicationIdMap(Long protAppId) {
        return getProtocolApplicationIdMap().get(protAppId);
    }

    /**
     * Gets the startProtocolAction.
     *
     * @return the startProtocolAction.
     */
    public ProtocolAction getStartProtocolAction() {
        return startProtocolAction;
    }

    /**
     * Sets the startProtocolAction.
     *
     * @param startProtocolAction
     *            the startProtocolAction to set.
     */
    public void setStartProtocolAction(ProtocolAction startProtocolAction) {
        this.startProtocolAction = startProtocolAction;
    }

    /**
     * Gets the endProtocolAction.
     *
     * @return the endProtocolAction.
     */
    public ProtocolAction getEndProtocolAction() {
        return endProtocolAction;
    }

    /**
     * Sets the endProtocolAction.
     *
     * @param endProtocolAction
     *            the endProtocolAction to set.
     */
    public void setEndProtocolAction(ProtocolAction endProtocolAction) {
        this.endProtocolAction = endProtocolAction;
    }

    /**
     * Gets the experimentRun.
     *
     * @return the experimentRun.
     */
    public ExperimentRun getExperimentRun() {
        return experimentRun;
    }

    /**
     * Sets the experimentRun.
     *
     * @param experimentRun
     *            the experimentRun to set.
     */
    public void setExperimentRun(ExperimentRun experimentRun) {
        this.experimentRun = experimentRun;
    }

    /**
     * Gets the startProtocol.
     *
     * @return the startProtocol.
     */
    public Protocol getStartProtocol() {
        return startProtocol;
    }

    /**
     * Sets the startProtocol.
     *
     * @param startProtocol
     *            the startProtocol to set.
     */
    public void setStartProtocol(Protocol startProtocol) {
        this.startProtocol = startProtocol;
    }

    /**
     * Gets the endProtocol.
     *
     * @return the endProtocol.
     */
    public Protocol getEndProtocol() {
        return endProtocol;
    }

    /**
     * Sets the endProtocol.
     *
     * @param endProtocol
     *            the endProtocol to set.
     */
    public void setEndProtocol(Protocol endProtocol) {
        this.endProtocol = endProtocol;
    }

    /**
     * Gets the initialActionSequenceNumber.
     *
     * @return the initialActionSequenceNumber.
     */
    public Integer getInitialActionSequenceNumber() {
        return initialActionSequenceNumber;
    }

    /**
     * Gets the incrementActionSequence.
     *
     * @return the incrementActionSequence.
     */
    public Integer getIncrementActionSequence() {
        return incrementActionSequence;
    }

    /**
     * Gets the currentSequenceNumber.
     *
     * @return the currentSequenceNumber.
     */
    public Integer getCurrentSequenceNumber() {
        return currentSequenceNumber;
    }

    /**
     * Sets the currentSequenceNumber.
     *
     * @param currentSequenceNumber
     *            the currentSequenceNumber to set.
     */
    public void setCurrentSequenceNumber(Integer currentSequenceNumber) {
        this.currentSequenceNumber = currentSequenceNumber;
    }

    /**
     * Gets the protocolActionSequenceNumberMap.
     *
     * @return the protocolActionSequenceNumberMap.
     */
    public HashMap<Integer, ProtocolAction> getProtocolActionSequenceNumberMap() {
        return protocolActionSequenceNumberMap;
    }

    /**
     * Sets the protocolActionSequenceNumberMap.
     *
     * @param protocolActionSequenceNumberMap the protocolActionSequenceNumberMap to set.
     */
    public void setProtocolActionSequenceNumberMap(
            HashMap<Integer, ProtocolAction> protocolActionSequenceNumberMap) {
        this.protocolActionSequenceNumberMap = protocolActionSequenceNumberMap;
    }

    /**
     * Gets the protocolApplicationIdMap.
     *
     * @return the protocolApplicationIdMap.
     */
    public HashMap<Long, ProtocolAction> getProtocolApplicationIdMap() {
        return protocolApplicationIdMap;
    }

    /**
     * Sets the protocolApplicationIdMap.
     *
     * @param protocolApplicationIdMap the protocolApplicationIdMap to set.
     */
    public void setProtocolApplicationIdMap(
            HashMap<Long, ProtocolAction> protocolApplicationIdMap) {
        this.protocolApplicationIdMap = protocolApplicationIdMap;
    }

    /**
     * Gets the startProtocolLsidString.
     *
     * @return the startProtocolLsidString.
     */
    public String getStartProtocolLsidString() {
        return startProtocolLsidString;
    }

    /**
     * Sets the startProtocolLsidString.
     *
     * @param startProtocolLsidString
     *            the startProtocolLsidString to set.
     */
    public void setStartProtocolLsidString(String startProtocolLsidString) {
        this.startProtocolLsidString = startProtocolLsidString;
    }

    /**
     * Gets the endProtocolLsidString.
     *
     * @return the endProtocolLsidString.
     */
    public String getEndProtocolLsidString() {
        return endProtocolLsidString;
    }

    /**
     * Sets the endProtocolLsidString.
     *
     * @param endProtocolLsidString
     *            the endProtocolLsidString to set.
     */
    public void setEndProtocolLsidString(String endProtocolLsidString) {
        this.endProtocolLsidString = endProtocolLsidString;
    }

    /**
     * Gets the startProtocolApplication.
     *
     * @return the startProtocolApplication.
     */
    public ProtocolApplication getStartProtocolApplication() {
        return startProtocolApplication;
    }

    /**
     * Sets the startProtocolApplication.
     *
     * @param startProtocolApplication
     *            the startProtocolApplication to set.
     */
    public void setStartProtocolApplication(
            ProtocolApplication startProtocolApplication) {
        this.startProtocolApplication = startProtocolApplication;
    }

    /**
     * Gets the endProtocolApplication.
     *
     * @return the endProtocolApplication.
     */
    public ProtocolApplication getEndProtocolApplication() {
        return endProtocolApplication;
    }

    /**
     * Sets the endProtocolApplication.
     *
     * @param endProtocolApplication
     *            the endProtocolApplication to set.
     */
    public void setEndProtocolApplication(
            ProtocolApplication endProtocolApplication) {
        this.endProtocolApplication = endProtocolApplication;
    }

    /**
     * Gets the startProtocolApplicationLsidString.
     *
     * @return the startProtocolApplicationLsidString.
     */
    public String getStartProtocolApplicationLsidString() {
        return startProtocolApplicationLsidString;
    }

    /**
     * Sets the startProtocolApplicationLsidString.
     *
     * @param startProtocolApplicationLsidString
     *            the startProtocolApplicationLsidString to set.
     */
    public void setStartProtocolApplicationLsidString(
            String startProtocolApplicationLsidString) {
        this.startProtocolApplicationLsidString = startProtocolApplicationLsidString;
    }

    /**
     * Gets the endProtocolApplicationLsidString.
     *
     * @return the endProtocolApplicationLsidString.
     */
    public String getEndProtocolApplicationLsidString() {
        return endProtocolApplicationLsidString;
    }

    /**
     * Sets the endProtocolApplicationLsidString.
     *
     * @param endProtocolApplicationLsidString
     *            the endProtocolApplicationLsidString to set.
     */
    public void setEndProtocolApplicationLsidString(
            String endProtocolApplicationLsidString) {
        this.endProtocolApplicationLsidString = endProtocolApplicationLsidString;
    }

}