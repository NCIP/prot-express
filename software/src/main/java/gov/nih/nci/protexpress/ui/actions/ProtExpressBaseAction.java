/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;


/**
 * Base action class for protExpress.
 *
 * @author Krishna Kanchinadam
 */
public class ProtExpressBaseAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private Logger protExpressLogger = Logger.getLogger(this.getClass().getName());
    private String successMessage = null;
    private String errorMessage = null;

    /**
     * Logs a debug message.
     * @param message the debug message.
     */
    protected void logDebugMessage(String message) {
        getProtExpressLogger().debug(message);
    }

    /**
     * Logs an error message.
     * @param message the error message.
     */
    protected void logErrorMessage(String message) {
        getProtExpressLogger().error(message);
    }

    /**
     * Gets the protExpressLogger.
     *
     * @return the protExpressLogger.
     */
    public Logger getProtExpressLogger() {
        return protExpressLogger;
    }

    /**
     * Sets the protExpressLogger.
     *
     * @param protExpressLogger the protExpressLogger to set.
     */
    public void setProtExpressLogger(Logger protExpressLogger) {
        this.protExpressLogger = protExpressLogger;
    }

    /**
     * Gets the successMessage.
     *
     * @return the successMessage.
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * Sets the successMessage.
     *
     * @param successMessage the successMessage to set.
     */
    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    /**
     * Gets the errorMessage.
     *
     * @return the errorMessage.
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the errorMessage.
     *
     * @param errorMessage the errorMessage to set.
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Returns the directive for the next action/page to be displayed to the user.
     *
     * @param resultEnum the enum for which the result string needs to be looked up.
     * @return the directive for the next action / page to be directed to
     */
    public String getActionResult(ActionResultEnum resultEnum) {
        return resultEnum.getDisplayName();
    }
}










































