<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<fieldset>
    <c:url var="experimentProtocolEditUrl" value="/ajax/createExperiment/protocols/manage/editProtocol.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" ></c:param>
    </c:url>
    <legend>
        <fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.protocoldetailstitle" />
        [<a href="javascript://noop/" onclick="ProtExpress.loadDiv('${experimentProtocolEditUrl}', 'divAjaxBody', true);" ><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.edittext"/></a>]
    </legend>

    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.name" />:</td>
                <td class="value">${protocolApplication.protocol.name}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.description" />:</td>
                <td class="value">${protocolApplication.protocol.description}</td>
            </tr>
        </table>
    </div>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.software" />:</td>
                <td class="value">${protocolApplication.protocol.software}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.instrument" />:</td>
                <td class="value">${protocolApplication.protocol.instrument}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.notes" />:</td>
                <td class="value">${protocolApplication.notes}</td>
            </tr>
        </table>
    </div>
</fieldset>
