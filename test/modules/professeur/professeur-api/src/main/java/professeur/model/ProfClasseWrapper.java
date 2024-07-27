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
 * This class is a wrapper for {@link ProfClasse}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfClasse
 * @generated
 */
public class ProfClasseWrapper
	extends BaseModelWrapper<ProfClasse>
	implements ModelWrapper<ProfClasse>, ProfClasse {

	public ProfClasseWrapper(ProfClasse profClasse) {
		super(profClasse);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("profClasseId", getProfClasseId());
		attributes.put("professeurId", getProfesseurId());
		attributes.put("classeId", getClasseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long profClasseId = (Long)attributes.get("profClasseId");

		if (profClasseId != null) {
			setProfClasseId(profClasseId);
		}

		Long professeurId = (Long)attributes.get("professeurId");

		if (professeurId != null) {
			setProfesseurId(professeurId);
		}

		Long classeId = (Long)attributes.get("classeId");

		if (classeId != null) {
			setClasseId(classeId);
		}
	}

	@Override
	public ProfClasse cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the classe ID of this prof classe.
	 *
	 * @return the classe ID of this prof classe
	 */
	@Override
	public long getClasseId() {
		return model.getClasseId();
	}

	/**
	 * Returns the primary key of this prof classe.
	 *
	 * @return the primary key of this prof classe
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the prof classe ID of this prof classe.
	 *
	 * @return the prof classe ID of this prof classe
	 */
	@Override
	public long getProfClasseId() {
		return model.getProfClasseId();
	}

	/**
	 * Returns the professeur ID of this prof classe.
	 *
	 * @return the professeur ID of this prof classe
	 */
	@Override
	public long getProfesseurId() {
		return model.getProfesseurId();
	}

	/**
	 * Returns the uuid of this prof classe.
	 *
	 * @return the uuid of this prof classe
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
	 * Sets the classe ID of this prof classe.
	 *
	 * @param classeId the classe ID of this prof classe
	 */
	@Override
	public void setClasseId(long classeId) {
		model.setClasseId(classeId);
	}

	/**
	 * Sets the primary key of this prof classe.
	 *
	 * @param primaryKey the primary key of this prof classe
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the prof classe ID of this prof classe.
	 *
	 * @param profClasseId the prof classe ID of this prof classe
	 */
	@Override
	public void setProfClasseId(long profClasseId) {
		model.setProfClasseId(profClasseId);
	}

	/**
	 * Sets the professeur ID of this prof classe.
	 *
	 * @param professeurId the professeur ID of this prof classe
	 */
	@Override
	public void setProfesseurId(long professeurId) {
		model.setProfesseurId(professeurId);
	}

	/**
	 * Sets the uuid of this prof classe.
	 *
	 * @param uuid the uuid of this prof classe
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
	protected ProfClasseWrapper wrap(ProfClasse profClasse) {
		return new ProfClasseWrapper(profClasse);
	}

}