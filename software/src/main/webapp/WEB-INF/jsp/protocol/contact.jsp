<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<protExpress:tabPane paneTitleKey="protocol.tabs.contact">
    <s:form action="ajax/protocol/management/save/contact" method="post" id="protocolForm">
        <s:textfield name="protocol.primaryContact.firstName" key="protocol.primaryContact.firstName" size="40" />
        <s:textfield name="protocol.primaryContact.lastName" key="protocol.primaryContact.lastName" size="40" />
        <s:textfield name="protocol.primaryContact.email" key="protocol.primaryContact.email" size="40" />
        <s:textfield name="protocol.primaryContact.contactId" key="protocol.primaryContact.contactId" size="40" />
        <s:textfield name="protocol.primaryContact.comments" key="protocol.primaryContact.comments" size="40" />
        <s:hidden name="protocol.id" />
        <s:hidden name="protocol.primaryContact.id" />
        <s:hidden name="resultingForward" />
    </s:form>
    <div class="actions">
        <s:if test="resultingForward == 'dashboard'">
            <c:url value="/dashboard/dashboard.action" var="cancelUrl"/>
        </s:if>
        <s:else>
            <c:url value="/protocol/search/loadSearch.action" var="cancelUrl"/>
        </s:else>
        <a href="${cancelUrl}" class="cancel"><fmt:message key="cancel" /></a>
        <s:a onclick="showSubmittingText();" formId="protocolForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false"><fmt:message key="save" /></s:a>
    </div>
</protExpress:tabPane>