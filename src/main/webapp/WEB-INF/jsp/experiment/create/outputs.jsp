<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<div>
  <c:set var="mode" value="CREATE" />
  <c:set var="formId" value="manageOutputsForm" />
  <c:set var="divId" value="divContent" />
  <c:url var="saveUrl" value="/createExperiment/protocols/outputs/saveOutputsToSession.action" />
 <s:actionerror ></s:actionerror>
    <s:form id="manageOutputsForm" action="createExperiment/protocols/outputs/addNewOutput" method="post" >
        <!-- New Outputs List -->
        <c:set var="addNewOutputUrlTarget" value="/ajax/createExperiment/protocols/outputs/addNewOutput.action" />
        <c:set var="deleteOutputUrlTarget" value="/ajax/createExperiment/protocols/outputs/deleteOutput.action"/>
        <fieldset>
            <legend><fmt:message key="protexpress.page.createnewexperiment.addoutputs.title" /></legend>
            <%@ include file="/WEB-INF/jsp/experiment/common/manageNewOutputs.jsp"%>
        </fieldset>
        <!-- /New Outputs List -->
    </s:form>
  <div class="clear"></div>
  <div class="actionsrow">
      <del class="btnwrapper">
          <ul id="btnrow2">
              <li>
                  <a href="javascript:submitForm('${saveUrl}', '${formId}');" class="btn" onclick="this.blur();">
                      <span class="btn_img">
                          <span class="next"><fmt:message key="protexpress.page.createnewexperiment.addoutputs.button.continue" /></span>
                      </span>
                  </a>
              </li>
          </ul>
      </del>
    </div>
    <div class="clear"/>
</div>