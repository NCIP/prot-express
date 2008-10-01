<%@ tag display-name="homeButton"  description="Displays the button"  body-content="empty" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ attribute name="textKey" required="true" type="java.lang.String"%>
<%@ attribute name="selected" required="false" type="java.lang.String"%>
<%@ attribute name="insertNextStepIndicator" required="false" type="java.lang.String"%>

<c:choose>
    <c:when test="${selected == 'true'}"><c:set var="cssClass" value="selectedstep" /></c:when>
    <c:otherwise><c:set var="cssClass" value="step" /></c:otherwise>
</c:choose>

<div class="${cssClass}">
    <fmt:message key="${textKey}" />
</div>
<c:if test="${insertNextStepIndicator == 'true'}" >
    <div class="arrow"><img src="<c:url value="/images/processarrow.gif" />" alt="" /></div>
</c:if>
