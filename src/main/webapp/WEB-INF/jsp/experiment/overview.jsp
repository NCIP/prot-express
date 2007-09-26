<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type="text/javascript">
function showSubmittingText() {
    document.getElementById('submittingText').style.display = 'block';
    document.getElementById('theForm').style.display = 'none';
}
</script>
<h3><fmt:message key="experiment.overview" /></h3>
<div id="submittingText" style="display: none;">
    <div class="padme5"><fmt:message key="saving" /></div>
</div>
<div id="theForm">
    <s:form action="ajax/experiment/management/save/overview" id="overviewForm" method="post">
        <s:textfield name="experiment.lsid" key="experiment.lsid" size="40" />
        <s:textfield name="experiment.name" key="experiment.name" size="40" />
        <s:textfield name="experiment.comments" key="experiment.comments" size="40" />
        <s:textfield name="experiment.hypothesis" key="experiment.hypothesis" size="40" />
        <s:textfield name="experiment.url" key="experiment.url" size="40" />
        <s:hidden name="experiment.Id" />
    </s:form>
    <div class="actions">
        <a href="<c:url value="/experiment/search/loadSearch.action" />" class="cancel"><fmt:message key="cancel" /></a>
        <s:a onclick="showSubmittingText();" formId="overviewForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false"><fmt:message key="save" /></s:a>
    </div>
</div>