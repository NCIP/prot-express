<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="protExpress" %>

<div class="searchresults">
    <h2><fmt:message key="protexpress.page.search.resultstitle" /></h2>
    <table class="newdata2">
        <tbody>
            <tr>
            <th>Experiment Name in</th>
            <th>Description</th>
            <th>User</th>
            <th>Date &amp; Time</th>
            <th class="action">Status</th>
            <th class="action">Edit</th>
            <th class="action">Download</th>
            </tr>
          <tr>
              <td><a href="http://www.nsdev.us/5am/protexpress/experimentsummary.htm">Oligonucleotide Gene Expression E</a></td>
              <td>Sample description</td>
              <td><a href="mailto:kkanchinadam@email.com">kkanchinadam<img class="TargetAlertIcon" src="<c:url value="/images/outlook.png" />"></a></td>
              <td>02/31/08 9:52 AM</td>
              <td class="action"><span title="Incomplete"><img src="<c:url value="/images/ico_asterisk.gif" />"  alt="Incomplete"></span></td>
              <td class="action"><a href=""><img src="<c:url value="/images/ico_edit.gif" />" alt="Edit"></a></td>
              <td class="action">&nbsp;</td>
            </tr>
        </tbody>
    </table>
    <!--Paging-->
  <div class="pagecontrol">
      <p class="small">Displaying <strong>1-10</strong> of <strong>15</strong> Total.</p>
      <div class="paging">Page 1 <span class="bar">|</span> <a href="#">2<img class="TargetAlertIcon" src="<c:url value="/images/internal.png" />"></a>&nbsp;&nbsp;&lt; Back <span class="bar">|</span>
          <a href="#">Next &gt;<img class="TargetAlertIcon" src="<c:url value="/images/internal.png" />"></a>
      </div>
  </div>
    <!--/Paging-->
</div>