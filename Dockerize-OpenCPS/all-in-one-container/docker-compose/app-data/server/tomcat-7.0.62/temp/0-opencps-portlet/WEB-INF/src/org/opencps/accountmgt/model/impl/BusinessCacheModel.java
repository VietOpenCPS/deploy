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

import org.opencps.accountmgt.model.Business;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Business in entity cache.
 *
 * @author khoavd
 * @see Business
 * @generated
 */
public class BusinessCacheModel implements CacheModel<Business>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{businessId=");
		sb.append(businessId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", enName=");
		sb.append(enName);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", businessType=");
		sb.append(businessType);
		sb.append(", idNumber=");
		sb.append(idNumber);
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
		sb.append(", representativeName=");
		sb.append(representativeName);
		sb.append(", representativeRole=");
		sb.append(representativeRole);
		sb.append(", attachFile=");
		sb.append(attachFile);
		sb.append(", mappingOrganizationId=");
		sb.append(mappingOrganizationId);
		sb.append(", mappingUserId=");
		sb.append(mappingUserId);
		sb.append(", accountStatus=");
		sb.append(accountStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Business toEntityModel() {
		BusinessImpl businessImpl = new BusinessImpl();

		businessImpl.setBusinessId(businessId);
		businessImpl.setCompanyId(companyId);
		businessImpl.setGroupId(groupId);
		businessImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			businessImpl.setCreateDate(null);
		}
		else {
			businessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			businessImpl.setModifiedDate(null);
		}
		else {
			businessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uuid == null) {
			businessImpl.setUuid(StringPool.BLANK);
		}
		else {
			businessImpl.setUuid(uuid);
		}

		if (name == null) {
			businessImpl.setName(StringPool.BLANK);
		}
		else {
			businessImpl.setName(name);
		}

		if (enName == null) {
			businessImpl.setEnName(StringPool.BLANK);
		}
		else {
			businessImpl.setEnName(enName);
		}

		if (shortName == null) {
			businessImpl.setShortName(StringPool.BLANK);
		}
		else {
			businessImpl.setShortName(shortName);
		}

		if (businessType == null) {
			businessImpl.setBusinessType(StringPool.BLANK);
		}
		else {
			businessImpl.setBusinessType(businessType);
		}

		if (idNumber == null) {
			businessImpl.setIdNumber(StringPool.BLANK);
		}
		else {
			businessImpl.setIdNumber(idNumber);
		}

		if (address == null) {
			businessImpl.setAddress(StringPool.BLANK);
		}
		else {
			businessImpl.setAddress(address);
		}

		if (cityCode == null) {
			businessImpl.setCityCode(StringPool.BLANK);
		}
		else {
			businessImpl.setCityCode(cityCode);
		}

		if (districtCode == null) {
			businessImpl.setDistrictCode(StringPool.BLANK);
		}
		else {
			businessImpl.setDistrictCode(districtCode);
		}

		if (wardCode == null) {
			businessImpl.setWardCode(StringPool.BLANK);
		}
		else {
			businessImpl.setWardCode(wardCode);
		}

		if (telNo == null) {
			businessImpl.setTelNo(StringPool.BLANK);
		}
		else {
			businessImpl.setTelNo(telNo);
		}

		if (email == null) {
			businessImpl.setEmail(StringPool.BLANK);
		}
		else {
			businessImpl.setEmail(email);
		}

		if (representativeName == null) {
			businessImpl.setRepresentativeName(StringPool.BLANK);
		}
		else {
			businessImpl.setRepresentativeName(representativeName);
		}

		if (representativeRole == null) {
			businessImpl.setRepresentativeRole(StringPool.BLANK);
		}
		else {
			businessImpl.setRepresentativeRole(representativeRole);
		}

		businessImpl.setAttachFile(attachFile);
		businessImpl.setMappingOrganizationId(mappingOrganizationId);
		businessImpl.setMappingUserId(mappingUserId);
		businessImpl.setAccountStatus(accountStatus);

		businessImpl.resetOriginalValues();

		return businessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		businessId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uuid = objectInput.readUTF();
		name = objectInput.readUTF();
		enName = objectInput.readUTF();
		shortName = objectInput.readUTF();
		businessType = objectInput.readUTF();
		idNumber = objectInput.readUTF();
		address = objectInput.readUTF();
		cityCode = objectInput.readUTF();
		districtCode = objectInput.readUTF();
		wardCode = objectInput.readUTF();
		telNo = objectInput.readUTF();
		email = objectInput.readUTF();
		representativeName = objectInput.readUTF();
		representativeRole = objectInput.readUTF();
		attachFile = objectInput.readLong();
		mappingOrganizationId = objectInput.readLong();
		mappingUserId = objectInput.readLong();
		accountStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(businessId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (enName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(enName);
		}

		if (shortName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		if (businessType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessType);
		}

		if (idNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(idNumber);
		}

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

		if (representativeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(representativeName);
		}

		if (representativeRole == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(representativeRole);
		}

		objectOutput.writeLong(attachFile);
		objectOutput.writeLong(mappingOrganizationId);
		objectOutput.writeLong(mappingUserId);
		objectOutput.writeInt(accountStatus);
	}

	public long businessId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String uuid;
	public String name;
	public String enName;
	public String shortName;
	public String businessType;
	public String idNumber;
	public String address;
	public String cityCode;
	public String districtCode;
	public String wardCode;
	public String telNo;
	public String email;
	public String representativeName;
	public String representativeRole;
	public long attachFile;
	public long mappingOrganizationId;
	public long mappingUserId;
	public int accountStatus;
}