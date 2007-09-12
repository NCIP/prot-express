<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<body>
<h2><fmt:message key="registration.header" /></h2>
<s:form action="registration/save" method="post">
    <s:textfield name="user.loginName" label="%{getText('user.loginName')}" size="40" />
    <s:textfield name="user.firstName" label="%{getText('user.firstName')}" size="40" />
    <s:textfield name="user.lastName" label="%{getText('user.lastName')}" size="40" />
    <s:textfield name="user.emailId" label="%{getText('user.emailId')}" size="40" />
    <s:password name="user.password" label="%{getText('user.password')}" size="40" />
    <s:password name="passwordConfirmation" label="%{getText('passwordConfirmation')}" size="40" />
    <s:submit value="%{getText('register')}" />
</s:form>
</body>
</html>