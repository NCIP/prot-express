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
import gov.nih.nci.protexpress.data.persistent.ExperimentRun;
import gov.nih.nci.protexpress.data.persistent.Person;
import gov.nih.nci.protexpress.data.persistent.Protocol;
import gov.nih.nci.protexpress.data.persistent.ProtocolAction;
import gov.nih.nci.protexpress.data.persistent.ProtocolApplication;
import gov.nih.nci.protexpress.data.persistent.ProtocolParameters;
import gov.nih.nci.protexpress.data.persistent.SimpleType;
import gov.nih.nci.protexpress.data.persistent.SimpleTypeValue;
import gov.nih.nci.protexpress.xml.xar2_2.ContactType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentArchiveType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentRunType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentType;
import gov.nih.nci.protexpress.xml.xar2_2.ObjectFactory;
import gov.nih.nci.protexpress.xml.xar2_2.PropertyCollectionType;
import gov.nih.nci.protexpress.xml.xar2_2.ProtocolActionSetType;
import gov.nih.nci.protexpress.xml.xar2_2.ProtocolActionType;
import gov.nih.nci.protexpress.xml.xar2_2.ProtocolApplicationBaseType;
import gov.nih.nci.protexpress.xml.xar2_2.ProtocolBaseType;
import gov.nih.nci.protexpress.xml.xar2_2.SimpleTypeNames;
import gov.nih.nci.protexpress.xml.xar2_2.SimpleValueCollectionType;
import gov.nih.nci.protexpress.xml.xar2_2.SimpleValueType;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentArchiveType.ProtocolActionDefinitions;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentArchiveType.StartingInputDefinitions;
import gov.nih.nci.protexpress.xml.xar2_2.ExperimentRunType.ProtocolApplications;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Format conversion helper class for the Xar.xml 2.2 format.
 *
 * @author Krishna Kanchinadam
 */

public class Xar22FormatConversionHelper {
    private final ObjectFactory objectFactory = new ObjectFactory();

    private List<Experiment> experiments = new ArrayList<Experiment>();
    private final HashMap<String, Experiment> experimentMap = new HashMap<String, Experiment>();
    private final HashMap<String, ExperimentRun> expRunMap = new HashMap<String, ExperimentRun>();
    private final HashMap<String, Protocol> protocolMap = new HashMap<String, Protocol>();
    private final HashMap<String, ProtocolBaseType> xarProtocolBaseTypeMap = new HashMap<String, ProtocolBaseType>();

    /**
     * Default constructor.
     *
     */
    public Xar22FormatConversionHelper() {
    }

    /**
     * Given a XAR 2.2 Experiment Archive data, converts it to the internal data model.
     *
     * @param experimentArchive the experiment archive
     * @return the list of experiments.
     */
    public List<Experiment> parseExperimentArchiveData(ExperimentArchiveType experimentArchive) {
        getExperimentList(experimentArchive);
        setExperimentRunsForExperiment(experimentArchive);
        setProtocolApplications(experimentArchive);


       return this.experiments;
    }

    /**
     * Given a list of Experiment objects, creates and returns an ExperimentArchiveType.
     *
     * @param exps the list of experiments
     * @return an ExperimentArchiveType
     */
    public ExperimentArchiveType getExperimentArchiveData(List<Experiment> exps) {
        this.experiments = exps;

        ExperimentArchiveType xarExperimentArchiveType = getExperimentTypes();
        xarExperimentArchiveType.setExperimentRuns(getExperimentRuns());
        //set protocol definitions.
        ExperimentArchiveType.ProtocolDefinitions xarProtocolDefinitions = this.objectFactory
        .createExperimentArchiveTypeProtocolDefinitions();

        Iterator<ProtocolBaseType> iter = this.xarProtocolBaseTypeMap.values().iterator();
        while (iter.hasNext()) {
            ProtocolBaseType xarProtocolBaseType = iter.next();
            if (xarProtocolBaseType != null) {
                xarProtocolDefinitions.getProtocol().add(xarProtocolBaseType);
            }
        }
        xarExperimentArchiveType.setProtocolDefinitions(xarProtocolDefinitions);

        // Set StartingInputDefinitions, if applicable
        xarExperimentArchiveType.setStartingInputDefinitions(getStartingInputDefinitions());

        // Set protocol action definitions.
        xarExperimentArchiveType.setProtocolActionDefinitions(getProtocolActionDefinitions());

        return xarExperimentArchiveType;
    }

