<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>


    <c:url var="refreshTreeUrl" value="/ajax/editExperiment/experiment/refreshExperimentTree.action">
        <c:param name="experimentId" value="${experiment.id}"/>
        <c:param name="treeNodeUrlPrefix" value="edit"/>
    </c:url>
    <script type="text/javascript">
        var actionUrl = '${refreshTreeUrl}';
        //alert('${refreshTreeUrl}');
        var divElement = "treeViewData";
        var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'post', evalScripts: true, executeScripts: true});
    </script>
