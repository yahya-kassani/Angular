/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Matiere service. Represents a row in the &quot;LL_Matiere&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MatiereModel
 * @generated
 */
@ImplementationClassName("matiere.model.impl.MatiereImpl")
@ProviderType
public interface Matiere extends MatiereModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>matiere.model.impl.MatiereImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Matiere, Long> MATIERE_ID_ACCESSOR =
		new Accessor<Matiere, Long>() {

			@Override
			public Long get(Matiere matiere) {
				return matiere.getMatiereId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Matiere> getTypeClass() {
				return Matiere.class;
			}

		};

}