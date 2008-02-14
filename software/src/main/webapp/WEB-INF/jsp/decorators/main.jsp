<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title><fmt:message key="protexpress" /> - <decorator:title default="Welcome" /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <decorator:head />
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/prototype.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/scriptaculous.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/builder.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/controls.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/dragdrop.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/effects.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/slider.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/ajaxtags.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/ajaxtags_controls.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/ajaxtags/ajaxtags_parser.js"/>"></script>
    <script type="text/javascript" language="javascript" src="<c:url value="/scripts/protExpress.js"/>"></script>
    <link rel="address bar icon" href="<c:url value="/images/favicon.ico"/>">
    <link rel="icon" href="<c:url value="/images/favicon.ico"/>o" type="image/x-icon">
    <link rel="shortcut icon" href="<c:url value="/images/favicon.ico"/>" type="image/x-icon">
    <link rel="stylesheet" href="<c:url value="/stylesheets/protExpress.css"/>" media="screen" type="text/css"/>
    <link rel="stylesheet" href="<c:url value="/stylesheets/style.css"/>" media="screen" type="text/css"/>
</head>

<body onload="src/main/webapp/images/arrow_up.png""<decorator:getProperty property="body.onload" />">

<!--  HEADER -->
<div id="header"><%@ include file="/WEB-INF/jsp/decorators/mainHeader.jsp"%></div>
<!--  END OF HEADER -->

<!-- MAIN ROW (Area between header and footer) -->
<div id="main">

    <div id="contentwrapper">
        <!--  CONTENT -->
        <div id="<decorator:getProperty property="contentCssId" default="content" />" style="margin-bottom: 5px;">

            <!-- DECORATED BODY -->
            <decorator:body />
            <!-- END DECORATED BODY -->

        </div>
        <!--  END OF CONTENT -->
    </div>

    <!-- LEFTNAV -->
    <div id="leftnav"><c:import url="/WEB-INF/jsp/decorators/mainMenu.jsp" /></div>
    <!--  END OF LEFTNAV -->

    <div class="clear"></div>
</div>
<!-- END IF MAIN ROW -->

<!--  FOOTER -->
<div id="footerwrapper"><%@ include file="/WEB-INF/jsp/decorators/mainFooter.jsp"%></div>
<!--  END OF FOOTER -->

</body>
</html>