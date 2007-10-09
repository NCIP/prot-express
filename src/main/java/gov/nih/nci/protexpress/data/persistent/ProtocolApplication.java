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
package gov.nih.nci.protexpress.data.persistent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

/**
 * Class representing a protocol application.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "protocol_application")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProtocolApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int NAME_LENGTH = 100;
    private static final int LSID_LENGTH = 255;
    private static final int COMMENTS_LENGTH = 255;

    private Long id;
    private String lsid;
    private String name;
    private int actionSequence;
    private Calendar activityDate;
    private String comments;
    private ExperimentRun experimentRun;
    private Protocol protocol;
    private ProtocolParameters parameters = new ProtocolParameters();
    private List<SimpleTypeValue> properties = new ArrayList<SimpleTypeValue>();

    /**
     * protected default constructor for hibernate only.
     */
    protected ProtocolApplication() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param lsid the lsid of the protocol application
     * @param name the name of the protocol application
     * @param actionSequence the action sequence
     * @param activityDate the activity date
     * @param protocol the protocol being applied
     */
    public ProtocolApplication(String lsid, String name, int actionSequence, Calendar activityDate, Protocol protocol) {
        setLsid(lsid);
        setName(name);
        setActionSequence(actionSequence);
        setActivityDate(activityDate);
        setProtocol(protocol);
    }

    /**
     * The id of the object.
     *
     * @return the id, null for new objects
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the lsid.
     *
     * @return the lsid
     */
    @Column(name = "lsid", unique = true)
    @NotEmpty
    @Length(max = LSID_LENGTH)
    public String getLsid() {
        return this.lsid;
    }

    /**
     * Sets the lsid.
     *
     * @param lsid the lsid to set
     */
    public void setLsid(String lsid) {
        this.lsid = lsid;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name")
    @NotEmpty
    @Length(max = NAME_LENGTH)
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the actionSequence.
     *
     * @return the actionSequence
     */
    @Column(name = "action_sequence")
    @NotNull
    public int getActionSequence() {
        return this.actionSequence;
    }

    /**
     * Sets the actionSequence.
     *
     * @param actionSequence the actionSequence to set
     */
    public void setActionSequence(int actionSequence) {
        this.actionSequence = actionSequence;
    }

    /**
     * Gets the activityDate.
     *
     * @return the activityDate
     */
    @Column(name = "activity_date")
    @NotNull
    @Temporal(TemporalType.DATE)
    public Calendar getActivityDate() {
        return this.activityDate;
    }

    /**
     * Sets the activityDate.
     *
     * @param activityDate the activityDate to set
     */
    public void setActivityDate(Calendar activityDate) {
        this.activityDate = activityDate;
    }

    /**
     * Gets the comments.
     *
     * @return the comments
     */
    @Column(name = "comments")
    @NotEmpty
    @Length(max = COMMENTS_LENGTH)
    public String getComments() {
        return this.comments;
    }

    /**
     * Sets the comments.
     *
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Gets the protocol.
     *
     * @return the protocol.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "protocol_id")
    public Protocol getProtocol() {
        return this.protocol;
    }

    /**
     * Sets the protocol.
     *
     * @param protocol the protocol to set.
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * Gets the experimentRun.
     *
     * @return the experimentRun.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experiment_run_id", nullable = false)
    public ExperimentRun getExperimentRun() {
        return this.experimentRun;
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
     * Gets the parameters.
     *
     * @return the parameters.
     */
    @Embedded
    public ProtocolParameters getParameters() {
        return this.parameters;
    }

    /**
     * Sets the parameters.
     *
     * @param parameters the parameters to set.
     */
    public void setParameters(ProtocolParameters parameters) {
        this.parameters = parameters;
    }

    /**
     * Gets the properties.
     *
     * @return the properties.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "prot_application_id")
    public List<SimpleTypeValue> getProperties() {
        return properties;
    }

    /**
     * Sets the properties.
     *
     * @param properties the properties to set.
     */
    protected void setProperties(List<SimpleTypeValue> properties) {
        this.properties = properties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof ProtocolApplication)) {
            return false;
        }

        ProtocolApplication p = (ProtocolApplication) o;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder().append(getLsid(), p.getLsid()).isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getLsid()).toHashCode();
    }
}
