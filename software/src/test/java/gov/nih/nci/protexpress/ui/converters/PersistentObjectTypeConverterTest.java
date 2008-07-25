package gov.nih.nci.protexpress.ui.converters;

import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;

public class PersistentObjectTypeConverterTest extends ProtExpressBaseHibernateTest {

    public void testGetGenericService() {
        assertNotNull(new PersistentObjectTypeConverter().getGenericDataService());
    }
}
