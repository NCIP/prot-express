<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<body>
    <!-- Breadcrumb -->
      <protExpress:breadCrumbTrial>
          <protExpress:breadCrumb href="/ajax/home/home.action" textKey="protexpress.breadcrumb.home" />
          <protExpress:breadCrumb cssClass="selected" href="/ajax/createExperiment/reloadExperiment.action" text="${experiment.name}" insertSymbol="false"/>
      </protExpress:breadCrumbTrial>
    <!-- /Breadcrumb -->

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.createnewexperiment.overview.title" /></h1>
        <protExpress:processFlow>
            <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.identifyexperiment" insertNextStepIndicator="true"/>
            <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addprotocols" selected="true" insertNextStepIndicator="true"/>
            <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewexperiment" />
        </protExpress:processFlow>

        <div class="fadebox">
            <h2><fmt:message key="protexpress.page.createnewexperiment.steps.addprotocols" /></h2>
            <div id="divAjaxProtocolBody">
