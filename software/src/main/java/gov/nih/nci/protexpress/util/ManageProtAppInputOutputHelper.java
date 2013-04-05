/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang.StringUtils;



/**
 * Util methods for managing protocol inputs and outputs. .
 *
 * @author Krishna Kanchinadam
 */

public final class ManageProtAppInputOutputHelper {
    /**
     * Default constructor.
     *
     */
    private ManageProtAppInputOutputHelper() {
    }

    /**
     * Removes the invalid items (inputs/outputs with blank name, filename and notes) from the list.
     *
     * @param lst the list of inputs/outputs.
     */
    public static void removeInvalidItems(List<InputOutputObject> lst) {
        ListIterator<InputOutputObject> listIter = lst.listIterator();
        while (listIter.hasNext()) {
            InputOutputObject ioObject = listIter.next();
            if (StringUtils.isBlank(ioObject.getName())
                    && StringUtils.isBlank(ioObject.getDataFileURL())
                    && StringUtils.isBlank(ioObject.getNotes())) {
                listIter.remove();
            }
        }
    }

    /**
     * Determines if an input name is empty.
     *
     * @param lst the list of inputs/outputs.
     * @return isValid value to determine if all inputs have names.
     */
    public static boolean isNameEmpty(List<InputOutputObject> lst) {
        boolean isValid = true;
        for (InputOutputObject obj : lst) {
            if (isValid & StringUtils.isBlank(obj.getName())) {
                isValid = false;
            }
        }
        return isValid;
    }

    /**
     * Returns a list of potential inputs for a protocol application in the experiment run.
     *
     * @param experimentRunId the experiment run id.
     * @param protocolApplication the current protocol application - either from session or db.
     * @return the list of potential inputs.
     */
    public static List<InputOutputObject> getPotentialInputs(Long experimentRunId,
            ProtocolApplication protocolApplication) {
        // protocolApplicationId could be null, if not yet saved to the db.
        // Should ignore its own outputs.
        List<InputOutputObject> lstPotentialInputs = new ArrayList<InputOutputObject>();

        ExperimentRun expRun = ProtExpressRegistry.getExperimentService().getExperimentRunById(experimentRunId);
        for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
            if ((protocolApplication.getId() == null)
                    || (protApp.getId().intValue() != protocolApplication.getId().intValue())) {
                for (InputOutputObject output : protApp.getOutputs()) {
                    ProtocolApplication inputToPA = output.getInputToProtocolApplication();
                    if (inputToPA == null) {
                        lstPotentialInputs.add(output);
                    }
                }
            }
        }
        // Remove any dupe inputs from this list - outputs that have been selected as inputs, but not yet persisted.
        removeDuplicateInputs(protocolApplication.getInputs(), lstPotentialInputs);

        // Remove outputs of all child protocol applications - avoid circular dependancy.
        List<InputOutputObject> lstOutputsOfChildProtApps = new ArrayList<InputOutputObject>();
        getChildProtAppOutputs(protocolApplication, lstOutputsOfChildProtApps);
        removeDuplicateInputs(lstOutputsOfChildProtApps, lstPotentialInputs);

        return lstPotentialInputs;
    }

    /**
     * Removes child protocol outputs from the list of potential inputs.
     *
     * @param protocolApplication the protocol application.
     * @param lstOutputsOfChildProtApps list of child protocol applicaiton outputs.
     */
    private static void getChildProtAppOutputs(ProtocolApplication protocolApplication,
            List<InputOutputObject> lstOutputsOfChildProtApps) {
        for (InputOutputObject output : protocolApplication.getOutputs()) {
            lstOutputsOfChildProtApps.add(output);
            // recurse through the child protocols.
            if (output.getInputToProtocolApplication() != null) {
                getChildProtAppOutputs(output.getInputToProtocolApplication(), lstOutputsOfChildProtApps);
            }
        }
    }

    /**
     * Removes potential duplicate inputs from the list.
     *
     * @param lstInputs the protocol application inputs.
     * @param lstPotentialInputs the list of potential inputs.
     */
    private static void removeDuplicateInputs(List<InputOutputObject> lstInputs,
            List<InputOutputObject> lstPotentialInputs) {
        ListIterator<InputOutputObject> iterPAInputs = lstInputs.listIterator();
        while (iterPAInputs.hasNext()) {
            InputOutputObject currentInput = iterPAInputs.next();
            if ((currentInput.getId() != null)
                    && !StringUtils.isBlank(currentInput.getId().toString())
                    && lstPotentialInputs.contains(currentInput)) {
                lstPotentialInputs.remove(currentInput);
            }
        }
    }

    /**
     * Adds a new input to the protocol application inputs list.
     *
     * @param lst the list of inputs.
     */
    public static void addNewInput(List<InputOutputObject> lst) {
        addNewElementToList(lst);
    }

    /**
     * Adds a new input to the protocol application inputs list.
     *
     * @param lstInputs the list of inputs.
     * @param selectedInputId the id of the input to be added to the list of inputs.
     */
    public static void addExistingInput(List<InputOutputObject> lstInputs, Long selectedInputId) {
        InputOutputObject input = ProtExpressRegistry.getExperimentService().getInputOutputObjectById(selectedInputId);
        lstInputs.add((lstInputs.size() - 1), input);
    }

    /**
     * Adds a new output to the protocol application outputs list.
     *
     * @param lst the list of outputs.
     */
    public static void addNewOutput(List<InputOutputObject> lst) {
        addNewElementToList(lst);
    }

    /**
     * Adds a new InputOutputObject element to the inputs/outputs list.
     *
     * @param lst the list.
     */
    private static void addNewElementToList(List<InputOutputObject> lst) {
        if (lst != null) {
            lst.add(new InputOutputObject(null));
        }
    }

    /**
     * Deletes the specified input from the protocol application inputs list.
     *
     * @param lst the list of inputs.
     * @param deleteIndex the index of the element to be deleted from the list.
     */
    public static void deleteInput(List<InputOutputObject> lst, Long deleteIndex) {
        deleteElementFromList(lst, deleteIndex);
    }

    /**
     * Deletes the specified output from the protocol application outputs list.
     *
     * @param lst the list of outputs.
     * @param deleteIndex the index of the element to be deleted from the list.
     */
    public static void deleteOutput(List<InputOutputObject> lst, Long deleteIndex) {
        deleteElementFromList(lst, deleteIndex);
    }

    /**
     * Deletes the element at the specified index from the list.
     *
     * @param lst the list.
     * @param index the index of the object to be deleted.
     */
    private static void deleteElementFromList(List<InputOutputObject> lst, Long deleteIndex) {
        if ((lst != null) && (deleteIndex.intValue() >= 0) && (lst.size() > 0)) {
            lst.remove(deleteIndex.intValue());
        }
    }
}