    /**
     * Given a XAR 2.2 ExperimentArchiveType, sets the list of experiments and the experiment map.
     *
     * @param xarExperimentType the experiment type
     */
    private void getExperimentList(ExperimentArchiveType experimentArchive) {
        for (ExperimentType xarExperimentType : experimentArchive.getExperiment()) {
            Experiment experiment = getExperiment(xarExperimentType);
            this.experiments.add(experiment);
            // Add to Map
            this.experimentMap.put(experiment.getLsid(), experiment);
        }
    }

    /**
     * Given a list of Experiment, returns a XAR 2.2 ExperimentArchiveType.
     *
     * @return the ExperimentArchiveType
     */
    private ExperimentArchiveType getExperimentTypes() {
        ExperimentArchiveType xarExperimentArchiveType = this.objectFactory.createExperimentArchiveType();
        for (Experiment exp : this.experiments) {
            ExperimentType xarExperimentType = this.objectFactory.createExperimentType();
            xarExperimentType.setAbout(exp.getLsid());
            xarExperimentType.setComments(exp.getComments());
            xarExperimentType.setExperimentDescriptionURL(exp.getUrl());
            xarExperimentType.setHypothesis(exp.getHypothesis());
            xarExperimentType.setName(exp.getName());

            // Set the Contact Person.
            xarExperimentType.setContact(getContactType(exp.getPrimaryContact()));

            // Set the properties
            xarExperimentType.setProperties(getPropertyCollectionType(exp.getProperties()));

            //Add to experiment archive
            xarExperimentArchiveType.getExperiment().add(xarExperimentType);
        }

        return xarExperimentArchiveType;
    }

    /**
     * Given a XAR 2.2 ExperimentType, parses it and returns an Experiment.
     *
     * @param xarExperimentType the experiment type
     * @return the experiment
     */
    private Experiment getExperiment(ExperimentType xarExperimentType) {
        Experiment experiment = new Experiment(xarExperimentType.getAbout(),
                xarExperimentType.getName());
        experiment.setComments(xarExperimentType.getComments());
        experiment.setHypothesis(xarExperimentType.getHypothesis());
        experiment.setUrl(xarExperimentType.getExperimentDescriptionURL());

        // Get the Primary Contact Person, if present
        Person experimentPrimaryContact = getPerson(xarExperimentType.getContact());
        experiment.setPrimaryContact(experimentPrimaryContact);

        // Set the Properties
        if (xarExperimentType.getProperties() != null) {
            for (SimpleValueType xarSimpleVal : xarExperimentType.getProperties().getSimpleVal()) {
                SimpleTypeValue simpleTypeVal = new SimpleTypeValue(
                        xarSimpleVal.getName(),
                        xarSimpleVal.getOntologyEntryURI(),
                        SimpleType.valueOf(xarSimpleVal.getValueType().value()));
                simpleTypeVal.setValue(xarSimpleVal.getValue());

                experiment.getProperties().add(simpleTypeVal);
            }
        }
        return experiment;
    }

