/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package professeur.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import professeur.model.Professeur;

/**
 * The cache model class for representing Professeur in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProfesseurCacheModel
	implements CacheModel<Professeur>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProfesseurCacheModel)) {
			return false;
		}

		ProfesseurCacheModel professeurCacheModel =
			(ProfesseurCacheModel)object;

		if (professeurId == professeurCacheModel.professeurId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, professeurId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", professeurId=");
		sb.append(professeurId);
		sb.append(", nom=");
		sb.append(nom);
		sb.append(", prenom=");
		sb.append(prenom);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Professeur toEntityModel() {
		ProfesseurImpl professeurImpl = new ProfesseurImpl();

		if (uuid == null) {
			professeurImpl.setUuid("");
		}
		else {
			professeurImpl.setUuid(uuid);
		}

		professeurImpl.setProfesseurId(professeurId);

		if (nom == null) {
			professeurImpl.setNom("");
		}
		else {
			professeurImpl.setNom(nom);
		}

		if (prenom == null) {
			professeurImpl.setPrenom("");
		}
		else {
			professeurImpl.setPrenom(prenom);
		}

		professeurImpl.resetOriginalValues();

		return professeurImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		professeurId = objectInput.readLong();
		nom = objectInput.readUTF();
		prenom = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(professeurId);

		if (nom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nom);
		}

		if (prenom == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(prenom);
		}
	}

	public String uuid;
	public long professeurId;
	public String nom;
	public String prenom;

}