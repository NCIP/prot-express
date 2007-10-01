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

<h1><fmt:message key="protocols" /></h1>

<div class="box">
    <s:if test="protocol == null || protocol.id == null">
        <h2><fmt:message key="protocol.add" /></h2>
    </s:if>
    <s:else>
        <h2>${protocol.name}</h2>
    </s:else>

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

    <protExpress:tabbedPanel initialFile="/WEB-INF/jsp/protocol/overview.jsp">
        <protExpress:tab tabHeaderKey="protocol.tabs.overview" tabUrl="${overviewUrl}" id="overviewLink" isActive="true" />
        <s:if test="protocol != null && protocol.id != null">
            <protExpress:tab tabHeaderKey="protocol.tabs.inputOutput" tabUrl="${inputOutputUrl}" id="inputOutputLink" />
            <protExpress:tab tabHeaderKey="protocol.tabs.contact" tabUrl="${contactUrl}" id="contactLink" />
        </s:if>
    </protExpress:tabbedPanel>
</div>
</body>
</html>