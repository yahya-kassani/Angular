package etudiant.app.portlet;

import classe.model.Classe;
import classe.service.ClasseLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import etudiant.app.constants.EtudiantAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import etudiant.app.utility.EtudiantUtil;
import etudiant.app.utility.NavigationPageUtil;
import etudiant.model.Etudiant;
import etudiant.service.EtudiantLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
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
		"javax.portlet.display-name=EtudiantApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EtudiantAppPortletKeys.ETUDIANTAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EtudiantAppPortlet extends MVCPortlet {


	@Reference
	EtudiantLocalService etudiantLocalService;

	@Reference
	ClasseLocalService classeLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<EtudiantDTO> etudiants = etudiantLocalService.getEtudiants(-1,-1)
				.stream().map(this::transformDTO).filter(Objects::nonNull).collect(Collectors.toList());

		renderRequest.setAttribute("etudiants", etudiants);

		super.doView(renderRequest, renderResponse);
	}

	private EtudiantDTO transformDTO(Etudiant e) {
		try{
			final Classe classe = classeLocalService.getClasse(e.getClasseId());
			return new EtudiantDTO(e.getNom(),e.getPrenom(),classe.getIntitule(),e.getEtudiantId(),classe.getClasseId());
		}catch (Exception exception){
			return null;
		}

	}
	public void navigateToAddPage(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		List<Classe> classes = classeLocalService.getClasses(-1,-1);
		request.setAttribute("classes", classes);
		NavigationPageUtil.navigateToAddPage(classeLocalService,request, response);
	}

	public void display(ActionRequest request, ActionResponse response) throws PortalException {
		EtudiantUtil.display(etudiantLocalService,request,response);
	}

	public void add(ActionRequest request, ActionResponse response) throws Exception {
		EtudiantUtil.add(etudiantLocalService,request,response);
	}

	public void delete(ActionRequest request, ActionResponse response) throws PortalException {
		EtudiantUtil.delete(etudiantLocalService,request,response);
	}

	public void update(ActionRequest request,ActionResponse response) throws PortalException, IOException {
		EtudiantUtil.update(etudiantLocalService,request,response);
	}

	public void navigateToEditPage(ActionRequest request,ActionResponse response)throws PortalException{
		NavigationPageUtil.navigateToEditPage(classeLocalService,etudiantLocalService,request,response);
	}

}