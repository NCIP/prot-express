/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test;

import java.net.URL;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.dialect.HSQLDialect;

/**
 * Class to init csm in the test suite.
 *
 * @author Scott Miller
 */
public class CsmInitializer {
    private static final Logger LOG = Logger.getLogger(CsmInitializer.class);

    private static String[] csmData = new String[]{
            "INSERT INTO CSM_APPLICATION(APPLICATION_NAME, APPLICATION_DESCRIPTION, UPDATE_DATE, DECLARATIVE_FLAG, "
                    + "ACTIVE_FLAG) VALUES ('protExpress', 'protExpress', sysdate, 0, 0);",
            "INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, PASSWORD, UPDATE_DATE) "
                    + "VALUES ('user1', 'Test 1', 'User','password', sysdate);",
            "INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, UPDATE_DATE) "
                    + "VALUES ('protExpressTestUser1', 'Test1', 'User', sysdate);", 
            "INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, UPDATE_DATE) "
                    + "VALUES ('protExpressTestUser2', 'Test2', 'User', sysdate);", 
            "INSERT INTO CSM_USER(LOGIN_NAME, FIRST_NAME, LAST_NAME, UPDATE_DATE) "
                    + "VALUES ('protExpressTestUser3', 'Test3', 'User', sysdate);", 
                    "commit;"};

    private Configuration csmHibernateConfig;
    private final String[] dropScript;
    private final String[] createScript;
    private SessionFactory csmSessionFactory;
    private Session csmSession;

    /**
     * Csm initalizer constructor. Initializes the configuration and then creates and drops the db.
     */
    public CsmInitializer() {
        URL url = getClass().getClassLoader().getResource("jaas.config");
        System.getProperties().setProperty("java.security.auth.login.config", url.getPath());

        this.csmHibernateConfig = new Configuration();
        url = getClass().getClassLoader().getResource("protExpress.csm.new.hibernate.cfg.xml");
        this.csmHibernateConfig = this.csmHibernateConfig.configure(url);
        this.dropScript = this.csmHibernateConfig.generateDropSchemaScript(new HSQLDialect());
        this.createScript = this.csmHibernateConfig.generateSchemaCreationScript(new HSQLDialect());

        dropAndCreateCsmDb();
    }

    /**
     * Drop and create the csm db.
     */
    public void dropAndCreateCsmDb() {
        this.csmSessionFactory = this.csmHibernateConfig.buildSessionFactory();
        this.csmSession = this.csmSessionFactory.openSession();

        executeSqlStatements(this.csmSession, this.dropScript);
        executeSqlStatements(this.csmSession, this.createScript);
        executeSqlStatements(this.csmSession, csmData);
        this.csmSession.flush();
        this.csmSession.close();
        this.csmSessionFactory.close();
    }

    private void executeSqlStatements(Session sess, String[] statements) {
        for (String stmt : statements) {
            try {
                sess.createSQLQuery(stmt).executeUpdate();
            } catch (HibernateException e) {
                LOG.debug("Error executing statement: " + stmt + " : " + e);
            }
        }
    }

}
