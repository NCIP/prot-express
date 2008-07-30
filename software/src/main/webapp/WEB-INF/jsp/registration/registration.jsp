<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>
<html>
<head>
</head>
<body>

<!--Page Help-->
<a href="<c:url value="/notYetImplemented.html"/>" class="helpicon"><fmt:message key="help" /></a>
<!--/Page Help-->

<h1><fmt:message key="registration.header" /></h1>

<div class="box">
    <div class="formbox">
        <div id="boxinner">
            <h3><fmt:message key="registration.create.header" /></h3>
            <p class="info"><fmt:message key="registrationRequest.info"></fmt:message></p>

        <s:actionerror/>
        <s:form action="registration/save" method="post" id="regForm" theme="xhtml">
            <table class="form">
                <tr><th colspan="2">Security Information</th></tr>
                <c:if test="${ldapInstall == 'true'}">
                    <s:radio
                        name="ldapAuthenticate" key="registrationRequest.ldap" list="#{true: 'Yes', false:'No'}" tabindex="1"
                        onchange="$('acct_details')[$('regForm_ldapAuthenticatetrue').checked ? 'show' : 'hide']();"
                    />
                </c:if>

                <tbody id="acct_details" <s:if test="!ldapAuthenticate">style="display: none"</s:if> >
                <s:textfield name="registrationRequest.loginName" key="registrationRequest.loginName" id="loginName" tabindex="2" required="true"/>
                <s:password name="password" key="registrationRequest.password" id="password" tabindex="3" required="true"/>
                <c:if test="${ldapInstall == 'false'}">
                    <s:password name="passwordConfirm" key="registrationRequest.passwordConfirm" id="passwordConfirm" tabindex="4" required="true"/>
                </c:if>
                </tbody>
                <s:hidden name="registrationRequest.role" value="Principal Investigator"/>
                <%--
                <s:checkboxlist name="registrationRequest.role" key="registrationRequest.role"
                    list="@gov.nih.nci.protexpress.ui.actions.registration.UserRole@values()" listKey="name" listValue="name" tabindex="5" required="true" />
                --%>
                <tr><th colspan="2">Account Details</th></tr>
                <s:textfield name="registrationRequest.firstName" key="registrationRequest.firstName" size="50" tabindex="6" required="true" />
                <s:textfield name="registrationRequest.middleInitial" key="registrationRequest.middleInitial" size="50" tabindex="7" />
                <s:textfield name="registrationRequest.lastName" key="registrationRequest.lastName" size="50" tabindex="8" required="true" />
                <s:textfield name="registrationRequest.email" key="registrationRequest.email" size="50" tabindex="9" required="true" />
                <s:textfield name="registrationRequest.organization" key="registrationRequest.organization" size="50" tabindex="10" required="true" />
                <s:textfield name="registrationRequest.address1" key="registrationRequest.address1" size="50" tabindex="11" required="true" />
                <s:textfield name="registrationRequest.address2" key="registrationRequest.address2" size="50" tabindex="12" />
                <s:textfield name="registrationRequest.city" key="registrationRequest.city" size="50" tabindex="13" required="true" />
                <s:select key="registrationRequest.country"
                      name="registrationRequest.country"
                      list="countryList"
                      listKey="id"
                      listValue="printableName"
                      headerKey=""
                      headerValue="--Select a Country--"
                      value="registrationRequest.country.id"
                      tabindex="14"
                      required="true"
                      onchange="$('reg_state')[$('regForm_registrationRequest_country').value == '226' ? 'show' : 'hide']();$('reg_province')[$('regForm_registrationRequest_country').value != '226' ? 'show' : 'hide']();"
                />
                <tbody id="reg_state" <s:if test="registrationRequest.country.id != 226">style="display: none"</s:if>>
                <s:select key="registrationRequest.state" name="registrationRequest.state" list="stateList"
                      listKey="id" listValue="code" headerKey="" headerValue="--Select a State--"
                      id="state" value="registrationRequest.state.id" tabindex="15" required="true"
                />
                </tbody>
                <tbody id="reg_province" <s:if test="registrationRequest.country.id == 226">style="display: none"</s:if>>
                <s:textfield name="registrationRequest.province" key="registrationRequest.province" size="50" tabindex="15" required="true"/>
                </tbody>
                <s:textfield name="registrationRequest.zip" key="registrationRequest.zip" size="20" tabindex="15" required="true" />
                <s:textfield name="registrationRequest.phone" key="registrationRequest.phone" size="20" tabindex="16" required="true"/>
                <s:textfield name="registrationRequest.fax" key="registrationRequest.fax" size="20" tabindex="17"/>
            </table>
            <div class="hidesubmit"><input type="submit"></div>
        </s:form>
            <div class="clear"><br /></div>
            <c:url value="/home/home.action" var="cancelUrl"/>
        <protExpress:buttonRow>
            <protExpress:button style="cancel" textKey="cancel" id="save" href="${cancelUrl}"/>
            <protExpress:button style="register" textKey="registration.submit" id="delete" onclick="javascript:document.getElementById('regForm').submit();"/>
        </protExpress:buttonRow>
        </div>
    </div>
</div>
</body>
</html>

