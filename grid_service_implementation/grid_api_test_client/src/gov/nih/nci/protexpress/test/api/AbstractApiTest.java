/**
 * The software subject to this notice and license includes both human readable
 * source code form and machine readable, binary, object code form. The test
 * Software was developed in conjunction with the National Cancer Institute
 * (NCI) by NCI employees and 5AM Solutions, Inc. (5AM). To the extent
 * government employees are authors, any rights in such works shall be subject
 * to Title 17 of the United States Code, section 105.
 *
 * This test Software License (the License) is between NCI and You. You (or
 * Your) shall mean a person or an entity, and all other entities that control,
 * are controlled by, or are under common control with the entity. Control for
 * purposes of this definition means (i) the direct or indirect power to cause
 * the direction or management of such entity, whether by contract or otherwise,
 * or (ii) ownership of fifty percent (50%) or more of the outstanding shares,
 * or (iii) beneficial ownership of such entity.
 *
 * This License is granted provided that You agree to the conditions described
 * below. NCI grants You a non-exclusive, worldwide, perpetual, fully-paid-up,
 * no-charge, irrevocable, transferable and royalty-free right and license in
 * its rights in the test Software to (i) use, install, access, operate,
 * execute, copy, modify, translate, market, publicly display, publicly perform,
 * and prepare derivative works of the test Software; (ii) distribute and
 * have distributed to and by third parties the test Software and any
 * modifications and derivative works thereof; and (iii) sublicense the
 * foregoing rights set out in (i) and (ii) to third parties, including the
 * right to license such rights to further third parties. For sake of clarity,
 * and not by way of limitation, NCI shall have no right of accounting or right
 * of payment from You or Your sub-licensees for the rights granted under this
 * License. This License is granted at no charge to You.
 *
 * Your redistributions of the source code for the Software must retain the
 * above copyright notice, this list of conditions and the disclaimer and
 * limitation of liability of Article 6, below. Your redistributions in object
 * code form must reproduce the above copyright notice, this list of conditions
 * and the disclaimer of Article 6 in the documentation and/or other materials
 * provided with the distribution, if any.
 *
 * Your end-user documentation included with the redistribution, if any, must
 * include the following acknowledgment: This product includes software
 * developed by 5AM and the National Cancer Institute. If You do not include
 * such end-user documentation, You shall include this acknowledgment in the
 * Software itself, wherever such third-party acknowledgments normally appear.
 *
 * You may not use the names "The National Cancer Institute", "NCI", or "5AM"
 * to endorse or promote products derived from this Software. This License does
 * not authorize You to use any trademarks, service marks, trade names, logos or
 * product names of either NCI or 5AM, except as required to comply with the
 * terms of this License.
 *
 * For sake of clarity, and not by way of limitation, You may incorporate this
 * Software into Your proprietary programs and into any third party proprietary
 * programs. However, if You incorporate the Software into third party
 * proprietary programs, You agree that You are solely responsible for obtaining
 * any permission from such third parties required to incorporate the Software
 * into such third party proprietary programs and for informing Your
 * sub-licensees, including without limitation Your end-users, of their
 * obligation to secure any required permissions from such third parties before
 * incorporating the Software into such third party proprietary software
 * programs. In the event that You fail to obtain such permissions, You agree
 * to indemnify NCI for any claims against NCI by such third parties, except to
 * the extent prohibited by law, resulting from Your failure to obtain such
 * permissions.
 *
 * For sake of clarity, and not by way of limitation, You may add Your own
 * copyright statement to Your modifications and to the derivative works, and
 * You may provide additional or different license terms and conditions in Your
 * sublicenses of modifications of the Software, or any derivative works of the
 * Software as a whole, provided Your use, reproduction, and distribution of the
 * Work otherwise complies with the conditions stated in this License.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * (INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. IN NO
 * EVENT SHALL THE NATIONAL CANCER INSTITUTE, 5AM SOLUTIONS, INC. OR THEIR
 * AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 * OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
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
