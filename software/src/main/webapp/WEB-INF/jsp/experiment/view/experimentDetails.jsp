<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>


<!-- Set Page Help Topic Id -->
<fmt:message var="helpTopicId" key="protexpress.help.view_experiment_details"></fmt:message>
<script type="text/javascript">
    ProtExpress.setHelpTopic("${helpTopicId}");
</script>
<!-- /Set Page Help Topic Id -->

<h3>${experiment.name}</h3>
    <fieldset class="leftfield_wide">
        <legend><fmt:message key="protexpress.page.viewexperimentdetails.overviewtitle" /></legend>
        <table class="form">
            <tr>
                <td class="label_left"><fmt:message key="protexpress.experiment.name" />:<br/><p>${experiment.name}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.experiment.description" />:<br/><p>${experiment.description}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.experiment.hypothesis" />:<br/><p>${experiment.hypothesis}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.experiment.url" />:<br/><p><a href="${experiment.url}">${experiment.url}</a></p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.experiment.notes" />:<br/><p>${experiment.notes}</p></td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield_thin">
        <legend><fmt:message key="protexpress.experiment.dateperformed" /></legend>
        <table class="form">
            <tr>
                <td class="label_left"><p><fmt:formatDate type="date" pattern="MM/dd/yyyy" dateStyle="short" value="${experiment.datePerformed}" /></p></td>
            </tr>
        </table>
    </fieldset>
    <fieldset class="rightfield_thin">
        <legend><fmt:message key="protexpress.page.viewexperimentdetails.contacttitle" /></legend>
        <table class="form">
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.firstname" />:<br/><p>${experiment.contactPerson.firstName}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.lastname" />:<br/><p>${experiment.contactPerson.lastName}</p></td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.email" />:<br/>
                    <p><a href="mailto:${experiment.contactPerson.email}">${experiment.contactPerson.email}</a></p>
                </td>
            </tr>
            <tr>
                <td class="label_left"><fmt:message key="protexpress.contact.notes" />:<br/><p>${experiment.contactPerson.notes}</p></td>
            </tr>
        </table>
    </fieldset>
<div class="clear"><br /></div>

