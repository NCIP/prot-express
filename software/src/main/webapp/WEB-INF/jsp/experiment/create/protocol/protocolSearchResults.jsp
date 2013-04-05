<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.create_experiment_protocol_search_results"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<!--Protocol Search Results List -->
<div class="tabbed">
    <div class="searchresults">
    <c:url var="sortUrl" value="/ajax/createExperiment/protocols/add/doSearch.action" />

    <s:hidden name="protocolApplication.id" value="protocolApplication.id"/>
    <s:hidden name="experimentId" value="experiment.id"/>

    <ajax:displayTag id="displayTagFrame" ajaxFlag="true" tableClass="newdata3">
        <display:table class="newdata3" cellspacing="0" list="${protocols}" requestURI="${sortUrl}" id="row">
            <display:setProperty name="pagination.sort.param" value="protocols.sortCriterion" />
            <display:setProperty name="pagination.sortdirection.param" value="protocols.sortDirection" />
            <display:setProperty name="pagination.pagenumber.param" value="protocols.pageNumber" />
            <protExpress:displayTagProperties />

            <display:column property="name" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.name" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="description" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.description" sortable="true" maxLength="20" maxWords="4" />
            <display:column property="notes" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.notes" maxLength="20" maxWords="4" />
            <display:column titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.user">${row.auditInfo.creator}</display:column>
            <display:column class="actionwide" titleKey="protexpress.page.createnewexperiment.selectexistingprotocol.action">
                <del class="btnwrapper">
                    <ul id="btnrow2">
                        <li>
                            <c:choose>
                                <c:when test="${row.auditInfo.creator == currentUser.loginName}">
                                    <c:url var="selectAndContinueUrl" value="/ajax/createExperiment/protocols/add/selectProtocolAndContinue.action">
                                        <c:param name="protocolId" value="${row.id}" ></c:param>
                                    </c:url>
                                    <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${selectAndContinueUrl}', 'divAjaxBody', true);" class="btn" style="text-decoration:none" onclick="this.blur();">
                                        <span class="btn_img">
                                            <span class="add"><fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.button.selectandcontinue" /></span>
                                        </span>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <c:url var="copyAndContinueUrl" value="/ajax/createExperiment/protocols/add/copyProtocolAndContinue.action">
                                        <c:param name="protocolId" value="${row.id}" ></c:param>
                                    </c:url>
                                    <a href="javascript://noop/" onclick="ProtExpress.loadDiv('${copyAndContinueUrl}', 'divAjaxBody', true);" class="btn" style="text-decoration:none" onclick="this.blur();">
                                        <span class="btn_img">
                                            <span class="add"><fmt:message key="protexpress.page.createnewexperiment.selectexistingprotocol.button.copyandcontinue" /></span>
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