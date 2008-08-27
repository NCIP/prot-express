<%@ tag display-name="breadCrumb"  description="Displays the breadcrumb"  body-content="empty" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ attribute name="href" required="true" type="java.lang.String"%>
<%@ attribute name="text" required="false" type="java.lang.String"%>
<%@ attribute name="textKey" required="false" type="java.lang.String"%>
<%@ attribute name="insertSymbol" required="false" type="java.lang.String"%>
<%@ attribute name="cssClass" required="false" type="java.lang.String"%>

<c:url var="actionUrl" value="${href}" />

<c:choose>
    <c:when test="${not empty text}"><c:set var="breadCrumbText" value="${text}" /></c:when>
    <c:when test="${not empty textKey}"><fmt:message var="breadCrumbText" key="${textKey}" /></c:when>
    <c:otherwise><fmt:message var="breadCrumbText" key="protexpress.breadcrumb.defaultText" /></c:otherwise>
</c:choose>
<a href="javascript://noop/"  class="${cssClass}"
    onclick="ProtExpress.loadDiv('${actionUrl}', 'divAjaxBody', true); this.blur(); return false;">${breadCrumbText}</a>
<c:if test="${empty insertSymbol || (insertSymbol == 'true')}" >
    <span class="&gt;">&gt;&gt;</span>
</c:if>
