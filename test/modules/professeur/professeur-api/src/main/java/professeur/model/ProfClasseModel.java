/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ProfClasse service. Represents a row in the &quot;LL_ProfClasse&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>professeur.model.impl.ProfClasseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>professeur.model.impl.ProfClasseImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProfClasse
 * @generated
 */
@ProviderType
public interface ProfClasseModel extends BaseModel<ProfClasse> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a prof classe model instance should use the {@link ProfClasse} interface instead.
	 */

	/**
	 * Returns the primary key of this prof classe.
	 *
	 * @return the primary key of this prof classe
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this prof classe.
	 *
	 * @param primaryKey the primary key of this prof classe
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this prof classe.
	 *
	 * @return the uuid of this prof classe
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this prof classe.
	 *
	 * @param uuid the uuid of this prof classe
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the prof classe ID of this prof classe.
	 *
	 * @return the prof classe ID of this prof classe
	 */
	public long getProfClasseId();

	/**
	 * Sets the prof classe ID of this prof classe.
	 *
	 * @param profClasseId the prof classe ID of this prof classe
	 */
	public void setProfClasseId(long profClasseId);

	/**
	 * Returns the professeur ID of this prof classe.
	 *
	 * @return the professeur ID of this prof classe
	 */
	public long getProfesseurId();

	/**
	 * Sets the professeur ID of this prof classe.
	 *
	 * @param professeurId the professeur ID of this prof classe
	 */
	public void setProfesseurId(long professeurId);

	/**
	 * Returns the classe ID of this prof classe.
	 *
	 * @return the classe ID of this prof classe
	 */
	public long getClasseId();

	/**
	 * Sets the classe ID of this prof classe.
	 *
	 * @param classeId the classe ID of this prof classe
	 */
	public void setClasseId(long classeId);

	@Override
	public ProfClasse cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}