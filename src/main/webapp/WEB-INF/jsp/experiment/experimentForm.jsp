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

<h1><fmt:message key="experiments" /></h1>

<div class="box">
    <s:if test="experiment == null || experiment.id == null">
        <h2><fmt:message key="experiment.add" /></h2>
    </s:if>
    <s:else>
        <h2>${experiment.name}</h2>
    </s:else>

    <s:if test="experiment != null && experiment.id != null">
        <c:url value="/ajax/experiment/management/load/overview.action" var="overviewUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/experiment/management/load/protocolActions.action" var="protocolActionsUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/experiment/management/load/experimentInputs.action" var="experimentInputsUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/experiment/management/load/experimentRuns.action" var="experimentRunsUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/experiment/management/load/export.action" var="exportUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>

        <fmt:message key="experiment.tabs.overview" var="overviewTitle" />
        <fmt:message key="experiment.tabs.protocolActions" var="protocolActionsTitle" />
        <fmt:message key="experiment.tabs.experimentInputs" var="experimentInputsTitle" />
        <fmt:message key="experiment.tabs.experimentRuns" var="experimentRunsTitle" />
        <fmt:message key="experiment.tabs.export" var="exportTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox"
                postFunction="setSelectedTab" preFunction="showLoadingText">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="${param.initialTab == null || param.initialTab == 'overview'}" />
            <ajax:tab caption="${protocolActionsTitle}" baseUrl="${protocolActionsUrl}" defaultTab="${param.initialTab == 'protocolActions'}" />
            <ajax:tab caption="${experimentInputsTitle}" baseUrl="${experimentInputsUrl}" defaultTab="${param.initialTab == 'experimentInputs'}" />
            <ajax:tab caption="${experimentRunsTitle}" baseUrl="${experimentRunsUrl}" defaultTab="${param.initialTab == 'experimentRuns'}" />
            <ajax:tab caption="${exportTitle}" baseUrl="${exportUrl}" defaultTab="${param.initialTab == 'export'}" />
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url value="/experiment/management/load.action" var="addExperimentUrl">
            <c:param name="cancelResult" value="${cancelResult}"/>
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${addExperimentUrl}"><fmt:message key="experiment.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/experiment/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>