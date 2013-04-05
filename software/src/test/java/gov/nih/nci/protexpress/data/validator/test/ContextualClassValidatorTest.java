/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.data.validator.test;

import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.data.validator.ContextualClassValidator;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;

/**
 * @author Scott Miller
 *
 */
public class ContextualClassValidatorTest extends ProtExpressBaseHibernateTest {

    private Protocol protocol1;
    private Protocol protocol2;
    ContextualClassValidator<Protocol> classValidator = new ContextualClassValidator<Protocol>(Protocol.class);

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();

        this.protocol1 = new Protocol("test name 1");
        this.protocol2 = new Protocol("test name 2");
        this.theSession.save(this.protocol1);
        this.theSession.save(this.protocol2);
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testValidObject() {
        Protocol p = new Protocol("valid name");
        assertEquals(0, this.classValidator.getInvalidValues(p).length);
    }

    public void testInvalidObject() {
        Protocol p = new Protocol("valid name");
        assertEquals(0, this.classValidator.getInvalidValues(p).length);
        assertEquals(0, this.classValidator.getInvalidValues(p, "name").length);
    }

    public void testUpdateObject() {
        this.protocol1.setName("new valid name");
        assertEquals(0, this.classValidator.getInvalidValues(this.protocol1).length);
        assertEquals(0, this.classValidator.getInvalidValues(this.protocol1, "name").length);
    }
}
