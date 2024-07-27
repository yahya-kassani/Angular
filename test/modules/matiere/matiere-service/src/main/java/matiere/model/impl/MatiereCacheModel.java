/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package matiere.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import matiere.model.Matiere;

/**
 * The cache model class for representing Matiere in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MatiereCacheModel implements CacheModel<Matiere>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MatiereCacheModel)) {
			return false;
		}

		MatiereCacheModel matiereCacheModel = (MatiereCacheModel)object;

		if (matiereId == matiereCacheModel.matiereId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, matiereId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", matiereId=");
		sb.append(matiereId);
		sb.append(", classeId=");
		sb.append(classeId);
		sb.append(", professeurId=");
		sb.append(professeurId);
		sb.append(", Intitule=");
		sb.append(Intitule);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Matiere toEntityModel() {
		MatiereImpl matiereImpl = new MatiereImpl();

		if (uuid == null) {
			matiereImpl.setUuid("");
		}
		else {
			matiereImpl.setUuid(uuid);
		}

		matiereImpl.setMatiereId(matiereId);
		matiereImpl.setClasseId(classeId);
		matiereImpl.setProfesseurId(professeurId);

		if (Intitule == null) {
			matiereImpl.setIntitule("");
		}
		else {
			matiereImpl.setIntitule(Intitule);
		}

		matiereImpl.resetOriginalValues();

		return matiereImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		matiereId = objectInput.readLong();

		classeId = objectInput.readLong();

		professeurId = objectInput.readLong();
		Intitule = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(matiereId);

		objectOutput.writeLong(classeId);

		objectOutput.writeLong(professeurId);

		if (Intitule == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Intitule);
		}
	}

	public String uuid;
	public long matiereId;
	public long classeId;
	public long professeurId;
	public String Intitule;

}