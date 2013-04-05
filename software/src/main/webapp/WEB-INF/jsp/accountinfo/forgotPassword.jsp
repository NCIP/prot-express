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
<fmt:message var="helpTopicId" key="protexpress.help.forgotpassword"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h1><fmt:message key="forgotpassword.header" /></h1>

<div class="box">
    <div class="formbox">
        <div id="boxinner">
            <h3><fmt:message key="forgotpassword.request.header" /></h3>
            <p class="info"><fmt:message key="forgotpassword.info"></fmt:message></p>

        <s:actionerror/>
        <s:form action="forgotPassword/submitRequest" method="post" id="regForm" theme="xhtml">
            <s:textfield name="loginName" key="forgotpassword.loginName" id="loginName" tabindex="1" required="true"/>
            <s:textfield name="emailId" key="forgotpassword.emailId" id="emailId" tabindex="2" required="true"/>
        </s:form>
            <div class="clear"><br /></div>
            <c:url value="/home/home.action" var="cancelUrl"/>
        <protExpress:buttonRow>
            <protExpress:button style="cancel" textKey="cancel" id="save" href="${cancelUrl}"/>
            <protExpress:button style="register" textKey="forgotpassword.submit" id="delete" onclick="javascript:document.getElementById('regForm').submit();"/>
        </protExpress:buttonRow>
        </div>
    </div>
</div>
</body>
</html>

