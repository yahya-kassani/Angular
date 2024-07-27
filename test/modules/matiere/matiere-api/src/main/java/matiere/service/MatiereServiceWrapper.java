/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatiereService}.
 *
 * @author Brian Wing Shun Chan
 * @see MatiereService
 * @generated
 */
public class MatiereServiceWrapper
	implements MatiereService, ServiceWrapper<MatiereService> {

	public MatiereServiceWrapper() {
		this(null);
	}

	public MatiereServiceWrapper(MatiereService matiereService) {
		_matiereService = matiereService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _matiereService.getOSGiServiceIdentifier();
	}

	@Override
	public MatiereService getWrappedService() {
		return _matiereService;
	}

	@Override
	public void setWrappedService(MatiereService matiereService) {
		_matiereService = matiereService;
	}

	private MatiereService _matiereService;

}