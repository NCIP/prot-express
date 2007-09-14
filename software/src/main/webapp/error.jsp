<%@ page isErrorPage="true" contentType="text/html" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<page:applyDecorator name="main">
<html>
<head>
</head>
<body>
An error has occurred:
<br><br>
<jsp:useBean id="now" class="java.util.Date" />
${now}<br>
Request that failed: ${pageContext.errorData.requestURI}<br>
Status code: ${pageContext.errorData.statusCode}<br>
Exception: ${pageContext.errorData.throwable}<br>
</body>
</html>
</page:applyDecorator>