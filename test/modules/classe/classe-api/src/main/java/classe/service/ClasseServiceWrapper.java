/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ClasseService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClasseService
 * @generated
 */
public class ClasseServiceWrapper
	implements ClasseService, ServiceWrapper<ClasseService> {

	public ClasseServiceWrapper() {
		this(null);
	}

	public ClasseServiceWrapper(ClasseService classeService) {
		_classeService = classeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _classeService.getOSGiServiceIdentifier();
	}

	@Override
	public ClasseService getWrappedService() {
		return _classeService;
	}

	@Override
	public void setWrappedService(ClasseService classeService) {
		_classeService = classeService;
	}

	private ClasseService _classeService;

}