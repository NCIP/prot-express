/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;
import org.displaytag.properties.SortOrderEnum;

/**
 * @author Scott Miller
 *
 */
public class SortOrderEnumConverter extends StrutsTypeConverter {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values.length > 0 && toClass.equals(SortOrderEnum.class)) {
            return SortOrderEnum.fromName(values[0]);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToString(Map context, Object o) {
        if (o != null && o instanceof SortOrderEnum) {
            return ((SortOrderEnum) o).getName();
        }
        return null;
    }

}
