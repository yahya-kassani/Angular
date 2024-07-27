<%@ include file="/init.jsp" %>

<portlet:actionURL name="add2" var="addURL"></portlet:actionURL>

<aui:form action="<%= addURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input required="true" id="nom" name="nom" disabled="true" label="Nom" value="${professeur.nom}" />
        <aui:input type="hidden" name="professeurId" value="${professeur.professeurId}" />
        <aui:input required="true" id="intitule" name="intitule" label="Intitule"></aui:input>
        <aui:select name="classeId" label="Classe" id="classeId">
            <c:forEach var="classe" items="${classes}">
                <aui:option value="${classe.classeId}">${classe.intitule}</aui:option>
            </c:forEach>
        </aui:select>

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter"></aui:button>
    </aui:button-row>
</aui:form>
