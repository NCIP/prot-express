<%@taglib prefix="s" uri="/struts-tags"%>

<s:url id="searchProtocol" action="protocol/loadSearch" />
<s:url id="addProtocol" action="protocol/load.action" />

<a href="${searchProtocol}"><s:property value="%{getText('label.menu.protocol.search')}" /></a>
<br />
<a href="${addProtocol}"><s:property value="%{getText('label.menu.protocol.add')}" /></a>