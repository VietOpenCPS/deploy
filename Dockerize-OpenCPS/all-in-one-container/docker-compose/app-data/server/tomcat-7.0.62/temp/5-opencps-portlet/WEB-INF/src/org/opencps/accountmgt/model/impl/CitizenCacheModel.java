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

import org.opencps.accountmgt.model.Citizen;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Citizen in entity cache.
 *
 * @author khoavd
 * @see Citizen
 * @generated
 */
public class CitizenCacheModel implements CacheModel<Citizen>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{citizenId=");
		sb.append(citizenId);
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
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", personalId=");
		sb.append(personalId);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", birthdate=");
		sb.append(birthdate);
		sb.append(", address=");
		sb.append(address);
		sb.append(", cityCode=");
		sb.append(cityCode);
		sb.append(", districtCode=");
		sb.append(districtCode);
		sb.append(", wardCode=");
		sb.append(wardCode);
		sb.append(", telNo=");
		sb.append(telNo);
		sb.append(", email=");
		sb.append(email);
		sb.append(", attachFile=");
		sb.append(attachFile);
		sb.append(", mappingUserId=");
		sb.append(mappingUserId);
		sb.append(", accountStatus=");
		sb.append(accountStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Citizen toEntityModel() {
		CitizenImpl citizenImpl = new CitizenImpl();

		citizenImpl.setCitizenId(citizenId);
		citizenImpl.setCompanyId(companyId);
		citizenImpl.setGroupId(groupId);
		citizenImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			citizenImpl.setCreateDate(null);
		}
		else {
			citizenImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			citizenImpl.setModifiedDate(null);
		}
		else {
			citizenImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uuid == null) {
			citizenImpl.setUuid(StringPool.BLANK);
		}
		else {
			citizenImpl.setUuid(uuid);
		}

		if (fullName == null) {
			citizenImpl.setFullName(StringPool.BLANK);
		}
		else {
			citizenImpl.setFullName(fullName);
		}

		if (personalId == null) {
			citizenImpl.setPersonalId(StringPool.BLANK);
		}
		else {
			citizenImpl.setPersonalId(personalId);
		}

		citizenImpl.setGender(gender);

		if (birthdate == Long.MIN_VALUE) {
			citizenImpl.setBirthdate(null);
		}
		else {
			citizenImpl.setBirthdate(new Date(birthdate));
		}

		if (address == null) {
			citizenImpl.setAddress(StringPool.BLANK);
		}
		else {
			citizenImpl.setAddress(address);
		}

		if (cityCode == null) {
			citizenImpl.setCityCode(StringPool.BLANK);
		}
		else {
			citizenImpl.setCityCode(cityCode);
		}

		if (districtCode == null) {
			citizenImpl.setDistrictCode(StringPool.BLANK);
		}
		else {
			citizenImpl.setDistrictCode(districtCode);
		}

		if (wardCode == null) {
			citizenImpl.setWardCode(StringPool.BLANK);
		}
		else {
			citizenImpl.setWardCode(wardCode);
		}

		if (telNo == null) {
			citizenImpl.setTelNo(StringPool.BLANK);
		}
		else {
			citizenImpl.setTelNo(telNo);
		}

		if (email == null) {
			citizenImpl.setEmail(StringPool.BLANK);
		}
		else {
			citizenImpl.setEmail(email);
		}

		citizenImpl.setAttachFile(attachFile);
		citizenImpl.setMappingUserId(mappingUserId);
		citizenImpl.setAccountStatus(accountStatus);

		citizenImpl.resetOriginalValues();

		return citizenImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		citizenId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uuid = objectInput.readUTF();
		fullName = objectInput.readUTF();
		personalId = objectInput.readUTF();
		gender = objectInput.readInt();
		birthdate = objectInput.readLong();
		address = objectInput.readUTF();
		cityCode = objectInput.readUTF();
		districtCode = objectInput.readUTF();
		wardCode = objectInput.readUTF();
		telNo = objectInput.readUTF();
		email = objectInput.readUTF();
		attachFile = objectInput.readLong();
		mappingUserId = objectInput.readLong();
		accountStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(citizenId);
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

		if (fullName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (personalId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalId);
		}

		objectOutput.writeInt(gender);
		objectOutput.writeLong(birthdate);

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (cityCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cityCode);
		}

		if (districtCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(districtCode);
		}

		if (wardCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wardCode);
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

		objectOutput.writeLong(attachFile);
		objectOutput.writeLong(mappingUserId);
		objectOutput.writeInt(accountStatus);
	}

	public long citizenId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String uuid;
	public String fullName;
	public String personalId;
	public int gender;
	public long birthdate;
	public String address;
	public String cityCode;
	public String districtCode;
	public String wardCode;
	public String telNo;
	public String email;
	public long attachFile;
	public long mappingUserId;
	public int accountStatus;
}