/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import fichiermatiere.model.FichierMatiereTable;
import fichiermatiere.model.impl.FichierMatiereImpl;
import fichiermatiere.model.impl.FichierMatiereModelImpl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from FichierMatiere.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=fichiermatiere.model.impl.FichierMatiereImpl",
		"table.name=LL_FichierMatiere"
	},
	service = ArgumentsResolver.class
)
public class FichierMatiereModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		FichierMatiereModelImpl fichierMatiereModelImpl =
			(FichierMatiereModelImpl)baseModel;

		long columnBitmask = fichierMatiereModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(fichierMatiereModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					fichierMatiereModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(fichierMatiereModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return FichierMatiereImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return FichierMatiereTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		FichierMatiereModelImpl fichierMatiereModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = fichierMatiereModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = fichierMatiereModelImpl.getColumnValue(
					columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}