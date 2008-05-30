<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolHeader.jsp" />
<head><s:head debug="false" theme="ajax" /></head>


<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.addoutputs.info" /></p></div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.addinputs" /></div>
    <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt=" " /></div>
    <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.addoutputs" /></div>
    <div class="clear"></div>
</div>
<fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.addoutputs.title" /></legend>
    <c:url var="actionUrlAddOutput" value="/createExperiment/protocols/outputs/addNewOutput.action" />
    <c:url var="actionUrlSaveOutputs" value="/createExperiment/protocols/outputs/save.action" />
    <c:set var="formName" value="protocolApplicationOutputsForm" />

    <s:form id="protocolApplicationOutputsForm" method="post">
        <div class="searchresults" >
            <table class="newdata2">
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.count" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.name" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.filename" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.notes" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.action" /></th>
                </tr>
                <div id="divInputOutput">
                    <jsp:include page="/WEB-INF/jsp/createexperiment/protocol/outputs.jsp" />
                </div>
                <tr>
                    <td colspan="5">
                        <del class="btnwrapper">
                            <ul id="btnrow2" style="float:right; margin-right:0">
                                <li>
                                    <s:url id="actionUrl" value="/createExperiment/protocols/outputs/addNewOutput.action"/>
                                    <a href="javascript:submitForm('${actionUrlAddOutput}', '${formName}');" class="btn" onclick="this.blur();">
                                        <span class="btn_img"><span class="addrow"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.button.addanotheroutput" /></span></span>
                                    </a>
                                </li>
                            </ul>
                        </del>
                    </td>
                </tr>
            </table>
        </div>
    </s:form>
</fieldset>

<div class="clear"></div>
<div class="actionsrow">
    <del class="btnwrapper">
        <ul id="btnrow2">
            <c:url var="saveInputsUrl" value="/createExperiment/protocols/outputs/save.action" />
            <c:url var="skipStepUrl" value="/notYetImplemented.html" />
            <li>
                <a href="javascript:submitForm('${actionUrlSaveOutputs}', '${formName}');" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="save"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.button.save" /></span>
                    </span>
                </a>
            </li>
             <li>
                <a href="${skipStepUrl}" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="next"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.button.skipstep" /></span>
                    </span>
                </a>
            </li>
        </ul>
    </del>
    <div class="clear"/>
</div>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolFooter.jsp" />
