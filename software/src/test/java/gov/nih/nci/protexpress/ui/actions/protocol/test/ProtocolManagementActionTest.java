/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.protocol.test;

import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.protocol.ProtocolManagementAction;

import org.apache.commons.lang.builder.EqualsBuilder;

import com.opensymphony.xwork2.ActionSupport;

/**
 * This class tests the ProtocolManagementAction.
 *
 * @author Scott Miller
 */
public class ProtocolManagementActionTest extends ProtExpressBaseHibernateTest {

    ProtocolManagementAction action;
    Protocol protocol;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new ProtocolManagementAction();

        this.protocol = new Protocol("test protocol 1");
        this.protocol.setInstrument("foo");
        this.protocol.setDescription("bar");
        this.protocol.setSoftware("baz");

        this.theSession.saveOrUpdate(this.protocol);
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setProtocol(null);
        this.action.prepare();
        assertEquals(null, this.action.getProtocol());

        Protocol p = new Protocol(null);
        this.action.setProtocol(p);
        this.action.prepare();
        assertEquals(p, this.action.getProtocol());

        this.action.getProtocol().setId(this.protocol.getId());
        this.action.prepare();
        assertEquals(this.theSession.get(Protocol.class, this.protocol.getId()), this.action.getProtocol());
        assertTrue(EqualsBuilder.reflectionEquals(this.theSession.get(Protocol.class, this.protocol.getId()),
                this.action.getProtocol()));
    }

    public void testLoad() throws Exception {
        assertEquals(ActionSupport.INPUT, this.action.load());
    }

    public void testSaveOrUpdate() throws Exception {
        this.action.setProtocol(new Protocol("zzz"));
        assertEquals(ActionSupport.SUCCESS, this.action.save());
        assertEquals(this.theSession.get(Protocol.class, this.action.getProtocol().getId()), this.action.getProtocol());
    }

    public void testSaveOrUpdateReturnToDashboard() throws Exception {
        this.action.setCancelResult("dashboard");
        this.action.setProtocol(new Protocol("zzz"));
        assertEquals(ActionSupport.SUCCESS, this.action.save());
        assertEquals(this.theSession.get(Protocol.class, this.action.getProtocol().getId()), this.action.getProtocol());
        assertEquals("Protocol successfully saved.", this.action.getSuccessMessage());

        Protocol p = this.action.getProtocol();
        this.action = new ProtocolManagementAction();
        p.setName("Updated test name");
        this.action.setProtocol(p);
        assertEquals(ActionSupport.SUCCESS, this.action.save());
        assertEquals("Protocol successfully updated.", this.action.getSuccessMessage());
    }

    public void testDelete() throws Exception {
        this.action.setProtocol((Protocol) this.theSession.get(Protocol.class, this.protocol.getId()));
        assertEquals("deleteProtocol", this.action.deleteProtocol());
        assertEquals("Protocol successfully deleted.", this.action.getSuccessMessage());
        this.theSession.flush();
        this.theSession.clear();
        assertEquals(0, this.theSession.createQuery("from " + Protocol.class.getName()).list().size());
    }

    public void testCancel() throws Exception {
        assertEquals("cancel", this.action.cancel());
    }
}
