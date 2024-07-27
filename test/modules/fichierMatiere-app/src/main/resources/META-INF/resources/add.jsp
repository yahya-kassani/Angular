<%@ include file="/init.jsp" %>

<portlet:actionURL name="add" var="addURL"></portlet:actionURL>

<aui:form action="<%= addURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input name="fichier" type="file" id="fichier" label="Fichier de Matiere" />
        <aui:select name="matiereId" label="Matiere" id="matiereId">
            <c:forEach var="matiere" items="${matieres}">
                <aui:option value="${matiere.matiereId}">${matiere.intitule}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter"></aui:button>
    </aui:button-row>
</aui:form>
