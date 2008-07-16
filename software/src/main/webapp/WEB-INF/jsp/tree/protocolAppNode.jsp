<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>        
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:choose>
    <c:when test='${treeMode == "EDIT"}'>
        <s:url id="loadProtocolApplicationDetailsUrl" value="/ajax/editExperiment/protocolApplication/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
        </s:url>
    </c:when>
    <c:otherwise>
        <s:url id="loadProtocolApplicationDetailsUrl" value="/ajax/viewExperiment/protocolApplication/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
        </s:url>
    </c:otherwise>
</c:choose>
<protExpress:treeNode name="${protApp.protocol.name}" url="${loadProtocolApplicationDetailsUrl}" cssClass="protocol"/>