    /**
     * Given a XAR 2.2 ExperimentArchiveType, returns a list of Experiment Runs.
     *
     * @param experimentArchive the experiment archive
     */
    private void setExperimentRunsForExperiment(ExperimentArchiveType experimentArchive) {
        for (ExperimentRunType xarExpRunType : experimentArchive.getExperimentRuns().getExperimentRun()) {
            ExperimentRun expRun = getExperimentRun(xarExpRunType);
            // Add to Map
            this.expRunMap.put(expRun.getLsid(), expRun);


            // If ExperimentLSID specified, then set the experiment. Else...
            Experiment exp = null;
            if ((xarExpRunType.getExperimentLSID() != null) && (xarExpRunType.getExperimentLSID().length() != 0)) {
                exp = this.experimentMap.get(xarExpRunType.getExperimentLSID());
           } else {
                if (this.experiments.size() == 1) {
                    exp = this.experiments.get(0);
                }
            }

            if (exp != null) {
                exp.getExperimentRuns().add(expRun);
                expRun.setExperiment(exp);
            }
        }
    }

    /**
     * Given a XAR 2.2 ExperimentArchiveType, sets ProtocolApplication information.
     *
     * @param experimentArchive the experiment archive
     */
    private void setProtocolApplications(ExperimentArchiveType experimentArchive) {
        // Get the Protocols
        ExperimentArchiveType.ProtocolDefinitions xarProtocolDefinitions = experimentArchive.getProtocolDefinitions();
        if (xarProtocolDefinitions != null) {
            for (ProtocolBaseType xarProtocolBaseType : xarProtocolDefinitions.getProtocol()) {
                Protocol protocol = getProtocol(xarProtocolBaseType);
                //Add to Map
                this.protocolMap.put(protocol.getLsid(), protocol);
            }
        }

        // Iterate through the XAR Experiment Runs, get protocol applications and set accordingly.
        for (ExperimentRunType xarExpRunType : experimentArchive.getExperimentRuns().getExperimentRun()) {
            ExperimentRun expRun = this.expRunMap.get(xarExpRunType.getAbout());
            //Loop through the XAR Protocol Applications, set protocol values, set to Experiment Run
           ProtocolApplications xarProtApplications = xarExpRunType.getProtocolApplications();
           if (xarProtApplications != null) {
               for (ProtocolApplicationBaseType xarProtAppBaseType : xarProtApplications.getProtocolApplication()) {
                   // Get the protocol corresponding to the LSID and set the properties.
                   ProtocolApplication protApplication = getProtocolApplication(xarProtAppBaseType, expRun);
                   expRun.getProtocolApplications().add(protApplication);
               }
           }
        }
    }



    /**
     *  Given a list of experiment objects, returns the ExperimentArchiveType.StartingInputDefintions.
     *
     *  @return the ExperimentArchiveType.StartingInputDefintions object.
     */
    private StartingInputDefinitions getStartingInputDefinitions() {
        StartingInputDefinitions xarStartingInputDefns = this.objectFactory.
        createExperimentArchiveTypeStartingInputDefinitions();

        return xarStartingInputDefns;
    }

    /**
     *  Given a list of experiment objects, returns the ExperimentArchiveType.ProtocolActionDefinitons.
     *
     *  @return the ExperimentArchiveType.StartingInputDefintions object.
     */
    private ProtocolActionDefinitions getProtocolActionDefinitions() {
        ProtocolActionDefinitions xarProtActionDefns =
            this.objectFactory.createExperimentArchiveTypeProtocolActionDefinitions();

        for (Experiment exp : this.experiments) {
            xarProtActionDefns.getProtocolActionSet().add(getProtocolActionSetType(exp));
        }

        return xarProtActionDefns;
    }

    /**
     * Given a Experiment, returns a XAR 2.2 ProtocolActionSetType.
     *
     * @param exp the experiment.
     * @return the XAR 2.2 ProtocolActionSetType object.
     */
    private ProtocolActionSetType getProtocolActionSetType(Experiment exp) {
        ProtocolActionSetType xarPASetType = this.objectFactory.createProtocolActionSetType();
        if (exp != null) {
            // set parent protocol lsid
            //xarPASetType.setParentProtocolLSID(exp.getProtocolActions().get(0).getProtocol().getLsid());

             // Child protocol actions.
            for (ProtocolAction protAction : exp.getProtocolActions()) {
                ProtocolActionType xarProtActionType = this.objectFactory.createProtocolActionType();
                xarProtActionType.setChildProtocolLSID(protAction.getProtocol().getLsid());

                xarPASetType.getProtocolAction().add(xarProtActionType);
            }
        }
        return xarPASetType;
    }

