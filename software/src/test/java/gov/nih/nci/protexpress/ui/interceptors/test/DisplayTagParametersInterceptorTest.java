/*L
 * Copyright 5AM Solutions, Inc.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/prot-express/LICENSE.txt for details.
 */

package gov.nih.nci.protexpress.ui.interceptors.test;

import gov.nih.nci.protexpress.ui.interceptors.DisplayTagParametersInterceptor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParametersInterceptor;
import com.opensymphony.xwork2.util.OgnlValueStack;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author Scott Miller
 *
 */
public class DisplayTagParametersInterceptorTest extends TestCase {
    public void testParameterNameAware() throws Exception {
        DisplayTagParametersInterceptor interceptor = new DisplayTagParametersInterceptor();
        TestAction action = new TestAction();
        MapBackedValueStack stack = new MapBackedValueStack();

        final Map<String, Object> expected = new HashMap<String, Object>();
        expected.put("fooKey", "fooValue");
        expected.put("barKey", "barValue");
        expected.put("d-", "d-value2");
        expected.put("d-key", "d-value");

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("fooKey", "fooValue");
        parameters.put("barKey", "barValue");
        parameters.put("d-1", "error");
        parameters.put("d-", "d-value2");
        parameters.put("d-key", "d-value");

        Method setParamMethod = ParametersInterceptor.class.
            getDeclaredMethod("setParameters", Object.class, ValueStack.class, Map.class);
        setParamMethod.setAccessible(true);
        setParamMethod.invoke(interceptor, action, stack, parameters);
        assertEquals(expected, stack.actual);
    }

    class TestAction extends ActionSupport {
        private static final long serialVersionUID = 1L;
    }

    class MapBackedValueStack extends OgnlValueStack {
        private static final long serialVersionUID = 1L;
        final Map<String, Object> actual = new HashMap<String, Object>();

        public void setValue(String expr, Object value) {
            actual.put(expr, value);
        }
    }
}
