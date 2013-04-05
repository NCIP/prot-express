/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.create.CreateExperimentAction;

/**
 * This class tests the ManageExperimentAction class.
 *
 * @author Krishna Kanchinadam
 */
public class ManageExperimentActionTest extends ProtExpressBaseHibernateTest {

    CreateExperimentAction action;
    Experiment experiment;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new CreateExperimentAction();

        this.experiment = new Experiment("Name - Test Experiment 1");
        this.experiment.setDescription("Description - Test Experiment 1");
        this.experiment.setHypothesis("Hypothesis - Test Experiment 1");
        this.experiment.setUrl("URL - Test Experiment 1");

        this.theSession.saveOrUpdate(this.experiment);
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperiment(null);
        this.action.prepare();
        assertEquals(null, this.action.getExperiment());

        Experiment p = new Experiment(null);
        this.action.setExperiment(p);
        this.action.prepare();
        assertEquals(p, this.action.getExperiment());
    }

    public void testSaveOrUpdate() throws Exception {
        this.action.setExperiment(new Experiment("Test Experiment"));
        assertEquals("success", this.action.save());
        assertEquals(this.theSession.get(Experiment.class, this.action.getExperiment().getId()), this.action.getExperiment());
    }
}
