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
        ProtocolApplication protApp = new ProtocolApplication("Do IPAS 14 protocol", DatatypeConverter.parseDate("2006-08-31-07:00").getTime(), expRun, this.protocols.get(0));
        protApp.setId(440L);

        expRun.getProtocolApplications().add(protApp);

        // Another protocol application.
        protApp = new ProtocolApplication("Sample Preparation", DatatypeConverter.parseDate("2006-08-31-07:00").getTime(), expRun, this.protocols.get(1));
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
        assertEquals(unmarshalledProtApp1.getName(), "Do IPAS 14 protocol");

        assertNotNull(unmarshalledProtApp1.getExperimentRun());
    }
}