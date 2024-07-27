/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LL_Classe&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Classe
 * @generated
 */
public class ClasseTable extends BaseTable<ClasseTable> {

	public static final ClasseTable INSTANCE = new ClasseTable();

	public final Column<ClasseTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ClasseTable, Long> classeId = createColumn(
		"classeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ClasseTable, String> Intitule = createColumn(
		"Intitule", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ClasseTable() {
		super("LL_Classe", ClasseTable::new);
	}

}