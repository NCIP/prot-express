<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<s:url id="addProtocol" action="protocol/management/load" />
<a href="${addProtocol}"><s:property value="%{getText('label.menu.protocol.add')}" /></a>

<h2>Search Protcols</h2>

<s:form action="protocol/search/doSearch" method="post">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <s:textfield name="searchParameters.name" label="%{getText('label.protocol.name')}" size="40" />
    <s:textfield name="searchParameters.description" label="%{getText('label.protocol.description')}" size="40" />
    <s:select name="searchParameters.types" label="%{getText('label.protocol.type')}"
        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey=""
        multiple="true" />
    <s:submit value="%{getText('label.menu.protocol.search')}" />
    <s:submit value="%{getText('label.cancel')}" name="redirect-action:protocol/search/loadSearch" />
</s:form>

<c:if test="${protocols.list != null}">
    <c:url var="sortUrl" value="/protocol/search/doSearch.action" />

    <display:table list="${protocols}" requestURI="${sortUrl}" id="row">
        <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />
        <display:column property="name" titleKey="label.protocol.name" sortable="true" />
        <display:column property="description" titleKey="label.protocol.description" sortable="true" />
        <display:column property="type.displayName" titleKey="label.protocol.type" sortable="true" sortProperty="type" />

        <display:column titleKey="label.actions" sortable="false">
            <c:url var="loadUrl" value="/protocol/management/load.action">
                <c:param name="protocol.id" value="${row.id}" />
            </c:url>
            <a href="${loadUrl}"><s:text name="label.edit" /></a>
            <c:url var="deleteUrl" value="/protocol/management/delete.action">
                <c:param name="protocol.id" value="${row.id}" />
            </c:url>
            <a href="${deleteUrl}"><s:text name="label.delete" /></a>
        </display:column>
    </display:table>
</c:if>