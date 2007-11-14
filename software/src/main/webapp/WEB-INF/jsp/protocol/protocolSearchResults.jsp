<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<c:url var="sortUrl" value="/ajax/protocol/search/doSearch.action" />
<c:url var="loadUrlBase" value="/protocol/management/load.action" />
<c:url var="cancelUrl" value="/protocol/search/loadSearch.action" />
<ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="searchresults">
    <display:table class="searchresults" cellspacing="0" list="${protocols}" requestURI="${sortUrl}" id="row">
        <protExpress:displayTagProperties includeCancelButton="true" cancelButtonTabIndex="5" cancelButtonUrl="${cancelUrl}" />
        <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />
        <display:column property="name" titleKey="protocol.name" sortable="true" href="${loadUrlBase}" paramId="protocol.id" paramProperty="id" />
        <display:column property="description" titleKey="protocol.description" sortable="true" />
        <display:column property="type.displayName" titleKey="protocol.type" sortable="true" sortProperty="type" />

        <display:column titleKey="actions" sortable="false" >
            <c:if test="${row.auditInfo.creator == currentUser.loginName}">
                <c:url var="loadUrl" value="/protocol/management/load.action">
                    <c:param name="protocol.id" value="${row.id}" />
                </c:url>
                <a href="${loadUrl}"><fmt:message key="edit" /></a>
                <c:url var="deleteUrl" value="/protocol/management/delete.action">
                    <c:param name="protocol.id" value="${row.id}" />
                </c:url>
                <a href="${deleteUrl}"><fmt:message key="delete" /></a>
            </c:if>
        </display:column>
    </display:table>
</ajax:displayTag>