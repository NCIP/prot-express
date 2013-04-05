<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div id="treeViewData">
    <h2 class="treehead"><fmt:message key="protexpress.page.viewexperiment.treeview.title" /></h2>
<ul>
    <li id="${experiment.id}">
        <c:url var="loadExperimentDetailsUrl" value="/ajax/${treeNodeUrlPrefix}Experiment/experiment/load.action">
            <c:param name="experimentId" value="${experiment.id}"></c:param>
        </c:url>
        <span><protExpress:treeNode name="${experiment.name}" url="${loadExperimentDetailsUrl}" cssClass="experiment"/><br /></span>
        <ul style="display:block">
            <s:iterator id="experimentRun" value="%{experiment.experimentRuns}">
                <c:url var="loadExperimentRunDetailsUrl" value="/ajax/${treeNodeUrlPrefix}Experiment/experimentRun/load.action">
                    <c:param name="experimentId" value="${experiment.id}"></c:param>
                    <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                </c:url>
                <li id="${experimentRun.id}">
                    <span>&nbsp;&nbsp;&nbsp;&nbsp;<protExpress:treeNode name="${experimentRun.name}" url="${loadExperimentRunDetailsUrl}" cssClass="experiment_run"/><br /></span>
                    <ul style="display:block">
                        <s:iterator id="protApp" value="%{protocolApplications}">
                            <c:url var="loadProtocolApplicationDetailsUrl" value="/ajax/${treeNodeUrlPrefix}Experiment/protocolApplication/load.action">
                                <c:param name="experimentId" value="${experiment.id}"></c:param>
                                <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                                <c:param name="protocolApplicationId" value="${protApp.id}"></c:param>
                            </c:url>
                            <li id="${protApp.id}">
                                <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<protExpress:treeNode name="${protApp.protocol.name}" url="${loadProtocolApplicationDetailsUrl}" cssClass="protocol"/><br /></span>
                                <ul style="display:block">
                                    <s:iterator id="input" value="%{inputs}">
                                        <c:url var="loadInputDetailsUrl" value="/ajax/${treeNodeUrlPrefix}Experiment/input/load.action">
                                            <c:param name="experimentId" value="${experiment.id}"></c:param>
                                            <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                                            <c:param name="protocolApplicationId" value="${protApp.id}"></c:param>
                                            <c:param name="inputOutputObjectId" value="${input.id}"></c:param>
                                        </c:url>
                                        <li id="${protApp.id}.${input.id}">
                                            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<protExpress:treeNode name="${input.name}" url="${loadInputDetailsUrl}" cssClass="input"/><br /></span></li>
                                    </s:iterator>
                                    <s:iterator id="output" value="%{outputs}">
                                        <c:url var="loadOutputDetailsUrl" value="/ajax/${treeNodeUrlPrefix}Experiment/output/load.action">
                                            <c:param name="experimentId" value="${experiment.id}"></c:param>
                                            <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                                            <c:param name="protocolApplicationId" value="${protApp.id}"></c:param>
                                            <c:param name="inputOutputObjectId" value="${output.id}"></c:param>
                                        </c:url>
                                        <li id="${protApp.id}.${output.id}">
                                        <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<protExpress:treeNode name="${output.name}" url="${loadOutputDetailsUrl}" cssClass="output"/><br /></span></li>
                                    </s:iterator>
                                </ul>
                            </li>
                        </s:iterator>
                    </ul>
                </li>
            </s:iterator>
        </ul>
    </li>
</ul>
</div>
