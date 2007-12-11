<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<%@ taglib uri="http://ajaxtags.org/tags/ajax" prefix="ajax" %>
<html>
<head>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="protocols.search" /> | <a href="<c:url value="/protocol/management/load.action" />" class="add"><fmt:message key="protocol.add" /></a></h1>

<c:if test="${not empty successMessage}">
    <div class="confirm_msg">${successMessage}</div>
</c:if>

    <div class="box">
        <div class="formbox">
            <s:form action="protocol/search/doSearch" method="post">
                <div id="boxinner">
                    <h3><fmt:message key="search.criteria" /></h3>
                    <s:hidden name="protocols.sortDirection" />
                    <s:hidden name="protocols.sortCriterion" />
                    <s:textfield name="searchParameters.name" key="protocol.name" size="40" tabindex="1" />
                    <s:textarea name="searchParameters.description" key="protocol.description" rows="4" cols="37" tabindex="2" />
                    <s:select name="searchParameters.types" key="protocol.type"
                        list="@gov.nih.nci.protexpress.data.persistent.ProtocolType@values()" listValue="displayName" headerKey=""
                        multiple="true" tabindex="3" />
                    <s:submit value="%{getText('search')}" tabindex="4" />
                </div>
            </s:form>

            <c:if test="${protocols.list != null}">
                <div id="boxinner">
                    <h3><fmt:message key="search.results" /></h3>
                    <jsp:include page="/WEB-INF/jsp/protocol/protocolSearchResults.jsp" />
                </div>
            </c:if>
        </div>
    </div>
</body>
</html>