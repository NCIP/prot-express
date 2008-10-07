<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<h3>${experimentRun.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<jsp:include page="/WEB-INF/jsp/experiment/edit/refreshTree.jsp" />


<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_run_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<s:form id="editExperimentRunForm" action="/ajax/editExperiment/experimentRun/saveExperimentRun.action" method="post">
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>

    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.editexperimentrundetails.overviewtitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <protExpress:textfield formName="editExperimentRunForm" name="experimentRun.name" key="protexpress.experimentrun.name" required="true" maxlength="50"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <protExpress:textarea formName="editExperimentRunForm" name="experimentRun.notes" key="protexpress.experimentrun.notes" />
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.editexperimentrundetails.dateperformedtitle" /> (<fmt:message key="default.date.format"/>)</legend>
        <protExpress:datefield formName="editExperimentRunForm" htmlField="${experimentRun.datePerformed}" sname="experimentRun.datePerformed" theme="xhtml" />
    </fieldset>
    <div class="clear"><br /></div>

    <c:url var="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/protocol/addNewProtocol.action">
        <c:param name="experimentRunId" value="${experimentRun.id}" />
        <c:param name="experimentId" value="${experiment.id}" />
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



