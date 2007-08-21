<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h2>Search Protcols</h2>

<fmt:message key="label.add" var="addLink" />

<s:form action="protocol/list" method="post">
    <s:textfield name="protocol.name" label="%{getText('label.protocol.name')}" size="40" />
    <s:textfield name="protocol.description" label="%{getText('label.protocol.description')}" size="40" />
    <s:select name="protocol.type" label="%{getText('label.protocol.type')}"
        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey="" multiple="true"/>
    <s:submit value="%{getText('label.menu.protocol.search')}" />
</s:form>