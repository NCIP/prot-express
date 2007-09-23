<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<page:applyDecorator name="main">
<html>
<head>
</head>
<body onload="document.getElementById('j_username').focus();">
<page:param name="contentCssId">contenthome</page:param>
<!--Home Banner-->
<div class="homebanner"><img src="<c:url value="/images/banner_protexpress.gif"/>" alt="" height="140" width="600"></div>
<!--/Home Banner-->

<div id="homecontentbar">
    <div id="homecontentwrapper">
        <div id="homeinfo">
            <h1><fmt:message key="login.welcome" /></h1>
            <p class="intro"><fmt:message key="login.protexpress.description" /></p>
        </div>
        <div id="homelogin">
            <h1><fmt:message key="login.header" /></h1>
            <c:if test="${not empty failedLogin}">
                <fmt:message key="login.error" />
            </c:if>
            <form id="login" name="login" action=j_security_check>
                <table class="login">
                    <tbody>
                    <tr>
                        <td colspan="2" class="space">&nbsp;</td>
                    </tr>
                    <tr>
                        <td scope="row" class="label"><label for="j_username"><fmt:message key="login.username" />:</label></td>
                        <td class="value"><input id="j_username" name="j_username" tabindex="1" maxlength="100" size="15" value="" style="width: 90px;" type="text"></td>
                    </tr>
                    <tr>
                        <td scope="row" class="label"><label for="j_password"><fmt:message key="login.password" />:</label></td>
                        <td class="value"><input name="j_password" tabindex="2" maxlength="100" size="15" value="" style="width: 90px;" type="password"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="centered"><input src="<c:url value="/images/btn_login.gif" />" value="Login" class="button" type="image"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="space">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="loginlinks">
                            <a href="<c:url value="/registration/load.action" />" class="loginlinks"><fmt:message key="register" /></a> |
                            <a href="<c:url value="/notYetImplemented.html" />" class="loginlinks"><fmt:message key="login.forgotpassword" /></a>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
</page:applyDecorator>