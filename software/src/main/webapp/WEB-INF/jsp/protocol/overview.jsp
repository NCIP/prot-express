<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${protocol.id != null && protocol.auditInfo.creator != currentUser.loginName}" />
<s:if test="${protocol.id != null}">
    <c:set var="formAction" value="ajax/protocol/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="protocol/management/save"/>
</s:else>
<protExpress:tabPane paneTitleKey="protocol.overview">
    <s:form action="${formAction}" id="protocolForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="protocol.lsid" key="protocol.lsid" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="protocol.name" key="protocol.name" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="protocol.description" key="protocol.description" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:select name="protocol.type" key="protocol.type"
            list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName"
            headerKey="" headerValue="%{getText('protocol.type.select')}" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="protocol.software" key="protocol.software" size="40" tabindex="5" disabled="${isReadOnly}" />
        <s:textfield name="protocol.instrument" key="protocol.instrument" size="40" tabindex="6" disabled="${isReadOnly}" />
        <s:hidden name="protocol.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/protocol/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="7"><fmt:message key="cancel" /></a>

        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="8"><fmt:message key="copy" /></a>
        </s:if>
        <s:elseif test="${protocol.id != null}">
            <s:a onclick="showSubmittingText();" formId="protocolForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false" tabindex="8"><fmt:message key="save" /></s:a>
        </s:elseif>
        <s:else>
            <a href="javascript:document.getElementById('protocolForm').submit();" class="save" tabindex="8"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>