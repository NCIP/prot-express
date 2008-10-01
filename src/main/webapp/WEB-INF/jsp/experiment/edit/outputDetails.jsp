<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<h3>${inputOutputObject.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<jsp:include page="/WEB-INF/jsp/experiment/edit/refreshTree.jsp" />


<s:form id="editOutputForm" action="/ajax/editExperiment/output/saveOutput.action" method="post">
    <s:hidden name="inputOutputObjectId" value="%{inputOutputObject.id}"/>
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>
    <table class="form">
        <tr>
            <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.output.name" />:</td>
            <td class="value">
                <protExpress:textfield formName="editOutputForm" name="inputOutputObject.name" maxlength="200"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.output.filename" />:</td>
            <td class="value">
                <protExpress:textfield formName="editOutputForm" name="inputOutputObject.dataFileURL" maxlength="200"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.output.notes" />:</td>
            <td class="value">
                <protExpress:textarea formName="editOutputForm" name="inputOutputObject.notes" />
            </td>
        </tr>
    </table>
    <c:url var="deleteOutputUrl" value="/ajax/editExperiment/output/deleteOutput.action" />
    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.outputdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editOutputForm', 'detail-content'); return false;"/>
        <protExpress:deleteButton style="delete" textKey="protexpress.page.outputdetails.buttons.delete" id="delete" deleteConfirmText="output.delete.confirm"  onclick="ProtExpress.submitAjaxFormToUrl('editOutputForm', 'detail-content', '${deleteOutputUrl}'); this.blur(); return false;"/>

    </protExpress:buttonRow>
</s:form>

