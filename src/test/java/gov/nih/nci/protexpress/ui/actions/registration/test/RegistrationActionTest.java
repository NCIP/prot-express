package gov.nih.nci.protexpress.ui.actions.registration.test;

import gov.nih.nci.protexpress.domain.register.RegistrationRequest;
import gov.nih.nci.protexpress.test.ProtExpressBaseHibernateTest;
import gov.nih.nci.protexpress.ui.actions.registration.RegistrationAction;

import org.apache.struts2.ServletActionContext;
import org.springframework.mock.web.MockServletContext;

public class RegistrationActionTest extends ProtExpressBaseHibernateTest {
    private final RegistrationAction registrationAction = new RegistrationAction();
    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
//        ServiceLocatorStub locatorStub = ServiceLocatorStub.registerEmptyLocator();
//        locatorStub.addLookup(StateService.JNDI_NAME, new StateServiceStub());
//        locatorStub.addLookup(CountryService.JNDI_NAME, new CountryServiceStub());
//        locatorStub.addLookup(RegistrationService.JNDI_NAME, new RegistrationServiceStub());
        MockServletContext context = new MockServletContext();
        context.addInitParameter("ldap.install", "false");
        ServletActionContext.setServletContext(context);
    }
    
    public void testPrepare() throws Exception {
        MockServletContext context = (MockServletContext) ServletActionContext.getServletContext();
        context.addInitParameter("some.other.param", "false");
        registrationAction.prepare();
        assertNotNull(registrationAction.getRegistrationRequest());
        assertTrue(registrationAction.getLdapAuthenticate());
        //need to stub out ProtExpressRegistry.getRegistrationService() before we can assert number of entries
        //assertEquals(50,registrationAction.getStateList().size());
        //assertEquals(1,registrationAction.getCountryList().size());
    }
    
    public void testValidate() throws Exception {
        RegistrationRequest request = new RegistrationRequest();
        request.setLoginName("login");
        request.setEmail("test@email.com");
        registrationAction.setRegistrationRequest(request);
        registrationAction.prepare();
        registrationAction.validate();
    
        MockServletContext context = new MockServletContext();
        context.addInitParameter("ldap.install", "true");
        ServletActionContext.setServletContext(context);
        registrationAction.prepare();
        registrationAction.validate();
        
        registrationAction.setLdapAuthenticate(false);
        registrationAction.validate();
    }
}

