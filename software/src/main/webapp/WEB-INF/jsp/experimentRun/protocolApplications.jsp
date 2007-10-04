<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experimentRun.id != null && experimentRun.auditInfo.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="experimentRun.tabs.overview">
    Protocol Applications will be here!!
    <div class="actions">
        <c:url value="/experiment/management/load.action" var="cancelUrl">
            <c:param name="experiment.id" value="${experimentRun.experiment.id}" />
            <c:param name="initialTab" value="experimentRun" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="4"><fmt:message key="cancel" /></a>
    </div>
</protExpress:tabPane>