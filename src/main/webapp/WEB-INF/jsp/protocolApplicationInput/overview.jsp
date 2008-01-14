<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="true" />
<s:if test="${input.id != null}">
    <c:set var="formAction" value="ajax/protocolApplicationInput/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="protocolApplicationInput/management/save"/>
</s:else>

<protExpress:tabPane paneTitleKey="protocolApplicationInput.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="input.lsid" key="protocolApplicationInput.lsid" size="40" tabindex="1" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="input.name" key="protocolApplicationInput.name" size="40" tabindex="2" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="input.dataFileURL" key="protocolApplicationInput.dataFileUrl" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:hidden name="input.id" />
        <s:hidden name="protocolApplicationId" />
    </s:form>

    <div class="actions">
        <c:url value="/protocolApplication/management/load.action" var="cancelUrl">
            <c:param name="protocolApplication.id" value="${protocolApplication.id}" />
            <c:param name="initialTab" value="inputs" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="4"><fmt:message key="cancel" /></a>
        <s:if test="${input.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="5"><fmt:message key="selectInput" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="5"><fmt:message key="selectInput" /></a>
        </s:else>
    </div>
</protExpress:tabPane>