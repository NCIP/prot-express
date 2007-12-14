<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

            <s:if test="fieldErrors.get('protocolAction.protocol').size() > 0">
                <tr errorFor="overviewForm_protocolAction_protocol">
                    <td align="center" valign="top" colspan="2"><s:fielderror><s:param>protocolAction.protocol</s:param></s:fielderror></td>
                </tr>
            </s:if>
            <tr>
                <td class="tdLabel"><label for="overviewForm_protocolId" class="label"><fmt:message key="protocolAction.protocol" />:</label></td>
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
