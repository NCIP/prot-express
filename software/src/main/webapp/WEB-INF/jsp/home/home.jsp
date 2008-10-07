<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<title><fmt:message key="protexpress.page.home.caption" /></title>
<body>
    <!-- Breadcrumb -->
      <protExpress:breadCrumbTrial>
          <protExpress:breadCrumb href="/ajax/home/home.action" cssClass="selected" insertSymbol="false" textKey="protexpress.breadcrumb.home" />
      </protExpress:breadCrumbTrial>
    <!-- /Breadcrumb -->

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.home"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

    <div class="padme8">
        <!-- Add Content Here -->
        <h1><fmt:message key="protexpress.page.home.title" /></h1>
        <p class="homeintro"><fmt:message key="protexpress.page.home.introtext" /></p>
        <!-- Big Buttons -->
            <protExpress:homeButtonRow textKey="protexpress.page.home.actionchoice">
                <protExpress:homeButton divId="btn_home_create" btnId="btn_home_create_t" href="/ajax/createExperiment/createNewExperiment.action" textKey="protexpress.page.home.createnewexperiment" />
                <protExpress:homeButton divId="btn_home_search" btnId="btn_home_search_t" href="/ajax/search/loadSearch.action" textKey="protexpress.page.home.search" />
            </protExpress:homeButtonRow>
        <!-- /Big Buttons -->
        <!-- My Experiments -->
        <div class="myexperiments">
            <h2><fmt:message key="protexpress.page.home.recentexperiments" /></h2>
            <table class="newdata3">
                <tbody>
                    <s:if test="%{recentExperiments.size() == 0}">
                        <tr>
                            <td class="label_left">
                                <fmt:message key="protexpress.page.home.recentexperiments.nonefound" />&nbsp;&nbsp;
                                <a href="<c:url value="/createExperiment/createNewExperiment.action"/>"><fmt:message key="protexpress.page.home.createnewexperiment" /></a>
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
                            <c:url var="experimentDownloadUrl" value="/ajax/experiment/export.action">
                                <c:param name="experimentId" value="${experiment.id}" />
                            </c:url>
                            <tr>
                                <td><a href="${viewExperimentDetailsUrl}">${experiment.name}</a></td>
                                <td>${experiment.description}</td>
                                <td><fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${experiment.auditInfo.lastModifiedDate.time}" /></td>
                                <td class="action">
                                     <c:choose>
                                        <c:when test="${experiment.statusCompleted == true}">
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
                                    <c:if test="${experiment.statusCompleted == true}">
                                        <a href="${experimentDownloadUrl}">
                                            <img src="<c:url value="/images/ico_xar.gif" />" alt="<fmt:message key="protexpress.page.home.recentexperiments.icon.download.alt" />" />
                                        </a>
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
