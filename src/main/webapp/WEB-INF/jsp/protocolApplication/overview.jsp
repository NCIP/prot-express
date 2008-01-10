<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${protocolApplication.id != null && protocolApplication.auditInfo.creator != currentUser.loginName}" />
<s:if test="${protocolApplication.id != null}">
    <c:set var="formAction" value="ajax/protocolApplication/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="protocolApplication/management/save"/>
</s:else>
<protExpress:tabPane paneTitleKey="protocolApplication.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <td class="tdLabel"><s:label cssClass="label" name="protocolApplication.protocolAction.protocol.name" key="protocolAction.protocolName" ></s:label></td>
        <s:textfield name="protocolApplication.lsid" key="protocolApplication.lsid" size="40" tabindex="1" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="protocolApplication.name" key="protocolApplication.name" size="40" tabindex="2" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="protocolApplication.activityDate" key="protocolApplication.activityDate" maxlength="10" size="10" tabindex="4" disabled="${isReadOnly}" required="true"/>
        <s:textarea name="protocolApplication.comments" key="protocolApplication.comments" rows="4" cols="37" tabindex="4" disabled="${isReadOnly}" />
        <s:hidden name="protocolApplication.id" />
        <s:hidden name="experimentRunId" />
        <s:hidden name="protocolActionId" />
    </s:form>
    <div class="actions">
        <c:url value="/experimentRun/management/load.action" var="cancelUrl">
            <c:param name="experimentRun.id" value="${protocolApplication.experimentRun.id}" />
            <c:param name="initialTab" value="protocolApplications" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="8"><fmt:message key="cancel" /></a>

        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="9"><fmt:message key="copy" /></a>
        </s:if>
        <s:elseif test="${protocolApplication.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:elseif>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>