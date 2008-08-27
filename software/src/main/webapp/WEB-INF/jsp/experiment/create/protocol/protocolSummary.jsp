<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />

<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addinputs" insertNextStepIndicator="true"/>
    <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addoutputs" insertNextStepIndicator="true"/>
    <protExpress:processStep selected="true" textKey="protexpress.page.createnewexperiment.steps.reviewprotocol" />
    <div class="clear"></div>
</div>

<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.info" /></p></div>
<h3><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.title" /></h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>
<s:form id="protocolApplicationForm" method="post">
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <jsp:include page="/WEB-INF/jsp/experiment/create/protocol/protocolSummaryMain.jsp" />
</s:form>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/protocolSummaryManageInputs.jsp" />
<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/protocolSummaryManageOutputs.jsp" />

<c:url var="saveAndViewProtocolUrl" value="/ajax/createExperiment/protocols/manage/saveAndViewProtocol.action" />
<c:url var="saveAndAddNewProtocolUrl" value="/ajax/createExperiment/protocols/manage/saveAndAddNewProtocol.action" />
<c:url var="saveAndViewExperimentSummaryUrl" value="/ajax/createExperiment/protocols/manage/saveAndViewExperimentSummary.action" />

<protExpress:buttonRow>
    <protExpress:button style="save" textKey="protexpress.page.createnewexperiment.reviewprotocol.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('protocolApplicationForm', 'divAjaxBody', '${saveAndViewProtocolUrl}'); this.blur(); return false;" />
    <protExpress:button style="saverepeat" textKey="protexpress.page.createnewexperiment.identifyexperiment.button.saveandcontinue" id="saverepeat" onclick="ProtExpress.submitAjaxFormToUrl('protocolApplicationForm', 'divAjaxBody', '${saveAndAddNewProtocolUrl}'); this.blur(); return false;" />
    <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.reviewprotocol.button.experimentsummary" id="next" onclick="ProtExpress.submitAjaxFormToUrl('protocolApplicationForm', 'divAjaxBody', '${saveAndViewExperimentSummaryUrl}'); this.blur(); return false;" />
</protExpress:buttonRow>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />