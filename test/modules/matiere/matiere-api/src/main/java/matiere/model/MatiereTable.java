/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LL_Matiere&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Matiere
 * @generated
 */
public class MatiereTable extends BaseTable<MatiereTable> {

	public static final MatiereTable INSTANCE = new MatiereTable();

	public final Column<MatiereTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MatiereTable, Long> matiereId = createColumn(
		"matiereId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MatiereTable, Long> classeId = createColumn(
		"classeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatiereTable, Long> professeurId = createColumn(
		"professeurId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<MatiereTable, String> Intitule = createColumn(
		"Intitule", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MatiereTable() {
		super("LL_Matiere", MatiereTable::new);
	}

}