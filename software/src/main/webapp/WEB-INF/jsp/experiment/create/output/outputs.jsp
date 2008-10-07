<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />


<div class="info">
    <p><fmt:message key="protexpress.page.createnewexperiment.addoutputs.info" /></p>
</div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>

<c:if test="${protocolApplication.id == null}">
    <div id="processflow2">
        <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addinputs" insertNextStepIndicator="true"/>
        <protExpress:processStep selected="true" textKey="protexpress.page.createnewexperiment.steps.addoutputs" insertNextStepIndicator="true"/>
        <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewprotocol" />
        <div class="clear"></div>
    </div>
</c:if>

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.create_experiment_protocol_manage_outputs"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<div id="divContent">
  <c:set var="formId" value="manageOutputsForm" />
  <c:set var="divId" value="divAjaxBody" />

    <c:choose>
        <c:when test="${protocolApplication.id != null}">
            <c:url var="saveUrl" value="/ajax/createExperiment/protocols/outputs/saveOutputs.action" />
            <c:url var="cancelUrl" value="/ajax/createExperiment/protocols/manage/editProtocol.action">
                <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
            </c:url>
        </c:when>
        <c:when test="${protocolApplication.id == null}">
            <c:url var="saveUrl" value="/ajax/createExperiment/protocols/outputs/saveOutputsToSession.action" />
        </c:when>
    </c:choose>

 <s:actionerror ></s:actionerror>
    <s:form id="manageOutputsForm" action="ajax/createExperiment/protocols/outputs/addNewOutput" method="post" >
        <c:set var="formName" value="manageOutputsForm" />

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
        <c:choose>
            <c:when test="${protocolApplication.id != null}">
                <protExpress:button style="save" textKey="protexpress.page.createnewexperiment.addoutputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
                <protExpress:button style="cancel" textKey="protexpress.page.createnewexperiment.addoutputs.button.cancel" id="cancel" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${cancelUrl}'); this.blur(); return false;"/>
            </c:when>
            <c:when test="${protocolApplication.id == null}">
                <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.addoutputs.button.continue" id="continue" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', 'divAjaxBody', '${saveUrl}'); return false;"/>
            </c:when>
        </c:choose>
    </protExpress:buttonRow>

    <jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />