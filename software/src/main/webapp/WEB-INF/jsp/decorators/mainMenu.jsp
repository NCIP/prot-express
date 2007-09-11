<%@ taglib uri="http://struts-menu.sf.net/tag-el" prefix="menu"%>
<menu:useMenuDisplayer name="Simple">
<% if (request.isUserInRole("protExpressUser")) { %>
    <menu:displayMenu name="protExpressMain" />
<% } else { %>
    <menu:displayMenu name="protExpressLogin" />
<% } %>
    <menu:displayMenu name="protExpressAbout" />
    <menu:displayMenu name="globalLinks" />
</menu:useMenuDisplayer>