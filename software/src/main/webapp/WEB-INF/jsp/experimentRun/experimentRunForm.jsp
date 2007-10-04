<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<html>
<head>
<s:head theme="ajax" debug="true" />
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="experimentRuns"><fmt:param value="${experimentRun.experiment.name}" /></fmt:message></h1>

<div class="box">
    <s:if test="experimentRun == null || experimentRun.id == null">
        <h2><fmt:message key="experimentRun.add" /></h2>
    </s:if>
    <s:else>
        <h2>${experimentRun.name}</h2>
    </s:else>

    <c:url value="/ajax/experimentRun/management/load/overview.action" var="overviewUrl">
        <c:param name="experiment.id" value="${experiment.id}" />
        <c:param name="experimentRun.id" value="${experimentRun.id}" />
    </c:url>
    <c:url value="/ajax/experimentRun/management/load/protocolApplications.action" var="protocolApplicationsUrl">
        <c:param name="experimentRun.id" value="${experimentRun.id}" />
    </c:url>

    <protExpress:tabbedPanel initialFile="/WEB-INF/jsp/experimentRun/overview.jsp">
        <protExpress:tab tabHeaderKey="experimentRun.tabs.overview" tabUrl="${overviewUrl}" id="overviewLink" isActive="true" />
        <s:if test="experimentRun != null && experimentRun.id != null">
            <protExpress:tab tabHeaderKey="experimentRun.tabs.protocolApplications" tabUrl="${protocolApplicationsUrl}" id="protocolApplicationsLink" />
        </s:if>
    </protExpress:tabbedPanel>
</div>
</body>
</html>