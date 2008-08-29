<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>


    <h2><fmt:message key="protexpress.page.search.resultstitle" /></h2>
    <c:url var="sortUrl" value="/ajax/search/doSearch.action" />

    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="newdata3">
        <display:table class="newdata3" cellspacing="0" list="${experiments}" requestURI="${sortUrl}" id="row" >
            <display:setProperty name="pagination.sort.param" value="experiments.sortCriterion" />
            <display:setProperty name="pagination.sortdirection.param" value="experiments.sortDirection" />
            <display:setProperty name="pagination.pagenumber.param" value="experiments.pageNumber" />
            <protExpress:displayTagProperties />
            <c:url var="viewExperimentDetailsUrl" value="/viewExperiment/experiment/load.action" />
            <display:column property="name" href="${viewExperimentDetailsUrl}" titleKey="protexpress.page.search.experimentresults.column.experimentname" paramId="experimentId" paramProperty="id" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="description" titleKey="protexpress.page.search.experimentresults.column.description" sortable="true" maxLength="20" maxWords="4" />
            <display:column titleKey="protexpress.page.search.experimentresults.column.user">${row.auditInfo.creator}</display:column>
            <display:column titleKey="protexpress.page.search.experimentresults.column.dateandtime" >
                <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${row.auditInfo.lastModifiedDate.time}" />
            </display:column>

            <display:column class="action" titleKey="protexpress.page.search.experimentresults.column.status">
                <c:choose>
                    <c:when test="${statusCompleted.booleanValue == Boolean.TRUE}">
                        <span title="Complete">
                            <img src="<c:url value="/images/ico_check.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.complete.alt" />" />
                        </span>
                    </c:when>
                    <c:otherwise>
                        <span title="Incomplete">
                            <img src="<c:url value="/images/ico_asterisk.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.incomplete.alt" />" />
                        </span>
                    </c:otherwise>
                </c:choose>
            </display:column>
            <display:column class="action" titleKey="protexpress.page.search.experimentresults.column.edit">
                <c:if test="${row.auditInfo.creator == currentUser.loginName}">
                    <c:url var="experimentEditUrl" value="/editExperiment/experiment/load.action">
                        <c:param name="experimentId" value="${row.id}" />
                    </c:url>
                    <a href="${experimentEditUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.search.experimentresults.icon.edit.alt" />" /></a>
                </c:if>
            </display:column>
            <display:column class="action" titleKey="protexpress.page.search.experimentresults.column.download">
                <c:url var="experimentDownloadUrl" value="/ajax/experiment/export.action">
                    <c:param name="experimentId" value="${row.id}" />
                </c:url>
                <c:if test="${statusCompleted == Boolean.TRUE}">
                    <a href="${experimentDownloadUrl}"><img src="<c:url value="/images/ico_xar.gif" />" alt="<fmt:message key="protexpress.page.search.experimentresults.icon.download.alt" />" /></a>
                </c:if>
            </display:column>
        </display:table>
    </ajax:displayTag>
