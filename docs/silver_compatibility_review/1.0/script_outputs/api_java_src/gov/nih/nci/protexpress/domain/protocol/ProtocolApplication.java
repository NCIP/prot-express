package gov.nih.nci.protexpress.domain.protocol;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;

/**
 * An object representing the application of a protocol within the context of an ExperimentRun.
 */
public class ProtocolApplication implements Serializable {

    private static final long serialVersionUID = 200L;

    private Long id;
    private Date datePerformed;
    private String comments;
    private String notes;
    private String creator;
    private Date creationDate;
    private Date lastModifiedDate;
    private Set<InputOutputObject> outputs;
    private Set<InputOutputObject> inputs;
    private Protocol protocol;
    private ExperimentRun experimentRun;

    /**
     * Getter for id: Id of the protocol application object.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id: Id of the protocol application object.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for datePerformed: Date the protocol was applied in the context of an Experiment Run.
     */
    public Date getDatePerformed() {
        return datePerformed;
    }

    /**
     * Setter for datePerformed: Date the protocol was applied in the context of an Experiment Run.
     */
    public void setDatePerformed(Date datePerformed) {
        this.datePerformed = datePerformed;
    }

    /**
     * Getter for comments: Comments for the protocol application.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Setter for comments: Comments for the protocol application.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Getter for notes: Additional notes/information about the protocol application. 
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for notes: Additional notes/information about the protocol application. 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Getter for creator: Creator of the protocol application. 
     */
    public String getCreator() {
        return creator;
    }

    /**
     * Setter for creator: Creator of the protocol application. 
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * Getter for creationDate: Date/Time the protocol application was created. 
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Setter for creationDate: Date/Time the protocol application was created. 
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Getter for lastModifiedDate: Date/Time the protocol was last updated. 
     */
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * Setter for lastModifiedDate: Date/Time the protocol was last updated. 
     */
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * Getter for outputs: 
     */
    public Set<InputOutputObject> getOutputs() {
        return outputs;
    }

    /**
     * Setter for outputs: 
     */
    public void setOutputs(Set<InputOutputObject> outputs) {
        this.outputs = outputs;
    }

    /**
     * Getter for inputs: 
     */
    public Set<InputOutputObject> getInputs() {
        return inputs;
    }

    /**
     * Setter for inputs: 
     */
    public void setInputs(Set<InputOutputObject> inputs) {
        this.inputs = inputs;
    }

    /**
     * Getter for protocol: 
     */
    public Protocol getProtocol() {
        return protocol;
    }

    /**
     * Setter for protocol: 
     */
    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * Getter for experimentRun: 
     */
    public ExperimentRun getExperimentRun() {
        return experimentRun;
    }

    /**
     * Setter for experimentRun: 
     */
    public void setExperimentRun(ExperimentRun experimentRun) {
        this.experimentRun = experimentRun;
    }

}
