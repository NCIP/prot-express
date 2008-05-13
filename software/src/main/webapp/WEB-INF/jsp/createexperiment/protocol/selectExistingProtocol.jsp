<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolHeader.jsp" />
<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/addOrSelectProtocolHeader.jsp" />

<div class="tabs">
    <a href="<c:url value="/createExperiment/protocols/add/addNewProtocol.action" />" ><span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.addnewprotocol" /></span></a>
    <a href="<c:url value="/createExperiment/protocols/add/selectExistingProtocol.action" />" class="selected"><span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.selectexistingprotocol" /></span></a>
</div>

<!--Protocol Search Form -->
<s:form id="searchForm" action="createExperiment/protocols/add/doSearch" method="post" theme="simple">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <div style="text-align:right; padding:0 20px 0 0;">
        <s:checkbox name="searchParameters.searchAllUsers" key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" fieldValue="true" onclick="javascript:document.getElementById('searchForm').submit();" />&nbsp;
        <fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" />&nbsp;
    </div>
</s:form>
<!-- /Protocol Search Form -->
<!--Protocol Search Results List -->
<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolSearchResults.jsp" />
<!--/Protocol Search Results List -->

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolFooter.jsp" />
