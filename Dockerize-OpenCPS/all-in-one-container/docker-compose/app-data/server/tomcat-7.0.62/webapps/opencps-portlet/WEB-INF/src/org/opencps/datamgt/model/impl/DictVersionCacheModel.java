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

package org.opencps.datamgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.datamgt.model.DictVersion;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DictVersion in entity cache.
 *
 * @author khoavd
 * @see DictVersion
 * @generated
 */
public class DictVersionCacheModel implements CacheModel<DictVersion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{dictVersionId=");
		sb.append(dictVersionId);
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
		sb.append(", dictCollectionId=");
		sb.append(dictCollectionId);
		sb.append(", version=");
		sb.append(version);
		sb.append(", description=");
		sb.append(description);
		sb.append(", validatedFrom=");
		sb.append(validatedFrom);
		sb.append(", validatedTo=");
		sb.append(validatedTo);
		sb.append(", issueStatus=");
		sb.append(issueStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DictVersion toEntityModel() {
		DictVersionImpl dictVersionImpl = new DictVersionImpl();

		dictVersionImpl.setDictVersionId(dictVersionId);
		dictVersionImpl.setCompanyId(companyId);
		dictVersionImpl.setGroupId(groupId);
		dictVersionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dictVersionImpl.setCreateDate(null);
		}
		else {
			dictVersionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dictVersionImpl.setModifiedDate(null);
		}
		else {
			dictVersionImpl.setModifiedDate(new Date(modifiedDate));
		}

		dictVersionImpl.setDictCollectionId(dictCollectionId);

		if (version == null) {
			dictVersionImpl.setVersion(StringPool.BLANK);
		}
		else {
			dictVersionImpl.setVersion(version);
		}

		if (description == null) {
			dictVersionImpl.setDescription(StringPool.BLANK);
		}
		else {
			dictVersionImpl.setDescription(description);
		}

		if (validatedFrom == Long.MIN_VALUE) {
			dictVersionImpl.setValidatedFrom(null);
		}
		else {
			dictVersionImpl.setValidatedFrom(new Date(validatedFrom));
		}

		if (validatedTo == Long.MIN_VALUE) {
			dictVersionImpl.setValidatedTo(null);
		}
		else {
			dictVersionImpl.setValidatedTo(new Date(validatedTo));
		}

		dictVersionImpl.setIssueStatus(issueStatus);

		dictVersionImpl.resetOriginalValues();

		return dictVersionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictVersionId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dictCollectionId = objectInput.readLong();
		version = objectInput.readUTF();
		description = objectInput.readUTF();
		validatedFrom = objectInput.readLong();
		validatedTo = objectInput.readLong();
		issueStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictVersionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dictCollectionId);

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(validatedFrom);
		objectOutput.writeLong(validatedTo);
		objectOutput.writeInt(issueStatus);
	}

	public long dictVersionId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long dictCollectionId;
	public String version;
	public String description;
	public long validatedFrom;
	public long validatedTo;
	public int issueStatus;
}