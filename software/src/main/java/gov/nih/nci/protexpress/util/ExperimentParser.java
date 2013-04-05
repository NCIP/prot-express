/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.util.HashMap;


/**
 * Utility class to parse an experiment into its constituents.
 *
 * @author Krishna Kanchinadam
 */
public class ExperimentParser {

    private Experiment experiment;
    private final HashMap<Long, ExperimentRunHolder> experimentRunHolders = new HashMap<Long, ExperimentRunHolder>();
    private final HashMap<Long, Protocol> protocols = new HashMap<Long, Protocol>();
    private final HashMap<Long, InputOutputObject> startingInputs = new HashMap<Long, InputOutputObject>();
    private final HashMap<String, Long> protocolActionSequenceNumber = new HashMap<String, Long>();

    /**
     * Default constructor.
     *
     * @param experiment the experiment
     */
    public ExperimentParser(Experiment experiment) {
        setExperiment(experiment);
        this.parse();
    }

    /**
     * Parses the given experiment.
     */
    private void parse() {
        parseExperimentRuns();
        parseProtocols();
        parseStartingInputs();
    }

    private void parseExperimentRuns() {
        for (ExperimentRun expRun : getExperiment().getExperimentRuns()) {
            ExperimentRunHolder expRunHolder = new ExperimentRunHolder(expRun);
            getExperimentRunHolders().put(expRun.getId(), expRunHolder);
        }
    }

    private void parseProtocols() {
        for (ExperimentRun expRun : getExperiment().getExperimentRuns()) {
            for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
                getProtocols().put(protApp.getProtocol().getId(), protApp.getProtocol());
            }
        }
    }

    private void parseStartingInputs() {
        for (ExperimentRun expRun : getExperiment().getExperimentRuns()) {
            for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
                for (InputOutputObject input : protApp.getInputs()) {
                    if (input.getOutputOfProtocolApplication() == null) {
                        getStartingInputs().put(input.getId(), input);
                    }
                }
            }
        }
    }

    /**
     * Gets the experiment.
     *
     * @return the experiment.
     */
    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * Gets the experimentRunHolders.
     *
     * @return the experimentRunHolders.
     */
    public HashMap<Long, ExperimentRunHolder> getExperimentRunHolders() {
        return experimentRunHolders;
    }

    /**
     * Gets the protocols.
     *
     * @return the protocols.
     */
    public HashMap<Long, Protocol> getProtocols() {
        return protocols;
    }

    /**
     * Gets the startingInputs.
     *
     * @return the startingInputs.
     */
    public HashMap<Long, InputOutputObject> getStartingInputs() {
        return startingInputs;
    }

    /**
     * Sets the experiment.
     *
     * @param experiment the experiment to set.
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Gets the protocolActionSequenceNumber.
     *
     * @return the protocolActionSequenceNumber.
     */
    public HashMap<String, Long> getProtocolActionSequenceNumber() {
        return protocolActionSequenceNumber;
    }

}