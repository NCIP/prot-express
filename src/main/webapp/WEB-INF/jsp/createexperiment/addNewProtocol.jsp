<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<jsp:include page="/WEB-INF/jsp/createexperiment/experimentAddOrSelectProtocolHeader.jsp" />

<s:form id="addNewProtocolForm" action="/createExperiment/manageProtocols/save.action" method="post">
    <s:hidden name="protocolApplication.id" value="${protocolApplication.id}"/>
    <s:hidden name="experimentId" value="${experiment.id}"/>
    <s:hidden name="experimentRunId" value="${experimentRun.id}"/>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.name" />:</td>
                <td class="value"><s:textfield name="protocol.name"/>
                </td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.description" />:</td>
                <td class="value"><s:textarea name="protocol.description" rows="2" cols="20"></s:textarea></td>
            </tr>
        </table>
    </div>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.software" />:</td>
                <td class="value"><s:textfield name="protocol.software"></s:textfield></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.instrument" />:</td>
                 <td class="value"><s:textfield name="protocol.instrument"></s:textfield></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.notes" />:</td>
                 <td class="value"> <s:textarea name="protocol.notes" rows="2" cols="20"></s:textarea></td>
            </tr>
        </table>
    </div>
    <div class="clear"/>
    <div class="actionsrow">
        <del class="btnwrapper">
            <ul id="btnrow2">
                <li>
                    <c:url var="cancelUrl" value="/createExperiment/reloadCreateNewExperiment.action" />
                    <a href="${cancelUrl}" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="cancel"><fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.button.back" /></span>
                        </span>
                    </a>
                </li>
                <li>
                    <a href="javascript:document.getElementById('addNewProtocolForm').submit();" class="btn" style="text-decoration:none" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="savecontinue"><fmt:message key="protexpress.page.createnewexperiment.addnewprotocol.button.saveandcontinue" /></span>
                        </span>
                    </a>
                </li>
            </ul>
        </del>
        <div class="clear"></div>
    </div>
</s:form>