    /**
     * Given a list of Experiment objects, returns ExperimentArchiveType.ExperimentRuns.
     *
     * @return the ExperimentArchiveType.ExperimentRuns object
     */
    private ExperimentArchiveType.ExperimentRuns getExperimentRuns() {
        ExperimentArchiveType.ExperimentRuns xarExperimentRuns =
            this.objectFactory.createExperimentArchiveTypeExperimentRuns();

        for (Experiment exp : this.experiments) {
            for (ExperimentRun expRun : exp.getExperimentRuns()) {
                ExperimentRunType xarExperimentRunType = this.objectFactory.createExperimentRunType();
                xarExperimentRunType.setAbout(expRun.getLsid());
                xarExperimentRunType.setExperimentLSID(expRun.getExperiment().getLsid());
                xarExperimentRunType.setComments(expRun.getComments());
                xarExperimentRunType.setName(expRun.getName());

             // Set the properties
                xarExperimentRunType.setProperties(getPropertyCollectionType(expRun.getProperties()));

                // Get Protocol Applications.
                ExperimentRunType.ProtocolApplications xarProtocolApplications = this.objectFactory
                .createExperimentRunTypeProtocolApplications();
                for (ProtocolApplication protApp : expRun.getProtocolApplications()) {
                    ProtocolApplicationBaseType xarProtocolApplicationBaseType =
                        getProtocolApplicationBaseType(protApp);
                    ProtocolBaseType xarProtocolBaseType = getProtocolBaseType(protApp);

                    // Add Protocol Application
                    xarProtocolApplications.getProtocolApplication().add(xarProtocolApplicationBaseType);

                    // Set the protocol in the map.
                    if (this.xarProtocolBaseTypeMap.get(xarProtocolBaseType.getAbout()) == null) {
                        this.xarProtocolBaseTypeMap.put(xarProtocolBaseType.getAbout(), xarProtocolBaseType);
                    }
                    xarExperimentRunType.setProtocolApplications(xarProtocolApplications);
                }
                xarExperimentRuns.getExperimentRun().add(xarExperimentRunType);
            }
        }
        return xarExperimentRuns;
    }

    /**
     * Given  a ProtocolApplication, returns a XAR 2.2 ProtocolApplicationBaseType.
     *
     * @param protApp the protocol application
     * @return the protocol application base type
     */
    private ProtocolApplicationBaseType getProtocolApplicationBaseType(ProtocolApplication protApp) {
        ProtocolApplicationBaseType xarProtocolApplicationBaseType =
            this.objectFactory.createProtocolApplicationBaseType();

        xarProtocolApplicationBaseType.setAbout(protApp.getLsid());
        if (protApp.getProtocolAction() != null) {
            xarProtocolApplicationBaseType.setActivityDate(protApp.getActivityDate());
            xarProtocolApplicationBaseType.setComments(protApp.getComments());
            xarProtocolApplicationBaseType.setName(protApp.getName());
            xarProtocolApplicationBaseType.setProtocolLSID(protApp.getProtocolAction().getProtocol().getLsid());
        }

     // Get the protocol application parameters.
        xarProtocolApplicationBaseType.setProtocolApplicationParameters(getProtocolApplicationParameters(protApp));

        // Set the properties
        xarProtocolApplicationBaseType.setProperties(getPropertyCollectionType(protApp.getProperties()));

        return xarProtocolApplicationBaseType;
    }

