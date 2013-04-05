<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:choose>
    <c:when test='${treeMode == "EDIT"}'>
        <s:url id="loadOutputDetailsUrl" value="/ajax/editExperiment/output/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
            <s:param name="inputOutputObjectId" value="#output.id"></s:param>
        </s:url>
    </c:when>
    <c:otherwise>
        <s:url id="loadOutputDetailsUrl" value="/ajax/viewExperiment/output/load.action">
            <s:param name="experimentId" value="experiment.id"></s:param>
            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
            <s:param name="inputOutputObjectId" value="#output.id"></s:param>
        </s:url>
    </c:otherwise>
</c:choose>
<protExpress:treeNode name="${output.name}" url="${loadOutputDetailsUrl}" cssClass="output"/>
