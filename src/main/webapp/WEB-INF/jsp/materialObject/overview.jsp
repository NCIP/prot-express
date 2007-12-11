<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${materialObject.id != null && materialObject.experiment.auditInfo.creator != currentUser.loginName}" />
<s:if test="${materialObject.id != null}">
    <c:set var="formAction" value="ajax/materialObject/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="materialObject/management/save"/>
</s:else>

<protExpress:tabPane paneTitleKey="materialObject.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="materialObject.lsid" key="materialObject.lsid" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="materialObject.name" key="materialObject.name" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:hidden name="materialObject.id" />
        <s:hidden name="experimentId" />
    </s:form>

    <div class="actions">
        <c:url value="/experiment/management/load.action" var="cancelUrl">
            <c:param name="experiment.id" value="${materialObject.experiment.id}" />
            <c:param name="initialTab" value="materialObjects" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="8"><fmt:message key="cancel" /></a>
        <s:if test="${materialObject.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>