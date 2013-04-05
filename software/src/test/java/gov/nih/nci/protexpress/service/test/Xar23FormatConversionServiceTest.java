/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.test;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.service.FormatConversionService;
import gov.nih.nci.protexpress.test.ProtExpressBaseCsmTest;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;


/**
 * Class to test the xar 23 conversion service.
 *
 * @author Scott Miller
 */
public class Xar23FormatConversionServiceTest extends ProtExpressBaseCsmTest {
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
        this.fcs = ProtExpressRegistry.getXar23FormatConversionService();
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

    }

    @SuppressWarnings("unchecked")
    public void testMarshallAndUmarshallFile() throws Exception {

    }

    @SuppressWarnings("unchecked")
    public void testMarshallAndUmarshallStream() throws Exception {

    }

    @SuppressWarnings("unchecked")
    public void testLoadExampleFiles() throws Exception {

    }


     private void setupProtocols() {
         this.protocols = new ArrayList<Protocol>();

         Protocol prot1 = new Protocol("IPAS14 Process");
         prot1.setId(100L);
         prot1.setDescription("Prepare and run LCMS, including fractionation of the input sample.  Produces one mzXML file per fraction in a single directory.");
         prot1.setSoftware("this is the software....");
         prot1.setInstrument("This is the instrument.");

         ContactPerson person = new ContactPerson();
         person.setFirstName("John");
         person.setLastName("Tabb");
         person.setEmail("tabb@research-center.com");
         prot1.setContactPerson(person);

         this.protocols.add(prot1);

         prot1 = new Protocol("Sample Prep");
         prot1.setId(101L);
         prot1.setDescription("unspecified");
         this.protocols.add(prot1);

     }

    private Experiment getExperiment1() {
        // Setup first experiment.
        Experiment currentExperiment = new Experiment("IPAS14 Experiment");
        currentExperiment.setId(400L);
        currentExperiment.setDescription("Mouse Pancreatic Cancer Research");
        currentExperiment.setHypothesis("Cancer can kill a mouse too.");
        currentExperiment.setUrl("http://testUrl1:8080/index.html");

     // Set Primary Contact
        ContactPerson person = new ContactPerson();
        person.setFirstName("Jim");
        person.setLastName("Smith");
        person.setEmail("jim@smiths.net");

        currentExperiment.setContactPerson(person);

        // Set Starting Input Definitions.

        // Set Experiment Runs
        ExperimentRun expRun = new ExperimentRun("IP0014_AX02 (Mouse Pancreatic Cancer Study)");
        expRun.setId(430L);
        expRun.setExperiment(currentExperiment);
        expRun.setNotes("Profiling of Proteins in Lung Adenocarcinoma Cell Surface");

        // Set a Protocol Application
        ProtocolApplication protApp = new ProtocolApplication(DatatypeConverter.parseDate("2006-08-31-07:00").getTime(), expRun, this.protocols.get(0));
        protApp.setId(440L);

        expRun.getProtocolApplications().add(protApp);

        // Another protocol application.
        protApp = new ProtocolApplication(DatatypeConverter.parseDate("2006-08-31-07:00").getTime(), expRun, this.protocols.get(1));
        protApp.setId(441L);

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
        assertEquals(unmarshalledExperiment.getName(), "IPAS14 Experiment");
        assertEquals(unmarshalledExperiment.getHypothesis(), "Cancer can kill a mouse too.");
        assertEquals(unmarshalledExperiment.getUrl(), "http://testUrl1:8080/index.html");
        assertEquals(unmarshalledExperiment.getDescription(), "Mouse Pancreatic Cancer Research");

        // Contact person for the experiment
        ContactPerson person = unmarshalledExperiment.getContactPerson();
        assertNotNull(person);
        assertEquals(person, this.experiments.get(0).getContactPerson());
        assertEquals(person.getFirstName(), "Jim");
        assertEquals(person.getLastName(), "Smith");
        assertEquals(person.getEmail(), "jim@smiths.net");

        Experiment exp1 = this.experiments.get(0);
        exp1.setId(400L);
        assertNotNull(exp1);

        //Experiment Runs
        List<ExperimentRun> unmarshalledExperimentRuns = unmarshalledExperiment.getExperimentRuns();
        assertNotNull(unmarshalledExperimentRuns);
        assertEquals(1, unmarshalledExperimentRuns.size());

        ExperimentRun unmarshalledExperimentRun = unmarshalledExperimentRuns.get(0);
        unmarshalledExperimentRun.setId(430L);
        assertNotNull(unmarshalledExperimentRun);
        assertEquals(unmarshalledExperimentRun, this.experiments.get(0).getExperimentRuns().get(0));
        assertEquals(unmarshalledExperimentRun.getName(), "IP0014_AX02 (Mouse Pancreatic Cancer Study)");
        assertEquals(unmarshalledExperimentRun.getNotes(), "Profiling of Proteins in Lung " +
                "Adenocarcinoma Cell Surface");

        List<ProtocolApplication> protApplications = unmarshalledExperimentRun.getProtocolApplications();
        assertEquals(protApplications.size(), 2);

        ProtocolApplication unmarshalledProtApp1 = protApplications.get(0);
        unmarshalledProtApp1.setId(440L);
        assertNotNull(unmarshalledProtApp1);
        assertEquals(unmarshalledProtApp1, this.experiments.get(0).getExperimentRuns().get(0).getProtocolApplications().get(0));
        assertEquals(unmarshalledProtApp1.getNotes(), null);

        assertNotNull(unmarshalledProtApp1.getExperimentRun());
    }
}