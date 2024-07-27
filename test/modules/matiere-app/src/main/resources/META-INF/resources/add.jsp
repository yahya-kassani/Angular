<%@ include file="/init.jsp" %>

<portlet:actionURL name="add" var="addURL"></portlet:actionURL>

<aui:form action="<%= addURL %>" name="<portlet:namespace />fm" method="post" id="myForm">
    <aui:fieldset>
        <aui:select name="professeurId" label="Professeur" id="professeurId">
            <c:forEach var="professeurs" items="${professeurs}">
                <aui:option value="${professeurs.professeurId}">${professeurs.nom} ${professeurs.prenom}</aui:option>
            </c:forEach>
        </aui:select>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter"></aui:button>
    </aui:button-row>
</aui:form>
