<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>        
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:choose>
    <c:when test='${treeMode == "EDIT"}'>
        <s:url id="loadExperimentRunDetailsUrl" value="/ajax/editExperiment/experimentRun/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
        </s:url>
    </c:when>
    <c:otherwise>
        <s:url id="loadExperimentRunDetailsUrl" value="/ajax/viewExperiment/experimentRun/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
        </s:url>
    </c:otherwise>
</c:choose>
<protExpress:treeNode name="${experimentRun.name}" url="${loadExperimentRunDetailsUrl}" cssClass="experiment_run"/>
