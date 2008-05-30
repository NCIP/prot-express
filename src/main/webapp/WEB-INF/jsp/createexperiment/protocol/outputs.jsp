<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>


<s:iterator id="output" value="newOutputs" status="e">
    <tr>
        <td class="alignright">${e.index + 1}</td>
        <td class="title"><s:textfield name="newOutputs[%{#e.index}].name" value="%{name}" required="true"/></td>
        <td><s:textfield name="newOutputs[%{#e.index}].dataFileURL" value="%{dataFileURL}"/></td>
        <td><s:textarea name="newOutputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
        <td class="action">
            <s:if test="newOutputs.size > 1">
                <c:url var="deleteOutputUrl" value="/notYetImplemented.html">
                    <c:param name="outputId" value="${e.index}" />
                </c:url>
                <a href="${deleteOutputUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.addoutputs.icon.deletenewoutput.alt" />" /></a>
            </s:if>
    </tr>
</s:iterator>
