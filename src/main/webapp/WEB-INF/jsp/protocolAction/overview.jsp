<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${protocolAction.id != null && protocolAction.experiment.auditInfo.creator != currentUser.loginName}" />
<s:if test="${protocolAction.id != null}">
    <c:set var="formAction" value="ajax/protocolAction/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="protocolAction/management/save"/>
</s:else>

<protExpress:tabPane paneTitleKey="protocolAction.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="protocolAction.sequenceNumber" key="protocolAction.sequenceNumber" size="40" tabindex="2" disabled="${isReadOnly}" />
        <c:if test="${protocolAction.id != null}">
            <tr>
                <td class="tdLabel"><s:label cssClass="label" name="protocolAction.protocol.name" key="protocolAction.protocolName" ></s:label></td>
            </tr>
            <tr>
                <td class="tdLabel"><s:label cssClass="label" name="protocolAction.protocol.type.displayName" key="protocolAction.protocolType" ></s:label></td>
            </tr>
            <tr>
                <c:choose>
                    <c:when test="${potentialPredecessors != null}">
                        <s:select
                        name="protocolAction.predecessors"
                        key="protocolAction.potentialPredecessors"
                        list="potentialPredecessors"
                        listKey="id"
                        listValue="id"
                        headerKey=""
                        multiple="true"
                        tabindex="3" />
                    </c:when>
                    <c:otherwise>
                        <td colspan="2"><fmt:message key="protocolAction.noPredecessors" /></td>
                    </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:if>
        <c:if test="${protocolAction.id == null}">
            <jsp:include page="/WEB-INF/jsp/protocolAction/ajaxSelectProtocol.jsp" />
        </c:if>
        <s:hidden name="protocolAction.id" />
        <s:hidden name="experimentId" />
    </s:form>
    <c:if test="${protocolAction.id == null}">
        <c:url var="updateListUrl" value="/ajax/protocolAction/management/retrieveProtocols/xmlProtocolList.action" />
        <ajax:select baseUrl="${updateListUrl}" source="overviewForm_protocolName" target="overviewForm_protocolId" eventType="" var="ajaxSelect"
            parameters="protocolName={overviewForm_protocolName}" emptyOptionName="-- No Protocols Found --"
            preFunction="initProgress" postFunction="resetProgress" executeOnLoad="${protocolId != null}" />
    </c:if>
    <div class="actions">
        <c:url value="/experiment/management/load.action" var="cancelUrl">
            <c:param name="experiment.id" value="${protocolAction.experiment.id}" />
            <c:param name="initialTab" value="protocolActions" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="8"><fmt:message key="cancel" /></a>

        <s:if test="${protocolAction.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:if>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>