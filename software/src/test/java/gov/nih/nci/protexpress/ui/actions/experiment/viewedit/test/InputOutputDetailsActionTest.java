/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.InputOutputDetailsAction;

/**
 * This class tests the ProtocolApplicationDetailsAction class.
 *
 * @author Krishna Kanchinadam
 */
public class InputOutputDetailsActionTest extends ProtExpressBaseHibernateTest {

    InputOutputDetailsAction action;
    Experiment experiment;
    ExperimentRun experimentRun;
    Protocol protocol;
    ProtocolApplication protApp;
    InputOutputObject ioObj;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new InputOutputDetailsAction();

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

        this.ioObj = new InputOutputObject("IO Object");
        this.theSession.saveOrUpdate(this.ioObj);
        assertNotNull(this.ioObj.getId());

        this.protApp.getInputs().add(this.ioObj);
        this.theSession.saveOrUpdate(this.protApp);

        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperimentRunId(this.experimentRun.getId());
        this.action.setExperimentId(this.experiment.getId());
        this.action.setProtocolApplicationId(this.protApp.getId());
        this.action.setInputOutputObjectId(this.ioObj.getId());
        this.action.prepare();
        assertNotNull(this.action.getExperiment());
        assertEquals("Name - Test Experiment 1", this.action.getExperiment().getName());
        assertNotNull(this.action.getExperimentRun());
        assertEquals(this.action.getExperimentRun().getExperiment(), this.action.getExperiment());
        assertNotNull(this.action.getProtocolApplication());
        assertNotNull(this.action.getInputOutputObject());
    }

    public void testSaveInput() throws Exception {
        this.testPrepare();
        assertEquals("success", this.action.saveInput());
        assertEquals("Input successfully updated.", this.action.getSuccessMessage());
    }

    public void testSaveOutput() throws Exception {
        this.testPrepare();
        assertEquals("success", this.action.saveOutput());
        assertEquals("Output successfully updated.", this.action.getSuccessMessage());
    }

   public void testDeleteInput() throws Exception {
       this.testPrepare();
       assertEquals("delete", this.action.deleteOutput());
       assertEquals("Output successfully deleted.", this.action.getSuccessMessage());
    }

   public void testDeleteOutput() throws Exception {
       this.testPrepare();
       assertEquals("delete", this.action.deleteOutput());
       assertEquals("Output successfully deleted.", this.action.getSuccessMessage());
   }

 }
