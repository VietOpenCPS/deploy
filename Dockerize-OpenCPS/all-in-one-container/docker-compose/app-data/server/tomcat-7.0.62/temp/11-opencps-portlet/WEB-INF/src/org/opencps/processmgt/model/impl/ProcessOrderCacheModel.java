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

import org.opencps.processmgt.model.ProcessOrder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcessOrder in entity cache.
 *
 * @author khoavd
 * @see ProcessOrder
 * @generated
 */
public class ProcessOrderCacheModel implements CacheModel<ProcessOrder>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{processOrderId=");
		sb.append(processOrderId);
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
		sb.append(", dossierTemplateId=");
		sb.append(dossierTemplateId);
		sb.append(", govAgencyCode=");
		sb.append(govAgencyCode);
		sb.append(", govAgencyName=");
		sb.append(govAgencyName);
		sb.append(", govAgencyOrganizationId=");
		sb.append(govAgencyOrganizationId);
		sb.append(", serviceProcessId=");
		sb.append(serviceProcessId);
		sb.append(", dossierId=");
		sb.append(dossierId);
		sb.append(", fileGroupId=");
		sb.append(fileGroupId);
		sb.append(", processStepId=");
		sb.append(processStepId);
		sb.append(", actionUserId=");
		sb.append(actionUserId);
		sb.append(", actionDatetime=");
		sb.append(actionDatetime);
		sb.append(", actionNote=");
		sb.append(actionNote);
		sb.append(", assignToUserId=");
		sb.append(assignToUserId);
		sb.append(", processWorkflowId=");
		sb.append(processWorkflowId);
		sb.append(", dossierStatus=");
		sb.append(dossierStatus);
		sb.append(", errorInfo=");
		sb.append(errorInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcessOrder toEntityModel() {
		ProcessOrderImpl processOrderImpl = new ProcessOrderImpl();

		processOrderImpl.setProcessOrderId(processOrderId);
		processOrderImpl.setCompanyId(companyId);
		processOrderImpl.setGroupId(groupId);
		processOrderImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			processOrderImpl.setCreateDate(null);
		}
		else {
			processOrderImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			processOrderImpl.setModifiedDate(null);
		}
		else {
			processOrderImpl.setModifiedDate(new Date(modifiedDate));
		}

		processOrderImpl.setServiceInfoId(serviceInfoId);
		processOrderImpl.setDossierTemplateId(dossierTemplateId);

		if (govAgencyCode == null) {
			processOrderImpl.setGovAgencyCode(StringPool.BLANK);
		}
		else {
			processOrderImpl.setGovAgencyCode(govAgencyCode);
		}

		if (govAgencyName == null) {
			processOrderImpl.setGovAgencyName(StringPool.BLANK);
		}
		else {
			processOrderImpl.setGovAgencyName(govAgencyName);
		}

		processOrderImpl.setGovAgencyOrganizationId(govAgencyOrganizationId);
		processOrderImpl.setServiceProcessId(serviceProcessId);
		processOrderImpl.setDossierId(dossierId);
		processOrderImpl.setFileGroupId(fileGroupId);
		processOrderImpl.setProcessStepId(processStepId);
		processOrderImpl.setActionUserId(actionUserId);

		if (actionDatetime == Long.MIN_VALUE) {
			processOrderImpl.setActionDatetime(null);
		}
		else {
			processOrderImpl.setActionDatetime(new Date(actionDatetime));
		}

		if (actionNote == null) {
			processOrderImpl.setActionNote(StringPool.BLANK);
		}
		else {
			processOrderImpl.setActionNote(actionNote);
		}

		processOrderImpl.setAssignToUserId(assignToUserId);
		processOrderImpl.setProcessWorkflowId(processWorkflowId);
		processOrderImpl.setDossierStatus(dossierStatus);

		if (errorInfo == null) {
			processOrderImpl.setErrorInfo(StringPool.BLANK);
		}
		else {
			processOrderImpl.setErrorInfo(errorInfo);
		}

		processOrderImpl.resetOriginalValues();

		return processOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		processOrderId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		serviceInfoId = objectInput.readLong();
		dossierTemplateId = objectInput.readLong();
		govAgencyCode = objectInput.readUTF();
		govAgencyName = objectInput.readUTF();
		govAgencyOrganizationId = objectInput.readLong();
		serviceProcessId = objectInput.readLong();
		dossierId = objectInput.readLong();
		fileGroupId = objectInput.readLong();
		processStepId = objectInput.readLong();
		actionUserId = objectInput.readLong();
		actionDatetime = objectInput.readLong();
		actionNote = objectInput.readUTF();
		assignToUserId = objectInput.readLong();
		processWorkflowId = objectInput.readLong();
		dossierStatus = objectInput.readInt();
		errorInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(processOrderId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(serviceInfoId);
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
		objectOutput.writeLong(serviceProcessId);
		objectOutput.writeLong(dossierId);
		objectOutput.writeLong(fileGroupId);
		objectOutput.writeLong(processStepId);
		objectOutput.writeLong(actionUserId);
		objectOutput.writeLong(actionDatetime);

		if (actionNote == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionNote);
		}

		objectOutput.writeLong(assignToUserId);
		objectOutput.writeLong(processWorkflowId);
		objectOutput.writeInt(dossierStatus);

		if (errorInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorInfo);
		}
	}

	public long processOrderId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long serviceInfoId;
	public long dossierTemplateId;
	public String govAgencyCode;
	public String govAgencyName;
	public long govAgencyOrganizationId;
	public long serviceProcessId;
	public long dossierId;
	public long fileGroupId;
	public long processStepId;
	public long actionUserId;
	public long actionDatetime;
	public String actionNote;
	public long assignToUserId;
	public long processWorkflowId;
	public int dossierStatus;
	public String errorInfo;
}