    /**
     * Given a ProtocolApplication, returns a XAR 2.2 ProtocolBaseType.
     *
     * @param protApp the protocol application
     * @return the protocol base type
     */
    private ProtocolBaseType getProtocolBaseType(ProtocolApplication protApp) {
        ProtocolBaseType xarProtocolBaseType = this.objectFactory.createProtocolBaseType();
        if ((protApp != null) && (protApp.getProtocolAction() != null)) {
            xarProtocolBaseType.setAbout(protApp.getProtocolAction().getProtocol().getLsid());
            // KK xarProtocolBaseType.setApplicationType(protApp.getProtocolAction().getProtocol().getType().name());
            xarProtocolBaseType.setInstrument(protApp.getProtocolAction().getProtocol().getInstrument());
            xarProtocolBaseType.setName(protApp.getProtocolAction().getProtocol().getName());
            xarProtocolBaseType.setProtocolDescription(protApp.getProtocolAction().getProtocol().getDescription());
            xarProtocolBaseType.setSoftware(protApp.getProtocolAction().getProtocol().getSoftware());

            xarProtocolBaseType.setOutputMaterialType(protApp.getProtocolAction().getProtocol().
                    getOutputMaterialType());
            xarProtocolBaseType.setOutputDataType(protApp.getProtocolAction().getProtocol().getOutputDataType());
            xarProtocolBaseType.setMaxInputDataPerInstance(this.objectFactory.
                    createProtocolBaseTypeMaxInputDataPerInstance(protApp.getProtocolAction().getProtocol().
                            getMaxInputDataPerInstance()));
            xarProtocolBaseType.setMaxInputMaterialPerInstance(this.objectFactory.
                    createProtocolBaseTypeMaxInputMaterialPerInstance(
                            protApp.getProtocolAction().getProtocol().getMaxInputMaterialPerInstance()));
            xarProtocolBaseType.setOutputDataPerInstance(this.objectFactory.
                    createProtocolBaseTypeOutputDataPerInstance(
                    protApp.getProtocolAction().getProtocol().getOutputDataPerInstance()));
            xarProtocolBaseType.setOutputMaterialPerInstance(this.objectFactory.
                    createProtocolBaseTypeOutputMaterialPerInstance(
                    protApp.getProtocolAction().getProtocol().getOutputMaterialPerInstance()));

            // Get the contact
            xarProtocolBaseType.setContact(getContactType(protApp.getProtocolAction().getProtocol().
                    getPrimaryContact()));

         // Set the properties
            xarProtocolBaseType.setProperties(getPropertyCollectionType(protApp.getProtocolAction().
                    getProtocol().getProperties()));

            // Get the protocol parameters.
            xarProtocolBaseType.setParameterDeclarations(getProtocolParameterDeclarations(protApp.
                    getProtocolAction().getProtocol()));
        }

        return xarProtocolBaseType;
    }

    /**
     * Given a Protocol, returns the XAR 2.2 SimpleValueCollectionType element.
     *
     * @param protocol the protocol
     * @return the XAR 2.2 SimpleValueCollectionType element
     */
    private SimpleValueCollectionType getProtocolParameterDeclarations(Protocol protocol) {
        return getParameterDeclarations(protocol.getParameters());
    }

    /**
     * Given a ProtocolApplication, returns the XAR 2.2 SimpleValueCollectionType element.
     *
     * @param protocol the protocol application
     * @return the XAR 2.2 SimpleValueCollectionType element
     */
    private SimpleValueCollectionType getProtocolApplicationParameters(ProtocolApplication protApp) {
        return getParameterDeclarations(protApp.getParameters());
    }

