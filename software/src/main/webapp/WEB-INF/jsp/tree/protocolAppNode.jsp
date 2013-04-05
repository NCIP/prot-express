<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:choose>
    <c:when test='${treeMode == "EDIT"}'>
        <c:url var="loadProtocolApplicationDetailsUrl" value="/ajax/editExperiment/protocolApplication/load.action">
            <c:param name="experimentId" value="${experiment.id}"/>
            <c:param name="experimentRunId" value="${experimentRun.id}"/>
            <c:param name="protocolApplicationId" value="${protApp.id}"/>
        </c:url>
    </c:when>
    <c:otherwise>
        <c:url var="loadProtocolApplicationDetailsUrl" value="/ajax/viewExperiment/protocolApplication/load.action">
            <c:param name="experimentId" value="${experiment.id}"/>
            <c:param name="experimentRunId" value="${experimentRun.id}"/>
            <c:param name="protocolApplicationId" value="${protApp.id}"/>
        </c:url>
    </c:otherwise>
</c:choose>
<protExpress:treeNode name="${protApp.protocol.name}" url="${loadProtocolApplicationDetailsUrl}" cssClass="protocol"/>
