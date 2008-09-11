<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>

<fieldset class="rightfield">
    <legend><fmt:message key="${title}" /></legend>
    <table class="form3">
        <tr>
            <td class="label_left">
                <protExpress:textfield formName="${formName}"  name="${nameFirstName}" key="protexpress.contact.firstname"/>
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textfield formName="${formName}" name="${nameLastName}" key="protexpress.contact.lastname" />
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textfield formName="${formName}" name="${nameEmail}" key="protexpress.contact.email" />
            </td>
        </tr>
        <tr>
            <td class="label_left">
                <protExpress:textarea formName="${formName}" name="${nameNotes}" key="protexpress.contact.notes" />
            </td>
        </tr>
    </table>
</fieldset>
