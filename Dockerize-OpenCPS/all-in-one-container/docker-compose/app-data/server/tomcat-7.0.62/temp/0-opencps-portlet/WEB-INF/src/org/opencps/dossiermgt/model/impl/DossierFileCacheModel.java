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

import org.opencps.dossiermgt.model.DossierFile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DossierFile in entity cache.
 *
 * @author trungnt
 * @see DossierFile
 * @generated
 */
public class DossierFileCacheModel implements CacheModel<DossierFile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{dossierFileId=");
		sb.append(dossierFileId);
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
		sb.append(", dossierId=");
		sb.append(dossierId);
		sb.append(", uuid=");
		sb.append(uuid);
		sb.append(", dossierPartId=");
		sb.append(dossierPartId);
		sb.append(", templateFileNo=");
		sb.append(templateFileNo);
		sb.append(", groupFileId=");
		sb.append(groupFileId);
		sb.append(", ownerUserId=");
		sb.append(ownerUserId);
		sb.append(", ownerOrganizationId=");
		sb.append(ownerOrganizationId);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", formData=");
		sb.append(formData);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", dossierFileMark=");
		sb.append(dossierFileMark);
		sb.append(", dossierFileType=");
		sb.append(dossierFileType);
		sb.append(", dossierFileNo=");
		sb.append(dossierFileNo);
		sb.append(", dossierFileDate=");
		sb.append(dossierFileDate);
		sb.append(", removed=");
		sb.append(removed);
		sb.append(", original=");
		sb.append(original);
		sb.append(", syncStatus=");
		sb.append(syncStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DossierFile toEntityModel() {
		DossierFileImpl dossierFileImpl = new DossierFileImpl();

		dossierFileImpl.setDossierFileId(dossierFileId);
		dossierFileImpl.setCompanyId(companyId);
		dossierFileImpl.setGroupId(groupId);
		dossierFileImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dossierFileImpl.setCreateDate(null);
		}
		else {
			dossierFileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dossierFileImpl.setModifiedDate(null);
		}
		else {
			dossierFileImpl.setModifiedDate(new Date(modifiedDate));
		}

		dossierFileImpl.setDossierId(dossierId);

		if (uuid == null) {
			dossierFileImpl.setUuid(StringPool.BLANK);
		}
		else {
			dossierFileImpl.setUuid(uuid);
		}

		dossierFileImpl.setDossierPartId(dossierPartId);

		if (templateFileNo == null) {
			dossierFileImpl.setTemplateFileNo(StringPool.BLANK);
		}
		else {
			dossierFileImpl.setTemplateFileNo(templateFileNo);
		}

		dossierFileImpl.setGroupFileId(groupFileId);
		dossierFileImpl.setOwnerUserId(ownerUserId);
		dossierFileImpl.setOwnerOrganizationId(ownerOrganizationId);

		if (displayName == null) {
			dossierFileImpl.setDisplayName(StringPool.BLANK);
		}
		else {
			dossierFileImpl.setDisplayName(displayName);
		}

		if (formData == null) {
			dossierFileImpl.setFormData(StringPool.BLANK);
		}
		else {
			dossierFileImpl.setFormData(formData);
		}

		dossierFileImpl.setFileEntryId(fileEntryId);
		dossierFileImpl.setDossierFileMark(dossierFileMark);
		dossierFileImpl.setDossierFileType(dossierFileType);

		if (dossierFileNo == null) {
			dossierFileImpl.setDossierFileNo(StringPool.BLANK);
		}
		else {
			dossierFileImpl.setDossierFileNo(dossierFileNo);
		}

		if (dossierFileDate == Long.MIN_VALUE) {
			dossierFileImpl.setDossierFileDate(null);
		}
		else {
			dossierFileImpl.setDossierFileDate(new Date(dossierFileDate));
		}

		dossierFileImpl.setRemoved(removed);
		dossierFileImpl.setOriginal(original);
		dossierFileImpl.setSyncStatus(syncStatus);

		dossierFileImpl.resetOriginalValues();

		return dossierFileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dossierFileId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dossierId = objectInput.readLong();
		uuid = objectInput.readUTF();
		dossierPartId = objectInput.readLong();
		templateFileNo = objectInput.readUTF();
		groupFileId = objectInput.readLong();
		ownerUserId = objectInput.readLong();
		ownerOrganizationId = objectInput.readLong();
		displayName = objectInput.readUTF();
		formData = objectInput.readUTF();
		fileEntryId = objectInput.readLong();
		dossierFileMark = objectInput.readInt();
		dossierFileType = objectInput.readInt();
		dossierFileNo = objectInput.readUTF();
		dossierFileDate = objectInput.readLong();
		removed = objectInput.readInt();
		original = objectInput.readInt();
		syncStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dossierFileId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dossierId);

		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(dossierPartId);

		if (templateFileNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateFileNo);
		}

		objectOutput.writeLong(groupFileId);
		objectOutput.writeLong(ownerUserId);
		objectOutput.writeLong(ownerOrganizationId);

		if (displayName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (formData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formData);
		}

		objectOutput.writeLong(fileEntryId);
		objectOutput.writeInt(dossierFileMark);
		objectOutput.writeInt(dossierFileType);

		if (dossierFileNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dossierFileNo);
		}

		objectOutput.writeLong(dossierFileDate);
		objectOutput.writeInt(removed);
		objectOutput.writeInt(original);
		objectOutput.writeInt(syncStatus);
	}

	public long dossierFileId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long dossierId;
	public String uuid;
	public long dossierPartId;
	public String templateFileNo;
	public long groupFileId;
	public long ownerUserId;
	public long ownerOrganizationId;
	public String displayName;
	public String formData;
	public long fileEntryId;
	public int dossierFileMark;
	public int dossierFileType;
	public String dossierFileNo;
	public long dossierFileDate;
	public int removed;
	public int original;
	public int syncStatus;
}