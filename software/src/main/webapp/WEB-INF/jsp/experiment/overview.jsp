<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<protExpress:tabPane paneTitleKey="experiment.overview">
    <s:form action="ajax/experiment/management/save/overview" id="overviewForm" method="post">
        <s:textfield name="experiment.lsid" key="experiment.lsid" size="40" />
        <s:textfield name="experiment.name" key="experiment.name" size="40" />
        <s:textfield name="experiment.comments" key="experiment.comments" size="40" />
        <s:textfield name="experiment.hypothesis" key="experiment.hypothesis" size="40" />
        <s:textfield name="experiment.url" key="experiment.url" size="40" />
        <s:hidden name="experiment.id" />
    </s:form>
    <div class="actions">
        <a href="<c:url value="/experiment/search/loadSearch.action" />" class="cancel"><fmt:message key="cancel" /></a>
        <s:a onclick="showSubmittingText();" formId="overviewForm" targets="boxinner" theme="ajax" cssClass="save" showLoadingText="false"><fmt:message key="save" /></s:a>
    </div>
</protExpress:tabPane>