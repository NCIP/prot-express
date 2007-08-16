<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<h2>Experiments</h2>

<c:url var="sortUrl" value="/experiment/list.action" />

<display:table defaultsort="1" list="${experiments}" pagesize="10" requestURI="${sortUrl}" id="row" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="name" titleKey="label.experiment.name" sortable="true" />
    <display:column property="description" titleKey="label.experiment.description" sortable="true" />
    <display:column property="url" titleKey="label.experiment.url" sortable="true" />
    <display:column titleKey="label.actions" sortable="false">
        <c:url var="loadUrl" value="/experiment/save!load.action">
            <c:param name="experiment.id" value="${row.id}" />
        </c:url>
        <a href="${loadUrl}"><s:text name="label.edit" /></a>
        <c:url var="deleteUrl" value="/experiment/save!delete.action">
            <c:param name="experiment.id" value="${row.id}" />
        </c:url>
        <a href="${deleteUrl}"><s:text name="label.delete" /></a>
    </display:column>
</display:table>

<s:url id="editExperiment" action="experiment/list"/>
<s:url id="addExperiment" action="experiment/save!load"/>
<a href="${searchExperiment}"><s:property value="%{getText('label.menu.experiment.search')}" /></a>
&nbsp;&nbsp;
<a href="${addExperiment}"><s:property value="%{getText('label.menu.experiment.add')}" /></a>