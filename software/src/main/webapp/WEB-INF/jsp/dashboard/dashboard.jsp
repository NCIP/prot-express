<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<body>
<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1>
    <fmt:message key="dashboard.header">
        <fmt:param value="${currentUserDisplayName}" />
    </fmt:message>
</h1>


<div class="dashboardwrapper">
    <div class="floatbox">
        <h2><fmt:message key="protocols" /></h2>
        <div class="toolbar">
            <c:url value="/protocol/management/load.action" var="addProtocolUrl">
                <c:param name="cancelResult" value="dashboard"/>
            </c:url>
            <a href="<c:url value="/protocol/search/loadSearch.action" />" class="search"><fmt:message key="search" /></a>
            <a href="${addProtocolUrl}" class="add" style="border: 0"><fmt:message key="dashboard.protocols.add" /></a>
        </div>
        <table class="searchresults" cellspacing="0">
            <tr>
                <th colspan="3"><fmt:message key="dashboard.protocols.my" /></th>
            </tr>
            <tr>
            <s:if test="%{recentProtocols.size() == 0}">
                <tr>
                    <td><fmt:message key="dashboard.protocols.nonefound" /></td>
                </tr>
            </s:if>
            <s:else>
                <c:forEach items="${recentProtocols}" var="protocol">
                    <c:url var="loadUrl" value="/protocol/management/load.action">
                        <c:param name="protocol.id" value="${protocol.id}" />
                        <c:param name="cancelResult" value="dashboard"/>
                    </c:url>
                    <tr>
                        <td><a href="${loadUrl}">${protocol.name}</a></td>
                        <td><fmt:formatDate dateStyle="short" value="${protocol.auditInfo.lastModifiedDate.time}"/></td>
                        <td><a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="Edit" /></a></td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <div class="floatbox">
        <h2><fmt:message key="experiments" /></h2>
        <div class="toolbar">
            <c:url value="/experiment/management/load.action" var="addExperimentUrl">
                <c:param name="cancelResult" value="dashboard"/>
            </c:url>
            <a href="<c:url value="/experiment/search/loadSearch.action" />" class="search"><fmt:message key="search" /></a>
            <a href="${addExperimentUrl}" class="add" style="border: 0"><fmt:message key="dashboard.experiments.add" /></a>
            <a href="<c:url value="/notYetImplemented.html"/>" class="import" style="border: 0"><fmt:message key="dashboard.experiments.import" /></a>
        </div>
        <table class="searchresults" cellspacing="0">
            <tr>
                <th colspan="3"><fmt:message key="dashboard.experiments.my" /></th>
            </tr>
            <s:if test="%{recentExperiments.size() == 0}">
                <tr>
                    <td><fmt:message key="dashboard.experiments.nonefound" /></td>
                </tr>
            </s:if>
            <s:else>
                <c:forEach items="${recentExperiments}" var="experiment">
                    <c:url var="loadUrl" value="/experiment/management/load.action">
                        <c:param name="experiment.id" value="${experiment.id}" />
                        <c:param name="cancelResult" value="dashboard"/>
                    </c:url>
                    <tr>
                        <td><a href="${loadUrl}">${experiment.name}</a></td>
                        <td><fmt:formatDate dateStyle="short" value="${experiment.auditInfo.lastModifiedDate.time}"/></td>
                        <td><a href="${loadUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="Edit" /></a></td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
</div>
</body>
</html>