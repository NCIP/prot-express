<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader.jsp" />
<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolHeader2.jsp" />

    <div id="divAjaxAddOrSelectProtocolBody">
        <jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addNewProtocol.jsp" />
    </div>

<jsp:include page="/WEB-INF/jsp/experiment/create/protocol/addOrSelectProtocolFooter.jsp" />