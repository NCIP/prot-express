<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />


<div class="info">
    <p><fmt:message key="protexpress.page.createnewexperiment.addoutputs.info" /></p>
</div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addinputs" insertNextStepIndicator="true"/>
    <protExpress:processStep selected="true" textKey="protexpress.page.createnewexperiment.steps.addoutputs" insertNextStepIndicator="true"/>
    <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewprotocol" />
    <div class="clear"></div>
</div>

<div id="divContent">
  <c:set var="formId" value="manageOutputsForm" />

 <c:url var="saveUrl" value="/ajax/createExperiment/protocols/outputs/saveOutputsToSession.action" />
 <s:actionerror ></s:actionerror>
    <s:form id="manageOutputsForm" action="ajax/createExperiment/protocols/outputs/addNewOutput" method="post" >
        <!-- New Outputs List -->
        <c:set var="addNewOutputUrlTarget" value="/ajax/createExperiment/protocols/outputs/addNewOutput.action" />
        <c:set var="deleteOutputUrlTarget" value="/ajax/createExperiment/protocols/outputs/deleteOutput.action"/>
        <fieldset>
            <legend><fmt:message key="protexpress.page.createnewexperiment.addoutputs.title" /></legend>
            <%@ include file="/WEB-INF/jsp/experiment/common/manageNewOutputs.jsp"%>
        </fieldset>
        <!-- /New Outputs List -->
    </s:form>
  <div class="clear"></div>
 <protExpress:buttonRow>
        <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.addoutputs.button.continue" id="continue" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', 'divAjaxBody', '${saveUrl}'); return false;"/>
    </protExpress:buttonRow>

    <jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />