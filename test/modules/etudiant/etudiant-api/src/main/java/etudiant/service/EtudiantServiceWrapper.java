/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EtudiantService}.
 *
 * @author Brian Wing Shun Chan
 * @see EtudiantService
 * @generated
 */
public class EtudiantServiceWrapper
	implements EtudiantService, ServiceWrapper<EtudiantService> {

	public EtudiantServiceWrapper() {
		this(null);
	}

	public EtudiantServiceWrapper(EtudiantService etudiantService) {
		_etudiantService = etudiantService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _etudiantService.getOSGiServiceIdentifier();
	}

	@Override
	public EtudiantService getWrappedService() {
		return _etudiantService;
	}

	@Override
	public void setWrappedService(EtudiantService etudiantService) {
		_etudiantService = etudiantService;
	}

	private EtudiantService _etudiantService;

}