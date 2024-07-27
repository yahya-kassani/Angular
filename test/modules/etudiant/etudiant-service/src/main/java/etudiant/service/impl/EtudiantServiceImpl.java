/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service.impl;

import com.liferay.portal.aop.AopService;

import etudiant.service.base.EtudiantServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=ll",
		"json.web.service.context.path=Etudiant"
	},
	service = AopService.class
)
public class EtudiantServiceImpl extends EtudiantServiceBaseImpl {
}