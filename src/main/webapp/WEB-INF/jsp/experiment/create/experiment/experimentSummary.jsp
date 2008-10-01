<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<head><s:head theme="ajax" /></head>
<title><fmt:message key="protexpress.page.createnewexperiment.overview.caption" /></title>

<body>
    <protExpress:breadCrumbTrial>
          <protExpress:breadCrumb href="/ajax/home/home.action" textKey="protexpress.breadcrumb.home" />
          <protExpress:breadCrumb cssClass="selected" href="/ajax/createExperiment/reloadExperiment.action" text="${experiment.name}" insertSymbol="false"/>
      </protExpress:breadCrumbTrial>

    <!-- Page Help -->
        <protExpress:pageHelp/>
    <!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.createnewexperiment.overview.title" /></h1>
        <div class="fadebox">
            <protExpress:processFlow>
                <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.identifyexperiment" insertNextStepIndicator="true"/>
                <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addprotocols" insertNextStepIndicator="true"/>
                <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewexperiment" selected="true" />
            </protExpress:processFlow>

            <div class="fadebox">
                <h2><fmt:message key="protexpress.page.createnewexperiment.steps.reviewexperiment" /></h2>
                <div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.info" /></p></div>
            </div>
            <h3>${experiment.name}</h3>

            <fieldset>
                <c:url var="reloadExperimentUrl" value="/ajax/createExperiment/reloadExperiment.action" />
                <legend>
                    <fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.identificationtitle" />&nbsp;
                    [<a href="javascript://noop/" onclick="ProtExpress.loadDiv('${reloadExperimentUrl}', 'divAjaxBody', true);"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.editexperimentsection" /></a>]
                </legend>
                <fieldset class="leftfield_wide">
                    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.overviewtitle" /></legend>
                    <table class="form">
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.name" />:<br /><p>${experiment.name}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.description" />:<br /><p>${experiment.description}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.hypothesis" />:<br /><p>${experiment.hypothesis}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.url" />:<br /><p><a href="${experiment.url}" target="_blank">${experiment.url}</a></p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.notes" />:<br /><p>${experiment.notes}</p></td></tr>
                    </table>
                </fieldset>
                <fieldset class="rightfield_thin">
                    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.dateperformedtitle" /></legend>
                    <table class="form">
                        <tr><td class="label_left">${experiment.datePerformed}</td></tr>
                    </table>
                </fieldset>
                <fieldset class="rightfield_thin">
                    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.contacttitle" /></legend>
                    <table class="form">
                        <tr><td class="label_left"><fmt:message key="protexpress.contact.firstname" />:<br /><p>${experiment.contactPerson.firstName}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.contact.lastname" />:<br /><p>${experiment.contactPerson.lastName}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.contact.email" />:<br /><p>${experiment.contactPerson.email}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.contact.notes" />:<br /><p>${experiment.contactPerson.notes}</p></td></tr>
                    </table>
                </fieldset>
                <div class="clear"></div>
            </fieldset>
            <fieldset>
                <c:url var="addAnotherProtocolUrl" value="/ajax/createExperiment/protocols/add/addAnotherProtocol.action" />
                <legend>
                    <fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocolstitle" />&nbsp;
                    [<a href="javascript://noop/" onclick="ProtExpress.loadDiv('${addAnotherProtocolUrl}', 'divAjaxBody', true);"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.addeditprotocolssection"/></a>]
                </legend>
                <div class="searchresults" style="border-bottom:0;">
                    <table class="newdata3">
                        <tbody>
                            <s:if test="%{experiment.experimentRun.protocolApplications.size() == 0}">
                                <tr><td class="label_left"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.noprotocolsfound" /></td></tr>
                            </s:if>
                            <s:else>
                                <tr>
                                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocols.column.count" /></th>
                                    <th><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocols.column.protocolname" /></th>
                                    <th><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocols.column.inputcount" /></th>
                                    <th><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocols.column.outputcount" /></th>
                                    <th  class="action"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocols.column.action" /></th>
                                </tr>
                                <c:forEach items="${experiment.experimentRuns}" var="expRun" varStatus="itemCount">
                                    <c:forEach items="${expRun.protocolApplications}" var="protApp">
                                        <c:url var="protocolViewUrl" value="/ajax/createExperiment/protocols/manage/viewProtocolSummary.action">
                                            <c:param name="protocolApplicationId" value="${protApp.id}" />
                                        </c:url>
                                        <c:url var="protocolEditUrl" value="/ajax/createExperiment/protocols/manage/editProtocol.action">
                                            <c:param name="protocolApplicationId" value="${protApp.id}" />
                                        </c:url>
                                        <c:choose>
                                            <c:when test="${itemCount.count % 2 == 0}"><tr class="even"></c:when>
                                            <c:otherwise><tr class="odd"></c:otherwise>
                                        </c:choose>
                                            <td class="alignright">${itemCount.count}.</td>
                                            <td class="title">
                                                <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${protocolViewUrl}', 'divAjaxBody', true);">${protApp.protocol.name}</a></td>
                                            <td>${fn:length(protApp.inputs)}</td>
                                            <td>${fn:length(protApp.outputs)}</td>
                                            <td  class="action">
                                                <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${protocolEditUrl}', 'divAjaxBody', true);"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.icon.edit.alt" />" /></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:forEach>
                            </s:else>
                        </tbody>
                    </table>
                </div>
            </fieldset>
            <c:url var="homeUrl" value="/ajax/home/home.action" />
            <c:url var="repeatExperimentRunUrl" value="/createExperiment/repeat.action" />
            <protExpress:buttonRow>
                <protExpress:button style="saveconfim" textKey="protexpress.page.createnewexperiment.reviewexperiment.button.finished" id="saveconfirm" onclick="ProtExpress.loadDiv('${homeUrl}', 'divAjaxBody', true); return false;"/>
                <protExpress:button style="copy" textKey="protexpress.page.createnewexperiment.reviewexperiment.button.repeat" id="save" href="${repeatExperimentRunUrl}"/>
            </protExpress:buttonRow>

        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
