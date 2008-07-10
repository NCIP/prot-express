<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<ul class="pde">
    <li>
        <c:choose>
            <c:when test='${treeMode == "EDIT"}'>
                <s:url id="loadExperimentDetailsUrl" value="/ajax/editExperiment/experiment/load.action">
                    <s:param name="experimentId" value="%{experiment.id}"></s:param>
                </s:url>
            </c:when>
            <c:otherwise>
                <s:url id="loadExperimentDetailsUrl" value="/ajax/viewExperiment/experiment/load.action">
                    <s:param name="experimentId" value="%{experiment.id}"></s:param>
                </s:url>
            </c:otherwise>
        </c:choose>
        <span id="span_${experiment.id}" class="selected"><s:a href="%{loadExperimentDetailsUrl}" cssClass="experiment" theme="ajax" targets="detail-content" >${experiment.name}</s:a></span>
        <ul class="show">
            <s:iterator id="experimentRun" value="%{experiment.experimentRuns}">
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
                <li>
                    <span id="span_${experimentRun.id}"><s:a href="%{loadExperimentRunDetailsUrl}" cssClass="experiment_run" theme="ajax" targets="detail-content" >${experimentRun.name}</s:a></span>
                    <ul class="show">
                        <s:iterator id="protApp" value="%{protocolApplications}">
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
                            <li>
                                <span id="span_${protApp.id}"><s:a href="%{loadProtocolApplicationDetailsUrl}" cssClass="protocol" theme="ajax" targets="detail-content" >${protApp.protocol.name}</s:a></span>
                                <ul>
                                    <s:iterator id="input" value="%{inputs}">
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
                                        <li>
                                            <span id="span_${protApp.id}.${input.id}"><s:a href="%{loadInputDetailsUrl}" cssClass="input" theme="ajax" targets="detail-content" >${input.name}</s:a></span>
                                       </li>
                                    </s:iterator>
                                    <s:iterator id="output" value="%{outputs}">
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
                                        <li>
                                            <span id="span_${protApp.id}.${output.id}"><s:a href="%{loadOutputDetailsUrl}" cssClass="output" theme="ajax" targets="detail-content" >${output.name}</s:a></span>
                                        </li>
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
