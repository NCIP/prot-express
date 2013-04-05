/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

/**
 * Class to handle the exporting of experiment data.
 * @author Scott Miller
 */
public class ExperimentExportAction extends ProtExpressBaseAction implements Preparable {

    private static final long serialVersionUID = 1L;
    private Experiment experiment = new Experiment(null);
    private ExperimentExportFileType fileType = ExperimentExportFileType.Xar2_3;
    private Long experimentId;

    private InputStream inputStream = null;

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getExperiment() != null && getExperiment().getId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperiment().getId()));
        } else if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }
    }

    /**
     * Export the selected experiment.
     * @return the stream.
     */
    public InputStream getInputStream()  {
        return this.inputStream;
    }

    /**
     * no op action that returns success.
     * @return success
     * @throws JAXBException on error
     */
    @SkipValidation
    public String export() throws JAXBException {
        if (ExperimentExportFileType.Xar2_3.equals(getFileType())) {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ProtExpressRegistry.getXar23FormatConversionService().marshallExperiments(getExperiment(), os);
            this.inputStream = new ByteArrayInputStream(os.toByteArray());
        }
        return ActionSupport.SUCCESS;
    }

    /**
     * @return the experiment
     */
    public Experiment getExperiment() {
        return this.experiment;
    }

    /**
     * @param experiment the experiment to set
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * @return the fileType
     */
    @RequiredFieldValidator(key = "experiment.export.fileType", message = "File Type is required")
    public ExperimentExportFileType getFileType() {
        return this.fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(ExperimentExportFileType fileType) {
        this.fileType = fileType;
    }

    /**
     * Gets the experimentId.
     *
     * @return the experimentId.
     */
    public Long getExperimentId() {
        return experimentId;
    }

    /**
     * Sets the experimentId.
     *
     * @param experimentId the experimentId to set.
     */
    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }
}
