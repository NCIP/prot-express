package gov.nih.nci.protexpress.service.test;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.data.persistent.Experiment;
import gov.nih.nci.protexpress.data.persistent.ExperimentRun;
import gov.nih.nci.protexpress.data.persistent.Protocol;
import gov.nih.nci.protexpress.data.persistent.ProtocolApplication;
import gov.nih.nci.protexpress.service.ExperimentSearchParameters;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.util.UserHolder;

import java.util.Calendar;
import java.util.List;

import org.displaytag.properties.SortOrderEnum;

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

/**
 * @author Krishna Kanchinadam
 */
public class ExperimentServiceTest extends ProtExpressBaseHibernateTest {

    @SuppressWarnings("unchecked")
    public void testSaveRetrieveDeleteExperiment() throws Exception {
        Experiment exp1 = new Experiment("Name - Test Experiment 1");
        exp1.setComments("Description - Test Experiment 1");
        exp1.setHypothesis("Hypothesis - Test Experiment 1");
        exp1.setUrl("URL - Test Experiment 1");

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp1);

        this.theSession.flush();
        this.theSession.clear();

        Experiment exp2 = ProtExpressRegistry.getExperimentService().getExperimentById(exp1.getId());
        assertEquals(exp1, exp2);

        ProtExpressRegistry.getExperimentService().deleteExperiment(exp2);

        this.theSession.flush();
        this.theSession.clear();

