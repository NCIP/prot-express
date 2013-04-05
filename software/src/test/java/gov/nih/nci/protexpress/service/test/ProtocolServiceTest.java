/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.test;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.util.UserHolder;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;



/**
 * @author Scott Miller
 */
public class ProtocolServiceTest extends ProtExpressBaseHibernateTest {

    @SuppressWarnings("unchecked")
    public void testSaveRetrieveDeleteProtocol() throws Exception {
        Protocol p = new Protocol("test protocol 1");
        p.setInstrument("foo");
        p.setDescription("bar");
        p.setSoftware("baz");

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        this.theSession.flush();
        this.theSession.clear();

        Protocol p2 = ProtExpressRegistry.getProtocolService().getProtocolById(p.getId());
        assertEquals(p, p2);

        ProtExpressRegistry.getProtocolService().deleteProtocol(p2);

        this.theSession.flush();
        this.theSession.clear();

        List<Protocol> protocolList = this.theSession.createQuery("from " + Protocol.class.getName()).list();
        assertEquals(0, protocolList.size());
    }

    @SuppressWarnings("unchecked")
    public void testSearchProtocols() throws Exception {
        Protocol p = new Protocol("test protocol 1");
        p.setDescription("bar 123");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        p = new Protocol("test protocol 12");
        p.setDescription("bar 12");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        p = new Protocol("test protocol 123");
        p.setDescription("bar 1");
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(p);

        this.theSession.flush();
        this.theSession.clear();

        List<Protocol> protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, null,
                null);
        assertEquals(3, protocolList.size());
        assertEquals(3, ProtExpressRegistry.getProtocolService().countMatchingProtocols(null));

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "name",
                SortOrderEnum.ASCENDING);
        String lastVal = null;
        for (Protocol prot : protocolList) {
            if (lastVal != null) {
                assertTrue(prot.getName().compareTo(lastVal) >= 0);
            }
            lastVal = prot.getName();
        }

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "name",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        for (Protocol prot : protocolList) {
            if (lastVal != null) {
                assertTrue(prot.getName().compareTo(lastVal) <= 0);
            }
            lastVal = prot.getName();
        }

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "description",
                SortOrderEnum.ASCENDING);
        lastVal = null;
        for (Protocol prot : protocolList) {
            if (lastVal != null) {
                assertTrue(prot.getDescription().compareTo(lastVal) >= 0);
            }
            lastVal = prot.getDescription();
        }

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(null, 10, 0, "description",
                SortOrderEnum.DESCENDING);
        lastVal = null;
        for (Protocol prot : protocolList) {
            if (lastVal != null) {
                assertTrue(prot.getDescription().compareTo(lastVal) <= 0);
            }
            lastVal = prot.getDescription();
        }

        SearchParameters params = new SearchParameters();
        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, protocolList.size());
        assertEquals(3, ProtExpressRegistry.getProtocolService().countMatchingProtocols(params));

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 2, 0, null, null);
        assertEquals(2, protocolList.size());
        assertEquals(3, ProtExpressRegistry.getProtocolService().countMatchingProtocols(params));

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 2, 1, null, null);
        assertEquals(2, protocolList.size());

        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 2, null, null);
        assertEquals(1, protocolList.size());

        params.setName("a");
        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(0, protocolList.size());

        params.setName("t prot");
        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(3, protocolList.size());

        params.setName("tocol 12");
        protocolList = ProtExpressRegistry.getProtocolService().searchForProtocols(params, 10, 0, null, null);
        assertEquals(2, protocolList.size());
    }

    public void testGetMostRecentExperiments() throws Exception {
        List<Protocol> protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser(
                UserHolder.getUsername(), 3);
        assertEquals(0, protocols.size());

        Protocol protocol1 = new Protocol("ex1");
        this.theSession.save(protocol1);
        this.theSession.flush();
        Thread.sleep(100);

        protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(1, protocols.size());
        assertEquals(protocol1, protocols.get(0));

        Protocol protocol2 = new Protocol("ex2");
        this.theSession.save(protocol2);
        this.theSession.flush();
        Thread.sleep(100);

        protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(2, protocols.size());
        assertEquals(protocol2, protocols.get(0));
        assertEquals(protocol1, protocols.get(1));

        Protocol protocol3 = new Protocol("ex3");
        this.theSession.save(protocol3);
        this.theSession.flush();
        Thread.sleep(100);

        protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(2, protocols.size());
        assertEquals(protocol3, protocols.get(0));
        assertEquals(protocol2, protocols.get(1));

        protocol1.setDescription("new comments");
        this.theSession.update(protocol1);
        this.theSession.flush();

        protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser(
                UserHolder.getUsername(), 2);
        assertEquals(2, protocols.size());
        assertEquals(protocol1, protocols.get(0));
        assertEquals(protocol3, protocols.get(1));

        protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser(
                UserHolder.getUsername(), 5);
        assertEquals(3, protocols.size());
        assertEquals(protocol1, protocols.get(0));
        assertEquals(protocol3, protocols.get(1));
        assertEquals(protocol2, protocols.get(2));

        protocols = ProtExpressRegistry.getProtocolService().getMostRecentProtocolsforUser("unuseduser", 3);
        assertEquals(0, protocols.size());
    }

    public void testGetUsersProtocolsByProtocolName() {

        Protocol protocol1 = new Protocol("test name 1");
        this.theSession.save(protocol1);

        Protocol protocol2 = new Protocol("test name 2");
        this.theSession.save(protocol2);

        Protocol protocol3 = new Protocol("A second test protocol");
        this.theSession.save(protocol3);

        this.theSession.flush();
        this.theSession.clear();

        List<Protocol> retrievedProtocols = ProtExpressRegistry.getProtocolService().getProtocolsForCurrentUserByName("test name");
        assertEquals(2, retrievedProtocols.size());

        retrievedProtocols = ProtExpressRegistry.getProtocolService().getProtocolsForCurrentUserByName("A seco");
        assertEquals(1, retrievedProtocols.size());

        retrievedProtocols = ProtExpressRegistry.getProtocolService().getProtocolsForCurrentUserByName("nonexistent test name");
        assertEquals(0, retrievedProtocols.size());
    }

    public void testEqualsAndHashCode() {
        assertFalse(new Protocol("test").equals(new Protocol("test")));
        Protocol p1 = new Protocol("test protocol 1");
        p1.setInstrument("foo");
        p1.setDescription("bar");
        p1.setSoftware("baz");

        assertFalse(p1.equals(null));
        assertFalse(p1.equals(new String("Foo")));
        assertTrue(p1.equals(p1));
        //assertEquals(p1.hashCode(), new Protocol("test protocol 1").hashCode());
    }
}