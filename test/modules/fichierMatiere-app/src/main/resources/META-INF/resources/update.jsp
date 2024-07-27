<%@ include file="/init.jsp" %>

<portlet:actionURL name="update" var="updateURL"></portlet:actionURL>

<aui:form action="<%= updateURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:input required="true" id="fichierMatiereId" name="fichierMatiereId" type="hidden" value="${fichierMatiere.fichierMatiereId}"></aui:input>

        <div style="margin-bottom: 30px">
            <label>Document PDF: </label><br />
            <c:choose>
                <c:when test="${fichierMatiere.fichierMatiereId > 0}">
                    <iframe src="${fichierUrl}" width="600" height="400" style="border: none;"></iframe>
                </c:when>
                <c:otherwise>
                    <label>Pas de document disponible</label>
                </c:otherwise>
            </c:choose>
        </div>


        <aui:input required="true" id="fichierId" name="fichierId" label="fichierId" value="${fichierMatiere.fichierId}"></aui:input>
        <aui:input name="fichier" type="file" id="fichier" label="Nouvelle Fichier" />

        <aui:select name="matiereId" label="Matiere" id="matiereId">
            <c:forEach var="matiere" items="${matieres}">
                <aui:option value="${matiere.matiereId}" selected="${fichierMatiere.matiereId == matiere.matiereId}">${matiere.intitule}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Modifier"></aui:button>
    </aui:button-row>
</aui:form>
