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
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;

/**
 * Class representing a protocol.
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "protocol_application")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProtocolApplication implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int NAME_LENGTH = 100;
    private static final int DESCRIPTION_LENGTH = 255;
    private static final int SOFTWARE_LENGTH = 255;
    private static final int INSTRUMENT_LENGTH = 255;
    private static final int TYPE_LENGTH = 20;
    private static final int LSID_LENGTH = 255;
    private static final int ACTION_SEQUENCE_LENGTH = 3;
    private static final int ACTIVITY_DATE_LENGTH = 25;
    private static final int OUTPUT_MATERIAL_TYPE_LENGTH = 25;
    private static final int OUTPUT_DATA_TYPE_LENGTH = 25;

    // ProtocolApplication attributes
    private Long id;
    private String lsid;
    private String name;
    private ProtocolType type;
    private String protocolLsid;
    private int actionSequence;
    private Calendar activityDate;
    private String comments;
    private ExperimentRun experimentRun;

    // Protocol Attributes
    private Protocol protocol;
    private String protocolName;
    private String protocolDescription;
    private ProtocolType protocolType;
    private Integer protocolMaxInputMaterialPerInstance;
    private Integer protocolMaxInputDataPerInstance;
    private Integer protocolOutputMaterialPerInstance;
    private Integer protocolOutputDataPerInstance;
    private String protocolOutputMaterialType = "Material";
    private String protocolOutputDataType = "Data";
    private String protocolSoftware;
    private String protocolInstrument;
    private Person protocolPrimaryContact;

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
     * @param type the protocol application type
     * @param actionSequence the action sequence
     * @param activityDate the activity date
     */
    public ProtocolApplication(String lsid, String name, ProtocolType type, int actionSequence, Calendar activityDate) {
        setLsid(lsid);
        setName(name);
        setType(type);
        setActionSequence(actionSequence);
        setActivityDate(activityDate);
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
     * @return the type
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = TYPE_LENGTH)
    @NotNull
    public ProtocolType getType() {
        return this.type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ProtocolType type) {
        this.type = type;
    }

    /**
     * Gets the protocolLsid.
     *
     * @return the protocolLsid
     */
    @Column(name = "protocol_lsid")
    @NotEmpty
    @Length(max = LSID_LENGTH)
    public String getProtocolLsid() {
        return this.protocolLsid;
    }

    /**
     * Sets the protocolLsid.
     *
     * @param protocolLsid the protocolLsid to set
     */
    public void setProtocolLsid(String protocolLsid) {
        this.protocolLsid = protocolLsid;
    }

    /**
     * Gets the actionSequence.
     *
     * @return the actionSequence
     */
    @Column(name = "action_sequence")
    @NotEmpty
    @Length(max = ACTION_SEQUENCE_LENGTH)
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
    @NotEmpty
    @Length(max = ACTIVITY_DATE_LENGTH)
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
    @Length(max = DESCRIPTION_LENGTH)
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
        this.updateProtocolValues();
    }

    /**
     * Updates the protocol related attribute values.
     *
     */
    private void updateProtocolValues() {
        if (this.protocol != null) {
            this.setProtocolName(this.protocol.getName());
            this.setProtocolDescription(this.protocol.getDescription());
            this.setProtocolType(this.protocol.getType());
            this.setProtocolMaxInputMaterialPerInstance(this.protocol.getMaxInputMaterialPerInstance());
            this.setProtocolMaxInputDataPerInstance(this.protocol.getMaxInputDataPerInstance());
            this.setProtocolOutputMaterialPerInstance(this.protocol.getOutputMaterialPerInstance());
            this.setProtocolOutputDataPerInstance(this.protocol.getOutputDataPerInstance());
            this.setProtocolOutputMaterialType(this.protocol.getOutputMaterialType());
            this.setProtocolSoftware(this.protocol.getSoftware());
            this.setProtocolInstrument(this.protocol.getInstrument());
            this.setProtocolLsid(this.protocol.getLsid());
            // Set the Contact Person.
            Person person = new Person();
            person.setComments(this.protocol.getPrimaryContact().getComments());
            person.setContactId(this.protocol.getPrimaryContact().getContactId());
            person.setEmail(this.protocol.getPrimaryContact().getEmail());
            person.setFirstName(this.protocol.getPrimaryContact().getFirstName());
            person.setLastName(this.protocol.getPrimaryContact().getLastName());

            this.setProtocolPrimaryContact(person);
        }
    }


    /**
     * Gets the protocolName.
     *
     * @return the protocolName.
     */
    @Column(name = "protocol_name")
    @Length(max = NAME_LENGTH)
    public String getProtocolName() {
        return protocolName;
    }

    /**
     * Sets the protocolName.
     *
     * @param protocolName the protocolName to set.
     */
    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    /**
     * Gets the protocolDescription.
     *
     * @return the protocolDescription
     */
    @Column(name = "protocol_description")
    @Length(max = DESCRIPTION_LENGTH)
    public String getProtocolDescription() {
        return this.protocolDescription;
    }

    /**
     * Sets the protocolDescription.
     *
     * @param protocolDescription the protocolDescription to set
     */
    public void setProtocolDescription(String protocolDescription) {
        this.protocolDescription = protocolDescription;
    }

    /**
     * @return the protocolType
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "protocol_type", length = TYPE_LENGTH)
    @NotNull
    public ProtocolType getProtocolType() {
        return this.protocolType;
    }

    /**
     * @param protocolType the protocolType to set
     */
    public void setProtocolType(ProtocolType protocolType) {
        this.protocolType = protocolType;
    }

    /**
     * Gets the protocolMaxInputMaterialPerInstance.
     *
     * @return the protocolMaxInputMaterialPerInstance.
     */
    @Column(name = "max_input_material")
    public Integer getProtocolMaxInputMaterialPerInstance() {
        return protocolMaxInputMaterialPerInstance;
    }

    /**
     * Sets the protocolMaxInputMaterialPerInstance.
     *
     * @param protocolMaxInputMaterialPerInstance the protocolMaxInputMaterialPerInstance to set.
     */
    public void setProtocolMaxInputMaterialPerInstance(
            Integer protocolMaxInputMaterialPerInstance) {
        this.protocolMaxInputMaterialPerInstance = protocolMaxInputMaterialPerInstance;
    }

    /**
     * Gets the protocolMaxInputDataPerInstance.
     *
     * @return the protocolMaxInputDataPerInstance.
     */
    @Column(name = "max_input_data")
    public Integer getProtocolMaxInputDataPerInstance() {
        return protocolMaxInputDataPerInstance;
    }

    /**
     * Sets the protocolMaxInputDataPerInstance.
     *
     * @param protocolMaxInputDataPerInstance the protocolMaxInputDataPerInstance to set.
     */
    public void setProtocolMaxInputDataPerInstance(
            Integer protocolMaxInputDataPerInstance) {
        this.protocolMaxInputDataPerInstance = protocolMaxInputDataPerInstance;
    }

    /**
     * Gets the protocolOutputMaterialPerInstance.
     *
     * @return the protocolOutputMaterialPerInstance.
     */
    @Column(name = "output_material")
    public Integer getProtocolOutputMaterialPerInstance() {
        return protocolOutputMaterialPerInstance;
    }

    /**
     * Sets the protocolOutputMaterialPerInstance.
     *
     * @param protocolOutputMaterialPerInstance the protocolOutputMaterialPerInstance to set.
     */
    public void setProtocolOutputMaterialPerInstance(
            Integer protocolOutputMaterialPerInstance) {
        this.protocolOutputMaterialPerInstance = protocolOutputMaterialPerInstance;
    }

    /**
     * Gets the protocolOutputDataPerInstance.
     *
     * @return the protocolOutputDataPerInstance.
     */
    @Column(name = "output_data")
    public Integer getProtocolOutputDataPerInstance() {
        return protocolOutputDataPerInstance;
    }

    /**
     * Sets the protocolOutputDataPerInstance.
     *
     * @param protocolOutputDataPerInstance the protocolOutputDataPerInstance to set.
     */
    public void setProtocolOutputDataPerInstance(Integer protocolOutputDataPerInstance) {
        this.protocolOutputDataPerInstance = protocolOutputDataPerInstance;
    }

    /**
     * Gets the protocolOutputMaterialType.
     *
     * @return the protocolOutputMaterialType.
     */
    @Column(name = "output_material_type")
    @Length(max = OUTPUT_MATERIAL_TYPE_LENGTH)
    public String getProtocolOutputMaterialType() {
        return protocolOutputMaterialType;
    }

    /**
     * Sets the protocolOutputMaterialType.
     *
     * @param protocolOutputMaterialType the protocolOutputMaterialType to set.
     */
    public void setProtocolOutputMaterialType(String protocolOutputMaterialType) {
        this.protocolOutputMaterialType = protocolOutputMaterialType;
    }

    /**
     * Gets the protocolOutputDataType.
     *
     * @return the protocolOutputDataType.
     */
    @Column(name = "output_data_type")
    @Length(max = OUTPUT_DATA_TYPE_LENGTH)
    public String getProtocolOutputDataType() {
        return protocolOutputDataType;
    }

    /**
     * Sets the protocolOutputDataType.
     *
     * @param protocolOutputDataType the protocolOutputDataType to set.
     */
    public void setProtocolOutputDataType(String protocolOutputDataType) {
        this.protocolOutputDataType = protocolOutputDataType;
    }

    /**
     * Gets the protocolSoftware.
     *
     * @return the protocolSoftware
     */
    @Column(name = "protocol_software")
    @Length(max = SOFTWARE_LENGTH)
    public String getProtocolSoftware() {
        return this.protocolSoftware;
    }

    /**
     *
     * @param protocolSoftware the protocolSoftware to set
     */
    public void setProtocolSoftware(String protocolSoftware) {
        this.protocolSoftware = protocolSoftware;
    }

    /**
     * Gets the protocolInstrument.
     *
     * @return the protocolInstrument
     */
    @Column(name = "protocol_instrument")
    @Length(max = INSTRUMENT_LENGTH)
    public String getProtocolInstrument() {
        return this.protocolInstrument;
    }

    /**
     * Sets the protocolInstrument.
     *
     * @param protocolInstrument the protocolInstrument to set
     */
    public void setProtocolInstrument(String protocolInstrument) {
        this.protocolInstrument = protocolInstrument;
    }

    /**
     * Gets the protocolPrimaryContact.
     *
     * @return the protocolPrimaryContact.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "protocol_person_id")
    public Person getProtocolPrimaryContact() {
        return this.protocolPrimaryContact;
    }

    /**
     * Sets the protocolPrimaryContact.
     *
     * @param protocolPrimaryContact the protocolPrimaryContact to set.
     */
    public void setProtocolPrimaryContact(Person protocolPrimaryContact) {
        this.protocolPrimaryContact = protocolPrimaryContact;
    }

    /**
     * Gets the experimentRun.
     *
     * @return the experimentRun.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "experiment_run_id", nullable = false)
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
