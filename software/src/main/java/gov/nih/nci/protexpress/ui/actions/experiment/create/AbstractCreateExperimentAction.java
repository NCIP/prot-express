/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;

import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * An abstract base action class for all actions related to the Create Experiment process.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public abstract class AbstractCreateExperimentAction extends ProtExpressBaseAction {
    private static final long serialVersionUID = 1L;

    private Experiment experiment = new Experiment(null);
    private ExperimentRun experimentRun = new ExperimentRun("Run");
    private Long experimentId;

    /**
     * Action Constructor.
     */
    public AbstractCreateExperimentAction() {
        super();
    }

    /**
     * Gets the experiment.
     *
     * @return the experiment.
     */
    @CustomValidator(type = "hibernate")
    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * Sets the experiment.
     *
     * @param experiment the experiment to set.
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Gets the experimentRun.
     *
     * @return the experimentRun.
     */
    public ExperimentRun getExperimentRun() {
        return experimentRun;
    }

    /**
     * Sets the experimentRun.
     *
     * @param experimentRun the experimentRun to set.
     */
    public void setExperimentRun(ExperimentRun experimentRun) {
        this.experimentRun = experimentRun;
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

    /**
     * Resets the experiment and run.
     */
    protected void resetExperiment() {
        setExperiment(new Experiment(null));
        setExperimentRun(new ExperimentRun("Run"));
    }
}