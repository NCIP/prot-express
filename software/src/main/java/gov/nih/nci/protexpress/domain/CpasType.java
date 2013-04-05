/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain;

/**
 * @author Krishna Kanchinadam
 *
 */
public enum CpasType {
    /**
     * The Material type.
     */
    MATERIAL("Material"),
    /**
     * The Data type.
     */
    DATA("Data"),
    /**
     * The ProtocolApplication type.
     */
    PROTOCOL_APPLICATION("ProtocolApplication"),
    /**
     * The ExperimentRun type.
     */
    EXPERIMENT_RUN("ExperimentRun"),
    /**
     * The ExperimentRunOutput type.
     */
    EXPERIMENT_RUN_OUTPUT("ExperimentRunOutput");

    private String displayName;

    /**
     * Constructor for CpasType.
     *
     * @param displayname the display name
     */
    private CpasType(String displayname) {
        this.displayName = displayname;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return this.displayName;
    }
}
