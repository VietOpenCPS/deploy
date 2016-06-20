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

package org.opencps.usermgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.usermgt.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author khoavd
 * @see Employee
 * @generated
 */
public class EmployeeCacheModel implements CacheModel<Employee>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{employeeId=");
		sb.append(employeeId);
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
		sb.append(", workingUnitId=");
		sb.append(workingUnitId);
		sb.append(", employeeNo=");
		sb.append(employeeNo);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", birthdate=");
		sb.append(birthdate);
		sb.append(", telNo=");
		sb.append(telNo);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", email=");
		sb.append(email);
		sb.append(", workingStatus=");
		sb.append(workingStatus);
		sb.append(", mainJobPosId=");
		sb.append(mainJobPosId);
		sb.append(", mappingUserId=");
		sb.append(mappingUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmployeeId(employeeId);
		employeeImpl.setCompanyId(companyId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeImpl.setModifiedDate(null);
		}
		else {
			employeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeImpl.setWorkingUnitId(workingUnitId);

		if (employeeNo == null) {
			employeeImpl.setEmployeeNo(StringPool.BLANK);
		}
		else {
			employeeImpl.setEmployeeNo(employeeNo);
		}

		if (fullName == null) {
			employeeImpl.setFullName(StringPool.BLANK);
		}
		else {
			employeeImpl.setFullName(fullName);
		}

		employeeImpl.setGender(gender);

		if (birthdate == Long.MIN_VALUE) {
			employeeImpl.setBirthdate(null);
		}
		else {
			employeeImpl.setBirthdate(new Date(birthdate));
		}

		if (telNo == null) {
			employeeImpl.setTelNo(StringPool.BLANK);
		}
		else {
			employeeImpl.setTelNo(telNo);
		}

		if (mobile == null) {
			employeeImpl.setMobile(StringPool.BLANK);
		}
		else {
			employeeImpl.setMobile(mobile);
		}

		if (email == null) {
			employeeImpl.setEmail(StringPool.BLANK);
		}
		else {
			employeeImpl.setEmail(email);
		}

		employeeImpl.setWorkingStatus(workingStatus);
		employeeImpl.setMainJobPosId(mainJobPosId);
		employeeImpl.setMappingUserId(mappingUserId);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		workingUnitId = objectInput.readLong();
		employeeNo = objectInput.readUTF();
		fullName = objectInput.readUTF();
		gender = objectInput.readInt();
		birthdate = objectInput.readLong();
		telNo = objectInput.readUTF();
		mobile = objectInput.readUTF();
		email = objectInput.readUTF();
		workingStatus = objectInput.readInt();
		mainJobPosId = objectInput.readLong();
		mappingUserId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(workingUnitId);

		if (employeeNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeNo);
		}

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		objectOutput.writeInt(gender);
		objectOutput.writeLong(birthdate);

		if (telNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telNo);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeInt(workingStatus);
		objectOutput.writeLong(mainJobPosId);
		objectOutput.writeLong(mappingUserId);
	}

	public long employeeId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long workingUnitId;
	public String employeeNo;
	public String fullName;
	public int gender;
	public long birthdate;
	public String telNo;
	public String mobile;
	public String email;
	public int workingStatus;
	public long mainJobPosId;
	public long mappingUserId;
}