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
function setActiveMenu() {
    if(document.location.href) {
        currentLocation = document.location.href;
    } else {
        currentLocation = document.location;
    }

    if (document.getElementById('leftnav')!= null && currentLocation != null) {
        menuItems = document.getElementById('leftnav').getElementsByTagName('a');
        for(var i=0; i < menuItems.length; i++) {
            if(menuItems[i].href == currentLocation) {
                menuItems[i].className = 'selected';
                i = menuItems.length;
            }
        }
    }
}

setActiveMenu();
</script>