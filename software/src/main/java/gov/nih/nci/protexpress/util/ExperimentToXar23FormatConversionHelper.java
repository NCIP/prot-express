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

import gov.nih.nci.protexpress.domain.ConfigParamEnum;
import gov.nih.nci.protexpress.domain.CpasType;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.xml.xar2_3.ContactType;
import gov.nih.nci.protexpress.xml.xar2_3.DataBaseType;
import gov.nih.nci.protexpress.xml.xar2_3.ExperimentArchiveType;
import gov.nih.nci.protexpress.xml.xar2_3.ExperimentRunType;
import gov.nih.nci.protexpress.xml.xar2_3.ExperimentType;
import gov.nih.nci.protexpress.xml.xar2_3.InputOutputRefsType;
import gov.nih.nci.protexpress.xml.xar2_3.MaterialBaseType;
import gov.nih.nci.protexpress.xml.xar2_3.ObjectFactory;
import gov.nih.nci.protexpress.xml.xar2_3.PropertyCollectionType;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolActionSetType;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolActionType;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolApplicationBaseType;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolBaseType;
import gov.nih.nci.protexpress.xml.xar2_3.SimpleTypeNames;
import gov.nih.nci.protexpress.xml.xar2_3.SimpleValueType;
import gov.nih.nci.protexpress.xml.xar2_3.InputOutputRefsType.DataLSID;
import gov.nih.nci.protexpress.xml.xar2_3.InputOutputRefsType.MaterialLSID;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolActionType.PredecessorAction;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolApplicationBaseType.OutputDataObjects;
import gov.nih.nci.protexpress.xml.xar2_3.ProtocolApplicationBaseType.OutputMaterials;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Format conversion helper class for the Xar.xml 2.3 format.
 *
 * @author Krishna Kanchinadam
 */

public class ExperimentToXar23FormatConversionHelper {

    private static final Logger LOGGER = Logger.getLogger(ExperimentToXar23FormatConversionHelper.class);
    private final ObjectFactory objectFactory = new ObjectFactory();
    private ExperimentParser experimentParser;
    private String propertyKeyName = "Notes";
    private String propertyExperimentDescription = "Description";
    private Long startProtocolActionSequenceNumber = 1L;
    private Long endProtocolActionSequenceNumber;

    /**
     * Default constructor.
     * @param experiment the experiment
     */
    public ExperimentToXar23FormatConversionHelper(Experiment experiment) {
        if (experiment != null) {
            this.experimentParser = new ExperimentParser(experiment);
        } else {
            LOGGER.debug("Experiment object is null");
        }
    }

    /**
     * Given a list of Experiment objects, creates and returns an ExperimentArchiveType.
     *
     * @return an ExperimentArchiveType
     */
    public ExperimentArchiveType getExperimentArchiveData() {
        //Experiment Basic Info.
        ExperimentArchiveType xarExperimentArchiveType = getExperimentArchiveTypeElement(
                getExperimentParser().getExperiment());

        // Protocol Definitions.
        xarExperimentArchiveType.setProtocolDefinitions(getProtocolDefinitions(
                getExperimentParser().getExperimentRunHolders(), getExperimentParser().getProtocols()));

        //Starting Inputs
        xarExperimentArchiveType.setStartingInputDefinitions(getStartingInputDefinitions(
                getExperimentParser().getStartingInputs()));

        //Experiment Run & Protocol Application.
        xarExperimentArchiveType.setExperimentRuns(getExperimentRuns(getExperimentParser().getExperimentRunHolders()));

        // Protocol Action Definitions
        xarExperimentArchiveType.setProtocolActionDefinitions(
                getProtocolActionDefinitions(getExperimentParser().getExperimentRunHolders()));

        return xarExperimentArchiveType;
    }

    private ExperimentArchiveType getExperimentArchiveTypeElement(Experiment exp) {
        ExperimentArchiveType xarExpArchiveElement = getObjectFactory().createExperimentArchiveType();
        xarExpArchiveElement.getExperiment().add(getExperimentTypeElement(exp));
        return xarExpArchiveElement;
    }

