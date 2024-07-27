<%@ include file="/init.jsp" %>


<portlet:actionURL name="update" var="updateURL"></portlet:actionURL>

<aui:form action="<%= updateURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input required="true" id="etudiantId" name="etudiantId" type="hidden" value="${etudiant.etudiantId}"></aui:input>
        <div style="margin-bottom: 30px">
            <label>Photo Etudiant: </label><br />
            <c:choose>
                <c:when test = "${etudiant.imageId > 0}">
                    <img src="${imageUrl}" alt="photo etudiant"  style="width: 200px; height: 200px;"/>
                </c:when>
                <c:otherwise>
                    <label>Hello everyone</label>
                </c:otherwise>
            </c:choose>
        </div>

        <aui:input name="image" type="File" id="image" label="Nouvelle Image Etudiant" />
        <aui:input required="true" id="nom" name="nom" label="Nom" value="${etudiant.nom}"></aui:input>
        <aui:input name="prenom" id="prenom" label="Prenom" value="${etudiant.prenom}"></aui:input>
        <aui:select name="classeId" label="Classe" id="classeId">
            <c:forEach var="classe" items="${classes}">
                <aui:option value="${classe.classeId}" selected="${etudiant.classeId == classe.classeId}">${classe.intitule}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Modifier"></aui:button>
    </aui:button-row>
</aui:form>