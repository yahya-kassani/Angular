<%@ include file="/init.jsp" %>

<aui:fieldset>

    <aui:input required="true" id="nom" name="nom" disabled="true" label="Nom" value="${professeur.nom}"></aui:input>
    <aui:input name="prenom" id="prenom" label="Prenom" disabled="true" value="${professeur.prenom}"></aui:input>
    <aui:select name="classeIds" label="Classes" id="classeId" multiple="true" disabled="true">
        <c:forEach var="classe" items="${classes}">
            <aui:option value="${classe.classeId}">${classe.intitule}</aui:option>
        </c:forEach>
    </aui:select>
</aui:fieldset>