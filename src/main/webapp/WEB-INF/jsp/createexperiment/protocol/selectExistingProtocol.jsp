<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolHeader.jsp" />
<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/addOrSelectProtocolHeader.jsp" />

<!--Protocol List-->
<s:form id="searchForm" action="createExperiment/manageProtocols/doSearch" method="post" theme="simple">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <div style="text-align:right; padding:0 20px 0 0;">
        <s:checkbox name="searchParameters.searchAllUsers" key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" fieldValue="true" />&nbsp;
        <fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.searchallusers" />&nbsp;
        <div class="actionsrow">
            <del class="btnwrapper">
                <ul id="btnrow2">
                    <li>
                        <a href="javascript:document.getElementById('searchForm').submit();" class="btn" onclick="this.blur();"><span class="btn_img"><span class="search"><fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.button.refresh" /></span></span></a>
                    </li>
                </ul>
            </del>
        </div>
    </div>
</s:form>

<div class="tabbed">
    <div class="searchresults">
    <c:url var="sortUrl" value="/ajax/createExperiment/manageProtocols/doSearch.action" />

    <s:hidden name="protocolApplication.id" value="${protocolApplication.id}"/>
    <s:hidden name="experimentId" value="${experiment.id}"/>

    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="newdata3">
        <display:table class="newdata3" cellspacing="0" list="${protocols}" requestURI="${sortUrl}" id="row">
            <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
            <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
            <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />

            <c:set var="emailUrl" value="mailto:test@test.com" />
            <protExpress:displayTagProperties />

            <display:column property="name" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.name" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="description" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.name" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="notes" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.notes" maxLength="20" maxWords="4" />
            <display:column titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.user">
                <a href="${emailUrl}">${row.auditInfo.creator}</a>
            </display:column>
            <display:column class="actionwide" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.action">
                <del class="btnwrapper">
                    <ul id="btnrow2">
                        <li>
                            <a href="experimentcreate_protocols2.htm" class="btn" style="text-decoration:none" onclick="this.blur();">
                                <span class="btn_img">
                                    <span class="add"><fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.button.selectandcontinue" /></span>
                                </span>
                            </a>
                        </li>
                    </ul>
                </del>
            </display:column>
        </display:table>
    </ajax:displayTag>
</div>
</div>
<!--/Protocol List-->

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolFooter.jsp" />
