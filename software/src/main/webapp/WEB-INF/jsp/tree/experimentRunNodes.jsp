<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<ul >
    <s:iterator id="experimentRun" value="%{experiment.experimentRuns}">
      <li>
      <span id="span_${experimentRun.id}">
            <%@ include file="/WEB-INF/jsp/tree/experimentRunNode.jsp"%>
      </span>
      <%@ include file="/WEB-INF/jsp/tree/protocolAppNodes.jsp"%>
  </li>
    </s:iterator>
</ul>