    /**
     * Given a ProtocolParameter object, returns the XAR 2.2 SimpleValueCollectionType element.
     *
     * @param protocolParam the ProtocolParameters
     * @return the XAR 2.2 SimpleValueCollectionType element
     */
    private SimpleValueCollectionType getParameterDeclarations(ProtocolParameters protocolParam) {
        SimpleValueCollectionType xarSimpleValueCollectionType = this.objectFactory.createSimpleValueCollectionType();
        if (protocolParam != null) {
            if (protocolParam.getAppLsidTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getAppLsidTemplate(),
                        ProtocolParameters.APP_LSID_TEMPLATE,
                        ProtocolParameters.URI_APP_LSID_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }

            if (protocolParam.getAppNameTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getAppNameTemplate(),
                        ProtocolParameters.APP_NAME_TEMPLATE,
                        ProtocolParameters.URI_APP_NAME_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }

            if (protocolParam.getOutputDataDirTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getOutputDataDirTemplate(),
                        ProtocolParameters.OUTPUT_DATA_DIR_TEMPLATE,
                        ProtocolParameters.URI_OUTPUT_DATA_DIR_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }
            if (protocolParam.getOutputDataFileTemplate() != null) {
                 xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                         protocolParam.getOutputDataFileTemplate(),
                         ProtocolParameters.OUTPUT_DATA_FILE_TEMPLATE,
                         ProtocolParameters.URI_OUTPUT_DATA_FILE_TEMPLATE,
                         ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }

            if (protocolParam.getOutputDataLsidTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getOutputDataLsidTemplate(),
                        ProtocolParameters.OUTPUT_DATA_LSID_TEMPLATE,
                        ProtocolParameters.URI_OUTPUT_DATA_LSID_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }

            if (protocolParam.getOutputDataNameTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getOutputDataNameTemplate(),
                        ProtocolParameters.OUTPUT_DATA_NAME_TEMPLATE,
                        ProtocolParameters.URI_OUTPUT_DATA_NAME_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }
            if (protocolParam.getOutputMaterialLsidTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getOutputMaterialLsidTemplate(),
                        ProtocolParameters.OUTPUT_MATERIAL_LSID_TEMPLATE,
                        ProtocolParameters.URI_OUTPUT_MATERIAL_LSID_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }

            if (protocolParam.getOutputMaterialNameTemplate() != null) {
                xarSimpleValueCollectionType.getSimpleVal().add(getSimpleValueTypeElement(
                        protocolParam.getOutputMaterialNameTemplate(),
                        ProtocolParameters.OUTPUT_MATERIAL_NAME_TEMPLATE,
                        ProtocolParameters.URI_OUTPUT_MATERIAL_NAME_TEMPLATE,
                        ProtocolParameters.PROTOCOL_PARAMETERS_TYPE));
            }
        }
        return xarSimpleValueCollectionType;
    }

    /**
     * Given a value, paramter name, and the uri, returns a XAR 2.2 SimpleValueType.
     *
     * @param value the value
     * @param paramName the parameter name
     * @param uri the URI value
     * @param type the type
     */
    private SimpleValueType getSimpleValueTypeElement(String value, String paramName, String uri, String type) {
        SimpleValueType xarSimpleValType = this.objectFactory.createSimpleValueType();
        xarSimpleValType.setValue(value);
        xarSimpleValType.setName(paramName);
        xarSimpleValType.setOntologyEntryURI(uri);
        xarSimpleValType.setValueType(SimpleTypeNames.fromValue(type));

        return xarSimpleValType;
    }

    /**
     * Given a XAR 2.2 ExperimentRunType, parses it and returns an ExperimentRun.
     *
     * @param xarExperimentRunType the experiment run type
     * @return the experiment run
     */
    private ExperimentRun getExperimentRun(ExperimentRunType xarExperimentRunType) {
        ExperimentRun expRun = new ExperimentRun(xarExperimentRunType.getAbout(), xarExperimentRunType.getName());
        expRun.setComments(xarExperimentRunType.getComments());

        // Set the Properties
        if (xarExperimentRunType.getProperties() != null) {
            for (SimpleValueType xarSimpleVal : xarExperimentRunType.getProperties().getSimpleVal()) {
                SimpleTypeValue simpleTypeVal = new SimpleTypeValue(
                        xarSimpleVal.getName(),
                        xarSimpleVal.getOntologyEntryURI(),
                        SimpleType.valueOf(xarSimpleVal.getValueType().value()));
                simpleTypeVal.setValue(xarSimpleVal.getValue());

                expRun.getProperties().add(simpleTypeVal);
            }
        }
        return expRun;
    }

