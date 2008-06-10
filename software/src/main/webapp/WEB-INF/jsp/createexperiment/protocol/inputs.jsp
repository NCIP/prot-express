<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<s:form id="protocolApplicationInputsForm" method="post">
    <s:hidden name="protocolApplicationId" value="%{protocolApplication.id}" />
<div class="searchresults" >
<div id="divInputOutput">
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
            <td class="title"><s:textfield name="protocolApplication.inputs[%{#e.index}].name" value="%{name}" required="true"/></td>
            <td><s:textfield name="protocolApplication.inputs[%{#e.index}].dataFileURL" value="%{dataFileURL}"/></td>
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
        <tr>
            <td colspan="5">
                <del class="btnwrapper">
                    <ul id="btnrow2" style="float:right; margin-right:0">
                        <li>
                            <c:url var="actionUrlAddInput" value="/createExperiment/protocols/inputs/addNewInput.action"/>
                            <a href="javascript:submitForm('${actionUrlAddInput}', 'protocolApplicationInputsForm');" class="btn" onclick="this.blur();">
                                <span class="btn_img"><span class="addrow"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.addanotherinput" /></span></span>
                            </a>
                        </li>
                    </ul>
                </del>
            </td>
        </tr>
    </table>
</div>
</div>
</s:form>