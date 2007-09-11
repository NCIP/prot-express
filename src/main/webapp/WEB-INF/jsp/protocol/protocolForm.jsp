<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<body>
<s:if test="protocol==null || protocol.id == null">
    <h2><fmt:message key="protocol.add" /></h2>
</s:if>
<s:else>
    <h2><fmt:message key="protocol.edit" /></h2>
</s:else>

<s:form action="protocol/management/save" method="post">
    <s:textfield name="protocol.name" label="%{getText('protocol.name')}" size="40" />
    <s:textfield name="protocol.description" label="%{getText('protocol.description')}" size="40" />
    <s:select name="protocol.type" label="%{getText('protocol.type')}"
        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey=""
        headerValue="%{getText('protocol.type.select')}" />
    <s:hidden name="protocol.Id" />
    <s:submit value="%{getText('save')}" />
    <s:submit value="%{getText('cancel')}" name="redirect-action:protocol/search/loadSearch" />
</s:form>
</body>
</html>