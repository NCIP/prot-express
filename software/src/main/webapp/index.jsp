<%@page import="gov.nih.nci.protexpress.data.persistent.Protocol"%>
<%@page import="java.util.List"%>
<%@page import="gov.nih.nci.protexpress.ProtExpressRegistry"%>
List of protocols:
<table border="1">
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Type</th>
    </tr>

<%
List<Protocol> protocols = ProtExpressRegistry.getProtocolService().getAllProtocols();
for (Protocol p : protocols) {
    pageContext.setAttribute("protocol", p);
%>
    <tr>
        <td>${protocol.name}</td>
        <td>${protocol.description}</td>
        <td>${protocol.type.displayName}</td>
    </tr>
<%
}
%>
</table>