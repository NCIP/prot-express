<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:head theme="ajax" />
<h3>${protocolApplication.protocol.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>
<s:form id="editExperimentForm" action="/ajax/editExperiment/protocolApplication/saveProtocolApplication.action" method="post">
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>
    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.overviewtitle" /></legend>
        <table class="form2">
            <tr>
                <td class="label_left"><span class="required">*</span>&nbsp;<s:textfield name="protocolApplication.protocol.name" key="protexpress.protocol.name" labelposition="top"/></td>
            </tr>
            <tr>
                <td class="label_left"><s:textarea name="protocolApplication.protocol.description" key="protexpress.protocol.description" labelposition="top" rows="4"></s:textarea></td>
            </tr>
            <tr>
                <td class="label_left"><s:textarea name="protocolApplication.notes" key="protexpress.protocol.notes" labelposition="top" rows="4"></s:textarea></td>
            </tr>
            <tr>
                <td class="label_left"><s:textfield name="protocolApplication.protocol.software" key="protexpress.protocol.software" labelposition="top"/></td>
            </tr>
            <tr>
                <td class="label_left"><s:textfield name="protocolApplication.protocol.instrument" key="protexpress.protocol.instrument" labelposition="top"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.protocolapplication.dateperformed" /></legend>
        <s:datetimepicker name="protocolApplication.datePerformed" toggleType="fade" displayFormat="MM/dd/yyyy" required="*"/>
    </fieldset>
     <fieldset class="rightfield">
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.contacttitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <s:textfield name="protocolApplication.protocol.contactPerson.firstName" key="protexpress.contact.firstname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="protocolApplication.protocol.contactPerson.lastName" key="protexpress.contact.lastname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="protocolApplication.protocol.contactPerson.email" key="protexpress.contact.email" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="protocolApplication.protocol.contactPerson.notes" key="protexpress.contact.notes" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="clear" />
    <div class="actionsrow">
        <del class="btnwrapper">
            <ul id="btnrow2">
                <li>
                    <s:a theme="ajax" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="save"><fmt:message key="protexpress.page.editprotocolapplicationdetails.buttons.save" /></span>
                        </span>
                    </s:a>
                </li>
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="add_input"><fmt:message key="protexpress.page.editprotocolapplicationdetails.buttons.addinput" /></span>
                        </span>
                    </a>
                </li>
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="add_output"><fmt:message key="protexpress.page.editprotocolapplicationdetails.buttons.addoutput" /></span>
                        </span>
                    </a>
                </li>
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="delete"><fmt:message key="protexpress.page.editprotocolapplicationdetails.buttons.delete" /></span>
                        </span>
                    </a>
                </li>
            </ul>
        </del>
    </div>
</s:form>
