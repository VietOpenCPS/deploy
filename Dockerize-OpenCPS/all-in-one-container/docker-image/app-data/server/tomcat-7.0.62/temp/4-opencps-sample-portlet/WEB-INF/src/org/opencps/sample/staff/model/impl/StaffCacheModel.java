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

package org.opencps.sample.staff.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.sample.staff.model.Staff;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Staff in entity cache.
 *
 * @author trungnt
 * @see Staff
 * @generated
 */
public class StaffCacheModel implements CacheModel<Staff>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{staffId=");
		sb.append(staffId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", birthDay=");
		sb.append(birthDay);
		sb.append(", address=");
		sb.append(address);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", position=");
		sb.append(position);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Staff toEntityModel() {
		StaffImpl staffImpl = new StaffImpl();

		staffImpl.setStaffId(staffId);
		staffImpl.setGroupId(groupId);
		staffImpl.setCompanyId(companyId);
		staffImpl.setUserId(userId);

		if (userName == null) {
			staffImpl.setUserName(StringPool.BLANK);
		}
		else {
			staffImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			staffImpl.setCreateDate(null);
		}
		else {
			staffImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			staffImpl.setModifiedDate(null);
		}
		else {
			staffImpl.setModifiedDate(new Date(modifiedDate));
		}

		staffImpl.setDepartmentId(departmentId);

		if (fullName == null) {
			staffImpl.setFullName(StringPool.BLANK);
		}
		else {
			staffImpl.setFullName(fullName);
		}

		if (birthDay == Long.MIN_VALUE) {
			staffImpl.setBirthDay(null);
		}
		else {
			staffImpl.setBirthDay(new Date(birthDay));
		}

		if (address == null) {
			staffImpl.setAddress(StringPool.BLANK);
		}
		else {
			staffImpl.setAddress(address);
		}

		if (email == null) {
			staffImpl.setEmail(StringPool.BLANK);
		}
		else {
			staffImpl.setEmail(email);
		}

		if (phoneNumber == null) {
			staffImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			staffImpl.setPhoneNumber(phoneNumber);
		}

		if (position == null) {
			staffImpl.setPosition(StringPool.BLANK);
		}
		else {
			staffImpl.setPosition(position);
		}

		if (description == null) {
			staffImpl.setDescription(StringPool.BLANK);
		}
		else {
			staffImpl.setDescription(description);
		}

		staffImpl.resetOriginalValues();

		return staffImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		staffId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		departmentId = objectInput.readLong();
		fullName = objectInput.readUTF();
		birthDay = objectInput.readLong();
		address = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		position = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(staffId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(departmentId);

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeLong(birthDay);

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (position == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(position);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long staffId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long departmentId;
	public String fullName;
	public long birthDay;
	public String address;
	public String email;
	public String phoneNumber;
	public String position;
	public String description;
}