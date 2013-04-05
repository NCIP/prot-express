/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class for editing experiment run details.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ExperimentRunDetailsAction extends ExperimentDetailsAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private ExperimentRun experimentRun = null;
    private Long experimentRunId;
    private Long newExperimentRunId;

    private String actionResultDelete = "delete";
    private String actionResultEditExperimentRun = "editExperimentRun";

    /**
     * Action Constructor.
     */
    public ExperimentRunDetailsAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getExperimentRunId() != null) {
            setExperimentRun(ProtExpressRegistry.getExperimentService().getExperimentRunById(getExperimentRunId()));
        }
        if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }
    }

    /**
     * Gets the experimentRun.
     *
     * @return the experimentRun.
     */
    @CustomValidator(type = "hibernate")
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
     * Gets the experimentRunId.
     *
     * @return the experimentRunId.
     */
    public Long getExperimentRunId() {
        return experimentRunId;
    }

    /**
     * Sets the experimentRunId.
     *
     * @param experimentRunId the experimentRunId to set.
     */
    public void setExperimentRunId(Long experimentRunId) {
        this.experimentRunId = experimentRunId;
    }

    /**
     * Save the experiment run data.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveExperimentRun() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("experimentrun.update.success"));
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getExperimentRun());
        ProtExpressRegistry.getProtExpressService().clear();

        return ActionSupport.SUCCESS;
    }

    /**
     * Repeats the Run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String repeat() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("experimentrun.repeat.success"));
        ExperimentRun newExpRun = ExperimentRun.getCopy(getExperimentRun());
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(newExpRun);
        ProtExpressRegistry.getProtExpressService().clear();

     // set the appropriate id's to pass as parameters to the next action, for editing the newly created run.
        setNewExperimentRunId(newExpRun.getId());
        setExperimentId(newExpRun.getExperiment().getId());
        return actionResultEditExperimentRun;
    }

    /**
     * Deletes the protocol application from the run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String delete() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("experimentrun.delete.success"));
        ProtExpressRegistry.getExperimentService().deleteExperimentRun(getExperimentRun());
        return actionResultDelete;
    }

    /**
     * Gets the newExperimentRunId.
     *
     * @return the newExperimentRunId.
     */
    public Long getNewExperimentRunId() {
        return newExperimentRunId;
    }

    /**
     * Sets the newExperimentRunId.
     *
     * @param newExperimentRunId the newExperimentRunId to set.
     */
    public void setNewExperimentRunId(Long newExperimentRunId) {
        this.newExperimentRunId = newExperimentRunId;
    }


}