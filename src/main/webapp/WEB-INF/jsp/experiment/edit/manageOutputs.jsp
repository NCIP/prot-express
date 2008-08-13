<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:set var="mode" value="EDIT" />
<c:set var="formId" value="manageOutputsForm" />
<c:set var="divId" value="detail-content" />

<c:url var="cancelUrl" value="/ajax/editExperiment/protocolApplication/load.action">
    <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    <c:param name="experimentRunId" value="${protocolApplication.experimentRun.id}" />
    <c:param name="experimentId" value="${protocolApplication.experimentRun.experiment.id}" />
</c:url>
<c:url var="saveUrl" value="/ajax/editExperiment/protocolApplication/updateOutputs.action">
    <c:param name="experimentId" value="${protocolApplication.experimentRun.experiment.id}" />
</c:url>

<h3>${protocolApplication.experimentRun.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;${protocolApplication.protocol.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;<fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.caption" /></h3>
<s:actionerror ></s:actionerror>
<s:form id="manageOutputsForm" action="/ajax/editExperiment/protocolApplication/addNewOutput.action" method="post">

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
    <protExpress:button style="cancel" textKey="protexpress.page.editprotocolapplicationdetails.outputs.button.cancel" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', '${divId}', true); this.blur(); return false;"/>
    <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.outputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
</protExpress:buttonRow>