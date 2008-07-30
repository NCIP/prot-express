<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<div>
  <c:set var="mode" value="CREATE" />
  <c:set var="formId" value="manageInputsForm" />
  <c:set var="divId" value="divContent" />
  <c:url var="saveUrl" value="/createExperiment/protocols/inputs/saveInputsToSession.action" />
 <s:actionerror ></s:actionerror>
    <s:form id="manageInputsForm" action="createExperiment/protocols/inputs/addNewInput" method="post" >
        <!-- New Inputs List -->
        <c:set var="addNewInputUrlTarget" value="/ajax/createExperiment/protocols/inputs/addNewInput.action" />
        <c:set var="deleteInputUrlTarget" value="/ajax/createExperiment/protocols/inputs/deleteInput.action"/>
        <fieldset>
            <legend><fmt:message key="protexpress.page.createnewexperiment.addinputs.title" /></legend>
            <%@ include file="/WEB-INF/jsp/experiment/common/manageNewInputs.jsp"%>
        </fieldset>
        <!-- /New Inputs List -->
      <!-- Select Input List-->
      <c:set var="addExistingInputUrlTarget" value="/ajax/createExperiment/protocols/inputs/addExistingInput.action" />
      <fieldset>
          <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.selectexistinginputscaption" /></legend>
          <%@ include file="/WEB-INF/jsp/experiment/common/managePotentialInputs.jsp"%>
      </fieldset>
      <!--/Select Input List-->
    </s:form>
  <div class="clear"></div>
  <div class="actionsrow">
      <del class="btnwrapper">
          <ul id="btnrow2">
              <li>
                  <a href="javascript:submitForm('${saveUrl}', '${formId}');" class="btn" onclick="this.blur();">
                      <span class="btn_img">
                          <span class="next"><fmt:message key="protexpress.page.createnewexperiment.addinputs.button.continue" /></span>
                      </span>
                  </a>
              </li>
          </ul>
      </del>
    </div>
    <div class="clear"/>
</div>