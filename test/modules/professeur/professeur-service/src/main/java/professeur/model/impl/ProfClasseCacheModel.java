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

import professeur.model.ProfClasse;

/**
 * The cache model class for representing ProfClasse in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProfClasseCacheModel
	implements CacheModel<ProfClasse>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProfClasseCacheModel)) {
			return false;
		}

		ProfClasseCacheModel profClasseCacheModel =
			(ProfClasseCacheModel)object;

		if (profClasseId == profClasseCacheModel.profClasseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, profClasseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", profClasseId=");
		sb.append(profClasseId);
		sb.append(", professeurId=");
		sb.append(professeurId);
		sb.append(", classeId=");
		sb.append(classeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProfClasse toEntityModel() {
		ProfClasseImpl profClasseImpl = new ProfClasseImpl();

		if (uuid == null) {
			profClasseImpl.setUuid("");
		}
		else {
			profClasseImpl.setUuid(uuid);
		}

		profClasseImpl.setProfClasseId(profClasseId);
		profClasseImpl.setProfesseurId(professeurId);
		profClasseImpl.setClasseId(classeId);

		profClasseImpl.resetOriginalValues();

		return profClasseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		profClasseId = objectInput.readLong();

		professeurId = objectInput.readLong();

		classeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(profClasseId);

		objectOutput.writeLong(professeurId);

		objectOutput.writeLong(classeId);
	}

	public String uuid;
	public long profClasseId;
	public long professeurId;
	public long classeId;

}