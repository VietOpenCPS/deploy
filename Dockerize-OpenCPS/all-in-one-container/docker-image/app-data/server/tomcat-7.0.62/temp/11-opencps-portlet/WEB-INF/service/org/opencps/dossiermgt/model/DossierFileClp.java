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

package org.opencps.dossiermgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.dossiermgt.service.ClpSerializer;
import org.opencps.dossiermgt.service.DossierFileLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author trungnt
 */
public class DossierFileClp extends BaseModelImpl<DossierFile>
	implements DossierFile {
	public DossierFileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DossierFile.class;
	}

	@Override
	public String getModelClassName() {
		return DossierFile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dossierFileId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierFileId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierFileId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierFileId", getDossierFileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("uuid", getUuid());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("templateFileNo", getTemplateFileNo());
		attributes.put("groupFileId", getGroupFileId());
		attributes.put("ownerUserId", getOwnerUserId());
		attributes.put("ownerOrganizationId", getOwnerOrganizationId());
		attributes.put("displayName", getDisplayName());
		attributes.put("formData", getFormData());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("dossierFileMark", getDossierFileMark());
		attributes.put("dossierFileType", getDossierFileType());
		attributes.put("dossierFileNo", getDossierFileNo());
		attributes.put("dossierFileDate", getDossierFileDate());
		attributes.put("removed", getRemoved());
		attributes.put("original", getOriginal());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierFileId = (Long)attributes.get("dossierFileId");

		if (dossierFileId != null) {
			setDossierFileId(dossierFileId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		String templateFileNo = (String)attributes.get("templateFileNo");

		if (templateFileNo != null) {
			setTemplateFileNo(templateFileNo);
		}

		Long groupFileId = (Long)attributes.get("groupFileId");

		if (groupFileId != null) {
			setGroupFileId(groupFileId);
		}

		Long ownerUserId = (Long)attributes.get("ownerUserId");

		if (ownerUserId != null) {
			setOwnerUserId(ownerUserId);
		}

		Long ownerOrganizationId = (Long)attributes.get("ownerOrganizationId");

		if (ownerOrganizationId != null) {
			setOwnerOrganizationId(ownerOrganizationId);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String formData = (String)attributes.get("formData");

		if (formData != null) {
			setFormData(formData);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Integer dossierFileMark = (Integer)attributes.get("dossierFileMark");

		if (dossierFileMark != null) {
			setDossierFileMark(dossierFileMark);
		}

		Integer dossierFileType = (Integer)attributes.get("dossierFileType");

		if (dossierFileType != null) {
			setDossierFileType(dossierFileType);
		}

		String dossierFileNo = (String)attributes.get("dossierFileNo");

		if (dossierFileNo != null) {
			setDossierFileNo(dossierFileNo);
		}

		Date dossierFileDate = (Date)attributes.get("dossierFileDate");

		if (dossierFileDate != null) {
			setDossierFileDate(dossierFileDate);
		}

		Integer removed = (Integer)attributes.get("removed");

		if (removed != null) {
			setRemoved(removed);
		}

		Integer original = (Integer)attributes.get("original");

		if (original != null) {
			setOriginal(original);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	@Override
	public long getDossierFileId() {
		return _dossierFileId;
	}

	@Override
	public void setDossierFileId(long dossierFileId) {
		_dossierFileId = dossierFileId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierFileId", long.class);

				method.invoke(_dossierFileRemoteModel, dossierFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dossierFileRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dossierFileRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dossierFileRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dossierFileRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dossierFileRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_dossierId = dossierId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierId", long.class);

				method.invoke(_dossierFileRemoteModel, dossierId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_dossierFileRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDossierPartId() {
		return _dossierPartId;
	}

	@Override
	public void setDossierPartId(long dossierPartId) {
		_dossierPartId = dossierPartId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierPartId", long.class);

				method.invoke(_dossierFileRemoteModel, dossierPartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateFileNo() {
		return _templateFileNo;
	}

	@Override
	public void setTemplateFileNo(String templateFileNo) {
		_templateFileNo = templateFileNo;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateFileNo",
						String.class);

				method.invoke(_dossierFileRemoteModel, templateFileNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupFileId() {
		return _groupFileId;
	}

	@Override
	public void setGroupFileId(long groupFileId) {
		_groupFileId = groupFileId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupFileId", long.class);

				method.invoke(_dossierFileRemoteModel, groupFileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOwnerUserId() {
		return _ownerUserId;
	}

	@Override
	public void setOwnerUserId(long ownerUserId) {
		_ownerUserId = ownerUserId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerUserId", long.class);

				method.invoke(_dossierFileRemoteModel, ownerUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOwnerUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getOwnerUserId(), "uuid", _ownerUserUuid);
	}

	@Override
	public void setOwnerUserUuid(String ownerUserUuid) {
		_ownerUserUuid = ownerUserUuid;
	}

	@Override
	public long getOwnerOrganizationId() {
		return _ownerOrganizationId;
	}

	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_ownerOrganizationId = ownerOrganizationId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setOwnerOrganizationId",
						long.class);

				method.invoke(_dossierFileRemoteModel, ownerOrganizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisplayName() {
		return _displayName;
	}

	@Override
	public void setDisplayName(String displayName) {
		_displayName = displayName;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayName", String.class);

				method.invoke(_dossierFileRemoteModel, displayName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormData() {
		return _formData;
	}

	@Override
	public void setFormData(String formData) {
		_formData = formData;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFormData", String.class);

				method.invoke(_dossierFileRemoteModel, formData);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_dossierFileRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDossierFileMark() {
		return _dossierFileMark;
	}

	@Override
	public void setDossierFileMark(int dossierFileMark) {
		_dossierFileMark = dossierFileMark;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierFileMark", int.class);

				method.invoke(_dossierFileRemoteModel, dossierFileMark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDossierFileType() {
		return _dossierFileType;
	}

	@Override
	public void setDossierFileType(int dossierFileType) {
		_dossierFileType = dossierFileType;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierFileType", int.class);

				method.invoke(_dossierFileRemoteModel, dossierFileType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDossierFileNo() {
		return _dossierFileNo;
	}

	@Override
	public void setDossierFileNo(String dossierFileNo) {
		_dossierFileNo = dossierFileNo;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierFileNo", String.class);

				method.invoke(_dossierFileRemoteModel, dossierFileNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDossierFileDate() {
		return _dossierFileDate;
	}

	@Override
	public void setDossierFileDate(Date dossierFileDate) {
		_dossierFileDate = dossierFileDate;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierFileDate", Date.class);

				method.invoke(_dossierFileRemoteModel, dossierFileDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRemoved() {
		return _removed;
	}

	@Override
	public void setRemoved(int removed) {
		_removed = removed;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setRemoved", int.class);

				method.invoke(_dossierFileRemoteModel, removed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getOriginal() {
		return _original;
	}

	@Override
	public void setOriginal(int original) {
		_original = original;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setOriginal", int.class);

				method.invoke(_dossierFileRemoteModel, original);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSyncStatus() {
		return _syncStatus;
	}

	@Override
	public void setSyncStatus(int syncStatus) {
		_syncStatus = syncStatus;

		if (_dossierFileRemoteModel != null) {
			try {
				Class<?> clazz = _dossierFileRemoteModel.getClass();

				Method method = clazz.getMethod("setSyncStatus", int.class);

				method.invoke(_dossierFileRemoteModel, syncStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDossierFileRemoteModel() {
		return _dossierFileRemoteModel;
	}

	public void setDossierFileRemoteModel(BaseModel<?> dossierFileRemoteModel) {
		_dossierFileRemoteModel = dossierFileRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _dossierFileRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_dossierFileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DossierFileLocalServiceUtil.addDossierFile(this);
		}
		else {
			DossierFileLocalServiceUtil.updateDossierFile(this);
		}
	}

	@Override
	public DossierFile toEscapedModel() {
		return (DossierFile)ProxyUtil.newProxyInstance(DossierFile.class.getClassLoader(),
			new Class[] { DossierFile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DossierFileClp clone = new DossierFileClp();

		clone.setDossierFileId(getDossierFileId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDossierId(getDossierId());
		clone.setUuid(getUuid());
		clone.setDossierPartId(getDossierPartId());
		clone.setTemplateFileNo(getTemplateFileNo());
		clone.setGroupFileId(getGroupFileId());
		clone.setOwnerUserId(getOwnerUserId());
		clone.setOwnerOrganizationId(getOwnerOrganizationId());
		clone.setDisplayName(getDisplayName());
		clone.setFormData(getFormData());
		clone.setFileEntryId(getFileEntryId());
		clone.setDossierFileMark(getDossierFileMark());
		clone.setDossierFileType(getDossierFileType());
		clone.setDossierFileNo(getDossierFileNo());
		clone.setDossierFileDate(getDossierFileDate());
		clone.setRemoved(getRemoved());
		clone.setOriginal(getOriginal());
		clone.setSyncStatus(getSyncStatus());

		return clone;
	}

	@Override
	public int compareTo(DossierFile dossierFile) {
		long primaryKey = dossierFile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierFileClp)) {
			return false;
		}

		DossierFileClp dossierFile = (DossierFileClp)obj;

		long primaryKey = dossierFile.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{dossierFileId=");
		sb.append(getDossierFileId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append(", templateFileNo=");
		sb.append(getTemplateFileNo());
		sb.append(", groupFileId=");
		sb.append(getGroupFileId());
		sb.append(", ownerUserId=");
		sb.append(getOwnerUserId());
		sb.append(", ownerOrganizationId=");
		sb.append(getOwnerOrganizationId());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", formData=");
		sb.append(getFormData());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", dossierFileMark=");
		sb.append(getDossierFileMark());
		sb.append(", dossierFileType=");
		sb.append(getDossierFileType());
		sb.append(", dossierFileNo=");
		sb.append(getDossierFileNo());
		sb.append(", dossierFileDate=");
		sb.append(getDossierFileDate());
		sb.append(", removed=");
		sb.append(getRemoved());
		sb.append(", original=");
		sb.append(getOriginal());
		sb.append(", syncStatus=");
		sb.append(getSyncStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DossierFile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dossierFileId</column-name><column-value><![CDATA[");
		sb.append(getDossierFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateFileNo</column-name><column-value><![CDATA[");
		sb.append(getTemplateFileNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupFileId</column-name><column-value><![CDATA[");
		sb.append(getGroupFileId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerUserId</column-name><column-value><![CDATA[");
		sb.append(getOwnerUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ownerOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getOwnerOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formData</column-name><column-value><![CDATA[");
		sb.append(getFormData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierFileMark</column-name><column-value><![CDATA[");
		sb.append(getDossierFileMark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierFileType</column-name><column-value><![CDATA[");
		sb.append(getDossierFileType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierFileNo</column-name><column-value><![CDATA[");
		sb.append(getDossierFileNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierFileDate</column-name><column-value><![CDATA[");
		sb.append(getDossierFileDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>removed</column-name><column-value><![CDATA[");
		sb.append(getRemoved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>original</column-name><column-value><![CDATA[");
		sb.append(getOriginal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncStatus</column-name><column-value><![CDATA[");
		sb.append(getSyncStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dossierFileId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierId;
	private String _uuid;
	private long _dossierPartId;
	private String _templateFileNo;
	private long _groupFileId;
	private long _ownerUserId;
	private String _ownerUserUuid;
	private long _ownerOrganizationId;
	private String _displayName;
	private String _formData;
	private long _fileEntryId;
	private int _dossierFileMark;
	private int _dossierFileType;
	private String _dossierFileNo;
	private Date _dossierFileDate;
	private int _removed;
	private int _original;
	private int _syncStatus;
	private BaseModel<?> _dossierFileRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.dossiermgt.service.ClpSerializer.class;
}