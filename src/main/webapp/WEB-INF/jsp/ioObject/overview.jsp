<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${inputOutputObject.id != null && inputOutputObject.experiment.auditInfo.creator != currentUser.loginName}" />
<s:if test="${inputOutputObject.id != null}">
    <c:set var="formAction" value="ajax/ioObject/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="ioObject/management/save"/>
</s:else>

<protExpress:tabPane paneTitleKey="ioObject.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="inputOutputObject.lsid" key="ioObject.lsid" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="inputOutputObject.name" key="ioObject.name" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:radio name="inputOutputObject.cpasType" key="ioObject.cpasType"
            list="@gov.nih.nci.protexpress.data.persistent.InputOutputObjectType@values()" listValue="displayName"
            tabindex="3" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="inputOutputObject.dataFileURL" key="ioObject.dataFileUrl" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:hidden name="inputOutputObject.id" />
        <s:hidden name="experimentId" />
    </s:form>

    <div class="actions">
        <c:url value="/experiment/management/load.action" var="cancelUrl">
            <c:param name="experiment.id" value="${inputOutputObject.experiment.id}" />
            <c:param name="initialTab" value="ioObjects" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="8"><fmt:message key="cancel" /></a>
        <s:if test="${inputOutputObject.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>