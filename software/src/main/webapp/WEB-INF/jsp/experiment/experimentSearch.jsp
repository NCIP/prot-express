<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
</head>
<body>

<fmt:message key="experiments" /> | <a href="<c:url value="/experiment/management/load.action" />"><fmt:message key="experiment.add" /></a>

<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<h2><fmt:message key="experiments.search" /></h2>

<s:form action="experiment/search/doSearch" method="post">
    <s:hidden name="experiments.sortDirection" />
    <s:hidden name="experiments.sortCriterion" />
    <s:textfield name="searchParameters.name" key="experiment.name" size="40" />
    <s:textfield name="searchParameters.comments" key="experiment.comments" size="40" />
    <s:submit value="%{getText('search')}" />
    <s:submit value="%{getText('cancel')}" name="redirect-action:experiment/search/loadSearch" />
</s:form>

<c:if test="${experiments.list != null}">
    <c:url var="sortUrl" value="/experiment/search/doSearch.action" />
    <c:url var="loadUrlBase" value="/experiment/management/load.action" />
    <display:table list="${experiments}" requestURI="${sortUrl}" id="row">
        <display:setProperty name="pagination.sort.param" value="experiments.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="experiments.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="experiments.pageNumber" />
        <display:column property="name" titleKey="experiment.name" sortable="true" href="${loadUrlBase}" paramId="experiment.id" paramProperty="id" />
        <display:column property="comments" titleKey="experiment.comments" sortable="true" />
        <display:column property="url" titleKey="experiment.url" sortable="true" />

        <display:column titleKey="actions" sortable="false">
            <c:if test="${row.auditInfo.creator == currentUser.loginName}">
                <c:url var="loadUrl" value="/experiment/management/load.action">
                    <c:param name="experiment.id" value="${row.id}" />
                </c:url>
                <a href="${loadUrl}"><fmt:message key="edit" /></a>
                <c:url var="deleteUrl" value="/experiment/management/delete.action">
                    <c:param name="experiment.id" value="${row.id}" />
                </c:url>
                <a href="${deleteUrl}"><fmt:message key="delete" /></a>
            </c:if>
        </display:column>
    </display:table>
</c:if>

</body>
</html>