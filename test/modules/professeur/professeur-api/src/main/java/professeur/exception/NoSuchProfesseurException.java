/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package professeur.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchProfesseurException extends NoSuchModelException {

	public NoSuchProfesseurException() {
	}

	public NoSuchProfesseurException(String msg) {
		super(msg);
	}

	public NoSuchProfesseurException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchProfesseurException(Throwable throwable) {
		super(throwable);
	}

}