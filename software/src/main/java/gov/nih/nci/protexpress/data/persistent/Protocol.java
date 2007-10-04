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

import gov.nih.nci.protexpress.data.validator.UniqueConstraint;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

/**
 * Class representing a protocol.
 *
 * @author Scott Miller
 */
@Entity
@Table(name = "protocol")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Protocol implements Serializable, Persistent, Auditable {

    private static final long serialVersionUID = 1L;

    private static final int NAME_LENGTH = 100;
    private static final int DESCRIPTION_LENGTH = 255;
    private static final int SOFTWARE_LENGTH = 255;
    private static final int INSTRUMENT_LENGTH = 255;
    private static final int TYPE_LENGTH = 20;
    private static final int LSID_LENGTH = 255;
    private static final int OUTPUT_MATERIAL_TYPE_LENGTH = 25;
    private static final int OUTPUT_DATA_TYPE_LENGTH = 25;

    private Long id;
    private String lsid;
    private String name;
    private ProtocolType type;
    private String description;
    private String software;
    private String instrument;
    private Integer maxInputMaterialPerInstance;
    private Integer maxInputDataPerInstance;
    private Integer outputMaterialPerInstance;
    private Integer outputDataPerInstance;
    private String outputMaterialType = "Material";
    private String outputDataType = "Data";
    private String creator;
    private Calendar creationDate = Calendar.getInstance();
    private Calendar lastModifiedDate = Calendar.getInstance();
    private Person primaryContact;
    private ProtocolParameters parameters = new ProtocolParameters();

    /**
     * protected default constructor for hibernate only.
     */
    protected Protocol() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param lsid the lsid of the protocol
     * @param name the name of the protocol
     * @param type the type
     */
    public Protocol(String lsid, String name, ProtocolType type) {
        setLsid(lsid);
        setName(name);
        setType(type);
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
    @Column(name = "lsid")
    @UniqueConstraint(propertyName = "lsid")
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
    @Index(name = "protocol_name_idx")
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
    @Index(name = "protocol_type_idx")
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
     * Gets the description.
     *
     * @return the description
     */
    @Column(name = "description")
    @Length(max = DESCRIPTION_LENGTH)
    @Index(name = "protocol_desc_idx")
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the instrument.
     *
     * @return the instrument
     */
    @Column(name = "instrument")
    @Length(max = INSTRUMENT_LENGTH)
    public String getInstrument() {
        return this.instrument;
    }

    /**
     * Sets the instrument.
     *
     * @param instrument the instrument to set
     */
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    /**
     * Gets the software.
     *
     * @return the software
     */
    @Column(name = "software")
    @Length(max = SOFTWARE_LENGTH)
    public String getSoftware() {
        return this.software;
    }

    /**
     *
     * @param software the software to set
     */
    public void setSoftware(String software) {
        this.software = software;
    }

    /**
     * {@inheritDoc}
     */
    // note, this does not use hibernate validator annotations, because field is set by an interceptor, and thus should
    // not be validated at the UI
    @Column(name = "creator", nullable = false, length = Auditable.CREATOR_LENGTH)
    public String getCreator() {
        return this.creator;
    }

    /**
     * {@inheritDoc}
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * {@inheritDoc}
     */
    // note, this does not use hibernate validator annotations, because field is set by an interceptor, and thus should
    // not be validated at the UI
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getCreationDate() {
        return this.creationDate;
    }

    /**
     * {@inheritDoc}
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * {@inheritDoc}
     */
    // note, this does not use hibernate validator annotations, because field is set by an interceptor, and thus should
    // not be validated at the UI
    @Column(name = "modification_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * {@inheritDoc}
     */
    public void setLastModifiedDate(Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Gets the primaryContact.
     *
     * @return the primaryContact.
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    @Valid
    public Person getPrimaryContact() {
        return this.primaryContact;
    }

    /**
     * Sets the primaryContact.
     *
     * @param primaryContact the primaryContact to set.
     */
    public void setPrimaryContact(Person primaryContact) {
        this.primaryContact = primaryContact;
    }

    /**
     * Gets the maxInputMaterialPerInstance.
     *
     * @return the maxInputMaterialPerInstance.
     */
    @Column(name = "max_input_material")
    public Integer getMaxInputMaterialPerInstance() {
        return this.maxInputMaterialPerInstance;
    }

    /**
     * Sets the maxInputMaterialPerInstance.
     *
     * @param maxInputMaterialPerInstance the maxInputMaterialPerInstance to set.
     */
    public void setMaxInputMaterialPerInstance(Integer maxInputMaterialPerInstance) {
        this.maxInputMaterialPerInstance = maxInputMaterialPerInstance;
    }

    /**
     * Gets the maxInputDataPerInstance.
     *
     * @return the maxInputDataPerInstance.
     */
    @Column(name = "max_input_data")
    public Integer getMaxInputDataPerInstance() {
        return this.maxInputDataPerInstance;
    }

    /**
     * Sets the maxInputDataPerInstance.
     *
     * @param maxInputDataPerInstance the maxInputDataPerInstance to set.
     */
    public void setMaxInputDataPerInstance(Integer maxInputDataPerInstance) {
        this.maxInputDataPerInstance = maxInputDataPerInstance;
    }

    /**
     * Gets the outputMaterialPerInstance.
     *
     * @return the outputMaterialPerInstance.
     */
    @Column(name = "output_material")
    public Integer getOutputMaterialPerInstance() {
        return this.outputMaterialPerInstance;
    }

    /**
     * Sets the outputMaterialPerInstance.
     *
     * @param outputMaterialPerInstance the outputMaterialPerInstance to set.
     */
    public void setOutputMaterialPerInstance(Integer outputMaterialPerInstance) {
        this.outputMaterialPerInstance = outputMaterialPerInstance;
    }

    /**
     * Gets the outputDataPerInstance.
     *
     * @return the outputDataPerInstance.
     */
    @Column(name = "output_data")
    public Integer getOutputDataPerInstance() {
        return this.outputDataPerInstance;
    }

    /**
     * Sets the outputDataPerInstance.
     *
     * @param outputDataPerInstance the outputDataPerInstance to set.
     */
    public void setOutputDataPerInstance(Integer outputDataPerInstance) {
        this.outputDataPerInstance = outputDataPerInstance;
    }

    /**
     * Gets the outputMaterialType.
     *
     * @return the outputMaterialType.
     */
    @Column(name = "output_material_type")
    @Length(max = OUTPUT_MATERIAL_TYPE_LENGTH)
    @NotEmpty
    public String getOutputMaterialType() {
        return this.outputMaterialType;
    }

    /**
     * Sets the outputMaterialType.
     *
     * @param outputMaterialType the outputMaterialType to set.
     */
    public void setOutputMaterialType(String outputMaterialType) {
        this.outputMaterialType = outputMaterialType;
    }

    /**
     * Gets the outputDataType.
     *
     * @return the outputDataType.
     */
    @Column(name = "output_data_type")
    @Length(max = OUTPUT_DATA_TYPE_LENGTH)
    @NotEmpty
    public String getOutputDataType() {
        return this.outputDataType;
    }

    /**
     * Sets the outputDataType.
     *
     * @param outputDataType the outputDataType to set.
     */
    public void setOutputDataType(String outputDataType) {
        this.outputDataType = outputDataType;
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

        if (!(o instanceof Protocol)) {
            return false;
        }

        Protocol p = (Protocol) o;

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
