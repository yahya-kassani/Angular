/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LL_Professeur&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Professeur
 * @generated
 */
public class ProfesseurTable extends BaseTable<ProfesseurTable> {

	public static final ProfesseurTable INSTANCE = new ProfesseurTable();

	public final Column<ProfesseurTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfesseurTable, Long> professeurId = createColumn(
		"professeurId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ProfesseurTable, String> nom = createColumn(
		"nom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ProfesseurTable, String> prenom = createColumn(
		"prenom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ProfesseurTable() {
		super("LL_Professeur", ProfesseurTable::new);
	}

}