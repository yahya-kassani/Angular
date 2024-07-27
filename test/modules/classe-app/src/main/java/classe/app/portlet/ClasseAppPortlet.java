package classe.app.portlet;

import classe.app.constants.ClasseAppPortletKeys;

import classe.model.Classe;
import classe.service.ClasseLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

/**
 * @author lenovo
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ClasseApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ClasseAppPortletKeys.CLASSEAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class ClasseAppPortlet extends MVCPortlet {
	@Reference
	ClasseLocalService classeLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<Classe> classes = classeLocalService.getClasses(-1, -1);
		renderRequest.setAttribute("classes", classes);
		super.doView(renderRequest, renderResponse);
	}

	public void navigateToAddPage(ActionRequest request,ActionResponse response){
		response.getRenderParameters().setValue("mvcPath", "/add.jsp");
	}


	public void add(ActionRequest request, ActionResponse response) throws Exception {
		final String intitule = ParamUtil.getString(request, "intitule", "");
		classeLocalService.add(intitule);
	}

	public void delete(ActionRequest request, ActionResponse response) throws PortletException, PortalException {
		final long classeId = ParamUtil.getLong(request, "classeId", 0L);
		if(classeId != 0L){
			final Classe classe = classeLocalService.getClasse(classeId);
			classeLocalService.deleteClasse(classeId);
		}
	}

	public void navigateToEditPage(ActionRequest request, ActionResponse response) throws PortalException {
		final long classeId = ParamUtil.getLong(request, "classeId", 0L);

		if (classeId != 0L) {
			final Classe classe = classeLocalService.getClasse(classeId);
			request.setAttribute("classe", classe);
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
	}

	public void update(ActionRequest request, ActionResponse response) throws IOException, PortalException {
		final long classeId = ParamUtil.getLong(request, "classeId", 0L);
		final String intitule = ParamUtil.getString(request, "intitule", "");

		if(classeId > 0){
			final Classe classe = classeLocalService.getClasse(classeId);

			classeLocalService.update(classeId,intitule);
		}
	}

	public void consulter(ActionRequest request, ActionResponse response) throws PortalException {
		final long classeId = ParamUtil.getLong(request, "classeId", 0L);

		if(classeId != 0L){
			final Classe classe = classeLocalService.getClasse(classeId);
			request.setAttribute("classe", classe);
			response.getRenderParameters().setValue("mvcPath", "/consulter.jsp");
		}
	}


}