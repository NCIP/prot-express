<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:choose>
    <c:when test='${treeMode == "EDIT"}'>
        <c:url var="loadExperimentRunDetailsUrl" value="/ajax/editExperiment/experimentRun/load.action">
            <c:param name="experimentId" value="${experiment.id}"/>
            <c:param name="experimentRunId" value="${experimentRun.id}"/>
        </c:url>
    </c:when>
    <c:otherwise>
        <c:url var="loadExperimentRunDetailsUrl" value="/ajax/viewExperiment/experimentRun/load.action">
            <c:param name="experimentId" value="${experiment.id}"/>
            <c:param name="experimentRunId" value="${experimentRun.id}"/>
        </c:url>
    </c:otherwise>
</c:choose>
<protExpress:treeNode name="${experimentRun.name}" url="${loadExperimentRunDetailsUrl}" cssClass="experiment_run"/>
