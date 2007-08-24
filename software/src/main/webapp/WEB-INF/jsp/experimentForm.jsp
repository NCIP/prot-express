<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<s:if test="experiment==null || experiment.id == null">
    <h2>Add New Experiment</h2>
</s:if>
<s:else>
    <h2>Edit Experiment</h2>
</s:else>


<s:form action="experiment/management/save" method="post">
    <s:textfield name="experiment.name" label="%{getText('label.experiment.name')}" size="40" />
    <s:textfield name="experiment.description" label="%{getText('label.experiment.description')}" size="40" />
    <s:textfield name="experiment.hypothesis" label="%{getText('label.experiment.hypothesis')}" size="40" />
    <s:textfield name="experiment.url" label="%{getText('label.experiment.url')}" size="40" />

    <s:hidden name="experiment.Id" />
    <s:submit value="%{getText('label.save')}" />
    <s:submit value="%{getText('label.cancel')}" name="redirect-action:experiment/search/loadSearch" />
</s:form>

