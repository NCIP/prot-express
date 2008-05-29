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
package gov.nih.nci.protexpress.ui.actions.experiment;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.service.ExperimentService;
import gov.nih.nci.protexpress.service.SearchParameters;
import gov.nih.nci.protexpress.service.SearchType;
import gov.nih.nci.protexpress.ui.pagination.PaginatedListImpl;
import gov.nih.nci.protexpress.util.CreateExperimentSessionHelper;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.displaytag.properties.SortOrderEnum;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * Action for managing create experiment process.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public class CreateExperimentAddProtocolAction extends ActionSupport implements Preparable {
    private static final long serialVersionUID = 1L;

    private Experiment experiment = new Experiment(null);
    private Protocol protocol = new Protocol(null);
    private Long protocolId;
    private ProtocolApplication protocolApplication = new ProtocolApplication(
            "ProtocolApplication", null, null, null);

    private SearchParameters searchParameters = new SearchParameters();
    private PaginatedListImpl<Protocol> protocols = new PaginatedListImpl<Protocol>(
            0, null, ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name",
            SortOrderEnum.ASCENDING);

    private String actionResultSelectExistingProtocol = "selectExistingProtocol";

    private CreateExperimentSessionHelper experimentSessionHelper;

    /**
     * Denotes the action to be performed - Create a new protocol, select an existing protocol or copy a protocol.
     *
     */
    private enum Mode {
        CreateProtocol,
        SelectProtocolAndContinue,
        CopyProtocolAndContinue;
    }

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        experimentSessionHelper = getSessionHelper();
        ExperimentService es = ProtExpressRegistry.getExperimentService();
        if (experimentSessionHelper.getExperimentId() != null) {
            setExperiment(es.getExperimentById(experimentSessionHelper.getExperimentId()));
        } else if (getExperiment().getId() != null) {
            setExperiment(es.getExperimentById(getExperiment().getId()));
        }
    }

    /**
     * Add a new protocol to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addNewProtocol() {
        experimentSessionHelper = getSessionHelper();
        experimentSessionHelper.setProtocolApplicationId(null);
        experimentSessionHelper.getProtocolInputs().clear();
        experimentSessionHelper.updateExperimentInSession();

        return ActionSupport.INPUT;
    }

    /**
     * Action for adding another protocol to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String addAnotherProtocol() {
        return addNewProtocol();
    }

    /**
     * select an existing protocol to add to the experiment.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String selectExistingProtocol() {
        getSearchParameters().setSearchAllUsers(false);
        protocols = new PaginatedListImpl<Protocol>(0, null,
                ProtExpressRegistry.MAX_RESULTS_PER_PAGE, 1, null, "name",
                SortOrderEnum.ASCENDING);

        doSearch();
        return this.actionResultSelectExistingProtocol;
    }

    /**
     * Perform Search for Protocols/Experiments.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    @SuppressWarnings("unchecked")
    public String doSearch() {
        int count = 0;
        getSearchParameters().setSearchType(SearchType.PROTOCOLS);
        count = ProtExpressRegistry.getProtocolService()
                .countMatchingProtocols(getSearchParameters());
        getProtocols().setFullListSize(count);
        getProtocols().setList(
                ProtExpressRegistry.getProtocolService().searchForProtocols(
                        getSearchParameters(),
                        getProtocols().getObjectsPerPage(),
                        getProtocols().getObjectsPerPage()
                                * (getProtocols().getPageNumber() - 1),
                        getProtocols().getSortCriterion(),
                        getProtocols().getSortDirection()));

        return actionResultSelectExistingProtocol;
    }

    /**
     * Creates a new Protocol, and adds it to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String save() {
        return saveProtocolApplicationInformation(Mode.CreateProtocol);
    }

    /**
     * Selects a protocol, and adds it to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String selectProtocolAndContinue() {
        return saveProtocolApplicationInformation(Mode.SelectProtocolAndContinue);
    }

    /**
     * Copies a protocol, and adds the copied protocol to the current experiment run.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String copyProtocolAndContinue() {
       return saveProtocolApplicationInformation(Mode.CopyProtocolAndContinue);
    }

    /**
     * Create/Select/Copy a protocol, and save protocol application information.
     *
     * @return the directive for the next action / page to be directed to
     */
    private String saveProtocolApplicationInformation(Mode saveMode) {
        experimentSessionHelper = getSessionHelper();
        ExperimentRun expRun = getExperiment().getExperimentRuns().get(0);

        if ((expRun != null) && (getProtocolApplication().getId() == null)) {
            if (saveMode == Mode.CreateProtocol) {
                getProtocol().setContactPerson(ContactPerson.getCopy(getExperiment().getContactPerson()));
            }

            if ((saveMode == Mode.SelectProtocolAndContinue) || (saveMode == Mode.CopyProtocolAndContinue)) {
                Protocol sourceProtocol = null;
                if (getProtocolId() != null) {
                    sourceProtocol = ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId());

                    if (saveMode == Mode.SelectProtocolAndContinue) {
                        setProtocol(sourceProtocol);
                    } else {
                        setProtocol(Protocol.getCopy(sourceProtocol));
                    }
                }
            }

            ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocol());

            getProtocolApplication().setActivityDate(expRun.getDatePerformed());
            getProtocolApplication().setNotes(getProtocol().getNotes());
            getProtocolApplication().setStepNumber(1L);
            getProtocolApplication().setProtocol(getProtocol());
            getProtocolApplication().setExperimentRun(expRun);
            expRun.getProtocolApplications().add(getProtocolApplication());

            ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocolApplication());

            experimentSessionHelper.setProtocolApplicationId(getProtocolApplication().getId());
            experimentSessionHelper.updateExperimentInSession();
            experimentSessionHelper = null;
        }

        return ActionSupport.SUCCESS;
    }

    /**
     * loads the protocol.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        return ActionSupport.INPUT;
    }

    /**
     * Gets the experiment.
     *
     * @return the experiment.
     */
    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * Sets the experiment.
     *
     * @param experiment
     *            the experiment to set.
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Gets the protocol.
     *
     * @return the protocol.
     */
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * Sets the protocol.
     *
     * @param protocol
     *            the protocol to set.
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * Gets the protocol application.
     *
     * @return the protocol application.
     */
    public ProtocolApplication getProtocolApplication() {
        return protocolApplication;
    }

    /**
     * Sets the protocol application.
     *
     * @param protocolApplication
     *            the protocolApplication to set.
     */
    public void setProtocolApplication(ProtocolApplication protocolApplication) {
        this.protocolApplication = protocolApplication;
    }

    /**
     * @return the protocols
     */
    public PaginatedListImpl<Protocol> getProtocols() {
        return this.protocols;
    }

    /**
     * @param protocols
     *            the protocols to set
     */
    public void setProtocols(PaginatedListImpl<Protocol> protocols) {
        this.protocols = protocols;
    }

    /**
     * @return the searchParameters
     */
    public SearchParameters getSearchParameters() {
        return this.searchParameters;
    }

    /**
     * @param searchParameters
     *            the searchParameters to set
     */
    public void setSearchParameters(SearchParameters searchParameters) {
        this.searchParameters = searchParameters;
    }

    private CreateExperimentSessionHelper getSessionHelper() {
        return new CreateExperimentSessionHelper(ActionContext.getContext());
    }

    /**
     * Gets the protocolId.
     *
     * @return the protocolId.
     */
    public Long getProtocolId() {
        return protocolId;
    }

    /**
     * Sets the protocolId.
     *
     * @param protocolId the protocolId to set.
     */
    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

}