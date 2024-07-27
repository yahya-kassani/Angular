package etudiant.app.utility;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import etudiant.app.portlet.EtudiantAppPortlet;
import etudiant.model.Etudiant;
import etudiant.service.EtudiantLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.io.InputStream;

public class EtudiantUtil {

    private static final String ETUDIANT_FOLDER= "ETUDIANT_FOLDER";

    public static void display(EtudiantLocalService etudiantLocalService, ActionRequest request, ActionResponse response) throws PortalException {
        final long etudiantId = ParamUtil.getLong(request, "etudiantId", 0L);

        if(etudiantId != 0L){
            final Etudiant etudiant = etudiantLocalService.getEtudiant(etudiantId);

            try{
                FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(etudiant.getImageId());
                String imageUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK, false, false);
                request.setAttribute("imageUrl", imageUrl);
            }catch (Exception e){}


            request.setAttribute("etudiant", etudiant);
            response.getRenderParameters().setValue("mvcPath", "/display.jsp");
        }
    }

    public static void add(EtudiantLocalService etudiantLocalService,ActionRequest request, ActionResponse response) throws Exception {
        final String nom = ParamUtil.getString(request, "nom", "");
        final String prenom = ParamUtil.getString(request, "prenom", "");
        final long classeId = ParamUtil.getLong(request, "classeId", 0L);
        final UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
        final InputStream inputStream = uploadPortletRequest.getFileAsStream("image");
        long imageId = 0L;

        if(inputStream != null) {
            final String fileName = uploadPortletRequest.getFileName("image");
            ServiceContext serviceContext = ServiceContextFactory.getInstance(EtudiantAppPortlet.class.getName(), request);

            final long folderId = ImageManagementUtil.findOrCreateFolderThenGetId(serviceContext, ETUDIANT_FOLDER);
            imageId = ImageManagementUtil.addImageThenGenerateId(serviceContext, folderId, fileName, inputStream);
        }


        etudiantLocalService.add(nom, prenom, imageId,classeId);
    }

    public static void delete(EtudiantLocalService etudiantLocalService,ActionRequest request, ActionResponse response) throws PortalException {
        final long etudiantId = ParamUtil.getLong(request, "etudiantId", 0L);
        if(etudiantId != 0L){
            final Etudiant etudiant = etudiantLocalService.getEtudiant(etudiantId);
            etudiantLocalService.deleteEtudiant(etudiantId);
            DLAppLocalServiceUtil.deleteFileEntry(etudiant.getImageId());
        }
    }

    public static void update(EtudiantLocalService etudiantLocalService,ActionRequest request,ActionResponse response) throws PortalException, IOException {
        final long etudiantId = ParamUtil.getLong(request, "etudiantId", 0L);
        final String nom = ParamUtil.getString(request, "nom", "");
        final String prenom = ParamUtil.getString(request, "prenom", "");
        final long classeId = ParamUtil.getLong(request, "classeId", 0L);
        final UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
        final InputStream inputStream = uploadPortletRequest.getFileAsStream("image");


        if(etudiantId > 0){
            long imageId = 0L;
            final Etudiant etudiant = etudiantLocalService.getEtudiant(etudiantId);

            if(inputStream != null) {
                final String fileName = uploadPortletRequest.getFileName("image");
                ServiceContext serviceContext = ServiceContextFactory.getInstance(EtudiantAppPortlet.class.getName(), request);

                final long folderId = ImageManagementUtil.findOrCreateFolderThenGetId(serviceContext, ETUDIANT_FOLDER);

                imageId = ImageManagementUtil.addImageThenGenerateId(serviceContext,folderId, fileName, inputStream);
            }
            else{
                imageId = etudiant.getImageId();
            }
            etudiantLocalService.update(etudiantId, nom, prenom, imageId, classeId);
        }
    }
}
