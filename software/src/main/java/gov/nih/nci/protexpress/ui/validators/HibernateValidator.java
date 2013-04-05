/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.validators;

import gov.nih.nci.protexpress.data.validator.ContextualClassValidator;

import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.validator.InvalidValue;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

/**
 * Class to provide hibernate validator support in Struts 2.
 *
 * @author Scott Miller
 */
public class HibernateValidator extends FieldValidatorSupport {

    private static final Logger LOG = Logger.getLogger(HibernateValidator.class);
    private static final HashMap<Class, ContextualClassValidator> CLASS_VALIDATOR_MAP =
        new HashMap<Class, ContextualClassValidator>();

    /**
     * {@inheritDoc}
     */
    public void validate(Object object) throws ValidationException {
        String fieldName = getFieldName();
        Object value = getFieldValue(fieldName, object);
        ValueStack stack = ActionContext.getContext().getValueStack();
        stack.push(object);
        if (value instanceof Collection) {
            Collection coll = (Collection) value;
            Object[] array = coll.toArray();
            validateArrayElements(array, fieldName);
        } else if (value instanceof Object[]) {
            Object[] array = (Object[]) value;
            validateArrayElements(array, fieldName);
        } else {
            validateObject(fieldName, value);
        }
        stack.pop();
    }

    private void validateArrayElements(Object[] array, String fieldName) {
        for (int i = 0; i < array.length; i++) {
            Object o = array[i];
            validateObject(fieldName + "[" + i + "]", o);
        }
    }

    @SuppressWarnings("unchecked")
    private void validateObject(String fieldName, Object o) {
        if (o == null) {
            LOG.warn("The visited object is null, VisitorValidator will not be able to handle validation properly. "
                    + "Please make sure the visited object is not null for VisitorValidator to function properly");
            return;
        }

        ContextualClassValidator classValidator = CLASS_VALIDATOR_MAP.get(o.getClass());
        if (classValidator == null) {
            classValidator = new ContextualClassValidator(o.getClass());
            CLASS_VALIDATOR_MAP.put(o.getClass(), classValidator);
        }
        InvalidValue[] validationMessages = classValidator.getInvalidValues(o);

        if (validationMessages.length > 0) {
            for (InvalidValue message : validationMessages) {
                String errorField = fieldName;
                String msg = message.getMessage();
                if (StringUtils.isNotBlank(message.getPropertyPath())) {
                    errorField = fieldName + "." + message.getPropertyPath();
                    msg = StringUtils.replace(msg, "fieldName", "\"" + errorField + "\"");
                }
                ValueStack stack = ActionContext.getContext().getValueStack();
                msg = TextParseUtil.translateVariables(msg, stack);
                getValidatorContext().addFieldError(errorField, msg);
            }
        }
    }
}
