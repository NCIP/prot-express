<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<display:setProperty name="paging.banner.no_items_found">
    <div class="pagecontrol">No {0} found.
</display:setProperty>
<display:setProperty name="paging.banner.one_item_found">
    <div class="pagecontrol">One {0} found.
</display:setProperty>
<display:setProperty name="paging.banner.all_items_found">
    <div class="pagecontrol">
        <p class="small">Total <strong>{0}</strong> items found. Displaying all.</p>
</display:setProperty>
<display:setProperty name="paging.banner.some_items_found">
    <div class="pagecontrol">
        <p class="small">Displaying <strong>{2}-{3}</strong> of <strong>{0}</strong> Total.</p>
</display:setProperty>
<display:setProperty name="paging.banner.full">
    <div class="paging">
        &lt;<a href="{1}">First</a> <span class="bar">|</span> <a href="{2}">Prev</a>]&gt; {0} &lt;<a href="{3}">Next</a> <span class="bar">|</span> <a href="{4}">Last</a>&gt;
    </div></div>
</display:setProperty>
<display:setProperty name="paging.banner.first">
    <div class="paging">
        &lt;First <span class="bar">|</span> Prev&gt; {0} &lt;<a href="{3}">Next</a> <span class="bar">|</span> <a href="{4}">Last</a>&gt;
    </div></div>
</display:setProperty>
<display:setProperty name="paging.banner.last">
    <div class="paging">
        &lt;<a href="{1}">First</a> <span class="bar">|</span> <a href="{2}">Prev</a>&gt; {0} &lt;Next <span class="bar">|</span> Last&gt;
    </div></div>
</display:setProperty>
<display:setProperty name="paging.banner.onepage">
    <div class="paging">{0}</div></div>
</display:setProperty>