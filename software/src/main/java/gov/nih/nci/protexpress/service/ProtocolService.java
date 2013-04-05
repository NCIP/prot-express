/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import gov.nih.nci.protexpress.domain.protocol.Protocol;

import java.util.List;

import org.displaytag.properties.SortOrderEnum;

/**
 * Service to handle the manipulation of protocols.
 *
 * @author Scott Miller
 */
public interface ProtocolService {

    /**
     * Searches for protocols that match the given criteria.
     *
     * @param params the params for the search
     * @return the number of protocols that match the search
     */
    int countMatchingProtocols(SearchParameters params);

    /**
     * Searches for protocols that match the given criteria.
     *
     * @param params the params for the search
     * @param maxResults the max number of results to return
     * @param firstResult the first result to return
     * @param sortProperty the name of the property to sort on
     * @param sortDir the direction of the sort
     * @return the protocols that match the search
     */
    List<Protocol> searchForProtocols(SearchParameters params, int maxResults, int firstResult,
            String sortProperty, SortOrderEnum sortDir);

    /**
     * return the list of protocols owned by the current user with the given protocol name start.
     * @param protocolName the start of the name of the protocol
     * @return the protocols
     */
    List<Protocol> getProtocolsForCurrentUserByName(String protocolName);

    /**
     * Get the protocols the user has edited most recently.
     *
     * @param username the username of the user
     * @param numberOfProtocols the number of protocols to return
     * @return the protocols
     */
    List<Protocol> getMostRecentProtocolsforUser(String username, int numberOfProtocols);

    /**
     * Retrieve the protocol with the given identifier.
     *
     * @param id the id of the protocol to retrive
     * @return the protocol to retrieve
     */
    Protocol getProtocolById(Long id);

    /**
     * delete the given protocol.
     *
     * @param protocol the protocol to delete
     */
    void deleteProtocol(Protocol protocol);
}