<%@ tag display-name="textarea"  description="Displays a textarea"  body-content="empty" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@ attribute name="formName" required="true" type="java.lang.String"%>
<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="key" required="false" type="java.lang.String"%>
<%@ attribute name="labelposition" required="false" type="java.lang.String"%>
<%@ attribute name="required" required="false" type="java.lang.String"%>
<%@ attribute name="rows" required="false" type="java.lang.String"%>
<%@ attribute name="cols" required="false" type="java.lang.String"%>
<%@ attribute name="maxlength" required="false" type="java.lang.String"%>
<%@ attribute name="readonly" required="false" type="java.lang.String"%>
<%@ attribute name="style" required="false" type="java.lang.String"%>

<c:if test="${empty labelposition}">
    <c:set var="labelposition" value="top"/>
</c:if>
<c:if test="${empty required}">
    <c:set var="required" value="false"/>
</c:if>
<c:if test="${empty rows}">
    <c:set var="rows" value="4" />
</c:if>
<c:if test="${empty cols}">
    <c:set var="cols" value="20" />
</c:if>
<c:if test="${empty maxlength}">
    <c:set var="maxlength" value="2000"/>
</c:if>
<c:if test="${empty readonly}">
    <c:set var="readonly" value="false"/>
</c:if>
<c:if test="${empty style}">
    <c:set var="style" value=""/>
</c:if>
<c:choose>
    <c:when test="${empty key}">
        <c:set var="label" value="" />
    </c:when>
    <c:otherwise>
        <fmt:message var="label" key="${key}" />
    </c:otherwise>
</c:choose>

<c:set var="elementId" value="${formName}_${fn:replace(name, '.', '_')}" />
<fmt:message var="counterMessage" key="protexpress.textbox.charactersleft" />

<s:textarea name="%{#attr.name}" label="%{#attr.label}" labelposition="%{#attr.labelposition}" rows="%{#attr.rows}" cols="%{#attr.cols}"
            onkeydown="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.name}_remLenCounter', '%{#attr.maxlength}', '%{#attr.counterMessage}')"
            onkeyup="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.name}_remLenCounter', '%{#attr.maxlength}', '%{#attr.counterMessage}')"
            onfocus="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.name}_remLenCounter', '%{#attr.maxlength}', '%{#attr.counterMessage}'); ProtExpress.showDiv('div_%{#attr.name}_remLen')"
            onblur="ProtExpress.hideDiv('div_%{#attr.name}_remLen')"
            cssStyle="%{#attr.style}" required="%{#attr.required}" readonly="%{#attr.readonly}" theme="css_xhtml"></s:textarea>

<div id="div_${name}_remLen" class="confirm_msg" style="display:none">
    <font size="1" face="arial, helvetica, sans-serif">
        <label id="${name}_remLenCounter">${counterMessage}</label>
    </font>
</div>