/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.cagrid.protexpress.service;

import gov.nih.nci.cagrid.introduce.servicetools.ServiceConfiguration;

import org.globus.wsrf.config.ContainerConfig;
import java.io.File;
import javax.naming.InitialContext;

import org.apache.axis.MessageContext;
import org.globus.wsrf.Constants;


/** 
 * DO NOT EDIT:  This class is autogenerated!
 * 
 * This class holds all service properties which were defined for the service to have
 * access to.
 * 
 * @created by Introduce Toolkit version 1.2
 * 
 */
public class ProtExpressGridServiceConfiguration implements ServiceConfiguration {

	public static ProtExpressGridServiceConfiguration  configuration = null;

	public static ProtExpressGridServiceConfiguration getConfiguration() throws Exception {
		if (ProtExpressGridServiceConfiguration.configuration != null) {
			return ProtExpressGridServiceConfiguration.configuration;
		}
		MessageContext ctx = MessageContext.getCurrentContext();

		String servicePath = ctx.getTargetService();

		String jndiName = Constants.JNDI_SERVICES_BASE_NAME + servicePath + "/serviceconfiguration";
		try {
			javax.naming.Context initialContext = new InitialContext();
			ProtExpressGridServiceConfiguration.configuration = (ProtExpressGridServiceConfiguration) initialContext.lookup(jndiName);
		} catch (Exception e) {
			throw new Exception("Unable to instantiate service configuration.", e);
		}

		return ProtExpressGridServiceConfiguration.configuration;
	}
	
	private String etcDirectoryPath;
	
	
	private String queryProcessorClass;
	
	private String sdk4Style_beansJarFileName;
	
	private String cqlQueryProcessorConfig_applicationName;
	
	private String cqlQueryProcessorConfig_queryCaseInsensitive;
	
	private String cqlQueryProcessorConfig_useLocalApiFlag;
	
	private String cqlQueryProcessorConfig_ormJarName;
	
	private String cqlQueryProcessorConfig_applicationHostName;
	
	private String cqlQueryProcessorConfig_applicationHostPort;
	
	private String cqlQueryProcessorConfig_useServiceLogin;
	
	private String cqlQueryProcessorConfig_useGridIdentityLogin;
	
	private String cqlQueryProcessorConfig_staticLoginUsername;
	
	private String cqlQueryProcessorConfig_staticLoginPassword;
	
	private String serverConfigLocation;
	
	private String dataService_cqlValidatorClass;
	
	private String dataService_domainModelValidatorClass;
	
	private String dataService_validateCqlFlag;
	
	private String dataService_validateDomainModelFlag;
	
	private String dataService_classMappingsFilename;
	
	private String cqlQueryProcessorConfig_domainTypesInfoFilename;
	
	
	public String getEtcDirectoryPath() {
		return ContainerConfig.getBaseDirectory() + File.separator + etcDirectoryPath;
	}
	
