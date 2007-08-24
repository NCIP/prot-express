<%@taglib prefix="s" uri="/struts-tags" %>

<s:url id="searchExperiment" action="experiment/search/loadSearch"/>
<s:url id="addExperiment" action="experiment/management/load"/>

<a href="${searchExperiment}"><s:property value="%{getText('label.menu.experiment.search')}" /></a>
<br />
<a href="${addExperiment}"><s:property value="%{getText('label.menu.experiment.add')}" /></a>