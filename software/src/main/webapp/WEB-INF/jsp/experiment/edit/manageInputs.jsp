<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<c:set var="mode" value="EDIT" />
<c:set var="formId" value="manageInputsForm" />
<c:set var="divId" value="detail-content" />

<c:url var="cancelUrl" value="/ajax/editExperiment/protocolApplication/load.action">
    <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    <c:param name="experimentRunId" value="${protocolApplication.experimentRun.id}" />
    <c:param name="experimentId" value="${protocolApplication.experimentRun.experiment.id}" />
</c:url>
<c:url var="saveUrl" value="/ajax/editExperiment/protocolApplication/updateInputs.action"  />

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_manage_inputs"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h3>${protocolApplication.experimentRun.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;${protocolApplication.protocol.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;<fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.caption" /></h3>
<s:actionerror ></s:actionerror>
<s:form id="manageInputsForm" action="/ajax/editExperiment/protocolApplication/addNewInput.action" method="post">
    <c:set var="formName" value="manageInputsForm" />

    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>

    <!-- New Inputs List -->
    <c:set var="addNewInputUrlTarget" value="/ajax/editExperiment/protocolApplication/addNewInput.action" />
    <c:set var="deleteInputUrlTarget" value="/ajax/editExperiment/protocolApplication/deleteInput.action"/>

    <fieldset>
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.addnewinputstitle" /></legend>
        <%@ include file="/WEB-INF/jsp/experiment/common/manageNewInputs.jsp"%>
    </fieldset>
    <!--/New Inputs List -->

    <!-- Select Input List-->
    <c:set var="addExistingInputUrlTarget" value="/ajax/editExperiment/protocolApplication/addExistingInput.action" />

    <fieldset>
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.selectexistinginputscaption" /></legend>
        <%@ include file="/WEB-INF/jsp/experiment/common/managePotentialInputs.jsp"%>
    </fieldset>
    <!--/Select Input List-->
</s:form>

<protExpress:buttonRow>
    <protExpress:button style="cancel" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.cancel" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', '${divId}', true); this.blur(); return false;"/>
    <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
</protExpress:buttonRow>


