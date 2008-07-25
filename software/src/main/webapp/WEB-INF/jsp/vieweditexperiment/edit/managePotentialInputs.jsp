<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<c:set var="formId" value="manageInputsForm" />
<c:set var="divExistingInputs" value="detail-content" />

<fieldset>
    <legend><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.selectexistinginputscaption" /></legend>
    <s:if test="%{experiment.experimentRun.protocolApplications.size() != 0}">
        <tr><td class="label_left"><fmt:message key="protexpress.page.createnewexperiment.reviewexperiment.noprotocolsfound" /></td></tr>
    </s:if>
    <div class="searchresults">
        <s:if test="%{potentialInputs.size() == 0}">
            <table class="newdata3">
                <tr><td class="label_left"><fmt:message key="protexpress.page.editprotocolapplicationdetails.noexistinginputs" /></td></tr>
            </table>
        </s:if>
        <s:else>
          <table class="newdata3">
              <tr>
                  <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.name" /></th>
                  <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.filename" /></th>
                  <th><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.notes" /></th>
                  <th class="action"><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.column.action" /></th>
              </tr>
          </table>
            <div class="scrolltable" style="overflow:auto; height:255px">
                <table class="newdata3" style="width:99.9%">
                    <s:iterator id="pInput" value="potentialInputs" status="e">
                        <s:if test="#e.odd == true"><tr class="odd"></s:if>
                        <s:if test="#e.even == true"><tr class="even"></s:if>
                            <td class="title"><s:textfield name="pInput[%{#e.index}].name" value="%{name}" required="true" readonly="true" cssStyle="width:99%"/></td>
                            <td><s:textfield name="pInput[%{#e.index}].dataFileURL" value="%{dataFileURL}" readonly="true" cssStyle="width:99%"/></td>
                            <td>
                                <s:textarea name="pInput[%{#e.index}].notes" value="%{notes}" readonly="true" rows="2" cols="20" cssStyle="width:99%; height:40px;"  ></s:textarea>
                            </td>
                            <td class="action">
                                <del class="btnwrapper">
                                    <ul id="btnrow2">
                                        <li>
                                            <c:url var="addExistingInputUrl" value="/ajax/editExperiment/protocolApplication/addExistingInput.action" >
                                                <c:param name="selectedInputId" value="${pInput.id}" />
                                            </c:url>
                                            <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divExistingInputs}', '${addExistingInputUrl}'); this.blur(); return false;" class="btn" style="text-decoration:none">
                                                <span class="btn_img">
                                                    <span class="add"><fmt:message key="protexpress.page.editprotocolapplicationdetails.inputs.selectandcontinue" /></span>
                                                </span>
                                            </a>
                                        </li>
                                    </ul>
                                </del>
                          </td>
                      </tr>
                  </s:iterator>
              </table>
            </s:else>
        </div>
    </div>
</fieldset>
