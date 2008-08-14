<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

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
                <td class="title"><s:textfield name="protocolApplication.outputs[%{#e.index}].name" value="%{name}" required="true" readonly="%{attribReadOnly}" cssStyle="width:99%" maxlength="200"/></td>
                <td><s:textfield name="protocolApplication.outputs[%{#e.index}].dataFileURL" value="%{dataFileURL}" readonly="%{attribReadOnly}" cssStyle="width:99%" maxlength="200"/></td>
                <td><s:textarea name="protocolApplication.outputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" readonly="%{attribReadOnly}" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
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
