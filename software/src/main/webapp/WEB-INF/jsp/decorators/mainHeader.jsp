<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- NCI/NIH Header -->
<div id="nciheader">
    <div id="ncilogo">
        <a href="http://www.cancer.gov">
            <img src="<c:url value="/images/logotype.gif"/>" width="283" height="37" alt="Logo: National Cancer Institute" />
        </a>
    </div>
    <div id="nihtag">
        <a href="http://www.cancer.gov">
            <img src="<c:url value="/images/tagline.gif"/>" width="295" height="37" alt="Logo: U.S. National Institutes of Health | www.cancer.gov" />
        </a>
    </div>
</div>
<!-- END OF NCI/NIH Header -->

<!-- protExpress HEADER -->
<div id="protexpressheader">
    <div id="protexpresslogo">
        <a href="<c:url value="/"/>">
            <img src="<c:url value="/images/logo_protExpress.gif"/>" width="187" height="32" alt="Logo: protExpress - Proteomics Experiment &amp; Protocol Data Management System" />
        </a>
    </div>
    <c:if test="${pageContext.request.remoteUser != null}">
    <div id="userinfo">
        <fmt:message key="welcome" />, ${currentUserDisplayName} |
        <!-- <a href="<c:url value="/notYetImplemented.html"/>"><fmt:message key="account" /></a> | -->
        <a href="<c:url value="/logout.jsp"/>"><fmt:message key="logout" /></a>
    </div>
    </c:if>
</div>
<!-- END OF protExpress HEADER -->

<!-- TAG INFORMATION -->
<div id="infobar">
    <div id="rightinfo">
        <!-- <fmt:message key="build.tag" />:&nbsp;<span><a href="${initParam["build.svn.url"]}" target="blank">${initParam["build.tag"]}</a></span>&nbsp; -->
        <fmt:message key="build.tag" />:&nbsp;<span>${initParam["build.tag"]}</span>&nbsp;
        <span class="bar">|</span>
        <fmt:message key="build.time" />:&nbsp;<span>${initParam["build.time"]}</span>&nbsp;
        <span class="bar">|</span>
        <fmt:message key="build.node" />:&nbsp;<span>${initParam["build.node"]}</span>&nbsp;
    </div>
</div>
<!-- /TAG INFORMATION -->