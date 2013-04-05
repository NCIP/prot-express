/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.data.validator;

import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.fiveamsolutions.nci.commons.data.persistent.PersistentObject;

/**
 * Class validator that uses a thread local to allow the property validators to access the current bean.
 * @param <T> the class the validation will run against.
 * @author Scott Miller
 */
public class ContextualClassValidator<T> extends ClassValidator<T> {
    private static final long serialVersionUID = 1L;
    private static ThreadLocal<PersistentObject> currentBeanThreadLocal = new ThreadLocal<PersistentObject>();

    /**
     * Get the bean currently being validated in this thread.
     *
     * @return the bean that was last passed to the getInvalidValues methods in this thread.
     */
    public static PersistentObject getCurrentBean() {
        return currentBeanThreadLocal.get();
    }

    /**
     * Constructs the class validator.
     *
     * @param beanClazz the class to validate.
     */
    public ContextualClassValidator(Class<T> beanClazz) {
        super(beanClazz);
        setCurrentBean(null);
    }

    private void setCurrentBean(PersistentObject bean) {
        currentBeanThreadLocal.set(bean);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvalidValue[] getInvalidValues(T bean, String propertyName) {
        try {
            setCurrentBean((PersistentObject) bean);
            return super.getInvalidValues(bean, propertyName);
        } finally {
            setCurrentBean(null);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InvalidValue[] getInvalidValues(T bean) {
        try {
            setCurrentBean((PersistentObject) bean);
            return super.getInvalidValues(bean);
        } finally {
            setCurrentBean(null);
        }
    }
}