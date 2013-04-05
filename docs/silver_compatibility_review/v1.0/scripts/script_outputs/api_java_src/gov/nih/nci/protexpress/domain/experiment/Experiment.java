/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.experiment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import gov.nih.nci.protexpress.domain.contact.ContactPerson;

/**
 * A set of lab procedures ("runs") executed on specified inputs and producing one or more outputs.  The set of runs are analyzed together to support some result.
 */
public class Experiment implements Serializable {

    private static final long serialVersionUID = 200L;

    private Long id;
    private String name;
    private String description;
    private String hypothesis;
    private String url;
    private String notes;
    private Date datePerformed;
    private String creator;
    private Date creationDate;
    private Date lastModifiedDate;
    private Set<ExperimentRun> experimentRuns;
    private ContactPerson contactPerson;

    /**
     * Getter for id: Id for the experiment. 
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id: Id for the experiment. 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for name: Name of the experiment. 
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name: Name of the experiment. 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for description: Description for the experiment. 
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description: Description for the experiment. 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for hypothesis: Hypothesis for the experiment. 
     */
    public String getHypothesis() {
        return hypothesis;
    }

    /**
     * Setter for hypothesis: Hypothesis for the experiment. 
     */
    public void setHypothesis(String hypothesis) {
        this.hypothesis = hypothesis;
    }

    /**
     * Getter for url: Experiment's URL, if applicable. 
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter for url: Experiment's URL, if applicable. 
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Getter for notes: Additional notes/information for the experiment.
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for notes: Additional notes/information for the experiment.
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Getter for datePerformed: Date the experiment was performed. 
     */
    public Date getDatePerformed() {
        return datePerformed;
    }

    /**
     * Setter for datePerformed: Date the experiment was performed. 
     */
    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    /**
     * Getter for creator: Creator of the experiment. 
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Setter for creator: Creator of the experiment. 
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Getter for creationDate: Date/Time the experiment was created. 
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Setter for creationDate: Date/Time the experiment was created. 
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Getter for lastModifiedDate: Date/Time the experiment was last modified. 
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Setter for lastModifiedDate: Date/Time the experiment was last modified. 
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Getter for experimentRuns: 
     */
    public Set<ExperimentRun> getExperimentRuns() {
        return experimentRuns;
    }

    /**
     * Setter for experimentRuns: 
     */
    public void setExperimentRuns(Set<ExperimentRun> experimentRuns) {
        this.experimentRuns = experimentRuns;
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
