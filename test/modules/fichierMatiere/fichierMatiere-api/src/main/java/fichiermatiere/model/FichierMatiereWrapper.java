/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FichierMatiere}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FichierMatiere
 * @generated
 */
public class FichierMatiereWrapper
	extends BaseModelWrapper<FichierMatiere>
	implements FichierMatiere, ModelWrapper<FichierMatiere> {

	public FichierMatiereWrapper(FichierMatiere fichierMatiere) {
		super(fichierMatiere);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fichierMatiereId", getFichierMatiereId());
		attributes.put("matiereId", getMatiereId());
		attributes.put("fichierId", getFichierId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fichierMatiereId = (Long)attributes.get("fichierMatiereId");

		if (fichierMatiereId != null) {
			setFichierMatiereId(fichierMatiereId);
		}

		Long matiereId = (Long)attributes.get("matiereId");

		if (matiereId != null) {
			setMatiereId(matiereId);
		}

		Long fichierId = (Long)attributes.get("fichierId");

		if (fichierId != null) {
			setFichierId(fichierId);
		}
	}

	@Override
	public FichierMatiere cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the fichier ID of this fichier matiere.
	 *
	 * @return the fichier ID of this fichier matiere
	 */
	@Override
	public long getFichierId() {
		return model.getFichierId();
	}

	/**
	 * Returns the fichier matiere ID of this fichier matiere.
	 *
	 * @return the fichier matiere ID of this fichier matiere
	 */
	@Override
	public long getFichierMatiereId() {
		return model.getFichierMatiereId();
	}

	/**
	 * Returns the matiere ID of this fichier matiere.
	 *
	 * @return the matiere ID of this fichier matiere
	 */
	@Override
	public long getMatiereId() {
		return model.getMatiereId();
	}

	/**
	 * Returns the primary key of this fichier matiere.
	 *
	 * @return the primary key of this fichier matiere
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this fichier matiere.
	 *
	 * @return the uuid of this fichier matiere
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fichier ID of this fichier matiere.
	 *
	 * @param fichierId the fichier ID of this fichier matiere
	 */
	@Override
	public void setFichierId(long fichierId) {
		model.setFichierId(fichierId);
	}

	/**
	 * Sets the fichier matiere ID of this fichier matiere.
	 *
	 * @param fichierMatiereId the fichier matiere ID of this fichier matiere
	 */
	@Override
	public void setFichierMatiereId(long fichierMatiereId) {
		model.setFichierMatiereId(fichierMatiereId);
	}

	/**
	 * Sets the matiere ID of this fichier matiere.
	 *
	 * @param matiereId the matiere ID of this fichier matiere
	 */
	@Override
	public void setMatiereId(long matiereId) {
		model.setMatiereId(matiereId);
	}

	/**
	 * Sets the primary key of this fichier matiere.
	 *
	 * @param primaryKey the primary key of this fichier matiere
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this fichier matiere.
	 *
	 * @param uuid the uuid of this fichier matiere
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FichierMatiereWrapper wrap(FichierMatiere fichierMatiere) {
		return new FichierMatiereWrapper(fichierMatiere);
	}

}