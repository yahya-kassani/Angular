<%@ include file="/init.jsp" %>

<portlet:actionURL name="add" var="addURL"></portlet:actionURL>


<aui:form action="<%= addURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input required="true" id="intitule" name="intitule" label="Intitule"></aui:input>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter"></aui:button>
    </aui:button-row>
</aui:form>
