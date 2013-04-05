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

/**
 * Class representing either of the following inputs and/or outputs:
1. Material input/output - a biological sample or a processed derivative of a sample. 
2. Data input/output.
 */
public class InputOutputObject implements Serializable {

    private static final long serialVersionUID = 200L;

    private Long id;
    private String name;
    private String dataFileURL;
    private String notes;
    private ProtocolApplication outputOfProtocolApplication;
    private ProtocolApplication inputToProtocolApplication;

    /**
     * Getter for id: Id of the input/output.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for id: Id of the input/output.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for name: Name of the input/output. 
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name: Name of the input/output. 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for dataFileURL: Location of the data input/output. If this field is null, it signifies a Material (Sample) input/output.
     */
    public String getDataFileURL() {
        return dataFileURL;
    }

    /**
     * Setter for dataFileURL: Location of the data input/output. If this field is null, it signifies a Material (Sample) input/output.
     */
    public void setDataFileURL(String dataFileURL) {
        this.dataFileURL = dataFileURL;
    }

    /**
     * Getter for notes: Additional notes/information for the input/output. 
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Setter for notes: Additional notes/information for the input/output. 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Getter for outputOfProtocolApplication: 
     */
    public ProtocolApplication getOutputOfProtocolApplication() {
        return outputOfProtocolApplication;
    }

    /**
     * Setter for outputOfProtocolApplication: 
     */
    public void setOutputOfProtocolApplication(ProtocolApplication outputOfProtocolApplication) {
        this.outputOfProtocolApplication = outputOfProtocolApplication;
    }

    /**
     * Getter for inputToProtocolApplication: 
     */
    public ProtocolApplication getInputToProtocolApplication() {
        return inputToProtocolApplication;
    }

    /**
     * Setter for inputToProtocolApplication: 
     */
    public void setInputToProtocolApplication(ProtocolApplication inputToProtocolApplication) {
        this.inputToProtocolApplication = inputToProtocolApplication;
    }

}
