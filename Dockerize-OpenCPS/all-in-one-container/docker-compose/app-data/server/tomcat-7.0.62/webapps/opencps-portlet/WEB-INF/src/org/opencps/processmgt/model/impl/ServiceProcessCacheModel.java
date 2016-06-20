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

package org.opencps.processmgt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.opencps.processmgt.model.ServiceProcess;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ServiceProcess in entity cache.
 *
 * @author khoavd
 * @see ServiceProcess
 * @generated
 */
public class ServiceProcessCacheModel implements CacheModel<ServiceProcess>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{serviceProcessId=");
		sb.append(serviceProcessId);
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
		sb.append(", processNo=");
		sb.append(processNo);
		sb.append(", processName=");
		sb.append(processName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dossierTemplateId=");
		sb.append(dossierTemplateId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ServiceProcess toEntityModel() {
		ServiceProcessImpl serviceProcessImpl = new ServiceProcessImpl();

		serviceProcessImpl.setServiceProcessId(serviceProcessId);
		serviceProcessImpl.setCompanyId(companyId);
		serviceProcessImpl.setGroupId(groupId);
		serviceProcessImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			serviceProcessImpl.setCreateDate(null);
		}
		else {
			serviceProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			serviceProcessImpl.setModifiedDate(null);
		}
		else {
			serviceProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (processNo == null) {
			serviceProcessImpl.setProcessNo(StringPool.BLANK);
		}
		else {
			serviceProcessImpl.setProcessNo(processNo);
		}

		if (processName == null) {
			serviceProcessImpl.setProcessName(StringPool.BLANK);
		}
		else {
			serviceProcessImpl.setProcessName(processName);
		}

		if (description == null) {
			serviceProcessImpl.setDescription(StringPool.BLANK);
		}
		else {
			serviceProcessImpl.setDescription(description);
		}

		serviceProcessImpl.setDossierTemplateId(dossierTemplateId);

		serviceProcessImpl.resetOriginalValues();

		return serviceProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		serviceProcessId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		processNo = objectInput.readUTF();
		processName = objectInput.readUTF();
		description = objectInput.readUTF();
		dossierTemplateId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(serviceProcessId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (processNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processNo);
		}

		if (processName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(processName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(dossierTemplateId);
	}

	public long serviceProcessId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String processNo;
	public String processName;
	public String description;
	public long dossierTemplateId;
}