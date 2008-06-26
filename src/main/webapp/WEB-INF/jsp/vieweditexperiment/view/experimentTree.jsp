<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<ul id="treeview">
    <li id="${experiment.id}">
        <c:url var="loadExperimentDetailsUrl" value="${urlPrefix}/experiment/load.action">
            <c:param name="experimentId" value="${experiment.id}"></c:param>
        </c:url>
        <s:url id="loadExperimentDetailsUrl1" value="%{#urlPrefix1}/experiment/load.action">
            <s:param name="experimentId" value="%{experiment.id}"></s:param>
        </s:url>
        <s:a href="%{loadExperimentDetailsUrl1}" theme="ajax" targets="detail-content">#test111</s:a>
        <span>
            <a href="javascript://noop/" onclick="toggleTreeNodeAndRefreshDetailsView('${experiment.id}','${loadExperimentDetailsUrl}')" class="experiment">${experiment.name}</a>
        </span>
        <ul style="display:block">
            <s:iterator id="experimentRun" value="%{experiment.experimentRuns}">
                <c:url var="loadExperimentRunDetailsUrl" value="${urlPrefix}/experimentRun/load.action">
                    <c:param name="experimentId" value="${experiment.id}"></c:param>
                    <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                </c:url>
                <li id="${experimentRun.id}">
                    <span><a href="javascript://noop/" onclick="toggleTreeNodeAndRefreshDetailsView('${experimentRun.id}','${loadExperimentRunDetailsUrl}')" class="experimentrun">${experimentRun.name}</a></span>
                    <ul style="display:block">
                        <s:iterator id="protApp" value="%{protocolApplications}">
                            <c:url var="loadProtocolApplicationDetailsUrl" value="${urlPrefix}/protocolApplication/load.action">
                                <c:param name="experimentId" value="${experiment.id}"></c:param>
                                <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                                <c:param name="protocolApplicationId" value="${protApp.id}"></c:param>
                            </c:url>
                            <li id="${protApp.id}">
                                <span><a href="javascript://noop/" onclick="toggleTreeNodeAndRefreshDetailsView('${protApp.id}','${loadProtocolApplicationDetailsUrl}')" class="protocol">${protApp.protocol.name}</a></span>
                                <ul style="display:none">
                                    <s:iterator id="input" value="%{inputs}">
                                        <c:url var="loadInputDetailsUrl" value="${urlPrefix}/input/load.action">
                                            <c:param name="experimentId" value="${experiment.id}"></c:param>
                                            <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                                            <c:param name="protocolApplicationId" value="${protApp.id}"></c:param>
                                            <c:param name="inputOutputObjectId" value="${input.id}"></c:param>
                                        </c:url>
                                        <li id="${protApp.id}.${input.id}">
                                            <span><a href="javascript://noop/" onclick="toggleTreeNodeAndRefreshDetailsView('${protApp.id}.${input.id}','${loadInputDetailsUrl}')" class="input">${input.name}</a></span></li>
                                    </s:iterator>
                                    <s:iterator id="output" value="%{outputs}">
                                        <c:url var="loadOutputDetailsUrl" value="${urlPrefix}/output/load.action">
                                            <c:param name="experimentId" value="${experiment.id}"></c:param>
                                            <c:param name="experimentRunId" value="${experimentRun.id}"></c:param>
                                            <c:param name="protocolApplicationId" value="${protApp.id}"></c:param>
                                            <c:param name="inputOutputObjectId" value="${output.id}"></c:param>
                                        </c:url>
                                        <li id="${protApp.id}.${output.id}">
                                        <span><a href="javascript://noop/" onclick="toggleTreeNodeAndRefreshDetailsView('${protApp.id}.${output.id}','${loadOutputDetailsUrl}')" class="output">${output.name}</a></span></li>
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