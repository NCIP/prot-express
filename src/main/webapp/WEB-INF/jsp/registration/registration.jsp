<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<body onload="document.getElementById('regForm_user_loginName').focus();">

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="registration.header" /></h1>

<div class="box">
    <div class="formbox">
        <div id="boxinner">
            <h3><fmt:message key="registration.create.header" /></h3>
            <s:form action="registration/save" method="post" id="regForm">
                <s:textfield name="user.loginName" key="user.loginName" size="40" tabindex="1" required="true"/>
                <s:textfield name="user.firstName" key="user.firstName" size="40" tabindex="2" required="true"/>
                <s:textfield name="user.lastName" key="user.lastName" size="40" tabindex="3" required="true"/>
                <s:textfield name="user.emailId" key="user.emailId" size="40" tabindex="4" required="true"/>
                <s:password name="user.password" key="user.password" size="40" tabindex="5" required="true"/>
                <s:password name="passwordConfirmation" key="passwordConfirmation" size="40" tabindex="6" required="true"/>
                <div class="hidesubmit"><input type="submit"></div>
            </s:form>
            <div class="actions">
                <a href="<c:url value="/dashboard/dashboard.action" />" tabindex="6" class="cancel"><fmt:message key="cancel" /></a>
                <a href="javascript:document.getElementById('regForm').submit();" tabindex="7" class="save"><fmt:message key="save" /></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>