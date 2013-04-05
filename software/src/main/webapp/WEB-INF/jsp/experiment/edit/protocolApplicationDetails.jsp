<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<h3>${protocolApplication.protocol.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<jsp:include page="/WEB-INF/jsp/experiment/edit/refreshTree.jsp" />

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_protocol_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<s:form id="editProtAppForm" action="/ajax/editExperiment/protocolApplication/saveProtocolApplication.action" method="post">
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>

    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.overviewtitle" /></legend>
        <table class="form2">
            <tr>
                <td class="label_left">
                    <protExpress:textfield formName="editProtAppForm" name="protocolApplication.protocol.name" key="protexpress.protocol.name" required="true" maxlength="200"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <protExpress:textarea formName="editProtAppForm" name="protocolApplication.protocol.description" key="protexpress.protocol.description" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <protExpress:textarea formName="editProtAppForm" name="protocolApplication.notes" key="protexpress.protocol.notes" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <protExpress:textfield formName="editProtAppForm" name="protocolApplication.protocol.software" key="protexpress.protocol.software" maxlength="200"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <protExpress:textfield formName="editProtAppForm" name="protocolApplication.protocol.instrument" key="protexpress.protocol.instrument" maxlength="200"/>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.editprotocolapplicationdetails.dateperformedtitle" /> (<fmt:message key="default.date.format"/>)</legend>
        <protExpress:datefield formName="editProtAppForm" htmlField="${protocolApplication.datePerformed}" sname="protocolApplication.datePerformed" theme="xhtml" />
    </fieldset>

    <!-- Protocol Application Contact -->
    <c:set var="formName" value="editProtAppForm" />
    <c:set var="title" value="protexpress.page.editprotocolapplicationdetails.contacttitle" />
    <c:set var="nameFirstName" value="protocolApplication.protocol.contactPerson.firstName" />
    <c:set var="nameLastName" value="protocolApplication.protocol.contactPerson.lastName" />
    <c:set var="nameEmail" value="protocolApplication.protocol.contactPerson.email" />
    <c:set var="nameNotes" value="protocolApplication.protocol.contactPerson.notes" />
    <%@ include file="/WEB-INF/jsp/experiment/common/contactPersonInfo.jsp"%>
    <!-- /Protocol Application Contact -->

    <div class="clear" />

    <c:url var="manageInputsUrl" value="/ajax/editExperiment/protocolApplication/manageInputs.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
        <c:param name="experimentRunId" value="${experimentRun.id}" />
        <c:param name="experimentId" value="${experiment.id}" />
    </c:url>
    <c:url var="manageOutputsUrl" value="/ajax/editExperiment/protocolApplication/manageOutputs.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
        <c:param name="experimentRunId" value="${experimentRun.id}" />
        <c:param name="experimentId" value="${experiment.id}" />
    </c:url>

    <c:url var="deleteProtAppUrl" value="/ajax/editExperiment/protocolApplication/delete.action" />

    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('editProtAppForm', 'detail-content'); return false;"/>
        <protExpress:button style="add_input" textKey="protexpress.page.editprotocolapplicationdetails.buttons.addinput" id="add_input" onclick="ProtExpress.loadDiv('${manageInputsUrl}', 'detail-content', true); this.blur(); return false;"/>
        <protExpress:button style="add_output" textKey="protexpress.page.editprotocolapplicationdetails.buttons.addoutput" id="add_output" onclick="ProtExpress.loadDiv('${manageOutputsUrl}', 'detail-content', true); this.blur(); return false;"/>
        <protExpress:deleteButton style="delete" textKey="protexpress.page.editprotocolapplicationdetails.buttons.delete" id="delete" deleteConfirmText="protocolapplication.delete.confirm"  onclick="ProtExpress.submitAjaxFormToUrl('editProtAppForm', 'detail-content', '${deleteProtAppUrl}'); this.blur(); return false;"/>
    </protExpress:buttonRow>
</s:form>

