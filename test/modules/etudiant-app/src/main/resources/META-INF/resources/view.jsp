<%@ include file="/init.jsp" %>



<a href="<portlet:actionURL name='navigateToAddPage'/> " class="btn  btn-primary btn-default">
	<i class="glyphicon glyphicon-plus">Ajouter un Etudiant</i>
</a>


<liferay-ui:search-container delta="20" emptyResultsMessage="no-entries-were-found" total="${etudiants.size()}">
	<liferay-ui:search-container-results calculateStartAndEnd="true"  results="${etudiants}" />

	<liferay-ui:search-container-row className="etudiant.app.portlet.EtudiantDTO" keyProperty="etudiantId" modelVar="e" escapedModel="<%=true%>" cssClass="table">

		<liferay-ui:search-container-column-text name="Titre">
			<div class="truncate">${e.nom}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Description">
			<div class="truncate">${e.prenom}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Numero de Classe">
			<div class="truncate">${e.classe}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Actions">
			<a href="<portlet:actionURL name='display'>
                            <portlet:param name='etudiantId' value='${e.id}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="view"  label="<liferay-ui:message key='etudiant.view' />" />
			</a>
			<a href="<portlet:actionURL name='navigateToEditPage'>
                            <portlet:param name='etudiantId' value='${e.id}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="edit"  label="<liferay-ui:message key='etudiant.edit' />" />
			</a>
			<a href="<portlet:actionURL name='delete'>
                            <portlet:param name='etudiantId' value='${e.id}' />
                    </portlet:actionURL>" onclick="return confirm('Are you sure you want to delete this item?');">
				<liferay-ui:icon image="delete"  label="<liferay-ui:message key='eservice.edit' />" />
			</a>

		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>