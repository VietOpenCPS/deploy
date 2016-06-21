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
import org.opencps.dossiermgt.service.FileGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author trungnt
 */
public class FileGroupClp extends BaseModelImpl<FileGroup> implements FileGroup {
	public FileGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FileGroup.class;
	}

	@Override
	public String getModelClassName() {
		return FileGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _fileGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFileGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileGroupId", getFileGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("dossierId", getDossierId());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("displayName", getDisplayName());
		attributes.put("removed", getRemoved());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileGroupId = (Long)attributes.get("fileGroupId");

		if (fileGroupId != null) {
			setFileGroupId(fileGroupId);
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

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		Integer removed = (Integer)attributes.get("removed");

		if (removed != null) {
			setRemoved(removed);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	@Override
	public long getFileGroupId() {
		return _fileGroupId;
	}

	@Override
	public void setFileGroupId(long fileGroupId) {
		_fileGroupId = fileGroupId;

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setFileGroupId", long.class);

				method.invoke(_fileGroupRemoteModel, fileGroupId);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_fileGroupRemoteModel, companyId);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_fileGroupRemoteModel, groupId);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_fileGroupRemoteModel, userId);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_fileGroupRemoteModel, createDate);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_fileGroupRemoteModel, modifiedDate);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_fileGroupRemoteModel, uuid);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierId", long.class);

				method.invoke(_fileGroupRemoteModel, dossierId);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierPartId", long.class);

				method.invoke(_fileGroupRemoteModel, dossierPartId);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayName", String.class);

				method.invoke(_fileGroupRemoteModel, displayName);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setRemoved", int.class);

				method.invoke(_fileGroupRemoteModel, removed);
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

		if (_fileGroupRemoteModel != null) {
			try {
				Class<?> clazz = _fileGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setSyncStatus", int.class);

				method.invoke(_fileGroupRemoteModel, syncStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFileGroupRemoteModel() {
		return _fileGroupRemoteModel;
	}

	public void setFileGroupRemoteModel(BaseModel<?> fileGroupRemoteModel) {
		_fileGroupRemoteModel = fileGroupRemoteModel;
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

		Class<?> remoteModelClass = _fileGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_fileGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FileGroupLocalServiceUtil.addFileGroup(this);
		}
		else {
			FileGroupLocalServiceUtil.updateFileGroup(this);
		}
	}

	@Override
	public FileGroup toEscapedModel() {
		return (FileGroup)ProxyUtil.newProxyInstance(FileGroup.class.getClassLoader(),
			new Class[] { FileGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FileGroupClp clone = new FileGroupClp();

		clone.setFileGroupId(getFileGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUuid(getUuid());
		clone.setDossierId(getDossierId());
		clone.setDossierPartId(getDossierPartId());
		clone.setDisplayName(getDisplayName());
		clone.setRemoved(getRemoved());
		clone.setSyncStatus(getSyncStatus());

		return clone;
	}

	@Override
	public int compareTo(FileGroup fileGroup) {
		long primaryKey = fileGroup.getPrimaryKey();

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

		if (!(obj instanceof FileGroupClp)) {
			return false;
		}

		FileGroupClp fileGroup = (FileGroupClp)obj;

		long primaryKey = fileGroup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{fileGroupId=");
		sb.append(getFileGroupId());
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
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append(", displayName=");
		sb.append(getDisplayName());
		sb.append(", removed=");
		sb.append(getRemoved());
		sb.append(", syncStatus=");
		sb.append(getSyncStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.FileGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>fileGroupId</column-name><column-value><![CDATA[");
		sb.append(getFileGroupId());
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
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayName</column-name><column-value><![CDATA[");
		sb.append(getDisplayName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>removed</column-name><column-value><![CDATA[");
		sb.append(getRemoved());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncStatus</column-name><column-value><![CDATA[");
		sb.append(getSyncStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _fileGroupId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private long _dossierId;
	private long _dossierPartId;
	private String _displayName;
	private int _removed;
	private int _syncStatus;
	private BaseModel<?> _fileGroupRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.dossiermgt.service.ClpSerializer.class;
}