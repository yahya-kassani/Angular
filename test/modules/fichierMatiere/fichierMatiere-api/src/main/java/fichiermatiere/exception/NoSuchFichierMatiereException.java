/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package fichiermatiere.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchFichierMatiereException extends NoSuchModelException {

	public NoSuchFichierMatiereException() {
	}

	public NoSuchFichierMatiereException(String msg) {
		super(msg);
	}

	public NoSuchFichierMatiereException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchFichierMatiereException(Throwable throwable) {
		super(throwable);
	}

}