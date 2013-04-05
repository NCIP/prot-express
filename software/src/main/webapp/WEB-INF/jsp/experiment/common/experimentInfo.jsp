<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<fieldset class="leftfield">
    <legend><fmt:message key="${title}" /></legend>
    <table class="form3">
        <tr>
            <td class="label_left">
                <protExpress:textfield formName="${formName}" name="${nameExperimentName}" key="protexpress.experiment.name"  required="true" maxlength="200"/>
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textarea formName="${formName}" name="${nameExperimentDescription}" key="protexpress.experiment.description" />
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textarea formName="${formName}" name="${nameExperimentHypothesis}" key="protexpress.experiment.hypothesis" maxlength="500"/>
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textfield formName="${formName}" name="${nameExperimentUrl}" key="protexpress.experiment.url" maxlength="200"/>
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textarea formName="${formName}" name="${nameExperimentNotes}" key="protexpress.experiment.notes" />
            </td>
        </tr>
    </table>
</fieldset>