<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!--
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
-->

<div class="searchresults">
    <s:if test="%{potentialInputs.size() == 0}">
        <table class="newdata3">
            <tr><td class="label_left"><fmt:message key="protexpress.page.manageinputs.noexistinginputs" /></td></tr>
        </table>
    </s:if>
    <s:else>
        <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="newdata3">
            <display:table class="newdata3" cellspacing="0" list="${potentialInputs}" requestURI="" id="row">
                <protExpress:displayTagProperties />
                    <display:column property="name" titleKey="protexpress.page.manageinputs.column.name" sortable="false" maxLength="20" maxWords="4" />
                    <display:column property="dataFileURL" titleKey="protexpress.page.manageinputs.column.filename" sortable="false" maxLength="20" maxWords="4" />
                    <display:column property="notes" titleKey="protexpress.page.manageinputs.column.notes" maxLength="20" maxWords="4" />
                    <display:column class="actionwide" titleKey="protexpress.page.manageinputs.column.action">
                        <del class="btnwrapper">
                            <ul id="btnrow2">
                                <li>
                                    <c:url var="addExistingInputUrl" value="${addExistingInputUrlTarget}" >
                                        <c:param name="selectedInputId" value="${row.id}" />
                                    </c:url>
                                    <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${addExistingInputUrl}'); this.blur(); return false;" class="btn" style="text-decoration:none">
                                        <span class="btn_img">
                                            <span class="add"><fmt:message key="protexpress.page.manageinputs.selectandcontinue" /></span>
                                        </span>
                                    </a>
                                </li>
                            </ul>
                        </del>
                    </display:column>
            </display:table>
        </ajax:displayTag>
    </s:else>
</div>

<!--
<div class="searchresults">
      <c:url var="sortUrl" value="/ajax/editExperiment/experimentRun/protocol/searchProtocols.action" />

      <s:hidden name="protocolApplication.id" value="protocolApplication.id"/>
      <s:hidden name="experimentId" value="experiment.id"/>

      <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="newdata3">
          <display:table class="newdata3" cellspacing="0" list="${protocols}" requestURI="${sortUrl}" id="row">
              <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
              <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
              <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />
              <protExpress:displayTagProperties />

              <display:column property="name" titleKey="protexpress.page.editexperimentrundetails.selectexistingprotocol.name" sortable="true" maxLength="20" maxWords="4" />
              <display:column property="description" titleKey="protexpress.page.editexperimentrundetails.selectexistingprotocol.description" sortable="true" maxLength="20" maxWords="4" />
              <display:column property="notes" titleKey="protexpress.page.editexperimentrundetails.selectexistingprotocol.notes" maxLength="20" maxWords="4" />
              <display:column titleKey="protexpress.page.editexperimentrundetails.selectexistingprotocol.user">${row.auditInfo.creator}</display:column>
              <display:column class="actionwide" titleKey="protexpress.page.editexperimentrundetails.selectexistingprotocol.action">
                  <del class="btnwrapper">
                      <ul id="btnrow2">
                          <li>
                              <c:choose>
                                  <c:when test="${row.auditInfo.creator == currentUser.loginName}">
                                      <c:url var="selectAndContinueUrl" value="/ajax/editExperiment/experimentRun/protocol/selectProtocolAndContinue.action">
                                          <c:param name="protocolId" value="${row.id}" ></c:param>
                                          <c:param name="experimentRunId" value="${experimentRun.id}" ></c:param>
                                          <c:param name="experimentId" value="${experiment.id}" ></c:param>
                                      </c:url>
                                      <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${selectAndContinueUrl}'); this.blur(); return false;" class="btn" style="text-decoration:none">
                                          <span class="btn_img">
                                              <span class="add"><fmt:message key="protexpress.page.editexperimentrundetails.selectexistingprotocol.button.selectandcontinue" /></span>
                                          </span>
                                      </a>
                                  </c:when>
                                  <c:otherwise>
                                      <c:url var="copyAndContinueUrl" value="/ajax/editExperiment/experimentRun/protocol/copyProtocolAndContinue.action">
                                          <c:param name="protocolId" value="${row.id}" ></c:param>
                                          <c:param name="experimentRunId" value="${experimentRun.id}" ></c:param>
                                          <c:param name="experimentId" value="${experiment.id}" ></c:param>
                                      </c:url>
                                      <a href="javascript://noop/" onclick="ProtExpress.submitAjaxFormToUrl('${formId}', '${divId}', '${copyAndContinueUrl}'); this.blur(); return false;" class="btn" style="text-decoration:none">
                                          <span class="btn_img">
                                              <span class="add"><fmt:message key="protexpress.page.editexperimentrundetails.selectexistingprotocol.button.copyandcontinue" /></span>
                                          </span>
                                      </a>
                                  </c:otherwise>
                              </c:choose>
                          </li>
                      </ul>
                  </del>
              </display:column>
          </display:table>
      </ajax:displayTag>
  </div>
 -->