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
<h1><fmt:message key="experiment.materialObjects"><fmt:param value="${materialObject.experiment.name}" /></fmt:message></h1>
<div class="box">
    <s:if test="materialObject == null || materialObject.id == null">
        <h2><fmt:message key="materialObject.add" /></h2>
    </s:if>
    <s:else>
       <h2><fmt:message key="materialObject.edit" /></h2>
    </s:else>

    <s:if test="materialObject != null && materialObject.id != null">
        <c:url value="/ajax/materialObject/management/load/overview.action" var="overviewUrl">
            <c:param name="experiment.id" value="${experiment.id}" />
            <c:param name="materialObject.id" value="${materialObject.id}" />
        </c:url>
        <fmt:message key="materialObject.tabs.overview" var="overviewTitle" />

        <ajax:tabPanel panelStyleId="tabbed" currentStyleClass="current" contentStyleId="selectedtabbox" contentStyleClass="selectedtabbox" postFunction="setSelectedTab">
            <ajax:tab caption="${overviewTitle}" baseUrl="${overviewUrl}" defaultTab="true"/>
        </ajax:tabPanel>
    </s:if>
    <s:else>
        <c:url var="createMaterialObjectUrl" value="/materialObject/management/load.action">
            <c:param name="experimentId" value="${experimentId}" />
        </c:url>
        <div id="tabbed">
            <ul>
                <li class="active"><a href="${createMaterialObjectUrl}"><fmt:message key="materialObject.tabs.overview" /></a></li>
            </ul>
        </div>
        <div id="selectedtabbox" class="selectedtabbox">
            <jsp:include page="/WEB-INF/jsp/materialObject/overview.jsp" />
        </div>
    </s:else>
</div>
</body>
</html>