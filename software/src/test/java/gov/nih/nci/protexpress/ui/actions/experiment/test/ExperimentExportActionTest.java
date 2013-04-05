/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.test;

import java.io.InputStream;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.service.FormatConversionService;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.experiment.ExperimentExportAction;
import gov.nih.nci.protexpress.ui.actions.experiment.ExperimentExportFileType;
import java.io.File;
import org.apache.commons.lang.builder.EqualsBuilder;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Scott Miller
 *
 */
public class ExperimentExportActionTest extends ProtExpressBaseHibernateTest  {

    ExperimentExportAction action;
    Experiment experiment;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.action = new ExperimentExportAction();

        this.experiment = new Experiment("Name - Test Experiment 1");
        this.experiment.setDescription("Description - Test Experiment 1");
        this.experiment.setHypothesis("Hypothesis - Test Experiment 1");
        this.experiment.setUrl("URL - Test Experiment 1");

        this.theSession.saveOrUpdate(this.experiment);
        this.theSession.flush();
        this.theSession.clear();
    }

    public void testPrepare() throws Exception {
        this.action.setExperiment(null);
        this.action.prepare();
        assertEquals(null, this.action.getExperiment());

        Experiment p = new Experiment(null);
        this.action.setExperiment(p);
        this.action.prepare();
        assertEquals(p, this.action.getExperiment());

        this.action.getExperiment().setId(this.experiment.getId());
        this.action.prepare();
        assertEquals(this.theSession.get(Experiment.class, this.experiment.getId()), this.action.getExperiment());
        assertTrue(EqualsBuilder.reflectionEquals(this.theSession.get(Experiment.class, this.experiment.getId()), this.action
                .getExperiment()));
    }

    public void testExport() throws Exception {
        this.action.setExperiment(this.experiment);
        this.action.setFileType(ExperimentExportFileType.Xar2_3);
        assertEquals("XAR 2.3", ExperimentExportFileType.Xar2_3.getDisplayName());
        assertEquals(ActionSupport.SUCCESS, this.action.export());
    }

}
