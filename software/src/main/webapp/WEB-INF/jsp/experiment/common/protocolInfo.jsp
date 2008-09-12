<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div class="twocoltable">
    <table class="form">
        <tr>
            <td class="value">
                <protExpress:textfield formName="${formName}" name="${nameProtocolName}" key="protexpress.protocol.name"  maxlength="200" labelposition="left"/>
            </td>
        </tr>
        <tr>
           <td class="value">
                 <protExpress:textarea formName="${formName}" name="${nameProtocolDescription}" key="protexpress.protocol.description" labelposition="left"/>
            </td>
        </tr>
    </table>
</div>
<div class="twocoltable">
    <table class="form" >
        <tr>
           <td class="value">
                 <protExpress:textfield formName="${formName}" name="${nameProtocolSoftware}" key="protexpress.protocol.software" maxlength="200" labelposition="left"/>
            </td>
        </tr>
        <tr>
           <td class="value">
                 <protExpress:textfield formName="${formName}" name="${nameProtocolInstrument}" key="protexpress.protocol.instrument" maxlength="200" labelposition="left"/>
            </td>
        </tr>
        <tr>
           <td class="value">
                 <protExpress:textarea formName="${formName}" name="${nameProtocolNotes}" key="protexpress.protocol.notes" labelposition="left"/>
            </td>
        </tr>
    </table>
</div>
<div class="clear"/>