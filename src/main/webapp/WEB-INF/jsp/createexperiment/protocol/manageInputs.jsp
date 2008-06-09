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
    <jsp:include page="/WEB-INF/jsp/createexperiment/protocol/inputs.jsp" />
</fieldset>

<div class="clear"></div>
<div class="actionsrow">
    <del class="btnwrapper">
        <ul id="btnrow2">
            <c:url var="saveInputsUrl" value="/createExperiment/protocols/inputs/save.action" />
            <c:url var="skipStepUrl" value="/notYetImplemented.html" />
            <li>
                <a href="javascript:submitForm('${actionUrlSaveInputs}', 'protocolApplicationInputsForm');" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="save"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.save" /></span>
                    </span>
                </a>
            </li>
        </ul>
    </del>
    <div class="clear"/>
</div>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolFooter.jsp" />
