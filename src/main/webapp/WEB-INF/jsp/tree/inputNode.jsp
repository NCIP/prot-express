<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:choose>
    <c:when test='${treeMode == "EDIT"}'>
        <s:url id="loadInputDetailsUrl" value="/ajax/editExperiment/input/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
            <s:param name="inputOutputObjectId" value="#input.id"></s:param>
        </s:url>
    </c:when>
    <c:otherwise>
        <s:url id="loadInputDetailsUrl" value="/ajax/viewExperiment/input/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
            <s:param name="inputOutputObjectId" value="#input.id"></s:param>
        </s:url>
    </c:otherwise>
</c:choose>
<protExpress:treeNode name="${input.name}" url="${loadInputDetailsUrl}" cssClass="input" />
