<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<c:url var="addNewOutputUrl" value="${addNewOutputUrlTarget}" />

<div id="divManageOutputs" class="searchresults">
    <table class="newdata2">
        <tr>
            <th class="alignright"><fmt:message key="protexpress.page.manageoutputs.column.count" /></th>
            <th><fmt:message key="protexpress.page.manageoutputs.column.name" /></th>
            <th><fmt:message key="protexpress.page.manageoutputs.column.filename" /></th>
            <th><fmt:message key="protexpress.page.manageoutputs.column.notes" /></th>
            <th><fmt:message key="protexpress.page.manageoutputs.column.action" /></th>
        </tr>

        <s:iterator id="output" value="protocolApplication.outputs" status="e">
            <tr>
                <td class="alignright">${e.index + 1}</td>
                <td class="title">
                     <protExpress:textfield formName="${formId}" name="protocolApplication.outputs[${e.index}].name"
                                            nameAlias="protocolApplication_outputs_${e.index}__name" maxlength="200"
                                            readonly="%{attribReadOnly}"  />
                </td>
                <td>
                    <protExpress:textfield formName="${formId}" name="protocolApplication.outputs[${e.index}].dataFileURL"
                                            nameAlias="protocolApplication_outputs_${e.index}__dataFileURL" maxlength="200"
                                            readonly="%{attribReadOnly}"  />
                </td>
                <td>
                    <protExpress:textarea formName="${formId}" name="protocolApplication.outputs[${e.index}].notes"
                                            nameAlias="protocolApplication_outputs_${e.index}__notes" maxlength="200"
                                            rows="2" cols="20" readonly="%{attribReadOnly}" style="height:40px;" />
                </td>

                <td class="action">
                    <c:if test="${fn:length(protocolApplication.outputs) > 1}">
                        <c:url var="deleteOutputUrl" value="${deleteOutputUrlTarget}" >
                            <c:param name="deleteIndex" value="${e.index}" />
                        </c:url>
                        <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${deleteOutputUrl}'); this.blur(); return false;">
                            <img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.manageoutputs.icon.deleteoutput.alt" />" />
                        </a>
                    </c:if>
                </td>
            </tr>
        </s:iterator>
        <tr>
            <td colspan="6" align="left">
                <del class="btnwrapper">
                    <ul id="btnrow2">
                        <protExpress:button style="addrow" textKey="protexpress.page.manageoutputs.button.addadnotheroutput" id="addOutput" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${addNewOutputUrl}'); this.blur(); return false;"/>
                    </ul>
                </del>
            </td>
        </tr>
    </table>
</div>

