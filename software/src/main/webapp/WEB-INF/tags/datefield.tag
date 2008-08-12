<%@ tag display-name="datefield"  description="Displays the datefield"  body-content="empty" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="formName" required="true" type="java.lang.String"%>
<%@ attribute name="htmlField" required="true" type="java.util.Date" %>
<%@ attribute name="sname" required="true" type="java.lang.String"%>
<%@ attribute name="theme" required="true" type="java.lang.String"%>

<s:textfield name="%{#attr.sname}" required="true" size="10" maxlength="10" theme="%{#attr.theme}">
    <s:param name="value"><fmt:formatDate value="${htmlField}" pattern="MM/dd/yyyy"/></s:param>
</s:textfield>
<a href="javascript://noop/"><img id="imgCalendar_${formName}_${fn:replace(sname, '.', '_')}" src="<c:url value="/images/ico_calendar.gif" />" /></a>

<script type="text/javascript">
    Calendar.setup({
        inputField     :    "${formName}_${fn:replace(sname, '.', '_')}",   // id of the input field
        ifFormat       :    "%m/%d/%Y",       // format of the input field
        button         :    "imgCalendar_${formName}_${fn:replace(sname, '.', '_')}",
        showsTime      :    false,
        timeFormat     :    "24",
        step           :    1
    });
</script>