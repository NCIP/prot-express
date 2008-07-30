<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.viewexperiment.overview.title" /></h1>
        <div id="editview">
            <!--TREE COLUMN-->
            <div id="treecol">
                <h2 class="treehead"><fmt:message key="protexpress.page.viewexperiment.treeview.title" /></h2>
                <c:set var="treeMode" value="VIEW" />
                <%@ include file="/WEB-INF/jsp/experiment/viewEditExperimentTree.jsp"%>
            </div>
            <c:if test="${selectedNodeId != null}">
                <script>
                    // selectTreeNode('${selectedNodeId}');
                </script>
            </c:if>
            <!-- /TREE COLUMN -->
            <!-- DETAIL COLUMN -->
            <div id="detailcol">
                <h2 class="detailhead"><fmt:message key="protexpress.page.viewexperiment.detailsview.title" /></h2>
                <div class="detailbox" id="detail-content">
                    <jsp:include page="/WEB-INF/jsp/experiment/view/experimentDetails.jsp" />
                </div>
                <div class="detailbox">
                    <div class="actionsrow">
                        <del class="btnwrapper">
                            <ul id="btnrow2">
                                <li>
                                    <c:url var="editExperimentDetailsUrl" value="/editExperiment/experiment/load.action">
                                        <c:param name="experimentId" value="${experiment.id}" />
                                    </c:url>
                                    <a href="${editExperimentDetailsUrl}" class="btn" onclick="this.blur();">
                                        <span class="btn_img"><span class="edit"><fmt:message key="protexpress.page.viewexperiment.detailsview.footer.editexperiment" /></span></span>
                                    </a>
                                </li>
                            </ul>
                        </del>
                    </div>
                </div>
            </div>
            <!-- /DETAIL COLUMN -->
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
