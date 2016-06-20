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

import org.opencps.accountmgt.service.CitizenLocalServiceUtil;
import org.opencps.accountmgt.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class CitizenClp extends BaseModelImpl<Citizen> implements Citizen {
	public CitizenClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Citizen.class;
	}

	@Override
	public String getModelClassName() {
		return Citizen.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _citizenId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCitizenId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _citizenId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("citizenId", getCitizenId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("fullName", getFullName());
		attributes.put("personalId", getPersonalId());
		attributes.put("gender", getGender());
		attributes.put("birthdate", getBirthdate());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("telNo", getTelNo());
		attributes.put("email", getEmail());
		attributes.put("attachFile", getAttachFile());
		attributes.put("mappingUserId", getMappingUserId());
		attributes.put("accountStatus", getAccountStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long citizenId = (Long)attributes.get("citizenId");

		if (citizenId != null) {
			setCitizenId(citizenId);
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

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String personalId = (String)attributes.get("personalId");

		if (personalId != null) {
			setPersonalId(personalId);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Date birthdate = (Date)attributes.get("birthdate");

		if (birthdate != null) {
			setBirthdate(birthdate);
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

		Long attachFile = (Long)attributes.get("attachFile");

		if (attachFile != null) {
			setAttachFile(attachFile);
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
	public long getCitizenId() {
		return _citizenId;
	}

	@Override
	public void setCitizenId(long citizenId) {
		_citizenId = citizenId;

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setCitizenId", long.class);

				method.invoke(_citizenRemoteModel, citizenId);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_citizenRemoteModel, companyId);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_citizenRemoteModel, groupId);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_citizenRemoteModel, userId);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_citizenRemoteModel, createDate);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_citizenRemoteModel, modifiedDate);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_citizenRemoteModel, uuid);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setFullName", String.class);

				method.invoke(_citizenRemoteModel, fullName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonalId() {
		return _personalId;
	}

	@Override
	public void setPersonalId(String personalId) {
		_personalId = personalId;

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonalId", String.class);

				method.invoke(_citizenRemoteModel, personalId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGender() {
		return _gender;
	}

	@Override
	public void setGender(int gender) {
		_gender = gender;

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", int.class);

				method.invoke(_citizenRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBirthdate() {
		return _birthdate;
	}

	@Override
	public void setBirthdate(Date birthdate) {
		_birthdate = birthdate;

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthdate", Date.class);

				method.invoke(_citizenRemoteModel, birthdate);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_citizenRemoteModel, address);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setCityCode", String.class);

				method.invoke(_citizenRemoteModel, cityCode);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setDistrictCode", String.class);

				method.invoke(_citizenRemoteModel, districtCode);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setWardCode", String.class);

				method.invoke(_citizenRemoteModel, wardCode);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setTelNo", String.class);

				method.invoke(_citizenRemoteModel, telNo);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_citizenRemoteModel, email);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachFile", long.class);

				method.invoke(_citizenRemoteModel, attachFile);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setMappingUserId", long.class);

				method.invoke(_citizenRemoteModel, mappingUserId);
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

		if (_citizenRemoteModel != null) {
			try {
				Class<?> clazz = _citizenRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountStatus", int.class);

				method.invoke(_citizenRemoteModel, accountStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCitizenRemoteModel() {
		return _citizenRemoteModel;
	}

	public void setCitizenRemoteModel(BaseModel<?> citizenRemoteModel) {
		_citizenRemoteModel = citizenRemoteModel;
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

		Class<?> remoteModelClass = _citizenRemoteModel.getClass();

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

		Object returnValue = method.invoke(_citizenRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CitizenLocalServiceUtil.addCitizen(this);
		}
		else {
			CitizenLocalServiceUtil.updateCitizen(this);
		}
	}

	@Override
	public Citizen toEscapedModel() {
		return (Citizen)ProxyUtil.newProxyInstance(Citizen.class.getClassLoader(),
			new Class[] { Citizen.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CitizenClp clone = new CitizenClp();

		clone.setCitizenId(getCitizenId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUuid(getUuid());
		clone.setFullName(getFullName());
		clone.setPersonalId(getPersonalId());
		clone.setGender(getGender());
		clone.setBirthdate(getBirthdate());
		clone.setAddress(getAddress());
		clone.setCityCode(getCityCode());
		clone.setDistrictCode(getDistrictCode());
		clone.setWardCode(getWardCode());
		clone.setTelNo(getTelNo());
		clone.setEmail(getEmail());
		clone.setAttachFile(getAttachFile());
		clone.setMappingUserId(getMappingUserId());
		clone.setAccountStatus(getAccountStatus());

		return clone;
	}

	@Override
	public int compareTo(Citizen citizen) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), citizen.getCreateDate());

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

		if (!(obj instanceof CitizenClp)) {
			return false;
		}

		CitizenClp citizen = (CitizenClp)obj;

		long primaryKey = citizen.getPrimaryKey();

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
		StringBundler sb = new StringBundler(41);

		sb.append("{citizenId=");
		sb.append(getCitizenId());
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
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", personalId=");
		sb.append(getPersonalId());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", birthdate=");
		sb.append(getBirthdate());
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
		sb.append(", attachFile=");
		sb.append(getAttachFile());
		sb.append(", mappingUserId=");
		sb.append(getMappingUserId());
		sb.append(", accountStatus=");
		sb.append(getAccountStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("org.opencps.accountmgt.model.Citizen");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>citizenId</column-name><column-value><![CDATA[");
		sb.append(getCitizenId());
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
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalId</column-name><column-value><![CDATA[");
		sb.append(getPersonalId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthdate</column-name><column-value><![CDATA[");
		sb.append(getBirthdate());
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
			"<column><column-name>attachFile</column-name><column-value><![CDATA[");
		sb.append(getAttachFile());
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

	private long _citizenId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _uuid;
	private String _fullName;
	private String _personalId;
	private int _gender;
	private Date _birthdate;
	private String _address;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _telNo;
	private String _email;
	private long _attachFile;
	private long _mappingUserId;
	private String _mappingUserUuid;
	private int _accountStatus;
	private BaseModel<?> _citizenRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.accountmgt.service.ClpSerializer.class;
}