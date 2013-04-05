/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.domain.audit;

import gov.nih.nci.protexpress.domain.HibernateFieldLength;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Class to store the auditing fields.
 *
 * @author Scott Miller
 */
@Embeddable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class AuditInfo {
    private String creator;
    private Calendar creationDate = Calendar.getInstance();
    private Calendar lastModifiedDate = Calendar.getInstance();


    /**
     * {@inheritDoc}
     */
    // note, this does not use hibernate validator annotations, because field is set by an interceptor, and thus should
    // not be validated at the UI
    @Column(name = "creator", nullable = false, length = HibernateFieldLength.AUDIT_CREATOR_LENGTH)
    public String getCreator() {
        return this.creator;
    }

    /**
     * {@inheritDoc}
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * {@inheritDoc}
     */
    // note, this does not use hibernate validator annotations, because field is set by an interceptor, and thus should
    // not be validated at the UI
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date", nullable = false)
    public Calendar getCreationDate() {
        return this.creationDate;
    }

    /**
     * {@inheritDoc}
     */
    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * {@inheritDoc}
     */
    // note, this does not use hibernate validator annotations, because field is set by an interceptor, and thus should
    // not be validated at the UI
    @Column(name = "modification_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    /**
     * {@inheritDoc}
     */
    public void setLastModifiedDate(Calendar lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}