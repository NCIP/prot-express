/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service.impl;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.service.FormatConversionService;
import gov.nih.nci.protexpress.util.ExperimentToXar23FormatConversionHelper;
import gov.nih.nci.protexpress.util.Xar23ToExperimentFormatConversionHelper;
import gov.nih.nci.protexpress.xml.xar2_3.ExperimentArchiveType;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

/**
 * Format conversion service for the Xar.xml 2.3 format.
 *
 * @author Krishna Kanchinadam
 */
public class Xar23FormatConversionServiceImpl implements FormatConversionService {

    private static final QName QNAME = new QName("http://cpas.fhcrc.org/exp/xml", "ExperimentArchive");
    private static final String SCHEMA_LOCATION = "https://www.labkey.org/download/XarSchema/V2.3/expTypes.xsd";

    private JAXBContext jaxbContext;

    /**
     * Default constructor.
     *
     * @throws JAXBException thrown when the jaxb context can not be initialized
     */
    public Xar23FormatConversionServiceImpl() throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(ExperimentArchiveType.class.getPackage().getName());
    }

    /**
     * {@inheritDoc}
     */
    public void marshallExperiments(Experiment experiment, File output) throws JAXBException {
        getNewMarshaller().marshal(convertToExperimentArchive(experiment), output);
    }

    /**
     * {@inheritDoc}
     */
    public void marshallExperiments(Experiment experiment, OutputStream output) throws JAXBException {
        getNewMarshaller().marshal(convertToExperimentArchive(experiment), output);
    }

    /**
     * Method to get a new, configured marshaller.
     *
     * @return the marshaller
     * @throws JAXBException
     */
    private Marshaller getNewMarshaller() throws JAXBException {
        Marshaller marshaller = this.jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, SCHEMA_LOCATION);
        return marshaller;
    }

    /**
     * Converts the list of experiments to xar 2.2 archive data.
     *
     * @param experiments the experiments to convert
     * @return the xar 2.3 jaxb ready data
     */
    private JAXBElement<ExperimentArchiveType> convertToExperimentArchive(Experiment experiment) {
       ExperimentToXar23FormatConversionHelper expToXar23Helper =
           new ExperimentToXar23FormatConversionHelper(experiment);
       ExperimentArchiveType experimentArchive = expToXar23Helper.getExperimentArchiveData();
       return new JAXBElement<ExperimentArchiveType>(QNAME, ExperimentArchiveType.class, experimentArchive);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Experiment> unmarshallExperiments(File input) throws JAXBException {
        Unmarshaller u = this.jaxbContext.createUnmarshaller();
        JAXBElement<ExperimentArchiveType> experimentArchive = (JAXBElement<ExperimentArchiveType>) u.unmarshal(input);
        return convertToExperiments(experimentArchive.getValue());
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Experiment> unmarshallExperiments(InputStream input) throws JAXBException {
        Unmarshaller u = this.jaxbContext.createUnmarshaller();
        JAXBElement<ExperimentArchiveType> experimentArchive = (JAXBElement<ExperimentArchiveType>) u.unmarshal(input);
        return convertToExperiments(experimentArchive.getValue());
    }

    /**
     * converts the xar 2.2 experiment archive data to the internal data model.
     *
     * @param experimentArchive the experiment archive
     * @return the list of experiments.
     */
    private List<Experiment> convertToExperiments(ExperimentArchiveType experimentArchive) {
        Xar23ToExperimentFormatConversionHelper xar23ToExpHelper = new Xar23ToExperimentFormatConversionHelper();
        return xar23ToExpHelper.getExperimentData(experimentArchive);
    }
}
