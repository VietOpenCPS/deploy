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

import org.opencps.dossiermgt.model.ServiceConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceConfig in entity cache.
 *
 * @author trungnt
 * @see ServiceConfig
 * @generated
 */
public class ServiceConfigCacheModel implements CacheModel<ServiceConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{serviceConfigId=");
		sb.append(serviceConfigId);
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
		sb.append(", serviceProcessId=");
		sb.append(serviceProcessId);
		sb.append(", domainCode=");
		sb.append(domainCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceConfig toEntityModel() {
		ServiceConfigImpl serviceConfigImpl = new ServiceConfigImpl();

		serviceConfigImpl.setServiceConfigId(serviceConfigId);
		serviceConfigImpl.setCompanyId(companyId);
		serviceConfigImpl.setGroupId(groupId);
		serviceConfigImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			serviceConfigImpl.setCreateDate(null);
		}
		else {
			serviceConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceConfigImpl.setModifiedDate(null);
		}
		else {
			serviceConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		serviceConfigImpl.setServiceInfoId(serviceInfoId);

		if (serviceDomainIndex == null) {
			serviceConfigImpl.setServiceDomainIndex(StringPool.BLANK);
		}
		else {
			serviceConfigImpl.setServiceDomainIndex(serviceDomainIndex);
		}

		if (serviceAdministrationIndex == null) {
			serviceConfigImpl.setServiceAdministrationIndex(StringPool.BLANK);
		}
		else {
			serviceConfigImpl.setServiceAdministrationIndex(serviceAdministrationIndex);
		}

		serviceConfigImpl.setDossierTemplateId(dossierTemplateId);

		if (govAgencyCode == null) {
			serviceConfigImpl.setGovAgencyCode(StringPool.BLANK);
		}
		else {
			serviceConfigImpl.setGovAgencyCode(govAgencyCode);
		}

		if (govAgencyName == null) {
			serviceConfigImpl.setGovAgencyName(StringPool.BLANK);
		}
		else {
			serviceConfigImpl.setGovAgencyName(govAgencyName);
		}

		serviceConfigImpl.setGovAgencyOrganizationId(govAgencyOrganizationId);
		serviceConfigImpl.setServiceMode(serviceMode);
		serviceConfigImpl.setServiceProcessId(serviceProcessId);

		if (domainCode == null) {
			serviceConfigImpl.setDomainCode(StringPool.BLANK);
		}
		else {
			serviceConfigImpl.setDomainCode(domainCode);
		}

		serviceConfigImpl.resetOriginalValues();

		return serviceConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceConfigId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		serviceInfoId = objectInput.readLong();
		serviceDomainIndex = objectInput.readUTF();
		serviceAdministrationIndex = objectInput.readUTF();
		dossierTemplateId = objectInput.readLong();
		govAgencyCode = objectInput.readUTF();
		govAgencyName = objectInput.readUTF();
		govAgencyOrganizationId = objectInput.readLong();
		serviceMode = objectInput.readInt();
		serviceProcessId = objectInput.readLong();
		domainCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(serviceConfigId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
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
		objectOutput.writeLong(serviceProcessId);

		if (domainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(domainCode);
		}
	}

	public long serviceConfigId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long serviceInfoId;
	public String serviceDomainIndex;
	public String serviceAdministrationIndex;
	public long dossierTemplateId;
	public String govAgencyCode;
	public String govAgencyName;
	public long govAgencyOrganizationId;
	public int serviceMode;
	public long serviceProcessId;
	public String domainCode;
}