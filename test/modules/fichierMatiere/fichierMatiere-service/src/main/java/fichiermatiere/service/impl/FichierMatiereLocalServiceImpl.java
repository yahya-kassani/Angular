/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service.impl;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import fichiermatiere.model.FichierMatiere;
import fichiermatiere.service.base.FichierMatiereLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=fichiermatiere.model.FichierMatiere",
	service = AopService.class
)
public class FichierMatiereLocalServiceImpl
	extends FichierMatiereLocalServiceBaseImpl {

	public FichierMatiere add(long matiereId, long fichierId) {
		FichierMatiere fichierMatiere = fichierMatierePersistence.create(counterLocalService.increment());
		fichierMatiere.setMatiereId(matiereId);
		fichierMatiere.setFichierId(fichierId);
		return fichierMatierePersistence.update(fichierMatiere);
	}

	public FichierMatiere update(long fichierMatiereId, long fichierId, long matiereId) throws PortalException {
		FichierMatiere fichierMatiere = fichierMatiereLocalService.getFichierMatiere(fichierMatiereId);

		if (fichierId > 0 && fichierId != fichierMatiere.getFichierId()) {
			DLAppLocalServiceUtil.deleteFileEntry(fichierMatiere.getFichierId());
		}

		fichierMatiere.setFichierId(fichierId);
		fichierMatiere.setMatiereId(matiereId);
		return fichierMatierePersistence.update(fichierMatiere);
	}
}