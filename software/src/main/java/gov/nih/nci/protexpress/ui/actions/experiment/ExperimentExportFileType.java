/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment;

/**
 * @author Scott Miller, Krishna Kanchinadam
 *
 */
public enum ExperimentExportFileType {
    /**
     * The type for XAR 2.3.
     */
    Xar2_3("XAR 2.3");

    private String displayName;

    /**
     * Constructor for ExperimentExportFileType.
     *
     * @param displayname the display name
     */
    private ExperimentExportFileType(String displayname) {
        this.displayName = displayname;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return this.displayName;
    }
}
