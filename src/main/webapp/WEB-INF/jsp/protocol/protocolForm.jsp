<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
</head>
<body onload="document.getElementById('protocolForm_protocol_lsid').focus();">

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="protocols" /></h1>

<div class="box">
    <s:if test="protocol==null || protocol.id == null">
        <h2><fmt:message key="protocol.add" /></h2>
    </s:if>
    <s:else>
        <h2><fmt:message key="protocol.edit" /></h2>
    </s:else>
    <div class="padme5">
        <s:form action="protocol/management/save" method="post" id="protocolForm">
            <s:textfield name="protocol.lsid" key="protocol.lsid" size="40" />
            <s:textfield name="protocol.name" key="protocol.name" size="40" />
            <s:textfield name="protocol.description" key="protocol.description" size="40" />
            <s:select name="protocol.type" key="protocol.type"
                list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName"
                headerKey="" headerValue="%{getText('protocol.type.select')}" />
            <s:hidden name="protocol.Id" />
            <s:hidden name="resultingForward" />
            <div class="hidesubmit"><input type="submit"></div>
        </s:form>
    </div>
    <div class="actions">
        <s:if test="resultingForward == 'dashboard'">
            <c:url value="/dashboard/dashboard.action" var="cancelUrl"/>
        </s:if>
        <s:else>
            <c:url value="/protocol/search/loadSearch.action" var="cancelUrl"/>
        </s:else>
        <a href="${cancelUrl}" class="cancel"><fmt:message key="cancel" /></a>
        <a href="javascript:document.getElementById('protocolForm').submit();" class="save"><fmt:message key="save" /></a>
    </div>
</div>
</body>
</html>