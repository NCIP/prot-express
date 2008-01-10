<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${protocolApplication.id != null && protocolApplication.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="protocolApplication.tabs.outputs" submittingPaneMessageKey="deleting" ignoreSuccessMessage="true">
    <div class="addNewLink">
        <c:url var="createOutputObjectUrl" value="/protocolApplicationOutput/management/load.action">
            <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
        </c:url>
        <a href="${createOutputObjectUrl}" class="add"><fmt:message key="protocolApplicationOutput.add" /></a>
    </div>
    <c:if test="${not empty successMessage}">
        <div class="confirm_msg">${successMessage}</div>
    </c:if>

    <c:url value="/ajax/protocolApplication/management/load/outputs.action" var="sortUrl" />
    <c:url value="/experimentRun/management/load.action" var="cancelUrl">
            <c:param name="experimentRun.id" value="${protocolApplication.experimentRun.id}" />
            <c:param name="initialTab" value="protocolApplications" />
        </c:url>
    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="searchresults">
        <display:table class="searchresults" cellspacing="0" defaultsort="2" excludedParams="ajax"
            requestURI="${sortUrl}" list="${protocolApplication.outputs}" pagesize="10" sort="list" id="row">
            <protExpress:displayTagProperties includeCancelButton="true" cancelButtonTabIndex="6" cancelButtonUrl="${cancelUrl}" />
            <display:column property="name" titleKey="protocolApplicationOutput.name" sortable="true" />
            <display:column property="dataFileURL" titleKey="protocolApplicationOutput.dataFileUrl" sortable="false" />
            <display:column titleKey="actions" sortable="false">
                <c:url var="loadUrl" value="/protocolApplicationOutput/management/load.action">
                    <c:param name="outputId" value="${row.id}" />
                    <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
                </c:url>
                <c:if test="${isReadOnly}">
                    <a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="icon.view.alt" />" /> <fmt:message key="view" /></a>
                </c:if>
                <c:if test="${!isReadOnly}">
                    <a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="icon.edit.alt" />" /> <fmt:message key="edit" /></a>
                    <c:url var="deleteUrl" value="/ajax/protocolApplicationOutput/management/delete.action">
                        <c:param name="outputId" value="${row.id}" />
                        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
                    </c:url>
                    <ajax:anchors target="selectedtabbox" ajaxFlag="false">
                        <a href="${deleteUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="icon.delete.alt" />" /> <fmt:message key="delete" /></a>
                    </ajax:anchors>
                  </c:if>
              </display:column>
        </display:table>
    </ajax:displayTag>
</protExpress:tabPane>