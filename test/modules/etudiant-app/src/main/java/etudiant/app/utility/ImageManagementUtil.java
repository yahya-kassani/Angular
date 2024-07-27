package etudiant.app.utility;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.IOException;
import java.io.InputStream;

public class ImageManagementUtil {
    public static long addImageThenGenerateId(ServiceContext serviceContext, long folderId, String fileName, InputStream inputStream) throws IOException, PortalException {
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

    private static String getUniqueName(long groupId, long folderId, String fileName){
        String name = fileName;
        while(fileExists(groupId, folderId, name)){
            name = PortalUUIDUtil.generate() + "_" + "ETUDE";
        }
        return name;
    }

    private static boolean fileExists(long groupId, long folderId, String fileName) {
        try{
            DLAppLocalServiceUtil.getFileEntry(groupId, folderId, fileName);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static long findOrCreateFolderThenGetId(ServiceContext serviceContext,String folderName) throws IOException, PortalException {
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


}
