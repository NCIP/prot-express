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

function submitForm(actionUrl, formId) {
    document.getElementById(formId).action = actionUrl;
    document.getElementById(formId).submit();
}

var ProtExpress = {
    submitAjaxForm: function(formId, divId, options) {
        var formData = Form.serialize(formId);
        options = options || {};
        if (options.extraArgs) {
            formData = formData + '&' + Hash.toQueryString(options.extraArgs);
        }
        var url = options.url || $(formId).action;
        new Ajax.Updater(divId, url, {parameters: formData, evalScripts: true, insertion: options.insertion} );
    },
    submitAjaxFormToUrl: function(formId, divId, url) {
        var formData = Form.serialize(formId);
        var options = {};
        new Ajax.Updater(divId, url, {parameters: formData, evalScripts: true, insertion: options.insertion} );
    },
  submitDivAsForm: function(url, divId) {
      var div = document.getElementById(divId);
      var fields = div.getElementsByTagName("input");
      var params="";
      for (var i=0; i<fields.length; i++) {
          params += fields[i].name + "=" + escape(fields[i].value) + "&";
      }
      var aj = new Ajax.Updater(div, url, {
          asynchronous: true,
          method: 'post',
          evalScripts: true,
          parameters: params
      });
      return false;
  },
    loadDiv: function(url, divId, showLoadingIcon) {
    var div = document.getElementById(divId);
    if (showLoadingIcon) {
      div.innerHTML = '<div><img alt="Indicator" align="absmiddle" src="' + contextPath + '/images/loading.gif"/>&nbsp;Loading...</div>';
    }
    var aj = new Ajax.Updater(div, url, {
      asynchronous: true,
      method: 'get',
      evalScripts: true
    });
    return false;
  },
  submitDivOnReturn: function (e, addId) {
    var characterCode;
    if(e && e.which){
      e = e;
      characterCode = e.which;
    } else {
      e = event;
      characterCode = e.keyCode;
    }
    if(characterCode == 13){
      var add = document.getElementById(addId);
      add.onclick();
      return false
    }
    else{
      return true
    }
  },
  setFocusToFirstControl: function () {
    for (var f=0; f < document.forms.length; f++) {
      for(var i=0; i < document.forms[f].length; i++) {
        var elt = document.forms[f][i];
        if (elt.type != "hidden" && elt.disabled != true && elt.id != 'enableEnterSubmit') {
          try {
            elt.focus();
            return;
          } catch(er) {
          }
        }
      }
    }
  },
  textFieldCounter: function(elementId, labelId, maxLength, counterMessage) {
    var element = document.getElementById(elementId);
    var labelElement = document.getElementById(labelId);
    if (element.value.length > maxLength) {
        element.value = element.value.substring(0, maxLength);
    } else {
        var remainingChars = maxLength - element.value.length;
        labelElement.innerHTML = remainingChars + " " + counterMessage;
    }
  },
  showDiv: function(divId) {
    var divElement = document.getElementById(divId);
    divElement.style.display = "block";
  },
  hideDiv: function(divId) {
    var divElement = document.getElementById(divId);
    divElement.style.display = "none";
  },
  setHelpTopic: function(helpTopicId) {
    var pageHelpTopicElement = document.getElementById("pageHelpTopic");
    pageHelpTopicElement.value = helpTopicId;
  },
  showHelp: function(showNav) {
    var pageHelpTopicElement = document.getElementById("pageHelpTopic");
    var helpTopic = "welcome_help";
    if ((pageHelpTopicElement != null) && (pageHelpTopicElement.value != null) && (pageHelpTopicElement.value != "")) {
        helpTopic = pageHelpTopicElement.value;
    }
    var helpUrl = contextPath + "/help/index.html?";
    if (showNav) {
        helpUrl += "single=false&";
    }
    else {
        helpUrl += "single=true&";
    }

    helpUrl += "topic=" + helpTopic;
    window.open(helpUrl, "Help", "titlebar,status,scrollbars,resizable,alwaysRaised,dependent,width=800,height=500");
  }
}