	public void setEtcDirectoryPath(String etcDirectoryPath) {
		this.etcDirectoryPath = etcDirectoryPath;
	}

	
	public String getQueryProcessorClass() {
		return queryProcessorClass;
	}
	
	
	public void setQueryProcessorClass(String queryProcessorClass) {
		this.queryProcessorClass = queryProcessorClass;
	}

	
	public String getSdk4Style_beansJarFileName() {
		return sdk4Style_beansJarFileName;
	}
	
	
	public void setSdk4Style_beansJarFileName(String sdk4Style_beansJarFileName) {
		this.sdk4Style_beansJarFileName = sdk4Style_beansJarFileName;
	}

	
	public String getCqlQueryProcessorConfig_applicationName() {
		return cqlQueryProcessorConfig_applicationName;
	}
	
	
	public void setCqlQueryProcessorConfig_applicationName(String cqlQueryProcessorConfig_applicationName) {
		this.cqlQueryProcessorConfig_applicationName = cqlQueryProcessorConfig_applicationName;
	}

	
	public String getCqlQueryProcessorConfig_queryCaseInsensitive() {
		return cqlQueryProcessorConfig_queryCaseInsensitive;
	}
	
	
	public void setCqlQueryProcessorConfig_queryCaseInsensitive(String cqlQueryProcessorConfig_queryCaseInsensitive) {
		this.cqlQueryProcessorConfig_queryCaseInsensitive = cqlQueryProcessorConfig_queryCaseInsensitive;
	}

	
	public String getCqlQueryProcessorConfig_useLocalApiFlag() {
		return cqlQueryProcessorConfig_useLocalApiFlag;
	}
	
	
	public void setCqlQueryProcessorConfig_useLocalApiFlag(String cqlQueryProcessorConfig_useLocalApiFlag) {
		this.cqlQueryProcessorConfig_useLocalApiFlag = cqlQueryProcessorConfig_useLocalApiFlag;
	}

	
	public String getCqlQueryProcessorConfig_ormJarName() {
		return cqlQueryProcessorConfig_ormJarName;
	}
	
	
	public void setCqlQueryProcessorConfig_ormJarName(String cqlQueryProcessorConfig_ormJarName) {
		this.cqlQueryProcessorConfig_ormJarName = cqlQueryProcessorConfig_ormJarName;
	}

	
	public String getCqlQueryProcessorConfig_applicationHostName() {
		return cqlQueryProcessorConfig_applicationHostName;
	}
	
	
	public void setCqlQueryProcessorConfig_applicationHostName(String cqlQueryProcessorConfig_applicationHostName) {
		this.cqlQueryProcessorConfig_applicationHostName = cqlQueryProcessorConfig_applicationHostName;
	}

	
	public String getCqlQueryProcessorConfig_applicationHostPort() {
		return cqlQueryProcessorConfig_applicationHostPort;
	}
	
	
	public void setCqlQueryProcessorConfig_applicationHostPort(String cqlQueryProcessorConfig_applicationHostPort) {
		this.cqlQueryProcessorConfig_applicationHostPort = cqlQueryProcessorConfig_applicationHostPort;
	}

	
	public String getCqlQueryProcessorConfig_useServiceLogin() {
		return cqlQueryProcessorConfig_useServiceLogin;
	}
	
	
	public void setCqlQueryProcessorConfig_useServiceLogin(String cqlQueryProcessorConfig_useServiceLogin) {
		this.cqlQueryProcessorConfig_useServiceLogin = cqlQueryProcessorConfig_useServiceLogin;
	}

	
	public String getCqlQueryProcessorConfig_useGridIdentityLogin() {
		return cqlQueryProcessorConfig_useGridIdentityLogin;
	}
	
	
	public void setCqlQueryProcessorConfig_useGridIdentityLogin(String cqlQueryProcessorConfig_useGridIdentityLogin) {
		this.cqlQueryProcessorConfig_useGridIdentityLogin = cqlQueryProcessorConfig_useGridIdentityLogin;
	}

	
	public String getCqlQueryProcessorConfig_staticLoginUsername() {
		return cqlQueryProcessorConfig_staticLoginUsername;
	}
	
	
	public void setCqlQueryProcessorConfig_staticLoginUsername(String cqlQueryProcessorConfig_staticLoginUsername) {
		this.cqlQueryProcessorConfig_staticLoginUsername = cqlQueryProcessorConfig_staticLoginUsername;
	}

	
	public String getCqlQueryProcessorConfig_staticLoginPassword() {
		return cqlQueryProcessorConfig_staticLoginPassword;
	}
	
	
	public void setCqlQueryProcessorConfig_staticLoginPassword(String cqlQueryProcessorConfig_staticLoginPassword) {
		this.cqlQueryProcessorConfig_staticLoginPassword = cqlQueryProcessorConfig_staticLoginPassword;
	}

	
	public String getServerConfigLocation() {
		return ContainerConfig.getBaseDirectory() + File.separator + serverConfigLocation;
	}
	
	
	public void setServerConfigLocation(String serverConfigLocation) {
		this.serverConfigLocation = serverConfigLocation;
	}

	
	public String getDataService_cqlValidatorClass() {
		return dataService_cqlValidatorClass;
	}
	
	
	public void setDataService_cqlValidatorClass(String dataService_cqlValidatorClass) {
		this.dataService_cqlValidatorClass = dataService_cqlValidatorClass;
	}

	
	public String getDataService_domainModelValidatorClass() {
		return dataService_domainModelValidatorClass;
	}
	
	
	public void setDataService_domainModelValidatorClass(String dataService_domainModelValidatorClass) {
		this.dataService_domainModelValidatorClass = dataService_domainModelValidatorClass;
	}

	
	public String getDataService_validateCqlFlag() {
		return dataService_validateCqlFlag;
	}
	
	
	public void setDataService_validateCqlFlag(String dataService_validateCqlFlag) {
		this.dataService_validateCqlFlag = dataService_validateCqlFlag;
	}

	
	public String getDataService_validateDomainModelFlag() {
		return dataService_validateDomainModelFlag;
	}
	
	
	public void setDataService_validateDomainModelFlag(String dataService_validateDomainModelFlag) {
		this.dataService_validateDomainModelFlag = dataService_validateDomainModelFlag;
	}

	
	public String getDataService_classMappingsFilename() {
		return ContainerConfig.getBaseDirectory() + File.separator + dataService_classMappingsFilename;
	}
	
	
	public void setDataService_classMappingsFilename(String dataService_classMappingsFilename) {
		this.dataService_classMappingsFilename = dataService_classMappingsFilename;
	}

	
	public String getCqlQueryProcessorConfig_domainTypesInfoFilename() {
		return ContainerConfig.getBaseDirectory() + File.separator + cqlQueryProcessorConfig_domainTypesInfoFilename;
	}
	
	
	public void setCqlQueryProcessorConfig_domainTypesInfoFilename(String cqlQueryProcessorConfig_domainTypesInfoFilename) {
		this.cqlQueryProcessorConfig_domainTypesInfoFilename = cqlQueryProcessorConfig_domainTypesInfoFilename;
	}

	
}
