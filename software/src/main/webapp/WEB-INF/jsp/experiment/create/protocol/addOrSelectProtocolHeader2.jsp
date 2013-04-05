<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="info">
    <p><fmt:message key="protexpress.page.createnewexperiment.addprotocols.info" /></p>
</div>
<h3>${experiment.name}</h3>
<s:if test="experiment != null && experiment.experimentRuns != null">
    <div id="protocolflow">
        <c:forEach items="${experiment.experimentRuns}" var="expRun">
            <c:forEach items="${expRun.protocolApplications}" var="protApp">
                <c:url var="experimentProtocolEditUrl" value="/ajax/createExperiment/protocols/manage/editProtocol.action">
                    <c:param name="protocolApplicationId" value="${protApp.id}" />
                </c:url>
                <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${experimentProtocolEditUrl}', 'divAjaxBody', true);" >${protApp.protocol.name}</a>&nbsp;|&nbsp;
            </c:forEach>
        </c:forEach>
    </div>
</s:if>
