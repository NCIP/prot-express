<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:choose>
   <c:when test='${treeMode == "EDIT"}'>
       <c:url var="loadExperimentDetailsUrl" value="/ajax/editExperiment/experiment/load.action">
          <c:param name="experimentId" value="${experiment.id}"></c:param>
       </c:url>
   </c:when>
   <c:otherwise>
       <c:url var="loadExperimentDetailsUrl" value="/ajax/viewExperiment/experiment/load.action">
           <c:param name="experimentId" value="${experiment.id}"></c:param>
       </c:url>
   </c:otherwise>
</c:choose>
<protExpress:treeNode name="${experiment.name}" url="${loadExperimentDetailsUrl}" cssClass="experiment"/>
