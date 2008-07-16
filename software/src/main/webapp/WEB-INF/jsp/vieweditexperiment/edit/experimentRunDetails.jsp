<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<h3>${experimentRun.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
    <c:url var="actionUrl" value="/ajax/experiment/nav/tree/refreshExperimentRun.action">
        <c:param name="experimentRunId" value="${experimentRun.id}"/>
        <c:param name="treeMode" value="EDIT"/>
    </c:url>
    <script type="text/javascript">
        var actionUrl = '${actionUrl}';   
        var divElement = document.getElementById('span_${experimentRun.id}');
        var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'post', evalScripts: true, executeScripts: true});
    </script>    
</c:if>
<s:form id="editExperimentRunForm" action="/ajax/editExperiment/experimentRun/saveExperimentRun.action" method="post">
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.name" />:</td>
            <td class="value">
                <span class="required">*</span>&nbsp;<s:textfield name="experimentRun.name"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.dateperformed" />:</td>
            <td class="value">
                <span class="required">*</span>&nbsp;
                <s:textfield name="experimentRun.datePerformed" required="true" size="10" maxlength="10">
		            <s:param name="value"><s:date name="experimentRun.datePerformed" format="MM/dd/yyyy"/></s:param>
		            <s:param name="after"><div><fmt:message key="default.date.format"/></div></s:param>
		        </s:textfield>  
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.notes" />:</td>
            <td class="value">
                <s:textarea name="experimentRun.notes" rows="4" cols="20" cssStyle="width:90%"></s:textarea>
            </td>
        </tr>
    </table>

    <c:url var="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/addNewProtocol.action">
        <c:param name="experimentRunId" value="${experimentRun.id}" />
    </c:url>
    <protExpress:buttonRow>
        <protExpress:button style="copy" textKey="protexpress.page.editexperimentrundetails.buttons.repeat" id="copy" href="javascript:alert('Not Yet Implemented');"/>
        <protExpress:button style="save" textKey="protexpress.page.editexperimentrundetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editExperimentRunForm', 'detail-content'); return false;"/>
        <protExpress:button style="delete" textKey="protexpress.page.editexperimentrundetails.buttons.delete" id="delete" href="javascript:alert('Not Yet Implemented');"/>
        <protExpress:button style="add_folder" textKey="protexpress.page.editexperimentrundetails.buttons.addprotocol" id="add_folder" onclick="ProtExpress.loadDiv('${addNewProtocolUrl}', 'detail-content', true); this.blur(); return false;"/>
    </protExpress:buttonRow>

</s:form>