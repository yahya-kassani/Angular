/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service.impl;

import com.liferay.portal.aop.AopService;

import fichiermatiere.service.base.FichierMatiereServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ll",
		"json.web.service.context.path=FichierMatiere"
	},
	service = AopService.class
)
public class FichierMatiereServiceImpl extends FichierMatiereServiceBaseImpl {
}