<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<html>
<head>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="experiments.search" /> | <a href="<c:url value="/experiment/management/load.action" />" class="add"><fmt:message key="experiment.add" /></a></h1>

<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

    <div class="box">
        <div class="formbox">
        <s:form action="experiment/search/doSearch" method="post">
            <div id="boxinner">
                <h3><fmt:message key="search.criteria" /></h3>
                <s:hidden name="experiments.sortDirection" />
                <s:hidden name="experiments.sortCriterion" />
                <s:textfield name="searchParameters.name" key="experiment.name" size="40" tabindex="1" />
                <s:textfield name="searchParameters.comments" key="experiment.comments" size="40" tabindex="2" />
                <s:submit value="%{getText('search')}" tabindex="3" />
            </div>
        </s:form>
        <c:if test="${experiments.list != null}">
            <div id="boxinner">
                <h3><fmt:message key="search.results" /></h3>
                <jsp:include page="/WEB-INF/jsp/experiment/experimentSearchResults.jsp" />
            </div>
        </c:if>
        </div>
    </div>
</body>
</html>