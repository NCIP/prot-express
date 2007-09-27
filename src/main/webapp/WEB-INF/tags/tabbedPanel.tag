<%@ attribute name="initialFile" required="true"%>
<script type="text/javascript">
function setSelectedTab(currentLink) {
    tabMenuItems = document.getElementById('tabbed').getElementsByTagName('li');
    for(var i = 0; i < tabMenuItems.length; i++) {
        tabLink = tabMenuItems[i].getElementsByTagName('a')[0];
        if(tabLink.id == currentLink.id) {
            tabMenuItems[i].className = 'active';
        } else {
            tabMenuItems[i].className = '';
        }
    }
    currentLink.blur();
}
</script>
<ul id="tabbed">
    <jsp:doBody />
</ul>
<div class="selectedtabbox">
    <div id="boxinner">
        <jsp:include page="${initialFile}" />
    </div>
</div>