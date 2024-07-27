/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import matiere.model.Matiere;
import matiere.service.base.MatiereLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=matiere.model.Matiere",
	service = AopService.class
)
public class MatiereLocalServiceImpl extends MatiereLocalServiceBaseImpl {
	public Matiere add(long classeId, long professeurId, String intitule ){

		Matiere matiere=matiereLocalService.createMatiere(counterLocalService.increment());
		matiere.setClasseId(classeId);
		matiere.setIntitule(intitule);
		matiere.setProfesseurId(professeurId);

		return matierePersistence.update(matiere);

	}

	public Matiere update(long matiereId, long classeId, long professeurId, String intitule ) throws PortalException {
		Matiere matiere = matiereLocalService.getMatiere(matiereId);
		matiere.setClasseId(classeId);
		matiere.setIntitule(intitule);
		matiere.setProfesseurId(professeurId);
		return matierePersistence.update(matiere);
	}
}