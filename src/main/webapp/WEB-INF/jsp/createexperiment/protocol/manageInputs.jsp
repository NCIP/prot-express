<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolHeader.jsp" />
<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.addinputs.info" /></p></div>
<h3><span>${experiment.name}</span><span class="gt">&nbsp;&gt;&nbsp;</span><span>${protocolApplication.protocol.name}</span></h3>
<div id="processflow2">
    <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.addinputs" /></div>
    <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt=" " /></div>
    <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.addoutputs" /></div>
    <div class="clear"></div>
</div>
<s:form id="protocolApplicationInputsForm" action="createExperiment/protocols/inputs/addNewInput" method="post" >
<fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.addinputs.title" /></legend>
    <c:url var="actionUrlAddInput" value="/createExperiment/protocols/inputs/addNewInput.action" />
    <c:url var="actionUrlSaveInputs" value="/createExperiment/protocols/inputs/saveInputsToSession.action" />
    <div class="searchresults" >
        <table class="newdata2">
            <tr>
                <td width="100%">
                    <div id="divInputOutput">
                        <jsp:include page="/WEB-INF/jsp/createexperiment/protocol/inputs.jsp" />
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <del class="btnwrapper">
                        <ul id="btnrow2" style="float:right; margin-right:0">
                        <!--
                            <li>
                                <s:a theme="ajax" targets="divInputOutput"  cssClass="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="addrow"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.addanotherinput" /></span>
                                    </span>
                                </s:a>
                            </li>
                            -->
                            <li>
                                    <s:url id="actionUrlAddInput" value="/createExperiment/protocols/inputs/addNewInput.action"/>
                                    <a href="javascript:submitForm('${actionUrlAddInput}', 'protocolApplicationInputsForm');" class="btn" onclick="this.blur();">
                                        <span class="btn_img"><span class="addrow"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.addanotherinput" /></span></span>
                                    </a>
                                </li>
                        </ul>
                    </del>
                </td>
            </tr>
        </table>
    </div>
</fieldset>
</s:form>
<div class="clear"></div>
<div class="actionsrow">
    <del class="btnwrapper">
        <ul id="btnrow2">
            <li>
                <a href="javascript:submitForm('${actionUrlSaveInputs}', 'protocolApplicationInputsForm');" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="next"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.continue" /></span>
                    </span>
                </a>
            </li>
        </ul>
    </del>
    <div class="clear"/>
</div>

<jsp:include page="/WEB-INF/jsp/createexperiment/protocol/protocolFooter.jsp" />
