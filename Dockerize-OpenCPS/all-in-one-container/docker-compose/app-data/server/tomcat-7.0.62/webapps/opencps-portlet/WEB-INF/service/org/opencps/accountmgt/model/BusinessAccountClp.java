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

package org.opencps.accountmgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.accountmgt.service.BusinessAccountLocalServiceUtil;
import org.opencps.accountmgt.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class BusinessAccountClp extends BaseModelImpl<BusinessAccount>
	implements BusinessAccount {
	public BusinessAccountClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusinessAccount.class;
	}

	@Override
	public String getModelClassName() {
		return BusinessAccount.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _businessAccountId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusinessAccountId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _businessAccountId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessAccountId", getBusinessAccountId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("businessId", getBusinessId());
		attributes.put("fullName", getFullName());
		attributes.put("workingRole", getWorkingRole());
		attributes.put("telNo", getTelNo());
		attributes.put("email", getEmail());
		attributes.put("mappingUserId", getMappingUserId());
		attributes.put("hasPermissions", getHasPermissions());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long businessAccountId = (Long)attributes.get("businessAccountId");

		if (businessAccountId != null) {
			setBusinessAccountId(businessAccountId);
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

		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String workingRole = (String)attributes.get("workingRole");

		if (workingRole != null) {
			setWorkingRole(workingRole);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long mappingUserId = (Long)attributes.get("mappingUserId");

		if (mappingUserId != null) {
			setMappingUserId(mappingUserId);
		}

		String hasPermissions = (String)attributes.get("hasPermissions");

		if (hasPermissions != null) {
			setHasPermissions(hasPermissions);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}
	}

	@Override
	public long getBusinessAccountId() {
		return _businessAccountId;
	}

	@Override
	public void setBusinessAccountId(long businessAccountId) {
		_businessAccountId = businessAccountId;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessAccountId",
						long.class);

				method.invoke(_businessAccountRemoteModel, businessAccountId);
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

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_businessAccountRemoteModel, companyId);
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

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_businessAccountRemoteModel, groupId);
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

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_businessAccountRemoteModel, userId);
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

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_businessAccountRemoteModel, createDate);
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

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_businessAccountRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBusinessId() {
		return _businessId;
	}

	@Override
	public void setBusinessId(long businessId) {
		_businessId = businessId;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessId", long.class);

				method.invoke(_businessAccountRemoteModel, businessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullName() {
		return _fullName;
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_businessAccountRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkingRole() {
		return _workingRole;
	}

	@Override
	public void setWorkingRole(String workingRole) {
		_workingRole = workingRole;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingRole", String.class);

				method.invoke(_businessAccountRemoteModel, workingRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTelNo() {
		return _telNo;
	}

	@Override
	public void setTelNo(String telNo) {
		_telNo = telNo;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setTelNo", String.class);

				method.invoke(_businessAccountRemoteModel, telNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_businessAccountRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMappingUserId() {
		return _mappingUserId;
	}

	@Override
	public void setMappingUserId(long mappingUserId) {
		_mappingUserId = mappingUserId;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setMappingUserId", long.class);

				method.invoke(_businessAccountRemoteModel, mappingUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMappingUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getMappingUserId(), "uuid",
			_mappingUserUuid);
	}

	@Override
	public void setMappingUserUuid(String mappingUserUuid) {
		_mappingUserUuid = mappingUserUuid;
	}

	@Override
	public String getHasPermissions() {
		return _hasPermissions;
	}

	@Override
	public void setHasPermissions(String hasPermissions) {
		_hasPermissions = hasPermissions;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setHasPermissions",
						String.class);

				method.invoke(_businessAccountRemoteModel, hasPermissions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAccountStatus() {
		return _accountStatus;
	}

	@Override
	public void setAccountStatus(int accountStatus) {
		_accountStatus = accountStatus;

		if (_businessAccountRemoteModel != null) {
			try {
				Class<?> clazz = _businessAccountRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountStatus", int.class);

				method.invoke(_businessAccountRemoteModel, accountStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusinessAccountRemoteModel() {
		return _businessAccountRemoteModel;
	}

	public void setBusinessAccountRemoteModel(
		BaseModel<?> businessAccountRemoteModel) {
		_businessAccountRemoteModel = businessAccountRemoteModel;
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

		Class<?> remoteModelClass = _businessAccountRemoteModel.getClass();

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

		Object returnValue = method.invoke(_businessAccountRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusinessAccountLocalServiceUtil.addBusinessAccount(this);
		}
		else {
			BusinessAccountLocalServiceUtil.updateBusinessAccount(this);
		}
	}

	@Override
	public BusinessAccount toEscapedModel() {
		return (BusinessAccount)ProxyUtil.newProxyInstance(BusinessAccount.class.getClassLoader(),
			new Class[] { BusinessAccount.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusinessAccountClp clone = new BusinessAccountClp();

		clone.setBusinessAccountId(getBusinessAccountId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setBusinessId(getBusinessId());
		clone.setFullName(getFullName());
		clone.setWorkingRole(getWorkingRole());
		clone.setTelNo(getTelNo());
		clone.setEmail(getEmail());
		clone.setMappingUserId(getMappingUserId());
		clone.setHasPermissions(getHasPermissions());
		clone.setAccountStatus(getAccountStatus());

		return clone;
	}

	@Override
	public int compareTo(BusinessAccount businessAccount) {
		int value = 0;

		value = getFullName().compareTo(businessAccount.getFullName());

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

		if (!(obj instanceof BusinessAccountClp)) {
			return false;
		}

		BusinessAccountClp businessAccount = (BusinessAccountClp)obj;

		long primaryKey = businessAccount.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{businessAccountId=");
		sb.append(getBusinessAccountId());
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
		sb.append(", businessId=");
		sb.append(getBusinessId());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", workingRole=");
		sb.append(getWorkingRole());
		sb.append(", telNo=");
		sb.append(getTelNo());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", mappingUserId=");
		sb.append(getMappingUserId());
		sb.append(", hasPermissions=");
		sb.append(getHasPermissions());
		sb.append(", accountStatus=");
		sb.append(getAccountStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("org.opencps.accountmgt.model.BusinessAccount");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>businessAccountId</column-name><column-value><![CDATA[");
		sb.append(getBusinessAccountId());
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
			"<column><column-name>businessId</column-name><column-value><![CDATA[");
		sb.append(getBusinessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingRole</column-name><column-value><![CDATA[");
		sb.append(getWorkingRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telNo</column-name><column-value><![CDATA[");
		sb.append(getTelNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingUserId</column-name><column-value><![CDATA[");
		sb.append(getMappingUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasPermissions</column-name><column-value><![CDATA[");
		sb.append(getHasPermissions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountStatus</column-name><column-value><![CDATA[");
		sb.append(getAccountStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _businessAccountId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _businessId;
	private String _fullName;
	private String _workingRole;
	private String _telNo;
	private String _email;
	private long _mappingUserId;
	private String _mappingUserUuid;
	private String _hasPermissions;
	private int _accountStatus;
	private BaseModel<?> _businessAccountRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.accountmgt.service.ClpSerializer.class;
}