    private ExperimentType getExperimentTypeElement(Experiment exp) {
        ExperimentType xarExpTypeElement = getObjectFactory().createExperimentType();
        xarExpTypeElement.setAbout(getLsid(ConfigParamEnum.LSID_NAMESPACE_EXPERIMENT, exp.getId()));
        xarExpTypeElement.setComments(exp.getNotes());
        xarExpTypeElement.setExperimentDescriptionURL(exp.getUrl());
        xarExpTypeElement.setHypothesis(exp.getHypothesis());
        xarExpTypeElement.setName(exp.getName());
        xarExpTypeElement.setContact(getContactTypeElement(exp.getContactPerson()));
        xarExpTypeElement.setProperties(getPropertyCollectionTypeElement(
                this.propertyExperimentDescription, exp.getDescription(),
                SimpleTypeNames.STRING, getOntologyEntryUri()));
        return xarExpTypeElement;
    }

    private ContactType getContactTypeElement(ContactPerson contactPerson) {
        ContactType xarContactTypeElement = getObjectFactory().createContactType();
        if (contactPerson != null) {
            xarContactTypeElement.setEmail(contactPerson.getEmail());
            xarContactTypeElement.setFirstName(contactPerson.getFirstName());
            xarContactTypeElement.setLastName(contactPerson.getLastName());
            xarContactTypeElement.setContactId(contactPerson.getNotes());
        }
        return xarContactTypeElement;
    }

    private ExperimentArchiveType.ProtocolDefinitions getProtocolDefinitions(
            HashMap<Long, ExperimentRunHolder> expRunHolders, HashMap<Long, Protocol> protocols) {

        ExperimentArchiveType.ProtocolDefinitions xarProtocolDefinitionElement = getObjectFactory()
        .createExperimentArchiveTypeProtocolDefinitions();

        // Add start/stop protocols for each experiment run.
        for (ExperimentRunHolder expRunHolder : expRunHolders.values()) {
            xarProtocolDefinitionElement.getProtocol().add(getProtocolBaseTypeElement(expRunHolder.getStartProtocol(),
                    CpasType.EXPERIMENT_RUN.getDisplayName(), expRunHolder.getStartProtocolLsidString()));

            xarProtocolDefinitionElement.getProtocol().add(getProtocolBaseTypeElement(expRunHolder.getEndProtocol(),
                    CpasType.EXPERIMENT_RUN_OUTPUT.getDisplayName(), expRunHolder.getEndProtocolLsidString()));
        }

        for (Protocol protocol : protocols.values()) {
            xarProtocolDefinitionElement.getProtocol().add(getProtocolBaseTypeElement(protocol,
                    CpasType.PROTOCOL_APPLICATION.getDisplayName(), null));
        }

        return xarProtocolDefinitionElement;
    }

