<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<protExpress:tabPane paneTitleKey="protocol.tabs.contact">
    <s:form action="ajax/protocol/management/save/contact" method="post" id="protocolForm">
        <s:textfield name="protocol.primaryContact.firstName" key="protocol.primaryContact.firstName" size="40" tabindex="1" />
        <s:textfield name="protocol.primaryContact.lastName" key="protocol.primaryContact.lastName" size="40" tabindex="2" />
        <s:textfield name="protocol.primaryContact.email" key="protocol.primaryContact.email" size="40" tabindex="3" />
        <s:textfield name="protocol.primaryContact.contactId" key="protocol.primaryContact.contactId" size="40" tabindex="4" />
        <s:textfield name="protocol.primaryContact.comments" key="protocol.primaryContact.comments" size="40" tabindex="5" />
        <s:hidden name="protocol.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/protocol/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="6"><fmt:message key="cancel" /></a>
        <s:a onclick="showSubmittingText();" formId="protocolForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false" tabindex="7"><fmt:message key="save" /></s:a>
    </div>
</protExpress:tabPane>