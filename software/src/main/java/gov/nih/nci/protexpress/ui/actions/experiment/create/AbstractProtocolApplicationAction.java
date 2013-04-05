/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.actions.experiment.create;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.protocol.Protocol;
import gov.nih.nci.protexpress.domain.protocol.ProtocolApplication;
import gov.nih.nci.protexpress.util.SessionHelper;

import com.opensymphony.xwork2.validator.annotations.CustomValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * An abstract base action class for all actions related to the Create Experiment process.
 *
 * @author Krishna Kanchinadam
 */

@Validation
public abstract class AbstractProtocolApplicationAction extends AbstractCreateExperimentAction {
    private static final long serialVersionUID = 1L;

    private ProtocolApplication protocolApplication = new ProtocolApplication(
            null, null, null);
    private Protocol protocol = new Protocol(null);
    private Long deleteIndex;
    private Long protocolApplicationId;

    /**
     * Action Constructor.
     */
    public AbstractProtocolApplicationAction() {
        super();
    }

    /**
     * prepare method for managing protocol, inputs and outputs.
     */
    protected void prepareProtocolInputOutputAction() {
        Long expId = (getExperimentId() != null) ? getExperimentId() : SessionHelper.getExperimentIdFromSession();
        if (expId != null) {
            setExperiment(ProtExpressRegistry.getExperimentService().getExperimentById(expId));
            setExperimentRun(getExperiment().getExperimentRuns().get(0));
        }

        if (getProtocolApplicationId() != null) {
            setProtocolApplication(ProtExpressRegistry.getExperimentService()
                    .getProtocolApplicationById(getProtocolApplicationId()));
            SessionHelper.saveProtocolApplicationInSession(getProtocolApplication());
        } else {
            setProtocolApplication(SessionHelper.getProtocolApplicationFromSession());
        }
    }

    /**
     * Gets the protocolApplication.
     *
     * @return the protocolApplication.
     */
    public ProtocolApplication getProtocolApplication() {
        return protocolApplication;
    }

    /**
     * Sets the protocolApplication.
     *
     * @param protocolApplication the protocolApplication to set.
     */
    public void setProtocolApplication(ProtocolApplication protocolApplication) {
        this.protocolApplication = protocolApplication;
    }

    /**
     * Gets the deleteIndex.
     *
     * @return the deleteIndex.
     */
    public Long getDeleteIndex() {
        return deleteIndex;
    }

    /**
     * Sets the deleteIndex.
     *
     * @param deleteIndex the deleteIndex to set.
     */
    public void setDeleteIndex(Long deleteIndex) {
        this.deleteIndex = deleteIndex;
    }

    /**
     * Gets the protocolApplicationId.
     *
     * @return the protocolApplicationId.
     */
    public Long getProtocolApplicationId() {
        return protocolApplicationId;
    }

    /**
     * Sets the protocolApplicationId.
     *
     * @param protocolApplicationId the protocolApplicationId to set.
     */
    public void setProtocolApplicationId(Long protocolApplicationId) {
        this.protocolApplicationId = protocolApplicationId;
    }

    /**
    * Gets the protocol.
    *
    * @return the protocol.
    */
   @CustomValidator(type = "hibernate")
   public Protocol getProtocol() {
       return protocol;
   }

   /**
    * Sets the protocol.
    *
    * @param protocol
    *            the protocol to set.
    */
   public void setProtocol(Protocol protocol) {
       this.protocol = protocol;
   }

}