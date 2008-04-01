<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.addprotocols.info" /></p></div>
<h3>${experiment.name}</h3>

<s:if test="experiment != null && experiment.experimentRuns != null">
    <div id="protocolflow">
        <c:forEach items="${experiment.experimentRuns}" var="expRun">
            <c:forEach items="${expRun.protocolApplications}" var="protApp">
                <a href="<c:url value="/notYetImplemented.html" />">${protApp.protocol.name}</a>&nbsp;|&nbsp;
            </c:forEach>
        </c:forEach>
    </div>
</s:if>

<div class="tabs">
    <a href="<c:url value="/createExperiment/manageProtocols/addNewProtocol.action" />" class="selected"><span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.addnewprotocol" /></span></a>
    <a href="<c:url value="/notYetImplemented.html" />"><span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.selectexistingprotocol" /></span></a>
</div>