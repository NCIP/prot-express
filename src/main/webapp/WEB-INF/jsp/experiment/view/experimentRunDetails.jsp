<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<h3>${experimentRun.name}</h3>
<form name="edit" id="edit">
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.name" />:</td>
            <td class="value">${experimentRun.name}</td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.dateperformed" />:</td>
            <td class="value"><fmt:formatDate type="date" pattern="MM/dd/yyyy" dateStyle="short" value="${experimentRun.datePerformed}" /></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.notes" />:</td>
            <td class="value">${experimentRun.notes}</td>
        </tr>
    </table>
</form>