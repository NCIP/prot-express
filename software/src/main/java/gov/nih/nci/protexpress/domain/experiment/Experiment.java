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
import gov.nih.nci.protexpress.domain.contact.ContactPerson;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class representing an experiment.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "experiment")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Experiment implements Serializable, PersistentObject, Auditable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String hypothesis;
    private String url;
    private String notes;
    private Date datePerformed = new Date();
    private AuditInfo auditInfo = new AuditInfo();
    private ContactPerson contactPerson = new ContactPerson();
    private List<ExperimentRun> experimentRuns = new ArrayList<ExperimentRun>();

    /**
     * protected default constructor for hibernate only.
     */
    protected Experiment() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param name the name of the experiment
     *
     */
    public Experiment(String name) {
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
    @Length(max = HibernateFieldLength.EXPERIMENT_NAME_LENGTH)
    @NotEmpty
    @Index(name = "experiment_name_idx")
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
     * Gets the comments.
     *
     * @return the comments
     */
    @Column(name = "description")
    @Length(max = HibernateFieldLength.EXPERIMENT_DESCRIPTION_LENGTH)
    @Index(name = "experiment_description_idx")
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
     * Gets the hypothesis.
     *
     * @return the hypothesis
     */
    @Column(name = "hypothesis")
    @Length(max = HibernateFieldLength.EXPERIMENT_HYPOTHESIS_LENGTH)
    public String getHypothesis() {
        return this.hypothesis;
    }

    /**
     * Sets the hypothesis.
     *
     * @param hypothesis the hypothesis to set
     */
    public void setHypothesis(String hypothesis) {
        this.hypothesis = hypothesis;
    }

    /**
     * Sets the url.
     *
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    @Column(name = "url")
    @Length(max = HibernateFieldLength.EXPERIMENT_URL_LENGTH)
    public String getUrl() {
        return this.url;
    }

    /**
     * Gets the notes.
     *
     * @return the notes.
     */
    @Column(name = "notes")
    @Length(max = HibernateFieldLength.EXPERIMENT_NOTES_LENGTH)
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
     * Gets the experimentRuns.
     *
     * @return the experimentRuns.
     */
    @OneToMany(mappedBy = "experiment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<ExperimentRun> getExperimentRuns() {
        return this.experimentRuns;
    }

    /**
     * Sets the experimentRuns.
     *
     * @param experimentRuns the experimentRuns to set.
     */
    public void setExperimentRuns(List<ExperimentRun> experimentRuns) {
        this.experimentRuns = experimentRuns;
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

        if (!(o instanceof Experiment)) {
            return false;
        }

        Experiment exp = (Experiment) o;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder()
            .append(getId().toString(), exp.getId().toString())
            .append(getName(), exp.getName())
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