<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="gov.nih.nci.protexpress.data.persistent.Protocol"%>
<%@page import="java.util.List"%>
<%@page import="gov.nih.nci.protexpress.ProtExpressRegistry"%>
<%
            List<Protocol> protocols = ProtExpressRegistry.getProtocolService().getAllProtocols();
            pageContext.setAttribute("protocols", protocols);
%>
List of protocols:
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
    </tr>
    <c:forEach items="${protocols}" var="protocol">
        <tr>
            <td>${protocol.name}</td>
            <td>${protocol.description}</td>
            <td>${protocol.type.displayName}</td>
        </tr>
    </c:forEach>
</table>