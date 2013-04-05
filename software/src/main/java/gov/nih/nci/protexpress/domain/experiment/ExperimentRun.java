/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.experiment;

import gov.nih.nci.protexpress.domain.Auditable;
import gov.nih.nci.protexpress.domain.HibernateFieldLength;
import gov.nih.nci.protexpress.domain.audit.AuditInfo;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class representing an experiment run.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "experiment_run")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ExperimentRun implements Serializable, PersistentObject, Auditable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String notes;
    private Date datePerformed = new Date();
    private AuditInfo auditInfo = new AuditInfo();
    private Experiment experiment;
    private List<ProtocolApplication> protocolApplications = new ArrayList<ProtocolApplication>();

    /**
     * protected default constructor for hibernate only.
     */
    protected ExperimentRun() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param name the name of the experiment
     */
    public ExperimentRun(String name) {
        setName(name);
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
     * Sets the id.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    @Column(name = "name")
    @NotEmpty
    @Length(max = HibernateFieldLength.EXPRUN_NAME_LENGTH)
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
     * Gets the notes.
     *
     * @return the notes
     */
    @Column(name = "notes")
    @Length(max = HibernateFieldLength.EXPRUN_NOTES_LENGTH)
    public String getNotes() {
        return this.notes;
    }

    /**
     * Sets the notes.
     *
     * @param notes the notes to set
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
     * Gets the experiment.
     *
     * @return the experiment
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "experiment_id", nullable = false)
    @Valid
    public Experiment getExperiment() {
        return this.experiment;
    }

    /**
     * Sets the experiment.
     *
     * @param experiment the experiment to set
     */
    public void setExperiment(Experiment experiment) {
        this.experiment = experiment;
    }

    /**
     * Gets the protocolApplications.
     *
     * @return the protocolApplications.
     */
    @OneToMany(mappedBy = "experimentRun", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ProtocolApplication> getProtocolApplications() {
        return this.protocolApplications;
    }

    /**
     * Sets the protocolApplications.
     *
     * @param protocolApplications the protocolApplications to set.
     */
    protected void setProtocolApplications(List<ProtocolApplication> protocolApplications) {
        this.protocolApplications = protocolApplications;
    }

    /**
     * Returns a copy of the experiment run.
     *
     * @param srcExpRun the source experiment run to copy.
     * @return the new object.
     */
    public static ExperimentRun getCopy(ExperimentRun srcExpRun) {

        ExperimentRun newExpRun = new ExperimentRun(srcExpRun.getName());
        newExpRun.setDatePerformed(srcExpRun.getDatePerformed());
        newExpRun.setExperiment(srcExpRun.getExperiment());
        newExpRun.setNotes(srcExpRun.getNotes());
        for (ProtocolApplication protApp : srcExpRun.getProtocolApplications()) {
            ProtocolApplication newProtApp = ProtocolApplication.getCopy(protApp);
            newProtApp.setExperimentRun(newExpRun);
            newExpRun.getProtocolApplications().add(newProtApp);
        }

        return newExpRun;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        if (!(obj instanceof ExperimentRun)) {
            return false;
        }

        ExperimentRun experimentRun = (ExperimentRun) obj;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder()
        .append(getId().toString(), experimentRun.getId().toString())
        .append(getName(), experimentRun.getName())
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
