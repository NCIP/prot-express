<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
</head>
<body>

<fmt:message key="protocols" /> | <a href="<c:url value="/protocol/management/load.action" />"><fmt:message key="protocol.add" /></a>

<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

<h2><fmt:message key="protocols.search" /></h2>

<s:form action="protocol/search/doSearch" method="post">
    <s:hidden name="protocols.sortDirection" />
    <s:hidden name="protocols.sortCriterion" />
    <s:textfield name="searchParameters.name" key="protocol.name" size="40" />
    <s:textfield name="searchParameters.description" key="protocol.description" size="40" />
    <s:select name="searchParameters.types" key="protocol.type"
        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey=""
        multiple="true" />
    <s:submit value="%{getText('search')}" />
    <s:submit value="%{getText('cancel')}" name="redirect-action:protocol/search/loadSearch" />
</s:form>

<c:if test="${protocols.list != null}">
    <c:url var="sortUrl" value="/protocol/search/doSearch.action" />

    <c:url var="loadUrlBase" value="/protocol/management/load.action" />

    <display:table list="${protocols}" requestURI="${sortUrl}" id="row">
        <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />
        <display:column property="name" titleKey="protocol.name" sortable="true" href="${loadUrlBase}" paramId="protocol.id" paramProperty="id"/>
        <display:column property="description" titleKey="protocol.description" sortable="true" />
        <display:column property="type.displayName" titleKey="protocol.type" sortable="true" sortProperty="type" />

        <display:column titleKey="actions" sortable="false">
            <c:if test="${row.creator == currentUser.loginName}">
                <c:url var="loadUrl" value="/protocol/management/load.action">
                    <c:param name="protocol.id" value="${row.id}" />
                    <c:param name="cancelResult" value="search" />
                </c:url>
                <a href="${loadUrl}"><s:text name="edit" /></a>
                <c:url var="deleteUrl" value="/protocol/management/delete.action">
                    <c:param name="protocol.id" value="${row.id}" />
                </c:url>
                <a href="${deleteUrl}"><s:text name="delete" /></a>
            </c:if>
        </display:column>
    </display:table>
</c:if>

</body>
</html>