<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<h3>${inputOutputObject.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
    <c:url var="actionUrl" value="/ajax/experiment/nav/tree/refreshOutput.action">
        <c:param name="protAppId" value="${protocolApplicationId}"/>
        <c:param name="outputId" value="${inputOutputObject.id}"/>
        <c:param name="treeMode" value="EDIT"/>
    </c:url>
    <script type="text/javascript">
        var actionUrl = '${actionUrl}';
        var divElement = document.getElementById('span_${protocolApplicationId}.${inputOutputObject.id}');
        var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'post', evalScripts: true, executeScripts: true});
    </script>
</c:if>
<s:form id="editOutputForm" action="/ajax/editExperiment/output/saveOutput.action" method="post">
    <s:hidden name="inputOutputObjectId" value="%{inputOutputObject.id}"/>
    <s:hidden name="protocolApplicationId" value="%{protocolApplicationId}"/>
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
    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.outputdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editOutputForm', 'detail-content'); return false;"/>
        <protExpress:button style="delete" textKey="protexpress.page.outputdetails.buttons.delete" id="delete" href="javascript:alert('Not Yet Implemented');"/>
    </protExpress:buttonRow>
</s:form>

