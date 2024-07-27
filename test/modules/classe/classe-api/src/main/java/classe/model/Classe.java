/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Classe service. Represents a row in the &quot;LL_Classe&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ClasseModel
 * @generated
 */
@ImplementationClassName("classe.model.impl.ClasseImpl")
@ProviderType
public interface Classe extends ClasseModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>classe.model.impl.ClasseImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Classe, Long> CLASSE_ID_ACCESSOR =
		new Accessor<Classe, Long>() {

			@Override
			public Long get(Classe classe) {
				return classe.getClasseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Classe> getTypeClass() {
				return Classe.class;
			}

		};

}