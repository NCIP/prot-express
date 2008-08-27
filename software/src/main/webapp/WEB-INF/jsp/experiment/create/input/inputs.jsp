<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />

<div class="info">
    <p><fmt:message key="protexpress.page.createnewexperiment.addinputs.info" /></p>
</div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <protExpress:processStep selected="true" textKey="protexpress.page.createnewexperiment.steps.addinputs" insertNextStepIndicator="true"/>
    <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addoutputs" insertNextStepIndicator="true"/>
    <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewprotocol" />
    <div class="clear"></div>
</div>

<div id="divContent">
  <c:set var="formId" value="manageInputsForm" />

  <c:url var="saveUrl" value="/ajax/createExperiment/protocols/inputs/saveInputsToSession.action" />
 <s:actionerror ></s:actionerror>
    <s:form id="manageInputsForm" action="ajax/createExperiment/protocols/inputs/addNewInput" method="post" >
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
        <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.addinputs.button.continue" id="continue" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', 'divAjaxBody', '${saveUrl}'); return false;"/>
    </protExpress:buttonRow>


<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />