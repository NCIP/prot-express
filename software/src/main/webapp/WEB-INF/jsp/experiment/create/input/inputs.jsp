<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />

<div class="info">
    <p><fmt:message key="protexpress.page.createnewexperiment.addinputs.info" /></p>
</div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>

<c:if test="${protocolApplication.id == null}">
  <div id="processflow2">
      <protExpress:processStep selected="true" textKey="protexpress.page.createnewexperiment.steps.addinputs" insertNextStepIndicator="true"/>
      <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addoutputs" insertNextStepIndicator="true"/>
      <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewprotocol" />
      <div class="clear"></div>
  </div>
</c:if>

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.create_experiment_protocol_manage_inputs"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<div id="divContent">
    <c:set var="formId" value="manageInputsForm" />
    <c:set var="divId" value="divAjaxBody" />

    <c:choose>
        <c:when test="${protocolApplication.id != null}">
            <c:url var="saveUrl" value="/ajax/createExperiment/protocols/inputs/saveInputs.action" />
            <c:url var="cancelUrl" value="/ajax/createExperiment/protocols/manage/editProtocol.action">
                <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
            </c:url>
        </c:when>
        <c:when test="${protocolApplication.id == null}">
            <c:url var="saveUrl" value="/ajax/createExperiment/protocols/inputs/saveInputsToSession.action" />
        </c:when>
    </c:choose>

 <s:actionerror ></s:actionerror>
    <s:form id="manageInputsForm" action="ajax/createExperiment/protocols/inputs/addNewInput" method="post" >
        <c:set var="formName" value="manageInputsForm" />

        <!-- New Inputs List -->
        <c:set var="addNewInputUrlTarget" value="/ajax/createExperiment/protocols/inputs/addNewInput.action" />
        <c:set var="deleteInputUrlTarget" value="/ajax/createExperiment/protocols/inputs/deleteInput.action"/>
        <fieldset>
            <legend><fmt:message key="protexpress.page.createnewexperiment.addinputs.title" /></legend>
            <%@ include file="/WEB-INF/jsp/experiment/common/manageNewInputs.jsp"%>
        </fieldset>
        <!-- /New Inputs List -->
      <!-- Select Input List-->
      <c:set var="addExistingInputUrlTarget" value="/ajax/createExperiment/protocols/inputs/addExistingInput.action" />
      <fieldset>
          <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.selectexistinginputscaption" /></legend>
          <%@ include file="/WEB-INF/jsp/experiment/common/managePotentialInputs.jsp"%>
      </fieldset>
      <!--/Select Input List-->
    </s:form>
  <div class="clear"></div>
    <protExpress:buttonRow>
        <c:choose>
            <c:when test="${protocolApplication.id != null}">
                <protExpress:button style="save" textKey="protexpress.page.createnewexperiment.addinputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
                <protExpress:button style="cancel" textKey="protexpress.page.createnewexperiment.addinputs.button.cancel" id="cancel" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${cancelUrl}'); this.blur(); return false;"/>
            </c:when>
            <c:when test="${protocolApplication.id == null}">
                <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.addinputs.button.continue" id="continue" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
            </c:when>
        </c:choose>
    </protExpress:buttonRow>


<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />