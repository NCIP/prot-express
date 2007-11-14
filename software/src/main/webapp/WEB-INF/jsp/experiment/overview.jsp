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
        <s:textfield name="experiment.lsid" key="experiment.lsid" size="40" tabindex="1" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="experiment.name" key="experiment.name" size="40" tabindex="2" disabled="${isReadOnly}"  required="true"/>
        <s:textfield name="experiment.comments" key="experiment.comments" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:textfield name="experiment.hypothesis" key="experiment.hypothesis" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:textfield name="experiment.url" key="experiment.url" size="40" tabindex="5" disabled="${isReadOnly}" />
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