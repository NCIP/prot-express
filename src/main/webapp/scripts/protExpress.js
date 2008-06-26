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

function setSelectedTab() {
    tabMenuItems = document.getElementById('tabbed').getElementsByTagName('li');
    for(var i = 0; i < tabMenuItems.length; i++) {
        tabLink = tabMenuItems[i].getElementsByTagName('a')[0];
        if(tabLink.className == 'current') {
            tabMenuItems[i].className = 'active';
        } else {
            tabMenuItems[i].className = '';
        }
        tabLink.blur();
    }
}

function showSubmittingText() {
    if (document.getElementById('submittingText') != null) {
        document.getElementById('submittingText').style.display = 'block';
        document.getElementById('theForm').style.display = 'none';
    }
}

function showLoadingText() {
    if (document.getElementById('loadingText') != null) {
        document.getElementById('loadingText').style.display = 'block';
        document.getElementById('theForm').style.display = 'none';
    }
}

ajaxSubmit = function(formId, divId) {
    showSubmittingText();
    formData = Form.serialize(formId);
    url = $(formId).action;
    new Ajax.Updater(divId, url, {parameters: formData, evalScripts: true} );
}

function loadDiv(actionUrl, divId) {
    var divElement = document.getElementById(divId);
    var aj = new Ajax.Updater(divElement, actionUrl, {asynchronous: true, method: 'get', evalScripts: true, executeScripts: true});

    alert (divElement.innerHTML);
    return false;
}

function submitForm(actionUrl, formId) {
    document.getElementById(formId).action = actionUrl;
    document.getElementById(formId).submit();
}