    private ProtocolBaseType getProtocolBaseTypeElement(Protocol protocol, String cpasType, String lsidId) {
        ProtocolBaseType xarProtocolBaseTypeElement = getObjectFactory().createProtocolBaseType();
        String protocolLsid = null;
        if (lsidId != null) {
            protocolLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, lsidId);
        } else {
            protocolLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, protocol.getId());
        }
        xarProtocolBaseTypeElement.setAbout(protocolLsid);
        xarProtocolBaseTypeElement.setApplicationType(cpasType);
        xarProtocolBaseTypeElement.setInstrument(protocol.getInstrument());
        xarProtocolBaseTypeElement.setName(protocol.getName());
        xarProtocolBaseTypeElement.setProtocolDescription(protocol.getDescription());
        xarProtocolBaseTypeElement.setSoftware(protocol.getSoftware());
        xarProtocolBaseTypeElement.setContact(getContactTypeElement(protocol.getContactPerson()));
        xarProtocolBaseTypeElement.setProperties(getPropertyCollectionTypeElement(this.propertyKeyName,
                protocol.getNotes(), SimpleTypeNames.STRING, getOntologyEntryUri()));

        return xarProtocolBaseTypeElement;
    }

    private PropertyCollectionType getPropertyCollectionTypeElement(String name, String value,
            SimpleTypeNames valueType, String uri) {
        PropertyCollectionType xarPropCollectionTypeElement = getObjectFactory().createPropertyCollectionType();
        SimpleValueType xarSimpleValueTypeElement = getObjectFactory().createSimpleValueType();
        xarSimpleValueTypeElement.setName(name);
        xarSimpleValueTypeElement.setValue(value);
        xarSimpleValueTypeElement.setValueType(valueType);
        xarSimpleValueTypeElement.setOntologyEntryURI(uri);
        xarPropCollectionTypeElement.getSimpleVal().add(xarSimpleValueTypeElement);

        return xarPropCollectionTypeElement;
    }

    private ExperimentArchiveType.StartingInputDefinitions getStartingInputDefinitions(
            HashMap<Long, InputOutputObject> startingInputs) {
        ExperimentArchiveType.StartingInputDefinitions xarStartingInputDefnElement = getObjectFactory()
            .createExperimentArchiveTypeStartingInputDefinitions();

        for (InputOutputObject input : startingInputs.values()) {
            if (StringUtils.isNotBlank(input.getDataFileURL())) {
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
        xarDataBaseTypeElement.setAbout(getLsid(ConfigParamEnum.LSID_NAMESPACE_INPUT_OUTPUT, ioObject.getId()));
        xarDataBaseTypeElement.setCpasType(CpasType.DATA.getDisplayName());
        xarDataBaseTypeElement.setDataFileUrl(ioObject.getDataFileURL());
        xarDataBaseTypeElement.setName(ioObject.getName());
        xarDataBaseTypeElement.setProperties(getPropertyCollectionTypeElement(this.propertyKeyName,
                ioObject.getNotes(), SimpleTypeNames.STRING, getOntologyEntryUri()));

        return xarDataBaseTypeElement;
    }

    private MaterialBaseType getMaterialBaseTypeElement(InputOutputObject ioObject) {
        MaterialBaseType xarMaterialBaseTypeElement = getObjectFactory().createMaterialBaseType();
        xarMaterialBaseTypeElement.setAbout(getLsid(ConfigParamEnum.LSID_NAMESPACE_INPUT_OUTPUT, ioObject.getId()));
        xarMaterialBaseTypeElement.setCpasType(CpasType.MATERIAL.getDisplayName());
        xarMaterialBaseTypeElement.setName(ioObject.getName());
        xarMaterialBaseTypeElement.setProperties(getPropertyCollectionTypeElement(this.propertyKeyName,
                ioObject.getNotes(), SimpleTypeNames.STRING, getOntologyEntryUri()));

        return xarMaterialBaseTypeElement;
    }

    private ExperimentArchiveType.ProtocolActionDefinitions
        getProtocolActionDefinitions(HashMap<Long, ExperimentRunHolder> experimentRunHolders) {

        ExperimentArchiveType.ProtocolActionDefinitions xarProtocolActionDefsElement =
            getObjectFactory().createExperimentArchiveTypeProtocolActionDefinitions();

        for (ExperimentRunHolder expRunHolder : experimentRunHolders.values()) {
            xarProtocolActionDefsElement.getProtocolActionSet().add(getProtocolActionSetTypeElement(expRunHolder));
        }

        return xarProtocolActionDefsElement;
    }

    private ProtocolActionSetType getProtocolActionSetTypeElement(ExperimentRunHolder expRunHolder) {
        ProtocolActionSetType xarProtocolActionSetTypeElement = getObjectFactory().createProtocolActionSetType();
        xarProtocolActionSetTypeElement.setParentProtocolLSID(
                getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, expRunHolder.getStartProtocolLsidString()));

        xarProtocolActionSetTypeElement.getProtocolAction().add(getProtocolActionTypeElement(
                expRunHolder.getStartProtocolAction(), expRunHolder.getStartProtocolLsidString()));

        for (ProtocolAction protAction : expRunHolder.getProtocolActions()) {
            xarProtocolActionSetTypeElement.getProtocolAction().add(getProtocolActionTypeElement(protAction, null));
        }

        xarProtocolActionSetTypeElement.getProtocolAction().add(getProtocolActionTypeElement(
                expRunHolder.getEndProtocolAction(), expRunHolder.getEndProtocolLsidString()));

        return xarProtocolActionSetTypeElement;
    }

    private ProtocolActionType getProtocolActionTypeElement(ProtocolAction protAction, String lsidId) {
        ProtocolActionType xarProtocolActionTypeElement = getObjectFactory().createProtocolActionType();
        xarProtocolActionTypeElement.setActionSequence(protAction.getActionSequenceNumber());

        String protocolLsid = null;
        if (lsidId != null) {
            protocolLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, lsidId);
        } else {
            protocolLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL,
                    protAction.getProtocolApplication().getProtocol().getId());
        }
        xarProtocolActionTypeElement.setChildProtocolLSID(protocolLsid);
        // Get Predecessors
        for (Integer predActionNumber : protAction.getPredecessorActionNumbers()) {
            PredecessorAction predecessor = getObjectFactory().createProtocolActionTypePredecessorAction();
            predecessor.setActionSequenceRef(predActionNumber);
            xarProtocolActionTypeElement.getPredecessorAction().add(predecessor);
        }

        return xarProtocolActionTypeElement;
    }

    private ExperimentArchiveType.ExperimentRuns getExperimentRuns(
            HashMap<Long, ExperimentRunHolder> experimentRunHolders) {
        ExperimentArchiveType.ExperimentRuns xarExperimentRunsElement = getObjectFactory()
        .createExperimentArchiveTypeExperimentRuns();

        for (ExperimentRunHolder expRunHolder : experimentRunHolders.values()) {
            xarExperimentRunsElement.getExperimentRun()
            .add(getExperimentRunTypeElement(expRunHolder));
        }

        return xarExperimentRunsElement;
    }

    private ExperimentRunType getExperimentRunTypeElement(ExperimentRunHolder expRunHolder) {
        ExperimentRunType xarExpRunTypeElement = getObjectFactory().createExperimentRunType();


        xarExpRunTypeElement.setAbout(getLsid(ConfigParamEnum.LSID_NAMESPACE_EXPERIMENT_RUN,
                expRunHolder.getExperimentRun().getId()));
        xarExpRunTypeElement.setComments(StringUtils.EMPTY);
        xarExpRunTypeElement.setExperimentLSID(getLsid(ConfigParamEnum.LSID_NAMESPACE_EXPERIMENT,
                expRunHolder.getExperimentRun().getExperiment().getId()));
        xarExpRunTypeElement.setName(expRunHolder.getExperimentRun().getName());
        xarExpRunTypeElement.setProperties(getPropertyCollectionTypeElement(this.propertyKeyName,
                expRunHolder.getExperimentRun().getNotes(), SimpleTypeNames.STRING, getOntologyEntryUri()));
        xarExpRunTypeElement.setProtocolApplications(getProtocolApplications(expRunHolder));
        xarExpRunTypeElement.setProtocolLSID(getLsid(
                ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, expRunHolder.getStartProtocolLsidString()));

        return xarExpRunTypeElement;
    }

    private ExperimentRunType.ProtocolApplications getProtocolApplications(ExperimentRunHolder expRunHolder) {
        ExperimentRunType.ProtocolApplications xarProtocolApplicationsElement = getObjectFactory()
            .createExperimentRunTypeProtocolApplications();

        // Add start/stop protocol applications for the run.
        xarProtocolApplicationsElement.getProtocolApplication().add(getProtocolApplicationBaseTypeElement(
                expRunHolder.getStartProtocolApplication(), CpasType.EXPERIMENT_RUN.getDisplayName(),
                expRunHolder.getStartProtocolAction().getActionSequenceNumber(),
                expRunHolder.getStartProtocolLsidString(),
                expRunHolder.getStartProtocolApplicationLsidString()));

        xarProtocolApplicationsElement.getProtocolApplication().add(getProtocolApplicationBaseTypeElement(
                expRunHolder.getEndProtocolApplication(), CpasType.EXPERIMENT_RUN_OUTPUT.getDisplayName(),
                expRunHolder.getEndProtocolAction().getActionSequenceNumber(),
                expRunHolder.getEndProtocolLsidString(),
                expRunHolder.getEndProtocolApplicationLsidString()));

        for (ProtocolApplication protApplication : expRunHolder.getExperimentRun().getProtocolApplications()) {
            int actionSeqNumber = expRunHolder.getProtocolActionMap().get(
                    protApplication.getId()).getActionSequenceNumber();
            xarProtocolApplicationsElement.getProtocolApplication().add(getProtocolApplicationBaseTypeElement(
                    protApplication, CpasType.PROTOCOL_APPLICATION.getDisplayName(), actionSeqNumber, null, null));
        }
        return xarProtocolApplicationsElement;
    }

    private ProtocolApplicationBaseType getProtocolApplicationBaseTypeElement(
            ProtocolApplication protApp, String cpasType, int actionSequenceNumber,
            String protocolLsidId, String protAppLsidId) {
        ProtocolApplicationBaseType xarProtocolApplicationBaseTypeElement =
            getObjectFactory().createProtocolApplicationBaseType();

        String protAppLsid = null;
        if (protAppLsidId != null) {
            protAppLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL_APPLICATION, protAppLsidId);
        } else {
            protAppLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL_APPLICATION, protApp.getId());
        }
        xarProtocolApplicationBaseTypeElement.setAbout(protAppLsid);

        String protocolLsid = null;
        if (protocolLsidId != null) {
            protocolLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, protocolLsidId);
        } else {
            protocolLsid = getLsid(ConfigParamEnum.LSID_NAMESPACE_PROTOCOL, protApp.getProtocol().getId());
        }
        xarProtocolApplicationBaseTypeElement.setProtocolLSID(protocolLsid);

        xarProtocolApplicationBaseTypeElement.setActionSequence(actionSequenceNumber);
        xarProtocolApplicationBaseTypeElement.setActivityDate(DateHelper.getDate(protApp.getDatePerformed()));
        xarProtocolApplicationBaseTypeElement.setComments(StringUtils.EMPTY);
        xarProtocolApplicationBaseTypeElement.setCpasType(cpasType);
        xarProtocolApplicationBaseTypeElement.setName(getProtocolApplicationName(protApp));

        xarProtocolApplicationBaseTypeElement.setProperties(getPropertyCollectionTypeElement(this.propertyKeyName,
                protApp.getNotes(), SimpleTypeNames.STRING, getOntologyEntryUri()));

        xarProtocolApplicationBaseTypeElement.setInputRefs(getProtocolApplicationInputs(protApp));
        xarProtocolApplicationBaseTypeElement.setOutputDataObjects(
                getProtocolApplicationOutputDataObjectsElement(protApp));
        xarProtocolApplicationBaseTypeElement.setOutputMaterials(
                getProtocolApplicationOutputMaterialsElement(protApp));

        return xarProtocolApplicationBaseTypeElement;
    }

    private InputOutputRefsType getProtocolApplicationInputs(ProtocolApplication protApp) {
        InputOutputRefsType xarInputOutputRefsTypeElement = getObjectFactory().createInputOutputRefsType();

        for (InputOutputObject input : protApp.getInputs()) {
            if (StringUtils.isNotBlank(input.getDataFileURL())) {
                DataLSID xarDataLSIDElement = getObjectFactory().createInputOutputRefsTypeDataLSID();
                xarDataLSIDElement.setCpasType(CpasType.DATA.getDisplayName());
                xarDataLSIDElement.setDataFileUrl(input.getDataFileURL());
                xarDataLSIDElement.setValue(getLsid(ConfigParamEnum.LSID_NAMESPACE_INPUT_OUTPUT, input.getId()));
                xarInputOutputRefsTypeElement.getDataLSID().add(xarDataLSIDElement);
            } else {
                MaterialLSID xarMaterialLSIDElement = getObjectFactory().createInputOutputRefsTypeMaterialLSID();
                xarMaterialLSIDElement.setCpasType(CpasType.MATERIAL.getDisplayName());
                xarMaterialLSIDElement.setValue(getLsid(ConfigParamEnum.LSID_NAMESPACE_INPUT_OUTPUT, input.getId()));
                xarInputOutputRefsTypeElement.getMaterialLSID().add(xarMaterialLSIDElement);
            }
        }
        return xarInputOutputRefsTypeElement;
    }

    private OutputDataObjects getProtocolApplicationOutputDataObjectsElement(ProtocolApplication protApp) {
        OutputDataObjects xarOutputDataObjectsElement = getObjectFactory()
            .createProtocolApplicationBaseTypeOutputDataObjects();

        for (InputOutputObject output : protApp.getOutputs()) {
            if (StringUtils.isNotBlank(output.getDataFileURL())) {
                DataBaseType xarDataBaseTypeElement = getDataBaseTypeElement(output);
                xarDataBaseTypeElement.setSourceProtocolLSID(getLsid(
                        ConfigParamEnum.LSID_NAMESPACE_PROTOCOL,
                        output.getOutputOfProtocolApplication().getProtocol().getId()));
                xarOutputDataObjectsElement.getData().add(xarDataBaseTypeElement);
            }
        }
        return xarOutputDataObjectsElement;
    }

    private OutputMaterials getProtocolApplicationOutputMaterialsElement(ProtocolApplication protApp) {
        OutputMaterials xarOutputMaterialsElement = getObjectFactory()
            .createProtocolApplicationBaseTypeOutputMaterials();

        for (InputOutputObject output : protApp.getOutputs()) {
            if (StringUtils.isBlank(output.getDataFileURL())) {
                MaterialBaseType xarMaterialBaseTypeElement = getMaterialBaseTypeElement(output);
                xarMaterialBaseTypeElement.setSourceProtocolLSID(getLsid(
                        ConfigParamEnum.LSID_NAMESPACE_PROTOCOL,
                        output.getOutputOfProtocolApplication().getProtocol().getId()));
                xarOutputMaterialsElement.getMaterial().add(xarMaterialBaseTypeElement);
            }
        }
        return xarOutputMaterialsElement;
    }

    /**
     * Gets the objectFactory.
     *
     * @return the objectFactory.
     */
    public ObjectFactory getObjectFactory() {
        return objectFactory;
    }

    /**
     * Gets the experimentParser.
     *
     * @return the experimentParser.
     */
    public ExperimentParser getExperimentParser() {
        return experimentParser;
    }

    /**
     * Sets the experimentParser.
     *
     * @param experimentParser the experimentParser to set.
     */
    public void setExperimentParser(ExperimentParser experimentParser) {
        this.experimentParser = experimentParser;
    }

    private String getLsid(ConfigParamEnum configParamEnum, Long objectId) {
        return LsidGeneratorHelper.getLsid(configParamEnum, objectId);
    }

    private String getLsid(ConfigParamEnum configParamEnum, String objectId) {
        return LsidGeneratorHelper.getLsid(configParamEnum, objectId);
    }

    private String getOntologyEntryUri() {
        StringBuffer ontologyEntryUri = new StringBuffer();
        return ontologyEntryUri
            .append(ConfigurationHelper.getConfiguration().getString(ConfigParamEnum.ONTOLOGY_ENTRY_URI.name()))
            .toString();
    }

    private String getProtocolApplicationName(ProtocolApplication protApp) {
        StringBuffer protocolApplicationName = new StringBuffer();
        return protocolApplicationName
            .append(protApp.getProtocol().getName())
            .append(".ProtocolApplication")
            .toString();
    }

    /**
     * Gets the startProtocolActionSequenceNumber.
     *
     * @return the startProtocolActionSequenceNumber.
     */
    public Long getStartProtocolActionSequenceNumber() {
        return startProtocolActionSequenceNumber;
    }

    /**
     * Sets the startProtocolActionSequenceNumber.
     *
     * @param startProtocolActionSequenceNumber the startProtocolActionSequenceNumber to set.
     */
    public void setStartProtocolActionSequenceNumber(
            Long startProtocolActionSequenceNumber) {
        this.startProtocolActionSequenceNumber = startProtocolActionSequenceNumber;
    }

    /**
     * Gets the endProtocolActionSequenceNumber.
     *
     * @return the endProtocolActionSequenceNumber.
     */
    public Long getEndProtocolActionSequenceNumber() {
        return endProtocolActionSequenceNumber;
    }

    /**
     * Sets the endProtocolActionSequenceNumber.
     *
     * @param endProtocolActionSequenceNumber the endProtocolActionSequenceNumber to set.
     */
    public void setEndProtocolActionSequenceNumber(
            Long endProtocolActionSequenceNumber) {
        this.endProtocolActionSequenceNumber = endProtocolActionSequenceNumber;
    }
}