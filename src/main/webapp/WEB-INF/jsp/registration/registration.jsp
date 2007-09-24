<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="registration.header" /></h1>

<div class="box">
    <h2>Create a new protExpress account</h2>
    <div class="padme5">
        <s:form action="registration/save" method="post" id="regForm">
            <s:textfield name="user.loginName" key="user.loginName" size="40" />
            <s:textfield name="user.firstName" key="user.firstName" size="40" />
            <s:textfield name="user.lastName" key="user.lastName" size="40" />
            <s:textfield name="user.emailId" key="user.emailId" size="40" />
            <s:password name="user.password" key="user.password" size="40" />
            <s:password name="passwordConfirmation" key="passwordConfirmation" size="40" />
        </s:form>
    </div>
    <div class="actions">
        <a href="<s:url action="dashboard/dashboard" />" class="cancel"><fmt:message key="cancel" /></a>
        <a href="javascript:document.getElementById('regForm').submit();" class="save"><fmt:message key="save" /></a>
    </div>
</div>
</body>
</html>