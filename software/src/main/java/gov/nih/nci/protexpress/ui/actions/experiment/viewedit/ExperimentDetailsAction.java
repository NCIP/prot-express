/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.util.UserHolder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class for editing experiment details.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ExperimentDetailsAction extends AbstractExperimentDetailsAction implements Preparable {
    private static final long serialVersionUID = 1L;
    private Experiment experiment = null;
    private Long experimentId;
    private String actionResultViewExperiment = "viewExperiment";
    private String actionResultDelete = "delete";
    private String treeNodeUrlPrefix = null;

    /**
     * Action Constructor.
     */
    public ExperimentDetailsAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }
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
     * Save the experiment data.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveExperiment() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("experiment.update.success"));
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getExperiment());
        ProtExpressRegistry.getProtExpressService().clear();

        return ActionSupport.SUCCESS;
    }

    /* (non-Javadoc)
     * @see gov.nih.nci.protexpress.ui.actions.experiment.viewedit.AbstractExperimentDetailsAction#load()
     */
    /**
     * Overrides the default implementation of the method. If user does not have access to the experiment,
     * they are re-directed to a read-only view of the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @Override
    public String load() {
        String servletPath = ServletActionContext.getRequest().getServletPath();
        if ((servletPath.indexOf("editExperiment/") != -1)
                && !getExperiment().getAuditInfo().getCreator().equals(UserHolder.getUser().getLoginName())) {
            return this.actionResultViewExperiment;
        }

        return super.load();
    }

    /**
     * Deletes the protocol application from the run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String delete() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("experiment.delete.success"));
        ProtExpressRegistry.getExperimentService().deleteExperiment(getExperiment());
        return actionResultDelete;
    }

    /**
     * Refreshes the Experiment Tree.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String refreshExperimentTree() {
        return "refreshExperimentTree";
    }

    /**
     * Gets the treeNodeUrlPrefix.
     *
     * @return the treeNodeUrlPrefix.
     */
    public String getTreeNodeUrlPrefix() {
        return treeNodeUrlPrefix;
    }

    /**
     * Sets the treeNodeUrlPrefix.
     *
     * @param treeNodeUrlPrefix the treeNodeUrlPrefix to set.
     */
    public void setTreeNodeUrlPrefix(String treeNodeUrlPrefix) {
        this.treeNodeUrlPrefix = treeNodeUrlPrefix;
    }


}