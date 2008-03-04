<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <a href="<c:url value="/" />"><fmt:message key="protexpress.breadcrumb.home" /></a> <span class="&gt;">&gt;</span>
        <a href="<c:url value="/" />" class="selected"><fmt:message key="protexpress.breadcrumb.search" /></a> <span class="&gt;">&gt;</span>
        <a href="<c:url value="/" />" class="selected"><fmt:message key="protexpress.breadcrumb.viewprotocolsummary" /></a>
    </div>
    <!-- /Breadcrumb -->
    <!-- Page Help -->
    <a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="protexpress.icon.help.title" /></a>
    <!-- /Page Help -->
    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.viewprotocolsummary.title" /></h1>
        <div class="fadebox">
            <h2>${protocol.name}</h2>
            <fieldset>
                <legend><fmt:message key="protexpress.page.viewprotocolsummary.overviewtitle" /></legend>
                <table class="form">
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.name" />:</td>
                        <td class="value">${protocol.name}</td>
                    </tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.description" />:</td>
                        <td class="value">${protocol.description}</td>
                    </tr>
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.notes" />:</td>
                        <td class="value">${protocol.notes}</td>
                    </tr>
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.software" />:</td>
                        <td class="value">${protocol.software}</td>
                    </tr>
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.instrument" />:</td>
                        <td class="value">${protocol.instrument}</td>
                    </tr>
                </table>
            </fieldset>
            <fieldset>
                <legend><fmt:message key="protexpress.page.viewprotocolsummary.contacttitle" /></legend>
                <table class="form">
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.contactfirstname" />:</td>
                        <td class="value">${protocol.contactPerson.firstName}</td>
                    </tr>
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.contactlastname" />:</td>
                        <td class="value">${protocol.contactPerson.lastName}</td>
                    </tr>
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.contactemail" />:</td>
                        <td class="value">${protocol.contactPerson.email}</td>
                    </tr>
                    <tr>
                        <td class="label"><fmt:message key="protexpress.page.viewprotocolsummary.contactnotes" />:</td>
                        <td class="value">${protocol.contactPerson.notes}</td>
                    </tr>
                </table>
            </fieldset>
            <div class="actionsrow">
                <del class="btnrow2">
                    <ul id="btnrow2">
                        <li>
                            <a href="protocoledit.htm" class="btn" onclick="this.blur();">
                                <span class="btn_img">
                                    <span class="edit"><fmt:message key="protexpress.page.viewprotocolsummary.editprotocol" /></span>
                                </span>
                            </a>
                        </li>
                    </ul>
                </del>
            </div>
        </div>
        <!--/ADD CONTENT HERE-->
    </div>
</body>
