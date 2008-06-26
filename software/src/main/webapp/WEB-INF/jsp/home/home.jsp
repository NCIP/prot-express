<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<title><fmt:message key="protexpress.page.home.caption" /></title>
<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/home/home.action"/>" class="selected"><fmt:message key="protexpress.breadcrumb.home" /></a>
    </div>
    <!-- /Breadcrumb -->

    <!-- Page Help -->
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->

    <div class="padme8">
        <!-- Add Content Here -->
        <h1><fmt:message key="protexpress.page.home.title" /></h1>
        <p class="homeintro"><fmt:message key="protexpress.page.home.introtext" /></p>
        <!-- Big Buttons -->
        <div class="home_buttons">
            <h2><fmt:message key="protexpress.page.home.actionchoice" /></h2>

            <c:url var="createExperimentUrl" value="/createExperiment/createNewExperiment.action" />
            <c:url var="searchProtexpressUrl" value="/search/loadSearch.action" />

            <div id="btn_home_create">
                <a href="${createExperimentUrl}" id="btn_home_create_t"><fmt:message key="protexpress.page.home.createnewexperiment" /></a>
            </div>
            <div id="btn_home_search">
                <a href="${searchProtexpressUrl}" id="btn_home_search_t"><fmt:message key="protexpress.page.home.search" /></a>
            </div>
            <div class="clear"></div>
        </div>
        <!-- /Big Buttons -->
        <!-- My Experiments -->
        <div class="myexperiments">
            <h2><fmt:message key="protexpress.page.home.recentexperiments" /></h2>
            <table class="newdata3">
                <tbody>
                    <s:if test="%{recentExperiments.size() == 0}">
                        <tr>
                            <td class="label_left">
                                <fmt:message key="protexpress.page.home.recentexperiments.nonefound" />&nbsp;&nbsp;<a href="${createExperimentUrl}"><fmt:message key="protexpress.page.home.createnewexperiment" /></a>
                            </td>
                        </tr>
                    </s:if>
                    <s:else>
                        <tr>
                            <th><fmt:message key="protexpress.page.home.recentexperiments.column.experimentname" /></th>
                            <th><fmt:message key="protexpress.page.home.recentexperiments.column.description" /></th>
                            <th><fmt:message key="protexpress.page.home.recentexperiments.column.dateandtime" /></th>
                            <th class="action"><fmt:message key="protexpress.page.home.recentexperiments.column.status" /></th>
                            <th class="action"><fmt:message key="protexpress.page.home.recentexperiments.column.edit" /></th>
                            <th class="action"><fmt:message key="protexpress.page.home.recentexperiments.column.download" /></th>
                        </tr>
                        <c:forEach items="${recentExperiments}" var="experiment">
                            <c:url var="viewExperimentDetailsUrl" value="/viewExperiment/experiment/load.action">
                                <c:param name="experimentId" value="${experiment.id}" />
                            </c:url>
                            <c:url var="editExperimentDetailsUrl" value="/editExperiment/experiment/load.action">
                                <c:param name="experimentId" value="${experiment.id}" />
                            </c:url>
                            <c:url var="experimentDownloadUrl" value="/notYetImplemented.html">
                                <c:param name="experiment.id" value="${experiment.id}" />
                            </c:url>
                            <tr>
                                <td><a href="${viewExperimentDetailsUrl}">${experiment.name}</a></td>
                                <td>${experiment.description}</td>
                                <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${experiment.auditInfo.lastModifiedDate.time}" /></td>
                                <td class="action">
                                     <c:choose>
                                        <c:when test="${statusCompleted}">
                                            <span title="Complete">
                                                <img src="<c:url value="/images/ico_check.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.complete.alt" />" />
                                            </span>
                                        </c:when>
                                        <c:otherwise>
                                            <span title="Incomplete">
                                                <img src="<c:url value="/images/ico_asterisk.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.incomplete.alt" />" />
                                            </span>
                                        </c:otherwise>
                                    </c:choose>
                                  </td>
                                <td class="action">
                                    <a href="${editExperimentDetailsUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.edit.alt" />" /></a>
                                </td>
                                <td class="action">
                                    <c:if test="${statusCompleted}">
                                        <a href="${experimentDownloadUrl}"><img src="<c:url value="/images/ico_xar.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.download.alt" />" /></a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </s:else>
                </tbody>
            </table>
        </div>
        <!-- /My Experiments -->
    </div>
    <!-- /Add Content Here -->
</body>
