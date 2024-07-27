<%@ include file="/init.jsp" %>

<portlet:actionURL name="update" var="updateURL"></portlet:actionURL>


<aui:form action="<%= updateURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input required="true" id="classeId" name="classeId" label="classeId" value="${classe.classeId}"></aui:input>
        <aui:input name="intitule" id="intitule" label="intitule" value="${classe.intitule}"></aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Modifier"></aui:button>
    </aui:button-row>
</aui:form>