<%@ tag display-name="datefield"  description="Displays the datefield"  body-content="empty" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="name" required="true" type="java.util.Date" %>
<%@ attribute name="sname" required="true" type="java.lang.String"%>
<%@ attribute name="formname" required="true" type="java.lang.String"%>

<c:set var="sname_js" value="${fn:replace(sname, '.', '_')}" />

<script type="text/javascript">
    // Define the variables that will be used for the date controls in subsequent page.
    // Variables have to be defined in the parent page, due to scope problems.
    // These variables will be referred to in the appropriate page for displaying the calendar popup controls.

    var ${sname_js};
</script>
<s:textfield name="%{#attr.sname}" required="true" size="10" maxlength="10">
 
    <s:param name="value"><fmt:formatDate value="${name}" pattern="MM/dd/yyyy"/></s:param>

</s:textfield>
<a href="javascript://noop/" onclick="${sname_js}.toggle();"><img src="<c:url value="/images/ico_calendar.gif" />" /></a>
<script type="text/javascript">
    ${sname_js} = new Epoch('${jsname}Popup', 'popup', document.getElementById('${formname}_${sname_js}'));
</script>    