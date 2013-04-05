/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.opensymphony.xwork2.util.XWorkBasicConverter;

/**
 * Type converter to handle converting to a Calendar.
 * @author Scott Miller
 *
 */
public class CalendarConverter extends StrutsTypeConverter {
    private final XWorkBasicConverter converter = new XWorkBasicConverter();

    /**
     * {@inheritDoc}
     */
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        Date dt = (Date) this.converter.convertValue(context, null, null, null, values[0], Date.class);
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        return cal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String convertToString(Map context, Object o) {
        Calendar cal = (Calendar) o;
        return (String) this.converter.convertValue(context, null, null, null, cal.getTime(), String.class);
    }
}
