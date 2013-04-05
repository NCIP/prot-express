/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain;

import gov.nih.nci.protexpress.domain.audit.AuditInfo;

/**
 * Interface for all auditable entities.
 *
 * @author Scott Miller
 */
public interface Auditable {

    /**
     * The audit info.
     *
     * @return the audit info
     */
    AuditInfo getAuditInfo();

    /**
     * Set the audit info.
     *
     * @param auditInfo the audit info.
     */
    void setAuditInfo(AuditInfo auditInfo);
}