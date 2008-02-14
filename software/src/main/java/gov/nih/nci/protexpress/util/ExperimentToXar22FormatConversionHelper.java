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

import gov.nih.nci.protexpress.data.persistent.Experiment;
import gov.nih.nci.protexpress.data.persistent.Protocol;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentArchiveType;
import gov.nih.nci.protexpress.xml.xar2_2.ObjectFactory;

import java.util.HashMap;


/**
 * Format conversion helper class for the Xar.xml 2.2 format.
 *
 * @author Krishna Kanchinadam
 */

public class ExperimentToXar22FormatConversionHelper {
    private final ObjectFactory objectFactory = new ObjectFactory();

    private final HashMap<Long, Protocol> protocolMap = new HashMap<Long, Protocol>();

    /**
     * Default constructor.
     *
     */
    public ExperimentToXar22FormatConversionHelper() {
    }

    private ObjectFactory getObjectFactory() {
        return this.objectFactory;
    }

    private HashMap<Long, Protocol> getProtocolMap() {
        return this.protocolMap;
    }

    /**
     * Given a list of Experiment objects, creates and returns an ExperimentArchiveType.
     *
     * @param exp the experiment
     * @return an ExperimentArchiveType
     */
    public ExperimentArchiveType getExperimentArchiveData(Experiment exp) {
        return null;
    }

