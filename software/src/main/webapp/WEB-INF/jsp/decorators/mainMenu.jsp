<%--L
  Copyright 5AM Solutions, Inc.

  Distributed under the OSI-approved BSD 3-Clause License.
  See http://ncip.github.com/prot-express/LICENSE.txt for details.
L--%>

<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu"%>
<menu:useMenuDisplayer name="ListMenu">
    <% if (request.isUserInRole("protExpressUser")) { %>
        <menu:displayMenu name="protExpressMain" />
    <% } else { %>
        <menu:displayMenu name="protExpressLogin" />
    <% } %>
</menu:useMenuDisplayer>
<div id="quicklinks">
    <menu:useMenuDisplayer name="ListMenu">
        <menu:displayMenu name="globalLinks" />
    </menu:useMenuDisplayer>
</div>

<script language="javascript">
setActiveMenu('<%= request.getContextPath() %>');
</script>