function getCurrentSection(hrefString, appContext) {
    var arr = hrefString.split('/');

    for(var i = 0; i < arr.length; i++) {
        if (arr[i].length > 0 && ('/' + arr[i].toLowerCase()) != appContext.toLowerCase()) {
            return arr[i].toLowerCase();
        }
    }
    return null;
}

function setActiveMenu(appContext) {
    if(document.location.href) {
        currentLocation = document.location.href;
    } else {
        currentLocation = document.location;
    }

    if (document.getElementById('leftnav') != null && currentLocation != null) {
        menuItems = document.getElementById('leftnav').getElementsByTagName('ul')[0].getElementsByTagName('a');
        for(var i = 0; i < menuItems.length; i++) {
            if(menuItems[i].href == currentLocation) {
                menuItems[i].className = 'selected';
                return;
            }
        }
        if (document.location.pathname != null && getCurrentSection(document.location.pathname, appContext) != null) {
            currentSection = getCurrentSection(document.location.pathname, appContext);
            for(var i = 1; i < menuItems.length; i++) {
                if(getCurrentSection(menuItems[i].pathname, appContext) == currentSection) {
                    menuItems[i].className = 'selected';
                    return;
                }
            }
        }
    }
}