/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package etudiant.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import etudiant.model.Etudiant;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Etudiant in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EtudiantCacheModel
	implements CacheModel<Etudiant>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EtudiantCacheModel)) {
			return false;
		}

		EtudiantCacheModel etudiantCacheModel = (EtudiantCacheModel)object;

		if (etudiantId == etudiantCacheModel.etudiantId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, etudiantId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", etudiantId=");
		sb.append(etudiantId);
		sb.append(", nom=");
		sb.append(nom);
		sb.append(", prenom=");
		sb.append(prenom);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", classeId=");
		sb.append(classeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Etudiant toEntityModel() {
		EtudiantImpl etudiantImpl = new EtudiantImpl();

		if (uuid == null) {
			etudiantImpl.setUuid("");
		}
		else {
			etudiantImpl.setUuid(uuid);
		}

		etudiantImpl.setEtudiantId(etudiantId);

		if (nom == null) {
			etudiantImpl.setNom("");
		}
		else {
			etudiantImpl.setNom(nom);
		}

		if (prenom == null) {
			etudiantImpl.setPrenom("");
		}
		else {
			etudiantImpl.setPrenom(prenom);
		}

		etudiantImpl.setImageId(imageId);
		etudiantImpl.setClasseId(classeId);

		etudiantImpl.resetOriginalValues();

		return etudiantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		etudiantId = objectInput.readLong();
		nom = objectInput.readUTF();
		prenom = objectInput.readUTF();

		imageId = objectInput.readLong();

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

		objectOutput.writeLong(etudiantId);

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

		objectOutput.writeLong(imageId);

		objectOutput.writeLong(classeId);
	}

	public String uuid;
	public long etudiantId;
	public String nom;
	public String prenom;
	public long imageId;
	public long classeId;

}