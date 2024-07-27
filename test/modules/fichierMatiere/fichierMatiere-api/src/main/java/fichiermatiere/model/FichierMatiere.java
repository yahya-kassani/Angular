/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the FichierMatiere service. Represents a row in the &quot;LL_FichierMatiere&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiereModel
 * @generated
 */
@ImplementationClassName("fichiermatiere.model.impl.FichierMatiereImpl")
@ProviderType
public interface FichierMatiere extends FichierMatiereModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>fichiermatiere.model.impl.FichierMatiereImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FichierMatiere, Long>
		FICHIER_MATIERE_ID_ACCESSOR = new Accessor<FichierMatiere, Long>() {

			@Override
			public Long get(FichierMatiere fichierMatiere) {
				return fichierMatiere.getFichierMatiereId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FichierMatiere> getTypeClass() {
				return FichierMatiere.class;
			}

		};

}