<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<fieldset>
    <c:url var="manageOutputsUrl" value="/createExperiment/protocols/outputs/update.action">
        <c:param name="protocolApplicationId" value="${protocolApplication.id}" />
    </c:url>
    <legend><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.outputs"/>[<a href="${manageOutputsUrl}"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.addedittext"/></a>]</legend>
    <!--Output List-->
    <div class="searchresults" style="border-bottom:0;">
        <table class="newdata3">
            <s:if test="%{protocolApplication.outputs.size() == 0}">
                <tr>
                    <td class="label_left">
                        <fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.outputs.nonefound" />
                    </td>
            </s:if>
            <s:else>
                <tr>
                    <th class="alignright"><fmt:message key="protexpress.page.createnewexperiment.reviewprotocol.outputs.column.count" /></th>
                    <th><fmt:message key="protexpress.output.name" /></th>
                    <th><fmt:message key="protexpress.output.filename" /></th>
                    <th><fmt:message key="protexpress.output.notes" /></th>
                </tr>
                <c:forEach items="${protocolApplication.outputs}" var="output" varStatus="itemCount">
                    <c:choose>
                        <c:when test="${itemCount.count % 2 == 0}"><tr class="even"></c:when>
                        <c:otherwise><tr class="odd"></c:otherwise>
                    </c:choose>
                        <td class="alignright">${itemCount.count}.</td>
                        <td class="title">${output.name}</td>
                        <td>${output.dataFileURL}</td>
                        <td>${output.notes}</td>
                    </tr>
                </c:forEach>
            </s:else>
        </table>
    </div>
    <!--/Output List-->
</fieldset>
