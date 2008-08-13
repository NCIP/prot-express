<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<!--Protocol Search Results List -->
<c:set var="formId" value="selectExistingProtocolForm" />
<c:set var="divId" value="detail-content" />

<s:form id="selectExistingProtocolForm" method="post" />

<div class="tabbed">
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
</div>
<!--/Protocol Search Results List -->