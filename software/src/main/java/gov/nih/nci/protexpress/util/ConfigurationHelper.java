/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.util;

import gov.nih.nci.protexpress.ProtExpressRegistry;
import gov.nih.nci.protexpress.domain.ConfigParamEnum;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletContext;

import org.apache.commons.configuration.DataConfiguration;
import org.apache.commons.configuration.DatabaseConfiguration;
import org.apache.struts2.ServletActionContext;


/**
 * Helper class for retrieving system configuration.
 *
 * @author dkokotov, krishnak
 */
@SuppressWarnings({ "PMD.ReplaceHashtableWithMap", "unchecked", "PMD.CyclomaticComplexity" })
public final class ConfigurationHelper {
    private static final String TABLE_NAME = "config_parameter";
    private static final String PARAM_NAME_COLUMN = "param";
    private static final String PARAM_VALUE_COLUMN = "raw_value";

    private static Hashtable<String, String> ldapContextParams = null;

    private ConfigurationHelper() {
        // empty constructor
    }

    /**
     * @return the system configuration.
     */
    public static DataConfiguration getConfiguration() {
        DatabaseConfiguration config = new DatabaseConfiguration(ProtExpressRegistry.getInstance().getDataSource(),
                TABLE_NAME, PARAM_NAME_COLUMN, PARAM_VALUE_COLUMN);
        config.setDelimiterParsingDisabled(true);
        return new DataConfiguration(config);
    }

    /**
     * @param configParameter the configuration parameter.
     * @return the string configuration value.
     */
    public static String getConfigurationStringValue(ConfigParamEnum configParameter) {
        return ConfigurationHelper.getConfiguration().getString(configParameter.name());
    }

    /**
     * @param configParameter the configuration parameter.
     * @return the boolean configuration value.
     */
    public static boolean getConfigurationBooleanValue(ConfigParamEnum configParameter) {
        return ConfigurationHelper.getConfiguration().getBoolean(configParameter.name(), false);
    }

    /**
     * @return whether this is a development deployment, or a production deployment
     */
    public static boolean isDev() {
        return getConfigurationBooleanValue(ConfigParamEnum.DEVELOPMENT_MODE);
    }

    /**
     * @return the ldap context parameters.
     */
    public static Hashtable<String, String> getLdapContextParameters() {
        if (ldapContextParams == null) {
            ldapContextParams = new Hashtable<String, String>();

            ServletContext context = ServletActionContext.getServletContext();
            Enumeration<String> e = context.getInitParameterNames();
            while (e.hasMoreElements()) {
                String param = e.nextElement();
                if (param.startsWith("ldap")) {
                    ldapContextParams.put(param, context.getInitParameter(param));
                }
            }
        }
        return ldapContextParams;
    }

    /**
     * @return is ldap install?
     */
    public static boolean isLdapInstallation() {
        return Boolean.parseBoolean(ConfigurationHelper.getLdapContextParameters().get("ldap.install"));
    }
}
