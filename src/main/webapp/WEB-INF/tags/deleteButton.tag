<%@ tag display-name="deleteButton"  description="Displays the Delete button"  body-content="empty" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ attribute name="href" required="false" type="java.lang.String"%>
<%@ attribute name="onclick" required="false" type="java.lang.String"%>
<%@ attribute name="style" required="true" type="java.lang.String"%>
<%@ attribute name="text" required="false" type="java.lang.String"%>
<%@ attribute name="textKey" required="false" type="java.lang.String"%>
<%@ attribute name="deleteConfirmText" required="true" type="java.lang.String"%>
<%@ attribute name="id" required="false" type="java.lang.String" description="DOM element ID for the anchor, usefull for tests and scripts"%>
<c:set var="idHtml" value="id='${id}'"/>
<c:if test="${not empty textKey}">
<fmt:message key="${textKey}" var="text"/>
<fmt:message key="${deleteConfirmText}" var="deleteConfirmationMessage"/>
</c:if>
<c:if test="${empty href}">
<c:set var="href" value="javascript://noop/"/>
</c:if>
<li><a href="${href}" onclick=" if (confirm('${deleteConfirmationMessage}')) ${onclick}; this.blur();" class="btn" ${empty id ? "" : idHtml}><span class="btn_img"><span class="${style}">${text}</span></span></a></li>