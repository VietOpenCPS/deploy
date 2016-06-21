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

package org.opencps.servicemgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.servicemgt.model.ServiceInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceInfo in entity cache.
 *
 * @author khoavd
 * @see ServiceInfo
 * @generated
 */
public class ServiceInfoCacheModel implements CacheModel<ServiceInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", serviceinfoId=");
		sb.append(serviceinfoId);
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
		sb.append(", serviceNo=");
		sb.append(serviceNo);
		sb.append(", serviceName=");
		sb.append(serviceName);
		sb.append(", shortName=");
		sb.append(shortName);
		sb.append(", serviceProcess=");
		sb.append(serviceProcess);
		sb.append(", serviceMethod=");
		sb.append(serviceMethod);
		sb.append(", serviceDossier=");
		sb.append(serviceDossier);
		sb.append(", serviceCondition=");
		sb.append(serviceCondition);
		sb.append(", serviceDuration=");
		sb.append(serviceDuration);
		sb.append(", serviceActors=");
		sb.append(serviceActors);
		sb.append(", serviceResults=");
		sb.append(serviceResults);
		sb.append(", serviceRecords=");
		sb.append(serviceRecords);
		sb.append(", serviceFee=");
		sb.append(serviceFee);
		sb.append(", serviceInstructions=");
		sb.append(serviceInstructions);
		sb.append(", administrationCode=");
		sb.append(administrationCode);
		sb.append(", administrationIndex=");
		sb.append(administrationIndex);
		sb.append(", domainCode=");
		sb.append(domainCode);
		sb.append(", domainIndex=");
		sb.append(domainIndex);
		sb.append(", activeStatus=");
		sb.append(activeStatus);
		sb.append(", hasTemplateFiles=");
		sb.append(hasTemplateFiles);
		sb.append(", onlineUrl=");
		sb.append(onlineUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceInfo toEntityModel() {
		ServiceInfoImpl serviceInfoImpl = new ServiceInfoImpl();

		if (uuid == null) {
			serviceInfoImpl.setUuid(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setUuid(uuid);
		}

		serviceInfoImpl.setServiceinfoId(serviceinfoId);
		serviceInfoImpl.setCompanyId(companyId);
		serviceInfoImpl.setGroupId(groupId);
		serviceInfoImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			serviceInfoImpl.setCreateDate(null);
		}
		else {
			serviceInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceInfoImpl.setModifiedDate(null);
		}
		else {
			serviceInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (serviceNo == null) {
			serviceInfoImpl.setServiceNo(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceNo(serviceNo);
		}

		if (serviceName == null) {
			serviceInfoImpl.setServiceName(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceName(serviceName);
		}

		if (shortName == null) {
			serviceInfoImpl.setShortName(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setShortName(shortName);
		}

		if (serviceProcess == null) {
			serviceInfoImpl.setServiceProcess(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceProcess(serviceProcess);
		}

		if (serviceMethod == null) {
			serviceInfoImpl.setServiceMethod(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceMethod(serviceMethod);
		}

		if (serviceDossier == null) {
			serviceInfoImpl.setServiceDossier(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceDossier(serviceDossier);
		}

		if (serviceCondition == null) {
			serviceInfoImpl.setServiceCondition(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceCondition(serviceCondition);
		}

		if (serviceDuration == null) {
			serviceInfoImpl.setServiceDuration(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceDuration(serviceDuration);
		}

		if (serviceActors == null) {
			serviceInfoImpl.setServiceActors(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceActors(serviceActors);
		}

		if (serviceResults == null) {
			serviceInfoImpl.setServiceResults(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceResults(serviceResults);
		}

		if (serviceRecords == null) {
			serviceInfoImpl.setServiceRecords(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceRecords(serviceRecords);
		}

		if (serviceFee == null) {
			serviceInfoImpl.setServiceFee(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceFee(serviceFee);
		}

		if (serviceInstructions == null) {
			serviceInfoImpl.setServiceInstructions(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setServiceInstructions(serviceInstructions);
		}

		if (administrationCode == null) {
			serviceInfoImpl.setAdministrationCode(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setAdministrationCode(administrationCode);
		}

		if (administrationIndex == null) {
			serviceInfoImpl.setAdministrationIndex(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setAdministrationIndex(administrationIndex);
		}

		if (domainCode == null) {
			serviceInfoImpl.setDomainCode(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setDomainCode(domainCode);
		}

		if (domainIndex == null) {
			serviceInfoImpl.setDomainIndex(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setDomainIndex(domainIndex);
		}

		serviceInfoImpl.setActiveStatus(activeStatus);
		serviceInfoImpl.setHasTemplateFiles(hasTemplateFiles);

		if (onlineUrl == null) {
			serviceInfoImpl.setOnlineUrl(StringPool.BLANK);
		}
		else {
			serviceInfoImpl.setOnlineUrl(onlineUrl);
		}

		serviceInfoImpl.resetOriginalValues();

		return serviceInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		serviceinfoId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		serviceNo = objectInput.readUTF();
		serviceName = objectInput.readUTF();
		shortName = objectInput.readUTF();
		serviceProcess = objectInput.readUTF();
		serviceMethod = objectInput.readUTF();
		serviceDossier = objectInput.readUTF();
		serviceCondition = objectInput.readUTF();
		serviceDuration = objectInput.readUTF();
		serviceActors = objectInput.readUTF();
		serviceResults = objectInput.readUTF();
		serviceRecords = objectInput.readUTF();
		serviceFee = objectInput.readUTF();
		serviceInstructions = objectInput.readUTF();
		administrationCode = objectInput.readUTF();
		administrationIndex = objectInput.readUTF();
		domainCode = objectInput.readUTF();
		domainIndex = objectInput.readUTF();
		activeStatus = objectInput.readInt();
		hasTemplateFiles = objectInput.readInt();
		onlineUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(serviceinfoId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (serviceNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceNo);
		}

		if (serviceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceName);
		}

		if (shortName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortName);
		}

		if (serviceProcess == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceProcess);
		}

		if (serviceMethod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceMethod);
		}

		if (serviceDossier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceDossier);
		}

		if (serviceCondition == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceCondition);
		}

		if (serviceDuration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceDuration);
		}

		if (serviceActors == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceActors);
		}

		if (serviceResults == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceResults);
		}

		if (serviceRecords == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceRecords);
		}

		if (serviceFee == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceFee);
		}

		if (serviceInstructions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceInstructions);
		}

		if (administrationCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(administrationCode);
		}

		if (administrationIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(administrationIndex);
		}

		if (domainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(domainCode);
		}

		if (domainIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(domainIndex);
		}

		objectOutput.writeInt(activeStatus);
		objectOutput.writeInt(hasTemplateFiles);

		if (onlineUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(onlineUrl);
		}
	}

	public String uuid;
	public long serviceinfoId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String serviceNo;
	public String serviceName;
	public String shortName;
	public String serviceProcess;
	public String serviceMethod;
	public String serviceDossier;
	public String serviceCondition;
	public String serviceDuration;
	public String serviceActors;
	public String serviceResults;
	public String serviceRecords;
	public String serviceFee;
	public String serviceInstructions;
	public String administrationCode;
	public String administrationIndex;
	public String domainCode;
	public String domainIndex;
	public int activeStatus;
	public int hasTemplateFiles;
	public String onlineUrl;
}