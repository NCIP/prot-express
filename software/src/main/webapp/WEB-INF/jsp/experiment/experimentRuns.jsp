<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<c:set var="isReadOnly" value="${experiment.id != null && experiment.creator != currentUser.loginName}" />
<protExpress:tabPane paneTitleKey="experiment.tabs.experimentRuns">
    Experiment Runs will go here!!
    <s:form action="ajax/experiment/management/save/experimentRuns" method="post" id="experimentForm" disabled="${isReadOnly}" >
        <s:hidden name="experiment.id" />
        <s:hidden name="cancelResult" />
    </s:form>
    <div class="actions">
        <c:url value="/experiment/management/cancel.action" var="cancelUrl">
            <c:param name="cancelResult" value="${cancelResult}" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="6"><fmt:message key="cancel" /></a>
        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="7"><fmt:message key="copy" /></a>
        </s:if>
        <s:else>
            <s:a onclick="showSubmittingText();" formId="experimentForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false" tabindex="7"><fmt:message key="save" /></s:a>
        </s:else>
    </div>
</protExpress:tabPane>