/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.ui.actions.ActionResultEnum;
import gov.nih.nci.protexpress.util.SessionHelper;
import gov.nih.nci.protexpress.util.UserHolder;
import gov.nih.nci.security.authorization.domainobjects.User;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class to create a new experiment.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class CreateExperimentAction extends AbstractCreateExperimentAction implements Preparable {
    private static final long serialVersionUID = 1L;

    /**
     * Action Constructor.
     */
    public CreateExperimentAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        Long expId = (getExperimentId() != null) ? getExperimentId() : SessionHelper.getExperimentIdFromSession();
        if (expId != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(expId));
            if (getExperiment().getId() != null) {
                setExperimentRun(getExperiment().getExperimentRuns().get(0));
            }
        }
    }

    /**
     * load.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    private String load() {
        resetExperiment();
        User user = UserHolder.getUser();
        if (user != null) {
            getExperiment().getContactPerson().setEmail(user.getEmailId());
            getExperiment().getContactPerson().setFirstName(user.getFirstName());
            getExperiment().getContactPerson().setLastName(user.getLastName());
        }
        return ActionSupport.INPUT;
    }

    /**
     * create a new experiment (run).
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String createNewExperiment() {
        SessionHelper.removeExperimentAndProtocolInformationFromSession();
        return load();
    }

    /**
     * re-load the experiment page.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String reloadExperiment() {
        return ActionSupport.INPUT;
    }

    /**
     * Displays the View Experiment Summary page.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String viewExperimentSummary() {
        return getActionResult(ActionResultEnum.VIEW_EXPERIMENT_SUMMARY);
    }

    /**
     * Saves the experiment overview information.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String save() {
        if (getExperiment().getId() == null) {
            getExperimentRun().setDatePerformed(getExperiment().getDatePerformed());
            getExperimentRun().setNotes(getExperiment().getNotes());
            getExperimentRun().setExperiment(getExperiment());
            getExperiment().getExperimentRuns().clear();
            getExperiment().getExperimentRuns().add(getExperimentRun());
        }

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getExperiment());
        ProtExpressRegistry.getProtExpressService().clear();
        SessionHelper.saveExperimentIdInSession(getExperiment().getId());
        return ActionSupport.SUCCESS;
    }

    /**
     * Repeats the Run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String repeat() {
        ExperimentRun newExpRun = ExperimentRun.getCopy(getExperimentRun());
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(newExpRun);
        ProtExpressRegistry.getProtExpressService().clear();
     // set the appropriate id's to pass as parameters to the next action, for editing the newly created run.
        setExperimentId(getExperiment().getId());
        return getActionResult(ActionResultEnum.EDIT_EXPERIMENT);
    }
}

