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

<h1><fmt:message key="protocolApplications"><fmt:param value="${protocolApplication.experimentRun.name}" /></fmt:message></h1>

<div class="box">
    <s:if test="protocolApplication == null || protocolApplication.id == null">
        <h2><fmt:message key="protocolApplication.add" /></h2>
    </s:if>
    <s:else>
        <h2>${protocolApplication.name}</h2>
    </s:else>

    <s:if test="protocolApplication != null && protocolApplication.id != null">
        <c:url value="/ajax/protocolApplication/management/load/overview.action" var="overviewUrl">
            <c:param name="protocolApplication.id" value="${protocolApplication.id}" />
        </c:url>
        <c:url value="/ajax/protocolApplication/management/load/parameters.action" var="parametersUrl">
            <c:param name="protocolApplication.id" value="${protocolApplication.id}" />
        </c:url>

        <fmt:message key="protocolApplication.tabs.overview" var="overviewTitle" />
        <fmt:message key="protocolApplication.tabs.parameters" var="parametersTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox"
                postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
            <ajax:tab caption="${parametersTitle}" baseUrl="${parametersUrl}" />
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createProtocolApplicationUrl" value="/protocolApplication/management/load.action">
            <c:param name="experimentRunId" value="${experimentRunId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createProtocolApplicationUrl}"><fmt:message key="protocolApplication.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/protocolApplication/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>