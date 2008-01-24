<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<html>
<head>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1>
    <s:if test="experimentRun == null || experimentRun.id == null">
        <fmt:message key="experimentRun.add" />
    </s:if>
    <s:else>
        <fmt:message key="experimentRun.edit" />: ${experimentRun.name}
    </s:else>
</h1>

<div class="box">
    <s:if test="experimentRun != null && experimentRun.id != null">
        <c:url value="/ajax/experimentRun/management/load/overview.action" var="overviewUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="experimentRun.id" value="${experimentRun.id}" />
        </c:url>
        <c:url value="/ajax/experimentRun/management/load/protocolApplications.action" var="protocolApplicationsUrl">
            <c:param name="experimentRun.id" value="${experimentRun.id}" />
        </c:url>

        <fmt:message key="experimentRun.tabs.overview" var="overviewTitle" />
        <fmt:message key="experimentRun.tabs.protocolApplications" var="protocolApplicationTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox"
                postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="${param.initialTab == null || param.initialTab == 'overview'}" />
            <ajax:tab caption="${protocolApplicationTitle}" baseUrl="${protocolApplicationsUrl}" defaultTab="${param.initialTab == 'protocolApplications'}" />
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createExpRunUrl" value="/experimentRun/management/load.action">
            <c:param name="experimentId" value="${experimentId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createExpRunUrl}"><fmt:message key="experimentRun.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/experimentRun/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>