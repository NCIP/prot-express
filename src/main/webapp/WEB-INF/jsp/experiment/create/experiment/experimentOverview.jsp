<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<body>
    <!-- Breadcrumb -->
      <c:choose>
          <c:when test="${experimentRun != null && experimentRun.id != null}"><c:set var="breadCrumbExpText" value="${experimentRun.experiment.name}" /></c:when>
          <c:otherwise><fmt:message var="breadCrumbExpText" key="protexpress.breadcrumb.createnewexperiment" /></c:otherwise>
      </c:choose>
      <protExpress:breadCrumbTrial>
          <protExpress:breadCrumb href="/ajax/home/home.action" textKey="protexpress.breadcrumb.home" />
          <protExpress:breadCrumb cssClass="selected" href="/ajax/createExperiment/reloadExperiment.action" text="${breadCrumbExpText}" insertSymbol="false"/>
      </protExpress:breadCrumbTrial>
    <!-- /Breadcrumb -->

    <!-- Page Help -->
        <protExpress:pageHelp/>
    <!-- /Page Help -->

    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.createnewexperiment.overview.title" /></h1>
        <div class="fadebox">
            <protExpress:processFlow>
                <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.identifyexperiment" selected="true" insertNextStepIndicator="true"/>
                <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.addprotocols" insertNextStepIndicator="true"/>
                <protExpress:processStep textKey="protexpress.page.createnewexperiment.steps.reviewexperiment" />
            </protExpress:processFlow>

            <div class="fadebox">
                <h2><fmt:message key="protexpress.page.createnewexperiment.steps.identifyexperiment" /></h2>
                <div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.info" /></p></div>
            </div>

            <s:form id="createExperimentForm" action="ajax/createExperiment/save.action" method="post">
                <c:set var="formName" value="createExperimentForm" />

                <div class="centerfield">
                    <!-- Experiment Info -->
                    <c:set var="title" value="protexpress.page.createnewexperiment.identifyexperiment.overviewtitle" />
                    <c:set var="nameExperimentName" value="experiment.name" />
                    <c:set var="nameExperimentDescription" value="experiment.description" />
                    <c:set var="nameExperimentHypothesis" value="experiment.hypothesis" />
                    <c:set var="nameExperimentUrl" value="experiment.url" />
                    <c:set var="nameExperimentNotes" value="experiment.notes" />
                    <%@ include file="/WEB-INF/jsp/experiment/common/experimentInfo.jsp"%>
                    <!-- /Experiment Info -->

                    <!-- Experiment Date -->
                    <fieldset class="rightfield">
                        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.dateperformedtitle" /></legend>
                        <protExpress:datefield formName="createExperimentForm" htmlField="${experiment.datePerformed}" sname="experiment.datePerformed" theme="xhtml" />
                    </fieldset>
                    <!-- /Experiment Date -->

                    <!-- Experiment Contact -->
                    <c:set var="title" value="protexpress.page.createnewexperiment.identifyexperiment.contacttitle" />
                    <c:set var="nameFirstName" value="experiment.contactPerson.firstName" />
                    <c:set var="nameLastName" value="experiment.contactPerson.lastName" />
                    <c:set var="nameEmail" value="experiment.contactPerson.email" />
                    <c:set var="nameNotes" value="experiment.contactPerson.notes" />
                    <%@ include file="/WEB-INF/jsp/experiment/common/contactPersonInfo.jsp"%>
                    <!-- /Experiment Contact -->

                    <div class="clear"></div>
                </div>

                <c:url var="cancelUrl" value="/ajax/home/home.action" />
                <protExpress:buttonRow>
                    <protExpress:button style="cancel" textKey="protexpress.page.createnewexperiment.identifyexperiment.button.back" id="cancel" onclick="ProtExpress.loadDiv('${cancelUrl}', 'divAjaxBody', true);"/>
                    <protExpress:button style="savecontinue" textKey="protexpress.page.createnewexperiment.identifyexperiment.button.saveandcontinue" id="save" onclick="ProtExpress.submitAjaxForm('createExperimentForm', 'divAjaxBody'); return false;"/>
                </protExpress:buttonRow>
            </s:form>
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>

