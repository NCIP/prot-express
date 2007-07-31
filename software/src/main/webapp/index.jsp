<%@page import="gov.nih.nci.protexpress.data.persistent.Protocol"%>
<%@page import="java.util.List"%>
<%@page import="gov.nih.nci.protexpress.ProtExpressRegistry"%>
Welcome to the app!!

<%
List<Protocol> protocols = ProtExpressRegistry.getProtocolService().getAllProtocols();
for (Protocol p : protocols) {
    pageContext.setAttribute("protocol", p);
%>
  ${protocol.name}<br>
<% } %>