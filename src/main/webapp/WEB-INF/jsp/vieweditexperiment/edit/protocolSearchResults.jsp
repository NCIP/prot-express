<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

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
                                    <c:url var="selectAndContinueUrl1" value="/ajax/editExperiment/experimentRun/selectProtocolAndContinue.action">
                                        <c:param name="protocolId" value="${row.id}" ></c:param>
                                        <c:param name="experimentRunId" value="${experimentRun.id}" ></c:param>
                                    </c:url>
                                    <a href="javascript://noop/" onclick="refreshDetailsView('${selectAndContinueUrl1}')" class="btn" style="text-decoration:none" >
                                        <span class="btn_img">
                                            <span class="add"><fmt:message key="protexpress.page.editexperimentrundetails.selectexistingprotocol.button.selectandcontinue" /></span>
                                        </span>
                                    </a>

                                    <a href="javascript://noop/" onclick="toggleTreeNodeAndRefreshDetailsView('${experiment.id}','${loadExperimentDetailsUrl}')" class="experiment">${experiment.name}</a>
                                </c:when>
                                <c:otherwise>
                                    <c:url var="copyAndContinueUrl" value="/ajax/editExperiment/experimentRun/copyProtocolAndContinue.action">
                                        <c:param name="protocolId" value="${row.id}" ></c:param>
                                        <c:param name="experimentRunId" value="${experimentRun.id}" ></c:param>
                                    </c:url>
                                    <a href="javascript://noop/" onclick="refreshDetailsView('${copyAndContinueUrl}')" class="btn" style="text-decoration:none" >
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