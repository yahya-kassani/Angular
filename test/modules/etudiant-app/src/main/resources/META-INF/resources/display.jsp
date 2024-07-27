<%@ include file="/init.jsp" %>

<aui:fieldset>
    <div style="margin-bottom: 30px">
        <label>Photo Etudiant: </label><br />
        <img src="${imageUrl}" alt="phot etudiant"  style="width: 200px; height: 200px;"/>
    </div>
    <aui:input required="true" id="nom" name="nom" disabled="true" label="Nom" value="${etudiant.nom}"></aui:input>
    <aui:input name="prenom" id="prenom" label="Prenom" disabled="true" value="${etudiant.prenom}"></aui:input>
</aui:fieldset>