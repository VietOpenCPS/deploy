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

import org.opencps.dossiermgt.model.DossierTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DossierTemplate in entity cache.
 *
 * @author trungnt
 * @see DossierTemplate
 * @generated
 */
public class DossierTemplateCacheModel implements CacheModel<DossierTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{dossierTemplateId=");
		sb.append(dossierTemplateId);
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
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", templateNo=");
		sb.append(templateNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DossierTemplate toEntityModel() {
		DossierTemplateImpl dossierTemplateImpl = new DossierTemplateImpl();

		dossierTemplateImpl.setDossierTemplateId(dossierTemplateId);
		dossierTemplateImpl.setCompanyId(companyId);
		dossierTemplateImpl.setGroupId(groupId);
		dossierTemplateImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			dossierTemplateImpl.setCreateDate(null);
		}
		else {
			dossierTemplateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			dossierTemplateImpl.setModifiedDate(null);
		}
		else {
			dossierTemplateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (templateName == null) {
			dossierTemplateImpl.setTemplateName(StringPool.BLANK);
		}
		else {
			dossierTemplateImpl.setTemplateName(templateName);
		}

		if (description == null) {
			dossierTemplateImpl.setDescription(StringPool.BLANK);
		}
		else {
			dossierTemplateImpl.setDescription(description);
		}

		if (templateNo == null) {
			dossierTemplateImpl.setTemplateNo(StringPool.BLANK);
		}
		else {
			dossierTemplateImpl.setTemplateNo(templateNo);
		}

		dossierTemplateImpl.resetOriginalValues();

		return dossierTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		dossierTemplateId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		templateName = objectInput.readUTF();
		description = objectInput.readUTF();
		templateNo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(dossierTemplateId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (templateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (templateNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateNo);
		}
	}

	public long dossierTemplateId;
	public long companyId;
	public long groupId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String templateName;
	public String description;
	public String templateNo;
}