/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters;

import org.apache.commons.lang.StringUtils;

/**
 * @author Scott Miller
 *
 */
public class EnumTypeConverter extends com.opensymphony.xwork2.util.EnumTypeConverter {

    /**
     * {@inheritDoc}
     */
    @Override
    public Enum convertFromString(String value, Class toClass) {
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return super.convertFromString(value, toClass);
    }
}