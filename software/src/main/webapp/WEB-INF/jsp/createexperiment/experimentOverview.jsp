<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<head><s:head theme="ajax" /></head>
<title><fmt:message key="protexpress.page.createnewexperiment.overview.caption" /></title>

<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/home/home.action" />"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="<c:url value="/createExperiment/reloadCreateNewExperiment.action" />" class="selected">
            <s:if test="experiment != null && experiment.id != null">${experiment.name}</s:if>
            <s:else><fmt:message key="protexpress.breadcrumb.createnewexperiment" /></s:else>
        </a>
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
                <div class="selectedstep"><fmt:message key="protexpress.page.createnewexperiment.steps.identifyexperiment" /></div>
                <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt="" /></div>
                <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.addprotocols" /></div>
                <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt="" /></div>
                <div class="step"><fmt:message key="protexpress.page.createnewexperiment.steps.review" /></div>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
            <div class="fadebox">
                <h2><fmt:message key="protexpress.page.createnewexperiment.steps.identifyexperiment" /></h2>
                <div class="info"><p><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.info" /></p></div>
            </div>

            <s:form id="createExperimentForm" action="/createExperiment/saveOverviewInformation.action" method="post">
                <s:hidden name="experiment.id" value="${experiment.id}"/>
                <s:hidden name="experimentRun.id" value="${experimentRun.id}"/>
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
                        <s:datetimepicker
                                    name="experiment.datePerformed"
                                    toggleType="fade"
                                    displayFormat="MM/dd/yyyy" required="*"/>
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
                <div class="actionsrow">
                    <del class="btnwrapper">
                        <ul id="btnrow2">
                            <li>
                                <c:url var="cancelUrl" value="/home/home.action" />
                                <a href="${cancelUrl}" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="cancel"><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.button.back" /></span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:document.getElementById('createExperimentForm').submit();" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="savecontinue"><fmt:message key="protexpress.page.createnewexperiment.identifyexperiment.button.saveandcontinue" /></span>
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </del>
                </div>
            </s:form>
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>