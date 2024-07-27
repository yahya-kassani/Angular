package fichiermatiere.app.portlet;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import fichiermatiere.app.constants.FichierMatiereAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import fichiermatiere.model.FichierMatiere;
import fichiermatiere.service.FichierMatiereLocalService;
import matiere.model.Matiere;
import matiere.service.MatiereLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.InputStream;
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
		"javax.portlet.display-name=FichierMatiereApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FichierMatiereAppPortletKeys.FICHIERMATIEREAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FichierMatiereAppPortlet extends MVCPortlet {
	private static final String FichierMatiere_FOLDER= "FichierMatiere_FOLDER";

	@Reference
	FichierMatiereLocalService fichierMatiereLocalService;

	@Reference
	MatiereLocalService matiereLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<FichierMatiereDTO> fichierMatiere = fichierMatiereLocalService.getFichierMatieres(-1,-1)
				.stream().map(this::transformDTO).filter(Objects::nonNull).collect(Collectors.toList());
		renderRequest.setAttribute("fichierMatiere", fichierMatiere);
		super.doView(renderRequest, renderResponse);
	}
	private FichierMatiereDTO transformDTO(FichierMatiere e) {
		try{
			final Matiere matiere = matiereLocalService.getMatiere(e.getMatiereId());
			return new FichierMatiereDTO(e.getFichierMatiereId(),e.getFichierId(),matiere.getMatiereId(),matiere.getIntitule());
		}catch (Exception exception){
			return null;
		}
	}
	public void navigateToAddPage(ActionRequest request, ActionResponse response) throws PortletException, IOException {
		List<Matiere> matieres = matiereLocalService.getMatieres(-1, -1);
		request.setAttribute("matieres", matieres);
		response.getRenderParameters().setValue("mvcPath","/add.jsp");
	}
	public void add(ActionRequest request, ActionResponse response) throws IOException, PortalException {
		final long matiereId = ParamUtil.getLong(request, "matiereId", 0L);
		final UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		final InputStream inputStream = uploadPortletRequest.getFileAsStream("fichier");
		long fichierId = 0L;

		if(inputStream != null) {
			final String fileName = uploadPortletRequest.getFileName("fichier");
			ServiceContext serviceContext = ServiceContextFactory.getInstance(FichierMatiereAppPortlet.class.getName(), request);

			final long folderId = findOrCreateFolderThenGetId(serviceContext, FichierMatiere_FOLDER);
			fichierId = addFichierThenGenerateId(serviceContext, folderId, fileName, inputStream);
		}

		fichierMatiereLocalService.add(matiereId,fichierId);

	}
	public long findOrCreateFolderThenGetId(ServiceContext serviceContext,String folderName) throws IOException, PortalException {
		final long parentId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

		try{
			Folder folder = DLAppLocalServiceUtil.getFolder(serviceContext.getScopeGroupId(), parentId, folderName);
			return folder.getFolderId();
		}catch (Exception e){
			Folder folder = DLAppLocalServiceUtil.addFolder(
					"",
					serviceContext.getUserId(),
					serviceContext.getScopeGroupId(),
					parentId,
					folderName,
					"",
					serviceContext
			);
			return folder.getFolderId();
		}

	}
	public long addFichierThenGenerateId(ServiceContext serviceContext, long folderId, String fileName, InputStream inputStream) throws IOException, PortalException {
		FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
				null,
				serviceContext.getUserId(),
				serviceContext.getScopeGroupId(),
				folderId,
				fileName,
				null,
				fileName,
				"",
				"",
				"",
				inputStream,
				inputStream.available(),
				null,
				null,
				serviceContext
		);
		return fileEntry.getFileEntryId();
	}
	public void delete(ActionRequest request, ActionResponse response) throws PortalException {
		final long fichierMatiereId = ParamUtil.getLong(request, "fichierMatiereId", 0L);
		if(fichierMatiereId != 0L){
			final FichierMatiere fichierMatiere = fichierMatiereLocalService.getFichierMatiere(fichierMatiereId);
			fichierMatiereLocalService.deleteFichierMatiere(fichierMatiereId);
			DLAppLocalServiceUtil.deleteFileEntry(fichierMatiere.getFichierId());
		}
	}
	public void navigateToEditPage(ActionRequest request, ActionResponse response)throws PortalException {
		final long fichierMatiereId = ParamUtil.getLong(request, "fichierMatiereId", 0L);

		if (fichierMatiereId != 0L) {
			final FichierMatiere fichierMatiere = fichierMatiereLocalService.getFichierMatiere(fichierMatiereId);
			List<Matiere> matieres = matiereLocalService.getMatieres(-1,-1);
			try {
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fichierMatiere.getFichierId());
				String fichierUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK, false, false);
				request.setAttribute("fichierUrl", fichierUrl);
			} catch (Exception e) {
			}
			request.setAttribute("fichierMatiere",fichierMatiere);
			request.setAttribute("matieres", matieres);
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
	}
	public void update(ActionRequest request,ActionResponse response) throws PortalException, IOException {
		final long fichierMatiereId = ParamUtil.getLong(request, "fichierMatiereId", 0L);
		final long matiereId = ParamUtil.getLong(request, "matiereId", 0L);
		final UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		final InputStream inputStream = uploadPortletRequest.getFileAsStream("fichier");


		if(fichierMatiereId > 0){
			long fichierId = 0L;
			final FichierMatiere fichierMatiere = fichierMatiereLocalService.getFichierMatiere(fichierMatiereId);

			if(inputStream != null) {
				final String fileName = uploadPortletRequest.getFileName("fichier");
				ServiceContext serviceContext = ServiceContextFactory.getInstance(FichierMatiereAppPortlet.class.getName(), request);

				final long folderId = findOrCreateFolderThenGetId(serviceContext, FichierMatiere_FOLDER);

				fichierId = addFichierThenGenerateId(serviceContext,folderId, fileName, inputStream);
			}
			else{
				fichierId = fichierMatiere.getFichierId();
			}
			fichierMatiereLocalService.update(fichierMatiereId,fichierId,matiereId);
		}
	}
	public void display(ActionRequest request, ActionResponse response) throws PortalException {
		final long fichierMatiereId = ParamUtil.getLong(request, "fichierMatiereId", 0L);
		final List<Matiere> matieres = matiereLocalService.getMatieres(-1,-1);

		if(fichierMatiereId != 0L){
			final FichierMatiere fichierMatiere = fichierMatiereLocalService.getFichierMatiere(fichierMatiereId);
			try{
				FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(fichierMatiere.getFichierId());
				String fichierUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK, false, false);
				request.setAttribute("fichierUrl", fichierUrl);
			}catch (Exception e){}
			request.setAttribute("fichierMatiere", fichierMatiere);
			request.setAttribute("matieres",matieres);
			response.getRenderParameters().setValue("mvcPath", "/display.jsp");
		}
	}

}