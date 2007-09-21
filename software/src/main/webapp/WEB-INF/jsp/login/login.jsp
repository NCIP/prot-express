<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<page:applyDecorator name="main">
<html>
<head>
</head>
<body onload="document.getElementById('username').focus();">
<c:if test="${not empty failedLogin}">
    <fmt:message key="login.error" />
</c:if>
<form action="j_security_check">
<table class="wwFormTable">
    <tr>
        <td class="tdLabel"><label for="j_username" class="label"><fmt:message key="login.username" />:</label></td>
        <td><input id="username" type="text" name="j_username" size="10" tabindex="1" /></td>
    </tr>
    <tr>
        <td class="tdLabel"><label for="j_password" class="label"><fmt:message key="login.password" />:</label></td>
        <td><input type="password" name="j_password" size="10" tabindex="2" /></td>
    </tr>
    <tr>
        <td colspan="2">
        <div align="right"><input type="submit" value="<fmt:message key="login" />" /></div>
        </td>
    </tr>
</table>
</form>
</body>
</html>
</page:applyDecorator>