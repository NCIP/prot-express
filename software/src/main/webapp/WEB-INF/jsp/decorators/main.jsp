<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<%@ include file="/WEB-INF/jsp/decorators/mainHead.jsp"%>

<body onload="<decorator:getProperty property="body.onload" />">

<!--  HEADER -->
<div id="header"><%@ include file="/WEB-INF/jsp/decorators/mainHeader.jsp"%></div>
<!--  END OF HEADER -->

<!-- MAIN ROW (Area between header and footer) -->
<div id="main">

    <div id="contentwrapper">
        <!--  CONTENT -->
        <div id="<decorator:getProperty property="contentCssId" default="content" />" style="margin-bottom: 5px;">

            <!-- DECORATED BODY -->
            <div id="divAjaxBody">
                <decorator:body />
            </div>
            <!-- END DECORATED BODY -->

        </div>
        <!--  END OF CONTENT -->
        <div class="clear"><br></div>
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