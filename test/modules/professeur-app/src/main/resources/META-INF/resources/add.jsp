<%@ include file="/init.jsp" %>

<portlet:actionURL name="add" var="addURL"></portlet:actionURL>


<aui:form action="<%= addURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>

        <aui:input required="true" id="nom" name="nom" label="Nom"></aui:input>
        <aui:input name="prenom" id="prenom" label="Prenom"></aui:input>

        <aui:select name="classeIds" label="Classes" id="classeId" multiple="true">
            <c:forEach var="classe" items="${classes}">
                <aui:option value="${classe.classeId}">${classe.intitule}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter"></aui:button>
    </aui:button-row>
</aui:form>