<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<c:url var="sortUrl" value="/ajax/experiment/search/doSearch.action" />
<c:url var="loadUrlBase" value="/experiment/management/load.action" />
<c:url var="cancelUrl" value="/experiment/search/loadSearch.action" />
<ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="searchresults">
    <display:table class="searchresults" cellspacing="0" list="${experiments}" requestURI="${sortUrl}" id="row">
        <protExpress:displayTagProperties includeCancelButton="true" cancelButtonTabIndex="4" cancelButtonUrl="${cancelUrl}" />
        <display:setProperty name="pagination.sort.param" value="experiments.sortCriterion" />
        <display:setProperty name="pagination.sortdirection.param" value="experiments.sortDirection" />
        <display:setProperty name="pagination.pagenumber.param" value="experiments.pageNumber" />
        <display:column property="name" titleKey="experiment.name" sortable="true" maxLength="20" maxWords="4"/>
        <display:column property="comments" titleKey="experiment.comments" sortable="true"  maxLength="20" maxWords="4"/>
        <display:column property="url" titleKey="experiment.url" sortable="true"  maxLength="20" maxWords="4"/>
        <display:column property="auditInfo.creator" titleKey="experiment.auditInfo.creator" sortable="true"  maxLength="20" maxWords="4"/>
        <display:column sortProperty="auditInfo.creationDate" titleKey="experiment.auditInfo.creationDate" sortable="true">
            <fmt:formatDate value="${row.auditInfo.creationDate.time}" pattern="M/d/yyyy" />
        </display:column>

        <display:column titleKey="actions" sortable="false">
            <c:set var="isEditable" value="${row.auditInfo.creator == currentUser.loginName}" />
            <c:url var="loadUrl" value="/experiment/management/load.action">
                <c:param name="experiment.id" value="${row.id}" />
            </c:url>
            <c:if test="${!isEditable}">
                <a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="icon.view.alt" />" /> <fmt:message key="view" /></a>
            </c:if>
            <c:if test="${isEditable}">
                <a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="icon.edit.alt" />" /> <fmt:message key="edit" /></a>
                <c:url var="deleteUrl" value="/experiment/management/delete.action">
                    <c:param name="experiment.id" value="${row.id}" />
                </c:url>
                <a href="${deleteUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="icon.delete.alt" />" /> <fmt:message key="delete" /></a>
            </c:if>
        </display:column>
    </display:table>
</ajax:displayTag>




