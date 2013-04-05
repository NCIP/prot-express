/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Helper class to convert between Date and Calendar Formats.
 *
 * @author Krishna Kanchinadam
 */

public final class DateHelper {
    /**
     * Default constructor.
     *
     */
    private DateHelper() {
    }

    /**
     * Given a Date object, returns a Calendar.
     *
     * @param date the date object
     * @return a Calendar
     */
    public static Calendar getDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    /**
     * Given a Calendar object, returns a Date.
     *
     * @param cal the Calendar object
     * @return a Date
     */
    public static Date getDate(Calendar cal) {
       return cal.getTime();
    }
}