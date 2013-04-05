/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import gov.nih.nci.protexpress.domain.experiment.Experiment;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBException;

/**
 * Implementations of this service will provide the ability to convert experiment data from a specific file format to
 * the internal data model and vice versa.
 *
 * @author Scott Miller
 */
public interface FormatConversionService {

    /**
     * Take the experiment and write it to the file, converting it to the correct format.
     * @param experiment the experiment
     * @param output the file.
     * @throws JAXBException on marshalling error
     */
    void marshallExperiments(Experiment experiment, File output) throws JAXBException;

    /**
     * Take the experiment and write it to the stream, converting it to the correct format.
     * @param experiment the experiments
     * @param output the output stream.
     * @throws JAXBException on marshalling error
     */
    void marshallExperiments(Experiment experiment, OutputStream output) throws JAXBException;

    /**
     * Take the file and convert it to a list of experiments.
     *
     * @param input the file to convert.
     * @return the list of experiments.
     * @throws JAXBException on unmarshalling error
     */
    List<Experiment> unmarshallExperiments(File input) throws JAXBException;

    /**
     * Take the input stream and convert it to a list of experiments.
     *
     * @param input the input stream.
     * @return the list of experiments.
     * @throws JAXBException on unmarshalling error
     */
    List<Experiment> unmarshallExperiments(InputStream input) throws JAXBException;
}