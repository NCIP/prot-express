<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>

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
                <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.addprotocols" /></div>
                <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt="" /></div>
                <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.review" /></div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
            <div class="fadebox">
                <h2><fmt:message key="protexpress.page.createnewexperiment.steps.addprotocols" /></h2>
                <div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.addprotocols.info" /></p></div>
                <h3>${experiment.name}</h3>

                <div class="tabs">
                     <a href="<c:url value="/createExperiment/load/experimentAddNewProtocol.action" />" ><span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.addnewprotocol" /></span></a>
                    <a href="<c:url value="/createExperiment/load/experimentSelectExistingProtocol.action"/>" class="selected"><span><fmt:message key="protexpress.page.createnewexperiment.addprotocol.tabs.selectexistingprotocol" /></span></a>
                </div>

                <jsp:include page="/WEB-INF/jsp/createexperiment/selectExistingProtocol.jsp" />
           </div>
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
