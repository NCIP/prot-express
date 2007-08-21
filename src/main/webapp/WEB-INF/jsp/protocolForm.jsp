<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:if test="protocol==null || protocol.id == null">
    <h2>Add new protocol</h2>
</s:if>
<s:else>
    <h2>Update protocol</h2>
</s:else>


<s:form action="protocol/save" method="post">
    <s:textfield name="protocol.name" label="%{getText('label.protocol.name')}" size="40" />
    <s:textfield name="protocol.description" label="%{getText('label.protocol.description')}" size="40" />
    <s:select name="protocol.type" label="%{getText('label.protocol.type')}"
        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey=""
        headerValue="%{getText('label.protocol.type.select')}" />
    <s:hidden name="protocol.Id" />
    <s:submit value="%{getText('label.save')}" />
    <s:submit value="%{getText('label.cancel')}" name="redirect-action:protocol/loadSearch" />
</s:form>
