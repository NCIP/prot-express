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

<h1><fmt:message key="experiments" /></h1>

<div class="box">
    <s:if test="experiment == null || experiment.id == null">
        <h2><fmt:message key="experiment.add" /></h2>
    </s:if>
    <s:else>
        <h2>${experiment.name}</h2>
    </s:else>

    <c:url value="/ajax/experiment/management/load/overview.action" var="overviewUrl">
        <c:param name="experiment.id" value="${experiment.id}" />
        <c:param name="cancelResult" value="${cancelResult}" />
    </c:url>
    <c:url value="/ajax/experiment/management/load/experimentRuns.action" var="experimentRunsUrl">
        <c:param name="experiment.id" value="${experiment.id}" />
        <c:param name="cancelResult" value="${cancelResult}" />
    </c:url>
    <c:url value="/ajax/experiment/management/load/contact.action" var="contactUrl">
        <c:param name="experiment.id" value="${experiment.id}" />
        <c:param name="cancelResult" value="${cancelResult}" />
    </c:url>
    <c:url value="/ajax/experiment/management/load/export.action" var="exportUrl">
        <c:param name="experiment.id" value="${experiment.id}" />
        <c:param name="cancelResult" value="${cancelResult}" />
    </c:url>

    <protExpress:tabbedPanel initialFile="/WEB-INF/jsp/experiment/overview.jsp">
        <protExpress:tab tabHeaderKey="experiment.tabs.overview" tabUrl="${overviewUrl}" id="overviewLink" isActive="true" />
        <s:if test="experiment != null && experiment.id != null">
            <protExpress:tab tabHeaderKey="experiment.tabs.experimentRuns" tabUrl="${experimentRunsUrl}" id="expRunLink" />
            <protExpress:tab tabHeaderKey="experiment.tabs.contact" tabUrl="${contactUrl}" id="contactLink" />
            <protExpress:tab tabHeaderKey="experiment.tabs.export" tabUrl="${exportUrl}" id="exportLink" />
        </s:if>
    </protExpress:tabbedPanel>
</div>
</body>
</html>