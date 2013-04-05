/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters.test;

import org.displaytag.properties.SortOrderEnum;

import gov.nih.nci.protexpress.ui.converters.SortOrderEnumConverter;
import junit.framework.TestCase;

/**
 * @author Scott Miller
 *
 */
public class SortOrderEnumConverterTest extends TestCase {

    public void testConversion() {
        SortOrderEnumConverter converter = new SortOrderEnumConverter();
        assertEquals("ascending", converter.convertToString(null, SortOrderEnum.ASCENDING));
        assertEquals("descending", converter.convertToString(null, SortOrderEnum.DESCENDING));
        assertEquals(null, converter.convertToString(null, null));

        assertEquals(SortOrderEnum.ASCENDING, converter.convertValue(null, new String[] { "ascending" },
                SortOrderEnum.class));
        assertEquals(SortOrderEnum.DESCENDING, converter.convertValue(null, new String[] { "descending" },
                SortOrderEnum.class));
        assertEquals(null, converter.convertValue(null, new String[] {}, SortOrderEnum.class));
    }

}
