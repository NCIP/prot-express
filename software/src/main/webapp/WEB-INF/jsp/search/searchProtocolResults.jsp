<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

    <h2><fmt:message key="protexpress.page.search.resultstitle" /></h2>
    <c:url var="sortUrl" value="/ajax/search/doSearch.action" />
    <c:url var="protocolSummaryUrl" value="/protocol/viewProtocolDetails.action" />

    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="newdata3">
        <display:table class="newdata3" cellspacing="0" list="${protocols}" requestURI="${sortUrl}" id="row">
            <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
            <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
            <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />
            <protExpress:displayTagProperties />

            <display:column property="name" titleKey="protexpress.page.search.protocolresults.column.protocolname" href="${protocolSummaryUrl}" paramId="protocol.id" paramProperty="id" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="description" titleKey="protexpress.page.search.protocolresults.column.description" sortable="true" maxLength="20" maxWords="4" />
            <display:column titleKey="protexpress.page.search.protocolresults.column.user">${row.auditInfo.creator}</display:column>
            <display:column titleKey="protexpress.page.search.protocolresults.column.dateandtime" >
                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${row.auditInfo.lastModifiedDate.time}" />
            </display:column>

            <display:column class="action" titleKey="protexpress.page.search.protocolresults.column.edit">
                <c:if test="${row.auditInfo.creator == currentUser.loginName}">
                    <c:url var="protocolEditUrl" value="/protocol/editProtocolDetails.action">
                        <c:param name="protocol.id" value="${row.id}" />
                    </c:url>
                    <a href="${protocolEditUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.search.protocolresults.icon.edit.alt" />" /></a>
                </c:if>
            </display:column>
        </display:table>
    </ajax:displayTag>
