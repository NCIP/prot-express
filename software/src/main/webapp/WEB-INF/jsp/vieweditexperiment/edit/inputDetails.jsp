<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:head theme="ajax" />
<h3>${inputOutputObject.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>
<s:form id="editInputForm" action="/ajax/editExperiment/input/saveInput.action" method="post">
    <s:hidden name="inputOutputObjectId" value="%{inputOutputObject.id}"/>
    <s:hidden name="protocolApplicationId" value="%{protocolApplicationId}"/>
    <table class="form">
        <tr>
            <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.input.name" />:</td>
            <td class="value"><s:textfield name="inputOutputObject.name"/></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.input.filename" />:</td>
            <td class="value"><s:textfield name="inputOutputObject.dataFileURL"/></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.input.notes" />:</td>
            <td class="value">
                <s:textarea name="inputOutputObject.notes" rows="4" cols="20" cssStyle="width:90%"></s:textarea>
            </td>
        </tr>
    </table>
    <div class="actionsrow">
        <del class="btnwrapper">
            <ul id="btnrow2">
                <li>
                    <s:a theme="ajax" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="save"><fmt:message key="protexpress.page.inputdetails.buttons.save" /></span>
                        </span>
                    </s:a>
                </li>
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="delete"><fmt:message key="protexpress.page.inputdetails.buttons.delete" /></span>
                        </span>
                    </a>
                </li>
            </ul>
        </del>
    </div>
</s:form>

