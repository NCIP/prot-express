<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>


<html>
<head>
</head>
<body>

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.register_success"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h1><fmt:message key="registration.header" /></h1>

<div class="box">
    <div class="formbox">
        <div id="boxinner">
            <h3><fmt:message key="registration.success.header" /></h3>
            <div class="confirm_msg">
                <fmt:message key="registration.success.msg">
                    <fmt:param><a href="<c:url value="/home/home.action" />" tabindex="1"><fmt:message key="registration.here" /></a></fmt:param>
                </fmt:message>
            </div>
        </div>
    </div>
</div>
</body>
</html>