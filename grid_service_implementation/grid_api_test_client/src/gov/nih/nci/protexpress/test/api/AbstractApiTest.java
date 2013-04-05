/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.test.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import gov.nih.nci.cagrid.cqlquery.Attribute;
import gov.nih.nci.cagrid.cqlquery.CQLQuery;
import gov.nih.nci.cagrid.cqlquery.Predicate;
import gov.nih.nci.cagrid.cqlresultset.CQLQueryResults;
import gov.nih.nci.cagrid.data.utilities.CQLQueryResultsIterator;
import gov.nih.nci.cagrid.protexpress.client.ProtExpressGridServiceClient;
import gov.nih.nci.protexpress.test.base.TestProperties;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

/**
 * Base class for all API tests that test the Remote Java API and Grid API.
 * Provides utilities to log all output needed for caBIG Silver Compatibility review.
 *
 * @author Rashmi Srinivasa
 * @author Krishna Kanchinadam
 */
public class AbstractApiTest {
    protected static final String TEST_NAME = "TEST NAME";
    protected static final String API_CALL = "API CALL";
    protected static final String TRAVERSE_OBJECT_GRAPH = "TRAVERSING OBJECT GRAPH FOR CLASS";
    protected static final String TEST_OUTPUT = "TEST OUTPUT";
    protected static final String ATTRIBUTE = "ATTRIBUTE";
    protected static final String ASSOCIATION = "ASSOCIATION";

    // Target Domain Objects
    protected static final String TARGET_OBJECT_EXPERIMENT = "gov.nih.nci.protexpress.domain.experiment.Experiment";
    protected static final String TARGET_OBJECT_EXPERIMENT_RUN = "gov.nih.nci.protexpress.domain.experiment.ExperimentRun";
    protected static final String TARGET_OBJECT_PROTOCOL = "gov.nih.nci.protexpress.domain.protocol.Protocol";
    protected static final String TARGET_OBJECT_PROTOCOL_APPLICATION = "gov.nih.nci.protexpress.domain.protocol.ProtocolApplication";
    protected static final String TARGET_OBJECT_INPUT_OUTPUT = "gov.nih.nci.protexpress.domain.protocol.InputOutputObject";
    protected static final String TARGET_OBJECT_CONTACT_PERSON = "gov.nih.nci.protexpress.domain.contact.ContactPerson";

    protected static void logForSilverCompatibility (String header, String outputText) {
        System.out.println(header + ": " + outputText);
    }

    protected static void logForSilverCompatibility (String outputText) {
        System.out.println(outputText);
    }

