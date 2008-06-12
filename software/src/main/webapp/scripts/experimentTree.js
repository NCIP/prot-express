function toggleTreeNodeAndRefreshDetailsView(id, url) {
        var li = document.getElementById(id);
        var sub = li.getElementsByTagName("ul")[0];
        if (sub){
        if (sub.style.display == "none") {
            sub.style.display = "block";
        } else {
            sub.style.display = "none";
        }}
        clearSelectionClass();
        var span = li.getElementsByTagName("span")[0];
        span.className = "selected";
        refreshDetailsView(url);
    }
    function clearSelectionClass() {
        var tree = document.getElementById('treeview');
        var list = tree.getElementsByTagName("span");
        var i = list.length - 1;
        var span;
        do {
            span = list[i];
            if (span.className == "selected") {
                span.removeAttribute("class");
            }
        } while (i--);
    }

    function selectTreeNode(id) {
        clearSelectionClass();
        var li = document.getElementById(id);
        var span = li.getElementsByTagName("span")[0];
        span.className = "selected";
        var sub = li.getElementsByTagName("ul")[0];
        sub.style.display = "block";
        // expand parents
        var tree = document.getElementById('treeview');
        var elt = li;
        while (elt != tree) {
            if (elt.style.display == "none") {
                sub.style.display = "block";
            }
            elt = elt.parentNode;
        }
    }

    function refreshDetailsView(actionUrl) {
        var divId = "detail-content";
        loadDiv(actionUrl, divId);
    }