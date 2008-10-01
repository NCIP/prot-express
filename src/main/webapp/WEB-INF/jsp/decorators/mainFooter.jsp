<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="footernav">
    <a href="<c:url value="/notYetImplemented.html"/>"><fmt:message key="contact.us" /></a>
    <a href="http://www.nih.gov/about/privacy.htm"><fmt:message key="privacy.notice" /></a>
    <a href="http://www.nih.gov/about/disclaim.htm"><fmt:message key="disclaimer" /></a>
    <a href="http://www3.cancer.gov/accessibility/nci508.htm"><fmt:message key="accessibiity" /></a>
    <a href="<c:url value="/notYetImplemented.html"/>" class="last"><fmt:message key="protexpress.support" /></a>
</div>

<div id="partnerlogos">
    <a href="http://www.cancer.gov"><img src="<c:url value="/images/footer_nci.gif" />" width="63" height="31" alt="Logo: National Cancer Institute" /></a>
    <a href="http://www.dhhs.gov"><img src="<c:url value="/images/footer_hhs.gif" />" width="39" height="31" alt="Logo: Department of Health and Human Services" /></a>
    <a href="http://www.nih.gov"><img src="<c:url value="/images/footer_nih.gif" />" width="46" height="31" alt="Logo: National Institutes of Health" /></a>
    <a href="http://www.usa.gov"><img src="<c:url value="/images/footer_usagov.gif" />" width="91" height="31" alt="Logo: USA.gov" /></a>
</div>