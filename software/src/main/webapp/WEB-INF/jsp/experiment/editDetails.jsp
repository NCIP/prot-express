<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>


<title><fmt:message key="protexpress.page.editexperiment.title.caption" /></title>
<c:url var="editExperimentDetailsUrl" value="/editExperiment/experiment/load.action">
    <c:param name="experimentId" value="${experiment.id}" />
</c:url>
<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/home/home.action" />"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="${editExperimentDetailsUrl}" class="selected"><fmt:message key="protexpress.breadcrumb.editexperiment" /></a>
    </div>
    <!-- /Breadcrumb -->
    <!-- Page Help -->
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.editexperiment.overview.title" /></h1>
        <div id="editview">
            <!--TREE COLUMN-->
            <div id="treecol">
                <h2 class="treehead"><fmt:message key="protexpress.page.editexperiment.treeview.title" /></h2>
                <c:set var="treeMode" value="EDIT" />
                <%@ include file="/WEB-INF/jsp/experiment/viewEditExperimentTree.jsp"%>
            </div>
            <!-- /TREE COLUMN -->
            <!-- DETAIL COLUMN -->
            <div id="detailcol">
                <h2 class="detailhead"><fmt:message key="protexpress.page.editexperiment.detailsview.title" /></h2>
                <div class="detailbox" id="detail-content">
                  <jsp:include page="/WEB-INF/jsp/experiment/edit/experimentDetails.jsp" />
                </div>
            </div>
            <!-- /DETAIL COLUMN -->
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>

<script type="text/javascript">
    // Define the variables that will be used for the date controls in subsequent page.
    // Variables have to be defined in the parent page, due to scope problems.
    // These variables will be referred to in the appropriate page for displaying the calendar popup controls.

    var expDatePerformed, expRunDatePerformed, protAppDatePerformed;
</script>
