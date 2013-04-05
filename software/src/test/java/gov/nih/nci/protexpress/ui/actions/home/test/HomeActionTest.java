/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.home.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.home.HomeAction;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Test for the home action.
 * @author Krishna Kanchinadam
 */
public class HomeActionTest extends ProtExpressBaseHibernateTest {

    private HomeAction action;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new HomeAction();
    }

    public void testLoad() {
        Experiment e = new Experiment("e1");
        this.theSession.save(e);

        assertEquals(ActionSupport.SUCCESS, this.action.load());
        assertEquals(1, this.action.getRecentExperiments().size());
    }
}