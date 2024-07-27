/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

import professeur.model.ProfClasseTable;
import professeur.model.impl.ProfClasseImpl;
import professeur.model.impl.ProfClasseModelImpl;

/**
 * The arguments resolver class for retrieving value from ProfClasse.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=professeur.model.impl.ProfClasseImpl",
		"table.name=LL_ProfClasse"
	},
	service = ArgumentsResolver.class
)
public class ProfClasseModelArgumentsResolver implements ArgumentsResolver {

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

		ProfClasseModelImpl profClasseModelImpl =
			(ProfClasseModelImpl)baseModel;

		long columnBitmask = profClasseModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(profClasseModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= profClasseModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(profClasseModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return ProfClasseImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return ProfClasseTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		ProfClasseModelImpl profClasseModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = profClasseModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = profClasseModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}