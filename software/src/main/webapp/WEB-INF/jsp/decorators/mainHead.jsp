<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<head>
    <title><fmt:message key="protexpress.page.default.caption" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <decorator:head />
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/prototype.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/scriptslib/scriptaculous.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/ajaxtags.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/ajaxtags_controls.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/ajaxtags_parser.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/protExpress.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/experimentTree.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/pde.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/calendar/calendar.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/calendar/calendar-setup.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/calendar/calendar-en.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/overlib/overlibmws.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/overlib/overlibmws_bubble.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/overlib/overlibmws_filter.js"/>"></script>
    <link rel="address bar icon" href="<c:url value="/images/favicon.ico"/>">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>" type="image/x-icon">
    <link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>" media="screen" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/stylesheets/protExpress.css"/>" media="screen" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/stylesheets/treeview.css"/>" media="screen" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/stylesheets/calendar/calendar.css"/>" media="screen" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/stylesheets/overwrite.css"/>" media="screen" type="text/css"/>
  <script type="text/javascript" language="javascript">
      var contextPath = "<%=request.getContextPath()%>";
  </script>
</head>

<c:set var="divAjaxBodyId" value="divAjaxBody" />
<c:set var="peFormId" value="peFormId" />







