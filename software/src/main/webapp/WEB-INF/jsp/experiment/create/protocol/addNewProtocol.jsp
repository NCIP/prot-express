<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!-- TABS -->
<c:url var="addNewProtocolUrl" value="/ajax/createExperiment/protocols/add/addNewProtocol.action" />
<c:url var="selectExistingProtocolUrl" value="/ajax/createExperiment/protocols/add/selectExistingProtocol.action" />
<div class="tabs">
    <a href="javascript://noop/" class="selected" onclick="ProtExpress.loadDiv('${addNewProtocolUrl}', 'divAjaxBody', true);">
        <span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.addnewprotocol" /></span>
    </a>
    <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${selectExistingProtocolUrl}', 'divAjaxAddOrSelectProtocolBody', true);">
        <span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.selectexistingprotocol" /></span>
    </a>
</div>
<!-- /TABS -->

<s:form id="addNewProtocolForm" action="/ajax/createExperiment/protocols/add/save.action" method="post">

    <!-- Protocol Info -->
    <c:set var="formName" value="addNewProtocolForm" />
    <c:set var="nameProtocolName" value="protocol.name" />
    <c:set var="nameProtocolDescription" value="protocol.description" />
    <c:set var="nameProtocolSoftware" value="protocol.software" />
    <c:set var="nameProtocolInstrument" value="protocol.instrument" />
    <c:set var="nameProtocolNotes" value="protocol.notes" />
    <%@ include file="/WEB-INF/jsp/experiment/common/protocolInfo.jsp"%>
    <!-- /Protocol Info -->

    <c:url var="cancelUrl" value="/ajax/createExperiment/reloadExperiment.action" />
    <c:url var="saveAndViewExperimentSummaryUrl" value="/ajax/createExperiment/viewExperimentSummary.action" />
    <protExpress:buttonRow>
        <protExpress:button style="cancel" textKey="protexpress.page.createnewexperiment.addnewprotocol.button.back" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', 'divAjaxBody', true);"/>
        <protExpress:button style="savecontinue" textKey="protexpress.page.createnewexperiment.addnewprotocol.button.continue" id="save" onclick="ProtExpress.submitAjaxForm('addNewProtocolForm', 'divAjaxBody'); return false;"/>
        <protExpress:button style="next" textKey="protexpress.page.createnewexperiment.addnewprotocol.button.viewexperimentsummary" id="next" onclick="ProtExpress.submitAjaxFormToUrl('addNewProtocolForm', 'divAjaxBody', '${saveAndViewExperimentSummaryUrl}'); this.blur(); return false;" />
    </protExpress:buttonRow>
</s:form>






