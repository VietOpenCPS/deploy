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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.dossiermgt.service.ClpSerializer;
import org.opencps.dossiermgt.service.DossierStatusLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author trungnt
 */
public class DossierStatusClp extends BaseModelImpl<DossierStatus>
	implements DossierStatus {
	public DossierStatusClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DossierStatus.class;
	}

	@Override
	public String getModelClassName() {
		return DossierStatus.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dossierStatusId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierStatusId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierStatusId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierStatusId", getDossierStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("fileGroupId", getFileGroupId());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("actionInfo", getActionInfo());
		attributes.put("messageInfo", getMessageInfo());
		attributes.put("updateDatetime", getUpdateDatetime());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierStatusId = (Long)attributes.get("dossierStatusId");

		if (dossierStatusId != null) {
			setDossierStatusId(dossierStatusId);
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

		Long fileGroupId = (Long)attributes.get("fileGroupId");

		if (fileGroupId != null) {
			setFileGroupId(fileGroupId);
		}

		Integer dossierStatus = (Integer)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		String actionInfo = (String)attributes.get("actionInfo");

		if (actionInfo != null) {
			setActionInfo(actionInfo);
		}

		String messageInfo = (String)attributes.get("messageInfo");

		if (messageInfo != null) {
			setMessageInfo(messageInfo);
		}

		Date updateDatetime = (Date)attributes.get("updateDatetime");

		if (updateDatetime != null) {
			setUpdateDatetime(updateDatetime);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	@Override
	public long getDossierStatusId() {
		return _dossierStatusId;
	}

	@Override
	public void setDossierStatusId(long dossierStatusId) {
		_dossierStatusId = dossierStatusId;

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierStatusId", long.class);

				method.invoke(_dossierStatusRemoteModel, dossierStatusId);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dossierStatusRemoteModel, companyId);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dossierStatusRemoteModel, groupId);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dossierStatusRemoteModel, userId);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dossierStatusRemoteModel, createDate);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dossierStatusRemoteModel, modifiedDate);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierId", long.class);

				method.invoke(_dossierStatusRemoteModel, dossierId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileGroupId() {
		return _fileGroupId;
	}

	@Override
	public void setFileGroupId(long fileGroupId) {
		_fileGroupId = fileGroupId;

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setFileGroupId", long.class);

				method.invoke(_dossierStatusRemoteModel, fileGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDossierStatus() {
		return _dossierStatus;
	}

	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierStatus", int.class);

				method.invoke(_dossierStatusRemoteModel, dossierStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionInfo() {
		return _actionInfo;
	}

	@Override
	public void setActionInfo(String actionInfo) {
		_actionInfo = actionInfo;

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setActionInfo", String.class);

				method.invoke(_dossierStatusRemoteModel, actionInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMessageInfo() {
		return _messageInfo;
	}

	@Override
	public void setMessageInfo(String messageInfo) {
		_messageInfo = messageInfo;

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setMessageInfo", String.class);

				method.invoke(_dossierStatusRemoteModel, messageInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdateDatetime() {
		return _updateDatetime;
	}

	@Override
	public void setUpdateDatetime(Date updateDatetime) {
		_updateDatetime = updateDatetime;

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateDatetime", Date.class);

				method.invoke(_dossierStatusRemoteModel, updateDatetime);
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

		if (_dossierStatusRemoteModel != null) {
			try {
				Class<?> clazz = _dossierStatusRemoteModel.getClass();

				Method method = clazz.getMethod("setSyncStatus", int.class);

				method.invoke(_dossierStatusRemoteModel, syncStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDossierStatusRemoteModel() {
		return _dossierStatusRemoteModel;
	}

	public void setDossierStatusRemoteModel(
		BaseModel<?> dossierStatusRemoteModel) {
		_dossierStatusRemoteModel = dossierStatusRemoteModel;
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

		Class<?> remoteModelClass = _dossierStatusRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dossierStatusRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DossierStatusLocalServiceUtil.addDossierStatus(this);
		}
		else {
			DossierStatusLocalServiceUtil.updateDossierStatus(this);
		}
	}

	@Override
	public DossierStatus toEscapedModel() {
		return (DossierStatus)ProxyUtil.newProxyInstance(DossierStatus.class.getClassLoader(),
			new Class[] { DossierStatus.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DossierStatusClp clone = new DossierStatusClp();

		clone.setDossierStatusId(getDossierStatusId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDossierId(getDossierId());
		clone.setFileGroupId(getFileGroupId());
		clone.setDossierStatus(getDossierStatus());
		clone.setActionInfo(getActionInfo());
		clone.setMessageInfo(getMessageInfo());
		clone.setUpdateDatetime(getUpdateDatetime());
		clone.setSyncStatus(getSyncStatus());

		return clone;
	}

	@Override
	public int compareTo(DossierStatus dossierStatus) {
		int value = 0;

		value = DateUtil.compareTo(getModifiedDate(),
				dossierStatus.getModifiedDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierStatusClp)) {
			return false;
		}

		DossierStatusClp dossierStatus = (DossierStatusClp)obj;

		long primaryKey = dossierStatus.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{dossierStatusId=");
		sb.append(getDossierStatusId());
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
		sb.append(", fileGroupId=");
		sb.append(getFileGroupId());
		sb.append(", dossierStatus=");
		sb.append(getDossierStatus());
		sb.append(", actionInfo=");
		sb.append(getActionInfo());
		sb.append(", messageInfo=");
		sb.append(getMessageInfo());
		sb.append(", updateDatetime=");
		sb.append(getUpdateDatetime());
		sb.append(", syncStatus=");
		sb.append(getSyncStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DossierStatus");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dossierStatusId</column-name><column-value><![CDATA[");
		sb.append(getDossierStatusId());
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
			"<column><column-name>fileGroupId</column-name><column-value><![CDATA[");
		sb.append(getFileGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionInfo</column-name><column-value><![CDATA[");
		sb.append(getActionInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>messageInfo</column-name><column-value><![CDATA[");
		sb.append(getMessageInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateDatetime</column-name><column-value><![CDATA[");
		sb.append(getUpdateDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>syncStatus</column-name><column-value><![CDATA[");
		sb.append(getSyncStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dossierStatusId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierId;
	private long _fileGroupId;
	private int _dossierStatus;
	private String _actionInfo;
	private String _messageInfo;
	private Date _updateDatetime;
	private int _syncStatus;
	private BaseModel<?> _dossierStatusRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.dossiermgt.service.ClpSerializer.class;
}