    /*
    public ExperimentArchiveType getExperimentArchiveData(Experiment exp) {
        ExperimentArchiveType xarExperimentArchiveType = getExperimentArchiveTypeElement(exp);
        setProtocolsInMap(exp);
        xarExperimentArchiveType.setProtocolDefinitions(getProtocolDefinitions());
        xarExperimentArchiveType.setStartingInputDefinitions(getStartingInputDefinitions(exp));
        xarExperimentArchiveType.setProtocolActionDefinitions(getProtocolActionDefinitions(exp));
        xarExperimentArchiveType.setExperimentRuns(getExperimentRuns(exp));

        return xarExperimentArchiveType;
    }

    private ExperimentArchiveType getExperimentArchiveTypeElement(Experiment exp) {
        ExperimentArchiveType xarExpArchiveElement = getObjectFactory().createExperimentArchiveType();
        ExperimentType xarExpElement = getExperimentTypeElement(exp);
        xarExpArchiveElement.getExperiment().add(xarExpElement);

        return xarExpArchiveElement;
    }

    private ExperimentType getExperimentTypeElement(Experiment exp) {
        ExperimentType xarExpTypeElement = getObjectFactory().createExperimentType();
        xarExpTypeElement.setAbout(exp.getLsid());
        xarExpTypeElement.setComments(exp.getComments());
        xarExpTypeElement.setExperimentDescriptionURL(exp.getUrl());
        xarExpTypeElement.setHypothesis(exp.getHypothesis());
        xarExpTypeElement.setName(exp.getName());
        xarExpTypeElement.setContact(getContactTypeElement(exp.getContactPerson()));
        xarExpTypeElement.setProperties(getPropertyCollectionTypeElement(exp.getProperties()));

        return xarExpTypeElement;
    }

    private ContactType getContactTypeElement(ContactPerson contactPerson) {
        ContactType xarContactTypeElement = getObjectFactory().createContactType();
        if (contactPerson != null) {
            xarContactTypeElement.setEmail(contactPerson.getEmail());
            xarContactTypeElement.setFirstName(contactPerson.getFirstName());
            xarContactTypeElement.setLastName(contactPerson.getLastName());
        }
        return xarContactTypeElement;
    }

    private PropertyCollectionType getPropertyCollectionTypeElement(List<SimpleTypeValue> props) {
        PropertyCollectionType xarPropCollectionTypeElement = getObjectFactory().createPropertyCollectionType();
        if ((props != null) && (props.size() > 0)) {
            for (SimpleTypeValue prop : props) {
                SimpleValueType xarSimpleValueTypeElement = getObjectFactory().createSimpleValueType();
                xarSimpleValueTypeElement.setName(prop.getName());
                xarSimpleValueTypeElement.setOntologyEntryURI(prop.getOntologyEntryURI());
                xarSimpleValueTypeElement.setValue(prop.getValueType().name());
                xarSimpleValueTypeElement.setValue(prop.getValue());

                xarPropCollectionTypeElement.getSimpleVal().add(xarSimpleValueTypeElement);
            }
        }

        return xarPropCollectionTypeElement;
    }

    private ExperimentArchiveType.ProtocolDefinitions getProtocolDefinitions() {
        ExperimentArchiveType.ProtocolDefinitions xarProtocolDefinitionElement = getObjectFactory()
            .createExperimentArchiveTypeProtocolDefinitions();

        // Get List of Protocols
        List<ProtocolBaseType> xarProtocolBaseTypeElements = getProtocolBaseTypeElements();
        for (ProtocolBaseType xarProtocolBaseTypeElement : xarProtocolBaseTypeElements) {
            xarProtocolDefinitionElement.getProtocol().add(xarProtocolBaseTypeElement);
        }

        return xarProtocolDefinitionElement;
    }

    private List<ProtocolBaseType> getProtocolBaseTypeElements() {
        List<ProtocolBaseType> xarProtocolBaseTypeElements = new ArrayList<ProtocolBaseType>();

        // Iterate through all protocols in the HashMap.
        int protocolMapSize = getProtocolMap().size();
        if (protocolMapSize > 0) {
            Iterator<Entry<Long, Protocol>> iter = getProtocolMap().entrySet().iterator();
            while (iter.hasNext()) {
                Entry<Long, Protocol> entry = iter.next();
                int stepNumber = entry.getKey().intValue();
                Protocol protocol = entry.getValue();
                ProtocolBaseType xarProtocolBaseTypeElement = getProtocolBaseTypeElement(protocol, stepNumber,
                        protocolMapSize);

                xarProtocolBaseTypeElements.add(xarProtocolBaseTypeElement);
            }
        }

        return xarProtocolBaseTypeElements;
    }

    private void setProtocolsInMap(Experiment exp) {
        for (ProtocolAction protAction : exp.getProtocolActions()) {
            Protocol protocol = protAction.getProtocol();
            getProtocolMap().put(protAction.getStepNumber(), protocol);
        }
    }

    private ProtocolBaseType getProtocolBaseTypeElement(Protocol prot, int stepNumber, int protocolCount) {
        ProtocolBaseType xarProtocolBaseTypeElement = getObjectFactory().createProtocolBaseType();
        xarProtocolBaseTypeElement.setAbout(prot.getLsid());
        xarProtocolBaseTypeElement.setApplicationType(getCpasProtocolApplicationType(stepNumber, protocolCount));
        xarProtocolBaseTypeElement.setInstrument(prot.getInstrument());
        xarProtocolBaseTypeElement.setName(prot.getName());
        xarProtocolBaseTypeElement.setProtocolDescription(prot.getDescription());
        xarProtocolBaseTypeElement.setSoftware(prot.getSoftware());
        xarProtocolBaseTypeElement.setContact(getContactTypeElement(prot.getContactPerson()));
        xarProtocolBaseTypeElement.setProperties(getPropertyCollectionTypeElement(prot.getProperties()));

        return xarProtocolBaseTypeElement;
    }

    private String getCpasProtocolApplicationType(int stepNumber, int protocolCount) {
        String cpasProtocolApplicationType = CpasType.PROTOCOL_APPLICATION.getDisplayName();
        if (stepNumber == 1) {
            cpasProtocolApplicationType = CpasType.EXPERIMENT_RUN.getDisplayName();
        } else if (stepNumber == protocolCount) {
            cpasProtocolApplicationType = CpasType.EXPERIMENT_RUN_OUTPUT.getDisplayName();
        }
        return cpasProtocolApplicationType;
    }

    private ExperimentArchiveType.StartingInputDefinitions getStartingInputDefinitions(Experiment exp) {
        ExperimentArchiveType.StartingInputDefinitions xarStartingInputDefnElement = getObjectFactory()
            .createExperimentArchiveTypeStartingInputDefinitions();

        for (InputOutputObject input : exp.getGlobalInputs()) {
            if ((input.getDataFileURL() != null) && (input.getDataFileURL().length() > 0)) {
                DataBaseType xarDataBaseTypeElement = getDataBaseTypeElement(input);
                xarStartingInputDefnElement.getData().add(xarDataBaseTypeElement);
            } else {
                MaterialBaseType xarMaterialBaseTypeElement = getMaterialBaseTypeElement(input);
                xarStartingInputDefnElement.getMaterial().add(xarMaterialBaseTypeElement);
            }
        }

        return xarStartingInputDefnElement;
    }

    private DataBaseType getDataBaseTypeElement(InputOutputObject ioObject) {
        DataBaseType xarDataBaseTypeElement = getObjectFactory().createDataBaseType();
        xarDataBaseTypeElement.setAbout(ioObject.getLsid());
        xarDataBaseTypeElement.setCpasType(CpasType.DATA.getDisplayName());
        xarDataBaseTypeElement.setDataFileUrl(ioObject.getDataFileURL());
        xarDataBaseTypeElement.setName(ioObject.getName());
        xarDataBaseTypeElement.setProperties(getPropertyCollectionTypeElement(ioObject.getProperties()));

        return xarDataBaseTypeElement;
    }

    private MaterialBaseType getMaterialBaseTypeElement(InputOutputObject ioObject) {
        MaterialBaseType xarMaterialBaseTypeElement = getObjectFactory().createMaterialBaseType();
        xarMaterialBaseTypeElement.setAbout(ioObject.getLsid());
        xarMaterialBaseTypeElement.setCpasType(CpasType.MATERIAL.getDisplayName());
        xarMaterialBaseTypeElement.setName(ioObject.getName());
        xarMaterialBaseTypeElement.setProperties(getPropertyCollectionTypeElement(ioObject.getProperties()));

        return xarMaterialBaseTypeElement;
    }

    private ExperimentArchiveType.ProtocolActionDefinitions getProtocolActionDefinitions(Experiment exp) {
        ExperimentArchiveType.ProtocolActionDefinitions xarProtocolActionDefnElement = getObjectFactory()
            .createExperimentArchiveTypeProtocolActionDefinitions();

        ProtocolActionSetType xarProtocolActionSetTypeElement = getObjectFactory().createProtocolActionSetType();
        for (ProtocolAction protAction : exp.getProtocolActions()) {
            if (protAction.getStepNumber() == 1) {
                xarProtocolActionSetTypeElement.setParentProtocolLSID(protAction.getProtocol().getLsid());
            }

            ProtocolActionType xarProtocolActionTypeElement = getObjectFactory().createProtocolActionType();
            xarProtocolActionTypeElement.setActionSequence(protAction.getStepNumber().intValue());
            xarProtocolActionTypeElement.setChildProtocolLSID(protAction.getProtocol().getLsid());
            xarProtocolActionTypeElement.getPredecessorAction().clear();
            xarProtocolActionTypeElement.getPredecessorAction().addAll(getPredecessorActions(exp, protAction));

            xarProtocolActionSetTypeElement.getProtocolAction().add(xarProtocolActionTypeElement);
        }
        xarProtocolActionDefnElement.getProtocolActionSet().add(xarProtocolActionSetTypeElement);

        return xarProtocolActionDefnElement;
    }

    private List<PredecessorAction>  getPredecessorActions(Experiment exp, ProtocolAction protAction) {
        List<PredecessorAction> xarPredecessorActionElements = new ArrayList<PredecessorAction>();

        List<ProtocolApplication> protApps = getProtocolApplicationsForAction(exp, protAction);

        List<InputOutputObject> inputs = new ArrayList<InputOutputObject>();
        for (ProtocolApplication protApp : protApps) {
            // Get all inputs across all protocol applications.
            inputs.addAll(protApp.getInputs());
        }
        // Determine the protocol applications outputs.
        List<Integer> predecessorStepNumbers = new ArrayList<Integer>();
        // Get the predecessor step numbers across each experiment run.
        for (ExperimentRun expRun : exp.getExperimentRuns()) {
            for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
                for (InputOutputObject output : protApp.getOutputs()) {
                    String outputLsid = output.getLsid();
                    for (InputOutputObject input : inputs) {
                        if (input.getLsid().equals(outputLsid)) {
                            Integer protActionStepNum = protApp.getProtocolAction().getStepNumber().intValue();
                            if (!predecessorStepNumbers.contains(protActionStepNum)) {
                                predecessorStepNumbers.add(protActionStepNum);
                            }
                        }
                    }
                }
            }
        }

        // Check for global inputs
        List<InputOutputObject> globalInputs = exp.getGlobalInputs();
        for (ExperimentRun expRun : exp.getExperimentRuns()) {
            for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
                if (protApp.getProtocolAction().equals(protAction)) {
                    for (InputOutputObject protAppInput : protApp.getInputs()) {
                        String protAppInputLsid = protAppInput.getLsid();
                        for (InputOutputObject globalInput : globalInputs) {
                            if (globalInput.getLsid().equals(protAppInputLsid)) {
                                Integer stepNum = 1;
                                if (!predecessorStepNumbers.contains(stepNum)) {
                                    predecessorStepNumbers.add(stepNum);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (Integer actionSeq : predecessorStepNumbers) {
            PredecessorAction xarPredecessorActionElement = getObjectFactory()
                .createProtocolActionTypePredecessorAction();
            xarPredecessorActionElement.setActionSequenceRef(actionSeq.intValue());

            xarPredecessorActionElements.add(xarPredecessorActionElement);
        }

        return xarPredecessorActionElements;
    }

    private List<ProtocolApplication> getProtocolApplicationsForAction(Experiment exp, ProtocolAction protAction) {
        List<ProtocolApplication> protApps = new ArrayList<ProtocolApplication>();

        int protActionStepNumber = protAction.getStepNumber().intValue();
        for (ExperimentRun expRun : exp.getExperimentRuns()) {
            for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
                ProtocolAction protAppProtocolAction = protApp.getProtocolAction();
                int protAppProtocolActionStepNumber = protAppProtocolAction.getStepNumber().intValue();
                if (protAppProtocolAction.equals(protAction)
                        && (protAppProtocolActionStepNumber == protActionStepNumber)) {
                    protApps.add(protApp);
                }
            }
        }

        return protApps;
    }

    private ExperimentArchiveType.ExperimentRuns getExperimentRuns(Experiment exp) {
        ExperimentArchiveType.ExperimentRuns xarExperimentRunsElement = getObjectFactory()
            .createExperimentArchiveTypeExperimentRuns();

        for (ExperimentRun expRun : exp.getExperimentRuns()) {
            ExperimentRunType xarExpRunTypeElement = getExperimentRunTypeElement(expRun);

            xarExperimentRunsElement.getExperimentRun().add(xarExpRunTypeElement);
        }

        return xarExperimentRunsElement;
    }

    private ExperimentRunType getExperimentRunTypeElement(ExperimentRun expRun) {
        ExperimentRunType xarExpRunTypeElement = getObjectFactory().createExperimentRunType();

        xarExpRunTypeElement.setAbout(expRun.getLsid());
        xarExpRunTypeElement.setComments(expRun.getComments());
        xarExpRunTypeElement.setExperimentLSID(expRun.getExperiment().getLsid());
        xarExpRunTypeElement.setName(expRun.getName());
        xarExpRunTypeElement.setProperties(getPropertyCollectionTypeElement(expRun.getProperties()));
        xarExpRunTypeElement.setProtocolApplications(getProtocolApplications(expRun));
        Protocol rootProtocol = getProtocolMap().get(1L);
        if (rootProtocol != null) {
            xarExpRunTypeElement.setProtocolLSID(rootProtocol.getLsid());
        }
        return xarExpRunTypeElement;
    }

    private ExperimentRunType.ProtocolApplications getProtocolApplications(ExperimentRun expRun) {
        ExperimentRunType.ProtocolApplications xarProtocolApplicationsElement = getObjectFactory()
            .createExperimentRunTypeProtocolApplications();

        for (ProtocolApplication protApplication : expRun.getProtocolApplications()) {
            ProtocolApplicationBaseType xarProtApplicationBaseTypeElement =
                    getProtocolApplicationBaseTypeElement(protApplication);

            xarProtocolApplicationsElement.getProtocolApplication().add(xarProtApplicationBaseTypeElement);
        }
        return xarProtocolApplicationsElement;
    }

    private ProtocolApplicationBaseType getProtocolApplicationBaseTypeElement(ProtocolApplication protApp) {
        ProtocolApplicationBaseType xarProtocolApplicationBaseTypeElement =
            getObjectFactory().createProtocolApplicationBaseType();

        int protocolCount = getProtocolMap().size();
        int stepNumber = protApp.getProtocolAction().getStepNumber().intValue();

        xarProtocolApplicationBaseTypeElement.setAbout(protApp.getLsid());
        xarProtocolApplicationBaseTypeElement.setActionSequence(stepNumber);
        xarProtocolApplicationBaseTypeElement.setActivityDate(protApp.getActivityDate());
        xarProtocolApplicationBaseTypeElement.setComments(protApp.getComments());
        xarProtocolApplicationBaseTypeElement.setCpasType(getCpasProtocolApplicationType(stepNumber, protocolCount));
        xarProtocolApplicationBaseTypeElement.setName(protApp.getName());
        xarProtocolApplicationBaseTypeElement.setProtocolLSID(protApp.getProtocolAction().getProtocol().getLsid());
        xarProtocolApplicationBaseTypeElement.setProperties(getPropertyCollectionTypeElement(protApp.getProperties()));
        xarProtocolApplicationBaseTypeElement.setInputRefs(getProtocolApplicationInputElements(protApp));
        xarProtocolApplicationBaseTypeElement.setOutputDataObjects(
                getProtocolApplicationOutputDataObjectsElement(protApp));
        xarProtocolApplicationBaseTypeElement.setOutputMaterials(
                getProtocolApplicationOutputMaterialsElement(protApp));

        return xarProtocolApplicationBaseTypeElement;
    }

    private InputOutputRefsType getProtocolApplicationInputElements(ProtocolApplication protApp) {
        InputOutputRefsType xarInputOutputRefsTypeElement = getObjectFactory().createInputOutputRefsType();

        for (InputOutputObject input : protApp.getInputs()) {
            if ((input.getDataFileURL() != null) && (input.getDataFileURL().length() > 0)) {
                DataLSID xarDataLSIDElement = getObjectFactory().createInputOutputRefsTypeDataLSID();
                xarDataLSIDElement.setCpasType(CpasType.DATA.getDisplayName());
                xarDataLSIDElement.setDataFileUrl(input.getDataFileURL());
                xarDataLSIDElement.setValue(input.getLsid());

                xarInputOutputRefsTypeElement.getDataLSID().add(xarDataLSIDElement);
            } else {
                MaterialLSID xarMaterialLSIDElement = getObjectFactory().createInputOutputRefsTypeMaterialLSID();
                xarMaterialLSIDElement.setCpasType(CpasType.MATERIAL.getDisplayName());
                xarMaterialLSIDElement.setValue(input.getLsid());

                xarInputOutputRefsTypeElement.getMaterialLSID().add(xarMaterialLSIDElement);
            }
        }
        return xarInputOutputRefsTypeElement;
    }

    private OutputDataObjects getProtocolApplicationOutputDataObjectsElement(ProtocolApplication protApp) {
        OutputDataObjects xarOutputDataObjectsElement = getObjectFactory()
            .createProtocolApplicationBaseTypeOutputDataObjects();

        for (InputOutputObject output : protApp.getOutputs()) {
            if ((output.getDataFileURL() != null) && (output.getDataFileURL().length() > 0)) {
                DataBaseType xarDataBaseTypeElement = getDataBaseTypeElement(output);
                xarDataBaseTypeElement.setSourceProtocolLSID(protApp.getProtocolAction().getProtocol().getLsid());
                xarOutputDataObjectsElement.getData().add(xarDataBaseTypeElement);
            }
        }

        return xarOutputDataObjectsElement;
    }

    private OutputMaterials getProtocolApplicationOutputMaterialsElement(ProtocolApplication protApp) {
        OutputMaterials xarOutputMaterialsElement = getObjectFactory()
            .createProtocolApplicationBaseTypeOutputMaterials();

        for (InputOutputObject output : protApp.getOutputs()) {
            if (!((output.getDataFileURL() != null) && (output.getDataFileURL().length() > 0))) {
                MaterialBaseType xarMaterialBaseTypeElement = getMaterialBaseTypeElement(output);
                xarMaterialBaseTypeElement.setSourceProtocolLSID(protApp.getProtocolAction().getProtocol().getLsid());
                xarOutputMaterialsElement.getMaterial().add(xarMaterialBaseTypeElement);
            }
        }

        return xarOutputMaterialsElement;
    }
*/
}