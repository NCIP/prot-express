/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.protocol;

import gov.nih.nci.protexpress.domain.HibernateFieldLength;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class representing a Material object - a biological sample or a processed
 * derivative of a sample.
 *
 * @author Krishna Kanchinadam
 */
@Entity
@Table(name = "input_output_object")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class InputOutputObject implements Serializable, PersistentObject {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String dataFileURL;
    private String notes;

    private ProtocolApplication outputOfProtocolApplication = null;
    private ProtocolApplication inputToProtocolApplication = null;

    /**
     * protected default constructor for hibernate only.
     */
    protected InputOutputObject() {
    }

    /**
     * Constructor to create the object and populate all required fields.
     *
     * @param name the name of the input output object.
     */
    public InputOutputObject(String name) {
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
    @NotEmpty
    @Length(max = HibernateFieldLength.IO_NAME_LENGTH)
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
     * Gets the dataFileURL.
     *
     * @return the dataFileURL.
     */
    @Column(name = "data_file_url")
    @Length(max = HibernateFieldLength.IO_DATA_FILE_URL_LENGTH)
    public String getDataFileURL() {
        return dataFileURL;
    }

    /**
     * Sets the dataFileURL.
     *
     * @param dataFileURL the dataFileURL to set.
     */
    public void setDataFileURL(String dataFileURL) {
        this.dataFileURL = dataFileURL;
    }

    /**
     * Gets the notes.
     *
     * @return the notes.
     */
    @Column(name = "notes")
    @Length(max = HibernateFieldLength.IO_NOTES_LENGTH)
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
     * Gets the outputOfProtocolApplication.
     *
     * @return the outputOfProtocolApplication.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "protapp_outputs",
            joinColumns = { @JoinColumn(name = "output_id") },
            inverseJoinColumns = { @JoinColumn(name = "protapp_id") })
    public ProtocolApplication getOutputOfProtocolApplication() {
        return outputOfProtocolApplication;
    }

    /**
     * Sets the outputOfProtocolApplication.
     *
     * @param outputOfProtocolApplication the outputOfProtocolApplication to set.
     */
    public void setOutputOfProtocolApplication(
            ProtocolApplication outputOfProtocolApplication) {
        this.outputOfProtocolApplication = outputOfProtocolApplication;
    }

    /**
     * Gets the inputToProtocolApplication.
     *
     * @return the inputToProtocolApplication.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "protapp_inputs",
            joinColumns = { @JoinColumn(name = "input_id") },
            inverseJoinColumns = { @JoinColumn(name = "protapp_id") })
    public ProtocolApplication getInputToProtocolApplication() {
        return inputToProtocolApplication;
    }

    /**
     * Sets the inputToProtocolApplication.
     *
     * @param inputToProtocolApplication the inputToProtocolApplication to set.
     */
    public void setInputToProtocolApplication(
            ProtocolApplication inputToProtocolApplication) {
        this.inputToProtocolApplication = inputToProtocolApplication;
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

        if (!(o instanceof InputOutputObject)) {
            return false;
        }

        InputOutputObject ioObj = (InputOutputObject) o;

        if (this.id == null) {
            return false;
        }

        return new EqualsBuilder()
        .append(getId().toString(), ioObj.getId().toString())
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
