<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:head theme="ajax" />
<h3>${experimentRun.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>
<s:form id="editExperimentRunForm" action="/ajax/editExperiment/experimentRun/saveExperimentRun.action" method="post">
    <s:hidden name="experimentRunId" value="%{experimentRun.id}"/>
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.name" />:</td>
            <td class="value">
                <span class="required">*</span>&nbsp;<s:textfield name="experimentRun.name"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.dateperformed" />:</td>
            <td class="value">
                <span class="required">*</span>&nbsp;<s:datetimepicker name="experimentRun.datePerformed" toggleType="fade" displayFormat="MM/dd/yyyy"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.notes" />:</td>
            <td class="value">
                <s:textarea name="experimentRun.notes" rows="4" cols="20" cssStyle="width:90%"></s:textarea>
            </td>
        </tr>
    </table>
    <div class="actionsrow">
        <del class="btnwrapper">
            <ul id="btnrow2">
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="copy"><fmt:message key="protexpress.page.editexperimentrundetails.buttons.repeat" /></span>
                        </span>
                    </a>
                </li>
                <li>
                    <s:a theme="ajax" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="save"><fmt:message key="protexpress.page.editexperimentrundetails.buttons.save" /></span>
                        </span>
                    </s:a>
                </li>
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="delete"><fmt:message key="protexpress.page.editexperimentrundetails.buttons.delete" /></span>
                        </span>
                    </a>
                </li>
                <li>
                    <s:url id="addNewProtocolUrl" value="/ajax/editExperiment/experimentRun/addNewProtocol.action">
                        <s:param name="experimentRunId" value="experimentRun.id" />
                    </s:url>
                    <s:a theme="ajax" href="%{addNewProtocolUrl}" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="add_folder"><fmt:message key="protexpress.page.editexperimentrundetails.buttons.addprotocol" /></span>
                        </span>
                    </s:a>
                </li>
            </ul>
        </del>
    </div>
</s:form>