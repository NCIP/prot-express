<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<protExpress:tabPane paneTitleKey="protocol.tabs.inputOutput">
    <s:form action="ajax/protocol/management/save/inputOutput" method="post" id="protocolForm">
        <s:textfield name="protocol.maxInputMaterialPerInstance" key="protocol.maxInputMaterialPerInstance" size="40" />
        <s:textfield name="protocol.maxInputDataPerInstance" key="protocol.maxInputDataPerInstance" size="40" />
        <s:textfield name="protocol.outputMaterialPerInstance" key="protocol.outputMaterialPerInstance" size="40" />
        <s:textfield name="protocol.outputDataPerInstance" key="protocol.outputDataPerInstance" size="40" />
        <s:textfield name="protocol.outputMaterialType" key="protocol.outputMaterialType" size="40" />
        <s:textfield name="protocol.outputDataType" key="protocol.outputDataType" size="40" />
        <s:hidden name="protocol.id" />
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