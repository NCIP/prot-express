<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<div class="searchresults">
    <h2><fmt:message key="protexpress.page.search.resultstitle" /></h2>
    <c:url var="sortUrl" value="/search/doSearch.action" />
    <ajax:displayTag id="displayTagFrame" >
        <display:table class="newdata3" cellspacing="0" list="${experiments}" requestURI="${sortUrl}" id="row">
            <display:setProperty name="pagination.sort.param" value="experiments.sortCriterion" />
            <display:setProperty name="pagination.sortdirection.param" value="experiments.sortDirection" />
            <display:setProperty name="pagination.pagenumber.param" value="experiments.pageNumber" />

            <c:set var="isEditable" value="${row.auditInfo.creator == currentUser.loginName}" />

            <protExpress:displayTagProperties />
            <c:url var="experimentSummaryUrl" value="/notYetImplemented.html">
              <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <c:url var="experimentEditUrl" value="/notYetImplemented.html">
              <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <c:url var="experimentDownloadUrl" value="/notYetImplemented.html">
              <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <c:set var="emailUrl" value="mailto:${row.auditInfo.creator}" />

            <display:column property="name" titleKey="protexpress.page.search.experimentresults.column.experimentname" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="comments" titleKey="protexpress.page.search.experimentresults.column.comments" sortable="true" maxLength="20" maxWords="4" />
            <display:column titleKey="protexpress.page.search.experimentresults.column.user">
                <a href="${emailUrl}">${row.auditInfo.creator}<img src="<c:url value="/images/outlook.png" />"  alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.email.alt" />" /></a>
            </display:column>
            <display:column titleKey="protexpress.page.search.experimentresults.column.dateandtime" >
                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${row.auditInfo.lastModifiedDate.time}" />
            </display:column>

            <display:column class="action" titleKey="protexpress.page.search.experimentresults.column.status">
                <span title="Incomplete">
                    <img src="<c:url value="/images/ico_asterisk.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.incomplete.alt" />" />
                </span>
                <span title="Complete">
                    <img src="<c:url value="/images/ico_check.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.complete.alt" />" />
                </span>
            </display:column>
            <display:column class="action" titleKey="protexpress.page.search.experimentresults.column.edit">
                <c:if test="${isEditable}">
                    <a href="${experimentEditUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.edit.alt" />" /></a>
                </c:if>
            </display:column>
            <display:column class="action" titleKey="protexpress.page.search.experimentresults.column.download">
                <a href="${experimentDownloadUrl}"><img src="<c:url value="/images/ico_xar.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.edit.alt" />" /></a>
            </display:column>
        </display:table>
    </ajax:displayTag>
</div>