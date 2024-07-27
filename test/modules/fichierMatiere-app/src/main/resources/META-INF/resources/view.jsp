<%@ include file="/init.jsp" %>

<a href="<portlet:actionURL name='navigateToAddPage'/>" class="btn btn-primary btn-default">
	<i class="glyphicon glyphicon-plus"></i> Ajouter un Fichier
</a>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-entries-were-found" total="${fichierMatiere.size()}">
	<liferay-ui:search-container-results calculateStartAndEnd="true" results="${fichierMatiere}" />

	<liferay-ui:search-container-row className="fichiermatiere.app.portlet.FichierMatiereDTO" keyProperty="fichierMatiereId" modelVar="e" escapedModel="<%= true %>" cssClass="table">
		<liferay-ui:search-container-column-text name="ID">
			<div class="truncate">${e.fichierMatiereId}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Matière">
			<div class="truncate">${e.nomMatiere}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Fichier ID">
			<div class="truncate">${e.fichierId}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Actions">
			<a href="<portlet:actionURL name='display'>
                        <portlet:param name='fichierMatiereId' value='${e.fichierMatiereId}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="view" label="Voir" />
			</a>
			<a href="<portlet:actionURL name='navigateToEditPage'>
                        <portlet:param name='fichierMatiereId' value='${e.fichierMatiereId}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="edit" label="Éditer" />
			</a>
			<a href="<portlet:actionURL name='delete'>
                        <portlet:param name='fichierMatiereId' value='${e.fichierMatiereId}' />
                    </portlet:actionURL>" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet élément ?');">
				<liferay-ui:icon image="delete" label="Supprimer" />
			</a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>
