<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${protocol.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="protocol.tabs.parameters">
    <s:form action="ajax/protocol/management/save/parameters" method="post" id="protocolForm" disabled="${isReadOnly}" >
        <s:textfield name="protocol.parameters.appLsidTemplate" key="protocol.parameters.appLsidTemplate" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.appNameTemplate" key="protocol.parameters.appNameTemplate" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.outputMaterialLsidTemplate" key="protocol.parameters.outputMaterialLsidTemplate" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.outputMaterialNameTemplate" key="protocol.parameters.outputMaterialNameTemplate" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.outputDataLsidTemplate" key="protocol.parameters.outputDataLsidTemplate" size="40" tabindex="5" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.outputDataNameTemplate" key="protocol.parameters.outputDataNameTemplate" size="40" tabindex="6" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.outputDataFileTemplate" key="protocol.parameters.outputDataFileTemplate" size="40" tabindex="7" disabled="${isReadOnly}" />
        <s:textfield name="protocol.parameters.outputDataDirTemplate" key="protocol.parameters.outputDataDirTemplate" size="40" tabindex="7" disabled="${isReadOnly}" />
        <s:hidden name="protocol.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/protocol/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="9"><fmt:message key="cancel" /></a>
        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="10"><fmt:message key="copy" /></a>
        </s:if>
        <s:else>
            <a href="javascript:ajaxSubmit('protocolForm', 'selectedtabbox');" class="save" tabindex="10"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>