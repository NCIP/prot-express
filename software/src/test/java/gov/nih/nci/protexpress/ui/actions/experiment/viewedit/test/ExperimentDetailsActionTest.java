/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.ExperimentDetailsAction;

/**
 * This class tests the ExperimentDetailsAction class.
 *
 * @author Krishna Kanchinadam
 */
public class ExperimentDetailsActionTest extends ProtExpressBaseHibernateTest {

    ExperimentDetailsAction action;
    Experiment experiment;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new ExperimentDetailsAction();
        this.experiment = new Experiment("Name - Test Experiment 1");
        this.experiment.setDescription("Description - Test Experiment 1");
        this.experiment.setHypothesis("Hypothesis - Test Experiment 1");
        this.experiment.setUrl("URL - Test Experiment 1");

        this.theSession.saveOrUpdate(this.experiment);
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperimentId(this.experiment.getId());
        this.action.prepare();
        assertNotNull(this.action.getExperiment());
        assertEquals("Name - Test Experiment 1", this.action.getExperiment().getName());
    }

    public void testSaveExperiment() throws Exception {
        this.testPrepare();
        this.action.getExperiment().setName("Name Modified");
        this.action.getExperiment().setHypothesis("Hypothesis Modified");
        assertEquals("success", this.action.saveExperiment());
        assertEquals(this.theSession.get(Experiment.class, this.action.getExperiment().getId()), this.action.getExperiment());
        assertEquals("Name Modified", this.action.getExperiment().getName());
        assertEquals("Hypothesis Modified", this.action.getExperiment().getHypothesis());
    }

    public void testDelete() throws Exception {
        this.testPrepare();
        assertEquals("delete", this.action.delete());
        assertEquals("Experiment successfully deleted.", this.action.getSuccessMessage());
    }

}
