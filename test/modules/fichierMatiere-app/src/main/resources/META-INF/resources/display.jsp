<%@ include file="/init.jsp" %>

<aui:fieldset>

    <c:forEach var="matiere" items="${matieres}">
        <c:if test="${fichierMatiere.matiereId == matiere.matiereId}">
            <aui:input required="true" id="matiere" name="matiere" disabled="true" label="Matière" value="${matiere.intitule}" />
        </c:if>
    </c:forEach>

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

    <aui:button-row>
        <aui:button type="button" value="Retour" onClick="history.back();" />
    </aui:button-row>
</aui:fieldset>
