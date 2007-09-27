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
    <s:if test="protocol ==null || protocol.id == null">
        <h2><fmt:message key="protocol.add" /></h2>
    </s:if>
    <s:else>
        <h2>${protocol.name}</h2>
    </s:else>

    <s:url action="ajax/protocol/management/load/overview" id="overviewUrl">
        <s:param name="protocol.id" value="${protocol.id}" />
    </s:url>
    <s:url action="ajax/protocol/management/load/contact" id="contactUrl">
        <s:param name="protocol.id" value="${protocol.id}" />
    </s:url>

    <protExpress:tabbedPanel initialFile="/WEB-INF/jsp/protocol/overview.jsp">
        <protExpress:tab tabHeaderKey="protocol.tabs.overview" tabUrl="${overviewUrl}" id="overviewLink" isActive="true" />
        <protExpress:tab tabHeaderKey="protocol.tabs.contact" tabUrl="${contactUrl}" id="contactLink" />
    </protExpress:tabbedPanel>
</div>
</body>
</html>