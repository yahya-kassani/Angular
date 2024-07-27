<%@ include file="/init.jsp" %>

<portlet:actionURL name="update" var="updateURL"></portlet:actionURL>

<aui:form action="<%= updateURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input type="hidden" name="professeurId" value="${professeur.professeurId}" />
        <aui:input required="true" id="nom" name="nom" label="Nom" value="${professeur.nom}" />
        <aui:input name="prenom" id="prenom" label="Prenom" value="${professeur.prenom}" />
        <aui:select name="classeIds" label="Classes" id="classeId" multiple="true">
            <c:forEach var="classe" items="${classes}">
                <aui:option value="${classe.classeId}" selected="${profClassesId.contains(classe.classeId)}">${classe.intitule}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Modifier"></aui:button>
    </aui:button-row>
</aui:form>
