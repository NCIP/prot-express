
var spanClassSelected = "selected";
var styleDisplayBlock = "block";
var styleDisplayNone = "none";


function toggleTreeNode(treeNodeId, imgId, pathImageTreeArrowRight, pathImageTreeArrowDown) {
return;
    var treeNode = document.getElementById(treeNodeId);
    var imgNode = document.getElementById(imgId);
    if (treeNode) {
        if (treeNode.style.display == styleDisplayNone) {
            treeNode.style.display = styleDisplayBlock;
            if (imgNode) {
                imgNode.src = pathImageTreeArrowDown;
            }
        } else {
            treeNode.style.display = styleDisplayNone;
            if (imgNode) {
                imgNode.src = pathImageTreeArrowRight;
            }
        }
    }
}

function refreshDetailsScreen(treeNodeId, imgId, pathImageTreeArrowRight, pathImageTreeArrowDown, spanId, detailsUrl) {

    var spanNode = document.getElementById(spanId);
    if (spanNode) {
        clearSelectionClass();
        //spanNode.addAttribute("class", spanClassSelected);

        toggleTreeNode(treeNodeId, imgId, pathImageTreeArrowRight, pathImageTreeArrowDown);
        refreshDetailsView(detailsUrl);
    }
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
    }while (i--);
}

function refreshTreeView(actionUrl) {
    var divId = "treecol";
    loadDiv(actionUrl, divId);
}

function refreshDetailsView(actionUrl) {
    var divId = "detail-content";
    loadDiv(actionUrl, divId);
}

function selectTreeNode(spanId) {
   // alert(spanId);

}

function testSubmit(actionUrl) {
alert(actionUrl);
    var divId = "detail-content";
    loadDiv(actionUrl, divId);
}
