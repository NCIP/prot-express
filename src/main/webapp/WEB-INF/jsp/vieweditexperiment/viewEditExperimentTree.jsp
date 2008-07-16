<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<ul class="pde">
    <li>
		<span id="span_${experiment.id}">
        <%@ include file="/WEB-INF/jsp/tree/experimentNode.jsp"%>
        </span>    
        <%@ include file="/WEB-INF/jsp/tree/experimentRunNodes.jsp"%>
    </li>
</ul>
