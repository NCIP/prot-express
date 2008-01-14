<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${input.id != null && input.experiment.auditInfo.creator != currentUser.loginName}" />
<s:if test="${input.id != null}">
    <c:set var="formAction" value="ajax/experimentInput/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="experimentInput/management/save"/>
</s:else>

<protExpress:tabPane paneTitleKey="experimentInput.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="input.lsid" key="experimentInput.lsid" size="40" tabindex="1" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="input.name" key="experimentInput.name" size="40" tabindex="2" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="input.dataFileURL" key="experimentInput.dataFileUrl" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:hidden name="input.id" />
        <s:hidden name="experimentId" />
    </s:form>

    <div class="actions">
        <c:url value="/experiment/management/load.action" var="cancelUrl">
            <c:param name="experiment.id" value="${input.experiment.id}" />
            <c:param name="initialTab" value="experimentInputs" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="4"><fmt:message key="cancel" /></a>
        <s:if test="${input.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="5"><fmt:message key="save" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="5"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>