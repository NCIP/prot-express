<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>


<html>
<head>
</head>
<body>

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.forgotpasswordsuccess"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h1><fmt:message key="forgotpassword.header" /></h1>

<div class="box">
    <div class="formbox">
        <div id="boxinner">
            <h3><fmt:message key="forgotpassword.success.header" /></h3>
                <div class="confirm_msg">${successMessage}</div>
        </div>
    </div>
</div>
</body>
</html>