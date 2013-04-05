/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress;

import gov.nih.nci.protexpress.service.AccountInformationService;
import gov.nih.nci.protexpress.service.ExperimentService;
import gov.nih.nci.protexpress.service.FormatConversionService;
import gov.nih.nci.protexpress.service.GenericDataService;
import gov.nih.nci.protexpress.service.ProtExpressService;
import gov.nih.nci.protexpress.service.ProtocolService;
import gov.nih.nci.protexpress.service.RegistrationService;
import gov.nih.nci.protexpress.service.impl.Xar23FormatConversionServiceImpl;
import gov.nih.nci.security.SecurityServiceProvider;
import gov.nih.nci.security.UserProvisioningManager;

import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * This class is used to access all of the spring managed beans in a static manner.
 *
 * @author Scott Miller
 */
public final class ProtExpressRegistry {
    /**
     * The max number of results per page in paged search results.
     */
    public static final int MAX_RESULTS_PER_PAGE = 10;
    private static final Logger ERROR_LOGGER = Logger.getLogger(ProtExpressRegistry.class.getPackage().getName()
            + ".ERROR");
    private static final ResourceBundle PROT_EXPRESS_RESOURCE_BUNDLE = ResourceBundle.getBundle("protExpress");

    private static final ProtExpressRegistry THE_INSTANCE = new ProtExpressRegistry();

    private ProtocolService protocolService;
    private ExperimentService experimentService;
    private ProtExpressService protExpressService;
    private FormatConversionService xar23FormatConversionService;
    private UserProvisioningManager userProvisioningManager;
    private RegistrationService registrationService;
    private AccountInformationService accountInformationService;
    private DataSource dataSource;
    private GenericDataService genericDataService;


    private ProtExpressRegistry() {
        try {
            setXar23FormatConversionService(new Xar23FormatConversionServiceImpl());
            this.userProvisioningManager = SecurityServiceProvider.getUserProvisioningManager("protExpress");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @return the singleton
     */
    public static ProtExpressRegistry getInstance() {
        return THE_INSTANCE;
    }

    /**
     * @return the protocolService
     */
    public static ProtocolService getProtocolService() {
        return ProtExpressRegistry.getInstance().protocolService;
    }

    /**
     * @param protocolService the protocolService to set
     */
    public void setProtocolService(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    /**
     * @return the experimentService
     */
    public static ExperimentService getExperimentService() {
        return ProtExpressRegistry.getInstance().experimentService;
    }

    /**
     * @param experimentService the experimentService to set
     */
    public void setExperimentService(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    /**
     * @return the protExpressService
     */
    public static ProtExpressService getProtExpressService() {
        return ProtExpressRegistry.getInstance().protExpressService;
    }

    /**
     * @param protExpressService the protExpressService to set
     */
    public void setProtExpressService(ProtExpressService protExpressService) {
        this.protExpressService = protExpressService;
    }

    /**
     * @return the xar23FormatConversionService
     */
    public static FormatConversionService getXar23FormatConversionService() {
        return ProtExpressRegistry.getInstance().xar23FormatConversionService;
    }

    /**
     * @param xar23FormatConversionService the xar23FormatConversionService to set
     */
    public void setXar23FormatConversionService(FormatConversionService xar23FormatConversionService) {
        this.xar23FormatConversionService = xar23FormatConversionService;
    }

    /**
     * @return the userProvisioningManager
     */
    public static UserProvisioningManager getUserProvisioningManager() {
        if (ProtExpressRegistry.getInstance().userProvisioningManager == null) {
            try {
                ProtExpressRegistry.getInstance().userProvisioningManager =
                    SecurityServiceProvider.getUserProvisioningManager("protExpress");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return ProtExpressRegistry.getInstance().userProvisioningManager;
    }

    /**
     * @return the ERROR_LOGGER
     */
    public static Logger getErrorLogger() {
        return ERROR_LOGGER;
    }

    /**
     * @return the PROT_EXPRESS_RESOURCE_BUNDLE
     */
    public static ResourceBundle getApplicationResourceBundle() {
        return PROT_EXPRESS_RESOURCE_BUNDLE;
    }

    /**
     * @return service to handle registration activities
     */
    public static RegistrationService getRegistrationService() {
        return ProtExpressRegistry.getInstance().registrationService;
    }

    /**
     * @param registrationService service to set
     */
    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * @return service to handle account information activities
     */
    public static AccountInformationService getAccountInformationService() {
        return ProtExpressRegistry.getInstance().accountInformationService;
    }

    /**
     * @param accountInformationService service to set
     */
    public void setAccountInformationService(AccountInformationService accountInformationService) {
        this.accountInformationService = accountInformationService;
    }

    /**
     * @return protExpress data source
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @param dataSource ds to set
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return the generic data service
     */
    public static GenericDataService getGenericDataService() {
        return ProtExpressRegistry.getInstance().genericDataService;
    }

    /**
     * @param genericDataService service to set
     */
    public void setGenericDataService(GenericDataService genericDataService) {
        this.genericDataService = genericDataService;
    }
}