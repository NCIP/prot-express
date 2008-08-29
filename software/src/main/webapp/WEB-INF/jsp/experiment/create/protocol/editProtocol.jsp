<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />

<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.editprotocol.info" /></p></div>
<h3><fmt:message key="protexpress.page.createnewexperiment.editprotocol.title" /></h3>
<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>
<s:form id="protocolApplicationForm" method="post">
  <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}"/>

  <fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.editprotocol.protocoldetailstitle" /></legend>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.protocol.name" />:</td>
                <td class="value"><s:textfield name="protocol.name"/></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.description" />:</td>
                <td class="value"><s:textarea name="protocol.description" rows="4"></s:textarea></td>
            </tr>
        </table>
    </div>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.software" />:</td>
                <td class="value"><s:textfield name="protocol.software"/></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.instrument" />:</td>
                <td class="value"><s:textfield name="protocol.instrument"/></td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.notes" />:</td>
                <td class="value"><s:textarea name="protocolApplication.notes" rows="4"></s:textarea></td>
            </tr>
        </table>
    </div>
</fieldset>
</s:form>
<fieldset>
    <c:url var="manageInputsUrl" value="/ajax/createExperiment/protocols/inputs/update.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    </c:url>
    <legend>
        <fmt:message key="protexpress.page.createnewexperiment.editprotocol.inputs" />
        [<a href="javascript://noop/" onclick="ProtExpress.loadDiv('${manageInputsUrl}', 'divAjaxBody', true);"><fmt:message key="protexpress.page.createnewexperiment.editprotocol.addedittext"/></a>]
    </legend>
    <!--Input List-->
    <div class="searchresults" style="border-bottom:0;">
        <table class="newdata3">
            <s:if test="%{protocolApplication.inputs.size() == 0}">
                <tr>
                    <td class="label_left">
                        <fmt:message key="protexpress.page.createnewexperiment.editprotocol.inputs.nonefound" />
                    </td>
            </s:if>
            <s:else>
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.editprotocol.inputs.column.count" /></th>
                    <th><fmt:message key="protexpress.input.name" /></th>
                    <th><fmt:message key="protexpress.input.filename" /></th>
                    <th><fmt:message key="protexpress.input.notes" /></th>
                </tr>
                <c:forEach items="${protocolApplication.inputs}" var="input"  varStatus="itemCount">
                    <c:choose>
                        <c:when test="${itemCount.count % 2 == 0}"><tr class="even"></c:when>
                        <c:otherwise><tr class="odd"></c:otherwise>
                    </c:choose>
                        <td class="alignright">${itemCount.count}.</td>
                        <td class="title">${input.name}</td>
                        <td>${input.dataFileURL}</td>
                        <td>${input.notes}</td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <!--/Input List-->
</fieldset>
<fieldset>
    <c:url var="manageOutputsUrl" value="/ajax/createExperiment/protocols/outputs/update.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    </c:url>
    <legend>
        <fmt:message key="protexpress.page.createnewexperiment.editprotocol.outputs" />
        [<a href="javascript://noop/" onclick="ProtExpress.loadDiv('${manageOutputsUrl}', 'divAjaxBody', true);"><fmt:message key="protexpress.page.createnewexperiment.editprotocol.addedittext"/></a>]
    </legend>
    <!--Output List-->
    <div class="searchresults" style="border-bottom:0;">
        <table class="newdata3">
            <s:if test="%{protocolApplication.outputs.size() == 0}">
                <tr>
                    <td class="label_left">
                        <fmt:message key="protexpress.page.createnewexperiment.editprotocol.outputs.nonefound" />
                    </td>
            </s:if>
            <s:else>
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.editprotocol.outputs.column.count" /></th>
                    <th><fmt:message key="protexpress.output.name" /></th>
                    <th><fmt:message key="protexpress.output.filename" /></th>
                    <th><fmt:message key="protexpress.output.notes" /></th>
                </tr>
                <c:forEach items="${protocolApplication.outputs}" var="output" varStatus="itemCount">
                    <c:choose>
                        <c:when test="${itemCount.count % 2 == 0}"><tr class="even"></c:when>
                        <c:otherwise><tr class="odd"></c:otherwise>
                    </c:choose>
                        <td class="alignright">${itemCount.count}.</td>
                        <td class="title">${output.name}</td>
                        <td>${output.dataFileURL}</td>
                        <td>${output.notes}</td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <!--/Output List-->
</fieldset>

<c:url var="saveProtocolApplicationUrl" value="/ajax/createExperiment/protocols/manage/updateProtocol.action" />
<c:url var="saveAndNewProtocolUrl" value="/ajax/createExperiment/protocols/manage/saveAndAddNewProtocol.action"></c:url>
<c:url var="saveAndViewExperimentSummaryUrl" value="/ajax/createExperiment/protocols/manage/saveAndViewExperimentSummary.action" />

<protExpress:buttonRow>
    <protExpress:button style="save" textKey="protexpress.page.createnewexperiment.editprotocol.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('protocolApplicationForm', 'divAjaxBody', '${saveProtocolApplicationUrl}'); this.blur(); return false;" />
    <protExpress:button style="saverepeat" textKey="protexpress.page.createnewexperiment.editprotocol.button.addanotherprotocol" id="saverepeat" onclick="ProtExpress.submitAjaxFormToUrl('protocolApplicationForm', 'divAjaxBody', '${saveAndNewProtocolUrl}'); this.blur(); return false;" />
    <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.editprotocol.button.experimentsummary" id="next" onclick="ProtExpress.submitAjaxFormToUrl('protocolApplicationForm', 'divAjaxBody', '${saveAndViewExperimentSummaryUrl}'); this.blur(); return false;" />
</protExpress:buttonRow>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />

