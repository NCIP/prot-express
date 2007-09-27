<%@ attribute name="tabHeaderKey" required="true"%>
<%@ attribute name="tabUrl" required="true"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="isActive" required="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<li <c:if test="${isActive}" >class="active"</c:if>>
    <s:a href="${tabUrl}" id="${id}" targets="boxinner" theme="ajax" onclick="setSelectedTab(this)"><fmt:message key="${tabHeaderKey}"/></s:a>
</li>