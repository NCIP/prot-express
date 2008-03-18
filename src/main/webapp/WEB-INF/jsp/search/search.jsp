<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<head><s:head theme="ajax" /></head>
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
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->

    <div class="padme8">
        <!-- Add Content Here -->
        <h1><fmt:message key="protexpress.page.search.title" /></h1>
        <!--Search Filters-->
        <div class="filterbox">
            <h2><fmt:message key="protexpress.page.search.filtertitle" /></h2>
            <s:form id="searchForm" action="search/doSearch" method="post" theme="simple">
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
                                <s:datetimepicker
                                    name="searchParameters.fromDate"
                                    toggleType="fade"
                                    displayFormat="MM/dd/yyyy" /> -
                                <s:datetimepicker
                                    name="searchParameters.toDate"
                                    toggleType="fade"
                                    displayFormat="MM/dd/yyyy" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                <div class="actionsrow">
                    <del class="btnwrapper">
                        <ul id="btnrow2">
                            <li>
                                 <a href="javascript:document.getElementById('searchForm').submit();" class="btn" onclick="this.blur();"><span class="btn_img"><span class="search"><fmt:message key="protexpress.page.search.search" /></span></span></a>
                            </li>
                        </ul>
                    </del>
                </div>
            </s:form>
            <div class="clear"></div>
        </div>
        <!--/Search Filters-->
        <!--Search Results-->
        <jsp:include page="/WEB-INF/jsp/search/searchResults.jsp" />
        <!--/Search Results-->
    </div>
    <!-- /Add Content Here -->
</body>
