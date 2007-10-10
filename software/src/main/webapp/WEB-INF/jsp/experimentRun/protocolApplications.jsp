<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experimentRun.id != null && experimentRun.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="experimentRun.tabs.protocolApplications" submittingPaneMessageKey="deleting" ignoreSuccessMessage="true">
    <div class="addProtocolApp">
        <c:url var="createProtocolApplicationUrl" value="/protocolApplication/management/load.action">
            <c:param name="experimentRunId" value="${experimentRun.id}" />
        </c:url>
        <a href="${createProtocolApplicationUrl}" class="add"><fmt:message key="protocolApplication.add" /></a>
    </div>
    <c:if test="${not empty successMessage}">
        <div class="confirm_msg">${successMessage}</div>
    </c:if>

    <c:url value="/ajax/experimentRun/management/load/protocolApplications.action" var="sortUrl" />
    <c:url value="/experiment/management/load.action" var="cancelUrl">
        <c:param name="experiment.id" value="${experimentRun.experiment.id}" />
        <c:param name="initialTab" value="experimentRuns" />
    </c:url>
    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="searchresults">
        <display:table class="searchresults" cellspacing="0" defaultsort="3" excludedParams="ajax"
            requestURI="${sortUrl}" list="${experimentRun.protocolApplications}" pagesize="10" sort="list" id="row">
            <protExpress:displayTagProperties includeCancelButton="true" cancelButtonTabIndex="6" cancelButtonUrl="${cancelUrl}" />
            <display:column property="lsid" titleKey="protocolApplication.lsid" sortable="true" />
            <display:column property="name" titleKey="protocolApplication.name" sortable="true" />
            <display:column property="actionSequence" titleKey="protocolApplication.actionSequence" sortable="true" />
            <display:column sortProperty="activityDate" titleKey="protocolApplication.activityDate" sortable="true">
                <fmt:formatDate value="${row.activityDate.time}" pattern="M/d/yyyy" />
            </display:column>
            <display:column titleKey="actions" sortable="false">
                <c:if test="${row.auditInfo.creator == currentUser.loginName}">
                    <c:url var="loadUrl" value="/protocolApplication/management/load.action">
                        <c:param name="protocolApplication.id" value="${row.id}" />
                    </c:url>
                    <a href="${loadUrl}"><fmt:message key="edit" /></a>
                    <c:url var="deleteUrl" value="/ajax/protocolApplication/management/delete.action">
                        <c:param name="protocolApplication.id" value="${row.id}" />
                        <c:param name="experimentRun.id" value="${experimentRun.id}" />
                    </c:url>
                    <ajax:anchors target="selectedtabbox" ajaxFlag="false">
                        <a href="${deleteUrl}"><fmt:message key="delete" /></a>
                    </ajax:anchors>
                </c:if>
            </display:column>
        </display:table>
    </ajax:displayTag>
</protExpress:tabPane>