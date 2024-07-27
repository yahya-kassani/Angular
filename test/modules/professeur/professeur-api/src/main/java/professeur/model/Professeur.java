/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Professeur service. Represents a row in the &quot;LL_Professeur&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProfesseurModel
 * @generated
 */
@ImplementationClassName("professeur.model.impl.ProfesseurImpl")
@ProviderType
public interface Professeur extends PersistedModel, ProfesseurModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>professeur.model.impl.ProfesseurImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Professeur, Long> PROFESSEUR_ID_ACCESSOR =
		new Accessor<Professeur, Long>() {

			@Override
			public Long get(Professeur professeur) {
				return professeur.getProfesseurId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Professeur> getTypeClass() {
				return Professeur.class;
			}

		};

}