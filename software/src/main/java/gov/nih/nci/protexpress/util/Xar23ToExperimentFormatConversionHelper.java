/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */


package gov.nih.nci.protexpress.util;

import java.util.List;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.xml.xar2_3.ExperimentArchiveType;


/**
 * Format conversion helper class for the Xar.xml 2.3 format.
 *
 * @author Krishna Kanchinadam
 */

public class Xar23ToExperimentFormatConversionHelper {
    /**
     * Default constructor.
     *
     */
    public Xar23ToExperimentFormatConversionHelper() {
    }

   /**
     * Given a list of Experiment objects, creates and returns an ExperimentArchiveType.
     *
     * @param experimentArchive the experiment archive
     * @return an Experiment
     */
    public List<Experiment> getExperimentData(ExperimentArchiveType experimentArchive) {
        return null;
    }
}
