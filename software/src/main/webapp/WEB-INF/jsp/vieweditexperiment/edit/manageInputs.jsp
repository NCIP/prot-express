<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>


<c:set var="formId" value="manageInputsForm" />
<c:set var="divDetailContentId" value="detail-content" />

<c:url var="cancelUrl" value="/ajax/editExperiment/protocolApplication/load.action">
    <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    <c:param name="experimentRunId" value="${protocolApplication.experimentRun.id}" />
    <c:param name="experimentId" value="${protocolApplication.experimentRun.experiment.id}" />
</c:url>
<c:url var="saveUrl" value="/ajax/editExperiment/protocolApplication/updateInputs.action" />


<h3>${protocolApplication.experimentRun.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;${protocolApplication.protocol.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;<fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.caption" /></h3>

<s:form id="manageInputsForm" action="/ajax/editExperiment/protocolApplication/addNewInput.action" method="post">
    <!-- New Inputs List -->
    <div id="divNewInputs">
        <jsp:include page="/WEB-INF/jsp/vieweditexperiment/edit/manageNewInputs.jsp" />
    </div>
    <!-- New Inputs List -->

    <!--Input List-->
    <div id="divPotentialInputs">
        <jsp:include page="/WEB-INF/jsp/vieweditexperiment/edit/managePotentialInputs.jsp" />
    </div>
    <!--/Input List-->
</s:form>

<protExpress:buttonRow>
    <protExpress:button style="cancel" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.cancel" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', '${divDetailContentId}', true); this.blur(); return false;"/>
    <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divDetailContentId}', '${saveUrl}'); this.blur(); return false;"/>
</protExpress:buttonRow>