    protected static StringBuilder buildStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        return new StringBuilder(sw.toString());
    }

    protected static void logTestEnvironmentValues() {
        logForSilverCompatibility("\n\n");
        logForSilverCompatibility("######################################################################################################################################");
        logForSilverCompatibility("####################################----------TEST PROPERTIES---------------------#####################################################");
        logForSilverCompatibility("######################################################################################################################################");
        logForSilverCompatibility("-----------SERVER_HOSTNAME", TestProperties.getServerHostname());
        logForSilverCompatibility("-----------SERVER_PORT", new Long(TestProperties.getServerPort()).toString());
        logForSilverCompatibility("-----------GRID_SERVER_HOSTNAME", TestProperties.getGridServerHostname());
        logForSilverCompatibility("-----------GRID_SERVER_PORT", new Long(TestProperties.getGridServerPort()).toString());
        logForSilverCompatibility("-----------EXPERIMENT_ID", TestProperties.getExperimentId());
        logForSilverCompatibility("-----------EXPERIMENT_RUN_ID", TestProperties.getExperimentRunId());
        logForSilverCompatibility("-----------PROTOCOL_ID", TestProperties.getProtocolId());
        logForSilverCompatibility("-----------PROTOCOL_APPLICATION_ID", TestProperties.getProtocolApplicationId());
        logForSilverCompatibility("-----------INPUT_OUTPUT_ID", TestProperties.getInputOutputObjectId());
        logForSilverCompatibility("-----------CONTACT_PERSON_ID", TestProperties.getContactPersonId());
        logForSilverCompatibility("######################################################################################################################################");
        logForSilverCompatibility("######################################################################################################################################");
        logForSilverCompatibility("\n\n");
    }

    protected static void runTest(String targetObject, String objectId) {
        try {
            logTestEnvironmentValues();
            ProtExpressGridServiceClient client = new ProtExpressGridServiceClient(TestProperties.getGridServiceUrl());
            logForSilverCompatibility(TEST_NAME, "Retrieving Information for " + targetObject + " with ID=" + objectId);

            CQLQueryResults cqlResults = getQueryResults(client, targetObject, objectId);
            logForSilverCompatibility(API_CALL, "Grid query(CQLQuery)");

            CQLQueryResultsIterator iter = new CQLQueryResultsIterator(cqlResults, ProtExpressGridServiceClient.class
                    .getResourceAsStream("client-config.wsdd"));
            if (!(iter.hasNext())) {
                logForSilverCompatibility("\n");
                logForSilverCompatibility("NO RECORD FOUND FOR " + targetObject + " WITH ID=" + objectId);
                logForSilverCompatibility("TERMINATING THE TEST.....");
                logForSilverCompatibility("\n");
                return;
            }
            displayMethods(iter.next());
        } catch (RemoteException e) {
            processCatchBlock(e);
        } catch (Throwable e) {
            // Catches things like out-of-memory errors and logs them.
            processCatchBlock(e);
        }
    }

    protected static CQLQueryResults getQueryResults(ProtExpressGridServiceClient client, String targetObjectName, String targetObjectId)
    throws RemoteException {
        CQLQuery cqlQuery = new CQLQuery();
        gov.nih.nci.cagrid.cqlquery.Object target = new gov.nih.nci.cagrid.cqlquery.Object();
        target.setName(targetObjectName);
        Attribute titleAttribute = new Attribute();
        titleAttribute.setName("id");
        titleAttribute.setValue(targetObjectId);
        titleAttribute.setPredicate(Predicate.EQUAL_TO);
        target.setAttribute(titleAttribute);

        cqlQuery.setTarget(target);
        CQLQueryResults cqlResults = client.query(cqlQuery);
        return cqlResults;
    }

    protected static void processCatchBlock(Throwable e) {
        StringBuilder trace = buildStackTrace(e);
        logForSilverCompatibility(TEST_OUTPUT, e.getClass().getName() + ": " + e + "\nTrace: " + trace);
        assertTrue(e.getClass().getName() + ": " + e, false);
    }

    protected static void displayMethods(Object obj) {
        // Get the methods, and print out the value.
        Method[] theMethods = obj.getClass().getMethods();
        logForSilverCompatibility(TRAVERSE_OBJECT_GRAPH, obj.getClass().getName());
        for(Method method : theMethods){
            if(isGetter(method)) {
                try {
                    Object value = method.invoke(obj, null);
                    String displayValue = "";
                    if (value != null) {
                        displayValue = value.toString();
                    }
                    logForSilverCompatibility("          " + method.getName() + "(): " + displayValue);
                } catch (IllegalArgumentException e) {
                    processCatchBlock(e);
                } catch (IllegalAccessException e) {
                    processCatchBlock(e);
                } catch (InvocationTargetException e) {
                    processCatchBlock(e);
                }
            }
          }
    }

    protected static boolean isGetter(Method method){
          if(!method.getName().startsWith("get"))      return false;
          if (method.getName().equals("getClass")) return false;
          if(method.getParameterTypes().length != 0)   return false;
          if(void.class.equals(method.getReturnType())) return false;
          return true;
        }

    protected static boolean isSetter(Method method){
          if(!method.getName().startsWith("set")) return false;
          if(method.getParameterTypes().length != 1) return false;
          return true;
        }
}
