<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<jsp:include page="/WEB-INF/jsp/createexperiment/experimentProtocolHeader.jsp" />
<div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.info" /></p></div>
<h3><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.title" /></h3>
<fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.protocoldetailstitle" /></legend>
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
                <td class="value">${protocolApplication.protocol.notes}</td>
            </tr>
        </table>
    </div>
</fieldset>
<fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.inputs" /></legend>
    <!--Input List-->
    <div class="searchresults" style="border-bottom:0;">
        <table class="newdata3">
            <s:if test="%{protocolApplication.inputs.size() == 0}">
                <tr>
                    <td class="label_left">
                        <fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.inputs.nonefound" />
                    </td>
            </s:if>
            <s:else>
                <tr>
                    <th><fmt:message key="protexpress.input.name" /></th>
                    <th><fmt:message key="protexpress.input.filename" /></th>
                    <th><fmt:message key="protexpress.page.input.notes" /></th>
                </tr>
                <c:forEach items="${protocolApplication.inputs}" var="input">
                    <tr>
                        <td class="title">${input.name}</td>
                        <td>${input.dataFileURL}</td>
                        <td>${input.additionalInfo}</td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <!--/Input List-->
</fieldset>
<fieldset>
    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.outputs" /></legend>
    <!--Output List-->
    <div class="searchresults" style="border-bottom:0;">
        <table class="newdata3">
            <s:if test="%{protocolApplication.outputs.size() == 0}">
                <tr>
                    <td class="label_left">
                        <fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.outputs.nonefound" />
                    </td>
            </s:if>
            <s:else>
                <tr>
                    <th><fmt:message key="protexpress.output.name" /></th>
                    <th><fmt:message key="protexpress.output.filename" /></th>
                    <th><fmt:message key="protexpress.output.notes" /></th>
                </tr>
                <c:forEach items="${protocolApplication.outputs}" var="output">
                    <tr>
                        <td class="title">${output.name}</td>
                        <td>${output.dataFileURL}</td>
                        <td>${output.additionalInfo}</td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <!--/Output List-->
</fieldset>
<div class="actionsrow">
    <del class="btnwrapper">
        <ul id="btnrow2">
            <li>
                <c:url var="experimentProtocolEditUrl" value="/notYetImplemented.html">
                    <c:param name="protocolApplication.id" value="${protocolApplication.id}" />
                </c:url>
                <c:url var="experimentSummaryUrl" value="/createExperiment/experimentSummary.action">
                    <c:param name="experimentId" value="${experiment.id}" />
                </c:url>
                <c:url var="addAnotherProtocolUrl" value="/createExperiment/manageProtocols/addNewProtocol.action">
                    <c:param name="experimentId" value="${experiment.id}" />
                </c:url>
                <a href="${experimentProtocolEditUrl}" class="btn" style="text-decoration:none" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="save"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.button.edit" /></span>
                    </span>
                </a>
            </li>
            <li>
                <a href="${addAnotherProtocolUrl}" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="saverepeat"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.button.addanotherprotocol" /></span>
                    </span>
                </a>
            </li>
            <li>
                <a href="${experimentSummaryUrl}" class="btn" onclick="this.blur();">
                    <span class="btn_img">
                        <span class="next"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.button.experimentsummary" /></span>
                    </span>
                </a>
            </li>
        </ul>
    </del>
    <div class="clear"/>
</div>
<jsp:include page="/WEB-INF/jsp/createexperiment/experimentProtocolFooter.jsp" />
