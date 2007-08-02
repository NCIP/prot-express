<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<h2>Protcols</h2>

<table border="1">
    <tr>
        <th><s:text name="label.protocol.name" /></th>
        <th><s:text name="label.protocol.description" /></th>
        <th><s:text name="label.protocol.type" /></th>
        <th><s:url id="url" action="protocol/save!load"/><a href="${url}"><s:text name="label.add"/></a></th>
    </tr>
    <c:forEach items="${protocols}" var="protocol">
        <tr>
            <td>${protocol.name}</td>
            <td>${protocol.description}</td>
            <td>${protocol.type.displayName}</td>
            <td>
                <s:url id="url" action="protocol/save!load">
                    <s:param name="protocol.id" value="${protocol.id}" />
                </s:url>
                <a href="${url}"><s:text name="label.edit" /></a>
                <s:url id="url" action="protocol/save!delete">
                    <s:param name="protocol.id" value="${protocol.id}" />
                </s:url>
                <a href="${url}"><s:text name="label.delete" /></a></td>
        </tr>
    </c:forEach>
</table>