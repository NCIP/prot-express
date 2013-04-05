/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.service;

import gov.nih.nci.protexpress.domain.register.Country;
import gov.nih.nci.protexpress.domain.register.RegistrationRequest;
import gov.nih.nci.protexpress.domain.register.State;

import java.util.List;

/**
 * Provides registration management functionality to the application.
 */
public interface RegistrationService {

    /**
     * Persists a registration.
     *
     * @param registrationRequest the new registrationRequest to save
     */
    void register(RegistrationRequest registrationRequest);
    
    /**
     * Gets all countries.
     * @return all countries.
     */
    List<Country> getCountries();
    
    /**
     * Gets all states.
     * @return all states.
     */
    List<State> getStates();
}
