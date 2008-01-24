<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experiment.id != null && experiment.auditInfo.creator != currentUser.loginName}" />
<s:if test="${experiment.id != null}">
    <c:set var="formAction" value="ajax/experiment/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="experiment/management/save"/>
</s:else>
<protExpress:tabPane paneTitleKey="experiment.overview">
    <s:form action="${formAction}" id="experimentForm" method="post" disabled="${isReadOnly}">
        <c:if test="${experiment.id != null}">
            <tr>
                <td class="tdLabel"><s:label cssClass="label" name="experiment.lsid" key="experiment.lsid" ></s:label></td>
            </tr>
        </c:if>
        <s:textfield name="experiment.name" key="experiment.name" size="40" tabindex="2" disabled="${isReadOnly}"  required="true"/>
        <s:textarea name="experiment.comments" key="experiment.comments" rows="4" cols="37" tabindex="3" disabled="${isReadOnly}" />
        <s:textarea name="experiment.hypothesis" key="experiment.hypothesis" rows="4" cols="37" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="experiment.url" key="experiment.url" size="40" tabindex="5" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.firstName" key="experiment.primaryContact.firstName" size="40" tabindex="6" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.lastName" key="experiment.primaryContact.lastName" size="40" tabindex="7" disabled="${isReadOnly}" />
        <s:textfield name="experiment.primaryContact.email" key="experiment.primaryContact.email" size="40" tabindex="8" disabled="${isReadOnly}" />
        <s:textarea name="experiment.primaryContact.contactId" key="experiment.primaryContact.contactId" rows="4" cols="37"  tabindex="9" disabled="${isReadOnly}" />
        <s:hidden name="experiment.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/experiment/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="6"><fmt:message key="cancel" /></a>

        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="7"><fmt:message key="copy" /></a>
        </s:if>
        <s:elseif test="${experiment.id != null}">
            <a href="javascript:ajaxSubmit('experimentForm', 'selectedtabbox');" class="save" tabindex="7"><fmt:message key="save" /></a>
        </s:elseif>
        <s:else>
            <a href="javascript:document.getElementById('experimentForm').submit();" class="save" tabindex="7"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>