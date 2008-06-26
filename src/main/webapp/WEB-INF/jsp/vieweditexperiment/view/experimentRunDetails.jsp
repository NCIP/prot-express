<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<h3>${experimentRun.name}</h3>
<form name="edit" id="edit">
    <table class="form">
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.name" />:</td>
            <td class="value">${experimentRun.name}</td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.dateperformed" />:</td>
            <td class="value"><fmt:formatDate type="date" dateStyle="short" value="${experimentRun.datePerformed}" /></td>
        </tr>
        <tr>
            <td class="label"><fmt:message key="protexpress.experimentrun.notes" />:</td>
            <td class="value">${experimentRun.notes}</td>
        </tr>
    </table>
</form>