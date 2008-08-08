<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<h3>${inputOutputObject.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
    <c:url var="actionUrl" value="/ajax/experiment/nav/tree/refreshInput.action">
        <c:param name="protAppId" value="${protocolApplicationId}"/>
        <c:param name="inputId" value="${inputOutputObject.id}"/>
        <c:param name="treeMode" value="EDIT"/>
    </c:url>
    <script type="text/javascript">
        var actionUrl = '${actionUrl}';
        var divElement = document.getElementById('span_${protocolApplicationId}.${inputOutputObject.id}');
        var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'post', evalScripts: true, executeScripts: true});
    </script>
</c:if>
<s:form id="editInputForm" action="/ajax/editExperiment/input/saveInput.action" method="post">
    <s:hidden name="inputOutputObjectId" value="%{inputOutputObject.id}"/>
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>
    <table class="form">
        <tr>
            <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.input.name" />:</td>
            <td class="value"><s:textfield name="inputOutputObject.name"/></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.input.filename" />:</td>
            <td class="value"><s:textfield name="inputOutputObject.dataFileURL"/></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.input.notes" />:</td>
            <td class="value">
                <s:textarea name="inputOutputObject.notes" rows="4" cols="20" cssStyle="width:90%"></s:textarea>
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
