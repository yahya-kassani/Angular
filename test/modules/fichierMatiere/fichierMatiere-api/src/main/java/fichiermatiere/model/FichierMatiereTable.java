/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LL_FichierMatiere&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiere
 * @generated
 */
public class FichierMatiereTable extends BaseTable<FichierMatiereTable> {

	public static final FichierMatiereTable INSTANCE =
		new FichierMatiereTable();

	public final Column<FichierMatiereTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FichierMatiereTable, Long> fichierMatiereId =
		createColumn(
			"fichierMatiereId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FichierMatiereTable, Long> matiereId = createColumn(
		"matiereId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FichierMatiereTable, Long> fichierId = createColumn(
		"fichierId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FichierMatiereTable() {
		super("LL_FichierMatiere", FichierMatiereTable::new);
	}

}