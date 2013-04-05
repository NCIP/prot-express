/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.data.validator;

import gov.nih.nci.protexpress.ProtExpressRegistry;

import java.util.Iterator;

import org.hibernate.mapping.Column;
import org.hibernate.mapping.Property;
import org.hibernate.validator.PropertyConstraint;
import org.hibernate.validator.Validator;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * @author Scott Miller
 *
 */
public class UniqueConstraintValidator implements Validator<UniqueConstraint>, PropertyConstraint {

    private String propertyName;

    /**
     * {@inheritDoc}
     */
    public void initialize(UniqueConstraint annotation) {
        this.propertyName = annotation.propertyName();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isValid(Object propValue) {
        PersistentObject bean = ContextualClassValidator.getCurrentBean();
        if (bean == null) {
            return true;
        }
        return ProtExpressRegistry.getProtExpressService().isFieldUnique(bean, this.propertyName, propValue);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public void apply(Property property) {
        if (!property.isComposite()) { // currently not supporting composite columns
            Iterator<Column> iter = property.getColumnIterator();
            while (iter.hasNext()) {
                iter.next().setUnique(true);
            }
        }
    }
}
