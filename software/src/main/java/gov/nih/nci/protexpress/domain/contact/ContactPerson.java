/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.contact;

import gov.nih.nci.protexpress.domain.HibernateFieldLength;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class to store a contact person details.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "contact_person")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ContactPerson implements Serializable, PersistentObject {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String notes;

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
     * Gets the firstName.
     *
     * @return the firstName
     */
    @Column(name = "contact_fname")
    @Length(max = HibernateFieldLength.CONTACT_PERSON_FIRST_NAME)
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the firstName.
     *
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the lastName.
     *
     * @return the lastName
     */
    @Column(name = "contact_lname")
    @Length(max = HibernateFieldLength.CONTACT_PERSON_LAST_NAME)
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the lastName.
     *
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    @Column(name = "contact_email")
    @Length(max = HibernateFieldLength.CONTACT_PERSON_EMAIL_LENGTH)
    @Email()
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the notes.
     *
     * @return the notes.
     */
    @Column(name = "contact_notes")
    @Length(max = HibernateFieldLength.CONTACT_PERSON_NOTES_LENGTH)
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
     * Copy a Contact Peson, and returns the new object.
     *
     * @param person the person to copy.
     * @return the new object.
     */
    public static ContactPerson getCopy(ContactPerson person) {
        ContactPerson newPerson = new ContactPerson();
        newPerson.setEmail(person.getEmail());
        newPerson.setFirstName(person.getFirstName());
        newPerson.setLastName(person.getLastName());
        newPerson.setNotes(person.getNotes());
        return newPerson;
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

        if (!(o instanceof ContactPerson)) {
            return false;
        }

        ContactPerson cperson = (ContactPerson) o;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder()
        .append(getId().toString(), cperson.getId().toString())
        .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        .append(getId().toString())
        .toHashCode();
    }
}
