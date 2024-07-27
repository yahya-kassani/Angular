/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package classe.model.impl;

import classe.model.Classe;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Classe in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ClasseCacheModel implements CacheModel<Classe>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ClasseCacheModel)) {
			return false;
		}

		ClasseCacheModel classeCacheModel = (ClasseCacheModel)object;

		if (classeId == classeCacheModel.classeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, classeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", classeId=");
		sb.append(classeId);
		sb.append(", Intitule=");
		sb.append(Intitule);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Classe toEntityModel() {
		ClasseImpl classeImpl = new ClasseImpl();

		if (uuid == null) {
			classeImpl.setUuid("");
		}
		else {
			classeImpl.setUuid(uuid);
		}

		classeImpl.setClasseId(classeId);

		if (Intitule == null) {
			classeImpl.setIntitule("");
		}
		else {
			classeImpl.setIntitule(Intitule);
		}

		classeImpl.resetOriginalValues();

		return classeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		classeId = objectInput.readLong();
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

		objectOutput.writeLong(classeId);

		if (Intitule == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(Intitule);
		}
	}

	public String uuid;
	public long classeId;
	public String Intitule;

}