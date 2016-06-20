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

package org.opencps.datamgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.datamgt.service.ClpSerializer;
import org.opencps.datamgt.service.DictVersionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class DictVersionClp extends BaseModelImpl<DictVersion>
	implements DictVersion {
	public DictVersionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DictVersion.class;
	}

	@Override
	public String getModelClassName() {
		return DictVersion.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dictVersionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDictVersionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dictVersionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictVersionId", getDictVersionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("version", getVersion());
		attributes.put("description", getDescription());
		attributes.put("validatedFrom", getValidatedFrom());
		attributes.put("validatedTo", getValidatedTo());
		attributes.put("issueStatus", getIssueStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictVersionId = (Long)attributes.get("dictVersionId");

		if (dictVersionId != null) {
			setDictVersionId(dictVersionId);
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

		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date validatedFrom = (Date)attributes.get("validatedFrom");

		if (validatedFrom != null) {
			setValidatedFrom(validatedFrom);
		}

		Date validatedTo = (Date)attributes.get("validatedTo");

		if (validatedTo != null) {
			setValidatedTo(validatedTo);
		}

		Integer issueStatus = (Integer)attributes.get("issueStatus");

		if (issueStatus != null) {
			setIssueStatus(issueStatus);
		}
	}

	@Override
	public long getDictVersionId() {
		return _dictVersionId;
	}

	@Override
	public void setDictVersionId(long dictVersionId) {
		_dictVersionId = dictVersionId;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setDictVersionId", long.class);

				method.invoke(_dictVersionRemoteModel, dictVersionId);
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

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dictVersionRemoteModel, companyId);
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

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dictVersionRemoteModel, groupId);
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

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dictVersionRemoteModel, userId);
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

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dictVersionRemoteModel, createDate);
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

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dictVersionRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDictCollectionId() {
		return _dictCollectionId;
	}

	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictCollectionId = dictCollectionId;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setDictCollectionId",
						long.class);

				method.invoke(_dictVersionRemoteModel, dictCollectionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_dictVersionRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_dictVersionRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getValidatedFrom() {
		return _validatedFrom;
	}

	@Override
	public void setValidatedFrom(Date validatedFrom) {
		_validatedFrom = validatedFrom;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setValidatedFrom", Date.class);

				method.invoke(_dictVersionRemoteModel, validatedFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getValidatedTo() {
		return _validatedTo;
	}

	@Override
	public void setValidatedTo(Date validatedTo) {
		_validatedTo = validatedTo;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setValidatedTo", Date.class);

				method.invoke(_dictVersionRemoteModel, validatedTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getIssueStatus() {
		return _issueStatus;
	}

	@Override
	public void setIssueStatus(int issueStatus) {
		_issueStatus = issueStatus;

		if (_dictVersionRemoteModel != null) {
			try {
				Class<?> clazz = _dictVersionRemoteModel.getClass();

				Method method = clazz.getMethod("setIssueStatus", int.class);

				method.invoke(_dictVersionRemoteModel, issueStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDictVersionRemoteModel() {
		return _dictVersionRemoteModel;
	}

	public void setDictVersionRemoteModel(BaseModel<?> dictVersionRemoteModel) {
		_dictVersionRemoteModel = dictVersionRemoteModel;
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

		Class<?> remoteModelClass = _dictVersionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dictVersionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DictVersionLocalServiceUtil.addDictVersion(this);
		}
		else {
			DictVersionLocalServiceUtil.updateDictVersion(this);
		}
	}

	@Override
	public DictVersion toEscapedModel() {
		return (DictVersion)ProxyUtil.newProxyInstance(DictVersion.class.getClassLoader(),
			new Class[] { DictVersion.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DictVersionClp clone = new DictVersionClp();

		clone.setDictVersionId(getDictVersionId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDictCollectionId(getDictCollectionId());
		clone.setVersion(getVersion());
		clone.setDescription(getDescription());
		clone.setValidatedFrom(getValidatedFrom());
		clone.setValidatedTo(getValidatedTo());
		clone.setIssueStatus(getIssueStatus());

		return clone;
	}

	@Override
	public int compareTo(DictVersion dictVersion) {
		long primaryKey = dictVersion.getPrimaryKey();

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

		if (!(obj instanceof DictVersionClp)) {
			return false;
		}

		DictVersionClp dictVersion = (DictVersionClp)obj;

		long primaryKey = dictVersion.getPrimaryKey();

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

		sb.append("{dictVersionId=");
		sb.append(getDictVersionId());
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
		sb.append(", dictCollectionId=");
		sb.append(getDictCollectionId());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", validatedFrom=");
		sb.append(getValidatedFrom());
		sb.append(", validatedTo=");
		sb.append(getValidatedTo());
		sb.append(", issueStatus=");
		sb.append(getIssueStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.opencps.datamgt.model.DictVersion");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dictVersionId</column-name><column-value><![CDATA[");
		sb.append(getDictVersionId());
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
			"<column><column-name>dictCollectionId</column-name><column-value><![CDATA[");
		sb.append(getDictCollectionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validatedFrom</column-name><column-value><![CDATA[");
		sb.append(getValidatedFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validatedTo</column-name><column-value><![CDATA[");
		sb.append(getValidatedTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueStatus</column-name><column-value><![CDATA[");
		sb.append(getIssueStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dictVersionId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dictCollectionId;
	private String _version;
	private String _description;
	private Date _validatedFrom;
	private Date _validatedTo;
	private int _issueStatus;
	private BaseModel<?> _dictVersionRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.datamgt.service.ClpSerializer.class;
}