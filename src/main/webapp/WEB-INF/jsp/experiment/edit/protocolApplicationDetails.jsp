<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<h3>${protocolApplication.protocol.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
    <c:url var="actionUrl" value="/ajax/experiment/nav/tree/refreshProtocolApplication.action">
        <c:param name="protAppId" value="${protocolApplication.id}"/>
        <c:param name="treeMode" value="EDIT"/>
    </c:url>
    <script type="text/javascript">
        var actionUrl = '${actionUrl}';
        var divElement = document.getElementById('span_${protocolApplication.id}');
        var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'post', evalScripts: true, executeScripts: true});
    </script>
</c:if>
<s:form id="editProtAppForm" action="/ajax/editExperiment/protocolApplication/saveProtocolApplication.action" method="post">
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.overviewtitle" /></legend>
        <table class="form2">
            <tr>
                <td class="label_left"><s:textfield name="protocolApplication.protocol.name" key="protexpress.protocol.name" required="true" labelposition="top"/></td>
            </tr>
            <tr>
                <td class="label_left"><s:textarea name="protocolApplication.protocol.description" key="protexpress.protocol.description" labelposition="top" rows="4"></s:textarea></td>
            </tr>
            <tr>
                <td class="label_left"><s:textarea name="protocolApplication.notes" key="protexpress.protocol.notes" labelposition="top" rows="4"></s:textarea></td>
            </tr>
            <tr>
                <td class="label_left"><s:textfield name="protocolApplication.protocol.software" key="protexpress.protocol.software" labelposition="top"/></td>
            </tr>
            <tr>
                <td class="label_left"><s:textfield name="protocolApplication.protocol.instrument" key="protexpress.protocol.instrument" labelposition="top"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.editprotocolapplicationdetails.dateperformedtitle" /> (<fmt:message key="default.date.format"/>)</legend>
        <s:textfield theme="xhtml" name="protocolApplication.datePerformed" required="true" size="10" maxlength="10">
            <s:param name="value"><s:date name="protocolApplication.datePerformed" format="MM/dd/yyyy"/></s:param>
        </s:textfield>
        <a href="javascript://noop/" onclick="protAppDatePerformed.toggle();"><img src="<c:url value="/images/ico_calendar.gif" />" /></a>
    </fieldset>
     <fieldset class="rightfield">
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.contacttitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <s:textfield name="protocolApplication.protocol.contactPerson.firstName" key="protexpress.contact.firstname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="protocolApplication.protocol.contactPerson.lastName" key="protexpress.contact.lastname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="protocolApplication.protocol.contactPerson.email" key="protexpress.contact.email" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="protocolApplication.protocol.contactPerson.notes" key="protexpress.contact.notes" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="clear" />

    <c:url var="manageInputsUrl" value="/ajax/editExperiment/protocolApplication/manageInputs.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    </c:url>
    <c:url var="manageOutputsUrl" value="/ajax/editExperiment/protocolApplication/manageOutputs.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    </c:url>

    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editProtAppForm', 'detail-content'); return false;"/>
        <protExpress:button style="add_input" textKey="protexpress.page.editprotocolapplicationdetails.buttons.addinput" id="add_input" onclick="ProtExpress.loadDiv('${manageInputsUrl}', 'detail-content', true); this.blur(); return false;"/>
        <protExpress:button style="add_output" textKey="protexpress.page.editprotocolapplicationdetails.buttons.addoutput" id="add_output" onclick="ProtExpress.loadDiv('${manageOutputsUrl}', 'detail-content', true); this.blur(); return false;"/>
        <protExpress:button style="delete" textKey="protexpress.page.editprotocolapplicationdetails.buttons.delete" id="delete" href="javascript:alert('Not Yet Implemented');"/>
    </protExpress:buttonRow>
</s:form>

<script type="text/javascript">
    protAppDatePerformed = new Epoch('protAppDatePerformedPopup', 'popup', document.getElementById('editProtAppForm_protocolApplication_datePerformed'));
</script>
