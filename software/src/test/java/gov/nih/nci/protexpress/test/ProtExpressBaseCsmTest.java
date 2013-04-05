/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test;

import junit.framework.TestCase;

/**
 * @author Scott Miller
 *
 */
public abstract class ProtExpressBaseCsmTest extends TestCase {
    private CsmInitializer csmInitializer;

    public ProtExpressBaseCsmTest() {
        csmInitializer = new CsmInitializer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        csmInitializer.dropAndCreateCsmDb();
    }
}