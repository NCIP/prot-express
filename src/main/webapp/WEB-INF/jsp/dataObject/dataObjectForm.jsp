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
<h1><fmt:message key="experiment.dataObjects"><fmt:param value="${dataObject.experiment.name}" /></fmt:message></h1>
<div class="box">
    <s:if test="dataObject == null || dataObject.id == null">
        <h2><fmt:message key="dataObject.add" /></h2>
    </s:if>
    <s:else>
       <h2><fmt:message key="dataObject.edit" /></h2>
    </s:else>

    <s:if test="dataObject != null && dataObject.id != null">
        <c:url value="/ajax/dataObject/management/load/overview.action" var="overviewUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="dataObject.id" value="${dataObject.id}" />
        </c:url>
        <fmt:message key="dataObject.tabs.overview" var="overviewTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox" postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createDataObjectUrl" value="/dataObject/management/load.action">
            <c:param name="experimentId" value="${experimentId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createDataObjectUrl}"><fmt:message key="dataObject.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/dataObject/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>