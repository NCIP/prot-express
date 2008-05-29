<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>


<s:iterator id="input" value="newInputs" status="e">
    <tr>
        <td class="alignright">${e.index + 1}</td>
        <td class="title"><s:textfield name="newInputs[%{#e.index}].name" value="%{name}" required="true"/></td>
        <td><s:textfield name="newInputs[%{#e.index}].dataFileURL" value="%{dataFileURL}"/></td>
        <td><s:textarea name="newInputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
        <td class="action">
            <s:if test="newInputs.size > 1">
                <c:url var="deleteInputUrl" value="/notYetImplemented.html">
                    <c:param name="inputId" value="${e.index}" />
                </c:url>
                <a href="${deleteInputUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.addinputs.icon.deletenewinput.alt" />" /></a>
            </s:if>
    </tr>
</s:iterator>
