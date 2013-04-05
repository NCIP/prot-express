<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

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
                <td class="value">${protocol.name}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.description" />:</td>
                <td class="value">${protocol.description}</td>
            </tr>
        </table>
    </div>
    <div class="twocoltable">
        <table class="form">
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.software" />:</td>
                <td class="value">${protocol.software}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.instrument" />:</td>
                <td class="value">${protocol.instrument}</td>
            </tr>
            <tr>
                <td class="label"><fmt:message key="protexpress.protocol.notes" />:</td>
                <td class="value">${protocolApplication.notes}</td>
            </tr>
        </table>
    </div>
</fieldset>
