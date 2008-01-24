<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${output.id != null && output.experiment.auditInfo.creator != currentUser.loginName}" />
<s:if test="${output.id != null}">
    <c:set var="formAction" value="ajax/protocolApplicationOutput/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="protocolApplicationOutput/management/save"/>
</s:else>

<protExpress:tabPane paneTitleKey="protocolApplicationOutput.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <c:if test="${output.id != null}">
            <tr>
                <td class="tdLabel"><s:label cssClass="label" name="output.lsid" key="protocolApplicationOutput.lsid" ></s:label></td>
            </tr>
        </c:if>
        <s:textfield name="output.name" key="protocolApplicationOutput.name" size="40" tabindex="2" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="output.dataFileURL" key="protocolApplicationOutput.dataFileUrl" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:hidden name="output.id" />
        <s:hidden name="protocolApplicationId" />
    </s:form>

    <div class="actions">
        <c:url value="/protocolApplication/management/load.action" var="cancelUrl">
            <c:param name="protocolApplication.id" value="${protocolApplication.id}" />
            <c:param name="initialTab" value="outputs" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="4"><fmt:message key="cancel" /></a>
        <s:if test="${output.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="5"><fmt:message key="save" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="5"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>