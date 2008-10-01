<%@ tag display-name="homeButtonRow" description="Allows you to have multiple button elements in a single row" body-content="scriptless" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@ attribute name="textKey" required="true" type="java.lang.String"%>

<div class="home_buttons">
    <h2><fmt:message key="${textKey}" /></h2>
    <jsp:doBody />
    <div class="clear"></div>
</div>
