/**
 * OpenCPS is the open source Core Public Services software
 * Copyright (C) 2016-present OpenCPS community
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 */

package org.opencps.dossiermgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.dossiermgt.model.FileGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileGroup in entity cache.
 *
 * @author trungnt
 * @see FileGroup
 * @generated
 */
public class FileGroupCacheModel implements CacheModel<FileGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{fileGroupId=");
		sb.append(fileGroupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", dossierId=");
		sb.append(dossierId);
		sb.append(", dossierPartId=");
		sb.append(dossierPartId);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", removed=");
		sb.append(removed);
		sb.append(", syncStatus=");
		sb.append(syncStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileGroup toEntityModel() {
		FileGroupImpl fileGroupImpl = new FileGroupImpl();

		fileGroupImpl.setFileGroupId(fileGroupId);
		fileGroupImpl.setCompanyId(companyId);
		fileGroupImpl.setGroupId(groupId);
		fileGroupImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			fileGroupImpl.setCreateDate(null);
		}
		else {
			fileGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fileGroupImpl.setModifiedDate(null);
		}
		else {
			fileGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uuid == null) {
			fileGroupImpl.setUuid(StringPool.BLANK);
		}
		else {
			fileGroupImpl.setUuid(uuid);
		}

		fileGroupImpl.setDossierId(dossierId);
		fileGroupImpl.setDossierPartId(dossierPartId);

		if (displayName == null) {
			fileGroupImpl.setDisplayName(StringPool.BLANK);
		}
		else {
			fileGroupImpl.setDisplayName(displayName);
		}

		fileGroupImpl.setRemoved(removed);
		fileGroupImpl.setSyncStatus(syncStatus);

		fileGroupImpl.resetOriginalValues();

		return fileGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileGroupId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uuid = objectInput.readUTF();
		dossierId = objectInput.readLong();
		dossierPartId = objectInput.readLong();
		displayName = objectInput.readUTF();
		removed = objectInput.readInt();
		syncStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fileGroupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dossierId);
		objectOutput.writeLong(dossierPartId);

		if (displayName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		objectOutput.writeInt(removed);
		objectOutput.writeInt(syncStatus);
	}

	public long fileGroupId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String uuid;
	public long dossierId;
	public long dossierPartId;
	public String displayName;
	public int removed;
	public int syncStatus;
}