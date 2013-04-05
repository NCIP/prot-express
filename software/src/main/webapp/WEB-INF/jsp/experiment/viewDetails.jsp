<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<head><s:head theme="ajax" /></head>
<title><fmt:message key="protexpress.page.viewexperiment.title.caption" /></title>
<c:url var="viewExperimentDetailsUrl" value="/viewExperiment/experiment/load.action">
    <c:param name="experimentId" value="${experiment.id}" />
</c:url>
<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/home/home.action" />"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="${viewExperimentDetailsUrl}" class="selected"><fmt:message key="protexpress.breadcrumb.viewexperiment" /></a>
    </div>
    <!-- /Breadcrumb -->

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.viewexperiment.overview.title" /></h1>
        <div id="editview">
            <!--TREE COLUMN-->
            <div id="treecol">
              <c:set var="treeNodeUrlPrefix" value="view" />
              <%@ include file="/WEB-INF/jsp/experiment/viewEditExperimentTree.jsp"%>
          </div>
            <!-- /TREE COLUMN -->
            <!-- DETAIL COLUMN -->
            <div id="detailcol">
                <h2 class="detailhead"><fmt:message key="protexpress.page.viewexperiment.detailsview.title" /></h2>
                <div class="detailbox" id="detail-content">
                    <jsp:include page="/WEB-INF/jsp/experiment/view/experimentDetails.jsp" />
                </div>
                <c:url var="editExperimentDetailsUrl" value="/editExperiment/experiment/load.action">
                    <c:param name="experimentId" value="${experiment.id}" />
                </c:url>
                <c:url var="downloadXarUrl" value="/ajax/experiment/export.action">
                    <c:param name="experimentId" value="${experiment.id}" />
                </c:url>

                <div class="detailbox">
                    <protExpress:buttonRow>
                        <c:if test="${experiment.auditInfo.creator == currentUser.loginName}">
                            <protExpress:button href="${editExperimentDetailsUrl}" style="edit" textKey="protexpress.page.viewexperiment.detailsview.footer.editexperiment" id="edit"/>
                        </c:if>
                        <protExpress:button href="${downloadXarUrl}" style="xar" textKey="protexpress.page.viewexperiment.detailsview.footer.downloadxar" id="xar"/>
                    </protExpress:buttonRow>
                </div>
            </div>
            <!-- /DETAIL COLUMN -->
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
