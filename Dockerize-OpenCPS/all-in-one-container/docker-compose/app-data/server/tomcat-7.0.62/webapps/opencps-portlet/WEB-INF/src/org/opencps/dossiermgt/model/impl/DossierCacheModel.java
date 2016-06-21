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

import org.opencps.dossiermgt.model.Dossier;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Dossier in entity cache.
 *
 * @author trungnt
 * @see Dossier
 * @generated
 */
public class DossierCacheModel implements CacheModel<Dossier>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{dossierId=");
		sb.append(dossierId);
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
		sb.append(", externalRefNo=");
		sb.append(externalRefNo);
		sb.append(", externalRefUrl=");
		sb.append(externalRefUrl);
		sb.append(", ownerOrganizationId=");
		sb.append(ownerOrganizationId);
		sb.append(", serviceConfigId=");
		sb.append(serviceConfigId);
		sb.append(", serviceInfoId=");
		sb.append(serviceInfoId);
		sb.append(", serviceDomainIndex=");
		sb.append(serviceDomainIndex);
		sb.append(", serviceAdministrationIndex=");
		sb.append(serviceAdministrationIndex);
		sb.append(", dossierTemplateId=");
		sb.append(dossierTemplateId);
		sb.append(", govAgencyCode=");
		sb.append(govAgencyCode);
		sb.append(", govAgencyName=");
		sb.append(govAgencyName);
		sb.append(", govAgencyOrganizationId=");
		sb.append(govAgencyOrganizationId);
		sb.append(", serviceMode=");
		sb.append(serviceMode);
		sb.append(", counter=");
		sb.append(counter);
		sb.append(", subjectId=");
		sb.append(subjectId);
		sb.append(", subjectName=");
		sb.append(subjectName);
		sb.append(", address=");
		sb.append(address);
		sb.append(", cityCode=");
		sb.append(cityCode);
		sb.append(", cityName=");
		sb.append(cityName);
		sb.append(", districtCode=");
		sb.append(districtCode);
		sb.append(", districtName=");
		sb.append(districtName);
		sb.append(", wardCode=");
		sb.append(wardCode);
		sb.append(", wardName=");
		sb.append(wardName);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", contactTelNo=");
		sb.append(contactTelNo);
		sb.append(", contactEmail=");
		sb.append(contactEmail);
		sb.append(", note=");
		sb.append(note);
		sb.append(", submitDatetime=");
		sb.append(submitDatetime);
		sb.append(", receiveDatetime=");
		sb.append(receiveDatetime);
		sb.append(", receptionNo=");
		sb.append(receptionNo);
		sb.append(", estimateDatetime=");
		sb.append(estimateDatetime);
		sb.append(", finishDatetime=");
		sb.append(finishDatetime);
		sb.append(", dossierStatus=");
		sb.append(dossierStatus);
		sb.append(", dossierSource=");
		sb.append(dossierSource);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Dossier toEntityModel() {
		DossierImpl dossierImpl = new DossierImpl();

		dossierImpl.setDossierId(dossierId);
		dossierImpl.setCompanyId(companyId);
		dossierImpl.setGroupId(groupId);
		dossierImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dossierImpl.setCreateDate(null);
		}
		else {
			dossierImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dossierImpl.setModifiedDate(null);
		}
		else {
			dossierImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (uuid == null) {
			dossierImpl.setUuid(StringPool.BLANK);
		}
		else {
			dossierImpl.setUuid(uuid);
		}

		if (externalRefNo == null) {
			dossierImpl.setExternalRefNo(StringPool.BLANK);
		}
		else {
			dossierImpl.setExternalRefNo(externalRefNo);
		}

		if (externalRefUrl == null) {
			dossierImpl.setExternalRefUrl(StringPool.BLANK);
		}
		else {
			dossierImpl.setExternalRefUrl(externalRefUrl);
		}

		dossierImpl.setOwnerOrganizationId(ownerOrganizationId);
		dossierImpl.setServiceConfigId(serviceConfigId);
		dossierImpl.setServiceInfoId(serviceInfoId);

		if (serviceDomainIndex == null) {
			dossierImpl.setServiceDomainIndex(StringPool.BLANK);
		}
		else {
			dossierImpl.setServiceDomainIndex(serviceDomainIndex);
		}

		if (serviceAdministrationIndex == null) {
			dossierImpl.setServiceAdministrationIndex(StringPool.BLANK);
		}
		else {
			dossierImpl.setServiceAdministrationIndex(serviceAdministrationIndex);
		}

		dossierImpl.setDossierTemplateId(dossierTemplateId);

		if (govAgencyCode == null) {
			dossierImpl.setGovAgencyCode(StringPool.BLANK);
		}
		else {
			dossierImpl.setGovAgencyCode(govAgencyCode);
		}

		if (govAgencyName == null) {
			dossierImpl.setGovAgencyName(StringPool.BLANK);
		}
		else {
			dossierImpl.setGovAgencyName(govAgencyName);
		}

		dossierImpl.setGovAgencyOrganizationId(govAgencyOrganizationId);
		dossierImpl.setServiceMode(serviceMode);
		dossierImpl.setCounter(counter);

		if (subjectId == null) {
			dossierImpl.setSubjectId(StringPool.BLANK);
		}
		else {
			dossierImpl.setSubjectId(subjectId);
		}

		if (subjectName == null) {
			dossierImpl.setSubjectName(StringPool.BLANK);
		}
		else {
			dossierImpl.setSubjectName(subjectName);
		}

		if (address == null) {
			dossierImpl.setAddress(StringPool.BLANK);
		}
		else {
			dossierImpl.setAddress(address);
		}

		if (cityCode == null) {
			dossierImpl.setCityCode(StringPool.BLANK);
		}
		else {
			dossierImpl.setCityCode(cityCode);
		}

		if (cityName == null) {
			dossierImpl.setCityName(StringPool.BLANK);
		}
		else {
			dossierImpl.setCityName(cityName);
		}

		if (districtCode == null) {
			dossierImpl.setDistrictCode(StringPool.BLANK);
		}
		else {
			dossierImpl.setDistrictCode(districtCode);
		}

		if (districtName == null) {
			dossierImpl.setDistrictName(StringPool.BLANK);
		}
		else {
			dossierImpl.setDistrictName(districtName);
		}

		if (wardCode == null) {
			dossierImpl.setWardCode(StringPool.BLANK);
		}
		else {
			dossierImpl.setWardCode(wardCode);
		}

		if (wardName == null) {
			dossierImpl.setWardName(StringPool.BLANK);
		}
		else {
			dossierImpl.setWardName(wardName);
		}

		if (contactName == null) {
			dossierImpl.setContactName(StringPool.BLANK);
		}
		else {
			dossierImpl.setContactName(contactName);
		}

		if (contactTelNo == null) {
			dossierImpl.setContactTelNo(StringPool.BLANK);
		}
		else {
			dossierImpl.setContactTelNo(contactTelNo);
		}

		if (contactEmail == null) {
			dossierImpl.setContactEmail(StringPool.BLANK);
		}
		else {
			dossierImpl.setContactEmail(contactEmail);
		}

		if (note == null) {
			dossierImpl.setNote(StringPool.BLANK);
		}
		else {
			dossierImpl.setNote(note);
		}

		if (submitDatetime == Long.MIN_VALUE) {
			dossierImpl.setSubmitDatetime(null);
		}
		else {
			dossierImpl.setSubmitDatetime(new Date(submitDatetime));
		}

		if (receiveDatetime == Long.MIN_VALUE) {
			dossierImpl.setReceiveDatetime(null);
		}
		else {
			dossierImpl.setReceiveDatetime(new Date(receiveDatetime));
		}

		if (receptionNo == null) {
			dossierImpl.setReceptionNo(StringPool.BLANK);
		}
		else {
			dossierImpl.setReceptionNo(receptionNo);
		}

		if (estimateDatetime == Long.MIN_VALUE) {
			dossierImpl.setEstimateDatetime(null);
		}
		else {
			dossierImpl.setEstimateDatetime(new Date(estimateDatetime));
		}

		if (finishDatetime == Long.MIN_VALUE) {
			dossierImpl.setFinishDatetime(null);
		}
		else {
			dossierImpl.setFinishDatetime(new Date(finishDatetime));
		}

		dossierImpl.setDossierStatus(dossierStatus);
		dossierImpl.setDossierSource(dossierSource);

		dossierImpl.resetOriginalValues();

		return dossierImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dossierId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		uuid = objectInput.readUTF();
		externalRefNo = objectInput.readUTF();
		externalRefUrl = objectInput.readUTF();
		ownerOrganizationId = objectInput.readLong();
		serviceConfigId = objectInput.readLong();
		serviceInfoId = objectInput.readLong();
		serviceDomainIndex = objectInput.readUTF();
		serviceAdministrationIndex = objectInput.readUTF();
		dossierTemplateId = objectInput.readLong();
		govAgencyCode = objectInput.readUTF();
		govAgencyName = objectInput.readUTF();
		govAgencyOrganizationId = objectInput.readLong();
		serviceMode = objectInput.readInt();
		counter = objectInput.readInt();
		subjectId = objectInput.readUTF();
		subjectName = objectInput.readUTF();
		address = objectInput.readUTF();
		cityCode = objectInput.readUTF();
		cityName = objectInput.readUTF();
		districtCode = objectInput.readUTF();
		districtName = objectInput.readUTF();
		wardCode = objectInput.readUTF();
		wardName = objectInput.readUTF();
		contactName = objectInput.readUTF();
		contactTelNo = objectInput.readUTF();
		contactEmail = objectInput.readUTF();
		note = objectInput.readUTF();
		submitDatetime = objectInput.readLong();
		receiveDatetime = objectInput.readLong();
		receptionNo = objectInput.readUTF();
		estimateDatetime = objectInput.readLong();
		finishDatetime = objectInput.readLong();
		dossierStatus = objectInput.readInt();
		dossierSource = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dossierId);
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

		if (externalRefNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalRefNo);
		}

		if (externalRefUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalRefUrl);
		}

		objectOutput.writeLong(ownerOrganizationId);
		objectOutput.writeLong(serviceConfigId);
		objectOutput.writeLong(serviceInfoId);

		if (serviceDomainIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceDomainIndex);
		}

		if (serviceAdministrationIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceAdministrationIndex);
		}

		objectOutput.writeLong(dossierTemplateId);

		if (govAgencyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(govAgencyCode);
		}

		if (govAgencyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(govAgencyName);
		}

		objectOutput.writeLong(govAgencyOrganizationId);
		objectOutput.writeInt(serviceMode);
		objectOutput.writeInt(counter);

		if (subjectId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectId);
		}

		if (subjectName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subjectName);
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

		if (cityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cityName);
		}

		if (districtCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(districtCode);
		}

		if (districtName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(districtName);
		}

		if (wardCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wardCode);
		}

		if (wardName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(wardName);
		}

		if (contactName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactName);
		}

		if (contactTelNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactTelNo);
		}

		if (contactEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactEmail);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(submitDatetime);
		objectOutput.writeLong(receiveDatetime);

		if (receptionNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receptionNo);
		}

		objectOutput.writeLong(estimateDatetime);
		objectOutput.writeLong(finishDatetime);
		objectOutput.writeInt(dossierStatus);
		objectOutput.writeInt(dossierSource);
	}

	public long dossierId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String uuid;
	public String externalRefNo;
	public String externalRefUrl;
	public long ownerOrganizationId;
	public long serviceConfigId;
	public long serviceInfoId;
	public String serviceDomainIndex;
	public String serviceAdministrationIndex;
	public long dossierTemplateId;
	public String govAgencyCode;
	public String govAgencyName;
	public long govAgencyOrganizationId;
	public int serviceMode;
	public int counter;
	public String subjectId;
	public String subjectName;
	public String address;
	public String cityCode;
	public String cityName;
	public String districtCode;
	public String districtName;
	public String wardCode;
	public String wardName;
	public String contactName;
	public String contactTelNo;
	public String contactEmail;
	public String note;
	public long submitDatetime;
	public long receiveDatetime;
	public String receptionNo;
	public long estimateDatetime;
	public long finishDatetime;
	public int dossierStatus;
	public int dossierSource;
}