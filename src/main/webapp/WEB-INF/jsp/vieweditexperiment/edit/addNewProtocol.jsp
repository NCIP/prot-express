<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:head theme="ajax" />

<h3><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.caption" /></h3>

<div class="tabs">
    <s:url id="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/addNewProtocol.action">
        <s:param name="experimentRunId" value="experimentRun.id" />
    </s:url>
    <s:url id="selectExistingProtocolUrl" value="/ajax/editExperiment/experimentRun/selectExistingProtocol.action">
        <s:param name="experimentRunId" value="experimentRun.id" />
    </s:url>
    <s:a theme="ajax" href="%{addNewProtocolUrl}" targets="detail-content" cssClass="selected">
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.addnewprotocol" /></span>
    </s:a>
    <s:a theme="ajax" href="%{selectExistingProtocolUrl}" targets="detail-content" >
        <span><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.tabs.selectexistingprotocol" /></span>
    </s:a>
</div>

<s:form id="addNewProtocolForm" action="ajax/editExperiment/experimentRun/saveNewProtocol.action" method="post">
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
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
    <div class="actionsrow">
        <del class="btnwrapper">
            <ul id="btnrow2">
                <li>
                    <s:url id="cancelUrl" value="/ajax/editExperiment/experimentRun/load.action">
                        <s:param name="experimentRunId" value="experimentRun.id" />
                    </s:url>
                    <s:a theme="ajax" href="%{cancelUrl}" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="cancel"><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.buttons.cancel" /></span>
                        </span>
                    </s:a>
                </li>
                <li>
                    <s:a theme="ajax" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="save"><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol.buttons.save" /></span>
                        </span>
                    </s:a>
                </li>
            </ul>
        </del>
        <div class="clear"></div>
    </div>
</s:form>


