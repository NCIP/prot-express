<%@ tag display-name="protocolInputInfo"  description="Displays the datefield"  body-content="empty" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<%@ attribute name="imgInputTypeUrl" required="true" type="java.lang.String"%>
<%@ attribute name="inputName" required="true" type="java.lang.String"%>
<%@ attribute name="outputOfProtocolName" required="true" type="java.lang.String"%>

<c:set var="bodyText" value="<b>${inputName}</b><br /><hr />Output of Protocol: ${outputOfProtocolName}"></c:set>

<protExpress:bubblePopupImage bodyText="${bodyText}" imgUrl="${imgInputTypeUrl}"/>
