<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolHeader.jsp" />
<head><s:head debug="false" theme="ajax" /></head>


<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.addinputs.info" /></p></div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.addinputs" /></div>
    <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt=" " /></div>
    <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.addoutputs" /></div>
    <div class="clear"></div>
</div>
<fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.addinputs.title" /></legend>
    <c:url var="actionUrlAddInput" value="/createExperiment/protocols/inputs/addNewInput.action" />
    <c:url var="actionUrlSaveInputs" value="/createExperiment/protocols/inputs/save.action" />
    <c:set var="formName" value="protocolApplicationInputsForm" />

    <s:form id="protocolApplicationInputsForm" method="post">
    <div class="searchresults" >
        <table class="newdata2">
            <tr>
                <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.count" /></th>
                <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.name" /></th>
                <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.filename" /></th>
                <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.notes" /></th>
                <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.action" /></th>
            </tr>
            <div id="divInputOutput">
                <jsp:include page="/WEB-INF/jsp/createexperiment/protocol/inputs.jsp" />
            </div>
            <tr>
                <td colspan="5">
                    <del class="btnwrapper">
                        <ul id="btnrow2" style="float:right; margin-right:0">
                            <li>
                                <s:url id="actionUrl" value="/createExperiment/protocols/inputs/addNewInput.action"/>
                                <a href="javascript:submitForm('${actionUrlAddInput}', '${formName}');" class="btn" onclick="this.blur();">
                                    <span class="btn_img"><span class="addrow"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.addanotherinput" /></span></span>
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
            <c:url var="saveInputsUrl" value="/createExperiment/protocols/inputs/save.action" />
            <c:url var="skipStepUrl" value="/notYetImplemented.html" />
            <li>
                <a href="javascript:submitForm('${actionUrlSaveInputs}', '${formName}');" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="save"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.save" /></span>
                    </span>
                </a>
            </li>
             <li>
                <a href="${skipStepUrl}" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="next"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.skipstep" /></span>
                    </span>
                </a>
            </li>
        </ul>
    </del>
    <div class="clear"/>
</div>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolFooter.jsp" />
