/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

import professeur.model.Professeur;
import professeur.service.base.ProfesseurLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=professeur.model.Professeur",
	service = AopService.class
)
public class ProfesseurLocalServiceImpl extends ProfesseurLocalServiceBaseImpl {
	public Professeur add(String nom, String prenom) {
		final Professeur professeur = professeurPersistence.create(counterLocalService.increment());
		professeur.setNom(nom);
		professeur.setPrenom(prenom);
		return professeurPersistence.update(professeur);
	}

	public Professeur update(long professeurId, String nom, String prenom) throws PortalException {
		Professeur professeur = professeurLocalService.getProfesseur(professeurId);

		professeur.setNom(nom);
		professeur.setPrenom(prenom);

		return professeurPersistence.update(professeur);
	}
}