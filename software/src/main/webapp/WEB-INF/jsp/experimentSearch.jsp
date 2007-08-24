<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h2>Search Experiments</h2>

<s:form action="experiment/search/doSearch" method="post">
    <s:hidden name="experiments.sortDirection" />
    <s:hidden name="experiments.sortCriterion" />
    <s:textfield name="searchParameters.name" label="%{getText('label.experiment.name')}" size="40" />
    <s:textfield name="searchParameters.description" label="%{getText('label.experiment.description')}" size="40" />
    <s:submit value="%{getText('label.menu.experiment.search')}" />
    <s:submit value="%{getText('label.cancel')}" name="redirect-action:experiment/search/loadSearch" />
</s:form>

<c:if test="${experiments.list != null}">
    <c:url var="sortUrl" value="/experiment/search/doSearch.action" />

    <display:table list="${experiments}" requestURI="${sortUrl}" id="row">
        <display:setProperty name="pagination.sort.param" value="experiments.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="experiments.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="experiments.pageNumber" />
        <display:column property="name" titleKey="label.experiment.name" sortable="true" />
        <display:column property="description" titleKey="label.experiment.description" sortable="true" />
        <display:column property="url" titleKey="label.experiment.url" sortable="true" />

        <display:column titleKey="label.actions" sortable="false">
            <c:url var="loadUrl" value="/experiment/management/load.action">
                <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <a href="${loadUrl}"><s:text name="label.edit" /></a>
            <c:url var="deleteUrl" value="/experiment/management/delete.action">
                <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <a href="${deleteUrl}"><s:text name="label.delete" /></a>
        </display:column>
    </display:table>
</c:if>