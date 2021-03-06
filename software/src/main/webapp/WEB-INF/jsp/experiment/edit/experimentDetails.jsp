<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<h3>${experiment.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<jsp:include page="/WEB-INF/jsp/experiment/edit/refreshTree.jsp" />

<s:form id="editExperimentForm" action="/ajax/editExperiment/experiment/delete.action" method="post">
    <s:hidden name="experimentId" value="%{experiment.id}"/>

    <c:set var="formName" value="editExperimentForm" />
    <!-- Experiment Info -->
    <c:set var="title" value="protexpress.page.editexperimentdetails.overviewtitle" />
    <c:set var="nameExperimentName" value="experiment.name" />
    <c:set var="nameExperimentDescription" value="experiment.description" />
    <c:set var="nameExperimentHypothesis" value="experiment.hypothesis" />
    <c:set var="nameExperimentUrl" value="experiment.url" />
    <c:set var="nameExperimentNotes" value="experiment.notes" />
    <%@ include file="/WEB-INF/jsp/experiment/common/experimentInfo.jsp"%>
    <!-- /Experiment Info -->

    <!-- Experiment Date -->
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.editexperimentdetails.dateperformedtitle" /> (<fmt:message key="default.date.format"/>)</legend>
        <protExpress:datefield formName="editExperimentForm" htmlField="${experiment.datePerformed}" sname="experiment.datePerformed" theme="xhtml" />
    </fieldset>
    <!-- /Experiment Date -->

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

    <!-- Experiment Contact -->
    <c:set var="title" value="protexpress.page.editexperimentdetails.contacttitle" />
    <c:set var="nameFirstName" value="experiment.contactPerson.firstName" />
    <c:set var="nameLastName" value="experiment.contactPerson.lastName" />
    <c:set var="nameEmail" value="experiment.contactPerson.email" />
    <c:set var="nameNotes" value="experiment.contactPerson.notes" />
    <%@ include file="/WEB-INF/jsp/experiment/common/contactPersonInfo.jsp"%>
    <!-- /Experiment Contact -->

    <div class="clear"><br /></div>

    <c:url var="deleteExperimentUrl" value="/ajax/editExperiment/experiment/delete.action" />
    <c:url var="saveExperimentUrl" value="/ajax/editExperiment/experiment/saveExperiment.action" />

    <protExpress:buttonRow>
        <protExpress:button style="save" textKey="protexpress.page.editexperimentdetails.buttons.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('editExperimentForm', 'detail-content', '${saveExperimentUrl}'); return false;"/>
        <protExpress:deleteButton style="delete" textKey="protexpress.page.editexperimentdetails.buttons.delete" id="delete" deleteConfirmText="experiment.delete.confirm"  onclick="document.getElementById('editExperimentForm').submit(); this.blur(); return false;"/>
    </protExpress:buttonRow>
</s:form>



