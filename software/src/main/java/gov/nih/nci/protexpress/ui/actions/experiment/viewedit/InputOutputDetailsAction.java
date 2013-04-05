/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class for editing protocol application input/output details.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class InputOutputDetailsAction extends ProtocolApplicationDetailsAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private InputOutputObject inputOutputObject = new InputOutputObject(null);
    private Long inputOutputObjectId;
    private String actionResultDelete = "delete";

    /**
     * Action Constructor.
     */
    public InputOutputDetailsAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getInputOutputObjectId() != null) {
            setInputOutputObject(ProtExpressRegistry.getExperimentService()
                    .getInputOutputObjectById(getInputOutputObjectId()));
        }

        if (getProtocolApplicationId() != null) {
            setProtocolApplication(ProtExpressRegistry.getExperimentService().
                    getProtocolApplicationById(getProtocolApplicationId()));
        }

        if (getExperimentRunId() != null) {
            setExperimentRun(ProtExpressRegistry.getExperimentService().getExperimentRunById(getExperimentRunId()));
        }

        if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }
    }

    /**
     * Gets the inputOutputObject.
     *
     * @return the inputOutputObject.
     */
    @CustomValidator(type = "hibernate")
    public InputOutputObject getInputOutputObject() {
        return inputOutputObject;
    }

    /**
     * Sets the inputOutputObject.
     *
     * @param inputOutputObject the inputOutputObject to set.
     */
    public void setInputOutputObject(InputOutputObject inputOutputObject) {
        this.inputOutputObject = inputOutputObject;
    }

    /**
     * Gets the inputOutputObjectId.
     *
     * @return the inputOutputObjectId.
     */
    public Long getInputOutputObjectId() {
        return inputOutputObjectId;
    }

    /**
     * Sets the inputOutputObjectId.
     *
     * @param inputOutputObjectId the inputOutputObjectId to set.
     */
    public void setInputOutputObjectId(Long inputOutputObjectId) {
        this.inputOutputObjectId = inputOutputObjectId;
    }

    /**
     * Save the input data.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveInput() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("input.update.success"));
        return saveInputOutputObject();
    }

    /**
     * Save the output data.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveOutput() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("output.update.success"));
        return saveInputOutputObject();
    }

    /**
     * Save the object.
     *
     * @return the directive for the next action / page to be directed to
     */
    private String saveInputOutputObject() {
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getInputOutputObject());
        ProtExpressRegistry.getProtExpressService().clear();

        return ActionSupport.SUCCESS;
    }

    /**
     * Deletes the input data.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String deleteInput() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("input.delete.success"));
        // If not an output of any other protocol application, can be deleted directly.
        // If an output of a previous protocol application, only the association should be broken.
        if (getInputOutputObject().getOutputOfProtocolApplication() != null) {
            getInputOutputObject().setInputToProtocolApplication(null);
            ProtExpressRegistry.getProtExpressService().saveOrUpdate(getInputOutputObject());
        } else {
            ProtExpressRegistry.getExperimentService().deleteInputOutputObject(getInputOutputObject());
        }

        return actionResultDelete;
    }

    /**
     * Deletes the output data.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String deleteOutput() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("output.delete.success"));
        ProtExpressRegistry.getExperimentService().deleteInputOutputObject(getInputOutputObject());
        return actionResultDelete;
    }
}