<%@ tag display-name="bubblePopupImage"  description="Displays the datefield"  body-content="empty" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="imgUrl" required="true" type="java.lang.String"%>
<%@ attribute name="bodyText" required="true" type="java.lang.String"%>

<a href="javascript://noop/" onclick="this.blur(); return false;"
            onmouseover="return overlib('${bodyText}', BUBBLE, BUBBLETYPE, 'quotation', TEXTSIZE, 'x-small');"
            onmouseout="nd();">
    <img src="${imgUrl}" alt="" />
</a>
