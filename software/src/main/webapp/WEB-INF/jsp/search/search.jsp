<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<title><fmt:message key="protexpress.page.search.caption" /></title>

<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/home/home.action"/>"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;
        <span class="&gt;">&gt;</span>&nbsp;
        <a href="<c:url value="/search/reloadSearch.action"/>" class="selected"><fmt:message key="protexpress.breadcrumb.search" />
    </div>
    <!-- /Breadcrumb -->

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->


<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.search_protexpress"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->


    <div class="padme8">
        <!-- Add Content Here -->
        <h1><fmt:message key="protexpress.page.search.title" /></h1>
        <!--Search Filters-->
        <div class="filterbox">
            <h2><fmt:message key="protexpress.page.search.filtertitle" /></h2>
            <s:form id="searchForm" action="ajax/search/doSearch" method="post" theme="simple">
              <!--   <s:hidden name="protocols.sortDirection" />
                <s:hidden name="protocols.sortCriterion" />
                <s:hidden name="experiments.sortDirection" />
                <s:hidden name="experiments.sortCriterion" />
                -->
                <table class="form">
                    <tbody>
                        <tr style="height: 28px;">
                            <td class="label" style="text-align: left; vertical-align: bottom; width: 250px;">
                                <fmt:message key="protexpress.page.search.searchfor" />:
                                <s:radio
                                    name="searchParameters.searchType"
                                    key="protexpress.page.search.searchfor"
                                    list="@gov.nih.nci.protexpress.service.SearchType@values()"
                                    listValue="displayName" />
                            </td>
                            <td class="label" style="text-align: left; vertical-align: bottom;"><fmt:message key="protexpress.page.search.lastmodified" />:</td>
                            <td class="label"><fmt:message key="protexpress.page.search.searchallusers" />: <s:checkbox name="searchParameters.searchAllUsers" key="protexpress.page.search.searchallusers" fieldValue="true" /></td>
                        </tr>
                        <tr>
                            <td  class="label" style="text-align: left; vertical-align: bottom;">
                                <fmt:message key="protexpress.page.search.name" />: <s:textfield name="searchParameters.name" key="protexpress.page.search.name" size="25" />
                            </td>
                            <td id="date" colspan="2">
                                <protExpress:datefield formName="searchForm" htmlField="${searchParameters.fromDate}" sname="searchParameters.fromDate" theme="simple" />
                                -
                                <protExpress:datefield formName="searchForm" htmlField="${searchParameters.toDate}" sname="searchParameters.toDate" theme="simple" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                <protExpress:buttonRow>
                    <protExpress:button onclick="ProtExpress.submitAjaxForm('searchForm', 'searchresults'); this.blur(); return false;" textKey="protexpress.page.search.search" style="search"/>
                </protExpress:buttonRow>
            </s:form>
            <div class="clear"></div>
        </div>

        <div class="searchresults" id="searchresults">
        <!--/Search Filters-->
        <!--Search Results-->
        <jsp:include page="/WEB-INF/jsp/search/searchResults.jsp" />
        <!--/Search Results-->
        </div>
    </div>
    <!-- /Add Content Here -->
</body>
