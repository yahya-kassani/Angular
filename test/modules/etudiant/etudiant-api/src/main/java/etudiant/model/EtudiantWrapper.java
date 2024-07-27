/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Etudiant}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Etudiant
 * @generated
 */
public class EtudiantWrapper
	extends BaseModelWrapper<Etudiant>
	implements Etudiant, ModelWrapper<Etudiant> {

	public EtudiantWrapper(Etudiant etudiant) {
		super(etudiant);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("etudiantId", getEtudiantId());
		attributes.put("nom", getNom());
		attributes.put("prenom", getPrenom());
		attributes.put("imageId", getImageId());
		attributes.put("classeId", getClasseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long etudiantId = (Long)attributes.get("etudiantId");

		if (etudiantId != null) {
			setEtudiantId(etudiantId);
		}

		String nom = (String)attributes.get("nom");

		if (nom != null) {
			setNom(nom);
		}

		String prenom = (String)attributes.get("prenom");

		if (prenom != null) {
			setPrenom(prenom);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long classeId = (Long)attributes.get("classeId");

		if (classeId != null) {
			setClasseId(classeId);
		}
	}

	@Override
	public Etudiant cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the classe ID of this etudiant.
	 *
	 * @return the classe ID of this etudiant
	 */
	@Override
	public long getClasseId() {
		return model.getClasseId();
	}

	/**
	 * Returns the etudiant ID of this etudiant.
	 *
	 * @return the etudiant ID of this etudiant
	 */
	@Override
	public long getEtudiantId() {
		return model.getEtudiantId();
	}

	/**
	 * Returns the image ID of this etudiant.
	 *
	 * @return the image ID of this etudiant
	 */
	@Override
	public long getImageId() {
		return model.getImageId();
	}

	/**
	 * Returns the nom of this etudiant.
	 *
	 * @return the nom of this etudiant
	 */
	@Override
	public String getNom() {
		return model.getNom();
	}

	/**
	 * Returns the prenom of this etudiant.
	 *
	 * @return the prenom of this etudiant
	 */
	@Override
	public String getPrenom() {
		return model.getPrenom();
	}

	/**
	 * Returns the primary key of this etudiant.
	 *
	 * @return the primary key of this etudiant
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this etudiant.
	 *
	 * @return the uuid of this etudiant
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
	 * Sets the classe ID of this etudiant.
	 *
	 * @param classeId the classe ID of this etudiant
	 */
	@Override
	public void setClasseId(long classeId) {
		model.setClasseId(classeId);
	}

	/**
	 * Sets the etudiant ID of this etudiant.
	 *
	 * @param etudiantId the etudiant ID of this etudiant
	 */
	@Override
	public void setEtudiantId(long etudiantId) {
		model.setEtudiantId(etudiantId);
	}

	/**
	 * Sets the image ID of this etudiant.
	 *
	 * @param imageId the image ID of this etudiant
	 */
	@Override
	public void setImageId(long imageId) {
		model.setImageId(imageId);
	}

	/**
	 * Sets the nom of this etudiant.
	 *
	 * @param nom the nom of this etudiant
	 */
	@Override
	public void setNom(String nom) {
		model.setNom(nom);
	}

	/**
	 * Sets the prenom of this etudiant.
	 *
	 * @param prenom the prenom of this etudiant
	 */
	@Override
	public void setPrenom(String prenom) {
		model.setPrenom(prenom);
	}

	/**
	 * Sets the primary key of this etudiant.
	 *
	 * @param primaryKey the primary key of this etudiant
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this etudiant.
	 *
	 * @param uuid the uuid of this etudiant
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
	protected EtudiantWrapper wrap(Etudiant etudiant) {
		return new EtudiantWrapper(etudiant);
	}

}