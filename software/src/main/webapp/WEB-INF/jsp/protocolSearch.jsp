<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h2>Search Protcols</h2>

<s:form action="protocol/doSearch" method="post">
    <s:textfield name="searchName" label="%{getText('label.protocol.name')}" size="40" />
    <s:textfield name="searchDescription" label="%{getText('label.protocol.description')}" size="40" />
    <s:select name="searchProtocolTypes" label="%{getText('label.protocol.type')}"
        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey=""
        multiple="true" />
    <s:submit value="%{getText('label.menu.protocol.search')}" />
    <s:submit value="%{getText('label.cancel')}" name="redirect-action:protocol/loadSearch" />
</s:form>

<c:if test="${protocols != null}">
    <c:url var="sortUrl" value="/protocol/doSearch.action" />

    <display:table defaultsort="1" list="${protocols}" pagesize="10" requestURI="${sortUrl}" id="row" sort="list">
        <display:setProperty name="paging.banner.placement" value="bottom" />
        <display:column property="name" titleKey="label.protocol.name" sortable="true" />
        <display:column property="description" titleKey="label.protocol.description" sortable="true" />
        <display:column property="type.displayName" titleKey="label.protocol.type" sortable="true" />

        <display:column titleKey="label.actions" sortable="false">
            <c:url var="loadUrl" value="/protocol/load.action">
                <c:param name="protocol.id" value="${row.id}" />
            </c:url>
            <a href="${loadUrl}"><s:text name="label.edit" /></a>
            <c:url var="deleteUrl" value="/protocol/delete.action">
                <c:param name="protocol.id" value="${row.id}" />
            </c:url>
            <a href="${deleteUrl}"><s:text name="label.delete" /></a>
        </display:column>
    </display:table>
</c:if>