<%@ tag display-name="treeNode"  description="Displays the node in tree"  body-content="empty" %>
<%@ attribute name="name" required="true" type="java.lang.String"%>
<%@ attribute name="url" required="true" type="java.lang.String"%>
<%@ attribute name="cssClass" required="true" type="java.lang.String"%>

<a href="javascript://noop/" onclick="ProtExpress.loadDiv('${url}', 'detail-content', true); return false;" class="${cssClass}">${name}</a>