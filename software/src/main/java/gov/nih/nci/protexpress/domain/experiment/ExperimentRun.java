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
package gov.nih.nci.protexpress.domain.experiment;

import gov.nih.nci.protexpress.domain.Auditable;
import gov.nih.nci.protexpress.domain.HibernateFieldLength;
import gov.nih.nci.protexpress.domain.audit.AuditInfo;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import org.hibernate.validator.Valid;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class representing an experiment run.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "experiment_run")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ExperimentRun implements Serializable, PersistentObject, Auditable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String notes;
    private Date datePerformed = new Date();
    private AuditInfo auditInfo = new AuditInfo();
    private Experiment experiment;
    private List<ProtocolApplication> protocolApplications = new ArrayList<ProtocolApplication>();

    /**
     * protected default constructor for hibernate only.
     */
    protected ExperimentRun() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param name the name of the experiment
     */
    public ExperimentRun(String name) {
        setName(name);
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
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name")
    @NotEmpty
    @Length(max = HibernateFieldLength.EXPRUN_NAME_LENGTH)
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
     * Gets the notes.
     *
     * @return the notes
     */
    @Column(name = "notes")
    @Length(max = HibernateFieldLength.EXPRUN_NOTES_LENGTH)
    public String getNotes() {
        return this.notes;
    }

    /**
     * Sets the notes.
     *
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the auditInfo
     */
    @Embedded
    @Valid
    public AuditInfo getAuditInfo() {
        return this.auditInfo;
    }

    /**
     * @param auditInfo the auditInfo to set
     */
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    /**
     * Gets the datePerformed.
     *
     * @return the datePerformed.
     */
    @Column(name = "date_performed")
    @NotNull
    @Temporal(TemporalType.DATE)
    public Date getDatePerformed() {
        return datePerformed;
    }

    /**
     * Sets the datePerformed.
     *
     * @param datePerformed the datePerformed to set.
     */
    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    /**
     * Gets the experiment.
     *
     * @return the experiment
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "experiment_id", nullable = false)
    @Valid
    public Experiment getExperiment() {
        return this.experiment;
    }

    /**
     * Sets the experiment.
     *
     * @param experiment the experiment to set
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Gets the protocolApplications.
     *
     * @return the protocolApplications.
     */
    @OneToMany(mappedBy = "experimentRun", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ProtocolApplication> getProtocolApplications() {
        return this.protocolApplications;
    }

    /**
     * Sets the protocolApplications.
     *
     * @param protocolApplications the protocolApplications to set.
     */
    protected void setProtocolApplications(List<ProtocolApplication> protocolApplications) {
        this.protocolApplications = protocolApplications;
    }

    /**
     * Returns a copy of the experiment run.
     *
     * @param srcExpRun the source experiment run to copy.
     * @return the new object.
     */
    public static ExperimentRun getCopy(ExperimentRun srcExpRun) {

        ExperimentRun newExpRun = new ExperimentRun(srcExpRun.getName());
        newExpRun.setDatePerformed(srcExpRun.getDatePerformed());
        newExpRun.setExperiment(srcExpRun.getExperiment());
        newExpRun.setNotes(srcExpRun.getNotes());
        for (ProtocolApplication protApp : srcExpRun.getProtocolApplications()) {
            ProtocolApplication newProtApp = ProtocolApplication.getCopy(protApp);
            newProtApp.setExperimentRun(newExpRun);
            newExpRun.getProtocolApplications().add(newProtApp);
        }

        return newExpRun;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ExperimentRun)) {
            return false;
        }

        ExperimentRun experimentRun = (ExperimentRun) obj;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder()
        .append(getId().toString(), experimentRun.getId().toString())
        .append(getName(), experimentRun.getName())
        .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        .append(getId().toString())
        .append(getName())
        .toHashCode();
    }
}
