/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.create.CreateExperimentAction;
import gov.nih.nci.protexpress.util.SessionHelper;
import gov.nih.nci.protexpress.util.UserHolder;
import gov.nih.nci.security.authorization.domainobjects.User;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * This class tests the CreateExperimentAction class.
 *
 * @author Krishna Kanchinadam
 */
public class CreateExperimentActionTest extends ProtExpressBaseHibernateTest {

    CreateExperimentAction action;
    Experiment experiment;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new CreateExperimentAction();
        SessionHelper.saveExperimentIdInSession(null);
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

    public void testCreateNewExperiment() throws Exception {
        User loggedInUser = new User();
        loggedInUser.setLoginName("foo");
        loggedInUser.setEmailId("foo@foo.com");
        loggedInUser.setFirstName("first");
        loggedInUser.setLastName("last");
        UserHolder.setUser(loggedInUser);

        this.action.createNewExperiment();

        assertNull(SessionHelper.getExperimentIdFromSession());
        assertNull(SessionHelper.getProtocolApplicationFromSession());

        assertEquals(this.action.getExperiment().getContactPerson().getFirstName(), loggedInUser.getFirstName());
        assertEquals(this.action.getExperiment().getContactPerson().getLastName(), loggedInUser.getLastName());
        assertEquals(this.action.getExperiment().getContactPerson().getEmail(), loggedInUser.getEmailId());
    }

    public void testReloadExperiment() throws Exception {
        assertEquals(this.action.reloadExperiment(), ActionSupport.INPUT);
    }

    public void testViewExperimentSummary() throws Exception {
        assertEquals(this.action.viewExperimentSummary(), "viewExperimentSummary");
    }

    public void testSave() throws Exception {
        this.action.createNewExperiment();
        this.action.getExperiment().setName("Name - Test Experiment 1");
        this.action.getExperiment().setDescription("Description - Test Experiment 1");
        this.action.getExperiment().setHypothesis("Hypothesis - Test Experiment 1");
        this.action.getExperiment().setUrl("URL - Test Experiment 1");
        this.action.getExperiment().setDatePerformed(new Date());

        assertEquals(ActionSupport.SUCCESS, this.action.save());
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testRepeat() throws Exception {
        this.action.createNewExperiment();
        this.action.getExperiment().setName("Name - Test Experiment 1");
        this.action.getExperiment().setDescription("Description - Test Experiment 1");
        this.action.getExperiment().setHypothesis("Hypothesis - Test Experiment 1");
        this.action.getExperiment().setUrl("URL - Test Experiment 1");
        this.action.getExperiment().setDatePerformed(new Date());

        assertEquals(ActionSupport.SUCCESS, this.action.save());
        assertEquals(1, this.action.getExperiment().getExperimentRuns().size());
        assertEquals("editExperiment", this.action.repeat());
        assertEquals(this.action.getExperiment().getId(), this.action.getExperimentId());
    }
}
