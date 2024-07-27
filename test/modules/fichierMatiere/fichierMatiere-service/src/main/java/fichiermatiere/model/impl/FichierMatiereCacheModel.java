/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package fichiermatiere.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import fichiermatiere.model.FichierMatiere;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FichierMatiere in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FichierMatiereCacheModel
	implements CacheModel<FichierMatiere>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FichierMatiereCacheModel)) {
			return false;
		}

		FichierMatiereCacheModel fichierMatiereCacheModel =
			(FichierMatiereCacheModel)object;

		if (fichierMatiereId == fichierMatiereCacheModel.fichierMatiereId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fichierMatiereId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fichierMatiereId=");
		sb.append(fichierMatiereId);
		sb.append(", matiereId=");
		sb.append(matiereId);
		sb.append(", fichierId=");
		sb.append(fichierId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FichierMatiere toEntityModel() {
		FichierMatiereImpl fichierMatiereImpl = new FichierMatiereImpl();

		if (uuid == null) {
			fichierMatiereImpl.setUuid("");
		}
		else {
			fichierMatiereImpl.setUuid(uuid);
		}

		fichierMatiereImpl.setFichierMatiereId(fichierMatiereId);
		fichierMatiereImpl.setMatiereId(matiereId);
		fichierMatiereImpl.setFichierId(fichierId);

		fichierMatiereImpl.resetOriginalValues();

		return fichierMatiereImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fichierMatiereId = objectInput.readLong();

		matiereId = objectInput.readLong();

		fichierId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fichierMatiereId);

		objectOutput.writeLong(matiereId);

		objectOutput.writeLong(fichierId);
	}

	public String uuid;
	public long fichierMatiereId;
	public long matiereId;
	public long fichierId;

}