<%@ include file="/init.jsp" %>



<a href="<portlet:actionURL name='navigateToAddPage'/> " class="btn  btn-primary btn-default">
	Ajouter une Classe
</a>

<liferay-ui:search-container delta="20" emptyResultsMessage="no-entries-were-found" total="${classes.size()}">
	<liferay-ui:search-container-results calculateStartAndEnd="true"  results="${classes}" />

	<liferay-ui:search-container-row className="classe.model.Classe" keyProperty="classeId" modelVar="c" escapedModel="<%=true%>" cssClass="table">
		<liferay-ui:search-container-column-text name="Num Classe">
			<div class="truncate">${c.classeId}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Titre">
			<div class="truncate">${c.intitule}</div>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="Actions">
			<a href="<portlet:actionURL name='consulter'>
                            <portlet:param name='classeId' value='${c.classeId}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="view"  label="<liferay-ui:message key='etudiant.view' />" />
			</a>
			<a href="<portlet:actionURL name='navigateToEditPage'>
                    <portlet:param name='classeId' value='${c.classeId}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="edit"  label="<liferay-ui:message key='etudiant.edit' />" />
			</a>
			<a href="<portlet:actionURL name='delete'>
                            <portlet:param name='classeId' value='${c.classeId}' />
                    </portlet:actionURL>">
				<liferay-ui:icon image="delete"  label="<liferay-ui:message key='classe.suppress' />" />
			</a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>