/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;
/**
 * @author Krishna Kanchinadam
 *
 */
public enum SearchType {
    /**
     * Experiment Search.
     */
    EXPERIMENTS("Experiments"),
    /**
     * Protocol Search.
     */
    PROTOCOLS("Protocols");

    private String displayName;

    /**
     * Constructor for SearchType.
     *
     * @param displayname the display name
     */
    private SearchType(String displayname) {
        this.displayName = displayname;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return this.displayName;
    }
}
