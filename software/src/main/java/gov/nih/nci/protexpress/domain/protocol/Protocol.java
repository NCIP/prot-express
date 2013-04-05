/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.protocol;

import gov.nih.nci.protexpress.domain.Auditable;
import gov.nih.nci.protexpress.domain.HibernateFieldLength;
import gov.nih.nci.protexpress.domain.audit.AuditInfo;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Valid;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class representing a protocol.
 *
 * @author Scott Miller
 */
@Entity
@Table(name = "protocol")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Protocol implements Serializable, PersistentObject, Auditable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String software;
    private String instrument;
    private String notes;
    private ContactPerson contactPerson = new ContactPerson();
    private AuditInfo auditInfo = new AuditInfo();

    /**
     * protected default constructor for hibernate only.
     */
    protected Protocol() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param name the name of the protocol
     */
    public Protocol(String name) {
        setName(name);
    }

    /**
     * The id of the protocol.
     *
     * @return the id, null for new protocols
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id of protocol to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the protocol.
     *
     * @return the name
     */
    @Index(name = "protocol_name_idx")
    @Column(name = "name")
    @NotEmpty
    @Length(max = HibernateFieldLength.PROTOCOL_NAME_LENGTH)
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the protocol.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    @Column(name = "description")
    @Length(max = HibernateFieldLength.PROTOCOL_DESCRIPTION_LENGTH)
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
    @Length(max = HibernateFieldLength.PROTOCOL_INSTRUMENT_LENGTH)
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
    @Length(max = HibernateFieldLength.PROTOCOL_SOFTWARE_LENGTH)
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
     * Gets the notes.
     *
     * @return the notes.
     */
    @Column(name = "notes")
    @Length(max = HibernateFieldLength.PROTOCOL_NOTES_LENGTH)
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes.
     *
     * @param notes the notes to set.
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
     * Gets the contactPerson.
     *
     * @return the contactPerson.
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_person_id")
    @Valid
    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    /**
     * Sets the contactPerson.
     *
     * @param contactPerson the contactPerson to set.
     */
    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * Copy a Protocol, and returns the new object.
     *
     * @param protocol the protocol to copy.
     * @return the new object.
     */
    public static Protocol getCopy(Protocol protocol) {
        Protocol newProtocol = new Protocol(protocol.getName());
        newProtocol.setContactPerson(protocol.getContactPerson());
        newProtocol.setDescription(protocol.getDescription());
        newProtocol.setInstrument(protocol.getInstrument());
        newProtocol.setNotes(protocol.getNotes());
        newProtocol.setSoftware(protocol.getSoftware());
        return newProtocol;
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

        return new EqualsBuilder()
        .append(getId().toString(), p.getId().toString())
        .append(getName(), p.getName())
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
