<%@taglib prefix="s" uri="/struts-tags" %>

<s:url id="searchExperiment" action="experiment/list"/>
<s:url id="editExperiment" action="experiment/list"/>
<s:url id="addExperiment" action="experiment/save!load.action"/>


<a href="${searchExperiment}"><s:property value="%{getText('label.menu.experiment.search')}" /></a>
<br />
<a href="${editExperiment}"><s:property value="%{getText('label.menu.experiment.edit')}" /></a>
<br />
<a href="${addExperiment}"><s:property value="%{getText('label.menu.experiment.add')}" /></a>