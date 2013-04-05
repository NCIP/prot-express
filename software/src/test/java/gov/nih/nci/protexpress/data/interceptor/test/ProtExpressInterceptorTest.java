/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.data.interceptor.test;

import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.security.IllegalModificationException;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.util.UserHolder;

/**
 * @author Scott Miller
 */
public class ProtExpressInterceptorTest extends ProtExpressBaseHibernateTest {

    public void testSaveAndUpdateAuditableObject() throws Exception {
        Protocol p = new Protocol("protocol1");
        this.theSession.save(p);
        assertEquals(UserHolder.getUsername(), p.getAuditInfo().getCreator());

        this.theSession.flush();
        this.theSession.clear();
    }

    public void testIllegalUpdate() {
        Protocol p = new Protocol("protocol1");
        this.theSession.save(p);
        this.theSession.flush();
        this.theSession.clear();

        p = (Protocol) this.theSession.load(Protocol.class, p.getId());

        try {
            UserHolder.setUser(null);
            this.theSession.delete(p);
            this.theSession.flush();
        } catch (IllegalModificationException e) {
            // expected
        }
    }

    public void testIllegalDeletee() {
        Protocol p = new Protocol("protocol1");
        this.theSession.save(p);
        this.theSession.flush();
        this.theSession.clear();

        p = (Protocol) this.theSession.load(Protocol.class, p.getId());

        try {
            UserHolder.setUser(null);
            p.setName("test change");
            this.theSession.update(p);
            this.theSession.flush();
        } catch (IllegalModificationException e) {
            // expected
        }
    }
}
