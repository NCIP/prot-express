<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.view_experiment_run_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h3>${experimentRun.name}</h3>
<form name="edit" id="edit">
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.name" />:</td>
            <td class="value">${experimentRun.name}</td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.dateperformed" />:</td>
            <td class="value"><fmt:formatDate type="date" pattern="MM/dd/yyyy" dateStyle="short" value="${experimentRun.datePerformed}" /></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.notes" />:</td>
            <td class="value">${experimentRun.notes}</td>
        </tr>
    </table>
</form>