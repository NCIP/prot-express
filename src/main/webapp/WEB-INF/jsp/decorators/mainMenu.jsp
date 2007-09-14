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
function getCurrentSection(hrefString) {
    var arr = hrefString.split('/');
    contextPathString = '/' + arr[0];
    if (contextPathString == '<%= request.getContextPath() %>') {
        return arr[1];
    }
    return arr[0];
}

function setActiveMenu() {
    if(document.location.href) {
        currentLocation = document.location.href;
        getCurrentSection(document.location.pathname);
    } else {
        currentLocation = document.location;
    }

    if (document.getElementById('leftnav')!= null && currentLocation != null) {
        menuItems = document.getElementById('leftnav').getElementsByTagName('a');
        for(var i=0; i < menuItems.length; i++) {
            if(menuItems[i].href == currentLocation) {
                menuItems[i].className = 'selected';
                return;
            }
        }
        if (document.location.pathname != null) {
            currentSection = getCurrentSection(document.location.pathname);
            for(var i=0; i < menuItems.length; i++) {
                if(getCurrentSection(menuItems[i].href) == currentSection) {
                    menuItems[i].className = 'selected';
                    return;
                }
            }
        }
    }
}

setActiveMenu();
</script>