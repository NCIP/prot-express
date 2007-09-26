<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="registration.header" /></h1>

<div class="box">
    <div class="formbox">
        <div id="boxinner">
            <h3><fmt:message key="registration.success.header" /></h3>
            <div class="padme5">
                <fmt:message key="registration.success.msg">
                    <fmt:param><a href="<c:url value="/dashboard/dashboard.action" />"><fmt:message key="registration.here" /></a></fmt:param>
                </fmt:message>
            </div>
        </div>
    </div>
</div>
</body>
</html>