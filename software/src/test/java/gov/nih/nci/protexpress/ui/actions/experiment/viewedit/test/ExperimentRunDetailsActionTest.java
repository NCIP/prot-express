/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.ExperimentRunDetailsAction;

/**
 * This class tests the ExperimentRunDetailsAction class.
 *
 * @author Krishna Kanchinadam
 */
public class ExperimentRunDetailsActionTest extends ProtExpressBaseHibernateTest {

    ExperimentRunDetailsAction action;
    Experiment experiment;
    ExperimentRun experimentRun;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new ExperimentRunDetailsAction();
        this.experiment = new Experiment("Name - Test Experiment 1");
        this.experiment.setDescription("Description - Test Experiment 1");
        this.experiment.setHypothesis("Hypothesis - Test Experiment 1");
        this.experiment.setUrl("URL - Test Experiment 1");

        this.theSession.saveOrUpdate(this.experiment);
        this.experimentRun = new ExperimentRun("Run");
        this.experimentRun.setDatePerformed(this.experiment.getDatePerformed());
        this.experimentRun.setExperiment(this.experiment);
        this.theSession.saveOrUpdate(this.experimentRun);

        assertNotNull(this.experiment.getId());
        assertNotNull(this.experimentRun.getId());
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperimentRunId(this.experimentRun.getId());
        this.action.setExperimentId(this.experiment.getId());
        this.action.prepare();
        assertNotNull(this.action.getExperiment());
        assertEquals("Name - Test Experiment 1", this.action.getExperiment().getName());
        assertNotNull(this.action.getExperimentRun());
        assertEquals(this.action.getExperimentRun().getExperiment(), this.action.getExperiment());
    }

    public void testSaveExperimentRun() throws Exception {
        this.testPrepare();
        this.action.getExperimentRun().setName("Run 1 of the experiment.");
        assertEquals("success", this.action.saveExperimentRun());
        assertEquals(this.theSession.get(ExperimentRun.class, this.action.getExperimentRun().getId()), this.action.getExperimentRun());
        assertEquals("Run 1 of the experiment.", this.action.getExperimentRun().getName());
    }

    public void testDelete() throws Exception {
        this.testPrepare();
        assertEquals("delete", this.action.delete());
        assertEquals("Experiment Run successfully deleted.", this.action.getSuccessMessage());
        assertEquals(0, this.action.getExperiment().getExperimentRuns().size());
    }

    public void testRepeat() throws Exception {
        this.testPrepare();
        assertEquals("editExperimentRun", this.action.repeat());
        assertEquals("Experiment Run successfully copied.", this.action.getSuccessMessage());
        this.action.prepare();
        assertEquals(2, this.action.getExperiment().getExperimentRuns().size());
    }
}
