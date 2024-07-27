/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProfesseurService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProfesseurService
 * @generated
 */
public class ProfesseurServiceWrapper
	implements ProfesseurService, ServiceWrapper<ProfesseurService> {

	public ProfesseurServiceWrapper() {
		this(null);
	}

	public ProfesseurServiceWrapper(ProfesseurService professeurService) {
		_professeurService = professeurService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _professeurService.getOSGiServiceIdentifier();
	}

	@Override
	public ProfesseurService getWrappedService() {
		return _professeurService;
	}

	@Override
	public void setWrappedService(ProfesseurService professeurService) {
		_professeurService = professeurService;
	}

	private ProfesseurService _professeurService;

}