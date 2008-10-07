<%@ tag display-name="pageHelp"  description="Displays the help"  body-content="empty" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="showNav" required="false" type="java.lang.String"%>

<c:if test="${empty showNav}">
    <c:set var="showNav" value="true"/>
</c:if>

<s:form id="pageHelpForm">
    <s:hidden id="pageHelpTopic" value="welcome_help" />
</s:form>


<a href="javascript://noop/" class="helpicon" onclick="ProtExpress.showHelp(${showNav}); this.blur(); return false;">
    <fmt:message key="protexpress.icon.help.title" />
</a>
