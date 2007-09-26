<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<s:head theme="ajax" debug="true" />
<script type="text/javascript">
function setSelectedTab(currentLink) {
    tabMenuItems = document.getElementById('tabbed').getElementsByTagName('li');
    for(var i = 0; i < tabMenuItems.length; i++) {
        tabLink = tabMenuItems[i].getElementsByTagName('a')[0];
        if(tabLink.id == currentLink.id) {
            tabMenuItems[i].className = 'active';
        } else {
            tabMenuItems[i].className = '';
        }
    }
    currentLink.blur();
}
</script>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="experiments" /></h1>

<div class="box">
    <s:if test="experiment==null || experiment.id == null">
        <h2><fmt:message key="experiment.add" /></h2>
    </s:if>
    <s:else>
        <h2>${experiment.name}</h2>
    </s:else>

    <s:url action="ajax/experiment/management/load/overview" id="overviewUrl">
        <s:param name="experiment.id" value="${experiment.id}" />
    </s:url>
    <s:url action="ajax/experiment/management/load/experimentRuns" id="experimentRunsUrl">
        <s:param name="experiment.id" value="${experiment.id}" />
    </s:url>
    <s:url action="ajax/experiment/management/load/contact" id="contactUrl">
        <s:param name="experiment.id" value="${experiment.id}" />
    </s:url>
    <s:url action="ajax/experiment/management/load/export" id="exportUrl">
        <s:param name="experiment.id" value="${experiment.id}" />
    </s:url>

    <ul id="tabbed">
        <li class="active"><s:a href="%{overviewUrl}" id="overviewLink" targets="boxinner" theme="ajax" onclick="setSelectedTab(this)"><fmt:message key="experiment.tabs.overview"/></s:a></li>
        <li><s:a href="%{experimentRunsUrl}" id="expRunLink" targets="boxinner" theme="ajax" onclick="setSelectedTab(this)"><fmt:message key="experiment.tabs.experimentRuns"/></s:a></li>
        <li><s:a href="%{contactUrl}" id="contactLink" targets="boxinner" theme="ajax" onclick="setSelectedTab(this)"><fmt:message key="experiment.tabs.contact"/></s:a></li>
        <li><s:a href="%{exportUrl}" id="exportLink" targets="boxinner" theme="ajax" onclick="setSelectedTab(this)"><fmt:message key="experiment.tabs.export"/></s:a></li>
    </ul>
    <div class="selectedtabbox">
        <div id="boxinner">
            <%@ include file="/WEB-INF/jsp/experiment/overview.jsp"%>
        </div>
    </div>
</div>
</body>
</html>