package matiere.app.portlet;

import classe.model.Classe;
import classe.service.ClasseLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import matiere.app.constants.MatiereAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import matiere.model.Matiere;
import matiere.service.MatiereLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import professeur.model.ProfClasse;
import professeur.model.Professeur;
import professeur.service.ProfClasseLocalService;
import professeur.service.ProfesseurLocalService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lenovo
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=MatiereApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + MatiereAppPortletKeys.MATIEREAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class MatiereAppPortlet extends MVCPortlet {

	@Reference
	ProfesseurLocalService professeurLocalService;
	@Reference
	ClasseLocalService classeLocalService;

	@Reference
	MatiereLocalService matiereLocalService;

	@Reference
	ProfClasseLocalService profClasseLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<MatiereDTO> matieres=matiereLocalService.getMatieres(-1,-1)
				.stream().map(this::transformDTO).filter(Objects::nonNull).collect(Collectors.toList());

		renderRequest.setAttribute("matieres", matieres);
		super.doView(renderRequest, renderResponse);
	}
	private MatiereDTO transformDTO(Matiere e) {

		try {
			final Professeur professeur = professeurLocalService.getProfesseur(e.getProfesseurId());

			final Classe classe = classeLocalService.getClasse(e.getClasseId());
			return new MatiereDTO(professeur.getNom(),classe.getIntitule(),e.getIntitule(),e.getClasseId(),e.getProfesseurId(),e.getMatiereId());
		} catch (Exception exception) {
			return null;

		}
	}
	public void navigateToAddPage(ActionRequest request, ActionResponse response) {
		List<Professeur> professeurs = professeurLocalService.getProfesseurs(-1, -1);
		request.setAttribute("professeurs", professeurs);
		response.getRenderParameters().setValue("mvcPath", "/add.jsp");
	}
	public void add(ActionRequest request, ActionResponse response) throws PortalException {
		final long professeurId = ParamUtil.getLong(request, "professeurId", 0L);
		final Professeur professeur = professeurLocalService.getProfesseur(professeurId);
		List<ProfClasse> profClasses = profClasseLocalService.getClasseIdsByProfesseurId(professeurId);
		try {
			final List<Classe> classes = new ArrayList();
			for(var p : profClasses){
				classes.add(classeLocalService.getClasse(p.getClasseId()));
			}
			request.setAttribute("classes",classes);
		}catch (Exception e){

		}
		request.setAttribute("profClasses", profClasses);
		request.setAttribute("professeur", professeur);
		response.getRenderParameters().setValue("mvcPath", "/add2.jsp");
	}

	public void add2(ActionRequest request, ActionResponse response) {
		final long classeId = ParamUtil.getLong(request, "classeId", 0L);
		final String intitule = ParamUtil.getString(request, "intitule");
		final long professeurId = ParamUtil.getLong(request, "professeurId", 0L);
		matiereLocalService.add(classeId, professeurId,intitule);
	}


	public  void delete(ActionRequest request, ActionResponse response) throws PortalException {
		final long matiereId = ParamUtil.getLong(request, "matiereId", 0L);
		if(matiereId != 0L){
			final Matiere matiere = matiereLocalService.getMatiere(matiereId);
			matiereLocalService.deleteMatiere(matiereId);
		}
	}
	public void display(ActionRequest request, ActionResponse response) throws PortalException {
		final long matiereId = ParamUtil.getLong(request, "matiereId", 0L);
		List<MatiereDTO> filteredMatieres = getMatieresByMatiereId(matiereId);
		request.setAttribute("matieres", filteredMatieres);
		response.getRenderParameters().setValue("mvcPath","/display.jsp");
	}
	public List<MatiereDTO> getMatieresByMatiereId(long matiereId) {
		List<MatiereDTO> allMatieres = matiereLocalService.getMatieres(-1,-1)
				.stream().map(this::transformDTO).filter(Objects::nonNull).collect(Collectors.toList());

		List<MatiereDTO> filteredMatieres = allMatieres.stream()
				.filter(matiere -> matiere.getMatiereId() == matiereId)
				.collect(Collectors.toList());
		return filteredMatieres;
	}
	public void navigateToEditPage(ActionRequest request,ActionResponse response) throws PortalException {

		final long matiereId = ParamUtil.getLong(request, "matiereId", 0L);

		if(matiereId!=0L){

			final Matiere  matieres=matiereLocalService.getMatiere(matiereId);

			//List<Classe> classes = classeLocalService.getClasses(-1, -1);

			List<Professeur> professeurs = professeurLocalService.getProfesseurs(-1, -1);
			List<ProfClasse> profClasses = profClasseLocalService.getClasseIdsByProfesseurId(matieres.getProfesseurId());
			try {
				final List<Classe> classes = new ArrayList();
				for(var p : profClasses){
					classes.add(classeLocalService.getClasse(p.getClasseId()));
				}
				request.setAttribute("classes",classes);
			}catch (Exception e){

			}

			//request.setAttribute("classes", classes);

			request.setAttribute("professeurs", professeurs);

			request.setAttribute("matieres", matieres);

			response.getRenderParameters().setValue("mvcPath","/update.jsp");

		}

	}
	public void update(ActionRequest request,ActionResponse response) throws PortalException {

		final long matiereId = ParamUtil.getLong(request, "matiereId", 0L);

		final long classeId=ParamUtil.getLong(request,"classeId",0L);

		final long professeurId=ParamUtil.getLong(request,"professeurId",0l);

		final String intitule=ParamUtil.getString(request,"intitule",null);

		if(matiereId>0){
			matiereLocalService.update(matiereId,classeId,professeurId,intitule);
		}
	}

}