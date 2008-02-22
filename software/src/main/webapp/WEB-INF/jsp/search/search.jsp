<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/"/>"><fmt:message key="protexpress.breadcrumb.home" /></a> <span class="&gt;">&gt;</span> <a href="<c:url value="/"/>" class="selected"><fmt:message key="protexpress.breadcrumb.search" />
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
            <s:form action="search/doSearch" method="post">
                <div id="form">
                    <s:hidden name="protocols.sortDirection" />
                    <s:hidden name="protocols.sortCriterion" />
                    <s:hidden name="experiments.sortDirection" />
                    <s:hidden name="experiments.sortCriterion" />

                    <s:radio name="searchParameters.searchType" key="protexpress.page.search.searchfor" list="@gov.nih.nci.protexpress.service.SearchType@values()" listValue="displayName" ></s:radio>
                    <s:textfield name="searchParameters.name" key="protexpress.page.search.name" size="40" />
                    <s:checkbox name="searchParameters.searchAllUsers" key="protexpress.page.search.searchallusers" fieldValue="true" />
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
