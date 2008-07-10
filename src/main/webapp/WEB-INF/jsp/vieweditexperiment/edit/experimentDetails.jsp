<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:head theme="ajax"/>
<h3>${experiment.name}</h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>
<s:form id="editExperimentForm" action="/ajax/editExperiment/experiment/saveExperiment.action" method="post">
    <s:hidden name="experimentId" value="%{experiment.id}"/>
    <fieldset class="leftfield">
        <legend><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.overviewtitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <span class="required">*</span>&nbsp;<s:textfield name="experiment.name" key="protexpress.experiment.name" labelposition="top"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.description" key="protexpress.experiment.description" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.hypothesis" key="protexpress.experiment.hypothesis" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.url" key="protexpress.experiment.url" labelposition="top"/>
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.notes" key="protexpress.experiment.notes" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield">
        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.dateperformedtitle" /></legend>
        <s:datetimepicker name="experiment.datePerformed" toggleType="fade" displayFormat="MM/dd/yyyy" required="*"/>
    </fieldset>
    <fieldset class="rightfield">
        <legend><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.contacttitle" /></legend>
        <table class="form3">
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.contactPerson.firstName" key="protexpress.contact.firstname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.contactPerson.lastName" key="protexpress.contact.lastname" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textfield name="experiment.contactPerson.email" key="protexpress.contact.email" labelposition="top" />
                </td>
            </tr>
            <tr>
                <td class="label_left">
                    <s:textarea name="experiment.contactPerson.notes" key="protexpress.contact.notes" labelposition="top" rows="4"></s:textarea>
                </td>
            </tr>
        </table>
    </fieldset>
    <div class="clear"><br /></div>
    <div class="actionsrow">
        <del class="btnwrapper">
            <ul id="btnrow2">
                <li>
                    <s:a theme="ajax" targets="detail-content" cssClass="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="save"><fmt:message key="protexpress.page.editexperimentdetails.buttons.save" /></span>
                        </span>
                    </s:a>
                </li>
                <li>
                    <a href="javascript:alert('Not Yet Implemented');" class="btn" onclick="this.blur();">
                        <span class="btn_img">
                            <span class="delete"><fmt:message key="protexpress.page.editexperimentdetails.buttons.delete" /></span>
                        </span>
                    </a>
                </li>
            </ul>
        </del>
    </div>
</s:form>