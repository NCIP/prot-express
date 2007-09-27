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
import gov.nih.nci.protexpress.data.persistent.ProtocolApplication;
import gov.nih.nci.protexpress.data.persistent.ProtocolType;
import gov.nih.nci.protexpress.service.FormatConversionService;
import gov.nih.nci.protexpress.test.ProtExpressBaseCsmTest;
import gov.nih.nci.protexpress.util.DateAdapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
        fcs = ProtExpressRegistry.getXar22FormatConversionService();

        setupProtocols();

        experiments = new ArrayList<Experiment>();
        experiments.add(getExperiment1());
        experiments.add(getExperiment2());
    }

    /**
     * Reads a xar file containing multiple experiments, gets list of Experiments,
     * performs assertions, and writes back to file.
     * @throws Exception the exception
     */
    @SuppressWarnings("unchecked")
    public void testUnmarshallAndMarshallFile() throws Exception {
        File inFile = new File(inputXARFile);
        List<Experiment> unmarshalledExperiments = fcs.unmarshallExperiments(inFile);
        assertExperiments(unmarshalledExperiments);

        File outFile = new File(outputXARFile1);
        fcs.marshallExperiments(unmarshalledExperiments, outFile);
    }

    @SuppressWarnings("unchecked")
     public void testMarshallAndUmarshallFile() throws Exception {
         File outFile = new File(outputXARFile2);
         List<Experiment> exp = new ArrayList<Experiment>();
         exp.add(getExperiment1());
         exp.add(getExperiment2());
         fcs.marshallExperiments(exp, outFile);

         List<Experiment> unmarshalledExperiments = fcs.unmarshallExperiments(outFile);
         assertEquals(2, unmarshalledExperiments.size());
         assertExperiments(unmarshalledExperiments);
     }

     @SuppressWarnings("unchecked")
     public void testMarshallAndUmarshallStream() throws Exception {
         ByteArrayOutputStream os = new ByteArrayOutputStream();
         fcs.marshallExperiments(experiments, os);
         List<Experiment> unmarshalledExperiments = fcs.unmarshallExperiments(new ByteArrayInputStream(os.toByteArray()));
         assertExperiments(unmarshalledExperiments);
     }

     private void setupProtocols() {
         protocols = new ArrayList<Protocol>();

         Protocol prot1 = new Protocol("${FolderLSIDBase}:Process.IPAS14", "IPAS14 Process", ProtocolType.valueOf("ExperimentRun"));
         prot1.setDescription("Prepare and run LCMS, including fractionation of the input sample.  Produces one mzXML file per fraction in a single directory.");
         prot1.setSoftware("this is the software....");
         prot1.setInstrument("This is the instrument.");

         Person person = new Person();
         person.setContactId("Dr. Tabb's Research Center' for Protocols");
         person.setFirstName("John");
         person.setLastName("Tabb");
         person.setEmail("tabb@research-center.com");
         person.setComments("Comment for a Person attached to Protocol Process.IPAS14");
         prot1.setPrimaryContact(person);

         protocols.add(prot1);
     }

    private Experiment getExperiment1() {
        // Setup first experiment.
        Experiment currentExperiment = new Experiment("${FolderLSIDBase}:IPAS14", "IPAS14 Experiment");
        currentExperiment.setComments("Mouse Pancreatic Cancer Research");
        currentExperiment.setHypothesis("Cancer can kill a mouse too.");
        currentExperiment.setUrl("http://testUrl1:8080/index.html");

     // Set Primary Contact
        Person person = new Person();
        person.setContactId("Jim's Laboratory");
        person.setFirstName("Jim");
        person.setLastName("Smith");
        person.setEmail("jim@smiths.net");
        currentExperiment.setPrimaryContact(person);

        // Set Experiment Runs
        ExperimentRun expRun = new ExperimentRun("${FolderLSIDBase}.${XarFileId}:IPAS14.IP0014_AX02", "IP0014_AX02 (Mouse Pancreatic Cancer Study)");
        expRun.setExperiment(currentExperiment);
        expRun.setComments("Profiling of Proteins in Lung Adenocarcinoma Cell Surface");

        // Set a Protocol Application
        ProtocolApplication protApp1 = new ProtocolApplication("${RunLSIDBase}:IPAS14", "Do IPAS 14 protocol", ProtocolType.valueOf("ExperimentRun"), 1, DateAdapter.getDateFromXmlString("2006-08-31-07:00"), protocols.get(0));

        List<ProtocolApplication> protApplications = new ArrayList<ProtocolApplication>();
        protApplications.add(protApp1);
        expRun.setProtocolApplications(protApplications);

        currentExperiment.getExperimentRuns().add(expRun);

        return currentExperiment;
    }

    private Experiment getExperiment2() {
        // Setup second experiment.
        Experiment currentExperiment = new Experiment("${FolderLSIDBase}:MS-MS-Searches", "MS-MS Searches on N-Linked Glycopeptide Purified Aliquots");
        currentExperiment.setComments("X!Comet scoring.  Jan 2005 Human IPI fasta.");
        currentExperiment.setHypothesis("Individual digests of identical aliquots will yield similar search results.");
        currentExperiment.setUrl("http://testUrl2:8080/index.html");

     // Set Experiment Runs
        ExperimentRun expRun = new ExperimentRun("${FolderLSIDBase}:MS2.aliquot_01", "MS2 Peptide Search Aliquot 01");
        expRun.setExperiment(currentExperiment);
        expRun.setComments("Profiling of Proteins in MS2 Peptide Search Aliquot 01");

        currentExperiment.getExperimentRuns().add(expRun);

        // Set Primary Contact
        Person person = new Person();
        person.setContactId("John's Research Center'");
        person.setFirstName("Jonathan");
        person.setLastName("Doe");
        person.setEmail("jdoe@research-center.com");
        currentExperiment.setPrimaryContact(person);

        return currentExperiment;
    }

    private void assertExperiments(List<Experiment> experiments) {
        assertEquals(2, experiments.size());
        assertExperiment1Values(experiments.get(0));
        assertExperiment2Values(experiments.get(1));
    }

    private void assertExperiment1Values(Experiment unmarshalledExperiment) {
        assertNotNull(unmarshalledExperiment);
        assertEquals(unmarshalledExperiment.getLsid(), "${FolderLSIDBase}:IPAS14");
        assertEquals(unmarshalledExperiment.getName(), "IPAS14 Experiment");
        assertEquals(unmarshalledExperiment.getHypothesis(), "Cancer can kill a mouse too.");
        assertEquals(unmarshalledExperiment.getUrl(), "http://testUrl1:8080/index.html");
        assertEquals(unmarshalledExperiment.getComments(), "Mouse Pancreatic Cancer Research");

        // Contact person for the experiment
        Person person = unmarshalledExperiment.getPrimaryContact();
        assertNotNull(person);
        assertEquals(person.getContactId(), "Jim's Laboratory");
        assertEquals(person.getFirstName(), "Jim");
        assertEquals(person.getLastName(), "Smith");
        assertEquals(person.getEmail(), "jim@smiths.net");

        List<ExperimentRun> unmarshalledExperimentRuns = unmarshalledExperiment.getExperimentRuns();
        assertNotNull(unmarshalledExperimentRuns);
        assertEquals(1, unmarshalledExperimentRuns.size());

        //Experiment Runs
        ExperimentRun unmarshalledExperimentRun = unmarshalledExperimentRuns.get(0);
        assertNotNull(unmarshalledExperimentRun);
        assertEquals(unmarshalledExperimentRun.getLsid(), "${FolderLSIDBase}.${XarFileId}:IPAS14.IP0014_AX02");
        assertEquals(unmarshalledExperimentRun.getName(), "IP0014_AX02 (Mouse Pancreatic Cancer Study)");
        assertEquals(unmarshalledExperimentRun.getExperiment().getLsid(), "${FolderLSIDBase}:IPAS14");
        assertEquals(unmarshalledExperimentRun.getComments(), "Profiling of Proteins in Lung " +
                "Adenocarcinoma Cell Surface");

        List<ProtocolApplication> protApplications = unmarshalledExperimentRun.getProtocolApplications();
        assertEquals(protApplications.size(), 1);

        ProtocolApplication unmarshalledProtApp1 = protApplications.get(0);
        assertNotNull(unmarshalledProtApp1);
        assertEquals(unmarshalledProtApp1.getActionSequence(), 1);
        assertEquals(unmarshalledProtApp1.getActivityDate(), DateAdapter.getDateFromXmlString("2006-08-31-07:00"));
        assertEquals(unmarshalledProtApp1.getComments(), null);
        assertEquals(unmarshalledProtApp1.getLsid(), "${RunLSIDBase}:IPAS14");
        assertEquals(unmarshalledProtApp1.getName(), "Do IPAS 14 protocol");
        assertEquals(unmarshalledProtApp1.getType(), ProtocolType.valueOf("ExperimentRun"));
        assertEquals(unmarshalledProtApp1.getProtocol().getLsid(), "${FolderLSIDBase}:Process.IPAS14");

        Protocol prot1 = unmarshalledProtApp1.getProtocol();
        assertNotNull(prot1);
        assertEquals(prot1.getLsid(), "${FolderLSIDBase}:Process.IPAS14");
        assertEquals(prot1.getType(), ProtocolType.valueOf("ExperimentRun"));
        assertEquals(prot1.getName(), "IPAS14 Process");
        assertEquals(prot1.getDescription(), "Prepare and run LCMS, including fractionation of the input sample.  Produces one mzXML file per fraction in a single directory.");
        assertEquals(prot1.getInstrument(), "This is the instrument.");
        assertEquals(prot1.getSoftware(), "this is the software....");
        assertEquals(prot1.getOutputDataType(), "Data");
        assertEquals(prot1.getOutputMaterialType(), "Material");

        Person prot1Contact = prot1.getPrimaryContact();
        assertNotNull(prot1Contact);
        assertEquals(prot1Contact.getContactId(), "Dr. Tabb's Research Center' for Protocols");
        assertEquals(prot1Contact.getFirstName(), "John");
        assertEquals(prot1Contact.getLastName(), "Tabb");
        assertEquals(prot1Contact.getEmail(), "tabb@research-center.com");
        // TODO: Check to see if a property COMMENTS is in the output XML File
    }

    private void assertExperiment2Values(Experiment unmarshalledExperiment) {
        assertNotNull(unmarshalledExperiment);
        assertEquals(unmarshalledExperiment.getLsid(), "${FolderLSIDBase}:MS-MS-Searches");
        assertEquals(unmarshalledExperiment.getName(), "MS-MS Searches on N-Linked Glycopeptide Purified Aliquots");
        assertEquals(unmarshalledExperiment.getHypothesis(), "Individual digests of identical aliquots will yield " +
                "similar search results.");
        assertEquals(unmarshalledExperiment.getUrl(), "http://testUrl2:8080/index.html");
        assertEquals(unmarshalledExperiment.getComments(), "X!Comet scoring.  Jan 2005 Human IPI fasta.");

        //Person
        Person person = unmarshalledExperiment.getPrimaryContact();
        assertNotNull(person);
        assertEquals(person.getContactId(), "John's Research Center'");
        assertEquals(person.getFirstName(), "Jonathan");
        assertEquals(person.getLastName(), "Doe");
        assertEquals(person.getEmail(), "jdoe@research-center.com");

        List<ExperimentRun> unmarshalledExperimentRuns = unmarshalledExperiment.getExperimentRuns();
        assertNotNull(unmarshalledExperimentRuns);
        assertEquals(1, unmarshalledExperimentRuns.size());

        // Experiment Runs
        ExperimentRun unmarshalledExperimentRun = unmarshalledExperimentRuns.get(0);
        assertNotNull(unmarshalledExperimentRun);
        assertEquals(unmarshalledExperimentRun.getLsid(), "${FolderLSIDBase}:MS2.aliquot_01");
        assertEquals(unmarshalledExperimentRun.getName(), "MS2 Peptide Search Aliquot 01");
        assertEquals(unmarshalledExperimentRun.getExperiment().getLsid(), "${FolderLSIDBase}:MS-MS-Searches");
        assertEquals(unmarshalledExperimentRun.getComments(), "Profiling of Proteins in MS2 Peptide Search Aliquot 01");

        List<ProtocolApplication> protApplications = unmarshalledExperimentRun.getProtocolApplications();
        assertEquals(protApplications.size(), 0);
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
            List<Experiment> experiments = fcs.unmarshallExperiments(new File(srcFiles[i]));
            assertEquals(1, experiments.size());
            assertEquals(names[i], experiments.get(0).getName());
        }
    }
}