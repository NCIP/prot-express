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
package gov.nih.nci.protexpress.ui.actions.protocolaction;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.data.persistent.Experiment;
import gov.nih.nci.protexpress.data.persistent.Protocol;
import gov.nih.nci.protexpress.data.persistent.ProtocolAction;
import gov.nih.nci.protexpress.service.ExperimentService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.ajaxtags.xml.AjaxXmlBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.CustomValidator;

/**
 * @author Krishna Kanchinadam
 *
 */
public class ProtocolActionManagementAction extends ActionSupport implements Preparable {

    private static final long serialVersionUID = 1L;
    private ProtocolAction protocolAction = new ProtocolAction(null, null);
    private Long experimentId;
    private Long protocolId;
    private String successMessage = null;
    private List<Protocol> protocols = new ArrayList<Protocol>();
    private String protocolName;

    /**
     * {@inheritDoc}
     */
    public void prepare() throws Exception {
        ExperimentService es = ProtExpressRegistry.getExperimentService();
        if (getProtocolAction().getId() != null) {
            setProtocolAction(es.getProtocolActionById(getProtocolAction().getId()));
        } else if (getExperimentId() != null) {
            Experiment exp = es.getExperimentById(getExperimentId());
            getProtocolAction().setExperiment(exp);
        }

        if (getProtocolId() != null) {
            Protocol p = ProtExpressRegistry.getProtocolService().getProtocolById(getProtocolId());
            getProtocolAction().setProtocol(p);
        }
    }

    /**
     * loads the {@link ProtocolAction}.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String load() {
        return ActionSupport.INPUT;
    }

    /**
     * Saves the Protocol Action.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String save() {
        if (getProtocolAction().getId() == null) {
            setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle()
                    .getString("protocolAction.save.success"));
        } else {
            setSuccessMessage(ProtExpressRegistry.getApplicationResourceBundle().getString(
                    "protocolAction.update.success"));
        }

        ProtExpressRegistry.getProtExpressService().saveOrUpdate(getProtocolAction());
        return ActionSupport.SUCCESS;
    }

    /**
     * delete the Protocol Action.
     *
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String delete() {
        String msg = ProtExpressRegistry.getApplicationResourceBundle().getString("protocolAction.delete.success");
        setSuccessMessage(msg);
        ProtExpressRegistry.getExperimentService().deleteProtocolAction(getProtocolAction());
        return ActionSupport.SUCCESS;
    }

    /**
     * Get the input stream.
     * @return the stream
     * @throws IllegalAccessException on error
     * @throws NoSuchMethodException on error
     * @throws InvocationTargetException on error
     * @throws UnsupportedEncodingException on error
     */
    public InputStream getInputStream() throws IllegalAccessException, NoSuchMethodException,
        InvocationTargetException, UnsupportedEncodingException {
        AjaxXmlBuilder xmlBuilder = new AjaxXmlBuilder().addItems(getProtocols(), "name", "id");
        return new ByteArrayInputStream(xmlBuilder.toString().getBytes("UTF-8"));
    }

    /**
     * Action to return the list of protocols.
     * @return the directive for the next action / page to be directed to
     */
    @SkipValidation
    public String retrieveProtocols() {
        setProtocols(ProtExpressRegistry.getProtocolService().getProtocolsForCurrentUserByName(getProtocolName()));
        return "xmlProtocolList";
    }

    /**
     * @return the ProtocolAction
     */
    @CustomValidator(type = "hibernate")
    public ProtocolAction getProtocolAction() {
        return this.protocolAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() {
        super.validate();
        if (this.hasErrors() && StringUtils.isNotEmpty(getProtocolName())) {
            setProtocols(ProtExpressRegistry.getProtocolService().getProtocolsForCurrentUserByName(getProtocolName()));
        }
    }

    /**
     * @param experimentId the experimentId to set
     */
    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    /**
     * @return the successMessage
     */
    public String getSuccessMessage() {
        return this.successMessage;
    }
    /**
     * @param protocolAction the protocolAction to set
     */
    public void setProtocolAction(ProtocolAction protocolAction) {
        this.protocolAction = protocolAction;
    }

    /**
     * @return the experimentId
     */
    public Long getExperimentId() {
        return this.experimentId;
    }

    /**
     * @return the protocol id
     */
    public Long getProtocolId() {
        return this.protocolId;
    }

    /**
     * @param protocolId the protocol id
     */
    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    /**
     * @param successMessage the successMessage to set
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }


    /**
     * @return the protocolName
     */
    public String getProtocolName() {
        return this.protocolName;
    }

    /**
     * @param protocolName the protocolName to set
     */
    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    /**
     * @return the protocols
     */
    public List<Protocol> getProtocols() {
        return this.protocols;
    }

    /**
     * @param protocols the protocols to set
     */
    public void setProtocols(List<Protocol> protocols) {
        this.protocols = protocols;
    }
}