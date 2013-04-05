/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress;

import java.util.ResourceBundle;

/**
 * This class is used to the site level configuration options.
 *
 * @author Krishna Kanchinadam
 */
public final class ProtExpressConfiguration {
    /**
     * The max number of results per page in paged search results.
     */
    private static final ProtExpressConfiguration PROTEXPRESS_CONFIGURATION = new ProtExpressConfiguration();
    private static final ResourceBundle PROT_EXPRESS_SITE_CONFIGURATION_BUNDLE =
        ResourceBundle.getBundle("protExpressSiteConfiguration");


    private ProtExpressConfiguration() {

    }

    /**
     * @return the singleton
     */
    public static ProtExpressConfiguration getInstance() {
        return PROTEXPRESS_CONFIGURATION;
    }

    /**
     * @return the PROT_EXPRESS_SITE_CONFIGURATION_BUNDLE
     */
    public static ResourceBundle getApplicationConfigurationBundle() {
        return PROT_EXPRESS_SITE_CONFIGURATION_BUNDLE;
    }
}