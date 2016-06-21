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

import org.opencps.processmgt.model.ProcessStep;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProcessStep in entity cache.
 *
 * @author khoavd
 * @see ProcessStep
 * @generated
 */
public class ProcessStepCacheModel implements CacheModel<ProcessStep>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{processStepId=");
		sb.append(processStepId);
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
		sb.append(", serviceProcessId=");
		sb.append(serviceProcessId);
		sb.append(", stepName=");
		sb.append(stepName);
		sb.append(", sequenceNo=");
		sb.append(sequenceNo);
		sb.append(", dossierStatus=");
		sb.append(dossierStatus);
		sb.append(", daysDuration=");
		sb.append(daysDuration);
		sb.append(", referenceDossierPartId=");
		sb.append(referenceDossierPartId);
		sb.append(", externalAppUrl=");
		sb.append(externalAppUrl);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProcessStep toEntityModel() {
		ProcessStepImpl processStepImpl = new ProcessStepImpl();

		processStepImpl.setProcessStepId(processStepId);
		processStepImpl.setCompanyId(companyId);
		processStepImpl.setGroupId(groupId);
		processStepImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			processStepImpl.setCreateDate(null);
		}
		else {
			processStepImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			processStepImpl.setModifiedDate(null);
		}
		else {
			processStepImpl.setModifiedDate(new Date(modifiedDate));
		}

		processStepImpl.setServiceProcessId(serviceProcessId);

		if (stepName == null) {
			processStepImpl.setStepName(StringPool.BLANK);
		}
		else {
			processStepImpl.setStepName(stepName);
		}

		processStepImpl.setSequenceNo(sequenceNo);

		if (dossierStatus == null) {
			processStepImpl.setDossierStatus(StringPool.BLANK);
		}
		else {
			processStepImpl.setDossierStatus(dossierStatus);
		}

		processStepImpl.setDaysDuration(daysDuration);
		processStepImpl.setReferenceDossierPartId(referenceDossierPartId);

		if (externalAppUrl == null) {
			processStepImpl.setExternalAppUrl(StringPool.BLANK);
		}
		else {
			processStepImpl.setExternalAppUrl(externalAppUrl);
		}

		processStepImpl.resetOriginalValues();

		return processStepImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		processStepId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		serviceProcessId = objectInput.readLong();
		stepName = objectInput.readUTF();
		sequenceNo = objectInput.readInt();
		dossierStatus = objectInput.readUTF();
		daysDuration = objectInput.readInt();
		referenceDossierPartId = objectInput.readLong();
		externalAppUrl = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(processStepId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(serviceProcessId);

		if (stepName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stepName);
		}

		objectOutput.writeInt(sequenceNo);

		if (dossierStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dossierStatus);
		}

		objectOutput.writeInt(daysDuration);
		objectOutput.writeLong(referenceDossierPartId);

		if (externalAppUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(externalAppUrl);
		}
	}

	public long processStepId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long serviceProcessId;
	public String stepName;
	public int sequenceNo;
	public String dossierStatus;
	public int daysDuration;
	public long referenceDossierPartId;
	public String externalAppUrl;
}