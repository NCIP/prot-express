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
<script type="text/javascript">
function toggleDataFileUrlElement() {

    var divDataFileUrl = document.getElementById("inputOutputObject.dataFileURL");
    if (divDataFileUrl != null) {
        var elementCpasType = document.getElementById("inputOutputObject.cpasType");
        if (elementCpasType != null) {
            var selectedCpasType = elementCpasType.value;
            if (selectedCpasType == "Data") {
                divDataFileUrl.style.visibility = true;
            }
            else {
                var elementDataFileUrl = document.getElementByName("inputOutputObject.dataFileURL");
                if (elementDataFileUrl != null) {
                    elementDataFileUrl.value = "";
                }
                divDataFileUrl.style.visibility = false;
            }
        }
    }
}
</script>
<protExpress:tabPane paneTitleKey="inputOutputObject.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="inputOutputObject.lsid" key="inputOutputObject.lsid" size="40" tabindex="1" disabled="${isReadOnly}" required="true"/>
        <s:textfield name="inputOutputObject.name" key="inputOutputObject.name" size="40" tabindex="2" disabled="${isReadOnly}" required="true"/>
        <s:radio
            id="inputOutputObject.cpasType"
            name="inputOutputObject.cpasType"
            key="inputOutputObject.cpasType"
            list="@gov.nih.nci.protexpress.data.persistent.InputOutputObjectType@values()"
            listValue="displayName"
            tabindex="3"
            disabled="${isReadOnly}"
            required="true" onchange="toggleDataFileUrlElement();"/>
        <div id="divDataFileUrl">
            <s:textfield name="inputOutputObject.dataFileURL" key="inputOutputObject.dataFileUrl" size="40" tabindex="4" disabled="${isReadOnly}" />
        </div>
        <s:hidden name="inputOutputObject.id" />
        <s:hidden name="experimentId" />
        <s:hidden name="protocolApplicationId" />
    </s:form>

    <div class="actions">
        <s:if test="${inputOutputObject.experiment.id != null}">
            <c:url value="/experiment/management/load.action" var="cancelUrl">
                <c:param name="experiment.id" value="${inputOutputObject.experiment.id}" />
                <c:param name="initialTab" value="ioObjects" />
            </c:url>
        </s:if>
        <s:else>
            <c:url value="/experiment/management/load.action" var="cancelUrl">
                <c:param name="protocolApplication.id" value="${inputOutputObject.protocolApplication.id}" />
                <c:param name="initialTab" value="inputs" />
            </c:url>
        </s:else>

        <a href="${cancelUrl}" class="cancel" tabindex="8"><fmt:message key="cancel" /></a>
        <s:if test="${inputOutputObject.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>