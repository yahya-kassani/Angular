package etudiant.app.utility;

import classe.model.Classe;
import classe.service.ClasseLocalService;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.ParamUtil;
import etudiant.model.Etudiant;
import etudiant.service.EtudiantLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.util.List;

public class NavigationPageUtil {

    public static void navigateToAddPage(ClasseLocalService classeLocalService, ActionRequest request, ActionResponse response) throws PortletException, IOException {
        List<Classe> classes = classeLocalService.getClasses(-1, -1);
        request.setAttribute("classes", classes);
        response.getRenderParameters().setValue("mvcPath","/add.jsp");
    }
    public static void navigateToEditPage(ClasseLocalService classeLocalService,EtudiantLocalService etudiantLocalService,ActionRequest request, ActionResponse response)throws PortalException {
        final long etudiantId = ParamUtil.getLong(request, "etudiantId", 0L);

        if (etudiantId != 0L) {
            final Etudiant etudiant = etudiantLocalService.getEtudiant(etudiantId);
            List<Classe> classes = classeLocalService.getClasses(-1, -1);
            try {
                FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(etudiant.getImageId());
                String imageUrl = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), null, StringPool.BLANK, false, false);
                request.setAttribute("imageUrl", imageUrl);
            } catch (Exception e) {
            }

            request.setAttribute("etudiant", etudiant);
            request.setAttribute("classes", classes);
            response.getRenderParameters().setValue("mvcPath", "/update.jsp");
        }
    }
}
