<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<h3>${experimentRun.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;<fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.caption" /></h3>

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_experiment_select_existing_protocol_to_run"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<div class="tabs">
    <c:url var="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/protocol/addNewProtocol.action">
        <c:param name="experimentId" value="${experiment.id}" />
        <c:param name="experimentRunId" value="${experimentRun.id}" />
    </c:url>
    <c:url var="selectExistingProtocolUrl" value="/ajax/editExperiment/experimentRun/protocol/selectExistingProtocol.action">
       <c:param name="experimentId" value="${experiment.id}" />
        <c:param name="experimentRunId" value="${experimentRun.id}" />
    </c:url>
    <a href="javascript:http://noop/" onclick="ProtExpress.loadDiv('${addNewProtocolUrl}', 'detail-content', true)">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.addnewprotocol" /></span>
    </a>
    <a href="javascript:http://noop/" class="selected" onclick="ProtExpress.loadDiv('${selectExistingProtocolUrl}', 'detail-content', true)">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.selectexistingprotocol" /></span>
    </a>
</div>

<!--Protocol Search Form -->
<s:form id="searchForm" action="/ajax/editExperiment/experimentRun/protocol/searchProtocols" method="post" theme="simple">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}"/>
    <div style="text-align:right; padding:0 20px 0 0;">
        <s:a cssStyle="text-decoration:none" onclick="ProtExpress.submitAjaxForm('searchForm', 'detail-content'); return false;">
          <s:checkbox theme="ajax" name="searchParameters.searchAllUsers" key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" fieldValue="true" />&nbsp;
        </s:a>
    </div>
</s:form>
<!-- /Protocol Search Form -->
<!--Protocol Search Results List -->
<jsp:include page="/WEB-INF/jsp/experiment/edit/protocolSearchResults.jsp" />
<!--/Protocol Search Results List -->