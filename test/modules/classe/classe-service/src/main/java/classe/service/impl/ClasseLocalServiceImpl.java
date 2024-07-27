/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.service.impl;

import classe.model.Classe;
import classe.service.base.ClasseLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=classe.model.Classe",
	service = AopService.class
)
public class ClasseLocalServiceImpl extends ClasseLocalServiceBaseImpl {


	public Classe add(String intitule){
		final Classe classe = classePersistence.create(counterLocalService.increment());
		classe.setIntitule(intitule);
		return classePersistence.update(classe);
	}

	public Classe update(long classeId,String intitule) throws PortalException {
		final Classe classe = classeLocalService.getClasse(classeId);
		classe.setIntitule(intitule);
		return classePersistence.update(classe);
	}

}