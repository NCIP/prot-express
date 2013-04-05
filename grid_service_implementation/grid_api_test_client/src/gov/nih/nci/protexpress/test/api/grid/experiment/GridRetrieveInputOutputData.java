/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test.api.grid.experiment;


import gov.nih.nci.protexpress.test.api.AbstractApiTest;
import gov.nih.nci.protexpress.test.base.TestProperties;

import org.junit.Test;

/**
 * A client querying experiment information through the protExpress Grid service.
 *
 * @author Krishna Kanchinadam (kanchink@mail.nih.gov)
 */

public class GridRetrieveInputOutputData extends AbstractApiTest {

    public GridRetrieveInputOutputData() {

    }

    @Test
    public void testRetrieveExperimenData() {
        String targetObject = TARGET_OBJECT_INPUT_OUTPUT;
        String objectId = TestProperties.getInputOutputObjectId();
        runTest(targetObject, objectId);
    }
}