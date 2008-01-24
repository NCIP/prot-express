<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${protocolAction.id != null && protocolAction.experiment.auditInfo.creator != currentUser.loginName}" />

<protExpress:tabPane paneTitleKey="protocolAction.overview">
    <s:form action="protocolAction/management/save" id="overviewForm" method="post" disabled="${isReadOnly}">
        <jsp:include page="/WEB-INF/jsp/protocolAction/ajaxSelectProtocol.jsp" />

        <s:hidden name="protocolAction.id" />
        <s:hidden name="experimentId" />
        <s:hidden name="experiment.id" value="${protocolAction.experiment.id}" />
        <s:hidden name="initialTab" value="protocolActions" />
    </s:form>

    <div class="actions">
        <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
    </div>
</protExpress:tabPane>