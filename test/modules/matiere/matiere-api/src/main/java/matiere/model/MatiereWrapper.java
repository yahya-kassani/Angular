/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Matiere}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Matiere
 * @generated
 */
public class MatiereWrapper
	extends BaseModelWrapper<Matiere>
	implements Matiere, ModelWrapper<Matiere> {

	public MatiereWrapper(Matiere matiere) {
		super(matiere);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("matiereId", getMatiereId());
		attributes.put("classeId", getClasseId());
		attributes.put("professeurId", getProfesseurId());
		attributes.put("Intitule", getIntitule());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long matiereId = (Long)attributes.get("matiereId");

		if (matiereId != null) {
			setMatiereId(matiereId);
		}

		Long classeId = (Long)attributes.get("classeId");

		if (classeId != null) {
			setClasseId(classeId);
		}

		Long professeurId = (Long)attributes.get("professeurId");

		if (professeurId != null) {
			setProfesseurId(professeurId);
		}

		String Intitule = (String)attributes.get("Intitule");

		if (Intitule != null) {
			setIntitule(Intitule);
		}
	}

	@Override
	public Matiere cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the classe ID of this matiere.
	 *
	 * @return the classe ID of this matiere
	 */
	@Override
	public long getClasseId() {
		return model.getClasseId();
	}

	/**
	 * Returns the intitule of this matiere.
	 *
	 * @return the intitule of this matiere
	 */
	@Override
	public String getIntitule() {
		return model.getIntitule();
	}

	/**
	 * Returns the matiere ID of this matiere.
	 *
	 * @return the matiere ID of this matiere
	 */
	@Override
	public long getMatiereId() {
		return model.getMatiereId();
	}

	/**
	 * Returns the primary key of this matiere.
	 *
	 * @return the primary key of this matiere
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the professeur ID of this matiere.
	 *
	 * @return the professeur ID of this matiere
	 */
	@Override
	public long getProfesseurId() {
		return model.getProfesseurId();
	}

	/**
	 * Returns the uuid of this matiere.
	 *
	 * @return the uuid of this matiere
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
	 * Sets the classe ID of this matiere.
	 *
	 * @param classeId the classe ID of this matiere
	 */
	@Override
	public void setClasseId(long classeId) {
		model.setClasseId(classeId);
	}

	/**
	 * Sets the intitule of this matiere.
	 *
	 * @param Intitule the intitule of this matiere
	 */
	@Override
	public void setIntitule(String Intitule) {
		model.setIntitule(Intitule);
	}

	/**
	 * Sets the matiere ID of this matiere.
	 *
	 * @param matiereId the matiere ID of this matiere
	 */
	@Override
	public void setMatiereId(long matiereId) {
		model.setMatiereId(matiereId);
	}

	/**
	 * Sets the primary key of this matiere.
	 *
	 * @param primaryKey the primary key of this matiere
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the professeur ID of this matiere.
	 *
	 * @param professeurId the professeur ID of this matiere
	 */
	@Override
	public void setProfesseurId(long professeurId) {
		model.setProfesseurId(professeurId);
	}

	/**
	 * Sets the uuid of this matiere.
	 *
	 * @param uuid the uuid of this matiere
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
	protected MatiereWrapper wrap(Matiere matiere) {
		return new MatiereWrapper(matiere);
	}

}