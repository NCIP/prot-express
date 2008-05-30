<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.identificationtitle" />&nbsp;[<a href="<c:url value="/createExperiment/reloadCreateNewExperiment.action" />">Edit</a>]</legend>
                <fieldset class="leftfield_wide">
                    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.overviewtitle" /></legend>
                    <table class="form">
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.name" />:<br /><p>${experiment.name}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.description" />:<br /><p>${experiment.description}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.hypothesis" />:<br /><p>${experiment.hypothesis}</p></td></tr>
                        <tr><td class="label_left"><fmt:message key="protexpress.experiment.url" />:<br /><p>${experiment.url}</p></td></tr>
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
                <legend><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.protocolstitle" />&nbsp;[<a href="experimentcreate.htm">Edit</a>]</legend>
                <div class="searchresults" style="border-bottom:0;">
                    <table class="newdata3">
                        <tbody>
                            <s:if test="%{experimentRun.protocolApplications.size() != 0}">
                                <tr>
                                    <td class="label_left">
                                        No Protocols found.
                                    </td>
                                </tr>
                            </s:if>
                            <s:else>
                                <tr>
                                    <th>Protocol Name</th>
                                    <th># Inputs</th>
                                    <th># Outputs</th>
                                    <th  class="action">Edit</th>
                                </tr>
                                <c:forEach items="${experiment.experimentRuns}" var="expRun">
                                    <c:forEach items="${expRun.protocolApplications}" var="protApp">
                                        <c:url var="protocolEditUrl" value="/notYetImplemented.html">
                                            <c:param name="protocolApplication.id" value="${protApp.id}" />
                                        </c:url>
                                        <tr>
                                            <td>${protApp.protocol.name}</td>
                                            <td>${protApp.protocol.name}</td>
                                            <td>${protApp.protocol.name}</td>
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
                            <c:url var="editUrl" value="/home/home.action" />
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