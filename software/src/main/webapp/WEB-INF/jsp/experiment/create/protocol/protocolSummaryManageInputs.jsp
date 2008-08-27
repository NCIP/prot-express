<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<fieldset>
    <c:url var="manageInputsUrl" value="/createExperiment/protocols/inputs/update.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    </c:url>
    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.inputs"/>[<a href="${manageInputsUrl}"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.addedittext"/></a>]</legend>

    <!--Input List-->
    <div class="searchresults" style="border-bottom:0;">
        <table class="newdata3">
            <s:if test="%{protocolApplication.inputs.size() == 0}">
                <tr>
                    <td class="label_left">
                        <fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.inputs.nonefound" />
                    </td>
            </s:if>
            <s:else>
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.inputs.column.count" /></th>
                    <th><fmt:message key="protexpress.input.name" /></th>
                    <th><fmt:message key="protexpress.input.filename" /></th>
                    <th><fmt:message key="protexpress.input.notes" /></th>
                </tr>
                <c:forEach items="${protocolApplication.inputs}" var="input" varStatus="itemCount">
                    <c:choose>
                        <c:when test="${itemCount.count % 2 == 0}"><tr class="even"></c:when>
                        <c:otherwise><tr class="odd"></c:otherwise>
                    </c:choose>
                        <td class="alignright">${itemCount.count}.</td>
                        <td class="title">${input.name}</td>
                        <td>${input.dataFileURL}</td>
                        <td>${input.notes}</td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <!--/Input List-->
</fieldset>
