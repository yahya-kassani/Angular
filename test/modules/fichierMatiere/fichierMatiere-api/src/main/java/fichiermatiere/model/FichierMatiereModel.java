/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the FichierMatiere service. Represents a row in the &quot;LL_FichierMatiere&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>fichiermatiere.model.impl.FichierMatiereModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>fichiermatiere.model.impl.FichierMatiereImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiere
 * @generated
 */
@ProviderType
public interface FichierMatiereModel extends BaseModel<FichierMatiere> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a fichier matiere model instance should use the {@link FichierMatiere} interface instead.
	 */

	/**
	 * Returns the primary key of this fichier matiere.
	 *
	 * @return the primary key of this fichier matiere
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this fichier matiere.
	 *
	 * @param primaryKey the primary key of this fichier matiere
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this fichier matiere.
	 *
	 * @return the uuid of this fichier matiere
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this fichier matiere.
	 *
	 * @param uuid the uuid of this fichier matiere
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the fichier matiere ID of this fichier matiere.
	 *
	 * @return the fichier matiere ID of this fichier matiere
	 */
	public long getFichierMatiereId();

	/**
	 * Sets the fichier matiere ID of this fichier matiere.
	 *
	 * @param fichierMatiereId the fichier matiere ID of this fichier matiere
	 */
	public void setFichierMatiereId(long fichierMatiereId);

	/**
	 * Returns the matiere ID of this fichier matiere.
	 *
	 * @return the matiere ID of this fichier matiere
	 */
	public long getMatiereId();

	/**
	 * Sets the matiere ID of this fichier matiere.
	 *
	 * @param matiereId the matiere ID of this fichier matiere
	 */
	public void setMatiereId(long matiereId);

	/**
	 * Returns the fichier ID of this fichier matiere.
	 *
	 * @return the fichier ID of this fichier matiere
	 */
	public long getFichierId();

	/**
	 * Sets the fichier ID of this fichier matiere.
	 *
	 * @param fichierId the fichier ID of this fichier matiere
	 */
	public void setFichierId(long fichierId);

	@Override
	public FichierMatiere cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}