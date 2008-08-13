/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The ProtExpress
 * Software was developed in conjunction with the National Cancer Institute
 * (NCI) by NCI employees and 5AM Solutions, Inc. (5AM). To the extent
 * government employees are authors, any rights in such works shall be subject
 * to Title 17 of the United States Code, section 105.
 *
 * This ProtExpress Software License (the License) is between NCI and You. You (or
 * Your) shall mean a person or an entity, and all other entities that control,
 * are controlled by, or are under common control with the entity. Control for
 * purposes of this definition means (i) the direct or indirect power to cause
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares,
 * or (iii) beneficial ownership of such entity.
 *
 * This License is granted provided that You agree to the conditions described
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up,
 * no-charge, irrevocable, transferable and royalty-free right and license in
 * its rights in the ProtExpress Software to (i) use, install, access, operate,
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the ProtExpress Software; (ii) distribute and
 * have distributed to and by third parties the ProtExpress Software and any
 * modifications and derivative works thereof; and (iii) sublicense the
 * foregoing rights set out in (i) and (ii) to third parties, including the
 * right to license such rights to further third parties. For sake of clarity,
 * and not by way of limitation, NCI shall have no right of accounting or right
 * of payment from You or Your sub-licensees for the rights granted under this
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the
 * above copyright notice, this list of conditions and the disclaimer and
 * limitation of liability of Article 6, below. Your redistributions in object
 * code form must reproduce the above copyright notice, this list of conditions
 * and the disclaimer of Article 6 in the documentation and/or other materials
 * provided with the distribution, if any.
 *
 * Your end-user documentation included with the redistribution, if any, must
 * include the following acknowledgment: This product includes software
 * developed by 5AM and the National Cancer Institute. If You do not include
 * such end-user documentation, You shall include this acknowledgment in the
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "5AM"
 * to endorse or promote products derived from this Software. This License does
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or 5AM, except as required to comply with the
 * terms of this License.
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this
 * Software into Your proprietary programs and into any third party proprietary
 * programs. However, if You incorporate the Software into third party
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software
 * into such third party proprietary programs and for informing Your
 * sub-licensees, including without limitation Your end-users, of their
 * obligation to secure any required permissions from such third parties before
 * incorporating the Software into such third party proprietary software
 * programs. In the event that You fail to obtain such permissions, You agree
 * to indemnify NCI for any claims against NCI by such third parties, except to
 * the extent prohibited by law, resulting from Your failure to obtain such
 * permissions.
 *
 * For sake of clarity, and not by way of limitation, You may add Your own
 * copyright statement to Your modifications and to the derivative works, and
 * You may provide additional or different license terms and conditions in Your
 * sublicenses of modifications of the Software, or any derivative works of the
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, 5AM SOLUTIONS, INC. OR THEIR
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package gov.nih.nci.protexpress.ui.actions.experiment.viewedit;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.util.ManageProtAppInputOutputHelper;
import gov.nih.nci.protexpress.util.SessionHelper;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action class for editing protocol application details.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class ProtocolApplicationDetailsAction extends ExperimentRunDetailsAction implements Preparable {
    private static final long serialVersionUID = 1L;

    private ProtocolApplication protocolApplication = null;
    private Long protocolApplicationId;
    private Long deleteIndex;
    private Long selectedInputId;

    private List<InputOutputObject> potentialInputs = new ArrayList<InputOutputObject>();

    private String actionResultManageInputs = "manageInputs";
    private String actionResultAddInputs = "addInputs";
    private String actionResultAddOutputs = "addOutputs";
    private String actionResultDelete = "delete";


    /**
     * Action Constructor.
     */
    public ProtocolApplicationDetailsAction() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        if (getProtocolApplicationId() != null) {
            setProtocolApplication(ProtExpressRegistry.getExperimentService().
                    getProtocolApplicationById(getProtocolApplicationId()));
        } else if (SessionHelper.getProtocolApplicationFromSession() != null) {
            setProtocolApplication(SessionHelper.getProtocolApplicationFromSession());
        }

        if (getProtocolApplication() != null) {
            setPotentialInputs(ManageProtAppInputOutputHelper.getPotentialInputs(
                    getProtocolApplication()));
        }

        if (getExperimentRunId() != null) {
            setExperimentRun(ProtExpressRegistry.getExperimentService().getExperimentRunById(getExperimentRunId()));
        }
        if (getExperimentId() != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(getExperimentId()));
        }
    }

    /**
     * Manage Inputs.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String manageInputs() {
        SessionHelper.removeProtocolApplicationFromSession();
        ManageProtAppInputOutputHelper.addNewInput(getProtocolApplication().getInputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultManageInputs;
    }

    /**
     * Manage Outputs.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String manageOutputs() {
        SessionHelper.removeProtocolApplicationFromSession();
        ManageProtAppInputOutputHelper.addNewOutput(getProtocolApplication().getOutputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddOutputs;
    }

    /**
     * Creates a new input, adds to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewInput() {
        ManageProtAppInputOutputHelper.addNewInput(getProtocolApplication().getInputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddInputs;
    }

    /**
     * Creates a new output, adds to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewOutput() {
        ManageProtAppInputOutputHelper.addNewOutput(getProtocolApplication().getOutputs());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        return this.actionResultAddOutputs;
    }

    /**
     * Adds a potential input (output of another protocol) to the protocol application.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addExistingInput() {
        ManageProtAppInputOutputHelper.addExistingInput(getProtocolApplication().getInputs(), getSelectedInputId());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        // remove dupes.
        ManageProtAppInputOutputHelper.removeDuplicateInputs(getProtocolApplication().
                getInputs(), getPotentialInputs());
        return this.actionResultAddInputs;
    }

    /**
     * Deletes the specified input from the protocol application.
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String deleteInput() {
        ManageProtAppInputOutputHelper.deleteInput(getProtocolApplication().getInputs(), getDeleteIndex());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        setPotentialInputs(ManageProtAppInputOutputHelper.getPotentialInputs(
                getProtocolApplication()));
        return this.actionResultAddInputs;
    }

    /**
     * Deletes the specified output from the protocol application.
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String deleteOutput() {
        ManageProtAppInputOutputHelper.deleteOutput(getProtocolApplication().getOutputs(), getDeleteIndex());
        SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        setPotentialInputs(ManageProtAppInputOutputHelper.getPotentialInputs(
                getProtocolApplication()));
        return this.actionResultAddOutputs;
    }

    /**
     * Updates the inputs for the protocol application. .
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String updateInputs() {
        ManageProtAppInputOutputHelper.removeInvalidItems(getProtocolApplication().getInputs());
        if (!ManageProtAppInputOutputHelper.isNameEmpty(getProtocolApplication().getInputs())) {
            addActionError(getText("protexpress.page.manageinputs.error.name.empty"));
            return this.actionResultAddInputs;
        }
        return save("protocol.inputs.update.success");
    }

    /**
     * Updates the inputs for the protocol application. .
     *
     * @return the directive for the next action / page to be directed to.
     */
    @SkipValidation
    public String updateOutputs() {
        ManageProtAppInputOutputHelper.removeInvalidItems(getProtocolApplication().getOutputs());
        if (!ManageProtAppInputOutputHelper.isNameEmpty(getProtocolApplication().getOutputs())) {
            addActionError(getText("protexpress.page.manageoutputs.error.name.empty"));
            return this.actionResultAddOutputs;
        }
        return save("protocol.outputs.update.success");
    }

    /**
     * Save the Protocol Application.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String saveProtocolApplication() {
        return save("protocol.update.success");
    }

    /**
     * save the protocol application.
     *
     * @param messageKey the success update message key.
     * @return the directive for the next action / page to be directed to
     */
    private String save(String messageKey) {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString(messageKey));
        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocolApplication());
        ProtExpressRegistry.getProtExpressService().clear();
        SessionHelper.removeProtocolApplicationFromSession();
        return ActionSupport.SUCCESS;
    }

    /**
     * Gets the protocolApplication.
     *
     * @return the protocolApplication.
     */
    @CustomValidator(type = "hibernate")
    public ProtocolApplication getProtocolApplication() {
        return protocolApplication;
    }

    /**
     * Sets the protocolApplication.
     *
     * @param protocolApplication the protocolApplication to set.
     */
    public void setProtocolApplication(ProtocolApplication protocolApplication) {
        this.protocolApplication = protocolApplication;
    }

    /**
     * Gets the protocolApplicationId.
     *
     * @return the protocolApplicationId.
     */
    public Long getProtocolApplicationId() {
        return protocolApplicationId;
    }

    /**
     * Sets the protocolApplicationId.
     *
     * @param protocolApplicationId the protocolApplicationId to set.
     */
    public void setProtocolApplicationId(Long protocolApplicationId) {
        this.protocolApplicationId = protocolApplicationId;
    }

    /**
     * Gets the deleteIndex.
     *
     * @return the deleteIndex.
     */
    public Long getDeleteIndex() {
        return deleteIndex;
    }

    /**
     * Sets the deleteIndex.
     *
     * @param deleteIndex the deleteIndex to set.
     */
    public void setDeleteIndex(Long deleteIndex) {
        this.deleteIndex = deleteIndex;
    }

    /**
     * Gets the potentialInputs.
     *
     * @return the potentialInputs.
     */
    public List<InputOutputObject> getPotentialInputs() {
        return potentialInputs;
    }

    /**
     * Sets the potentialInputs.
     *
     * @param potentialInputs the potentialInputs to set.
     */
    public void setPotentialInputs(List<InputOutputObject> potentialInputs) {
        this.potentialInputs = potentialInputs;
    }

    /**
     * Gets the selectedInputId.
     *
     * @return the selectedInputId.
     */
    public Long getSelectedInputId() {
        return selectedInputId;
    }

    /**
     * Sets the selectedInputId.
     *
     * @param selectedInputId the selectedInputId to set.
     */
    public void setSelectedInputId(Long selectedInputId) {
        this.selectedInputId = selectedInputId;
    }

    /**
     * Deletes the protocol application from the run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String delete() {
        setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString("protocol.delete.success"));
        getProtocolApplication().getExperimentRun().getProtocolApplications().remove(getProtocolApplication());
        ProtExpressRegistry.getExperimentService().deleteProtocolApplication(getProtocolApplication());
        return actionResultDelete;
    }
}