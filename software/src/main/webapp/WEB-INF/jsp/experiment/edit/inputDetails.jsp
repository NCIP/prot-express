<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<h3>${inputOutputObject.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<jsp:include page="/WEB-INF/jsp/experiment/edit/refreshTree.jsp" />

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_input_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<s:form id="editInputForm" action="/ajax/editExperiment/input/saveInput.action" method="post">
    <s:hidden name="inputOutputObjectId" value="%{inputOutputObject.id}"/>
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>
    <table class="form">
        <tr>
            <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.input.name" />:</td>
            <td class="value">
                <protExpress:textfield formName="editInputForm" name="inputOutputObject.name" maxlength="200"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.input.filename" />:</td>
            <td class="value">
                <protExpress:textfield formName="editInputForm" name="inputOutputObject.dataFileURL" maxlength="200"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.input.notes" />:</td>
            <td class="value">
                <protExpress:textarea formName="editInputForm" name="inputOutputObject.notes" />
            </td>
        </tr>
    </table>
    <c:url var="deleteInputUrl" value="/ajax/editExperiment/input/deleteInput.action" />

    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.inputdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editInputForm', 'detail-content'); return false;"/>
        <c:choose>
            <c:when test="${inputOutputObject.outputOfProtocolApplication != null}">
                <protExpress:deleteButton style="delete" textKey="protexpress.page.inputdetails.buttons.delete" deleteConfirmText="linkedinput.delete.confirm" id="delete" onclick="ProtExpress.submitAjaxFormToUrl('editInputForm', 'detail-content', '${deleteInputUrl}'); this.blur(); return false;" />
            </c:when>
            <c:otherwise>
                <protExpress:deleteButton style="delete" textKey="protexpress.page.inputdetails.buttons.delete" deleteConfirmText="input.delete.confirm" id="delete" onclick="ProtExpress.submitAjaxFormToUrl('editInputForm', 'detail-content', '${deleteInputUrl}'); this.blur(); return false;" />
            </c:otherwise>
        </c:choose>
    </protExpress:buttonRow>
</s:form>
