<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.view_experiment_protocol_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h3>${protocolApplication.protocol.name}</h3>
    <fieldset class="leftfield_wide">
        <legend><fmt:message key="protexpress.page.viewprotocolaplicationdetails.overviewtitle" /></legend>
        <table class="form">
            <tr>
                <td class="label_left"><fmt:message key="protexpress.protocol.name" />:<br/><p>${protocolApplication.protocol.name}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.protocol.description" />:<br/><p>${protocolApplication.protocol.description}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.protocol.notes" />:<br/><p>${protocolApplication.notes}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.protocol.software" />:<br/><p>${protocolApplication.protocol.software}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.protocol.instrument" />:<br/><p>${protocolApplication.protocol.instrument}</p></td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield_thin">
        <legend><fmt:message key="protexpress.protocolapplication.dateperformed" /></legend>
        <table class="form">
            <tr>
                <td class="label_left"><p><fmt:formatDate type="date" pattern="MM/dd/yyyy" dateStyle="short" value="${protocolApplication.datePerformed}" /></p></td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield_thin">
        <legend><fmt:message key="protexpress.page.viewprotocolaplicationdetails.contacttitle" /></legend>
        <table class="form">
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.firstname" />:<br/><p>${protocolApplication.protocol.contactPerson.firstName}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.lastname" />:<br/><p>${protocolApplication.protocol.contactPerson.lastName}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.email" />:<br/>
                    <p><a href="mailto:${protocolApplication.protocol.contactPerson.email}">${protocolApplication.protocol.contactPerson.email}</a></p>
                </td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.notes" />:<br/><p>${protocolApplication.protocol.contactPerson.notes}</p></td>
            </tr>
        </table>
    </fieldset>
    <div class="clear"><br /></div>
