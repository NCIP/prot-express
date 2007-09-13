<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
</head>
<body>

<s:url id="addExperiment" action="experiment/management/load" />
<fmt:message key="experiments" /> | <a href="${addExperiment}"><s:property value="%{getText('experiment.add')}" /></a>

<h2><fmt:message key="experiments.search" /></h2>

<s:form action="experiment/search/doSearch" method="post">
    <s:hidden name="experiments.sortDirection" />
    <s:hidden name="experiments.sortCriterion" />
    <s:textfield name="searchParameters.name" label="%{getText('experiment.name')}" size="40" />
    <s:textfield name="searchParameters.comments" label="%{getText('experiment.comments')}" size="40" />
    <s:submit value="%{getText('search')}" />
    <s:submit value="%{getText('cancel')}" name="redirect-action:experiment/search/loadSearch" />
</s:form>

<c:if test="${experiments.list != null}">
    <c:url var="sortUrl" value="/experiment/search/doSearch.action" />

    <display:table list="${experiments}" requestURI="${sortUrl}" id="row">
        <display:setProperty name="pagination.sort.param" value="experiments.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="experiments.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="experiments.pageNumber" />
        <display:column property="name" titleKey="experiment.name" sortable="true" />
        <display:column property="comments" titleKey="experiment.comments" sortable="true" />
        <display:column property="url" titleKey="experiment.url" sortable="true" />

        <display:column titleKey="actions" sortable="false">
            <c:url var="loadUrl" value="/experiment/management/load.action">
                <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <a href="${loadUrl}"><s:text name="edit" /></a>
            <c:url var="deleteUrl" value="/experiment/management/delete.action">
                <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <a href="${deleteUrl}"><s:text name="delete" /></a>
        </display:column>
    </display:table>
</c:if>

</body>
</html>