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
<h1><fmt:message key="experiment.inputOutputObjects"><fmt:param value="${inputOutputObject.experiment.name}" /></fmt:message></h1>
<div class="box">
    <s:if test="inputOutputObject == null || inputOutputObject.id == null">
        <h2><fmt:message key="inputOutputObject.add" /></h2>
    </s:if>
    <s:else>
       <h2><fmt:message key="inputOutputObject.edit" /></h2>
    </s:else>

    <s:if test="inputOutputObject != null && inputOutputObject.id != null">
        <c:url value="/ajax/ioObject/management/load/overview.action" var="overviewUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="protocolApplication.id" value="${protocolApplication.id}" />
            <c:param name="inputOutputObject.id" value="${inputOutputObject.id}" />
        </c:url>
        <fmt:message key="inputOutputObject.tabs.overview" var="overviewTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox" postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createIOObjectUrl" value="/ioObject/management/load.action">
            <c:param name="experimentId" value="${experimentId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createIOObjectUrl}"><fmt:message key="inputOutputObject.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/ioObject/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>