/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service;

/**
 * Provides the remote service utility for FichierMatiere. This utility wraps
 * <code>fichiermatiere.service.impl.FichierMatiereServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiereService
 * @generated
 */
public class FichierMatiereServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>fichiermatiere.service.impl.FichierMatiereServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static FichierMatiereService getService() {
		return _service;
	}

	public static void setService(FichierMatiereService service) {
		_service = service;
	}

	private static volatile FichierMatiereService _service;

}