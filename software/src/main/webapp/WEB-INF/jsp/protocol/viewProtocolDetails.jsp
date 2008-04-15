<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<title><fmt:message key="protexpress.page.viewprotocoldetails.caption" /></title>
<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <c:url var="viewProtocolDetailsUrl" value="/protocol/viewProtocolDetails.action">
            <c:param name="protocol.id" value="${protocol.id}" />
        </c:url>

        <a href="<c:url value="/home/home.action" />"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="<c:url value="/search/reloadSearch.action" />"><fmt:message key="protexpress.breadcrumb.search" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="${viewProtocolDetailsUrl}" class="selected"><fmt:message key="protexpress.breadcrumb.viewprotocoldetails" /></a>
    </div>
    <!-- /Breadcrumb -->
    <!-- Page Help -->
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->
    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.viewprotocoldetails.title" /></h1>
        <div class="fadebox">
            <h2>${protocol.name}</h2>
            <fieldset class="leftfield_wide">
                <legend><fmt:message key="protexpress.page.viewprotocoldetails.overviewtitle" /></legend>
                <table class="form2">
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.protocol.name" />:<br /><p>${protocol.name}</p></td>
                    </tr>
                        <td class="label_left"><fmt:message key="protexpress.protocol.description" />:<br /><p>${protocol.description}</p></td>
                    </tr>
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.protocol.notes" />:<br /><p>${protocol.notes}</p></td>
                    </tr>
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.protocol.software" />:<br /><p>${protocol.software}</p></td>
                    </tr>
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.protocol.instrument" />:<br /><p>${protocol.instrument}</p></td>
                    </tr>
                </table>
            </fieldset>
            <fieldset class="rightfield_thin">
                <legend><fmt:message key="protexpress.page.viewprotocoldetails.contacttitle" /></legend>
                <table class="form">
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.contact.firstname" />:<br /><p>${protocol.contactPerson.firstName}</p></td>
                    </tr>
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.contact.lastname" />:<br /><p>${protocol.contactPerson.lastName}</p></td>
                    </tr>
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.contact.email" />:<br /><p>${protocol.contactPerson.email}</p></td>
                    </tr>
                    <tr>
                        <td class="label_left"><fmt:message key="protexpress.contact.notes" />:<br /><p>${protocol.contactPerson.notes}</p></td>
                    </tr>
                </table>
            </fieldset>
            <div class="clear"></div>
            <c:if test="${protocol.auditInfo.creator == currentUser.loginName}">
                <c:url var="editProtocolDetailsUrl" value="/protocol/editProtocolDetails.action">
                    <c:param name="protocol.id" value="${protocol.id}" />
                </c:url>
                <div class="actionsrow">
                    <del class="btnrow2">
                        <ul id="btnrow2">
                            <li>
                                <a href="${editProtocolDetailsUrl}" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="edit"><fmt:message key="protexpress.page.viewprotocoldetails.button.editprotocol" /></span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <c:url var="deleteProtocolUrl" value="/protocol/deleteProtocol.action">
                                    <c:param name="protocol.id" value="${protocol.id}" />
                                </c:url>
                                <a href="${deleteProtocolUrl}" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="delete"><fmt:message key="protexpress.page.viewprotocoldetails.button.deleteprotocol" /></span>
                                    </span>
                                </a>
                            </li>
                        </ul>
                    </del>
                    <div class="clear"></div>
                </div>
            </c:if>
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
