/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters.test;

import java.util.Calendar;

import junit.framework.TestCase;

import gov.nih.nci.protexpress.ui.converters.CalendarConverter;

/**
 * @author Scott Miller
 *
 */
public class CalendarConverterTest extends TestCase {

    public void testCalendarConversion() {
        String srcDateString = "4/28/79";
        CalendarConverter converter = new CalendarConverter();
        Calendar cal = (Calendar) converter.convertFromString(null, new String[] { srcDateString }, Calendar.class);
        String str = converter.convertToString(null, cal);
        assertEquals(srcDateString, str);
    }
}