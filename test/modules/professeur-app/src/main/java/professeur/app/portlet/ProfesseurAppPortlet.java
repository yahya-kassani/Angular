package professeur.app.portlet;

import classe.model.Classe;
import classe.service.ClasseLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Reference;
import professeur.app.constants.ProfesseurAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import professeur.model.ProfClasse;
import professeur.model.Professeur;
import professeur.service.ProfClasseLocalService;
import professeur.service.ProfesseurLocalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lenovo
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ProfesseurApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ProfesseurAppPortletKeys.PROFESSEURAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ProfesseurAppPortlet extends MVCPortlet {

	@Reference
	ProfesseurLocalService professeurLocalService;

	@Reference
	ProfClasseLocalService profClasseLocalService;

	@Reference
	ClasseLocalService classeLocalService;
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		final List<Professeur> professeurs = professeurLocalService.getProfesseurs(-1,-1);

		renderRequest.setAttribute("professeurs", professeurs);
		super.doView(renderRequest, renderResponse);
	}

	public void add(ActionRequest request, ActionResponse response){
		final String nom = ParamUtil.getString(request,"nom","");
		final String prenom = ParamUtil.getString(request,"prenom","");
		final long[] classeIds = ParamUtil.getLongValues(request,"classeIds");

		try {
			final Professeur p = professeurLocalService.add(nom,prenom);
			for(long classeId : classeIds)
			{
				profClasseLocalService.add(p.getProfesseurId(),classeId);
			}
		}catch (Exception e) {

		}
	}

	public void navigateToAddPage(ActionRequest request, ActionResponse response) {
		List<Classe> classes = classeLocalService.getClasses(-1,-1);
		request.setAttribute("classes", classes);
		response.getRenderParameters().setValue("mvcPath","/add.jsp");
	}

	public void display(ActionRequest request, ActionResponse response) throws PortalException {
		final long professeurId = ParamUtil.getLong(request, "professeurId", 0L);

		if(professeurId != 0L){
			final Professeur professeur = professeurLocalService.getProfesseur(professeurId);

			try {

				final List<ProfClasse> profClasses = profClasseLocalService.getClasseIdsByProfesseurId(professeurId);
				final List<Classe> classes = new ArrayList();
				for(var p : profClasses){
					classes.add(classeLocalService.getClasse(p.getClasseId()));
				}
				request.setAttribute("classes", classes);
			}catch (Exception e) {

			}
			request.setAttribute("professeur", professeur);
			response.getRenderParameters().setValue("mvcPath", "/display.jsp");
		}
	}

	public  void delete(ActionRequest request, ActionResponse response) throws PortalException {
		final long professeurId = ParamUtil.getLong(request, "professeurId", 0L);
		if(professeurId != 0L){
			final Professeur professeur = professeurLocalService.getProfesseur(professeurId);
			professeurLocalService.deleteProfesseur(professeurId);
		}
	}

	public void navigateToEditPage(ActionRequest request, ActionResponse response)throws PortalException {
		final long professeurId = ParamUtil.getLong(request, "professeurId", 0L);

		if (professeurId != 0L) {

			final Professeur professeur = professeurLocalService.getProfesseur(professeurId);

			final List<Long> profClassesId =
					profClasseLocalService.getClasseIdsByProfesseurId(professeurId)
					.stream().map(ProfClasse::getClasseId).collect(Collectors.toList());

			List<Classe> classes = classeLocalService.getClasses(-1, -1);

			List<ClasseProffeurDTO> proffeurs = new ArrayList();

			request.setAttribute("professeur", professeur);
			request.setAttribute("classes", classes);
			request.setAttribute("profClassesId", profClassesId);
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
	}
	public void update(ActionRequest request, ActionResponse response) throws PortalException, IOException {
		final long professeurId = ParamUtil.getLong(request, "professeurId", 0L);
		final String nom = ParamUtil.getString(request, "nom", "");
		final String prenom = ParamUtil.getString(request, "prenom", "");
		final long[] classeIds = ParamUtil.getLongValues(request, "classeIds");

		if (professeurId > 0) {
			try {
				// Mettre à jour les informations du professeur
				Professeur professeur = professeurLocalService.getProfesseur(professeurId);
				professeurLocalService.update(professeurId,nom,prenom);

				// Mettre à jour les associations entre le professeur et les classes
				List<ProfClasse> currentProfClasses = profClasseLocalService.getClasseIdsByProfesseurId(professeurId);

				// Supprimer les anciennes associations
				for (ProfClasse profClasse : currentProfClasses) {
					profClasseLocalService.deleteProfClasse(profClasse);
				}

				// Ajouter les nouvelles associations
				for (long classeId : classeIds) {
					profClasseLocalService.add(professeurId, classeId);
				}

			} catch (Exception e) {
				e.printStackTrace();
				response.getRenderParameters().setValue("mvcPath", "/error.jsp");
			}
		}
	}

}