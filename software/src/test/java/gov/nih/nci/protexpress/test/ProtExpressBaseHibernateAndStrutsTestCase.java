/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test;

import java.util.Map;

import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.util.StrutsTestCaseHelper;

import com.opensymphony.xwork2.ActionProxyFactory;
import com.opensymphony.xwork2.config.Configuration;
import com.opensymphony.xwork2.config.ConfigurationManager;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.util.XWorkTestCaseHelper;

/**
 * @author Scott Miller
 */
public abstract class ProtExpressBaseHibernateAndStrutsTestCase extends ProtExpressBaseHibernateTest {
    protected ConfigurationManager configurationManager;
    protected Configuration configuration;
    protected Container container;
    protected ActionProxyFactory actionProxyFactory;

    public ProtExpressBaseHibernateAndStrutsTestCase() {
        super();
    }

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        initDispatcher(null);
        this.actionProxyFactory = this.container.getInstance(ActionProxyFactory.class);
    }

    @Override
    protected void onTearDown() throws Exception {
        XWorkTestCaseHelper.tearDown(this.configurationManager);
        this.configurationManager = null;
        this.configuration = null;
        this.container = null;
        this.actionProxyFactory = null;
        StrutsTestCaseHelper.tearDown();
        super.onTearDown();
    }

    protected Dispatcher initDispatcher(Map<String, String> params) {
        Dispatcher du = StrutsTestCaseHelper.initDispatcher(params);
        this.configurationManager = du.getConfigurationManager();
        this.configuration = this.configurationManager.getConfiguration();
        this.container = this.configuration.getContainer();
        return du;
    }
}
