<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
