<%@ tag display-name="homeButton"  description="Displays the button"  body-content="empty" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ attribute name="href" required="true" type="java.lang.String"%>
<%@ attribute name="divId" required="true" type="java.lang.String"%>
<%@ attribute name="btnId" required="true" type="java.lang.String"%>
<%@ attribute name="textKey" required="true" type="java.lang.String"%>

<c:url var="actionUrl" value="${href}" />

<div id="${divId}">
    <a id="${btnId}" href="javascript://noop/"
        onclick="ProtExpress.loadDiv('${actionUrl}', 'divAjaxBody', true); this.blur(); return false;">
        <fmt:message key="${textKey}" />
    </a>
</div>

