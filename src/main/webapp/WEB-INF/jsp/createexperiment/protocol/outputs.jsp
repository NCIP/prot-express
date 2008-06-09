<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<s:form id="protocolApplicationOutputsForm" method="post">
    <div class="searchresults" >
        <div id="divInputOutput">
            <table class="newdata2">
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.count" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.name" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.filename" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.notes" /></th>
                    <th><fmt:message key="protexpress.page.createnewexperiment.addoutputs.column.action" /></th>
                </tr>
                <s:iterator id="output" value="protocolOutputs" status="e">
                <tr>
                    <td class="alignright">${e.index + 1}</td>
                    <td class="title"><s:textfield name="protocolOutputs[%{#e.index}].name" value="%{name}" required="true"/></td>
                    <td><s:textfield name="protocolOutputs[%{#e.index}].dataFileURL" value="%{dataFileURL}"/></td>
                    <td><s:textarea name="protocolOutputs[%{#e.index}].notes" value="%{notes}" rows="2" cols="20" cssStyle="width:99%; height:40px;"  ></s:textarea></td>
                    <td class="action">
                        <s:if test="protocolOutputs.size > 1">
                            <c:url var="deleteOutputUrl" value="/notYetImplemented.html">
                                <c:param name="outputId" value="${e.index}" />
                            </c:url>
                            <a href="${deleteOutputUrl}"><img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.addoutputs.icon.deletenewoutput.alt" />" /></a>
                        </s:if>
                    </td>
                </tr>
                </s:iterator>
                <tr>
                    <td colspan="5">
                        <del class="btnwrapper">
                            <ul id="btnrow2" style="float:right; margin-right:0">
                                <li>
                                    <s:url id="actionUrlAddOutput" value="/createExperiment/protocols/outputs/addNewOutput.action"/>
                                    <a href="javascript:submitForm('${actionUrlAddOutput}', 'protocolApplicationOutputsForm');" class="btn" onclick="this.blur();">
                                        <span class="btn_img"><span class="addrow"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.button.addanotheroutput" /></span></span>
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

