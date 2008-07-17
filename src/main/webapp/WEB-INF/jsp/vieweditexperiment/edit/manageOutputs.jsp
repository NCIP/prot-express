<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:set var="formId" value="manageOutputsForm" />
<c:set var="divId" value="detail-content" />

<c:url var="cancelUrl" value="/ajax/editExperiment/protocolApplication/load.action">
    <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    <c:param name="experimentRunId" value="${protocolApplication.experimentRun.id}" />
    <c:param name="experimentId" value="${protocolApplication.experimentRun.experiment.id}" />
</c:url>
<c:url var="saveUrl" value="/ajax/editExperiment/protocolApplication/updateOutputs.action" />
<c:url var="addNewOutputUrl" value="/ajax/editExperiment/protocolApplication/addNewOutput.action" />

<h3><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.caption" /></h3>

<s:form id="manageOutputsForm" action="/ajax/editExperiment/protocolApplication/addNewOutput.action" method="post">
    <fieldset>
        <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.addnewoutputstitle" /></legend>
        <div class="searchresults">
            <table class="newdata2">
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.column.count" /></th>
                    <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.column.name" /></th>
                    <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.column.filename" /></th>
                    <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.column.notes" /></th>
                    <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.outputs.column.action" /></th>
                </tr>

                <s:iterator id="output" value="protocolApplication.outputs" status="e">
                    <tr>
                        <td class="alignright">${e.index + 1}</td>
                        <td class="title"><s:textfield name="protocolApplication.outputs[%{#e.index}].name" value="%{name}" required="true" cssStyle="width:99%"/></td>
                        <td><s:textfield name="protocolApplication.outputs[%{#e.index}].dataFileURL" value="%{dataFileURL}" cssStyle="width:99%"/></td>
                        <td><s:textarea name="protocolApplication.outputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
                        <td class="action">
                            <c:if test="${fn:length(protocolApplication.outputs) > 0}">
                                <c:url var="deleteOutputUrl" value="/ajax/editExperiment/protocolApplication/deleteOutput.action" >
                                    <c:param name="deleteIndex" value="${e.index}" />
                                </c:url>
                                <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${deleteOutputUrl}'); this.blur(); return false;">
                                    <img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.addoutputs.icon.deletenewoutput.alt" />" />
                                </a>
                            </c:if>
                        </td>
                    </tr>
                </s:iterator>
                <tr>
                    <td colspan="5">
                        <del class="btnwrapper">
                            <ul id="btnrow2" style="float:right; margin-right:0">
                                <protExpress:button style="add_output" textKey="protexpress.page.editprotocolapplicationdetails.outputs.button.addanotheroutput" id="addOutput"
                                onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${addNewOutputUrl}'); this.blur(); return false;"/>
                            </ul>
                        </del>
                    </td>
                </tr>
            </table>
        </div>
    </fieldset>
</s:form>

<protExpress:buttonRow>
    <protExpress:button style="cancel" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.cancel" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', '${divId}', true); this.blur(); return false;"/>
    <protExpress:button style="save" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.save" id="save" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${saveUrl}'); this.blur(); return false;"/>
</protExpress:buttonRow>


