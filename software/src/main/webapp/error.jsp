<%@ page isErrorPage="true" contentType="text/html" %>

An error has occurred:
<br><br>
<jsp:useBean id="now" class="java.util.Date" />
${now}<br>
Request that failed: ${pageContext.errorData.requestURI}<br>
Status code: ${pageContext.errorData.statusCode}<br>
Exception: ${pageContext.errorData.throwable}<br>