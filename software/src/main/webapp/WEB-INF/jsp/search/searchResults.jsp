<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!--Search Results-->
<s:if test="experiments.list != null">
    <jsp:include page="/WEB-INF/jsp/search/searchExperimentResults.jsp" />
</s:if>
<s:elseif test="protocols.list != null">
    <jsp:include page="/WEB-INF/jsp/search/searchProtocolResults.jsp" />
</s:elseif>
<!--/Search Results-->