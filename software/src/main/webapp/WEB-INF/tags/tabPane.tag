<%@ attribute name="paneTitleKey" required="true"%>
<%@ attribute name="submittingPaneMessageKey" required="false"%>
<%@ attribute name="initialFormFieldId" required="false"%>
<%@ attribute name="ignoreSuccessMessage" required="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${empty submittingPaneMessageKey}">
    <c:set var="submittingPaneMessageKey" value="saving" />
</c:if>
<script type="text/javascript">
function showSubmittingText() {
    document.getElementById('submittingText').style.display = 'block';
    document.getElementById('theForm').style.display = 'none';
}
</script>
<h3><fmt:message key="${paneTitleKey}" /></h3>
<div id="submittingText" style="display: none;">
    <div class="padme5"><fmt:message key="${submittingPaneMessageKey}" /></div>
</div>
<div id="theForm">
    <c:if test="${not empty successMessage && ignoreSuccessMessage != 'true'}">
        <div class="confirm_msg">${successMessage}</div>
    </c:if>
    <jsp:doBody />
</div>