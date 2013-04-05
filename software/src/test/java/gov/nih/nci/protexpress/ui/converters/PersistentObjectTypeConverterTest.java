/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters;

import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;

public class PersistentObjectTypeConverterTest extends ProtExpressBaseHibernateTest {

    public void testGetGenericService() {
        assertNotNull(new PersistentObjectTypeConverter().getGenericDataService());
    }
}
