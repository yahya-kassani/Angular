<%@ page import="matiere.app.portlet.MatiereDTO" %>
<%@ page import="java.util.List" %>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<%
    List<MatiereDTO> matieres = (List<matiere.app.portlet.MatiereDTO>) request.getAttribute("matieres");
%>

<aui:fieldset>
    <legend>Liste des Matières</legend>
    <% if (matieres != null && !matieres.isEmpty()) { %>
    <div style="margin-bottom: 30px">
        <% for (matiere.app.portlet.MatiereDTO matiere : matieres) { %>
        <div>
            <aui:input name="matiereId" label="Matière ID" value="<%= matiere.getMatiereId() %>" disabled="true" />
            <aui:input name="classeId" label="Classe ID" value="<%= matiere.getClasseId() %>" disabled="true" />
            <aui:input name="professeurId" label="Professeur ID" value="<%= matiere.getProfesseurId() %>" disabled="true" />
            <aui:input name="intitule" label="Intitulé" value="<%= matiere.getIntitule() %>" disabled="true" />
            <aui:input name="nomIntitue" label="Nom Intitulé" value="<%= matiere.getNomIntitue() %>" disabled="true" />
            <aui:input name="nomProf" label="Nom Professeur" value="<%= matiere.getNomProf() %>" disabled="true" />
            <br/><br/>
        </div>
        <% } %>
    </div>
    <% } else { %>
    <p>Aucune matière trouvée pour l'ID spécifié.</p>
    <% } %>
</aui:fieldset>
