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
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;

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
import javax.persistence.JoinTable;
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
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class representing a protocol application.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "protocol_application")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProtocolApplication implements Serializable, Auditable, PersistentObject {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Date datePerformed = new Date();
    private String comments;
    private String notes;

    private Protocol protocol;
    private ExperimentRun experimentRun;

    private AuditInfo auditInfo = new AuditInfo();
    private List<InputOutputObject> inputs = new ArrayList<InputOutputObject>();
    private List<InputOutputObject> outputs = new ArrayList<InputOutputObject>();

    /**
     * protected default constructor for hibernate only.
     */
    protected ProtocolApplication() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param datePerformed the date performed
     * @param expRun the experiment run
     * @param protocol the protocol
     */
    public ProtocolApplication(Date datePerformed,
            ExperimentRun expRun, Protocol protocol) {
        setDatePerformed(datePerformed);
        setExperimentRun(expRun);
        setProtocol(protocol);
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
     * Gets the comments.
     *
     * @return the comments
     */
    @Column(name = "comments")
    @Length(max = HibernateFieldLength.PROTAPP_COMMENTS_LENGTH)
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
     * Gets the experimentRun.
     *
     * @return the experimentRun.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    @JoinColumn(name = "experiment_run_id")
    public ExperimentRun getExperimentRun() {
        return this.experimentRun;
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
     * Gets the protocol.
     *
     * @return the protocol.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    @JoinColumn(name = "protocol_id")
    @Valid
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
    }

    /**
     * Gets the notes.
     *
     * @return the notes.
     */
    @Column(name = "notes")
    @Length(max = HibernateFieldLength.PROTAPP_NOTES_LENGTH)
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
     * Gets the inputs.
     *
     * @return the inputs.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "protapp_inputs",
            joinColumns = { @JoinColumn(name = "protapp_id") },
            inverseJoinColumns = { @JoinColumn(name = "input_id") })
    public List<InputOutputObject> getInputs() {
        return inputs;
    }

    /**
     * Sets the inputs.
     *
     * @param inputs the inputs to set.
     */
    public void setInputs(List<InputOutputObject> inputs) {
        this.inputs = inputs;
    }

    /**
     * Gets the outputs.
     *
     * @return the outputs.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "protapp_outputs",
            joinColumns = { @JoinColumn(name = "protapp_id") },
            inverseJoinColumns = { @JoinColumn(name = "output_id") })
    public List<InputOutputObject> getOutputs() {
        return outputs;
    }

    /**
     * Sets the outputs.
     *
     * @param outputs the outputs to set.
     */
    public void setOutputs(List<InputOutputObject> outputs) {
        this.outputs = outputs;
    }

    /**
     * {@inheritDoc}
     */
    @Embedded
    @Valid
    public AuditInfo getAuditInfo() {
        return this.auditInfo;
    }

    /**
     * {@inheritDoc}
     */
    public void setAuditInfo(AuditInfo auditInfo) {
        this.auditInfo = auditInfo;
    }

    /**
     * Returns a copy of the protocol application.
     *
     * @param srcProtApp the source protocol application to copy.
     * @return the new object.
     */
    public static ProtocolApplication getCopy(ProtocolApplication srcProtApp) {

        ProtocolApplication newProtApp = new ProtocolApplication(
                srcProtApp.getDatePerformed(),
                srcProtApp.getExperimentRun(),
                srcProtApp.getProtocol());

        newProtApp.setComments(srcProtApp.getComments());
        newProtApp.setNotes(srcProtApp.getNotes());
        return newProtApp;
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

        return new EqualsBuilder()
        .append(getId().toString(), p.getId().toString())
        .append("ProtocolApplication-", "ProtocolApplication-")
        .append(getProtocol().getName(), p.getProtocol().getName())
        .isEquals();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
        .append(getId().toString())
        .append("ProtocolApplication-")
        .append(getProtocol().getName())
        .toHashCode();
    }
}
