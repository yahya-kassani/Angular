/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FichierMatiereService}.
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiereService
 * @generated
 */
public class FichierMatiereServiceWrapper
	implements FichierMatiereService, ServiceWrapper<FichierMatiereService> {

	public FichierMatiereServiceWrapper() {
		this(null);
	}

	public FichierMatiereServiceWrapper(
		FichierMatiereService fichierMatiereService) {

		_fichierMatiereService = fichierMatiereService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fichierMatiereService.getOSGiServiceIdentifier();
	}

	@Override
	public FichierMatiereService getWrappedService() {
		return _fichierMatiereService;
	}

	@Override
	public void setWrappedService(FichierMatiereService fichierMatiereService) {
		_fichierMatiereService = fichierMatiereService;
	}

	private FichierMatiereService _fichierMatiereService;

}