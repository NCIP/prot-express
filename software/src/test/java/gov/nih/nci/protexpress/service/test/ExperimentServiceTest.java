/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.test;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.util.UserHolder;

import java.util.Date;
import java.util.List;

import org.displaytag.properties.SortOrderEnum;



/**
 * @author Krishna Kanchinadam
 */
public class ExperimentServiceTest extends ProtExpressBaseHibernateTest {

    @SuppressWarnings("unchecked")
    public void testSaveRetrieveDeleteExperiment() throws Exception {
        Experiment exp1 = new Experiment("Name - Test Experiment 1");
        exp1.setDescription("Description - Test Experiment 1");
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
        exp.setDescription("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);

        exp = new Experiment("test experiment 12");
        exp.setDescription("bar 12");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);

        exp = new Experiment("test experiment 123");
        exp.setDescription("bar 1");
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

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0, "description",
                SortOrderEnum.ASCENDING);
        lastVal = null;
        for (Experiment exp1 : experimentList) {
            if (lastVal != null) {
                assertTrue(exp1.getDescription().compareTo(lastVal) >= 0);
            }
            lastVal = exp1.getDescription();
        }

        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(null, 10, 0, "description",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        for (Experiment exp1 : experimentList) {
            if (lastVal != null) {
                assertTrue(exp1.getDescription().compareTo(lastVal) <= 0);
            }
            lastVal = exp1.getDescription();
        }

        SearchParameters exparams = new SearchParameters();
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

        exparams.setName("periment 12");
        experimentList = ProtExpressRegistry.getExperimentService().searchForExperiments(exparams, 10, 0, null, null);
        assertEquals(2, experimentList.size());
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

        experiment1.setDescription("new comments");
        this.theSession.update(experiment1);
        this.theSession.flush();
        Thread.sleep(100);

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
        exp1.setDescription("Description - Test Experiment 1");
        exp1.setHypothesis("Hypothesis - Test Experiment 1");
        exp1.setUrl("URL - Test Experiment 1");

        assertFalse(exp1.equals(null));
        assertFalse(exp1.equals(new String("Foo")));
        assertTrue(exp1.equals(exp1));
       // assertEquals(exp1.hashCode(), new Experiment("Name - Test Experiment 1").hashCode());
    }

    @SuppressWarnings("unchecked")
    public void testAddAndDeleteExperimentRun() throws Exception {
        Experiment exp = new Experiment("test experiment 1");
        exp.setDescription("bar 123");
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
        exp.setDescription("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(exp);
        this.theSession.flush();
        this.theSession.clear();

        ExperimentRun experimentRun = new ExperimentRun("test er1");
        experimentRun.setExperiment(exp);
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(experimentRun);

        this.theSession.flush();
        this.theSession.clear();

        ProtocolApplication pa = new ProtocolApplication(new Date(), experimentRun, p);
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
