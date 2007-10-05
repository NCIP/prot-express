<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experimentRun.id != null && experimentRun.auditInfo.creator != currentUser.loginName}" />
<s:if test="${experimentRun.id != null}">
    <c:set var="formAction" value="ajax/experimentRun/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="experimentRun/management/save"/>
</s:else>
<protExpress:tabPane paneTitleKey="experimentRun.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="experimentRun.lsid" key="experimentRun.lsid" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="experimentRun.name" key="experimentRun.name" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="experimentRun.comments" key="experimentRun.comments" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:hidden name="experimentRun.id" />
        <s:hidden name="experimentId" />
    </s:form>
    <div class="actions">
        <c:url value="/experiment/management/load.action" var="cancelUrl">
            <c:param name="experiment.id" value="${experimentRun.experiment.id}" />
            <c:param name="initialTab" value="experimentRuns" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="4"><fmt:message key="cancel" /></a>

        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="5"><fmt:message key="copy" /></a>
        </s:if>
        <s:elseif test="${experimentRun.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="5"><fmt:message key="save" /></a>
        </s:elseif>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="5"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>