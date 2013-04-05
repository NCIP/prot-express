<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<ul>
    <s:iterator id="input" value="%{inputs}">
	<li>
	    <span id="span_${protApp.id}.${input.id}">    
            <%@ include file="/WEB-INF/jsp/tree/inputNode.jsp"%>        
	    </span>
	</li>            
    </s:iterator>
    <s:iterator id="output" value="%{outputs}">
	<li>
	    <span id="span_${protApp.id}.${output.id}">    
            <%@ include file="/WEB-INF/jsp/tree/outputNode.jsp"%>        
	    </span>
	</li>        
    </s:iterator>
</ul>