/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters.test;

import gov.nih.nci.protexpress.ui.actions.experiment.ExperimentExportFileType;
import gov.nih.nci.protexpress.ui.converters.EnumTypeConverter;
import junit.framework.TestCase;

/**
 * Test case for the enum type converter.
 * @author Scott Miller
 */
public class EnumTypeConverterTest extends TestCase {

    public void testConversion() throws Exception {
        EnumTypeConverter converter = new EnumTypeConverter();
        Enum convertedValue = converter.convertFromString(null, ExperimentExportFileType.class);
        assertEquals(null, convertedValue);

        convertedValue = converter.convertFromString(ExperimentExportFileType.Xar2_3.name(), ExperimentExportFileType.class);
        assertEquals(ExperimentExportFileType.Xar2_3, convertedValue);
    }
}
