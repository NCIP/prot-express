<%@ taglib uri="/struts-tags" prefix="s"%>

<!--Search Results-->
<s:if test="${experiments.list != null}">
    <jsp:include page="/WEB-INF/jsp/search/searchExperimentResults.jsp" />
</s:if>
<s:elseif test="${protocols.list != null}">
    <jsp:include page="/WEB-INF/jsp/search/searchProtocolResults.jsp" />
</s:elseif>
<!--/Search Results-->