        List<Experiment> experimentList = this.theSession.createQuery("from " + Experiment.class.getName()).list();
        assertEquals(0, experimentList.size());
    }

    @SuppressWarnings("unchecked")
    public void testSearchExperiments() throws Exception {
        Experiment exp = new Experiment("test experiment 1");
        exp.setComments("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);

        exp = new Experiment("test experiment 12");
        exp.setComments("bar 12");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);

        exp = new Experiment("test experiment 123");
        exp.setComments("bar 1");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);

        this.theSession.flush();
        this.theSession.clear();

        List<Experiment> experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0,
                null, null);
        assertEquals(3, experimentList.size());
        assertEquals(3, ProtExpressRegistry.getExperimentService().countMatchingExperiments(null));

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0, "name",
                SortOrderEnum.ASCENDING);
        String lastVal = null;
        for (Experiment exp1 : experimentList) {
            if (lastVal != null) {
                assertTrue(exp1.getName().compareTo(lastVal) >= 0);
            }
            lastVal = exp1.getName();
        }

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0, "name",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        for (Experiment exp1 : experimentList) {
            if (lastVal != null) {
                assertTrue(exp1.getName().compareTo(lastVal) <= 0);
            }
            lastVal = exp1.getName();
        }

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0, "comments",
                SortOrderEnum.ASCENDING);
        lastVal = null;
        for (Experiment exp1 : experimentList) {
            if (lastVal != null) {
                assertTrue(exp1.getComments().compareTo(lastVal) >= 0);
            }
            lastVal = exp1.getComments();
        }

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0, "comments",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        for (Experiment exp1 : experimentList) {
            if (lastVal != null) {
                assertTrue(exp1.getComments().compareTo(lastVal) <= 0);
            }
            lastVal = exp1.getComments();
        }

        ExperimentSearchParameters exparams = new ExperimentSearchParameters();
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(3, experimentList.size());
        assertEquals(3, ProtExpressRegistry.getExperimentService().countMatchingExperiments(exparams));

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 2, 0, null, null);
        assertEquals(2, experimentList.size());
        assertEquals(3, ProtExpressRegistry.getExperimentService().countMatchingExperiments(exparams));

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 2, 1, null, null);
        assertEquals(2, experimentList.size());

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 2, null, null);
        assertEquals(1, experimentList.size());

        exparams.setName("a");
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(0, experimentList.size());

        exparams.setName("t experim");
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(3, experimentList.size());

        exparams.setComments("ar ");
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(3, experimentList.size());

        exparams.setName("periment 12");
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(2, experimentList.size());

        exparams.setComments("r 12");
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(1, experimentList.size());
    }

    public void testGetMostRecentExperiments() throws Exception {
        List<Experiment> experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), 3);
        assertEquals(0, experiments.size());

        Experiment experiment1 = new Experiment("ex1");
        this.theSession.save(experiment1);
        this.theSession.flush();
        Thread.sleep(100);

        experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(1, experiments.size());
        assertEquals(experiment1, experiments.get(0));

        Experiment experiment2 = new Experiment("ex2");
        this.theSession.save(experiment2);
        this.theSession.flush();
        Thread.sleep(100);

        experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(2, experiments.size());
        assertEquals(experiment2, experiments.get(0));
        assertEquals(experiment1, experiments.get(1));

        Experiment experiment3 = new Experiment("ex3");
        this.theSession.save(experiment3);
        this.theSession.flush();
        Thread.sleep(100);

        experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(2, experiments.size());
        assertEquals(experiment3, experiments.get(0));
        assertEquals(experiment2, experiments.get(1));

        experiment1.setComments("new comments");
        this.theSession.update(experiment1);
        this.theSession.flush();

        experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(2, experiments.size());
        assertEquals(experiment1, experiments.get(0));
        assertEquals(experiment3, experiments.get(1));

        experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), 5);
        assertEquals(3, experiments.size());
        assertEquals(experiment1, experiments.get(0));
        assertEquals(experiment3, experiments.get(1));
        assertEquals(experiment2, experiments.get(2));


        experiments = ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser("unuseduser", 3);
        assertEquals(0, experiments.size());
    }

    public void testEqualsAndHashCode() {
        assertFalse(new Experiment("TestExperiment1").equals(new Experiment(
                "TestExperiment1")));
        Experiment exp1 = new Experiment("Name - Test Experiment 1");
        exp1.setComments("Description - Test Experiment 1");
        exp1.setHypothesis("Hypothesis - Test Experiment 1");
        exp1.setUrl("URL - Test Experiment 1");

        assertFalse(exp1.equals(null));
        assertFalse(exp1.equals(new String("Foo")));
        assertTrue(exp1.equals(exp1));
        assertEquals(exp1.hashCode(), new Experiment("Name - Test Experiment 1").hashCode());
    }

    @SuppressWarnings("unchecked")
    public void testAddAndDeleteExperimentRun() throws Exception {
        Experiment exp = new Experiment("test experiment 1");
        exp.setComments("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);
        this.theSession.flush();
        this.theSession.clear();

        ExperimentRun experimentRun = new ExperimentRun("test er1");
        experimentRun.setExperiment(exp);
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(experimentRun);

        this.theSession.flush();
        this.theSession.clear();

        ExperimentRun retrievedExperimentRun = ProtExpressRegistry.getExperimentService().getExperimentRunById(experimentRun.getId());
        assertEquals(retrievedExperimentRun, experimentRun);

        ProtExpressRegistry.getExperimentService().deleteExperimentRun(retrievedExperimentRun);

        this.theSession.flush();
        this.theSession.clear();

        List<ExperimentRun> experimentRuns = this.theSession.createQuery("from " + ExperimentRun.class.getName()).list();
        assertEquals(0, experimentRuns.size());
    }

    @SuppressWarnings("unchecked")
    public void testAddAndDeleteProtocolApplication() throws Exception {
        Protocol p = new Protocol("test protocol 1");
        p.setInstrument("foo");
        p.setDescription("bar");
        p.setSoftware("baz");

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);
        this.theSession.flush();
        this.theSession.clear();

        Experiment exp = new Experiment("test experiment 1");
        exp.setComments("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);
        this.theSession.flush();
        this.theSession.clear();

        ExperimentRun experimentRun = new ExperimentRun("test er1");
        experimentRun.setExperiment(exp);
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(experimentRun);

        this.theSession.flush();
        this.theSession.clear();

        ProtocolApplication pa = new ProtocolApplication("protocol application name", Calendar.getInstance(), experimentRun, p);
        pa.setComments("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(pa);
        this.theSession.flush();
        this.theSession.clear();

        ProtocolApplication retrievedProtocolApplication = ProtExpressRegistry.getExperimentService().getProtocolApplicationById(pa.getId());
        assertEquals(retrievedProtocolApplication, pa);

        ProtExpressRegistry.getExperimentService().deleteProtocolApplication(retrievedProtocolApplication);

        this.theSession.flush();
        this.theSession.clear();

        List<ProtocolApplication> protocolApplications = this.theSession.createQuery("from " + ProtocolApplication.class.getName()).list();
        assertEquals(0, protocolApplications.size());
    }
}
