<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="twocoltable">
    <table class="form">
        <tr>
            <td class="label"><span class="required">*</span>&nbsp;<fmt:message key="protexpress.protocol.name" />:</td>
            <td class="value">
                <protExpress:textfield formName="${formName}" name="${nameProtocolName}" maxlength="200" labelposition="left"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.protocol.description" />:</td>
            <td class="value">
                <protExpress:textarea formName="${formName}" name="${nameProtocolDescription}" labelposition="left"/>
            </td>
        </tr>
    </table>
</div>
<div class="twocoltable">
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.protocol.software" />:</td>
            <td class="value">
                <protExpress:textfield formName="${formName}" name="${nameProtocolSoftware}" maxlength="200" labelposition="left"/>
            </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.protocol.instrument" />:</td>
             <td class="value">
                <protExpress:textfield formName="${formName}" name="${nameProtocolInstrument}" maxlength="200" labelposition="left"/>
             </td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.protocol.notes" />:</td>
             <td class="value">
                <protExpress:textarea formName="${formName}" name="${nameProtocolNotes}" labelposition="left"/>
             </td>
        </tr>
    </table>
</div>
<div class="clear"/>