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
    <s:if test="protocolAction == null || protocolAction.id == null">
        <fmt:message key="protocolAction.add" />
    </s:if>
    <s:else>
        <fmt:message key="protocolAction.edit" />: ${protocolAction.experiment.name}
    </s:else>
</h1>

<div class="box">
    <s:if test="protocolAction != null && protocolAction.id != null">
        <c:url value="/ajax/protocolAction/management/load/overview.action" var="overviewUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="protocolAction.id" value="${protocolAction.id}" />
        </c:url>

        <fmt:message key="protocolAction.tabs.overview" var="overviewTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox" postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createProtocolActionUrl" value="/protocolAction/management/load.action">
            <c:param name="experimentId" value="${experimentId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createProtocolActionUrl}"><fmt:message key="protocolAction.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/protocolAction/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>