/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LL_ProfClasse&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see ProfClasse
 * @generated
 */
public class ProfClasseTable extends BaseTable<ProfClasseTable> {

	public static final ProfClasseTable INSTANCE = new ProfClasseTable();

	public final Column<ProfClasseTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfClasseTable, Long> profClasseId = createColumn(
		"profClasseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProfClasseTable, Long> professeurId = createColumn(
		"professeurId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ProfClasseTable, Long> classeId = createColumn(
		"classeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private ProfClasseTable() {
		super("LL_ProfClasse", ProfClasseTable::new);
	}

}