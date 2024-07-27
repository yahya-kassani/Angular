/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service.impl;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import etudiant.model.Etudiant;
import etudiant.service.base.EtudiantLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=etudiant.model.Etudiant",
	service = AopService.class
)
public class EtudiantLocalServiceImpl extends EtudiantLocalServiceBaseImpl {

	public Etudiant add(String nom, String prenom, long imageId, long classId){
		Etudiant etudiant = etudiantPersistence.create(counterLocalService.increment());
		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setImageId(imageId);
		etudiant.setClasseId(classId);

		return etudiantPersistence.update(etudiant);
	}

	public Etudiant update(long etudiantId, String nom, String prenom, long imageId, long classId) throws PortalException {
		Etudiant etudiant = etudiantLocalService.getEtudiant(etudiantId);

		try{
			if(imageId > 0 && imageId != etudiant.getImageId()){
				DLAppLocalServiceUtil.deleteFileEntry(etudiant.getImageId());
			}
		}catch (Exception e){}

		etudiant.setNom(nom);
		etudiant.setPrenom(prenom);
		etudiant.setImageId(imageId);
		etudiant.setClasseId(classId);
		return etudiantPersistence.update(etudiant);
	}

}