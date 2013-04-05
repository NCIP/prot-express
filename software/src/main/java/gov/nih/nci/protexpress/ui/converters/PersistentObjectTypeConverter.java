/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.converters;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.service.GenericDataService;

import com.fiveamsolutions.nci.commons.web.struts2.converter.AbstractPersistentObjectTypeConverter;

/**
 * Converter to move between persistent objects and their id's.
 * @author Scott Miller
 */
public class PersistentObjectTypeConverter extends AbstractPersistentObjectTypeConverter {
    

    /**
     * {@inheritDoc}
     */
    @Override
    protected GenericDataService getGenericDataService() {
        return (GenericDataService) ProtExpressRegistry.getGenericDataService();
    }
}
