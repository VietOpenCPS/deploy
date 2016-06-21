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

import org.opencps.usermgt.model.WorkingUnit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkingUnit in entity cache.
 *
 * @author khoavd
 * @see WorkingUnit
 * @generated
 */
public class WorkingUnitCacheModel implements CacheModel<WorkingUnit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{workingunitId=");
		sb.append(workingunitId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", enName=");
		sb.append(enName);
		sb.append(", govAgencyCode=");
		sb.append(govAgencyCode);
		sb.append(", managerWorkingUnitId=");
		sb.append(managerWorkingUnitId);
		sb.append(", parentWorkingUnitId=");
		sb.append(parentWorkingUnitId);
		sb.append(", sibling=");
		sb.append(sibling);
		sb.append(", treeIndex=");
		sb.append(treeIndex);
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
		sb.append(", faxNo=");
		sb.append(faxNo);
		sb.append(", email=");
		sb.append(email);
		sb.append(", website=");
		sb.append(website);
		sb.append(", isEmployer=");
		sb.append(isEmployer);
		sb.append(", mappingOrganisationId=");
		sb.append(mappingOrganisationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkingUnit toEntityModel() {
		WorkingUnitImpl workingUnitImpl = new WorkingUnitImpl();

		workingUnitImpl.setWorkingunitId(workingunitId);
		workingUnitImpl.setCompanyId(companyId);
		workingUnitImpl.setGroupId(groupId);
		workingUnitImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			workingUnitImpl.setCreateDate(null);
		}
		else {
			workingUnitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workingUnitImpl.setModifiedDate(null);
		}
		else {
			workingUnitImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			workingUnitImpl.setName(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setName(name);
		}

		if (enName == null) {
			workingUnitImpl.setEnName(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setEnName(enName);
		}

		if (govAgencyCode == null) {
			workingUnitImpl.setGovAgencyCode(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setGovAgencyCode(govAgencyCode);
		}

		workingUnitImpl.setManagerWorkingUnitId(managerWorkingUnitId);
		workingUnitImpl.setParentWorkingUnitId(parentWorkingUnitId);
		workingUnitImpl.setSibling(sibling);

		if (treeIndex == null) {
			workingUnitImpl.setTreeIndex(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setTreeIndex(treeIndex);
		}

		if (address == null) {
			workingUnitImpl.setAddress(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setAddress(address);
		}

		if (cityCode == null) {
			workingUnitImpl.setCityCode(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setCityCode(cityCode);
		}

		if (districtCode == null) {
			workingUnitImpl.setDistrictCode(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setDistrictCode(districtCode);
		}

		if (wardCode == null) {
			workingUnitImpl.setWardCode(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setWardCode(wardCode);
		}

		if (telNo == null) {
			workingUnitImpl.setTelNo(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setTelNo(telNo);
		}

		if (faxNo == null) {
			workingUnitImpl.setFaxNo(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setFaxNo(faxNo);
		}

		if (email == null) {
			workingUnitImpl.setEmail(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setEmail(email);
		}

		if (website == null) {
			workingUnitImpl.setWebsite(StringPool.BLANK);
		}
		else {
			workingUnitImpl.setWebsite(website);
		}

		workingUnitImpl.setIsEmployer(isEmployer);
		workingUnitImpl.setMappingOrganisationId(mappingOrganisationId);

		workingUnitImpl.resetOriginalValues();

		return workingUnitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workingunitId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		enName = objectInput.readUTF();
		govAgencyCode = objectInput.readUTF();
		managerWorkingUnitId = objectInput.readLong();
		parentWorkingUnitId = objectInput.readLong();
		sibling = objectInput.readInt();
		treeIndex = objectInput.readUTF();
		address = objectInput.readUTF();
		cityCode = objectInput.readUTF();
		districtCode = objectInput.readUTF();
		wardCode = objectInput.readUTF();
		telNo = objectInput.readUTF();
		faxNo = objectInput.readUTF();
		email = objectInput.readUTF();
		website = objectInput.readUTF();
		isEmployer = objectInput.readBoolean();
		mappingOrganisationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workingunitId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

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

		if (govAgencyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(govAgencyCode);
		}

		objectOutput.writeLong(managerWorkingUnitId);
		objectOutput.writeLong(parentWorkingUnitId);
		objectOutput.writeInt(sibling);

		if (treeIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(treeIndex);
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

		if (faxNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(faxNo);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		objectOutput.writeBoolean(isEmployer);
		objectOutput.writeLong(mappingOrganisationId);
	}

	public long workingunitId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String enName;
	public String govAgencyCode;
	public long managerWorkingUnitId;
	public long parentWorkingUnitId;
	public int sibling;
	public String treeIndex;
	public String address;
	public String cityCode;
	public String districtCode;
	public String wardCode;
	public String telNo;
	public String faxNo;
	public String email;
	public String website;
	public boolean isEmployer;
	public long mappingOrganisationId;
}