<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<h3>${experiment.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
    <c:url var="actionUrl" value="/ajax/experiment/nav/tree/refreshExperiment.action">
        <c:param name="experimentId" value="${experiment.id}"/>
        <c:param name="treeMode" value="EDIT"/>
    </c:url>
    <script type="text/javascript">
	    var actionUrl = '${actionUrl}';   
	    var divElement = document.getElementById('span_${experiment.id}');
	    var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'post', evalScripts: true, executeScripts: true});
    </script>
</c:if>
<s:form id="editExperimentForm" action="/ajax/editExperiment/experiment/saveExperiment.action" method="post">
    <s:hidden name="experimentId" value="%{experiment.id}"/>
    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.overviewtitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <span class="required">*</span>&nbsp;<s:textfield name="experiment.name" key="protexpress.experiment.name" labelposition="top"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.description" key="protexpress.experiment.description" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.hypothesis" key="protexpress.experiment.hypothesis" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.url" key="protexpress.experiment.url" labelposition="top"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.notes" key="protexpress.experiment.notes" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.dateperformedtitle" /></legend>
		<s:textfield name="experiment.datePerformed" required="true" size="10" maxlength="10">
		    <s:param name="value"><s:date name="experiment.datePerformed" format="MM/dd/yyyy"/></s:param>
		    <s:param name="after"><div><fmt:message key="default.date.format"/></div></s:param>
		</s:textfield>        
    </fieldset>
    <fieldset class="rightfield">
        <legend><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.contacttitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.contactPerson.firstName" key="protexpress.contact.firstname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.contactPerson.lastName" key="protexpress.contact.lastname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.contactPerson.email" key="protexpress.contact.email" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.contactPerson.notes" key="protexpress.contact.notes" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="clear"><br /></div>
    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.editexperimentdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editExperimentForm', 'detail-content'); return false;"/>
        <protExpress:button style="delete" textKey="protexpress.page.editexperimentdetails.buttons.delete" id="delete" href="javascript:alert('Not Yet Implemented');"/>
    </protExpress:buttonRow>
</s:form>