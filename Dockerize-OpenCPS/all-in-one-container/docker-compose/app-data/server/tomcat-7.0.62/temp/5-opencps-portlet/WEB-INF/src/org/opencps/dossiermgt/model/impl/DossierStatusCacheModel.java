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

import org.opencps.dossiermgt.model.DossierStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DossierStatus in entity cache.
 *
 * @author trungnt
 * @see DossierStatus
 * @generated
 */
public class DossierStatusCacheModel implements CacheModel<DossierStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{dossierStatusId=");
		sb.append(dossierStatusId);
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
		sb.append(", fileGroupId=");
		sb.append(fileGroupId);
		sb.append(", dossierStatus=");
		sb.append(dossierStatus);
		sb.append(", actionInfo=");
		sb.append(actionInfo);
		sb.append(", messageInfo=");
		sb.append(messageInfo);
		sb.append(", updateDatetime=");
		sb.append(updateDatetime);
		sb.append(", syncStatus=");
		sb.append(syncStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DossierStatus toEntityModel() {
		DossierStatusImpl dossierStatusImpl = new DossierStatusImpl();

		dossierStatusImpl.setDossierStatusId(dossierStatusId);
		dossierStatusImpl.setCompanyId(companyId);
		dossierStatusImpl.setGroupId(groupId);
		dossierStatusImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dossierStatusImpl.setCreateDate(null);
		}
		else {
			dossierStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dossierStatusImpl.setModifiedDate(null);
		}
		else {
			dossierStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		dossierStatusImpl.setDossierId(dossierId);
		dossierStatusImpl.setFileGroupId(fileGroupId);
		dossierStatusImpl.setDossierStatus(dossierStatus);

		if (actionInfo == null) {
			dossierStatusImpl.setActionInfo(StringPool.BLANK);
		}
		else {
			dossierStatusImpl.setActionInfo(actionInfo);
		}

		if (messageInfo == null) {
			dossierStatusImpl.setMessageInfo(StringPool.BLANK);
		}
		else {
			dossierStatusImpl.setMessageInfo(messageInfo);
		}

		if (updateDatetime == Long.MIN_VALUE) {
			dossierStatusImpl.setUpdateDatetime(null);
		}
		else {
			dossierStatusImpl.setUpdateDatetime(new Date(updateDatetime));
		}

		dossierStatusImpl.setSyncStatus(syncStatus);

		dossierStatusImpl.resetOriginalValues();

		return dossierStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dossierStatusId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dossierId = objectInput.readLong();
		fileGroupId = objectInput.readLong();
		dossierStatus = objectInput.readInt();
		actionInfo = objectInput.readUTF();
		messageInfo = objectInput.readUTF();
		updateDatetime = objectInput.readLong();
		syncStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dossierStatusId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dossierId);
		objectOutput.writeLong(fileGroupId);
		objectOutput.writeInt(dossierStatus);

		if (actionInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionInfo);
		}

		if (messageInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageInfo);
		}

		objectOutput.writeLong(updateDatetime);
		objectOutput.writeInt(syncStatus);
	}

	public long dossierStatusId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long dossierId;
	public long fileGroupId;
	public int dossierStatus;
	public String actionInfo;
	public String messageInfo;
	public long updateDatetime;
	public int syncStatus;
}