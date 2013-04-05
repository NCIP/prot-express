<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<page:applyDecorator name="main">
<html>
<head>
</head>
<body onload="document.getElementById('j_username').focus();">
<page:param name="contentCssId">contenthome</page:param>
<!--Home Banner-->
<div class="homebanner"><img src="<c:url value="/images/banner_protexpress.gif"/>" alt="" height="140" width="599"></div>
<!--/Home Banner-->

<div id="homecontentbar">
    <div id="homecontentwrapper">
        <div id="homeinfo">
            <h1><fmt:message key="login.welcome" /></h1>
            <p class="intro"><fmt:message key="login.protexpress.description" /></p>
        </div>
        <div id="homelogin">
            <h1><fmt:message key="login.header" /></h1>
            <script type="text/javascript">
                        function startLogin() {
                            $('login_progress').show();
                            <c:choose>
                                <c:when test="${param.fromAjax == 'true'}">
                            new Ajax.Request('<c:url value="/home/home.action"/>', { onSuccess: completeLogin });
                                </c:when>
                                <c:otherwise>
                            completeLogin();
                                </c:otherwise>
                            </c:choose>
                        }

                        function completeLogin() {
                            $('login').submit();
                        }
                    </script>
                    <div id="login_progress" style="display: none; margin: 3px 3px">
                       <img alt="Indicator" align="absmiddle" src="<c:url value="/images/indicator.gif"/>" /> Logging in
                    </div>
            <form id="login" name="login" action="j_security_check" method="post" onsubmit="startLogin(); return false;">
                <table class="login">
                    <tbody>
                    <c:if test="${not empty failedLogin}">
                    <tr>
                        <td colspan="2" class="loginerror"><fmt:message key="login.error" /></td>
                    </tr>
                    </c:if>
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
                        <td colspan="2" class="centered"><input tabindex="3" src="<c:url value="/images/btn_login.gif" />"  value="Login" class="button" type="image"></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="space">&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="loginlinks">
                            <a href="<c:url value="/registration/input.action" />" class="loginlinks" tabindex="4"><fmt:message key="register" /></a> |
                            <a href="<c:url value="/forgotPassword/input.action" />" class="loginlinks" tabindex="5"><fmt:message key="login.forgotpassword" /></a>
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