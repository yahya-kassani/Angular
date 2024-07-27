/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package matiere.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMatiereException extends NoSuchModelException {

	public NoSuchMatiereException() {
	}

	public NoSuchMatiereException(String msg) {
		super(msg);
	}

	public NoSuchMatiereException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchMatiereException(Throwable throwable) {
		super(throwable);
	}

}