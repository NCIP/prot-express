<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h2>Protcols</h2>

<s:url id="sortUrl" action="protocol/list" />
<s:url id="addUrl" action="protocol/save!load" />
<fmt:message key="label.add" var="addLink" />
<display:table defaultsort="1" list="${protocols}" pagesize="10" requestURI="${sortUrl}" id="row" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="name" titleKey="label.protocol.name" sortable="true" />
    <display:column property="description" titleKey="label.protocol.description" sortable="true" />
    <display:column property="type.displayName" titleKey="label.protocol.type" sortable="true" />
    <display:column title="<a href='${addUrl}'>${addLink}</a>">
        <s:url id="loadUrl" action="protocol/save!load.action">
            <s:param name="protocol.id" value="${row.id}" />
        </s:url>
        <a href="${loadUrl}"><s:text name="label.edit" /></a>
        <s:url id="deleteUrl" action="protocol/save!delete">
            <s:param name="protocol.id" value="${row.id}" />
        </s:url>
        <a href="${deleteUrl}"><s:text name="label.delete" /></a>
    </display:column>
</display:table>
