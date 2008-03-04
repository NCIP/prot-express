<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<div class="searchresults">
    <h2><fmt:message key="protexpress.page.search.resultstitle" /></h2>
    <c:url var="sortUrl" value="/search/doSearch.action" />
    <c:url var="protocolSummaryUrl" value="/protocol/viewSummary.action" />

    <ajax:displayTag id="displayTagFrame" >
        <display:table class="newdata3" cellspacing="0" list="${protocols}" requestURI="${sortUrl}" id="row">
            <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
            <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
            <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />

            <c:set var="emailUrl" value="mailto:test@test.com" />
            <protExpress:displayTagProperties />

            <display:column property="name" titleKey="protexpress.page.search.protocolresults.column.protocolname" href="${protocolSummaryUrl}" paramId="protocol.id" paramProperty="id" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="description" titleKey="protexpress.page.search.protocolresults.column.description" sortable="true" maxLength="20" maxWords="4" />
            <display:column titleKey="protexpress.page.search.protocolresults.column.user">
                <a href="${emailUrl}">${row.auditInfo.creator}</a>
            </display:column>
            <display:column titleKey="protexpress.page.search.protocolresults.column.dateandtime" >
                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${row.auditInfo.lastModifiedDate.time}" />
            </display:column>

            <display:column class="action" titleKey="protexpress.page.search.protocolresults.column.edit">
                <c:if test="${row.auditInfo.creator == currentUser.loginName}">
                    <c:url var="protocolEditUrl" value="/notYetImplemented.html">
                        <c:param name="protocol.id" value="${row.id}" />
                    </c:url>
                    <a href="${protocolEditUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.search.protocolresults.icon.edit.alt" />" /></a>
                </c:if>
            </display:column>
        </display:table>
    </ajax:displayTag>
</div>