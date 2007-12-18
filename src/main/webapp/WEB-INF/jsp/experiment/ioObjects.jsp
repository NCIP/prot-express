<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experiment.id != null && experiment.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="experiment.tabs.inputOutputObjects" submittingPaneMessageKey="deleting" ignoreSuccessMessage="true">
    <div class="addNewLink">
        <c:url var="createInputOutputObjectUrl" value="/ioObject/management/load.action">
            <c:param name="experimentId" value="${experiment.id}" />
        </c:url>
        <a href="${createInputOutputObjectUrl}" class="add"><fmt:message key="inputOutputObject.add" /></a>
    </div>
    <c:if test="${not empty successMessage}">
        <div class="confirm_msg">${successMessage}</div>
    </c:if>

    <c:url value="/ajax/experiment/management/load/ioObject.action" var="sortUrl" />
    <c:url value="/experiment/management/cancel.action" var="cancelUrl">
        <c:param name="cancelResult" value="${cancelResult}" />
    </c:url>
    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="searchresults">
        <display:table class="searchresults" cellspacing="0" defaultsort="2" excludedParams="ajax"
            requestURI="${sortUrl}" list="${experiment.inputOutputObjects}" pagesize="10" sort="list" id="row">
            <protExpress:displayTagProperties includeCancelButton="true" cancelButtonTabIndex="6" cancelButtonUrl="${cancelUrl}" />
            <display:column property="name" titleKey="inputOutputObject.name" sortable="true" />
            <display:column property="cpasType.displayName" titleKey="inputOutputObject.cpasType" sortable="false" />
            <display:column property="dataFileURL" titleKey="inputOutputObject.dataFileUrl" sortable="false" />
            <display:column titleKey="actions" sortable="false">
                <c:url var="loadUrl" value="/ioObject/management/load.action">
                    <c:param name="inputOutputObject.id" value="${row.id}" />
                </c:url>
                <c:if test="${isReadOnly}">
                    <a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="icon.view.alt" />" /> <fmt:message key="view" /></a>
                </c:if>
                <c:if test="${!isReadOnly}">
                    <a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="icon.edit.alt" />" /> <fmt:message key="edit" /></a>
                    <c:url var="deleteUrl" value="/ajax/ioObject/management/delete.action">
                        <c:param name="inputOutputObject.id" value="${row.id}" />
                        <c:param name="experiment.id" value="${experiment.id}" />
                    </c:url>
                    <ajax:anchors target="selectedtabbox" ajaxFlag="false">
                        <a href="${deleteUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="icon.delete.alt" />" /> <fmt:message key="delete" /></a>
                    </ajax:anchors>
                  </c:if>
              </display:column>
        </display:table>
    </ajax:displayTag>
</protExpress:tabPane>