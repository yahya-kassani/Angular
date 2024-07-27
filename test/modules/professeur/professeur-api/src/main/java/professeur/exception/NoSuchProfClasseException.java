/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package professeur.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchProfClasseException extends NoSuchModelException {

	public NoSuchProfClasseException() {
	}

	public NoSuchProfClasseException(String msg) {
		super(msg);
	}

	public NoSuchProfClasseException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchProfClasseException(Throwable throwable) {
		super(throwable);
	}

}