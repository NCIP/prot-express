<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<table class="newdata2">
    <tr>
        <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.count" /></th>
        <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.name" /></th>
        <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.filename" /></th>
        <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.notes" /></th>
        <th><fmt:message key="protexpress.page.createnewexperiment.addinputs.column.action" /></th>
    </tr>
    <s:iterator id="input" value="protocolApplication.inputs" status="e">
        <tr>
            <td class="alignright">${e.index + 1}</td>
            <td class="title"><s:textfield name="protocolApplication.inputs[%{#e.index}].name" value="%{name}" required="true" cssStyle="width:99%"/></td>
            <td><s:textfield name="protocolApplication.inputs[%{#e.index}].dataFileURL" value="%{dataFileURL}" cssStyle="width:99%"/></td>
            <td><s:textarea name="protocolApplication.inputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
            <td class="action">
                <s:if test="protocolApplication.inputs.size > 1">
                    <c:url var="deleteInputUrl" value="/createExperiment/protocols/inputs/deleteInput.action">
                        <c:param name="deleteIndex" value="${e.index}" />
                    </c:url>
                    <a href="${deleteInputUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.addinputs.icon.deletenewinput.alt" />" /></a>
                </s:if>
            </td>
        </tr>
    </s:iterator>
</table>
