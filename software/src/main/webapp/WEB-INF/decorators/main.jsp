<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>ProtExpress - <decorator:title default="Welcome" /></title>
<decorator:head />
<link rel="stylesheet" href="<c:url value="/stylesheets/protExpress.css"/>" media="screen" type="text/css">
</head>

<body>
<!--  HEADER -->
<div id="header"><%@ include file="/WEB-INF/decorators/mainHeader.jsp"%></div>
<!--  END OF HEADER -->

<!--  MENU -->
<div id="menu"><c:import url="/WEB-INF/decorators/mainMenu.jsp" /></div>
<!--  END OF MENU -->

<!--  BODY -->
<div id="bodyContent"><decorator:body /></div>
<!--  END OF BODY -->

<!--  FOOTER -->
<div id="footer"><%@ include file="/WEB-INF/decorators/mainFooter.jsp"%></div>
<!--  END OF FOOTER -->

</body>
</html>