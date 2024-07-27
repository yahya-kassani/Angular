/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Classe}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Classe
 * @generated
 */
public class ClasseWrapper
	extends BaseModelWrapper<Classe> implements Classe, ModelWrapper<Classe> {

	public ClasseWrapper(Classe classe) {
		super(classe);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("classeId", getClasseId());
		attributes.put("Intitule", getIntitule());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long classeId = (Long)attributes.get("classeId");

		if (classeId != null) {
			setClasseId(classeId);
		}

		String Intitule = (String)attributes.get("Intitule");

		if (Intitule != null) {
			setIntitule(Intitule);
		}
	}

	@Override
	public Classe cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the classe ID of this classe.
	 *
	 * @return the classe ID of this classe
	 */
	@Override
	public long getClasseId() {
		return model.getClasseId();
	}

	/**
	 * Returns the intitule of this classe.
	 *
	 * @return the intitule of this classe
	 */
	@Override
	public String getIntitule() {
		return model.getIntitule();
	}

	/**
	 * Returns the primary key of this classe.
	 *
	 * @return the primary key of this classe
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this classe.
	 *
	 * @return the uuid of this classe
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
	 * Sets the classe ID of this classe.
	 *
	 * @param classeId the classe ID of this classe
	 */
	@Override
	public void setClasseId(long classeId) {
		model.setClasseId(classeId);
	}

	/**
	 * Sets the intitule of this classe.
	 *
	 * @param Intitule the intitule of this classe
	 */
	@Override
	public void setIntitule(String Intitule) {
		model.setIntitule(Intitule);
	}

	/**
	 * Sets the primary key of this classe.
	 *
	 * @param primaryKey the primary key of this classe
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this classe.
	 *
	 * @param uuid the uuid of this classe
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
	protected ClasseWrapper wrap(Classe classe) {
		return new ClasseWrapper(classe);
	}

}