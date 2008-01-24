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
    <s:if test="input == null || input.id == null">
        <fmt:message key="protocolApplicationOutput.add" />
    </s:if>
    <s:else>
        <fmt:message key="protocolApplicationOutput.edit" />: ${output.name}
    </s:else>
</h1>
<div class="box">
    <s:if test="output != null && output.id != null">
        <c:url value="/ajax/protocolApplicationOutput/management/load/overview.action" var="overviewUrl">
            <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
            <c:param name="outputId" value="${output.id}" />
        </c:url>
        <fmt:message key="protocolApplicationOutput.tabs.overview" var="overviewTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox" postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createProtocolApplicationOutputUrl" value="/protocolApplicationOutput/management/load.action">
            <c:param name="protocolApplicationId" value="${protocolApplicationId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createProtocolApplicationOutputUrl}"><fmt:message key="protocolApplicationOutput.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/protocolApplicationOutput/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>