<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<c:set var="isReadOnly" value="${protocolApplication.id != null && protocolApplication.auditInfo.creator != currentUser.loginName}" />
<s:if test="${protocolApplication.id != null}">
    <c:set var="formAction" value="ajax/protocolApplication/management/save/overview"/>
</s:if>
<s:else>
    <c:set var="formAction" value="protocolApplication/management/save"/>
</s:else>
<protExpress:tabPane paneTitleKey="protocolApplication.overview">
    <s:form action="${formAction}" id="overviewForm" method="post" disabled="${isReadOnly}">
        <s:textfield name="protocolApplication.lsid" key="protocolApplication.lsid" size="40" tabindex="1" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.name" key="protocolApplication.name" size="40" tabindex="2" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.actionSequence" key="protocolApplication.actionSequence" size="40" tabindex="3" disabled="${isReadOnly}" />
        <s:textfield name="protocolApplication.activityDate" key="protocolApplication.activityDate" size="40" tabindex="4" disabled="${isReadOnly}" />
        <s:textarea name="protocolApplication.comments" key="protocolApplication.comments" rows="4" cols="37" tabindex="5" disabled="${isReadOnly}" />
        <c:if test="${protocolApplication.id == null}">
            <s:if test="fieldErrors.get('protocolApplication.protocol').size() > 0">
            <tr errorFor="overviewForm_protocolApplication_protocol">
                <td align="center" valign="top" colspan="2"><s:fielderror><s:param>protocolApplication.protocol</s:param></s:fielderror></td>
            </tr>
            </s:if>
            <tr>
                <td class="tdLabel"><label for="overviewForm_protocolId" class="label"><fmt:message key="protocolApplication.protocol" />:</label></td>
                <td>
                    <script type="text/javascript">
                        var timer;
                        var lastSelectedProtocolId = '${protocolId}';
                        function startTimer(event) {
                            if (event.keyCode != 9) {
                                if (timer != null) {
                                    clearTimeout(timer);
                                }
                                timer = setTimeout("triggerAjax()", 750);
                            }
                        }
                        function triggerAjax() {
                            ajaxSelect.execute();
                        }
                        function initProgress() {
                            Element.show('progressMsg');
                        }
                        function resetProgress() {
                            Effect.Fade('progressMsg');
                            setSelectedOption('overviewForm_protocolId', lastSelectedProtocolId);
                        }

                        function setSelectedOption(formId, selectedValue) {
                            var selectBox = document.getElementById(formId);
                             for (var idx = 0; idx < selectBox.options.length; idx++) {
                                if (selectBox.options[idx].value == selectedValue) {
                                    selectBox.options[idx].selected = true;
                                }
                             }
                        }
                        function saveSelectedVal(selectBox) {
                            lastSelectedProtocolId = selectBox.value;
                        }
                    </script>
                    <s:textfield name="protocolName" theme="simple" size="20" tabindex="6" disabled="${isReadOnly}" onkeypress="startTimer(event);" />
                    <span id="progressMsg" style="display:none;"><img alt="Indicator" src="<c:url value="/images/indicator.gif"/>" /> <fmt:message key="loading" /></span><br>
                    <s:select list="#{}" cssStyle="margin-top: 3px; width: 200px;" name="protocolId" theme="simple" tabindex="7"
                        size="10" disabled="${isReadOnly}" value="protocolId.toString()" onchange="saveSelectedVal(this);"/>
                </td>
            </tr>
        </c:if>
        <s:hidden name="protocolApplication.id" />
        <s:hidden name="experimentRunId" />
    </s:form>
    <c:if test="${protocolApplication.id == null}">
        <c:url var="updateListUrl" value="/ajax/protocolApplication/management/retrieveProtocols/xmlProtocolList.action" />
        <ajax:select baseUrl="${updateListUrl}" source="overviewForm_protocolName" target="overviewForm_protocolId" eventType="" var="ajaxSelect"
            parameters="protocolName={overviewForm_protocolName}" emptyOptionName="-- No Protocols Found --"
            preFunction="initProgress" postFunction="resetProgress" executeOnLoad="${protocolId != null}" />
    </c:if>

    <div class="actions">
        <c:url value="/experimentRun/management/load.action" var="cancelUrl">
            <c:param name="experimentRun.id" value="${protocolApplication.experimentRun.id}" />
            <c:param name="initialTab" value="protocolApplications" />
        </c:url>
        <a href="${cancelUrl}" class="cancel" tabindex="8"><fmt:message key="cancel" /></a>

        <s:if test="${isReadOnly}">
            <a href="<c:url value="/notYetImplemented.html"/>" class="save" tabindex="9"><fmt:message key="copy" /></a>
        </s:if>
        <s:elseif test="${protocolApplication.id != null}">
            <a href="javascript:ajaxSubmit('overviewForm', 'selectedtabbox');" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:elseif>
        <s:else>
            <a href="javascript:document.getElementById('overviewForm').submit();" class="save" tabindex="9"><fmt:message key="save" /></a>
        </s:else>
    </div>
</protExpress:tabPane>