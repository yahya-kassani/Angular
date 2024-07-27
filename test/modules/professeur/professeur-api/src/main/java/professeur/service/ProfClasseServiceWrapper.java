/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfClasseService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfClasseService
 * @generated
 */
public class ProfClasseServiceWrapper
	implements ProfClasseService, ServiceWrapper<ProfClasseService> {

	public ProfClasseServiceWrapper() {
		this(null);
	}

	public ProfClasseServiceWrapper(ProfClasseService profClasseService) {
		_profClasseService = profClasseService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _profClasseService.getOSGiServiceIdentifier();
	}

	@Override
	public ProfClasseService getWrappedService() {
		return _profClasseService;
	}

	@Override
	public void setWrappedService(ProfClasseService profClasseService) {
		_profClasseService = profClasseService;
	}

	private ProfClasseService _profClasseService;

}