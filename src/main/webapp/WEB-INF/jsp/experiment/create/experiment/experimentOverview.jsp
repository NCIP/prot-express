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
                <div class="centerfield">
                    <fieldset class="leftfield">
                        <legend><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.overviewtitle" /></legend>
                        <table class="form3">
                            <tr>
                                <td class="label_left">
                                    <s:textfield name="experiment.name" key="protexpress.experiment.name" labelposition="top" required="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="label_left">
                                    <s:textarea name="experiment.description" key="protexpress.experiment.description" labelposition="top" rows="4"></s:textarea>
                                </td>
                            </tr>
                           <tr>
                                <td class="label_left">
                                    <s:textarea name="experiment.hypothesis" key="protexpress.experiment.hypothesis" labelposition="top" rows="4"></s:textarea>
                                </td>
                           </tr>
                           <tr>
                                <td class="label_left">
                                    <s:textfield name="experiment.url" key="protexpress.experiment.url" labelposition="top"/>
                                </td>
                            </tr>
                           <tr>
                                <td class="label_left">
                                    <s:textarea name="experiment.notes" key="protexpress.experiment.notes" labelposition="top" rows="4"></s:textarea>
                                </td>
                           </tr>
                        </table>
                    </fieldset>
                    <fieldset class="rightfield">
                        <legend><span class="required">*</span>&nbsp;<fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.dateperformedtitle" /></legend>
                        <protExpress:datefield formName="createExperimentForm" htmlField="${experiment.datePerformed}" sname="experiment.datePerformed" theme="xhtml" />
                    </fieldset>
                    <fieldset class="rightfield">
                        <legend><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.contacttitle" /></legend>
                        <table class="form3">
                            <tr>
                                <td class="label_left">
                                    <s:textfield name="experiment.contactPerson.firstName" key="protexpress.contact.firstname" labelposition="top" />
                                </td>
                            </tr>
                            <tr>
                                <td class="label_left">
                                    <s:textfield name="experiment.contactPerson.lastName" key="protexpress.contact.lastname" labelposition="top" />
                                </td>
                            </tr>
                            <tr>
                                <td class="label_left">
                                    <s:textfield name="experiment.contactPerson.email" key="protexpress.contact.email" labelposition="top" />
                                </td>
                            </tr>
                            <tr>
                                <td class="label_left">
                                    <s:textarea name="experiment.contactPerson.notes" key="protexpress.contact.notes" labelposition="top" rows="4"></s:textarea>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
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


