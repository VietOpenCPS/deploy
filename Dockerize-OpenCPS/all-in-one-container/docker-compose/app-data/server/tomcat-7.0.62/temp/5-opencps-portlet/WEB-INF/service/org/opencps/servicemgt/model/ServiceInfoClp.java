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

package org.opencps.servicemgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.servicemgt.service.ClpSerializer;
import org.opencps.servicemgt.service.ServiceInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ServiceInfoClp extends BaseModelImpl<ServiceInfo>
	implements ServiceInfo {
	public ServiceInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceInfo.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _serviceinfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setServiceinfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _serviceinfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("serviceinfoId", getServiceinfoId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceNo", getServiceNo());
		attributes.put("serviceName", getServiceName());
		attributes.put("shortName", getShortName());
		attributes.put("serviceProcess", getServiceProcess());
		attributes.put("serviceMethod", getServiceMethod());
		attributes.put("serviceDossier", getServiceDossier());
		attributes.put("serviceCondition", getServiceCondition());
		attributes.put("serviceDuration", getServiceDuration());
		attributes.put("serviceActors", getServiceActors());
		attributes.put("serviceResults", getServiceResults());
		attributes.put("serviceRecords", getServiceRecords());
		attributes.put("serviceFee", getServiceFee());
		attributes.put("serviceInstructions", getServiceInstructions());
		attributes.put("administrationCode", getAdministrationCode());
		attributes.put("administrationIndex", getAdministrationIndex());
		attributes.put("domainCode", getDomainCode());
		attributes.put("domainIndex", getDomainIndex());
		attributes.put("activeStatus", getActiveStatus());
		attributes.put("hasTemplateFiles", getHasTemplateFiles());
		attributes.put("onlineUrl", getOnlineUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
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

		String serviceNo = (String)attributes.get("serviceNo");

		if (serviceNo != null) {
			setServiceNo(serviceNo);
		}

		String serviceName = (String)attributes.get("serviceName");

		if (serviceName != null) {
			setServiceName(serviceName);
		}

		String shortName = (String)attributes.get("shortName");

		if (shortName != null) {
			setShortName(shortName);
		}

		String serviceProcess = (String)attributes.get("serviceProcess");

		if (serviceProcess != null) {
			setServiceProcess(serviceProcess);
		}

		String serviceMethod = (String)attributes.get("serviceMethod");

		if (serviceMethod != null) {
			setServiceMethod(serviceMethod);
		}

		String serviceDossier = (String)attributes.get("serviceDossier");

		if (serviceDossier != null) {
			setServiceDossier(serviceDossier);
		}

		String serviceCondition = (String)attributes.get("serviceCondition");

		if (serviceCondition != null) {
			setServiceCondition(serviceCondition);
		}

		String serviceDuration = (String)attributes.get("serviceDuration");

		if (serviceDuration != null) {
			setServiceDuration(serviceDuration);
		}

		String serviceActors = (String)attributes.get("serviceActors");

		if (serviceActors != null) {
			setServiceActors(serviceActors);
		}

		String serviceResults = (String)attributes.get("serviceResults");

		if (serviceResults != null) {
			setServiceResults(serviceResults);
		}

		String serviceRecords = (String)attributes.get("serviceRecords");

		if (serviceRecords != null) {
			setServiceRecords(serviceRecords);
		}

		String serviceFee = (String)attributes.get("serviceFee");

		if (serviceFee != null) {
			setServiceFee(serviceFee);
		}

		String serviceInstructions = (String)attributes.get(
				"serviceInstructions");

		if (serviceInstructions != null) {
			setServiceInstructions(serviceInstructions);
		}

		String administrationCode = (String)attributes.get("administrationCode");

		if (administrationCode != null) {
			setAdministrationCode(administrationCode);
		}

		String administrationIndex = (String)attributes.get(
				"administrationIndex");

		if (administrationIndex != null) {
			setAdministrationIndex(administrationIndex);
		}

		String domainCode = (String)attributes.get("domainCode");

		if (domainCode != null) {
			setDomainCode(domainCode);
		}

		String domainIndex = (String)attributes.get("domainIndex");

		if (domainIndex != null) {
			setDomainIndex(domainIndex);
		}

		Integer activeStatus = (Integer)attributes.get("activeStatus");

		if (activeStatus != null) {
			setActiveStatus(activeStatus);
		}

		Integer hasTemplateFiles = (Integer)attributes.get("hasTemplateFiles");

		if (hasTemplateFiles != null) {
			setHasTemplateFiles(hasTemplateFiles);
		}

		String onlineUrl = (String)attributes.get("onlineUrl");

		if (onlineUrl != null) {
			setOnlineUrl(onlineUrl);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_serviceInfoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceinfoId", long.class);

				method.invoke(_serviceInfoRemoteModel, serviceinfoId);
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

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_serviceInfoRemoteModel, companyId);
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

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_serviceInfoRemoteModel, groupId);
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

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_serviceInfoRemoteModel, userId);
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

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_serviceInfoRemoteModel, createDate);
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

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_serviceInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceNo() {
		return _serviceNo;
	}

	@Override
	public void setServiceNo(String serviceNo) {
		_serviceNo = serviceNo;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceNo", String.class);

				method.invoke(_serviceInfoRemoteModel, serviceNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceName() {
		return _serviceName;
	}

	@Override
	public void setServiceName(String serviceName) {
		_serviceName = serviceName;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceName", String.class);

				method.invoke(_serviceInfoRemoteModel, serviceName);
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

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setShortName", String.class);

				method.invoke(_serviceInfoRemoteModel, shortName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceProcess() {
		return _serviceProcess;
	}

	@Override
	public void setServiceProcess(String serviceProcess) {
		_serviceProcess = serviceProcess;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceProcess",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceProcess);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceMethod() {
		return _serviceMethod;
	}

	@Override
	public void setServiceMethod(String serviceMethod) {
		_serviceMethod = serviceMethod;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceMethod", String.class);

				method.invoke(_serviceInfoRemoteModel, serviceMethod);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceDossier() {
		return _serviceDossier;
	}

	@Override
	public void setServiceDossier(String serviceDossier) {
		_serviceDossier = serviceDossier;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceDossier",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceDossier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceCondition() {
		return _serviceCondition;
	}

	@Override
	public void setServiceCondition(String serviceCondition) {
		_serviceCondition = serviceCondition;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceCondition",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceCondition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceDuration() {
		return _serviceDuration;
	}

	@Override
	public void setServiceDuration(String serviceDuration) {
		_serviceDuration = serviceDuration;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceDuration",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceActors() {
		return _serviceActors;
	}

	@Override
	public void setServiceActors(String serviceActors) {
		_serviceActors = serviceActors;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceActors", String.class);

				method.invoke(_serviceInfoRemoteModel, serviceActors);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceResults() {
		return _serviceResults;
	}

	@Override
	public void setServiceResults(String serviceResults) {
		_serviceResults = serviceResults;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceResults",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceResults);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceRecords() {
		return _serviceRecords;
	}

	@Override
	public void setServiceRecords(String serviceRecords) {
		_serviceRecords = serviceRecords;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceRecords",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceRecords);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceFee() {
		return _serviceFee;
	}

	@Override
	public void setServiceFee(String serviceFee) {
		_serviceFee = serviceFee;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceFee", String.class);

				method.invoke(_serviceInfoRemoteModel, serviceFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServiceInstructions() {
		return _serviceInstructions;
	}

	@Override
	public void setServiceInstructions(String serviceInstructions) {
		_serviceInstructions = serviceInstructions;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceInstructions",
						String.class);

				method.invoke(_serviceInfoRemoteModel, serviceInstructions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdministrationCode() {
		return _administrationCode;
	}

	@Override
	public void setAdministrationCode(String administrationCode) {
		_administrationCode = administrationCode;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAdministrationCode",
						String.class);

				method.invoke(_serviceInfoRemoteModel, administrationCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdministrationIndex() {
		return _administrationIndex;
	}

	@Override
	public void setAdministrationIndex(String administrationIndex) {
		_administrationIndex = administrationIndex;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAdministrationIndex",
						String.class);

				method.invoke(_serviceInfoRemoteModel, administrationIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDomainCode() {
		return _domainCode;
	}

	@Override
	public void setDomainCode(String domainCode) {
		_domainCode = domainCode;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDomainCode", String.class);

				method.invoke(_serviceInfoRemoteModel, domainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDomainIndex() {
		return _domainIndex;
	}

	@Override
	public void setDomainIndex(String domainIndex) {
		_domainIndex = domainIndex;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDomainIndex", String.class);

				method.invoke(_serviceInfoRemoteModel, domainIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getActiveStatus() {
		return _activeStatus;
	}

	@Override
	public void setActiveStatus(int activeStatus) {
		_activeStatus = activeStatus;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveStatus", int.class);

				method.invoke(_serviceInfoRemoteModel, activeStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getHasTemplateFiles() {
		return _hasTemplateFiles;
	}

	@Override
	public void setHasTemplateFiles(int hasTemplateFiles) {
		_hasTemplateFiles = hasTemplateFiles;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setHasTemplateFiles", int.class);

				method.invoke(_serviceInfoRemoteModel, hasTemplateFiles);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOnlineUrl() {
		return _onlineUrl;
	}

	@Override
	public void setOnlineUrl(String onlineUrl) {
		_onlineUrl = onlineUrl;

		if (_serviceInfoRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setOnlineUrl", String.class);

				method.invoke(_serviceInfoRemoteModel, onlineUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				ServiceInfo.class.getName()));
	}

	public BaseModel<?> getServiceInfoRemoteModel() {
		return _serviceInfoRemoteModel;
	}

	public void setServiceInfoRemoteModel(BaseModel<?> serviceInfoRemoteModel) {
		_serviceInfoRemoteModel = serviceInfoRemoteModel;
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

		Class<?> remoteModelClass = _serviceInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_serviceInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceInfoLocalServiceUtil.addServiceInfo(this);
		}
		else {
			ServiceInfoLocalServiceUtil.updateServiceInfo(this);
		}
	}

	@Override
	public ServiceInfo toEscapedModel() {
		return (ServiceInfo)ProxyUtil.newProxyInstance(ServiceInfo.class.getClassLoader(),
			new Class[] { ServiceInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceInfoClp clone = new ServiceInfoClp();

		clone.setUuid(getUuid());
		clone.setServiceinfoId(getServiceinfoId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setServiceNo(getServiceNo());
		clone.setServiceName(getServiceName());
		clone.setShortName(getShortName());
		clone.setServiceProcess(getServiceProcess());
		clone.setServiceMethod(getServiceMethod());
		clone.setServiceDossier(getServiceDossier());
		clone.setServiceCondition(getServiceCondition());
		clone.setServiceDuration(getServiceDuration());
		clone.setServiceActors(getServiceActors());
		clone.setServiceResults(getServiceResults());
		clone.setServiceRecords(getServiceRecords());
		clone.setServiceFee(getServiceFee());
		clone.setServiceInstructions(getServiceInstructions());
		clone.setAdministrationCode(getAdministrationCode());
		clone.setAdministrationIndex(getAdministrationIndex());
		clone.setDomainCode(getDomainCode());
		clone.setDomainIndex(getDomainIndex());
		clone.setActiveStatus(getActiveStatus());
		clone.setHasTemplateFiles(getHasTemplateFiles());
		clone.setOnlineUrl(getOnlineUrl());

		return clone;
	}

	@Override
	public int compareTo(ServiceInfo serviceInfo) {
		int value = 0;

		value = getServiceName().compareTo(serviceInfo.getServiceName());

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

		if (!(obj instanceof ServiceInfoClp)) {
			return false;
		}

		ServiceInfoClp serviceInfo = (ServiceInfoClp)obj;

		long primaryKey = serviceInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", serviceinfoId=");
		sb.append(getServiceinfoId());
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
		sb.append(", serviceNo=");
		sb.append(getServiceNo());
		sb.append(", serviceName=");
		sb.append(getServiceName());
		sb.append(", shortName=");
		sb.append(getShortName());
		sb.append(", serviceProcess=");
		sb.append(getServiceProcess());
		sb.append(", serviceMethod=");
		sb.append(getServiceMethod());
		sb.append(", serviceDossier=");
		sb.append(getServiceDossier());
		sb.append(", serviceCondition=");
		sb.append(getServiceCondition());
		sb.append(", serviceDuration=");
		sb.append(getServiceDuration());
		sb.append(", serviceActors=");
		sb.append(getServiceActors());
		sb.append(", serviceResults=");
		sb.append(getServiceResults());
		sb.append(", serviceRecords=");
		sb.append(getServiceRecords());
		sb.append(", serviceFee=");
		sb.append(getServiceFee());
		sb.append(", serviceInstructions=");
		sb.append(getServiceInstructions());
		sb.append(", administrationCode=");
		sb.append(getAdministrationCode());
		sb.append(", administrationIndex=");
		sb.append(getAdministrationIndex());
		sb.append(", domainCode=");
		sb.append(getDomainCode());
		sb.append(", domainIndex=");
		sb.append(getDomainIndex());
		sb.append(", activeStatus=");
		sb.append(getActiveStatus());
		sb.append(", hasTemplateFiles=");
		sb.append(getHasTemplateFiles());
		sb.append(", onlineUrl=");
		sb.append(getOnlineUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(85);

		sb.append("<model><model-name>");
		sb.append("org.opencps.servicemgt.model.ServiceInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceinfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceinfoId());
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
			"<column><column-name>serviceNo</column-name><column-value><![CDATA[");
		sb.append(getServiceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceName</column-name><column-value><![CDATA[");
		sb.append(getServiceName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortName</column-name><column-value><![CDATA[");
		sb.append(getShortName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcess</column-name><column-value><![CDATA[");
		sb.append(getServiceProcess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceMethod</column-name><column-value><![CDATA[");
		sb.append(getServiceMethod());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceDossier</column-name><column-value><![CDATA[");
		sb.append(getServiceDossier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceCondition</column-name><column-value><![CDATA[");
		sb.append(getServiceCondition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceDuration</column-name><column-value><![CDATA[");
		sb.append(getServiceDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceActors</column-name><column-value><![CDATA[");
		sb.append(getServiceActors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceResults</column-name><column-value><![CDATA[");
		sb.append(getServiceResults());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceRecords</column-name><column-value><![CDATA[");
		sb.append(getServiceRecords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceFee</column-name><column-value><![CDATA[");
		sb.append(getServiceFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceInstructions</column-name><column-value><![CDATA[");
		sb.append(getServiceInstructions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>administrationCode</column-name><column-value><![CDATA[");
		sb.append(getAdministrationCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>administrationIndex</column-name><column-value><![CDATA[");
		sb.append(getAdministrationIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>domainCode</column-name><column-value><![CDATA[");
		sb.append(getDomainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>domainIndex</column-name><column-value><![CDATA[");
		sb.append(getDomainIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeStatus</column-name><column-value><![CDATA[");
		sb.append(getActiveStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasTemplateFiles</column-name><column-value><![CDATA[");
		sb.append(getHasTemplateFiles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>onlineUrl</column-name><column-value><![CDATA[");
		sb.append(getOnlineUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _serviceinfoId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _serviceNo;
	private String _serviceName;
	private String _shortName;
	private String _serviceProcess;
	private String _serviceMethod;
	private String _serviceDossier;
	private String _serviceCondition;
	private String _serviceDuration;
	private String _serviceActors;
	private String _serviceResults;
	private String _serviceRecords;
	private String _serviceFee;
	private String _serviceInstructions;
	private String _administrationCode;
	private String _administrationIndex;
	private String _domainCode;
	private String _domainIndex;
	private int _activeStatus;
	private int _hasTemplateFiles;
	private String _onlineUrl;
	private BaseModel<?> _serviceInfoRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.servicemgt.service.ClpSerializer.class;
}