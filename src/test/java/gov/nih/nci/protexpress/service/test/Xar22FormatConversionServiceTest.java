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
package gov.nih.nci.protexpress.service.test;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.data.persistent.Experiment;
import gov.nih.nci.protexpress.data.persistent.ExperimentRun;
import gov.nih.nci.protexpress.data.persistent.Person;
import gov.nih.nci.protexpress.data.persistent.Protocol;
import gov.nih.nci.protexpress.data.persistent.ProtocolAction;
import gov.nih.nci.protexpress.data.persistent.ProtocolApplication;
import gov.nih.nci.protexpress.data.persistent.ProtocolParameters;
import gov.nih.nci.protexpress.data.persistent.ProtocolType;
import gov.nih.nci.protexpress.data.persistent.SimpleType;
import gov.nih.nci.protexpress.data.persistent.SimpleTypeValue;
import gov.nih.nci.protexpress.service.FormatConversionService;
import gov.nih.nci.protexpress.test.ProtExpressBaseCsmTest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;


/**
 * Class to test the xar 22 conversion service.
 *
 * @author Scott Miller
 */
public class Xar22FormatConversionServiceTest extends ProtExpressBaseCsmTest {
    private List<Experiment> experiments;
    private List<Protocol> protocols;
    private FormatConversionService fcs;

    private final String inputXARFile = "src/test/inputFiles/test/inputXARFile.xar.xml";
    private final String outputXARFile1 = "target/outputXARFile-Unmarshall_Marshall.xar.xml";
    private final String outputXARFile2 = "target/outputXARFile-Marshall_Unmarshall.xar.xml";

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.fcs = ProtExpressRegistry.getXar22FormatConversionService();
        setupProtocols();

