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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.accountmgt.service.BusinessLocalServiceUtil;
import org.opencps.accountmgt.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class BusinessClp extends BaseModelImpl<Business> implements Business {
	public BusinessClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Business.class;
	}

	@Override
	public String getModelClassName() {
		return Business.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _businessId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusinessId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _businessId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("businessId", getBusinessId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("name", getName());
		attributes.put("enName", getEnName());
		attributes.put("shortName", getShortName());
		attributes.put("businessType", getBusinessType());
		attributes.put("idNumber", getIdNumber());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("telNo", getTelNo());
		attributes.put("email", getEmail());
		attributes.put("representativeName", getRepresentativeName());
		attributes.put("representativeRole", getRepresentativeRole());
		attributes.put("attachFile", getAttachFile());
		attributes.put("mappingOrganizationId", getMappingOrganizationId());
		attributes.put("mappingUserId", getMappingUserId());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long businessId = (Long)attributes.get("businessId");

		if (businessId != null) {
			setBusinessId(businessId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String enName = (String)attributes.get("enName");

		if (enName != null) {
			setEnName(enName);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String businessType = (String)attributes.get("businessType");

		if (businessType != null) {
			setBusinessType(businessType);
		}

		String idNumber = (String)attributes.get("idNumber");

		if (idNumber != null) {
			setIdNumber(idNumber);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String cityCode = (String)attributes.get("cityCode");

		if (cityCode != null) {
			setCityCode(cityCode);
		}

		String districtCode = (String)attributes.get("districtCode");

		if (districtCode != null) {
			setDistrictCode(districtCode);
		}

		String wardCode = (String)attributes.get("wardCode");

		if (wardCode != null) {
			setWardCode(wardCode);
		}

		String telNo = (String)attributes.get("telNo");

		if (telNo != null) {
			setTelNo(telNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String representativeName = (String)attributes.get("representativeName");

		if (representativeName != null) {
			setRepresentativeName(representativeName);
		}

		String representativeRole = (String)attributes.get("representativeRole");

		if (representativeRole != null) {
			setRepresentativeRole(representativeRole);
		}

		Long attachFile = (Long)attributes.get("attachFile");

		if (attachFile != null) {
			setAttachFile(attachFile);
		}

		Long mappingOrganizationId = (Long)attributes.get(
				"mappingOrganizationId");

		if (mappingOrganizationId != null) {
			setMappingOrganizationId(mappingOrganizationId);
		}

		Long mappingUserId = (Long)attributes.get("mappingUserId");

		if (mappingUserId != null) {
			setMappingUserId(mappingUserId);
		}

		Integer accountStatus = (Integer)attributes.get("accountStatus");

		if (accountStatus != null) {
			setAccountStatus(accountStatus);
		}
	}

	@Override
	public long getBusinessId() {
		return _businessId;
	}

	@Override
	public void setBusinessId(long businessId) {
		_businessId = businessId;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessId", long.class);

				method.invoke(_businessRemoteModel, businessId);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_businessRemoteModel, companyId);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_businessRemoteModel, groupId);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_businessRemoteModel, userId);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_businessRemoteModel, createDate);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_businessRemoteModel, modifiedDate);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_businessRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_businessRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEnName() {
		return _enName;
	}

	@Override
	public void setEnName(String enName) {
		_enName = enName;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setEnName", String.class);

				method.invoke(_businessRemoteModel, enName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortName() {
		return _shortName;
	}

	@Override
	public void setShortName(String shortName) {
		_shortName = shortName;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setShortName", String.class);

				method.invoke(_businessRemoteModel, shortName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessType() {
		return _businessType;
	}

	@Override
	public void setBusinessType(String businessType) {
		_businessType = businessType;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessType", String.class);

				method.invoke(_businessRemoteModel, businessType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdNumber() {
		return _idNumber;
	}

	@Override
	public void setIdNumber(String idNumber) {
		_idNumber = idNumber;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setIdNumber", String.class);

				method.invoke(_businessRemoteModel, idNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress() {
		return _address;
	}

	@Override
	public void setAddress(String address) {
		_address = address;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_businessRemoteModel, address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCityCode() {
		return _cityCode;
	}

	@Override
	public void setCityCode(String cityCode) {
		_cityCode = cityCode;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setCityCode", String.class);

				method.invoke(_businessRemoteModel, cityCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDistrictCode() {
		return _districtCode;
	}

	@Override
	public void setDistrictCode(String districtCode) {
		_districtCode = districtCode;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setDistrictCode", String.class);

				method.invoke(_businessRemoteModel, districtCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWardCode() {
		return _wardCode;
	}

	@Override
	public void setWardCode(String wardCode) {
		_wardCode = wardCode;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setWardCode", String.class);

				method.invoke(_businessRemoteModel, wardCode);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setTelNo", String.class);

				method.invoke(_businessRemoteModel, telNo);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_businessRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRepresentativeName() {
		return _representativeName;
	}

	@Override
	public void setRepresentativeName(String representativeName) {
		_representativeName = representativeName;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setRepresentativeName",
						String.class);

				method.invoke(_businessRemoteModel, representativeName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRepresentativeRole() {
		return _representativeRole;
	}

	@Override
	public void setRepresentativeRole(String representativeRole) {
		_representativeRole = representativeRole;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setRepresentativeRole",
						String.class);

				method.invoke(_businessRemoteModel, representativeRole);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttachFile() {
		return _attachFile;
	}

	@Override
	public void setAttachFile(long attachFile) {
		_attachFile = attachFile;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachFile", long.class);

				method.invoke(_businessRemoteModel, attachFile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMappingOrganizationId() {
		return _mappingOrganizationId;
	}

	@Override
	public void setMappingOrganizationId(long mappingOrganizationId) {
		_mappingOrganizationId = mappingOrganizationId;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setMappingOrganizationId",
						long.class);

				method.invoke(_businessRemoteModel, mappingOrganizationId);
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

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setMappingUserId", long.class);

				method.invoke(_businessRemoteModel, mappingUserId);
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
	public int getAccountStatus() {
		return _accountStatus;
	}

	@Override
	public void setAccountStatus(int accountStatus) {
		_accountStatus = accountStatus;

		if (_businessRemoteModel != null) {
			try {
				Class<?> clazz = _businessRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountStatus", int.class);

				method.invoke(_businessRemoteModel, accountStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBusinessRemoteModel() {
		return _businessRemoteModel;
	}

	public void setBusinessRemoteModel(BaseModel<?> businessRemoteModel) {
		_businessRemoteModel = businessRemoteModel;
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

		Class<?> remoteModelClass = _businessRemoteModel.getClass();

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

		Object returnValue = method.invoke(_businessRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusinessLocalServiceUtil.addBusiness(this);
		}
		else {
			BusinessLocalServiceUtil.updateBusiness(this);
		}
	}

	@Override
	public Business toEscapedModel() {
		return (Business)ProxyUtil.newProxyInstance(Business.class.getClassLoader(),
			new Class[] { Business.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusinessClp clone = new BusinessClp();

		clone.setBusinessId(getBusinessId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUuid(getUuid());
		clone.setName(getName());
		clone.setEnName(getEnName());
		clone.setShortName(getShortName());
		clone.setBusinessType(getBusinessType());
		clone.setIdNumber(getIdNumber());
		clone.setAddress(getAddress());
		clone.setCityCode(getCityCode());
		clone.setDistrictCode(getDistrictCode());
		clone.setWardCode(getWardCode());
		clone.setTelNo(getTelNo());
		clone.setEmail(getEmail());
		clone.setRepresentativeName(getRepresentativeName());
		clone.setRepresentativeRole(getRepresentativeRole());
		clone.setAttachFile(getAttachFile());
		clone.setMappingOrganizationId(getMappingOrganizationId());
		clone.setMappingUserId(getMappingUserId());
		clone.setAccountStatus(getAccountStatus());

		return clone;
	}

	@Override
	public int compareTo(Business business) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), business.getCreateDate());

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

		if (!(obj instanceof BusinessClp)) {
			return false;
		}

		BusinessClp business = (BusinessClp)obj;

		long primaryKey = business.getPrimaryKey();

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
		StringBundler sb = new StringBundler(49);

		sb.append("{businessId=");
		sb.append(getBusinessId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", enName=");
		sb.append(getEnName());
		sb.append(", shortName=");
		sb.append(getShortName());
		sb.append(", businessType=");
		sb.append(getBusinessType());
		sb.append(", idNumber=");
		sb.append(getIdNumber());
		sb.append(", address=");
		sb.append(getAddress());
		sb.append(", cityCode=");
		sb.append(getCityCode());
		sb.append(", districtCode=");
		sb.append(getDistrictCode());
		sb.append(", wardCode=");
		sb.append(getWardCode());
		sb.append(", telNo=");
		sb.append(getTelNo());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", representativeName=");
		sb.append(getRepresentativeName());
		sb.append(", representativeRole=");
		sb.append(getRepresentativeRole());
		sb.append(", attachFile=");
		sb.append(getAttachFile());
		sb.append(", mappingOrganizationId=");
		sb.append(getMappingOrganizationId());
		sb.append(", mappingUserId=");
		sb.append(getMappingUserId());
		sb.append(", accountStatus=");
		sb.append(getAccountStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("org.opencps.accountmgt.model.Business");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>businessId</column-name><column-value><![CDATA[");
		sb.append(getBusinessId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enName</column-name><column-value><![CDATA[");
		sb.append(getEnName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortName</column-name><column-value><![CDATA[");
		sb.append(getShortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessType</column-name><column-value><![CDATA[");
		sb.append(getBusinessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idNumber</column-name><column-value><![CDATA[");
		sb.append(getIdNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address</column-name><column-value><![CDATA[");
		sb.append(getAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cityCode</column-name><column-value><![CDATA[");
		sb.append(getCityCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>districtCode</column-name><column-value><![CDATA[");
		sb.append(getDistrictCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>wardCode</column-name><column-value><![CDATA[");
		sb.append(getWardCode());
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
			"<column><column-name>representativeName</column-name><column-value><![CDATA[");
		sb.append(getRepresentativeName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>representativeRole</column-name><column-value><![CDATA[");
		sb.append(getRepresentativeRole());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachFile</column-name><column-value><![CDATA[");
		sb.append(getAttachFile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getMappingOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingUserId</column-name><column-value><![CDATA[");
		sb.append(getMappingUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountStatus</column-name><column-value><![CDATA[");
		sb.append(getAccountStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _businessId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private String _name;
	private String _enName;
	private String _shortName;
	private String _businessType;
	private String _idNumber;
	private String _address;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _telNo;
	private String _email;
	private String _representativeName;
	private String _representativeRole;
	private long _attachFile;
	private long _mappingOrganizationId;
	private long _mappingUserId;
	private String _mappingUserUuid;
	private int _accountStatus;
	private BaseModel<?> _businessRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.accountmgt.service.ClpSerializer.class;
}