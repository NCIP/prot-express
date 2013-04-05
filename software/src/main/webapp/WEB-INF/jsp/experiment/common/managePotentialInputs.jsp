<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
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