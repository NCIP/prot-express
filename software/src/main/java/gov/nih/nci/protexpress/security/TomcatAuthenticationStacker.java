/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.security;

import java.util.Map;

/**
 * Class used to assist in doing password stacking in Tomcat.
 *
 * @author Scott Miller
 */
public class TomcatAuthenticationStacker {
    /**
     * The location of the username in the shared state if the user has already been authenticated.
     */
    private static final String SHARED_STATE_USERNAME_LOCATION = "gov.nih.nci.protexpress.security.username";

    private Map sharedState;

    /**
     * Constructor.
     *
     * @param state the shared state
     */
    public TomcatAuthenticationStacker(Map state) {
        this.sharedState = state;
    }

    /**
     * Adds the user to the shared state in the proper place for this class to know if it has been authenticated by
     * another module.
     *
     * @param username the username.
     */
    @SuppressWarnings("unchecked")
    public void addAuthenticatedUserToSharedState(String username) {
        this.sharedState.put(SHARED_STATE_USERNAME_LOCATION, username);
    }

    /**
     * Removes the user from the shared state.
     */
    @SuppressWarnings("unchecked")
    public void removeUserFromSharedState() {
        this.sharedState.remove(SHARED_STATE_USERNAME_LOCATION);
    }

    /**
     * Checks if a user has already been authenticated.
     *
     * @param username the username.
     * @return true if the user has already been added to the shared state, false otherwise
     */
    public boolean isUserAlreadyAuthenticated(String username) {
        if (username != null && username.equals(this.sharedState.get(SHARED_STATE_USERNAME_LOCATION))) {
            return true;
        }
        return false;
    }
}
