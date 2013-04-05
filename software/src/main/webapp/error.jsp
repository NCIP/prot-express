<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ page isErrorPage="true" contentType="text/html"%>
<%@ page import="java.io.PrintWriter,java.io.StringWriter,gov.nih.nci.protexpress.ProtExpressRegistry"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
ProtExpressRegistry.getErrorLogger().error("An error propogated to the jsp error page.", pageContext.getErrorData().getThrowable());
%>
<page:applyDecorator name="main">
    <html>
    <head>
    </head>
    <body>
    <fmt:message key="error.unexpected" />
    <c:if test="${debugModeEnabled}">
        <br>
        <br>
        <jsp:useBean id="now" class="java.util.Date" />
        <table>
            <tr>
                <td>Time:</td>
                <td>${now}</td>
            </tr>
            <tr>
                <td nowrap="nowrap">Failed Request:</td>
                <td>${pageContext.errorData.requestURI}</td>
            </tr>
            <tr>
                <td>Status code:</td>
                <td>${pageContext.errorData.statusCode}</td>
            </tr>
            <tr>
                <td>Message:</td>
                <td>${pageContext.errorData.throwable.message}</td>
            </tr>
            <tr>
                <td>Stack Trace</td>
                <td>
                <%
                    java.io.StringWriter sw = new StringWriter();
                    java.io.PrintWriter pw = new PrintWriter(sw);
                    pageContext.getErrorData().getThrowable().printStackTrace(pw);
                    pw.close();
                    out.println(sw);
                %>
                </td>
            </tr>
        </table>
    </c:if>
    </body>
    </html>
</page:applyDecorator>