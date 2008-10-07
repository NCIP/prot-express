<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!-- TABS -->
<c:url var="addNewProtocolUrl" value="/ajax/createExperiment/protocols/add/addNewProtocol.action" />
<c:url var="selectExistingProtocolUrl" value="/ajax/createExperiment/protocols/add/selectExistingProtocol.action" />
<div class="tabs">
    <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${addNewProtocolUrl}', 'divAjaxBody', true);">
        <span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.addnewprotocol" /></span>
    </a>
    <a href="javascript://noop/" class="selected"  onclick="ProtExpress.loadDiv('${selectExistingProtocolUrl}', 'divAjaxAddOrSelectProtocolBody', true);">
        <span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.selectexistingprotocol" /></span>
    </a>
</div>
<!-- /TABS -->

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.create_experiment_select_existing_protocol"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<!--Protocol Search Form -->
<s:form id="searchForm" action="ajax/createExperiment/protocols/add/selectExistingProtocol" method="post" theme="simple">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <div style="text-align:right; padding:0 20px 0 0;">
        <s:checkbox name="searchParameters.searchAllUsers" key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" fieldValue="true"
            onclick="ProtExpress.submitAjaxForm('searchForm', 'divAjaxAddOrSelectProtocolBody'); return false;" />&nbsp;
        <fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" />&nbsp;
    </div>
</s:form>
<!-- /Protocol Search Form -->
<!--Protocol Search Results List -->
<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/protocolSearchResults.jsp" />
<!--/Protocol Search Results List -->
