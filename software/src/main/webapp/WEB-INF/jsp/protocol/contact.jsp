<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${protocol.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="protocol.tabs.contact">
    <s:form action="ajax/protocol/management/save/contact" method="post" id="protocolForm" disabled="${isReadOnly}" >
        <s:textfield name="protocol.primaryContact.firstName" key="protocol.primaryContact.firstName" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="protocol.primaryContact.lastName" key="protocol.primaryContact.lastName" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="protocol.primaryContact.email" key="protocol.primaryContact.email" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:textfield name="protocol.primaryContact.contactId" key="protocol.primaryContact.contactId" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="protocol.primaryContact.comments" key="protocol.primaryContact.comments" size="40" tabindex="5" disabled="${isReadOnly}" />
        <s:hidden name="protocol.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/protocol/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="6"><fmt:message key="cancel" /></a>
        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="7"><fmt:message key="copy" /></a>
        </s:if>
        <s:else>
            <s:a onclick="showSubmittingText();" formId="protocolForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false" tabindex="8"><fmt:message key="save" /></s:a>
        </s:else>
    </div>
</protExpress:tabPane>