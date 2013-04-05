/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.contact;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Encapsulates the information for a Protocol and/or Experiment contact person.
 */
public class ContactPerson implements Serializable {

    private static final long serialVersionUID = 200L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String notes;

    /**
     * Getter for id: Id for the Contact person. 
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id: Id for the Contact person. 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for firstName: First Name of the contact person. 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for firstName: First Name of the contact person. 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for lastName: Last Name of the contact person. 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for lastName: Last Name of the contact person. 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for email: E-Mail Id for the contact person. 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email: E-Mail Id for the contact person. 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for notes: Additional notes about the Contact person.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for notes: Additional notes about the Contact person.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

}
