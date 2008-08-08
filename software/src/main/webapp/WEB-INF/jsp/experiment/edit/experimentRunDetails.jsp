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
    <s:hidden name="experimentId" value="%{experiment.id}"/>

    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.editexperimentrundetails.overviewtitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <s:textfield name="experimentRun.name" key="protexpress.experimentrun.name" labelposition="top" required="true"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experimentRun.notes" key="protexpress.experimentrun.notes" labelposition="top" rows="4" cols="20"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.editexperimentrundetails.dateperformedtitle" /> (<fmt:message key="default.date.format"/>)</legend>
        <s:textfield theme="xhtml" name="experimentRun.datePerformed" required="true" size="10" maxlength="10">
            <s:param name="value"><s:date name="experimentRun.datePerformed" format="MM/dd/yyyy"/></s:param>
        </s:textfield><a href="javascript://noop/" onclick="expRunDatePerformed.toggle();"><img src="<c:url value="/images/ico_calendar.gif" />" /></a>
    </fieldset>
    <div class="clear"><br /></div>

    <c:url var="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/addNewProtocol.action">
        <c:param name="experimentRunId" value="${experimentRun.id}" />
    </c:url>
    <c:url var="repeatExperimentRunUrl" value="/ajax/editExperiment/experimentRun/repeat.action" />
    <c:url var="deleteExperimentRunUrl" value="/ajax/editExperiment/experimentRun/delete.action" />

    <protExpress:buttonRow>
        <protExpress:button style="copy" textKey="protexpress.page.editexperimentrundetails.buttons.repeat" id="copy" onclick="ProtExpress.submitAjaxFormToUrl('editExperimentRunForm', 'detail-content', '${repeatExperimentRunUrl}'); return false;"/>
        <protExpress:button style="save" textKey="protexpress.page.editexperimentrundetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editExperimentRunForm', 'detail-content'); return false;"/>
        <protExpress:deleteButton style="delete" textKey="protexpress.page.editexperimentrundetails.buttons.delete" id="delete" deleteConfirmText="experimentrun.delete.confirm"  onclick="ProtExpress.submitAjaxFormToUrl('editExperimentRunForm', 'detail-content', '${deleteExperimentRunUrl}'); this.blur(); return false;"/>
        <protExpress:button style="add_folder" textKey="protexpress.page.editexperimentrundetails.buttons.addprotocol" id="add_folder" onclick="ProtExpress.loadDiv('${addNewProtocolUrl}', 'detail-content', true); this.blur(); return false;"/>
    </protExpress:buttonRow>
</s:form>
<script type="text/javascript">
    expRunDatePerformed = new Epoch('expRunDatePerformedPopup', 'popup', document.getElementById('editExperimentRunForm_experimentRun_datePerformed'));
</script>



