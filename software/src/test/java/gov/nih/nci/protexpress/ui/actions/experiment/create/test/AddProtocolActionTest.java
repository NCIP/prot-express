/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create.test;

import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.create.AddProtocolAction;
import gov.nih.nci.protexpress.ui.actions.experiment.create.CreateExperimentAction;
import gov.nih.nci.protexpress.util.UserHolder;
import gov.nih.nci.security.authorization.domainobjects.User;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * This class tests the CreateExperimentAction class.
 *
 * @author Krishna Kanchinadam
 */
public class AddProtocolActionTest extends ProtExpressBaseHibernateTest {

    AddProtocolAction action;
    User loggedInUser = new User();
    CreateExperimentAction createExperimentAction;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new AddProtocolAction();

        loggedInUser.setLoginName("foo");
        loggedInUser.setEmailId("foo@foo.com");
        loggedInUser.setFirstName("first");
        loggedInUser.setLastName("last");
        UserHolder.setUser(loggedInUser);

        this.createExperimentAction = new CreateExperimentAction();
        this.createExperimentAction.createNewExperiment();
        this.createExperimentAction.getExperiment().setName("Name - Test Experiment 1");
        this.createExperimentAction.getExperiment().setDescription("Description - Test Experiment 1");
        this.createExperimentAction.getExperiment().setHypothesis("Hypothesis - Test Experiment 1");
        this.createExperimentAction.getExperiment().setUrl("URL - Test Experiment 1");
        this.createExperimentAction.getExperiment().setDatePerformed(new Date());

        assertEquals(ActionSupport.SUCCESS, this.createExperimentAction.save());
        this.theSession.flush();
        this.theSession.clear();
        this.action.setExperiment(this.createExperimentAction.getExperiment());
        this.action.setExperimentRun(this.createExperimentAction.getExperimentRun());
    }

    public void testAddOrSelectProtocol() throws Exception {
        assertEquals(ActionSupport.INPUT, this.action.addOrSelectProtocol());
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

    public void testDoSearch() throws Exception {
        assertEquals("protocolSearchResults", this.action.doSearch());
    }

    public void testSave() throws Exception {
        assertEquals(ActionSupport.SUCCESS, this.action.save());
    }

    public void testSelectProtocolAndContinue() throws Exception {
        assertEquals(ActionSupport.SUCCESS, this.action.selectProtocolAndContinue());
    }

    public void testCopyProtocolAndContinue() throws Exception {
        assertEquals(ActionSupport.SUCCESS, this.action.copyProtocolAndContinue());
    }

}
