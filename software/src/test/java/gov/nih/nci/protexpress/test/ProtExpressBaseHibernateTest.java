/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test;

import gov.nih.nci.protexpress.util.UserHolder;
import gov.nih.nci.security.authorization.domainobjects.User;

import java.net.URL;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.transaction.support.TransactionSynchronizationManager;


/**
 * Base test case for the spring tests.
 *
 * @author Scott Miller
 */
public abstract class ProtExpressBaseHibernateTest extends AbstractDependencyInjectionSpringContextTests {

    protected SessionFactory theSessionFactory;
    protected Session theSession;
    protected CsmInitializer csmInitializer;

    /**
     * Constructor to initialize the configuration.
     */
    public ProtExpressBaseHibernateTest() {
        URL log4jConfig = getClass().getClassLoader().getResource("log4j.xml");
        if (log4jConfig == null) {
            throw new Error("resource log4j.xml not found");
        }
        PropertyConfigurator.configure(log4jConfig);
        setPopulateProtectedVariables(true);
        this.csmInitializer = new CsmInitializer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        this.csmInitializer.dropAndCreateCsmDb();
        User u = new User();
        u.setLoginName("~unittestuser~");
        UserHolder.setUser(u);
        LocalSessionFactoryBean theSessionFactoryBean = (LocalSessionFactoryBean) getApplicationContext().getBean(
                "&sessionFactory");
        theSessionFactoryBean.dropDatabaseSchema();
        theSessionFactoryBean.createDatabaseSchema();
        this.theSessionFactory = (SessionFactory) theSessionFactoryBean.getObject();
        this.theSessionFactory.evictQueries();
        for (Object o : this.theSessionFactory.getAllClassMetadata().values()) {
            ClassMetadata cm = (ClassMetadata) o;
            this.theSessionFactory.evict(cm.getMappedClass(EntityMode.POJO));
        }

        this.theSession = this.theSessionFactory.openSession();
        TransactionSynchronizationManager.bindResource(this.theSessionFactory, new SessionHolder(this.theSession));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onTearDown() throws Exception {
        TransactionSynchronizationManager.unbindResource(this.theSessionFactory);
        SessionFactoryUtils.closeSession(this.theSession);
        UserHolder.setUser(null);
        super.onTearDown();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String[] getConfigLocations() {
        return new String[]{"applicationContext-test.xml", "applicationContext-main.xml"};
    }
}
