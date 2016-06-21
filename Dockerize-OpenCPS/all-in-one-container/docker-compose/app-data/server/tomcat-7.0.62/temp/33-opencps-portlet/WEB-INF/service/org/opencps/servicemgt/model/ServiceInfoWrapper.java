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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceInfo}.
 * </p>
 *
 * @author khoavd
 * @see ServiceInfo
 * @generated
 */
public class ServiceInfoWrapper implements ServiceInfo,
	ModelWrapper<ServiceInfo> {
	public ServiceInfoWrapper(ServiceInfo serviceInfo) {
		_serviceInfo = serviceInfo;
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

	/**
	* Returns the primary key of this service info.
	*
	* @return the primary key of this service info
	*/
	@Override
	public long getPrimaryKey() {
		return _serviceInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service info.
	*
	* @param primaryKey the primary key of this service info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_serviceInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this service info.
	*
	* @return the uuid of this service info
	*/
	@Override
	public java.lang.String getUuid() {
		return _serviceInfo.getUuid();
	}

	/**
	* Sets the uuid of this service info.
	*
	* @param uuid the uuid of this service info
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_serviceInfo.setUuid(uuid);
	}

	/**
	* Returns the serviceinfo ID of this service info.
	*
	* @return the serviceinfo ID of this service info
	*/
	@Override
	public long getServiceinfoId() {
		return _serviceInfo.getServiceinfoId();
	}

	/**
	* Sets the serviceinfo ID of this service info.
	*
	* @param serviceinfoId the serviceinfo ID of this service info
	*/
	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceInfo.setServiceinfoId(serviceinfoId);
	}

	/**
	* Returns the company ID of this service info.
	*
	* @return the company ID of this service info
	*/
	@Override
	public long getCompanyId() {
		return _serviceInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this service info.
	*
	* @param companyId the company ID of this service info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_serviceInfo.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this service info.
	*
	* @return the group ID of this service info
	*/
	@Override
	public long getGroupId() {
		return _serviceInfo.getGroupId();
	}

	/**
	* Sets the group ID of this service info.
	*
	* @param groupId the group ID of this service info
	*/
	@Override
	public void setGroupId(long groupId) {
		_serviceInfo.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this service info.
	*
	* @return the user ID of this service info
	*/
	@Override
	public long getUserId() {
		return _serviceInfo.getUserId();
	}

	/**
	* Sets the user ID of this service info.
	*
	* @param userId the user ID of this service info
	*/
	@Override
	public void setUserId(long userId) {
		_serviceInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this service info.
	*
	* @return the user uuid of this service info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this service info.
	*
	* @param userUuid the user uuid of this service info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_serviceInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this service info.
	*
	* @return the create date of this service info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _serviceInfo.getCreateDate();
	}

	/**
	* Sets the create date of this service info.
	*
	* @param createDate the create date of this service info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_serviceInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this service info.
	*
	* @return the modified date of this service info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _serviceInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this service info.
	*
	* @param modifiedDate the modified date of this service info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_serviceInfo.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the service no of this service info.
	*
	* @return the service no of this service info
	*/
	@Override
	public java.lang.String getServiceNo() {
		return _serviceInfo.getServiceNo();
	}

	/**
	* Sets the service no of this service info.
	*
	* @param serviceNo the service no of this service info
	*/
	@Override
	public void setServiceNo(java.lang.String serviceNo) {
		_serviceInfo.setServiceNo(serviceNo);
	}

	/**
	* Returns the service name of this service info.
	*
	* @return the service name of this service info
	*/
	@Override
	public java.lang.String getServiceName() {
		return _serviceInfo.getServiceName();
	}

	/**
	* Sets the service name of this service info.
	*
	* @param serviceName the service name of this service info
	*/
	@Override
	public void setServiceName(java.lang.String serviceName) {
		_serviceInfo.setServiceName(serviceName);
	}

	/**
	* Returns the short name of this service info.
	*
	* @return the short name of this service info
	*/
	@Override
	public java.lang.String getShortName() {
		return _serviceInfo.getShortName();
	}

	/**
	* Sets the short name of this service info.
	*
	* @param shortName the short name of this service info
	*/
	@Override
	public void setShortName(java.lang.String shortName) {
		_serviceInfo.setShortName(shortName);
	}

	/**
	* Returns the service process of this service info.
	*
	* @return the service process of this service info
	*/
	@Override
	public java.lang.String getServiceProcess() {
		return _serviceInfo.getServiceProcess();
	}

	/**
	* Sets the service process of this service info.
	*
	* @param serviceProcess the service process of this service info
	*/
	@Override
	public void setServiceProcess(java.lang.String serviceProcess) {
		_serviceInfo.setServiceProcess(serviceProcess);
	}

	/**
	* Returns the service method of this service info.
	*
	* @return the service method of this service info
	*/
	@Override
	public java.lang.String getServiceMethod() {
		return _serviceInfo.getServiceMethod();
	}

	/**
	* Sets the service method of this service info.
	*
	* @param serviceMethod the service method of this service info
	*/
	@Override
	public void setServiceMethod(java.lang.String serviceMethod) {
		_serviceInfo.setServiceMethod(serviceMethod);
	}

	/**
	* Returns the service dossier of this service info.
	*
	* @return the service dossier of this service info
	*/
	@Override
	public java.lang.String getServiceDossier() {
		return _serviceInfo.getServiceDossier();
	}

	/**
	* Sets the service dossier of this service info.
	*
	* @param serviceDossier the service dossier of this service info
	*/
	@Override
	public void setServiceDossier(java.lang.String serviceDossier) {
		_serviceInfo.setServiceDossier(serviceDossier);
	}

	/**
	* Returns the service condition of this service info.
	*
	* @return the service condition of this service info
	*/
	@Override
	public java.lang.String getServiceCondition() {
		return _serviceInfo.getServiceCondition();
	}

	/**
	* Sets the service condition of this service info.
	*
	* @param serviceCondition the service condition of this service info
	*/
	@Override
	public void setServiceCondition(java.lang.String serviceCondition) {
		_serviceInfo.setServiceCondition(serviceCondition);
	}

	/**
	* Returns the service duration of this service info.
	*
	* @return the service duration of this service info
	*/
	@Override
	public java.lang.String getServiceDuration() {
		return _serviceInfo.getServiceDuration();
	}

	/**
	* Sets the service duration of this service info.
	*
	* @param serviceDuration the service duration of this service info
	*/
	@Override
	public void setServiceDuration(java.lang.String serviceDuration) {
		_serviceInfo.setServiceDuration(serviceDuration);
	}

	/**
	* Returns the service actors of this service info.
	*
	* @return the service actors of this service info
	*/
	@Override
	public java.lang.String getServiceActors() {
		return _serviceInfo.getServiceActors();
	}

	/**
	* Sets the service actors of this service info.
	*
	* @param serviceActors the service actors of this service info
	*/
	@Override
	public void setServiceActors(java.lang.String serviceActors) {
		_serviceInfo.setServiceActors(serviceActors);
	}

	/**
	* Returns the service results of this service info.
	*
	* @return the service results of this service info
	*/
	@Override
	public java.lang.String getServiceResults() {
		return _serviceInfo.getServiceResults();
	}

	/**
	* Sets the service results of this service info.
	*
	* @param serviceResults the service results of this service info
	*/
	@Override
	public void setServiceResults(java.lang.String serviceResults) {
		_serviceInfo.setServiceResults(serviceResults);
	}

	/**
	* Returns the service records of this service info.
	*
	* @return the service records of this service info
	*/
	@Override
	public java.lang.String getServiceRecords() {
		return _serviceInfo.getServiceRecords();
	}

	/**
	* Sets the service records of this service info.
	*
	* @param serviceRecords the service records of this service info
	*/
	@Override
	public void setServiceRecords(java.lang.String serviceRecords) {
		_serviceInfo.setServiceRecords(serviceRecords);
	}

	/**
	* Returns the service fee of this service info.
	*
	* @return the service fee of this service info
	*/
	@Override
	public java.lang.String getServiceFee() {
		return _serviceInfo.getServiceFee();
	}

	/**
	* Sets the service fee of this service info.
	*
	* @param serviceFee the service fee of this service info
	*/
	@Override
	public void setServiceFee(java.lang.String serviceFee) {
		_serviceInfo.setServiceFee(serviceFee);
	}

	/**
	* Returns the service instructions of this service info.
	*
	* @return the service instructions of this service info
	*/
	@Override
	public java.lang.String getServiceInstructions() {
		return _serviceInfo.getServiceInstructions();
	}

	/**
	* Sets the service instructions of this service info.
	*
	* @param serviceInstructions the service instructions of this service info
	*/
	@Override
	public void setServiceInstructions(java.lang.String serviceInstructions) {
		_serviceInfo.setServiceInstructions(serviceInstructions);
	}

	/**
	* Returns the administration code of this service info.
	*
	* @return the administration code of this service info
	*/
	@Override
	public java.lang.String getAdministrationCode() {
		return _serviceInfo.getAdministrationCode();
	}

	/**
	* Sets the administration code of this service info.
	*
	* @param administrationCode the administration code of this service info
	*/
	@Override
	public void setAdministrationCode(java.lang.String administrationCode) {
		_serviceInfo.setAdministrationCode(administrationCode);
	}

	/**
	* Returns the administration index of this service info.
	*
	* @return the administration index of this service info
	*/
	@Override
	public java.lang.String getAdministrationIndex() {
		return _serviceInfo.getAdministrationIndex();
	}

	/**
	* Sets the administration index of this service info.
	*
	* @param administrationIndex the administration index of this service info
	*/
	@Override
	public void setAdministrationIndex(java.lang.String administrationIndex) {
		_serviceInfo.setAdministrationIndex(administrationIndex);
	}

	/**
	* Returns the domain code of this service info.
	*
	* @return the domain code of this service info
	*/
	@Override
	public java.lang.String getDomainCode() {
		return _serviceInfo.getDomainCode();
	}

	/**
	* Sets the domain code of this service info.
	*
	* @param domainCode the domain code of this service info
	*/
	@Override
	public void setDomainCode(java.lang.String domainCode) {
		_serviceInfo.setDomainCode(domainCode);
	}

	/**
	* Returns the domain index of this service info.
	*
	* @return the domain index of this service info
	*/
	@Override
	public java.lang.String getDomainIndex() {
		return _serviceInfo.getDomainIndex();
	}

	/**
	* Sets the domain index of this service info.
	*
	* @param domainIndex the domain index of this service info
	*/
	@Override
	public void setDomainIndex(java.lang.String domainIndex) {
		_serviceInfo.setDomainIndex(domainIndex);
	}

	/**
	* Returns the active status of this service info.
	*
	* @return the active status of this service info
	*/
	@Override
	public int getActiveStatus() {
		return _serviceInfo.getActiveStatus();
	}

	/**
	* Sets the active status of this service info.
	*
	* @param activeStatus the active status of this service info
	*/
	@Override
	public void setActiveStatus(int activeStatus) {
		_serviceInfo.setActiveStatus(activeStatus);
	}

	/**
	* Returns the has template files of this service info.
	*
	* @return the has template files of this service info
	*/
	@Override
	public int getHasTemplateFiles() {
		return _serviceInfo.getHasTemplateFiles();
	}

	/**
	* Sets the has template files of this service info.
	*
	* @param hasTemplateFiles the has template files of this service info
	*/
	@Override
	public void setHasTemplateFiles(int hasTemplateFiles) {
		_serviceInfo.setHasTemplateFiles(hasTemplateFiles);
	}

	/**
	* Returns the online url of this service info.
	*
	* @return the online url of this service info
	*/
	@Override
	public java.lang.String getOnlineUrl() {
		return _serviceInfo.getOnlineUrl();
	}

	/**
	* Sets the online url of this service info.
	*
	* @param onlineUrl the online url of this service info
	*/
	@Override
	public void setOnlineUrl(java.lang.String onlineUrl) {
		_serviceInfo.setOnlineUrl(onlineUrl);
	}

	@Override
	public boolean isNew() {
		return _serviceInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceInfoWrapper((ServiceInfo)_serviceInfo.clone());
	}

	@Override
	public int compareTo(org.opencps.servicemgt.model.ServiceInfo serviceInfo) {
		return _serviceInfo.compareTo(serviceInfo);
	}

	@Override
	public int hashCode() {
		return _serviceInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.servicemgt.model.ServiceInfo> toCacheModel() {
		return _serviceInfo.toCacheModel();
	}

	@Override
	public org.opencps.servicemgt.model.ServiceInfo toEscapedModel() {
		return new ServiceInfoWrapper(_serviceInfo.toEscapedModel());
	}

	@Override
	public org.opencps.servicemgt.model.ServiceInfo toUnescapedModel() {
		return new ServiceInfoWrapper(_serviceInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceInfoWrapper)) {
			return false;
		}

		ServiceInfoWrapper serviceInfoWrapper = (ServiceInfoWrapper)obj;

		if (Validator.equals(_serviceInfo, serviceInfoWrapper._serviceInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _serviceInfo.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceInfo getWrappedServiceInfo() {
		return _serviceInfo;
	}

	@Override
	public ServiceInfo getWrappedModel() {
		return _serviceInfo;
	}

	@Override
	public void resetOriginalValues() {
		_serviceInfo.resetOriginalValues();
	}

	private ServiceInfo _serviceInfo;
}