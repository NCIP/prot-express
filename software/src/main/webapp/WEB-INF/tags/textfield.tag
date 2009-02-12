<%@ tag display-name="textfield"  description="Displays a textbox"  body-content="empty" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ attribute name="formName" required="true" type="java.lang.String"%>
<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="key" required="false" type="java.lang.String"%>
<%@ attribute name="labelposition" required="false" type="java.lang.String"%>
<%@ attribute name="required" required="false" type="java.lang.String"%>
<%@ attribute name="maxlength" required="false" type="java.lang.String"%>
<%@ attribute name="readonly" required="false" type="java.lang.String"%>
<%@ attribute name="style" required="false" type="java.lang.String"%>
<%@ attribute name="cols" required="false" type="java.lang.String"%>
<%@ attribute name="nameAlias" required="false" type="java.lang.String"%>

<c:if test="${empty labelposition}">
    <c:set var="labelposition" value="top"/>
</c:if>
<c:if test="${empty required}">
    <c:set var="required" value="false"/>
</c:if>
<c:if test="${empty maxlength}">
    <c:set var="maxlength" value="100"/>
</c:if>
<c:if test="${empty readonly}">
    <c:set var="readonly" value="false"/>
</c:if>
<c:if test="${empty style}">
    <c:set var="style" value=""/>
</c:if>
<c:if test="${empty cols}">
    <c:set var="cols" value="50" />
</c:if>
<c:choose>
    <c:when test="${empty key}">
        <c:set var="label" value="" />
    </c:when>
    <c:otherwise>
        <fmt:message var="label" key="${key}" />
    </c:otherwise>
</c:choose>

<c:set var="sname" value="${formName}_${fn:replace(name, '.', '_')}" />
<fmt:message var="counterMessage" key="protexpress.textbox.charactersleft" />

<c:choose>
    <c:when test="${empty nameAlias}">
        <c:set var="divRemLenId" value="div_${sname}_remLen" />
        <c:set var="labelRemLenCounterId" value="label_${sname}_remLenCounter" />
        <c:set var="elementId" value="${sname}" />
    </c:when>
    <c:otherwise>
        <c:set var="divRemLenId" value="div_${nameAlias}_remLen" />
        <c:set var="labelRemLenCounterId" value="label_${nameAlias}_remLenCounter" />
        <c:set var="elementId" value="${formName}_${nameAlias}" />
    </c:otherwise>
</c:choose>


<c:choose>
    <c:when  test="${empty label}">
        <s:textfield
            name="%{#attr.name}" size="%{#attr.cols}"
            onkeydown="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.labelRemLenCounterId}', '%{#attr.maxlength}', '%{#attr.counterMessage}')"
            onkeyup="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.labelRemLenCounterId}', '%{#attr.maxlength}', '%{#attr.counterMessage}')"
            onfocus="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.labelRemLenCounterId}', '%{#attr.maxlength}', '%{#attr.counterMessage}'); ProtExpress.showDiv('%{#attr.divRemLenId}')"
            onblur="ProtExpress.hideDiv('%{#attr.divRemLenId}')"
            cssStyle="%{#attr.style}" maxlength="%{#attr.maxlength}" readonly="%{#attr.readonly}"></s:textfield>
    </c:when>
    <c:otherwise>
        <s:textfield
            name="%{#attr.name}" size="%{#attr.cols}"
            label="%{#attr.label}" labelposition="%{#attr.labelposition}" required="%{#attr.required}"
            onkeydown="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.labelRemLenCounterId}', '%{#attr.maxlength}', '%{#attr.counterMessage}')"
            onkeyup="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.labelRemLenCounterId}', '%{#attr.maxlength}', '%{#attr.counterMessage}')"
            onfocus="ProtExpress.textFieldCounter('%{#attr.elementId}', '%{#attr.labelRemLenCounterId}', '%{#attr.maxlength}', '%{#attr.counterMessage}'); ProtExpress.showDiv('%{#attr.divRemLenId}')"
            onblur="ProtExpress.hideDiv('%{#attr.divRemLenId}')"
            cssStyle="%{#attr.style}" maxlength="%{#attr.maxlength}" readonly="%{#attr.readonly}"></s:textfield>
    </c:otherwise>
</c:choose>


<div id="${divRemLenId}" class="textlen_msg" style="display:none">
    <font size="1" face="arial, helvetica, sans-serif">
        <label id="${labelRemLenCounterId}">${counterMessage}</label>
    </font>
</div>