/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Professeur}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Professeur
 * @generated
 */
public class ProfesseurWrapper
	extends BaseModelWrapper<Professeur>
	implements ModelWrapper<Professeur>, Professeur {

	public ProfesseurWrapper(Professeur professeur) {
		super(professeur);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("professeurId", getProfesseurId());
		attributes.put("nom", getNom());
		attributes.put("prenom", getPrenom());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long professeurId = (Long)attributes.get("professeurId");

		if (professeurId != null) {
			setProfesseurId(professeurId);
		}

		String nom = (String)attributes.get("nom");

		if (nom != null) {
			setNom(nom);
		}

		String prenom = (String)attributes.get("prenom");

		if (prenom != null) {
			setPrenom(prenom);
		}
	}

	@Override
	public Professeur cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the nom of this professeur.
	 *
	 * @return the nom of this professeur
	 */
	@Override
	public String getNom() {
		return model.getNom();
	}

	/**
	 * Returns the prenom of this professeur.
	 *
	 * @return the prenom of this professeur
	 */
	@Override
	public String getPrenom() {
		return model.getPrenom();
	}

	/**
	 * Returns the primary key of this professeur.
	 *
	 * @return the primary key of this professeur
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the professeur ID of this professeur.
	 *
	 * @return the professeur ID of this professeur
	 */
	@Override
	public long getProfesseurId() {
		return model.getProfesseurId();
	}

	/**
	 * Returns the uuid of this professeur.
	 *
	 * @return the uuid of this professeur
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
	 * Sets the nom of this professeur.
	 *
	 * @param nom the nom of this professeur
	 */
	@Override
	public void setNom(String nom) {
		model.setNom(nom);
	}

	/**
	 * Sets the prenom of this professeur.
	 *
	 * @param prenom the prenom of this professeur
	 */
	@Override
	public void setPrenom(String prenom) {
		model.setPrenom(prenom);
	}

	/**
	 * Sets the primary key of this professeur.
	 *
	 * @param primaryKey the primary key of this professeur
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the professeur ID of this professeur.
	 *
	 * @param professeurId the professeur ID of this professeur
	 */
	@Override
	public void setProfesseurId(long professeurId) {
		model.setProfesseurId(professeurId);
	}

	/**
	 * Sets the uuid of this professeur.
	 *
	 * @param uuid the uuid of this professeur
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
	protected ProfesseurWrapper wrap(Professeur professeur) {
		return new ProfesseurWrapper(professeur);
	}

}