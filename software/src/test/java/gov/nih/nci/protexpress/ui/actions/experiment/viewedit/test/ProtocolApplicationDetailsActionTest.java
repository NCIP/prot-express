/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.ExperimentDetailsAction;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.ExperimentRunDetailsAction;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.ProtocolApplicationDetailsAction;

/**
 * This class tests the ProtocolApplicationDetailsAction class.
 *
 * @author Krishna Kanchinadam
 */
public class ProtocolApplicationDetailsActionTest extends ProtExpressBaseHibernateTest {

    ProtocolApplicationDetailsAction action;
    Experiment experiment;
    ExperimentRun experimentRun;
    Protocol protocol;
    ProtocolApplication protApp;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new ProtocolApplicationDetailsAction();
        this.experiment = new Experiment("Name - Test Experiment 1");
        this.experiment.setDescription("Description - Test Experiment 1");
        this.experiment.setHypothesis("Hypothesis - Test Experiment 1");
        this.experiment.setUrl("URL - Test Experiment 1");
        this.theSession.saveOrUpdate(this.experiment);
        assertNotNull(this.experiment.getId());

        this.experimentRun = new ExperimentRun("Run");
        this.experimentRun.setDatePerformed(this.experiment.getDatePerformed());
        this.experimentRun.setExperiment(this.experiment);
        this.theSession.saveOrUpdate(this.experimentRun);
        assertNotNull(this.experimentRun.getId());

        this.protocol = new Protocol("Prot1");
        this.protocol.setDescription("a new protocol");
        this.theSession.saveOrUpdate(this.protocol);
        assertNotNull(this.protocol.getId());

        this.protApp = new ProtocolApplication(this.experimentRun.getDatePerformed(), this.experimentRun, this.protocol);
        this.protApp.setNotes("prot app notes");
        this.theSession.saveOrUpdate(this.protApp);
        assertNotNull(this.protApp.getId());

        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperimentRunId(this.experimentRun.getId());
        this.action.setExperimentId(this.experiment.getId());
        this.action.setProtocolApplicationId(this.protApp.getId());
        this.action.prepare();
        assertNotNull(this.action.getExperiment());
        assertEquals("Name - Test Experiment 1", this.action.getExperiment().getName());
        assertNotNull(this.action.getExperimentRun());
        assertEquals(this.action.getExperimentRun().getExperiment(), this.action.getExperiment());
        assertNotNull(this.action.getProtocolApplication());
    }

    public void testSaveProtocolApplicatoin() throws Exception {
        this.testPrepare();
        assertEquals("success", this.action.saveProtocolApplication());
        assertEquals("Protocol successfully updated.", this.action.getSuccessMessage());
    }

    public void testDelete() throws Exception {
        this.testPrepare();
        assertEquals("delete", this.action.delete());
        assertEquals("Protocol successfully deleted.", this.action.getSuccessMessage());
    }

   public void testDeleteInput() throws Exception {
       this.testPrepare();
       this.action.setDeleteIndex(0L);
       assertEquals("addInputs", this.action.deleteInput());
    }

   public void testDeleteOutput() throws Exception {
       this.testPrepare();
       this.action.setDeleteIndex(0L);
       assertEquals("addOutputs", this.action.deleteOutput());
   }

   public void testManageInputs() throws Exception {
       this.testPrepare();
       assertEquals("manageInputs", this.action.manageInputs());
   }

   public void testManageOutputs() throws Exception {
       this.testPrepare();
       assertEquals("addOutputs", this.action.manageOutputs());
   }

   public void testAddNewInput() throws Exception {
       this.testPrepare();
       assertEquals("addInputs", this.action.addNewInput());
   }

   public void testAddNewOutput() throws Exception {
       this.testPrepare();
       assertEquals("addOutputs", this.action.addNewOutput());
   }

   public void testAddExistingInput() throws Exception {
       this.testPrepare();
       assertEquals("addInputs", this.action.addExistingInput());
   }


}
