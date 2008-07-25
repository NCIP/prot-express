<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<head><s:head theme="ajax" /></head>
<title><fmt:message key="protexpress.page.createnewexperiment.overview.caption" /></title>

<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/home/home.action" />"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="<c:url value="/createExperiment/reloadCreateNewExperiment.action" />" class="selected"><fmt:message key="protexpress.breadcrumb.createnewexperiment" /></a>
    </div>
    <!-- /Breadcrumb -->
    <!-- Page Help -->
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.createnewexperiment.overview.title" /></h1>
        <div class="fadebox">
            <div id="processflow">
                <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.identifyexperiment" /></div>
                <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt="" /></div>
                <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.addprotocols" /></div>
                <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt="" /></div>
                <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.review" /></div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
            <div class="fadebox">
                <h2><fmt:message key="protexpress.page.createnewexperiment.steps.review" /></h2>
                <div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.info" /></p></div>
            </div>
            <h3>${experiment.name}</h3>

            <fieldset>
                <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.identificationtitle" />&nbsp;[<a href="<c:url value="/createExperiment/reloadCreateNewExperiment.action" />"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.editexperimentsection" /></a>]</legend>
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
                <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocolstitle" />&nbsp;[<a href="<c:url value="/createExperiment/protocols/add/addAnotherProtocol.action"/>"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.addeditprotocolssection"/></a>]</legend>
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
                                        <c:url var="protocolViewUrl" value="/createExperiment/protocols/manage/reviewProtocol.action">
                                            <c:param name="protocolApplicationId" value="${protApp.id}" />
                                        </c:url>
                                        <c:url var="protocolEditUrl" value="/createExperiment/protocols/manage/editProtocol.action">
                                            <c:param name="protocolApplicationId" value="${protApp.id}" />
                                        </c:url>
                                        <c:choose>
                                            <c:when test="${itemCount.count % 2 == 0}"><tr class="even"></c:when>
                                            <c:otherwise><tr class="odd"></c:otherwise>
                                        </c:choose>
                                            <td class="alignright">${itemCount.count}.</td>
                                            <td class="title"><a href="${protocolViewUrl}">${protApp.protocol.name}</a></td>
                                            <td>${fn:length(protApp.inputs)}</td>
                                            <td>${fn:length(protApp.outputs)}</td>
                                            <td  class="action">
                                                <a href="${protocolEditUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.icon.edit.alt" />" /></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:forEach>
                            </s:else>
                        </tbody>
                    </table>
                </div>
            </fieldset>
            <div class="actionsrow">
                <del class="btnwrapper">
                    <ul id="btnrow2">
                        <li>
                            <c:url var="homeUrl" value="/home/home.action" />
                            <a href="${homeUrl}" class="btn" onclick="this.blur();">
                                <span class="btn_img">
                                    <span class="saveconfirm"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.button.finished" /></span>
                                </span>
                            </a>
                        </li>
                        <li>
                            <c:url var="editUrl" value="/viewExperiment/experiment/load.action">
                                <c:param name="experimentId" value="${experiment.id}" />
                            </c:url>
                            <a href="${editUrl}" class="btn" onclick="this.blur();">
                                <span class="btn_img">
                                    <span class="saverepeat"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.button.repeat" /></span>
                                </span>
                            </a>
                       </li>
                    </ul>
                </del>
            </div>
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
