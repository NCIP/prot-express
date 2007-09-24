<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<s:head theme="ajax" debug="true" />
</head>
<body>
<s:tabbedPanel id="experimentTabs" theme="simple">
    <s:div id="experimentMain" label="Experiment" theme="ajax">
        <s:if test="experiment==null || experiment.id == null">
            <h2><fmt:message key="experiment.add" /></h2>
        </s:if>
        <s:else>
            <h2><fmt:message key="experiment.edit" /></h2>
        </s:else>

        <s:form action="experiment/management/save" method="post">
            <s:textfield name="experiment.lsid" key="experiment.lsid" size="40" />
            <s:textfield name="experiment.name" key="experiment.name" size="40" />
            <s:textfield name="experiment.comments" key="experiment.comments" size="40" />
            <s:textfield name="experiment.hypothesis" key="experiment.hypothesis" size="40" />
            <s:textfield name="experiment.url" key="experiment.url" size="40" />

            <s:hidden name="experiment.Id" />
            <s:submit value="%{getText('save')}" />
            <s:submit value="%{getText('cancel')}" name="redirect-action:experiment/search/loadSearch" />
        </s:form>
    </s:div>
    <s:div id="experimentRuns" label="Experiment Runs" theme="ajax">
        This is just a placeholder for experiment runs.
    </s:div>
</s:tabbedPanel>
</body>
</html>