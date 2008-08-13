<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocolHeader.jsp" />
<head><s:head debug="false" theme="ajax" /></head>


<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.addoutputs.info" /></p></div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.addinputs" /></div>
    <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt=" " /></div>
    <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.addoutputs" /></div>
    <div class="clear"></div>
</div>

<div id="divContent">
    <%@ include file="/WEB-INF/jsp/experiment/create/outputs.jsp"%>
</div>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocolFooter.jsp" />