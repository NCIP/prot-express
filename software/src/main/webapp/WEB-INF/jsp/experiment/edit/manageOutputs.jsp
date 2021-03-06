<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<c:set var="mode" value="EDIT" />
<c:set var="formId" value="manageOutputsForm" />
<c:set var="divId" value="detail-content" />

<c:url var="cancelUrl" value="/ajax/editExperiment/protocolApplication/load.action">
    <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    <c:param name="experimentRunId" value="${protocolApplication.experimentRun.id}" />
    <c:param name="experimentId" value="${protocolApplication.experimentRun.experiment.id}" />
</c:url>
<c:url var="saveUrl" value="/ajax/editExperiment/protocolApplication/updateOutputs.action" />

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_manage_outputs"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h3>${protocolApplication.experimentRun.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;${protocolApplication.protocol.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;<fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.caption" /></h3>
<s:actionerror ></s:actionerror>
<s:form id="manageOutputsForm" action="/ajax/editExperiment/protocolApplication/addNewOutput.action" method="post">
    <c:set var="formName" value="manageOutputsForm" />

    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>

    <!-- New Outputs List -->
    <c:set var="addNewOutputUrlTarget" value="/ajax/editExperiment/protocolApplication/addNewOutput.action" />
    <c:set var="deleteOutputUrlTarget" value="/ajax/editExperiment/protocolApplication/deleteOutput.action"/>

    <fieldset>
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.addnewoutputstitle" /></legend>
        <%@ include file="/WEB-INF/jsp/experiment/common/manageNewOutputs.jsp"%>
    </fieldset>
    <!--/New Outputs List -->
</s:form>

<protExpress:buttonRow>
    <protExpress:button style="cancel" textKey="protexpress.page.editprotocolapplicationdetails.outputs.button.cancel" id="cancel"  onclick="ProtExpress.loadDiv('${cancelUrl}', '${divId}', true); this.blur(); return false;"/>
    <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.outputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
</protExpress:buttonRow>