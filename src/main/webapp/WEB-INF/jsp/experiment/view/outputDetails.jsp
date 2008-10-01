<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<h3>${inputOutputObject.name}</h3>
<form name="edit" id="edit">
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.output.name" />:</td>
            <td class="value">${inputOutputObject.name}</td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.output.filename" />:</td>
            <td class="value">${inputOutputObject.dataFileURL}</td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.output.notes" />:</td>
            <td class="value">${inputOutputObject.notes}</td>
        </tr>
    </table>
</form>
