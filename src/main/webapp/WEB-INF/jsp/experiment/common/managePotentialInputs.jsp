<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<div id="divPotentialInputs" class="searchresults">
    <s:if test="%{potentialInputs.size() == 0}">
        <table class="newdata3">
            <tr><td class="label_left"><fmt:message key="protexpress.page.manageinputs.noexistinginputs" /></td></tr>
        </table>
    </s:if>
    <s:else>
      <table class="newdata3">
          <tr>
              <th><fmt:message key="protexpress.page.manageinputs.column.name" /></th>
              <th><fmt:message key="protexpress.page.manageinputs.column.filename" /></th>
              <th><fmt:message key="protexpress.page.manageinputs.column.notes" /></th>
              <th class="action"><fmt:message key="protexpress.page.manageinputs.column.action" /></th>
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
                                        <c:url var="addExistingInputUrl" value="${addExistingInputUrlTarget}" >
                                            <c:param name="selectedInputId" value="${pInput.id}" />
                                        </c:url>
                                        <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${addExistingInputUrl}'); this.blur(); return false;" class="btn" style="text-decoration:none">
                                            <span class="btn_img">
                                                <span class="add"><fmt:message key="protexpress.page.manageinputs.selectandcontinue" /></span>
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