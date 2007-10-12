<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<protExpress:tabPane paneTitleKey="experiment.tabs.export">
    <s:form action="experiment/export" method="get" id="experimentForm">
        <s:select name="fileType" key="experiment.export.fileType"
            list="@gov.nih.nci.protexpress.ui.actions.experiment.ExperimentExportFileType@values()" listValue="displayName" tabindex="1" />
        <s:hidden name="experiment.id" />
    </s:form>
    <div class="actions">
        <c:url value="/experiment/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="2"><fmt:message key="cancel" /></a>
        <a href="javascript:document.getElementById('experimentForm').submit();" class="save" tabindex="4"><fmt:message key="save" /></a>
    </div>
</protExpress:tabPane>