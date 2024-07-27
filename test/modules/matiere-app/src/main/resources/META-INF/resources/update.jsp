<%@ include file="/init.jsp" %>

<portlet:actionURL name="update" var="updateURL"></portlet:actionURL>

<aui:form action="<%= updateURL %>" name="<portlet:namespace />fm" method="post" id="myForm">

    <aui:input required="true" id="matiereId" name="matiereId" type="hidden" value="${matieres.matiereId}"></aui:input>

    <aui:fieldset>
        <aui:select name="classeId" label="Classe" id="classeId">
            <c:forEach var="classe" items="${classes}">
                <aui:option value="${classe.classeId}">${classe.intitule}</aui:option>
            </c:forEach>
        </aui:select>

        <aui:select name="professeurId" label="Professeur" id="professeurId">
            <c:forEach var="professeurs" items="${professeurs}">
                <aui:option value="${professeurs.professeurId}">${professeurs.nom} ${professeurs.prenom}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>
    <aui:fieldset>
        <aui:input required="true" id="intitule" name="intitule" label="Intitule" value="${matieres.intitule}"></aui:input>
    </aui:fieldset>


    <aui:button-row>
        <aui:button type="submit" value="Update"></aui:button>
    </aui:button-row>

</aui:form>
