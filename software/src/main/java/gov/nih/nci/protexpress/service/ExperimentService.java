/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.domain.experiment.ExperimentRun;
import gov.nih.nci.protexpress.domain.protocol.InputOutputObject;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;

/**
 * Service to handle the manipulation of experiments.
 *
 * @author Scott Miller, Krishna Kanchinadam
 */
public interface ExperimentService {

    /**
     * Searches for experiments that match the given criteria.
     *
     * @param params the params for the search
     * @return the number of experiments that match the search
     */
    int countMatchingExperiments(SearchParameters params);

    /**
     * Searches for experiments that match the given criteria.
     *
     * @param params the params for the search
     * @param maxResults the max number of results to return
     * @param firstResult the first result to return
     * @param sortProperty the name of the property to sort on
     * @param sortDir the direction of the sort
     * @return the experiments that match the search
     */
    List<Experiment> searchForExperiments(SearchParameters params, int maxResults, int firstResult,
            String sortProperty, SortOrderEnum sortDir);

    /**
     * Get the experiments the user has edited most recently.
     *
     * @param username the username of the user
     * @param numberOfExperiments the number of experiments to return
     * @return the list of {@link Experiment}
     */
    List<Experiment> getMostRecentExperimentsforUser(String username, int numberOfExperiments);

    /**
     * Retrieve the experiment with the given identifier.
     *
     * @param id the id of the experiment to retrive
     * @return the {@link Experiment}
     */
    Experiment getExperimentById(Long id);

    /**
     * Retrieve the experiment run with the given identifier.
     *
     * @param id the id of the experiment run.
     * @return the {@link ExperimentRun}
     */
    ExperimentRun getExperimentRunById(Long id);

    /**
     * Retrieve the input output object with the given identifier.
     *
     * @param id the id of the input output object.
     * @return the {@link InputOutputObject}
     */
    InputOutputObject getInputOutputObjectById(Long id);

    /**
     * Retrieve the protocol application with the given id.
     *
     * @param id the identifier of the protocol application.
     * @return the {@link ProtocolApplication}
     */
    ProtocolApplication getProtocolApplicationById(Long id);

    /**
     * delete the given experiment.
     *
     * @param experiment the experiment to delete
     */
    void deleteExperiment(Experiment experiment);

    /**
     * delete the given experiment run.
     *
     * @param experimentRun the experiment run to delete.
     */
    void deleteExperimentRun(ExperimentRun experimentRun);

    /**
     * delete the given input output object.
     *
     * @param inputOutputObject the input output object to delete.
     */
    void deleteInputOutputObject(InputOutputObject inputOutputObject);

    /**
     * delete the {@link ProtocolApplication}.
     *
     * @param protocolApplication the protocol application to delete
     */
    void deleteProtocolApplication(ProtocolApplication protocolApplication);
}