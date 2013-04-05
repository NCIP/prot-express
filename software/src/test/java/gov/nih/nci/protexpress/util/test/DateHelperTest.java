/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.util.test;

import gov.nih.nci.protexpress.util.DateHelper;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

/**
 * @author Krishna Kanchinadam
 *
 */
public class DateHelperTest extends TestCase {

    public void testDateConversion() {
        Date dt = new Date();
        Calendar cal = DateHelper.getDate(dt);
        Date dtNew = DateHelper.getDate(cal);
        assertEquals(dtNew, dt);
    }
}