<%@taglib prefix="s" uri="/struts-tags" %>

<s:url id="searchProtocol" action="protocol/list"/>
<s:url id="editProtocol" action="protocol/list"/>
<s:url id="addProtocol" action="protocol/save!load.action"/>


<a href="${searchProtocol}"><s:property value="%{getText('label.menu.protocol.search')}" /></a>
<br />
<a href="${editProtocol}"><s:property value="%{getText('label.menu.protocol.edit')}" /></a>
<br />
<a href="${addProtocol}"><s:property value="%{getText('label.menu.protocol.add')}" /></a>