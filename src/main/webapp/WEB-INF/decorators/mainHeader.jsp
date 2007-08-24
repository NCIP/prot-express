<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<s:property value="%{getText('label.header.welcomeMsg')}" />

<s:url id="protocolUrl" action="protocol/search/loadSearch"/>
<s:url id="experimentUrl" action="experiment/search/loadSearch"/>


<a href="${protocolUrl}"><s:property value="%{getText('label.header.protocol')}" /></a>
&nbsp;
<a href="${experimentUrl}"><s:property value="%{getText('label.header.experiment')}" /></a>
