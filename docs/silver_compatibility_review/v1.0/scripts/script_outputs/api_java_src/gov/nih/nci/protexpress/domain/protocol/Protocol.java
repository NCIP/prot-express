/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.protocol;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;

/**
 * Represents a protocol.
 */
public class Protocol implements Serializable {

    private static final long serialVersionUID = 200L;

    private Long id;
    private String name;
    private String description;
    private String software;
    private String instrument;
    private String notes;
    private String creator;
    private Date creationDate;
    private Date lastModifiedDate;
    private ContactPerson contactPerson;

    /**
     * Getter for id: Id for the Protocol
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id: Id for the Protocol
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for name: Name of the protocol.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name: Name of the protocol.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description: Description for the protocol.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description: Description for the protocol.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for software: Software used for the protocol. 
     */
    public String getSoftware() {
        return software;
    }

    /**
     * Setter for software: Software used for the protocol. 
     */
    public void setSoftware(String software) {
        this.software = software;
    }

    /**
     * Getter for instrument: Instruments, hardware used for the protocol. 
     */
    public String getInstrument() {
        return instrument;
    }

    /**
     * Setter for instrument: Instruments, hardware used for the protocol. 
     */
    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    /**
     * Getter for notes: Additional information/notes about the protocol.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for notes: Additional information/notes about the protocol.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Getter for creator: Creator of the protocol. 
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Setter for creator: Creator of the protocol. 
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Getter for creationDate: Date/Time the protocol was created.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Setter for creationDate: Date/Time the protocol was created.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Getter for lastModifiedDate: Date/Time the protocol was last modified. 
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Setter for lastModifiedDate: Date/Time the protocol was last modified. 
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Getter for contactPerson: 
     */
    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    /**
     * Setter for contactPerson: 
     */
    public void setContactPerson(ContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

}
