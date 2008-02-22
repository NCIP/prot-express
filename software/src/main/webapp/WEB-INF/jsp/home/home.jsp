<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/"/>" class="selected"><fmt:message key="protexpress.breadcrumb.home" /></a>
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
            <div id="btn_home_create">
                <a href="" id="btn_home_create_t"><fmt:message key="protexpress.page.home.createnewexperiment" /></a>
            </div>
            <div id="btn_home_search">
                <a href="" id="btn_home_search_t"><fmt:message key="protexpress.page.home.search" /></a>
            </div>
            <div class="clear"></div>
        </div>
        <!-- /Big Buttons -->
        <!-- My Experiments -->
        <div class="myexperiments">
            <h2><fmt:message key="protexpress.page.home.recentexperiments" /></h2>
            <table class="newdata">
                <tbody>
                    <s:if test="%{recentExperiments.size() == 0}">
                        <tr><td><fmt:message key="protexpress.page.home.recentexperiments.nonefound" /></td></tr>
                    </s:if>
                    <s:else>
                        <tr>
                            <th><fmt:message key="protexpress.page.home.recentexperiments.column.experimentname" /></th>
                            <th><fmt:message key="protexpress.page.home.recentexperiments.column.comments" /></th>
                            <th><fmt:message key="protexpress.page.home.recentexperiments.column.dateandtime" /></th>
                            <th class="action"><fmt:message key="protexpress.page.home.recentexperiments.column.status" /></th>
                            <th class="action"><fmt:message key="protexpress.page.home.recentexperiments.column.edit" /></th>
                            <th class="action"><fmt:message key="protexpress.page.home.recentexperiments.column.download" /></th>
                        </tr>
                        <c:forEach items="${recentExperiments}" var="experiment">
                            <c:url var="experimentSummaryUrl" value="/notYetImplemented.html">
                                <c:param name="experiment.id" value="${experiment.id}" />
                            </c:url>
                            <c:url var="experimentEditUrl" value="/notYetImplemented.html">
                                <c:param name="experiment.id" value="${experiment.id}" />
                            </c:url>
                            <c:url var="experimentDownloadUrl" value="/notYetImplemented.html">
                                <c:param name="experiment.id" value="${experiment.id}" />
                            </c:url>
                            <tr>
                                <td><a href="${experimentSummaryUrl}">${experiment.name}</a></td>
                                <td>${experiment.comments}</td>
                                <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${experiment.auditInfo.lastModifiedDate.time}" /></td>
                                <td class="action">
                                    <span title="Incomplete">
                                        <img src="<c:url value="/images/ico_asterisk.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.incomplete.alt" />" />
                                    </span>
                                    <span title="Complete">
                                        <img src="<c:url value="/images/ico_check.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.complete.alt" />" />
                                    </span>
                                </td>
                                <td class="action">
                                    <a href="${experimentEditUrl}"><img src="<c:url value="/images/ico_edit.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.edit.alt" />" /></a>
                                </td>
                                <td class="action">
                                    <a href="${experimentDownloadUrl}"><img src="<c:url value="/images/ico_xar.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.download.alt" />" /></a>
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
