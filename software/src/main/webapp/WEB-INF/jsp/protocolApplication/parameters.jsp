<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${protocolApplication.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="protocolApplication.tabs.parameters">
    <s:form action="ajax/protocolApplication/management/save/parameters" method="post" id="protocolApplicationForm" disabled="${isReadOnly}" >
        <s:textfield name="protocolApplication.parameters.appLsidTemplate" key="protocolApplication.parameters.appLsidTemplate" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.appNameTemplate" key="protocolApplication.parameters.appNameTemplate" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.outputMaterialLsidTemplate" key="protocolApplication.parameters.outputMaterialLsidTemplate" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.outputMaterialNameTemplate" key="protocolApplication.parameters.outputMaterialNameTemplate" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.outputDataLsidTemplate" key="protocolApplication.parameters.outputDataLsidTemplate" size="40" tabindex="5" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.outputDataNameTemplate" key="protocolApplication.parameters.outputDataNameTemplate" size="40" tabindex="6" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.outputDataFileTemplate" key="protocolApplication.parameters.outputDataFileTemplate" size="40" tabindex="7" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.parameters.outputDataDirTemplate" key="protocolApplication.parameters.outputDataDirTemplate" size="40" tabindex="7" disabled="${isReadOnly}" />
        <s:hidden name="protocolApplication.id" />
    </s:form>
    <div class="actions">
        <c:url value="/experimentRun/management/load.action" var="cancelUrl">
            <c:param name="experimentRun.id" value="${protocolApplication.experimentRun.id}" />
            <c:param name="initialTab" value="protocolApplications" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="9"><fmt:message key="cancel" /></a>
        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="10"><fmt:message key="copy" /></a>
        </s:if>
        <s:else>
            <a href="javascript:ajaxSubmit('protocolApplicationForm', 'selectedtabbox');" class="save" tabindex="10"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>