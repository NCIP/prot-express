/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The ProtExpress
 * Software was developed in conjunction with the National Cancer Institute
 * (NCI) by NCI employees and 5AM Solutions, Inc. (5AM). To the extent
 * government employees are authors, any rights in such works shall be subject
 * to Title 17 of the United States Code, section 105.
 *
 * This ProtExpress Software License (the License) is between NCI and You. You (or
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
 * its rights in the ProtExpress Software to (i) use, install, access, operate,
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the ProtExpress Software; (ii) distribute and
 * have distributed to and by third parties the ProtExpress Software and any
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
