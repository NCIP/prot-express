<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<script type="text/javascript">
  window.location='<c:url value="/login.action?fromAjax=${header['X-Requested-With'] == 'XMLHttpRequest' ? 'true' : 'false'}"/>';
</script>
