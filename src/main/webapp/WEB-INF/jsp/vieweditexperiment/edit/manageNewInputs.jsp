<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>


<c:set var="formId" value="manageInputsForm" />
<c:set var="divNewInputsId" value="detail-content" />

<c:url var="addNewInputUrl" value="/ajax/editExperiment/protocolApplication/addNewInput.action" />

<fieldset>
    <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.addnewinputstitle" /></legend>
    <div class="searchresults">
        <table class="newdata2">
            <tr>
                <th class="alignright"><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.count" /></th>
                <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.name" /></th>
                <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.filename" /></th>
                <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.notes" /></th>
                <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.action" /></th>
            </tr>

            <s:iterator id="input" value="protocolApplication.inputs" status="e">
                <c:choose>
                    <c:when test="${(id != null) && (outputOfProtocolApplication != null)}"><s:set name="attribReadOnly" value="true" /></c:when>
                    <c:when test="${(id != null) && (outputOfProtocolApplication == null)}"><s:set name="attribReadOnly" value="false" /></c:when>
                    <c:when test="${(id == null) && (outputOfProtocolApplication == null)}"><s:set name="attribReadOnly" value="false" /></c:when>
                </c:choose>
                <tr>
                    <td class="alignright">${e.index + 1}</td>
                    <td class="title"><s:textfield name="protocolApplication.inputs[%{#e.index}].name" value="%{name}" required="true" readonly="%{attribReadOnly}" cssStyle="width:99%" /></td>
                    <td><s:textfield name="protocolApplication.inputs[%{#e.index}].dataFileURL" value="%{dataFileURL}" readonly="%{attribReadOnly}" cssStyle="width:99%"/></td>
                    <td><s:textarea name="protocolApplication.inputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" readonly="%{attribReadOnly}" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
                    <td class="action">
                        <c:if test="${fn:length(protocolApplication.inputs) > 0}">
                            <c:url var="deleteInputUrl" value="/ajax/editExperiment/protocolApplication/deleteInput.action" >
                                <c:param name="deleteIndex" value="${e.index}" />
                            </c:url>
                            <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divNewInputsId}', '${deleteInputUrl}'); this.blur(); return false;">
                                <img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.addinputs.icon.deletenewinput.alt" />" />
                            </a>
                        </c:if>
                    </td>
                </tr>
            </s:iterator>
            <tr>
                <td colspan="5">
                    <del class="btnwrapper">
                        <ul id="btnrow2" style="float:right; margin-right:0">
                            <protExpress:button style="add_input" textKey="protexpress.page.editprotocolapplicationdetails.inputs.button.addanotherinput"
                            id="addInput" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divNewInputsId}', '${addNewInputUrl}'); this.blur(); return false;"/>
                        </ul>
                    </del>
                </td>
            </tr>
        </table>
    </div>
</fieldset>
