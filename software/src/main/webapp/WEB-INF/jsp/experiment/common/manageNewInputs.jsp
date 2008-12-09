<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<c:url var="addNewInputUrl" value="${addNewInputUrlTarget}" />

<div id="divManageInputs" class="searchresults">
    <table class="newdata2">
        <tr>
            <th class="alignright"><fmt:message key="protexpress.page.manageinputs.column.count" /></th>
            <th><fmt:message key="protexpress.page.manageinputs.column.type" /></th>
            <th><fmt:message key="protexpress.page.manageinputs.column.name" /></th>
            <th><fmt:message key="protexpress.page.manageinputs.column.filename" /></th>
            <th><fmt:message key="protexpress.page.manageinputs.column.notes" /></th>
            <th><fmt:message key="protexpress.page.manageinputs.column.action" /></th>
        </tr>

        <s:iterator id="input" value="protocolApplication.inputs" status="e">
            <c:choose>
                <c:when test="${(id != null) && (outputOfProtocolApplication != null)}">
                    <s:set name="attribReadOnly" value="true" />
                    <c:set var="altText" value="Linked Input (Output of another protocol)" />
                    <c:url var="imgInputTypeUrl" value="/images/ico_input_linked.gif" />
                </c:when>
                <c:when test="${(id != null) && (outputOfProtocolApplication == null)}">
                    <s:set name="attribReadOnly" value="false" />
                    <c:set var="altText" value="Existing Input" />
                    <c:url var="imgInputTypeUrl" value="/images/ico_input_existing.gif" />
                </c:when>
                <c:when test="${(id == null) && (outputOfProtocolApplication == null)}">
                    <s:set name="attribReadOnly" value="false" />
                    <c:set var="altText" value="New Input" />
                    <c:url var="imgInputTypeUrl" value="/images/ico_input_new.gif" />
                </c:when>
            </c:choose>
            <tr>
                <td class="alignright">${e.index + 1}</td>
                <td class="action">
                   <protExpress:protocolInputInfo imgInputTypeUrl="${imgInputTypeUrl}" altText="${altText}" inputName="${name}" outputOfProtocolName=" "/>
                </td>
                <td class="title">
                     <protExpress:textfield formName="${formId}" name="protocolApplication.inputs[${e.index}].name"
                                            nameAlias="protocolApplication_inputs_${e.index}__name" maxlength="200" cols="25"
                                            readonly="%{attribReadOnly}"  />
                </td>
                <td>
                    <protExpress:textfield formName="${formId}" name="protocolApplication.inputs[${e.index}].dataFileURL"
                                            nameAlias="protocolApplication_inputs_${e.index}__dataFileURL" maxlength="200" cols="25"
                                            readonly="%{attribReadOnly}"  />
                </td>
                <td>
                    <protExpress:textarea formName="${formId}" name="protocolApplication.inputs[${e.index}].notes"
                                            nameAlias="protocolApplication_inputs_${e.index}__notes" maxlength="200"
                                            rows="2" cols="20" readonly="%{attribReadOnly}" style="height:40px;" />
                </td>
                <td class="action">
                    <c:if test="${fn:length(protocolApplication.inputs) > 1}">
                        <c:url var="deleteInputUrl" value="${deleteInputUrlTarget}" >
                            <c:param name="deleteIndex" value="${e.index}" />
                        </c:url>
                        <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${deleteInputUrl}'); this.blur(); return false;">
                            <img src="<c:url value="/images/ico_delete.gif" />" alt="<fmt:message key="protexpress.page.manageinputs.icon.deleteinput.alt" />" />
                        </a>
                    </c:if>
                </td>
            </tr>
        </s:iterator>
        <tr>
            <td colspan="6" align="left">
                <del class="btnwrapper">
                    <ul id="btnrow2">
                        <protExpress:button style="addrow" textKey="protexpress.page.manageinputs.button.addadnotherinput" id="addInput" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${addNewInputUrl}'); this.blur(); return false;"/>
                    </ul>
                </del>
            </td>
        </tr>
    </table>
</div>

