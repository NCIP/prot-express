package gov.nih.nci.protexpress.domain.experiment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

/**
 * The application of an experimental procedure to a specific set of inputs, producing a specific set of outputs.
 */
public class ExperimentRun implements Serializable {

    private static final long serialVersionUID = 200L;

    private Long id;
    private String name;
    private String notes;
    private Date datePerformed;
    private String creator;
    private Date creationDate;
    private Date lastModifiedDate;
    private Experiment experiment;
    private Set<ProtocolApplication> protocolApplications;

    /**
     * Getter for id: Id for the Experiment Run.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id: Id for the Experiment Run.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for name: Name of the Experiment Run.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name: Name of the Experiment Run.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for notes: Notes/Additional information for the experiment run. 
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for notes: Notes/Additional information for the experiment run. 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Getter for datePerformed: Date the Run was performed. 
     */
    public Date getDatePerformed() {
        return datePerformed;
    }

    /**
     * Setter for datePerformed: Date the Run was performed. 
     */
    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    /**
     * Getter for creator: Creator of the Experiment Run. 
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Setter for creator: Creator of the Experiment Run. 
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Getter for creationDate: Date/Time when the experiment run was created. 
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Setter for creationDate: Date/Time when the experiment run was created. 
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Getter for lastModifiedDate: Date/Time when the experiment run was last modified. 
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Setter for lastModifiedDate: Date/Time when the experiment run was last modified. 
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Getter for experiment: 
     */
    public Experiment getExperiment() {
        return experiment;
    }

    /**
     * Setter for experiment: 
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Getter for protocolApplications: 
     */
    public Set<ProtocolApplication> getProtocolApplications() {
        return protocolApplications;
    }

    /**
     * Setter for protocolApplications: 
     */
    public void setProtocolApplications(Set<ProtocolApplication> protocolApplications) {
        this.protocolApplications = protocolApplications;
    }

}
