<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<h3>${experimentRun.name}&nbsp;<span class="&gt;">&gt;&gt;</span>&nbsp;<fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.caption" /></h3>

<div class="tabs">
    <c:url var="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/protocol/addNewProtocol.action">
        <c:param name="experimentId" value="${experiment.id}" />
        <c:param name="experimentRunId" value="${experimentRun.id}" />
    </c:url>
    <c:url var="selectExistingProtocolUrl" value="/ajax/editExperiment/experimentRun/protocol/selectExistingProtocol.action">
        <c:param name="experimentId" value="${experiment.id}" />
        <c:param name="experimentRunId" value="${experimentRun.id}" />
    </c:url>
    <a href="javascript:http://noop/" class="selected" onclick="ProtExpress.loadDiv('${addNewProtocolUrl}', 'detail-content', true)">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.addnewprotocol" /></span>
    </a>
    <a href="javascript:http://noop/" onclick="ProtExpress.loadDiv('${selectExistingProtocolUrl}', 'detail-content', true)">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.selectexistingprotocol" /></span>
    </a>
</div>

<s:form id="addNewProtocolForm" action="ajax/editExperiment/experimentRun/protocol/saveNewProtocol.action" method="post">
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <s:hidden name="experimentId" value="%{experiment.id}" />
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.protocol.name" />:</td>
                <td class="value"><s:textfield name="protocol.name"/>
                </td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.description" />:</td>
                <td class="value"><s:textarea name="protocol.description" rows="2" cols="20"></s:textarea></td>
            </tr>
        </table>
    </div>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.software" />:</td>
                <td class="value"><s:textfield name="protocol.software"></s:textfield></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.instrument" />:</td>
                 <td class="value"><s:textfield name="protocol.instrument"></s:textfield></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.notes" />:</td>
                 <td class="value"> <s:textarea name="protocol.notes" rows="2" cols="20"></s:textarea></td>
            </tr>
        </table>
    </div>
    <div class="clear"/>
    <c:url var="cancelUrl" value="/ajax/editExperiment/experimentRun/load.action">
        <c:param name="experimentRunId" value="${experimentRun.id}" />
        <c:param name="experimentId" value="${experiment.id}" />
    </c:url>
    <protExpress:buttonRow>
        <protExpress:button style="cancel" textKey="protexpress.page.editexperimentrundetails.buttons.addprotocol.buttons.cancel" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', 'detail-content', true);"/>
        <protExpress:button style="save" textKey="protexpress.page.editexperimentrundetails.buttons.addprotocol.buttons.save" id="save" onclick="ProtExpress.submitAjaxForm('addNewProtocolForm', 'detail-content'); return false;"/>
    </protExpress:buttonRow>
</s:form>


