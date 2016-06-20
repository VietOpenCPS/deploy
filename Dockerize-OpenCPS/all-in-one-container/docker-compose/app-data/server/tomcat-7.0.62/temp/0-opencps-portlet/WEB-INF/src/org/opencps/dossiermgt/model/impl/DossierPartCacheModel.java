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

import org.opencps.dossiermgt.model.DossierPart;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DossierPart in entity cache.
 *
 * @author trungnt
 * @see DossierPart
 * @generated
 */
public class DossierPartCacheModel implements CacheModel<DossierPart>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{dossierpartId=");
		sb.append(dossierpartId);
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
		sb.append(", dossierTemplateId=");
		sb.append(dossierTemplateId);
		sb.append(", partNo=");
		sb.append(partNo);
		sb.append(", partName=");
		sb.append(partName);
		sb.append(", partTip=");
		sb.append(partTip);
		sb.append(", partType=");
		sb.append(partType);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", sibling=");
		sb.append(sibling);
		sb.append(", treeIndex=");
		sb.append(treeIndex);
		sb.append(", formScript=");
		sb.append(formScript);
		sb.append(", formReport=");
		sb.append(formReport);
		sb.append(", sampleData=");
		sb.append(sampleData);
		sb.append(", required=");
		sb.append(required);
		sb.append(", templateFileNo=");
		sb.append(templateFileNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DossierPart toEntityModel() {
		DossierPartImpl dossierPartImpl = new DossierPartImpl();

		dossierPartImpl.setDossierpartId(dossierpartId);
		dossierPartImpl.setCompanyId(companyId);
		dossierPartImpl.setGroupId(groupId);
		dossierPartImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dossierPartImpl.setCreateDate(null);
		}
		else {
			dossierPartImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dossierPartImpl.setModifiedDate(null);
		}
		else {
			dossierPartImpl.setModifiedDate(new Date(modifiedDate));
		}

		dossierPartImpl.setDossierTemplateId(dossierTemplateId);

		if (partNo == null) {
			dossierPartImpl.setPartNo(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setPartNo(partNo);
		}

		if (partName == null) {
			dossierPartImpl.setPartName(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setPartName(partName);
		}

		if (partTip == null) {
			dossierPartImpl.setPartTip(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setPartTip(partTip);
		}

		dossierPartImpl.setPartType(partType);
		dossierPartImpl.setParentId(parentId);
		dossierPartImpl.setSibling(sibling);

		if (treeIndex == null) {
			dossierPartImpl.setTreeIndex(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setTreeIndex(treeIndex);
		}

		if (formScript == null) {
			dossierPartImpl.setFormScript(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setFormScript(formScript);
		}

		if (formReport == null) {
			dossierPartImpl.setFormReport(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setFormReport(formReport);
		}

		if (sampleData == null) {
			dossierPartImpl.setSampleData(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setSampleData(sampleData);
		}

		dossierPartImpl.setRequired(required);

		if (templateFileNo == null) {
			dossierPartImpl.setTemplateFileNo(StringPool.BLANK);
		}
		else {
			dossierPartImpl.setTemplateFileNo(templateFileNo);
		}

		dossierPartImpl.resetOriginalValues();

		return dossierPartImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dossierpartId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dossierTemplateId = objectInput.readLong();
		partNo = objectInput.readUTF();
		partName = objectInput.readUTF();
		partTip = objectInput.readUTF();
		partType = objectInput.readInt();
		parentId = objectInput.readLong();
		sibling = objectInput.readDouble();
		treeIndex = objectInput.readUTF();
		formScript = objectInput.readUTF();
		formReport = objectInput.readUTF();
		sampleData = objectInput.readUTF();
		required = objectInput.readBoolean();
		templateFileNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dossierpartId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(dossierTemplateId);

		if (partNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partNo);
		}

		if (partName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partName);
		}

		if (partTip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partTip);
		}

		objectOutput.writeInt(partType);
		objectOutput.writeLong(parentId);
		objectOutput.writeDouble(sibling);

		if (treeIndex == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(treeIndex);
		}

		if (formScript == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formScript);
		}

		if (formReport == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formReport);
		}

		if (sampleData == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sampleData);
		}

		objectOutput.writeBoolean(required);

		if (templateFileNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateFileNo);
		}
	}

	public long dossierpartId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long dossierTemplateId;
	public String partNo;
	public String partName;
	public String partTip;
	public int partType;
	public long parentId;
	public double sibling;
	public String treeIndex;
	public String formScript;
	public String formReport;
	public String sampleData;
	public boolean required;
	public String templateFileNo;
}