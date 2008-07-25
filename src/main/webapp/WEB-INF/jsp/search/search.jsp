<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<title><fmt:message key="protexpress.page.search.caption" /></title>
<script type="text/javascript">
    // Define the variables that will be used for the date controls in subsequent page.
    // Variables have to be defined in the parent page, due to scope problems.
    // These variables will be referred to in the appropriate page for displaying the calendar popup controls.

    var fromDate, toDate;
</script>
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
						        <s:textfield name="searchParameters.fromDate" required="true" size="10" maxlength="10">
						            <s:param name="value"><s:date name="searchParameters.fromDate" format="MM/dd/yyyy"/></s:param>
						        </s:textfield>
						        <a href="javascript://noop/" onclick="fromDate.toggle();"><img src="<c:url value="/images/ico_calendar.gif" />" /></a>                            
                                -
						        <s:textfield name="searchParameters.toDate" required="true" size="10" maxlength="10">
						            <s:param name="value"><s:date name="searchParameters.toDate" format="MM/dd/yyyy"/></s:param>
						        </s:textfield>
						        <a href="javascript://noop/" onclick="toDate.toggle();"><img src="<c:url value="/images/ico_calendar.gif" />" /></a>                            
                            </td>
                        </tr>
                    </tbody>
                </table>
                <protExpress:buttonRow>
                    <protExpress:button onclick="ProtExpress.submitAjaxForm('searchForm', 'searchresults'); this.blur(); return false;" textKey="protexpress.page.search.search" style="search"/>
                </protExpress:buttonRow>
            </s:form>
            <div class="clear"></div>
		<script type="text/javascript">
		    toDate = new Epoch('toDatePopup', 'popup', document.getElementById('searchForm_searchParameters_toDate'));
		    fromDate = new Epoch('fromDatePopup', 'popup', document.getElementById('searchForm_searchParameters_fromDate'));
		</script>            
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
