/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit.test;

import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.viewedit.ExperimentRunAddProtocolAction;

/**
 * This class tests the ExperimentRunAddProtocolAction class.
 *
 * @author Krishna Kanchinadam
 */
public class ExperimentRunAddProtocolActionTest extends ProtExpressBaseHibernateTest {

    ExperimentRunAddProtocolAction action;
    ContactPerson contactPerson;
    Experiment experiment;
    ExperimentRun experimentRun;
    Protocol protocol;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new ExperimentRunAddProtocolAction();

        contactPerson = new ContactPerson();
        contactPerson.setFirstName("Contact");
        contactPerson.setLastName("LastName");

        this.experiment = new Experiment("Name - Test Experiment 1");
        this.experiment.setDescription("Description - Test Experiment 1");
        this.experiment.setHypothesis("Hypothesis - Test Experiment 1");
        this.experiment.setUrl("URL - Test Experiment 1");
        this.experiment.setContactPerson(contactPerson);

        this.theSession.saveOrUpdate(this.experiment);
        this.experimentRun = new ExperimentRun("Run");
        this.experimentRun.setDatePerformed(this.experiment.getDatePerformed());
        this.experimentRun.setExperiment(this.experiment);
        this.theSession.saveOrUpdate(this.experimentRun);

        this.protocol = new Protocol("Prot1");
        this.protocol.setDescription("a new protocol");
        this.theSession.saveOrUpdate(this.protocol);
        assertNotNull(this.protocol.getId());

        assertNotNull(this.experiment.getId());
        assertNotNull(this.experimentRun.getId());
        assertNotNull(this.protocol.getId());
        assertNotNull(this.experimentRun.getExperiment());
        assertNotNull(this.experiment.getContactPerson());
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperimentId(this.experiment.getId());
        this.action.setExperimentRunId(this.experimentRun.getId());
        this.action.setProtocolId(this.protocol.getId());
        this.action.prepare();
        assertNotNull(this.action.getExperiment());
        assertEquals("Name - Test Experiment 1", this.action.getExperiment().getName());
        assertNotNull(this.action.getExperimentRun());
        assertEquals(this.action.getExperimentRun().getExperiment(), this.action.getExperiment());
        assertNotNull(this.action.getProtocol());
    }

    public void testAddNewProtocol() throws Exception {
        assertEquals("addNewProtocol", this.action.addNewProtocol());
    }

    public void testAddAnotherProtocol() throws Exception {
        assertEquals("addNewProtocol", this.action.addNewProtocol());
    }

    public void testSelectExistingProtocol() throws Exception {
        assertEquals("selectExistingProtocol", this.action.selectExistingProtocol());
    }

    public void testSearchProtocols() throws Exception {
        assertEquals("selectExistingProtocol", this.action.searchProtocols());
    }

    public void testSaveNewProtocol() throws Exception {
        this.testPrepare();
        this.action.prepare();
        assertEquals("editProtocolApplication", this.action.saveNewProtocol());
    }

    public void testSelectProtocolAndContinue() throws Exception {
        this.testPrepare();
        this.action.prepare();
        assertEquals("editProtocolApplication", this.action.selectProtocolAndContinue());
    }

    public void testCopyProtocolAndContinue() throws Exception {
        this.testPrepare();
        this.action.prepare();
        assertEquals("editProtocolApplication", this.action.copyProtocolAndContinue());
    }

}
