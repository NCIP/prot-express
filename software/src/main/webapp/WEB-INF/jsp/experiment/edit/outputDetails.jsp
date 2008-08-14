<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

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
            <td class="value"><s:textfield name="inputOutputObject.name" /></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.output.filename" />:</td>
            <td class="value"><s:textfield name="inputOutputObject.dataFileURL"/></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.output.notes" />:</td>
            <td class="value">
                <s:textarea name="inputOutputObject.notes" rows="4" cols="20" cssStyle="width:90%"></s:textarea>
            </td>
        </tr>
    </table>
    <c:url var="deleteOutputUrl" value="/ajax/editExperiment/output/deleteOutput.action" />
    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.outputdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editOutputForm', 'detail-content'); return false;"/>
        <protExpress:deleteButton style="delete" textKey="protexpress.page.outputdetails.buttons.delete" id="delete" deleteConfirmText="output.delete.confirm"  onclick="ProtExpress.submitAjaxFormToUrl('editOutputForm', 'detail-content', '${deleteOutputUrl}'); this.blur(); return false;"/>

    </protExpress:buttonRow>
</s:form>
