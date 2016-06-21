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

package org.opencps.accountmgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.accountmgt.model.BusinessAccount;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusinessAccount in entity cache.
 *
 * @author khoavd
 * @see BusinessAccount
 * @generated
 */
public class BusinessAccountCacheModel implements CacheModel<BusinessAccount>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{businessAccountId=");
		sb.append(businessAccountId);
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
		sb.append(", businessId=");
		sb.append(businessId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", workingRole=");
		sb.append(workingRole);
		sb.append(", telNo=");
		sb.append(telNo);
		sb.append(", email=");
		sb.append(email);
		sb.append(", mappingUserId=");
		sb.append(mappingUserId);
		sb.append(", hasPermissions=");
		sb.append(hasPermissions);
		sb.append(", accountStatus=");
		sb.append(accountStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BusinessAccount toEntityModel() {
		BusinessAccountImpl businessAccountImpl = new BusinessAccountImpl();

		businessAccountImpl.setBusinessAccountId(businessAccountId);
		businessAccountImpl.setCompanyId(companyId);
		businessAccountImpl.setGroupId(groupId);
		businessAccountImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			businessAccountImpl.setCreateDate(null);
		}
		else {
			businessAccountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			businessAccountImpl.setModifiedDate(null);
		}
		else {
			businessAccountImpl.setModifiedDate(new Date(modifiedDate));
		}

		businessAccountImpl.setBusinessId(businessId);

		if (fullName == null) {
			businessAccountImpl.setFullName(StringPool.BLANK);
		}
		else {
			businessAccountImpl.setFullName(fullName);
		}

		if (workingRole == null) {
			businessAccountImpl.setWorkingRole(StringPool.BLANK);
		}
		else {
			businessAccountImpl.setWorkingRole(workingRole);
		}

		if (telNo == null) {
			businessAccountImpl.setTelNo(StringPool.BLANK);
		}
		else {
			businessAccountImpl.setTelNo(telNo);
		}

		if (email == null) {
			businessAccountImpl.setEmail(StringPool.BLANK);
		}
		else {
			businessAccountImpl.setEmail(email);
		}

		businessAccountImpl.setMappingUserId(mappingUserId);

		if (hasPermissions == null) {
			businessAccountImpl.setHasPermissions(StringPool.BLANK);
		}
		else {
			businessAccountImpl.setHasPermissions(hasPermissions);
		}

		businessAccountImpl.setAccountStatus(accountStatus);

		businessAccountImpl.resetOriginalValues();

		return businessAccountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		businessAccountId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		businessId = objectInput.readLong();
		fullName = objectInput.readUTF();
		workingRole = objectInput.readUTF();
		telNo = objectInput.readUTF();
		email = objectInput.readUTF();
		mappingUserId = objectInput.readLong();
		hasPermissions = objectInput.readUTF();
		accountStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(businessAccountId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(businessId);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (workingRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workingRole);
		}

		if (telNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telNo);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(mappingUserId);

		if (hasPermissions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hasPermissions);
		}

		objectOutput.writeInt(accountStatus);
	}

	public long businessAccountId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long businessId;
	public String fullName;
	public String workingRole;
	public String telNo;
	public String email;
	public long mappingUserId;
	public String hasPermissions;
	public int accountStatus;
}