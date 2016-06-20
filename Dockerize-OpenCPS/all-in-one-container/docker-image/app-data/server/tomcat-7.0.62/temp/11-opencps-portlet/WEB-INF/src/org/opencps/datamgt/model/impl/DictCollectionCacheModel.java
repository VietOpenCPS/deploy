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

import org.opencps.datamgt.model.DictCollection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DictCollection in entity cache.
 *
 * @author khoavd
 * @see DictCollection
 * @generated
 */
public class DictCollectionCacheModel implements CacheModel<DictCollection>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dictCollectionId=");
		sb.append(dictCollectionId);
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
		sb.append(", collectionCode=");
		sb.append(collectionCode);
		sb.append(", collectionName=");
		sb.append(collectionName);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DictCollection toEntityModel() {
		DictCollectionImpl dictCollectionImpl = new DictCollectionImpl();

		dictCollectionImpl.setDictCollectionId(dictCollectionId);
		dictCollectionImpl.setCompanyId(companyId);
		dictCollectionImpl.setGroupId(groupId);
		dictCollectionImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dictCollectionImpl.setCreateDate(null);
		}
		else {
			dictCollectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dictCollectionImpl.setModifiedDate(null);
		}
		else {
			dictCollectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (collectionCode == null) {
			dictCollectionImpl.setCollectionCode(StringPool.BLANK);
		}
		else {
			dictCollectionImpl.setCollectionCode(collectionCode);
		}

		if (collectionName == null) {
			dictCollectionImpl.setCollectionName(StringPool.BLANK);
		}
		else {
			dictCollectionImpl.setCollectionName(collectionName);
		}

		if (description == null) {
			dictCollectionImpl.setDescription(StringPool.BLANK);
		}
		else {
			dictCollectionImpl.setDescription(description);
		}

		dictCollectionImpl.resetOriginalValues();

		return dictCollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dictCollectionId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		collectionCode = objectInput.readUTF();
		collectionName = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dictCollectionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (collectionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionCode);
		}

		if (collectionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(collectionName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long dictCollectionId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String collectionCode;
	public String collectionName;
	public String description;
}