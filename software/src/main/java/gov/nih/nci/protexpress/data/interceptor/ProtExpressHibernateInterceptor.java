/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.data.interceptor;

import gov.nih.nci.protexpress.domain.audit.AuditInfo;
import gov.nih.nci.protexpress.domain.Auditable;
import gov.nih.nci.protexpress.security.IllegalModificationException;
import gov.nih.nci.protexpress.util.UserHolder;

import java.io.Serializable;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

/**
 * Interceptor for prot express.
 *
 * @author Scott Miller
 */
public class ProtExpressHibernateInterceptor extends EmptyInterceptor {
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Auditable) {
            for (int i = 0; i < propertyNames.length; i++) {
                if ("auditInfo".equals(propertyNames[i]) && StringUtils.isNotBlank(UserHolder.getUsername())) {
                    AuditInfo ai = (AuditInfo) state[i];
                    ai.setCreator(UserHolder.getUsername());
                    ai.setCreationDate(Calendar.getInstance());
                    ai.setLastModifiedDate(Calendar.getInstance());
                }
            }
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
            String[] propertyNames, Type[] types) {
        if (entity instanceof Auditable) {
            if (!((Auditable) entity).getAuditInfo().getCreator().equals(UserHolder.getUsername())) {
                throw new IllegalModificationException();
            }
            for (int i = 0; i < propertyNames.length; i++) {
                if ("auditInfo".equals(propertyNames[i])) {
                    AuditInfo ai = (AuditInfo) currentState[i];
                    ai.setLastModifiedDate(Calendar.getInstance());
                }
            }
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (entity instanceof Auditable
                && !((Auditable) entity).getAuditInfo().getCreator().equals(UserHolder.getUsername())) {
            throw new IllegalModificationException();
        }
        super.onDelete(entity, id, state, propertyNames, types);
    }
}