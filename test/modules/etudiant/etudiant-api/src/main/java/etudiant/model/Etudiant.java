/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Etudiant service. Represents a row in the &quot;LL_Etudiant&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EtudiantModel
 * @generated
 */
@ImplementationClassName("etudiant.model.impl.EtudiantImpl")
@ProviderType
public interface Etudiant extends EtudiantModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>etudiant.model.impl.EtudiantImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Etudiant, Long> ETUDIANT_ID_ACCESSOR =
		new Accessor<Etudiant, Long>() {

			@Override
			public Long get(Etudiant etudiant) {
				return etudiant.getEtudiantId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Etudiant> getTypeClass() {
				return Etudiant.class;
			}

		};

}