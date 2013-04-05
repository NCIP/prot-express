/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
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

        Integer startIndex = expRunHolder.getInitialActionSequenceNumber();
        Integer increment = expRunHolder.getIncrementActionSequence();
        Integer endIndex = expRunHolder.getCurrentSequenceNumber();
        for (int index = startIndex + increment; index <= endIndex; index += increment) {
            ProtocolAction protAction = expRunHolder.getProtocolActionSequenceNumberMap().get(index);
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

        // Add start protocol application for the run.
        xarProtocolApplicationsElement.getProtocolApplication().add(getProtocolApplicationBaseTypeElement(
                expRunHolder.getStartProtocolApplication(), CpasType.EXPERIMENT_RUN.getDisplayName(),
                expRunHolder.getStartProtocolAction().getActionSequenceNumber(),
                expRunHolder.getStartProtocolLsidString(),
                expRunHolder.getStartProtocolApplicationLsidString()));

     // Add protocol applications for the run.
        Integer startIndex = expRunHolder.getInitialActionSequenceNumber();
        Integer increment = expRunHolder.getIncrementActionSequence();
        Integer endIndex = expRunHolder.getCurrentSequenceNumber();
        for (int index = startIndex + increment; index <= endIndex; index += increment) {
            ProtocolAction protAction = expRunHolder.getProtocolActionSequenceNumberMap().get(index);
            if (protAction != null) {
                int actionSequenceNumber = protAction.getActionSequenceNumber();
                xarProtocolApplicationsElement.getProtocolApplication().add(getProtocolApplicationBaseTypeElement(
                        protAction.getProtocolApplication(),
                        CpasType.PROTOCOL_APPLICATION.getDisplayName(), actionSequenceNumber, null, null));
            }
        }


     // Add stop protocol application for the run.
        xarProtocolApplicationsElement.getProtocolApplication().add(getProtocolApplicationBaseTypeElement(
                expRunHolder.getEndProtocolApplication(), CpasType.EXPERIMENT_RUN_OUTPUT.getDisplayName(),
                expRunHolder.getEndProtocolAction().getActionSequenceNumber(),
                expRunHolder.getEndProtocolLsidString(),
                expRunHolder.getEndProtocolApplicationLsidString()));

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