        this.experiments = new ArrayList<Experiment>();
        this.experiments.add(getExperiment1());
    }

    /**
     * Reads a xar file containing multiple experiments, gets list of Experiments,
     * performs assertions, and writes back to file.
     * @throws Exception the exception
     */
    @SuppressWarnings("unchecked")
    public void testUnmarshallAndMarshallFile() throws Exception {
        File inFile = new File(this.inputXARFile);
        List<Experiment> unmarshalledExperiments = this.fcs.unmarshallExperiments(inFile);
        assertExperiments(unmarshalledExperiments);

        File outFile = new File(this.outputXARFile1);
        this.fcs.marshallExperiments(unmarshalledExperiments, outFile);
    }

    @SuppressWarnings("unchecked")
     public void testMarshallAndUmarshallFile() throws Exception {
         File outFile = new File(this.outputXARFile2);
         List<Experiment> exp = new ArrayList<Experiment>();
         exp.add(getExperiment1());
         this.fcs.marshallExperiments(exp, outFile);

         List<Experiment> unmarshalledExperiments = this.fcs.unmarshallExperiments(outFile);
         assertExperiments(unmarshalledExperiments);
     }

     @SuppressWarnings("unchecked")
     public void testMarshallAndUmarshallStream() throws Exception {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         this.fcs.marshallExperiments(this.experiments, os);
         List<Experiment> unmarshalledExperiments = this.fcs.unmarshallExperiments(new ByteArrayInputStream(os.toByteArray()));
         assertExperiments(unmarshalledExperiments);
     }

     private Experiment getMinimumExperiment() {
         Experiment exp1 = new Experiment("Lsid_Test_Experiment_1", "Name - Test Experiment 1");
         exp1.setComments("Description - Test Experiment 1");
         exp1.setHypothesis("Hypothesis - Test Experiment 1");
         exp1.setUrl("URL - Test Experiment 1");

         return exp1;
     }

     private void setupProtocols() {
         this.protocols = new ArrayList<Protocol>();

         Protocol prot1 = new Protocol("${FolderLSIDBase}:Process.IPAS14", "IPAS14 Process", ProtocolType.valueOf("ExperimentRun"));
         prot1.setId(100L);
         prot1.setDescription("Prepare and run LCMS, including fractionation of the input sample.  Produces one mzXML file per fraction in a single directory.");
         prot1.setSoftware("this is the software....");
         prot1.setInstrument("This is the instrument.");

      // Properties for protocol.
         SimpleTypeValue simpleTypeVal = new SimpleTypeValue("TreatAsFractions", "terms.fhcrc.org#RunProtocolTypes.TreatAsFractions", SimpleType.valueOf("String"));
         simpleTypeVal.setValue("true");
         prot1.getProperties().add(simpleTypeVal);

         Person person = new Person();
         person.setId(110L);
         person.setContactId("Dr. Tabb's Research Center' for Protocols");
         person.setFirstName("John");
         person.setLastName("Tabb");
         person.setEmail("tabb@research-center.com");

       //Person Properties
         simpleTypeVal = new SimpleTypeValue("Contact Type", "http://vocabulary.myorg.org/extendedContactInfo/contactProperty#contactType", SimpleType.valueOf("String"));
         simpleTypeVal.setValue("Principal Investigator");
         person.getProperties().add(simpleTypeVal);

         prot1.setPrimaryContact(person);

         ProtocolParameters protParams = new ProtocolParameters();
         protParams.setAppLsidTemplate("${RunLSIDBase}:IPAS14");
         protParams.setAppNameTemplate("Do IPAS 14 protocol");
         protParams.setOutputDataNameTemplate("OUT DATANAMETEMPLATE");
         prot1.setParameters(protParams);

         this.protocols.add(prot1);

         prot1 = new Protocol("${FolderLSIDBase}:SamplePrep.IPAS14", "Sample Prep", ProtocolType.valueOf("ProtocolApplication"));
         prot1.setId(101L);
         prot1.setDescription("unspecified");
         // Parameter declarations.
         protParams = new ProtocolParameters();
         protParams.setAppLsidTemplate("${RunLSIDBase}:SamplePrep.Combine");
         protParams.setAppNameTemplate("Sample Preparation");
         protParams.setOutputMaterialLsidTemplate("${RunLSIDBase}:Combined");
         protParams.setOutputMaterialNameTemplate("Combined tagged sample");
         prot1.setParameters(protParams);
         this.protocols.add(prot1);

     }

    private Experiment getExperiment1() {
        // Setup first experiment.
        Experiment currentExperiment = new Experiment("${FolderLSIDBase}:IPAS14", "IPAS14 Experiment");
        currentExperiment.setId(400L);
        currentExperiment.setComments("Mouse Pancreatic Cancer Research");
        currentExperiment.setHypothesis("Cancer can kill a mouse too.");
        currentExperiment.setUrl("http://testUrl1:8080/index.html");

        // Properties for experiment.
        SimpleTypeValue simpleTypeVal = new SimpleTypeValue("AnExperimentProperty", "terms.fhcrc.org#ExpProp.Something", SimpleType.valueOf("String"));
        simpleTypeVal.setValue("Some property");
        currentExperiment.getProperties().add(simpleTypeVal);
        simpleTypeVal = new SimpleTypeValue("Category", "terms.fhcrc.org#ExpProp.Category", SimpleType.valueOf("Integer"));
        simpleTypeVal.setValue("210");
        currentExperiment.getProperties().add(simpleTypeVal);

     // Set Primary Contact
        Person person = new Person();
        person.setId(420L);
        person.setContactId("Jim's Laboratory");
        person.setFirstName("Jim");
        person.setLastName("Smith");
        person.setEmail("jim@smiths.net");

        //Person Properties
        simpleTypeVal = new SimpleTypeValue("Contact Type", "http://vocabulary.myorg.org/extendedContactInfo/contactProperty#contactType", SimpleType.valueOf("String"));
        simpleTypeVal.setValue("Contractor");
        person.getProperties().add(simpleTypeVal);

        currentExperiment.setPrimaryContact(person);

        // protocol action set.
        ProtocolAction childProtAction1 = new ProtocolAction(this.protocols.get(1), 1);
        childProtAction1.setId(600L);
   // kk     childProtAction1.getPredecessors().add(childProtAction1);
        ProtocolAction childProtAction2 = new ProtocolAction(this.protocols.get(1), 2);
        childProtAction2.setId(601L);
   // kk     childProtAction2.getPredecessors().add(childProtAction1);
        childProtAction1.setExperiment(currentExperiment);
        childProtAction2.setExperiment(currentExperiment);
        currentExperiment.getProtocolActions().add(childProtAction1);
        currentExperiment.getProtocolActions().add(childProtAction2);

        // Set Starting Input Definitions.

        // Set Experiment Runs
        ExperimentRun expRun = new ExperimentRun("${FolderLSIDBase}.${XarFileId}:IPAS14.IP0014_AX02", "IP0014_AX02 (Mouse Pancreatic Cancer Study)");
        expRun.setId(430L);
        expRun.setExperiment(currentExperiment);
        expRun.setComments("Profiling of Proteins in Lung Adenocarcinoma Cell Surface");

        simpleTypeVal = new SimpleTypeValue("ExpRunType", "terms.fhcrc.org#RunProtocolTypes.Something", SimpleType.valueOf("String"));
        simpleTypeVal.setValue("Some Experiment Run Property");
        expRun.getProperties().add(simpleTypeVal);

        // Protocol Actions
        ProtocolAction protAction1 = new ProtocolAction(this.protocols.get(0), 1);
        ProtocolAction protAction2 = new ProtocolAction(this.protocols.get(1), 2);

        // Set a Protocol Application
        ProtocolApplication protApp = new ProtocolApplication("${RunLSIDBase}:IPAS14", "Do IPAS 14 protocol", DatatypeConverter.parseDate("2006-08-31-07:00"), expRun, protAction1);
        protApp.setId(440L);
        ProtocolParameters protParams = new ProtocolParameters();
        protParams.setOutputDataFileTemplate("Out Data File Template");
        protParams.setAppNameTemplate("Do IPAS 14 protocol");
        protApp.setParameters(protParams);

        simpleTypeVal = new SimpleTypeValue("ProtAppFactorsCount", "terms.fhcrc.org#RunProtocolTypes.Category", SimpleType.valueOf("Integer"));
        simpleTypeVal.setValue("2");
        protApp.getProperties().add(simpleTypeVal);

        expRun.getProtocolApplications().add(protApp);

        // Another protocol application.
        protApp = new ProtocolApplication("${RunLSIDBase}:SamplePrep.Combine", "Sample Preparation", DatatypeConverter.parseDate("2006-08-31-07:00"), expRun, protAction2);
        protApp.setId(441L);

        protParams = new ProtocolParameters();
        protParams.setAppLsidTemplate("${RunLSIDBase}:SamplePrep.Combine");
        protParams.setAppNameTemplate("Sample Preparation");
        protParams.setOutputMaterialLsidTemplate("${RunLSIDBase}:Combined");
        protParams.setOutputMaterialNameTemplate("Combined tagged sample");
        protApp.setParameters(protParams);

        expRun.getProtocolApplications().add(protApp);

        currentExperiment.getExperimentRuns().add(expRun);

        return currentExperiment;
    }

    private void assertExperiments(List<Experiment> experiments) {
        assertEquals(1, experiments.size());
        assertExperiment1Values(experiments.get(0));
    }

    private void assertExperiment1Values(Experiment unmarshalledExperiment) {
        assertNotNull(unmarshalledExperiment);
        unmarshalledExperiment.setId(400L);
        assertEquals(unmarshalledExperiment, this.experiments.get(0));
        assertEquals(unmarshalledExperiment.getLsid(), "${FolderLSIDBase}:IPAS14");
        assertEquals(unmarshalledExperiment.getName(), "IPAS14 Experiment");
        assertEquals(unmarshalledExperiment.getHypothesis(), "Cancer can kill a mouse too.");
        assertEquals(unmarshalledExperiment.getUrl(), "http://testUrl1:8080/index.html");
        assertEquals(unmarshalledExperiment.getComments(), "Mouse Pancreatic Cancer Research");

        // Get the Properties
        assertNotNull(unmarshalledExperiment.getProperties());
        List<SimpleTypeValue> simpleTypeValues = unmarshalledExperiment.getProperties();
        assertNotNull(simpleTypeValues);
        assertEquals(2, simpleTypeValues.size());
        assertEquals(simpleTypeValues.get(0).getName(), "AnExperimentProperty");
        assertEquals(simpleTypeValues.get(0).getOntologyEntryURI(), "terms.fhcrc.org#ExpProp.Something");
        assertEquals(simpleTypeValues.get(0).getValue(), "Some property");
        assertEquals(simpleTypeValues.get(0).getValueType(), SimpleType.valueOf("String"));
        assertEquals(simpleTypeValues.get(1).getName(), "Category");
        assertEquals(simpleTypeValues.get(1).getOntologyEntryURI(), "terms.fhcrc.org#ExpProp.Category");
        assertEquals(simpleTypeValues.get(1).getValue(), "210");
        assertEquals(simpleTypeValues.get(1).getValueType(), SimpleType.valueOf("Integer"));

        // Contact person for the experiment
        Person person = unmarshalledExperiment.getPrimaryContact();
        person.setId(420L);
        assertNotNull(person);
        assertEquals(person, this.experiments.get(0).getPrimaryContact());
        assertEquals(person.getContactId(), "Jim's Laboratory");
        assertEquals(person.getFirstName(), "Jim");
        assertEquals(person.getLastName(), "Smith");
        assertEquals(person.getEmail(), "jim@smiths.net");
        // Person Properties
        assertNotNull(person.getProperties());
        simpleTypeValues = person.getProperties();
        assertNotNull(simpleTypeValues);
        assertEquals(1, simpleTypeValues.size());
        assertEquals(simpleTypeValues.get(0).getName(), "Contact Type");
        assertEquals(simpleTypeValues.get(0).getOntologyEntryURI(), "http://vocabulary.myorg.org/extendedContactInfo/contactProperty#contactType");
        assertEquals(simpleTypeValues.get(0).getValue(), "Contractor");
        assertEquals(simpleTypeValues.get(0).getValueType(), SimpleType.valueOf("String"));

        Experiment exp1 = this.experiments.get(0);
        exp1.setId(400L);
        assertNotNull(exp1);
        // Protocol Actions
        assertNotNull(exp1.getProtocolActions());
        assertEquals(2, exp1.getProtocolActions().size());
        ProtocolAction protAction1 = exp1.getProtocolActions().get(0);
        ProtocolAction protAction2 = exp1.getProtocolActions().get(1);
        assertNotNull(protAction1);
        assertNotNull(protAction2);
        assertEquals(exp1, protAction1.getExperiment());
        assertEquals(exp1, protAction2.getExperiment());

        // Starting Input Definition values

        //Experiment Runs
        List<ExperimentRun> unmarshalledExperimentRuns = unmarshalledExperiment.getExperimentRuns();
        assertNotNull(unmarshalledExperimentRuns);
        assertEquals(1, unmarshalledExperimentRuns.size());

        ExperimentRun unmarshalledExperimentRun = unmarshalledExperimentRuns.get(0);
        unmarshalledExperimentRun.setId(430L);
        assertNotNull(unmarshalledExperimentRun);
        assertEquals(unmarshalledExperimentRun, this.experiments.get(0).getExperimentRuns().get(0));
        assertEquals(unmarshalledExperimentRun.getLsid(), "${FolderLSIDBase}.${XarFileId}:IPAS14.IP0014_AX02");
        assertEquals(unmarshalledExperimentRun.getName(), "IP0014_AX02 (Mouse Pancreatic Cancer Study)");
        assertEquals(unmarshalledExperimentRun.getExperiment().getLsid(), "${FolderLSIDBase}:IPAS14");
        assertEquals(unmarshalledExperimentRun.getComments(), "Profiling of Proteins in Lung " +
                "Adenocarcinoma Cell Surface");

        assertNotNull(unmarshalledExperimentRun.getProperties());
        simpleTypeValues = unmarshalledExperimentRun.getProperties();
        assertNotNull(simpleTypeValues);
        assertEquals(1, simpleTypeValues.size());
        assertEquals(simpleTypeValues.get(0).getName(), "ExpRunType");
        assertEquals(simpleTypeValues.get(0).getOntologyEntryURI(), "terms.fhcrc.org#RunProtocolTypes.Something");
        assertEquals(simpleTypeValues.get(0).getValue(), "Some Experiment Run Property");
        assertEquals(simpleTypeValues.get(0).getValueType(), SimpleType.valueOf("String"));

        List<ProtocolApplication> protApplications = unmarshalledExperimentRun.getProtocolApplications();
        assertEquals(protApplications.size(), 2);

        ProtocolApplication unmarshalledProtApp1 = protApplications.get(0);
        unmarshalledProtApp1.setId(440L);
        assertNotNull(unmarshalledProtApp1);
        assertEquals(unmarshalledProtApp1, this.experiments.get(0).getExperimentRuns().get(0).getProtocolApplications().get(0));
        assertEquals(unmarshalledProtApp1.getComments(), null);
        assertEquals(unmarshalledProtApp1.getLsid(), "${RunLSIDBase}:IPAS14");
        assertEquals(unmarshalledProtApp1.getName(), "Do IPAS 14 protocol");

        assertEquals(unmarshalledProtApp1.getParameters().getOutputDataFileTemplate(), "Out Data File Template");
        assertEquals(unmarshalledProtApp1.getParameters().getAppNameTemplate(), "Do IPAS 14 protocol");

        assertNotNull(unmarshalledProtApp1.getProperties());
        simpleTypeValues = unmarshalledProtApp1.getProperties();
        assertNotNull(simpleTypeValues);
        assertEquals(1, simpleTypeValues.size());
        assertEquals(simpleTypeValues.get(0).getName(), "ProtAppFactorsCount");
        assertEquals(simpleTypeValues.get(0).getOntologyEntryURI(), "terms.fhcrc.org#RunProtocolTypes.Category");
        assertEquals(simpleTypeValues.get(0).getValue(), "2");
        assertEquals(simpleTypeValues.get(0).getValueType(), SimpleType.valueOf("Integer"));

        assertNotNull(unmarshalledProtApp1.getExperimentRun());
        assertEquals(unmarshalledProtApp1.getExperimentRun().getLsid(), "${FolderLSIDBase}.${XarFileId}:IPAS14.IP0014_AX02");
        assertEquals(unmarshalledProtApp1.getExperimentRun().getExperiment().getLsid(), "${FolderLSIDBase}:IPAS14");


    }

    @SuppressWarnings("unchecked")
    public void testLoadExampleFiles() throws Exception {
        String[] srcFiles = new String[] {"src/test/inputFiles/xarEmapleFile1.xar.xml",
                "src/test/inputFiles/xarEmapleFile2.xar.xml", "src/test/inputFiles/xarEmapleFile3.xar.xml",
                "src/test/inputFiles/xarEmapleFile4.xar.xml", };

        String[] names = new String[] {"Lung Adenocarcinoma Study",
                "Peroxisome membrane protein analysis, Marcello Marelli et al.", "Default Experiment",
                "caBIG Test Data" };

        for (int i = 0; i < srcFiles.length; i++) {
            List<Experiment> experiments = this.fcs.unmarshallExperiments(new File(srcFiles[i]));
            assertEquals(1, experiments.size());
            assertEquals(names[i], experiments.get(0).getName());
        }
    }
}