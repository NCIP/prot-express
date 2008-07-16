<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>


<h3><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.caption" /></h3>

<div class="tabs">
    <s:url id="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/addNewProtocol.action">
        <s:param name="experimentRunId" value="experimentRun.id" />
    </s:url>
    <s:url id="selectExistingProtocolUrl" value="/ajax/editExperiment/experimentRun/selectExistingProtocol.action">
        <s:param name="experimentRunId" value="experimentRun.id" />
    </s:url>
    <s:a href="javascript:http://noop/" onclick="ProtExpress.loadDiv('%{addNewProtocolUrl}', 'detail-content', true)">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.addnewprotocol" /></span>
    </s:a>
    <s:a href="javascript:http://noop/" cssClass="selected" onclick="ProtExpress.loadDiv('%{selectExistingProtocolUrl}', 'detail-content', true)">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.selectexistingprotocol" /></span>
    </s:a>
</div>

<!--Protocol Search Form -->
<s:form id="searchForm" action="/ajax/editExperiment/experimentRun/searchProtocols" method="post" theme="simple">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <div style="text-align:right; padding:0 20px 0 0;">
        <s:a cssStyle="text-decoration:none" onclick="ProtExpress.submitAjaxForm('searchForm', 'detail-content'); return false;">
          <s:checkbox theme="ajax" name="searchParameters.searchAllUsers" key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" fieldValue="true" />&nbsp;
        </s:a>
    </div>
</s:form>
<!-- /Protocol Search Form -->
<!--Protocol Search Results List -->
<jsp:include page="/WEB-INF/jsp/vieweditexperiment/edit/protocolSearchResults.jsp" />
<!--/Protocol Search Results List -->