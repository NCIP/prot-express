<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<c:set  var="urlPrefix" value="/ajax/editExperiment" />

<ul id="treeview">
    <li id="${experiment.id}">

        <s:url id="loadExperimentDetailsUrl" value="/ajax/editExperiment/experiment/load.action">
            <s:param name="experimentId" value="%{experiment.id}"></s:param>
        </s:url>
        <span>
            <s:a href="%{loadExperimentDetailsUrl}" theme="ajax" targets="detail-content"  cssClass="experiment">${experiment.name}</s:a>
        </span>
        <ul style="display:block">
            <s:iterator id="experimentRun" value="%{experiment.experimentRuns}">
                <s:url id="loadExperimentRunDetailsUrl" value="/ajax/editExperiment/experimentRun/load.action">
                    <s:param name="experimentId" value="experiment.id"></s:param>
                    <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
                </s:url>
                <li id="${experimentRun.id}">
                    <span>
                        <s:a href="%{loadExperimentRunDetailsUrl}" theme="ajax" targets="detail-content" cssClass="experimentrun">${experimentRun.name}</s:a>
                    </span>
                    <ul style="display:block">
                        <s:iterator id="protApp" value="%{protocolApplications}">
                            <s:url id="loadProtocolApplicationDetailsUrl" value="/ajax/editExperiment/protocolApplication/load.action">
                                <s:param name="experimentId" value="experiment.id"></s:param>
                                <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
                                <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
                            </s:url>
                            <li id="${protApp.id}">
                                <span>
                                    <s:a href="%{loadProtocolApplicationDetailsUrl}" theme="ajax" targets="detail-content" cssClass="protocol">${protApp.protocol.name}</s:a>
                                </span>
                                <ul style="display:block">
                                    <s:iterator id="input" value="%{inputs}">
                                        <s:url id="loadInputDetailsUrl" value="/ajax/editExperiment/input/load.action">
                                            <s:param name="experimentId" value="experiment.id"></s:param>
                                            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
                                            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
                                            <s:param name="inputOutputObjectId" value="#input.id"></s:param>
                                        </s:url>
                                        <li id="${protApp.id}.${input.id}">
                                            <span>
                                                <s:a href="%{loadInputDetailsUrl}" theme="ajax" targets="detail-content" cssClass="input">${input.name}</s:a>
                                            </span>
                                       </li>
                                    </s:iterator>
                                    <s:iterator id="output" value="%{outputs}">
                                        <s:url id="loadOutputDetailsUrl" value="/ajax/editExperiment/output/load.action">
                                            <s:param name="experimentId" value="experiment.id"></s:param>
                                            <s:param name="experimentRunId" value="#experimentRun.id"></s:param>
                                            <s:param name="protocolApplicationId" value="#protApp.id"></s:param>
                                            <s:param name="inputOutputObjectId" value="#output.id"></s:param>
                                        </s:url>
                                        <li id="${protApp.id}.${output.id}">
                                            <span>
                                                <s:a href="%{loadOutputDetailsUrl}" theme="ajax" targets="detail-content" cssClass="output">${output.name}</s:a>
                                            </span>
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