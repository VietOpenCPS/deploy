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

package org.opencps.usermgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.usermgt.service.ClpSerializer;
import org.opencps.usermgt.service.WorkingUnitLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class WorkingUnitClp extends BaseModelImpl<WorkingUnit>
	implements WorkingUnit {
	public WorkingUnitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WorkingUnit.class;
	}

	@Override
	public String getModelClassName() {
		return WorkingUnit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workingunitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkingunitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workingunitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workingunitId", getWorkingunitId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("enName", getEnName());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("managerWorkingUnitId", getManagerWorkingUnitId());
		attributes.put("parentWorkingUnitId", getParentWorkingUnitId());
		attributes.put("sibling", getSibling());
		attributes.put("treeIndex", getTreeIndex());
		attributes.put("address", getAddress());
		attributes.put("cityCode", getCityCode());
		attributes.put("districtCode", getDistrictCode());
		attributes.put("wardCode", getWardCode());
		attributes.put("telNo", getTelNo());
		attributes.put("faxNo", getFaxNo());
		attributes.put("email", getEmail());
		attributes.put("website", getWebsite());
		attributes.put("isEmployer", getIsEmployer());
		attributes.put("mappingOrganisationId", getMappingOrganisationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workingunitId = (Long)attributes.get("workingunitId");

		if (workingunitId != null) {
			setWorkingunitId(workingunitId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String enName = (String)attributes.get("enName");

		if (enName != null) {
			setEnName(enName);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		Long managerWorkingUnitId = (Long)attributes.get("managerWorkingUnitId");

		if (managerWorkingUnitId != null) {
			setManagerWorkingUnitId(managerWorkingUnitId);
		}

		Long parentWorkingUnitId = (Long)attributes.get("parentWorkingUnitId");

		if (parentWorkingUnitId != null) {
			setParentWorkingUnitId(parentWorkingUnitId);
		}

		Integer sibling = (Integer)attributes.get("sibling");

		if (sibling != null) {
			setSibling(sibling);
		}

		String treeIndex = (String)attributes.get("treeIndex");

		if (treeIndex != null) {
			setTreeIndex(treeIndex);
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

		String faxNo = (String)attributes.get("faxNo");

		if (faxNo != null) {
			setFaxNo(faxNo);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		Boolean isEmployer = (Boolean)attributes.get("isEmployer");

		if (isEmployer != null) {
			setIsEmployer(isEmployer);
		}

		Long mappingOrganisationId = (Long)attributes.get(
				"mappingOrganisationId");

		if (mappingOrganisationId != null) {
			setMappingOrganisationId(mappingOrganisationId);
		}
	}

	@Override
	public long getWorkingunitId() {
		return _workingunitId;
	}

	@Override
	public void setWorkingunitId(long workingunitId) {
		_workingunitId = workingunitId;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingunitId", long.class);

				method.invoke(_workingUnitRemoteModel, workingunitId);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_workingUnitRemoteModel, companyId);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_workingUnitRemoteModel, groupId);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_workingUnitRemoteModel, userId);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_workingUnitRemoteModel, createDate);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_workingUnitRemoteModel, modifiedDate);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_workingUnitRemoteModel, name);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setEnName", String.class);

				method.invoke(_workingUnitRemoteModel, enName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGovAgencyCode() {
		return _govAgencyCode;
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyCode", String.class);

				method.invoke(_workingUnitRemoteModel, govAgencyCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getManagerWorkingUnitId() {
		return _managerWorkingUnitId;
	}

	@Override
	public void setManagerWorkingUnitId(long managerWorkingUnitId) {
		_managerWorkingUnitId = managerWorkingUnitId;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setManagerWorkingUnitId",
						long.class);

				method.invoke(_workingUnitRemoteModel, managerWorkingUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentWorkingUnitId() {
		return _parentWorkingUnitId;
	}

	@Override
	public void setParentWorkingUnitId(long parentWorkingUnitId) {
		_parentWorkingUnitId = parentWorkingUnitId;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setParentWorkingUnitId",
						long.class);

				method.invoke(_workingUnitRemoteModel, parentWorkingUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSibling() {
		return _sibling;
	}

	@Override
	public void setSibling(int sibling) {
		_sibling = sibling;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setSibling", int.class);

				method.invoke(_workingUnitRemoteModel, sibling);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTreeIndex() {
		return _treeIndex;
	}

	@Override
	public void setTreeIndex(String treeIndex) {
		_treeIndex = treeIndex;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setTreeIndex", String.class);

				method.invoke(_workingUnitRemoteModel, treeIndex);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress", String.class);

				method.invoke(_workingUnitRemoteModel, address);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCityCode", String.class);

				method.invoke(_workingUnitRemoteModel, cityCode);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setDistrictCode", String.class);

				method.invoke(_workingUnitRemoteModel, districtCode);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setWardCode", String.class);

				method.invoke(_workingUnitRemoteModel, wardCode);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setTelNo", String.class);

				method.invoke(_workingUnitRemoteModel, telNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFaxNo() {
		return _faxNo;
	}

	@Override
	public void setFaxNo(String faxNo) {
		_faxNo = faxNo;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setFaxNo", String.class);

				method.invoke(_workingUnitRemoteModel, faxNo);
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

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_workingUnitRemoteModel, email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsite() {
		return _website;
	}

	@Override
	public void setWebsite(String website) {
		_website = website;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsite", String.class);

				method.invoke(_workingUnitRemoteModel, website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsEmployer() {
		return _isEmployer;
	}

	@Override
	public boolean isIsEmployer() {
		return _isEmployer;
	}

	@Override
	public void setIsEmployer(boolean isEmployer) {
		_isEmployer = isEmployer;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setIsEmployer", boolean.class);

				method.invoke(_workingUnitRemoteModel, isEmployer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMappingOrganisationId() {
		return _mappingOrganisationId;
	}

	@Override
	public void setMappingOrganisationId(long mappingOrganisationId) {
		_mappingOrganisationId = mappingOrganisationId;

		if (_workingUnitRemoteModel != null) {
			try {
				Class<?> clazz = _workingUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setMappingOrganisationId",
						long.class);

				method.invoke(_workingUnitRemoteModel, mappingOrganisationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkingUnitRemoteModel() {
		return _workingUnitRemoteModel;
	}

	public void setWorkingUnitRemoteModel(BaseModel<?> workingUnitRemoteModel) {
		_workingUnitRemoteModel = workingUnitRemoteModel;
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

		Class<?> remoteModelClass = _workingUnitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workingUnitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkingUnitLocalServiceUtil.addWorkingUnit(this);
		}
		else {
			WorkingUnitLocalServiceUtil.updateWorkingUnit(this);
		}
	}

	@Override
	public WorkingUnit toEscapedModel() {
		return (WorkingUnit)ProxyUtil.newProxyInstance(WorkingUnit.class.getClassLoader(),
			new Class[] { WorkingUnit.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkingUnitClp clone = new WorkingUnitClp();

		clone.setWorkingunitId(getWorkingunitId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setName(getName());
		clone.setEnName(getEnName());
		clone.setGovAgencyCode(getGovAgencyCode());
		clone.setManagerWorkingUnitId(getManagerWorkingUnitId());
		clone.setParentWorkingUnitId(getParentWorkingUnitId());
		clone.setSibling(getSibling());
		clone.setTreeIndex(getTreeIndex());
		clone.setAddress(getAddress());
		clone.setCityCode(getCityCode());
		clone.setDistrictCode(getDistrictCode());
		clone.setWardCode(getWardCode());
		clone.setTelNo(getTelNo());
		clone.setFaxNo(getFaxNo());
		clone.setEmail(getEmail());
		clone.setWebsite(getWebsite());
		clone.setIsEmployer(getIsEmployer());
		clone.setMappingOrganisationId(getMappingOrganisationId());

		return clone;
	}

	@Override
	public int compareTo(WorkingUnit workingUnit) {
		int value = 0;

		value = getName().compareTo(workingUnit.getName());

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

		if (!(obj instanceof WorkingUnitClp)) {
			return false;
		}

		WorkingUnitClp workingUnit = (WorkingUnitClp)obj;

		long primaryKey = workingUnit.getPrimaryKey();

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

		sb.append("{workingunitId=");
		sb.append(getWorkingunitId());
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
		sb.append(", name=");
		sb.append(getName());
		sb.append(", enName=");
		sb.append(getEnName());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", managerWorkingUnitId=");
		sb.append(getManagerWorkingUnitId());
		sb.append(", parentWorkingUnitId=");
		sb.append(getParentWorkingUnitId());
		sb.append(", sibling=");
		sb.append(getSibling());
		sb.append(", treeIndex=");
		sb.append(getTreeIndex());
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
		sb.append(", faxNo=");
		sb.append(getFaxNo());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", isEmployer=");
		sb.append(getIsEmployer());
		sb.append(", mappingOrganisationId=");
		sb.append(getMappingOrganisationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("org.opencps.usermgt.model.WorkingUnit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workingunitId</column-name><column-value><![CDATA[");
		sb.append(getWorkingunitId());
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
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>enName</column-name><column-value><![CDATA[");
		sb.append(getEnName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>managerWorkingUnitId</column-name><column-value><![CDATA[");
		sb.append(getManagerWorkingUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentWorkingUnitId</column-name><column-value><![CDATA[");
		sb.append(getParentWorkingUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sibling</column-name><column-value><![CDATA[");
		sb.append(getSibling());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>treeIndex</column-name><column-value><![CDATA[");
		sb.append(getTreeIndex());
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
			"<column><column-name>faxNo</column-name><column-value><![CDATA[");
		sb.append(getFaxNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isEmployer</column-name><column-value><![CDATA[");
		sb.append(getIsEmployer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingOrganisationId</column-name><column-value><![CDATA[");
		sb.append(getMappingOrganisationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _workingunitId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _enName;
	private String _govAgencyCode;
	private long _managerWorkingUnitId;
	private long _parentWorkingUnitId;
	private int _sibling;
	private String _treeIndex;
	private String _address;
	private String _cityCode;
	private String _districtCode;
	private String _wardCode;
	private String _telNo;
	private String _faxNo;
	private String _email;
	private String _website;
	private boolean _isEmployer;
	private long _mappingOrganisationId;
	private BaseModel<?> _workingUnitRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.usermgt.service.ClpSerializer.class;
}