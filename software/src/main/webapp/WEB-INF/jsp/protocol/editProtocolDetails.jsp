<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<title><fmt:message key="protexpress.page.editprotocoldetails.caption" /></title>
<body>
    <!-- Breadcrumb -->
    <div id="breadcrumb">
        <c:url var="editProtocolDetailsUrl" value="/protocol/editProtocolDetails.action">
            <c:param name="protocol.id" value="${protocol.id}" />
        </c:url>

        <a href="<c:url value="/home/home.action" />"><fmt:message key="protexpress.breadcrumb.home" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="<c:url value="/search/reloadSearch.action" />"><fmt:message key="protexpress.breadcrumb.search" /></a>&nbsp;<span class="&gt;">&gt;</span>
        <a href="${editProtocolDetailsUrl}" class="selected"><fmt:message key="protexpress.breadcrumb.editprotocoldetails" /></a>
    </div>
    <!-- /Breadcrumb -->

<!-- Page Help -->
    <%@ include file="/WEB-INF/jsp/experiment/common/insertHelp.jsp"%>
<!-- /Page Help -->


<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.edit_protocol"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->


    <div class="padme8">
        <!--ADD CONTENT HERE-->
        <h1><fmt:message key="protexpress.page.editprotocoldetails.title" /></h1>
        <div class="fadebox">
            <h2>${protocol.name}</h2>
            <c:if test="${not empty successMessage}">
                <div class="confirm_msg">${successMessage}</div>
            </c:if>
            <s:form id="protocolForm" action="/protocol/save.action" method="post">
                <s:hidden name="protocol.id" />

                <fieldset class="leftfield">
                    <legend><fmt:message key="protexpress.page.editprotocoldetails.overviewtitle" /></legend>
                    <table class="form2">
                        <tr>
                            <td class="label_left">
                                <p>
                                    <protExpress:textfield formName="protocolForm" name="protocol.name" key="protexpress.protocol.name" required="true" maxlength="200"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label_left">
                                <p>
                                    <protExpress:textarea formName="protocolForm" name="protocol.description" key="protexpress.protocol.description" />
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label_left">
                                <p>
                                    <protExpress:textarea formName="protocolForm" name="protocol.notes" key="protexpress.protocol.notes" />
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label_left">
                                <p>
                                    <protExpress:textfield formName="protocolForm" name="protocol.software" key="protexpress.protocol.software" maxlength="200"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td class="label_left">
                                <p>
                                    <protExpress:textfield formName="protocolForm" name="protocol.instrument" key="protexpress.protocol.instrument" maxlength="200"/>
                                </p>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <!-- Protocol Contact -->
                <c:set var="formName" value="protocolForm" />
                <c:set var="title" value="protexpress.page.editprotocoldetails.contacttitle" />
                <c:set var="nameFirstName" value="protocol.contactPerson.firstName" />
                <c:set var="nameLastName" value="protocol.contactPerson.lastName" />
                <c:set var="nameEmail" value="protocol.contactPerson.email" />
                <c:set var="nameNotes" value="protocol.contactPerson.notes" />
                <%@ include file="/WEB-INF/jsp/experiment/common/contactPersonInfo.jsp"%>
                <!-- /Protocol Contact -->
            </s:form>
            <div class="clear"></div>
            <c:if test="${protocol.auditInfo.creator == currentUser.loginName}">
                <div class="actionsrow">
                    <del class="btnwrapper">
                        <ul id="btnrow2">
                            <li>
                                <c:url var="cancelUrl" value="/protocol/cancel.action">
                                    <c:param name="protocol.id" value="${protocol.id}" />
                                </c:url>
                                <a href="${cancelUrl}" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="cancel"><fmt:message key="protexpress.page.editprotocoldetails.button.back" /></span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <a href="javascript:document.getElementById('protocolForm').submit();" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="save"><fmt:message key="protexpress.page.editprotocoldetails.button.save" /></span>
                                    </span>
                                </a>
                            </li>
                            <li>
                                <c:url var="deleteProtocolUrl" value="/protocol/deleteProtocol.action">
                                    <c:param name="protocol.id" value="${protocol.id}" />
                                </c:url>
                                <a href="${deleteProtocolUrl}" class="btn" onclick="this.blur();">
                                    <span class="btn_img">
                                        <span class="delete"><fmt:message key="protexpress.page.editprotocoldetails.button.deleteprotocol" /></span>
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
