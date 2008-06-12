<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>

<div class="actionsrow">
    <del class="btnwrapper">
        <ul id="btnrow2">
            <li>
                <a href="${viewExperimentDetailsUrl}" class="btn" onclick="this.blur();">
                    <span class="btn_img"><span class="edit"><fmt:message key="protexpress.page.viewexperiment.detailsview.footer.editexperiment" /></span></span>
                </a>
            </li>
        </ul>
    </del>
</div>