    /**
     * Given a XAR 2.2 ProtocolBaseType, parses it and returns a Protocol.
     *
     * @param xarProtocolBaseType the protocol base type
     * @return the protocol
     */
    private Protocol getProtocol(ProtocolBaseType xarProtocolBaseType) {
        // KK Protocol protocol = new Protocol(xarProtocolBaseType.getAbout(), xarProtocolBaseType.getName(),
        // ProtocolType.valueOf(xarProtocolBaseType.getApplicationType()));
        Protocol protocol = new Protocol(xarProtocolBaseType.getAbout(), xarProtocolBaseType.getName());

        protocol.setInstrument(xarProtocolBaseType.getInstrument());
        protocol.setSoftware(xarProtocolBaseType.getSoftware());
        protocol.setDescription(xarProtocolBaseType.getProtocolDescription());
        protocol.setPrimaryContact(getPerson(xarProtocolBaseType.getContact()));

        // Get the protocol parameters, if any.
        protocol.setParameters(getProtocolParameters(xarProtocolBaseType.getParameterDeclarations()));

     // Set the Properties
        if (xarProtocolBaseType.getProperties() != null) {
            for (SimpleValueType xarSimpleVal : xarProtocolBaseType.getProperties().getSimpleVal()) {
                SimpleTypeValue simpleTypeVal = new SimpleTypeValue(
                        xarSimpleVal.getName(),
                        xarSimpleVal.getOntologyEntryURI(),
                        SimpleType.valueOf(xarSimpleVal.getValueType().value()));
                simpleTypeVal.setValue(xarSimpleVal.getValue());

                protocol.getProperties().add(simpleTypeVal);
            }
        }

        return protocol;
    }

    /**
     * Given a XAR 2.2 ProtocolApplicationBaseType, parses it and returns a ProtocolApplication.
     *
     * @param xarProtocolApplicationBaseType the protocol application base type
     * @param protocol the protocol
     * @return the protocol application
     */
    private ProtocolApplication getProtocolApplication(ProtocolApplicationBaseType xarProtAppBaseType,
            ExperimentRun expRun) {
        ProtocolApplication protApplication = new ProtocolApplication(xarProtAppBaseType.getAbout(),
                xarProtAppBaseType.getName(), xarProtAppBaseType.getActivityDate(), expRun, null);

        protApplication.setComments(xarProtAppBaseType.getComments());

        // Set the Properties
        if (xarProtAppBaseType.getProperties() != null) {
            for (SimpleValueType xarSimpleVal : xarProtAppBaseType.getProperties().getSimpleVal()) {
                SimpleTypeValue simpleTypeVal = new SimpleTypeValue(
                        xarSimpleVal.getName(),
                        xarSimpleVal.getOntologyEntryURI(),
                        SimpleType.valueOf(xarSimpleVal.getValueType().value()));
                simpleTypeVal.setValue(xarSimpleVal.getValue());
                protApplication.getProperties().add(simpleTypeVal);
            }
        }
        // Get the protocol application parameters, if any.
        protApplication.setParameters(getProtocolParameters(xarProtAppBaseType.getProtocolApplicationParameters()));

        return protApplication;
    }

