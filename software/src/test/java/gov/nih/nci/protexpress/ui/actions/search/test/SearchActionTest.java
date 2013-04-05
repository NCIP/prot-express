/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.search.test;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.service.SearchType;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.search.SearchAction;

import java.util.Date;
import java.util.List;

import org.displaytag.properties.SortOrderEnum;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Krishna Kanchinadam
 *
 */
public class SearchActionTest extends ProtExpressBaseHibernateTest {

    SearchAction action = new SearchAction();

    /**
     * {@inheritDoc}
     */
   @Override
   protected void onSetUp() throws Exception {
        super.onSetUp();
        action = new SearchAction();

        Experiment experiment = new Experiment("a Name - Test Experiment 1");
        experiment.setDescription("Description - Test Experiment 1");
        experiment.setDatePerformed(new Date());
        experiment.setHypothesis("Hypothesis - Test Experiment 1");
        experiment.setUrl("URL - Test Experiment 1");

        theSession.saveOrUpdate(experiment);

        experiment = new Experiment("b Name - Test Experiment 1");
        experiment.setDescription("Description - Test Experiment 2");
        experiment.setDatePerformed(new Date());
        experiment.setHypothesis("Hypothesis - Test Experiment 2");
        experiment.setUrl("URL - Test Experiment 2");

        theSession.saveOrUpdate(experiment);

        experiment = new Experiment("c Name - Test Experiment 3");
        experiment.setDescription("Description - Test Experiment 4");
        experiment.setDatePerformed(new Date());
        experiment.setHypothesis("Hypothesis - Test Experiment 4");
        experiment.setUrl("URL - Test Experiment 4");

        theSession.saveOrUpdate(experiment);
        theSession.flush();
        theSession.clear();

        Protocol protocol = new Protocol("a test protocol");
        protocol.setInstrument("foo");
        protocol.setDescription("z bar");
        protocol.setSoftware("baz");

        theSession.saveOrUpdate(protocol);

        protocol = new Protocol("b test protocol");
        protocol.setInstrument("foo");
        protocol.setDescription("x bar");
        protocol.setSoftware("baz");

        theSession.saveOrUpdate(protocol);

        protocol = new Protocol("c test protocol");
        protocol.setInstrument("foo");
        protocol.setDescription("y bar");
        protocol.setSoftware("baz");

        theSession.saveOrUpdate(protocol);
        theSession.flush();
        theSession.clear();
    }

    public void testExperimentSearch() throws Exception {
        assertEquals("loadSearchForm", action.loadSearch());
        assertNotNull(null, action.getExperiments().getList());

        action.getExperiments().setSortDirection(SortOrderEnum.DESCENDING);
        action.getExperiments().setSortCriterion("name");
        action.getExperiments().setPageNumber(1);
        assertEquals(ActionSupport.SUCCESS, action.doSearch());
        List<Experiment> experiments = action.getExperiments().getList();
        assertEquals(3, experiments.size());
        assertEquals(3, action.getExperiments().getFullListSize());
        assertEquals("c Name - Test Experiment 3", experiments.get(0).getName());
        assertEquals("a Name - Test Experiment 1", experiments.get(2).getName());

        action.getSearchParameters().setName("a Name");
        action.getExperiments().setSortDirection(SortOrderEnum.ASCENDING);
        assertEquals(ActionSupport.SUCCESS, action.doSearch());
        experiments = action.getExperiments().getList();
        assertEquals(1, experiments.size());
        assertEquals("a Name - Test Experiment 1", experiments.get(0).getName());

        action.setSearchParameters(new SearchParameters());
        action.getExperiments().setSortDirection(null);
        action.getExperiments().setObjectsPerPage(1);
        action.getExperiments().setSearchId("test");
        assertEquals(ActionSupport.SUCCESS, action.doSearch());
        experiments = action.getExperiments().getList();
        assertEquals(1, experiments.size());
        assertEquals(3, action.getExperiments().getFullListSize());
        assertEquals("a Name - Test Experiment 1", experiments.get(0).getName());
        assertEquals("test", action.getExperiments().getSearchId());

        action.setExperiments(null);
    }

    public void testProtocolSearch() throws Exception {
        action.getSearchParameters().setSearchType(SearchType.PROTOCOLS);

        assertEquals("loadSearchForm", action.loadSearch());
        assertNotNull(null, action.getProtocols().getList());

        action.getProtocols().setSortDirection(SortOrderEnum.DESCENDING);
        action.getProtocols().setSortCriterion("name");
        action.getProtocols().setPageNumber(1);
        assertEquals(ActionSupport.SUCCESS, action.doSearch());
        List<Protocol> protocols = action.getProtocols().getList();
        assertEquals(3, protocols.size());
        assertEquals(3, action.getProtocols().getFullListSize());
        assertEquals("c test protocol", protocols.get(0).getName());

        action.getSearchParameters().setName("a");
        action.getProtocols().setSortDirection(SortOrderEnum.ASCENDING);
        assertEquals(ActionSupport.SUCCESS, action.doSearch());
        protocols = action.getProtocols().getList();
        assertEquals(1, protocols.size());
        assertEquals("a test protocol", protocols.get(0).getName());

        action.setSearchParameters(new SearchParameters());
        action.getSearchParameters().setSearchType(SearchType.PROTOCOLS);
        action.getProtocols().setSortDirection(null);
        action.getProtocols().setObjectsPerPage(1);
        action.getProtocols().setSearchId("test");
        assertEquals(ActionSupport.SUCCESS, action.doSearch());
        protocols = action.getProtocols().getList();
        assertEquals(1, protocols.size());
        assertEquals(3, action.getProtocols().getFullListSize());
        assertEquals("a test protocol", protocols.get(0).getName());
        assertEquals("test", action.getProtocols().getSearchId());

        action.setProtocols(null);
    }

}
