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

<h1><fmt:message key="protocols" /></h1>

<div class="box">
    <s:if test="protocol == null || protocol.id == null">
        <h2><fmt:message key="protocol.add" /></h2>
    </s:if>
    <s:else>
        <h2>${protocol.name}</h2>
    </s:else>

    <s:if test="protocol != null && protocol.id != null">
        <c:url value="/ajax/protocol/management/load/overview.action" var="overviewUrl">
            <c:param name="protocol.id" value="${protocol.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/protocol/management/load/inputOutput.action" var="inputOutputUrl">
            <c:param name="protocol.id" value="${protocol.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/protocol/management/load/contact.action" var="contactUrl">
            <c:param name="protocol.id" value="${protocol.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <c:url value="/ajax/protocol/management/load/parameters.action" var="parametersUrl">
            <c:param name="protocol.id" value="${protocol.id}" />
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>

        <fmt:message key="protocol.tabs.overview" var="overviewTitle" />
        <fmt:message key="protocol.tabs.inputOutput" var="inputOutputTitle" />
        <fmt:message key="protocol.tabs.contact" var="contactTitle" />
        <fmt:message key="protocol.tabs.parameters" var="parameterTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" postFunction="setSelectedTab" preFunction="showLoadingText"
            contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
            <ajax:tab caption="${inputOutputTitle}" baseUrl="${inputOutputUrl}" />
            <ajax:tab caption="${contactTitle}" baseUrl="${contactUrl}" />
            <ajax:tab caption="${parameterTitle}" baseUrl="${parametersUrl}" />
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url value="/protocol/management/load.action" var="addProtocolUrl">
            <c:param name="cancelResult" value="${cancelResult}"/>
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${addProtocolUrl}"><fmt:message key="protocol.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/protocol/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>