    /**
     * Given a XAR 2.2 SimpleValueCollectionType element, returns the ProtoocolParameters.
     *
     */
    private ProtocolParameters getProtocolParameters(SimpleValueCollectionType xarSimpleValCollection) {
        ProtocolParameters protocolParam = new ProtocolParameters();
        if (xarSimpleValCollection != null) {
            for (SimpleValueType xarSimpleVal : xarSimpleValCollection.getSimpleVal()) {
                if ((xarSimpleVal != null) && (xarSimpleVal.getName() != null)) {
                    if (xarSimpleVal.getName().equals(ProtocolParameters.APP_LSID_TEMPLATE)) {
                        protocolParam.setAppLsidTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.APP_NAME_TEMPLATE)) {
                        protocolParam.setAppNameTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.OUTPUT_MATERIAL_LSID_TEMPLATE)) {
                        protocolParam.setOutputMaterialLsidTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.OUTPUT_MATERIAL_NAME_TEMPLATE)) {
                        protocolParam.setOutputMaterialNameTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.OUTPUT_DATA_LSID_TEMPLATE)) {
                        protocolParam.setOutputDataLsidTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.OUTPUT_DATA_NAME_TEMPLATE)) {
                        protocolParam.setOutputDataNameTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.OUTPUT_DATA_FILE_TEMPLATE)) {
                        protocolParam.setOutputDataFileTemplate(xarSimpleVal.getValue());
                    }
                    if (xarSimpleVal.getName().equals(ProtocolParameters.OUTPUT_DATA_DIR_TEMPLATE)) {
                        protocolParam.setOutputDataDirTemplate(xarSimpleVal.getValue());
                    }
                }
            }
        }
        return protocolParam;
    }

    /**
     * Given a XAR 2.2 ContactType, returns a Person.
     *
     * @param xarContactType the contact type
     * @return the person
     */
    private Person getPerson(ContactType xarContactType) {
        Person primaryContact = new Person();
        if (xarContactType != null) {
            primaryContact.setFirstName(xarContactType.getFirstName());
            primaryContact.setLastName(xarContactType.getLastName());
            primaryContact.setContactId(xarContactType.getContactId());
            primaryContact.setEmail(xarContactType.getEmail());

            // Set the Properties
            if (xarContactType.getProperties() != null) {
                for (SimpleValueType xarSimpleVal : xarContactType.getProperties().getSimpleVal()) {
                    SimpleTypeValue simpleTypeVal = new SimpleTypeValue(
                            xarSimpleVal.getName(),
                            xarSimpleVal.getOntologyEntryURI(),
                            SimpleType.valueOf(xarSimpleVal.getValueType().value()));
                    simpleTypeVal.setValue(xarSimpleVal.getValue());

                    primaryContact.getProperties().add(simpleTypeVal);
                }
            }
        }

        return primaryContact;
    }

    /**
     * Given a Person, returns a XAR 2.2 ContactType.
     *
     * @param person the person
     * @return xarContactType the contact type
     */
    private ContactType getContactType(Person person) {
        ContactType xarContactType = this.objectFactory.createContactType();
        if (person != null) {
            xarContactType.setContactId(person.getContactId());
            xarContactType.setEmail(person.getEmail());
            xarContactType.setFirstName(person.getFirstName());
            xarContactType.setLastName(person.getLastName());

         // Set the properties
            xarContactType.setProperties(getPropertyCollectionType(person.getProperties()));
        }
        return xarContactType;
    }

    /**
     * Given a list of SimpleTypeValue objects, returns the XAR 2.2 PropertyCollectionType object.
     *
     * @param propCol the simple value type collection
     * @return the XAR 2.2 PropertyCollectionType
     */
    private PropertyCollectionType getPropertyCollectionType(List<SimpleTypeValue> simpleTypeValues) {
        PropertyCollectionType xarPropCollection = this.objectFactory.createPropertyCollectionType();
        if (simpleTypeValues != null) {
            for (SimpleTypeValue simpleTypeVal : simpleTypeValues) {
                SimpleValueType xarSimpleVal = this.objectFactory.createSimpleValueType();
                xarSimpleVal.setName(simpleTypeVal.getName());
                xarSimpleVal.setOntologyEntryURI(simpleTypeVal.getOntologyEntryURI());
                xarSimpleVal.setValue(simpleTypeVal.getValue());
                xarSimpleVal.setValueType(SimpleTypeNames.fromValue(simpleTypeVal.getValueType().name()));

                xarPropCollection.getSimpleVal().add(xarSimpleVal);
            }
        }

        return xarPropCollection;
    }
}
