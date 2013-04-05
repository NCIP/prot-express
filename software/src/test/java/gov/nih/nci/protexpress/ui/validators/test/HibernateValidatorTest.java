/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.validators.test;

import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateAndStrutsTestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.ActionValidatorManager;
import com.opensymphony.xwork2.validator.ActionValidatorManagerFactory;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.ValidationParameter;

/**
 * This class tests the struts hibernate validator.
 *
 * @author Scott Miller
 */
public class HibernateValidatorTest extends ProtExpressBaseHibernateAndStrutsTestCase {
    private TestAction action;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new TestAction();
        this.action.setProtocol(new Protocol("test name 1"));
        this.action.setProtocol2(new Protocol("test name 2"));
    }

    public void testHibernateValidatorWithNullObject() throws Exception {
        this.action.setProtocol(null);
        ActionValidatorManager avm = ActionValidatorManagerFactory.getInstance();
        avm.validate(this.action, null);
        Map fieldErrors = this.action.getFieldErrors();

        assertFalse(this.action.hasErrors());
        assertEquals(0, fieldErrors.size());
    }

    public void testHibernateValidatorWithInvalidObject() throws Exception {
        this.action.setProtocol(new Protocol(null));
        ActionValidatorManager avm = ActionValidatorManagerFactory.getInstance();
        avm.validate(this.action, null);
        Map fieldErrors = this.action.getFieldErrors();

        assertTrue(this.action.hasErrors());
        assertEquals(1, fieldErrors.size());
        assertTrue(fieldErrors.containsKey("protocol.name"));
    }

    public void testHibernateValidatorWithValidObject() throws Exception {
        ActionValidatorManager avm = ActionValidatorManagerFactory.getInstance();
        avm.validate(this.action, null);
        Map fieldErrors = this.action.getFieldErrors();

        assertFalse(this.action.hasErrors());
        assertEquals(0, fieldErrors.size());
    }

    public void testHibernateValidatorListProcessing() throws Exception {
        this.action.getProtocolList().add(new Protocol("test name 3"));
        this.action.getProtocolList().add(new Protocol(null));
        this.action.getProtocolList().add(null);
        this.action.getProtocolList().add(new Protocol("test name 4"));

        ActionValidatorManager avm = ActionValidatorManagerFactory.getInstance();
        avm.validate(this.action, null);
        Map fieldErrors = this.action.getFieldErrors();

        assertTrue(this.action.hasErrors());
        assertEquals(1, fieldErrors.size());
        assertTrue(fieldErrors.containsKey("protocolList[1].name"));
    }

    public void testHibernateValidatorArrayProcessing() throws Exception {
        this.action.setProtocolArray(new Protocol[] { new Protocol("test name 3"),
                new Protocol(null), null, new Protocol("test name 4") });

        ActionValidatorManager avm = ActionValidatorManagerFactory.getInstance();
        avm.validate(this.action, null);
        Map fieldErrors = this.action.getFieldErrors();

        assertTrue(this.action.hasErrors());
        assertEquals(1, fieldErrors.size());
        assertTrue(fieldErrors.containsKey("protocolArray[1].name"));
    }

    /**
     * The action for this test case.
     */
    class TestAction extends ActionSupport {
        private static final long serialVersionUID = 1L;

        private Protocol protocol = new Protocol(null);
        private Protocol protocol2 = new Protocol(null);
        private Protocol[] protocolArray = null;
        private List<Protocol> protocolList = new ArrayList<Protocol>();

        /**
         * Test action does nothing.
         *
         * @return the directive for the next action / page to be directed to
         */
        @Override
        public String execute() {
            return ActionSupport.SUCCESS;
        }

        /**
         * @return the protocol
         */
        @CustomValidator(type = "hibernate")
        public Protocol getProtocol() {
            return this.protocol;
        }

        /**
         * @param protocol the protocol to set
         */
        public void setProtocol(Protocol protocol) {
            this.protocol = protocol;
        }

        /**
         * @return the protocol2
         */
        @CustomValidator(type = "hibernate", parameters = { @ValidationParameter(name = "appendPrefix", value = "false") })
        public Protocol getProtocol2() {
            return this.protocol2;
        }

        /**
         * @param protocol2 the protocol2 to set
         */
        public void setProtocol2(Protocol protocol2) {
            this.protocol2 = protocol2;
        }

        /**
         * @return the protocolArray
         */
        @CustomValidator(type = "hibernate")
        public Protocol[] getProtocolArray() {
            return this.protocolArray;
        }

        /**
         * @param protocolArray the protocolArray to set
         */
        public void setProtocolArray(Protocol[] protocolArray) {
            this.protocolArray = protocolArray;
        }

        /**
         * @return the protocolList
         */
        @CustomValidator(type = "hibernate")
        public List<Protocol> getProtocolList() {
            return this.protocolList;
        }

        /**
         * @param protocolList the protocolList to set
         */
        public void setProtocolList(List<Protocol> protocolList) {
            this.protocolList = protocolList;
        }
    }
}
