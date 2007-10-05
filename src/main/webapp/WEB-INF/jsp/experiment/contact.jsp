<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experiment.id != null && experiment.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="experiment.tabs.contact">
    <s:form action="ajax/experiment/management/save/contact" method="post" id="experimentForm" disabled="${isReadOnly}" >
        <s:textfield name="experiment.primaryContact.firstName" key="experiment.primaryContact.firstName" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.lastName" key="experiment.primaryContact.lastName" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.email" key="experiment.primaryContact.email" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.contactId" key="experiment.primaryContact.contactId" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.comments" key="experiment.primaryContact.comments" size="40" tabindex="5" disabled="${isReadOnly}" />
        <s:hidden name="experiment.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/experiment/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="6"><fmt:message key="cancel" /></a>
        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="7"><fmt:message key="copy" /></a>
        </s:if>
        <s:else>
            <a href="javascript:ajaxSubmit('experimentForm', 'selectedtabbox');" class="save" tabindex="7"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>