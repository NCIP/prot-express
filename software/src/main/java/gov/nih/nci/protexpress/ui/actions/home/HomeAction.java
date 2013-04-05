/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.home;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.experiment.Experiment;
import gov.nih.nci.protexpress.ui.actions.ProtExpressBaseAction;
import gov.nih.nci.protexpress.util.UserHolder;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Actions for the home functionality.
 *
 * @author Krishna Kanchinadam
 */
public class HomeAction extends ProtExpressBaseAction {
    private static final int NUM_RECENT_RESULTS_TO_DISPLAY = 3;

    private List<Experiment> recentExperiments;

    /**
     * Action for loading the home.
     *
     * @return the directive for the next action / page to be directed to
     */
    public String load() {
        setRecentExperiments(ProtExpressRegistry.getExperimentService().getMostRecentExperimentsforUser(
                UserHolder.getUsername(), NUM_RECENT_RESULTS_TO_DISPLAY));
        return ActionSupport.SUCCESS;
    }

    /**
     * @return the recentExperiments
     */
    public List<Experiment> getRecentExperiments() {
        return this.recentExperiments;
    }

    /**
     * @param recentExperiments the recentExperiments to set
     */
    public void setRecentExperiments(List<Experiment> recentExperiments) {
        this.recentExperiments = recentExperiments;
    }
}