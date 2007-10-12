<%@page import="org.ajaxtags.xml.AjaxXmlBuilder, java.util.List"%><%
  String contentType = "text/xml;charset=UTF-8";
  response.setContentType(contentType);
%><%= new AjaxXmlBuilder().addItems((List)pageContext.findAttribute("protocols"), "name", "id").toString() %>