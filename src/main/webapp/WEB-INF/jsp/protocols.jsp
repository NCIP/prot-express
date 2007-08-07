<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h2>Protcols</h2>

<c:url var="sortUrl" value="/protocol/list.action" />
<c:url var="addUrl" value="/protocol/save!load.action" />
<fmt:message key="label.add" var="addLink" />
<display:table defaultsort="1" list="${protocols}" pagesize="10" requestURI="${sortUrl}" id="row" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="name" titleKey="label.protocol.name" sortable="true" />
    <display:column property="description" titleKey="label.protocol.description" sortable="true" />
    <display:column property="type.displayName" titleKey="label.protocol.type" sortable="true" />
    <display:column title="<a href='${addUrl}'>${addLink}</a>">
        <c:url var="loadUrl" value="/protocol/save!load.action">
            <c:param name="protocol.id" value="${row.id}" />
        </c:url>
        <a href="${loadUrl}"><s:text name="label.edit" /></a>
        <c:url var="deleteUrl" value="/protocol/save!delete.action">
            <c:param name="protocol.id" value="${row.id}" />
        </c:url>
        <a href="${deleteUrl}"><s:text name="label.delete" /></a>
    </display:column>
</display:table>
