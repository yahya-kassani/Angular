/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;LL_Etudiant&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Etudiant
 * @generated
 */
public class EtudiantTable extends BaseTable<EtudiantTable> {

	public static final EtudiantTable INSTANCE = new EtudiantTable();

	public final Column<EtudiantTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EtudiantTable, Long> etudiantId = createColumn(
		"etudiantId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<EtudiantTable, String> nom = createColumn(
		"nom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EtudiantTable, String> prenom = createColumn(
		"prenom", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<EtudiantTable, Long> imageId = createColumn(
		"imageId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<EtudiantTable, Long> classeId = createColumn(
		"classeId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private EtudiantTable() {
		super("LL_Etudiant", EtudiantTable::new);
	}

}