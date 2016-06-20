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

package org.opencps.processmgt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceProcess}.
 * </p>
 *
 * @author khoavd
 * @see ServiceProcess
 * @generated
 */
public class ServiceProcessWrapper implements ServiceProcess,
	ModelWrapper<ServiceProcess> {
	public ServiceProcessWrapper(ServiceProcess serviceProcess) {
		_serviceProcess = serviceProcess;
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceProcess.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("processNo", getProcessNo());
		attributes.put("processName", getProcessName());
		attributes.put("description", getDescription());
		attributes.put("dossierTemplateId", getDossierTemplateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
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

		String processNo = (String)attributes.get("processNo");

		if (processNo != null) {
			setProcessNo(processNo);
		}

		String processName = (String)attributes.get("processName");

		if (processName != null) {
			setProcessName(processName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}
	}

	/**
	* Returns the primary key of this service process.
	*
	* @return the primary key of this service process
	*/
	@Override
	public long getPrimaryKey() {
		return _serviceProcess.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service process.
	*
	* @param primaryKey the primary key of this service process
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_serviceProcess.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the service process ID of this service process.
	*
	* @return the service process ID of this service process
	*/
	@Override
	public long getServiceProcessId() {
		return _serviceProcess.getServiceProcessId();
	}

	/**
	* Sets the service process ID of this service process.
	*
	* @param serviceProcessId the service process ID of this service process
	*/
	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcess.setServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the company ID of this service process.
	*
	* @return the company ID of this service process
	*/
	@Override
	public long getCompanyId() {
		return _serviceProcess.getCompanyId();
	}

	/**
	* Sets the company ID of this service process.
	*
	* @param companyId the company ID of this service process
	*/
	@Override
	public void setCompanyId(long companyId) {
		_serviceProcess.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this service process.
	*
	* @return the group ID of this service process
	*/
	@Override
	public long getGroupId() {
		return _serviceProcess.getGroupId();
	}

	/**
	* Sets the group ID of this service process.
	*
	* @param groupId the group ID of this service process
	*/
	@Override
	public void setGroupId(long groupId) {
		_serviceProcess.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this service process.
	*
	* @return the user ID of this service process
	*/
	@Override
	public long getUserId() {
		return _serviceProcess.getUserId();
	}

	/**
	* Sets the user ID of this service process.
	*
	* @param userId the user ID of this service process
	*/
	@Override
	public void setUserId(long userId) {
		_serviceProcess.setUserId(userId);
	}

	/**
	* Returns the user uuid of this service process.
	*
	* @return the user uuid of this service process
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceProcess.getUserUuid();
	}

	/**
	* Sets the user uuid of this service process.
	*
	* @param userUuid the user uuid of this service process
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_serviceProcess.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this service process.
	*
	* @return the create date of this service process
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _serviceProcess.getCreateDate();
	}

	/**
	* Sets the create date of this service process.
	*
	* @param createDate the create date of this service process
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_serviceProcess.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this service process.
	*
	* @return the modified date of this service process
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _serviceProcess.getModifiedDate();
	}

	/**
	* Sets the modified date of this service process.
	*
	* @param modifiedDate the modified date of this service process
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_serviceProcess.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the process no of this service process.
	*
	* @return the process no of this service process
	*/
	@Override
	public java.lang.String getProcessNo() {
		return _serviceProcess.getProcessNo();
	}

	/**
	* Sets the process no of this service process.
	*
	* @param processNo the process no of this service process
	*/
	@Override
	public void setProcessNo(java.lang.String processNo) {
		_serviceProcess.setProcessNo(processNo);
	}

	/**
	* Returns the process name of this service process.
	*
	* @return the process name of this service process
	*/
	@Override
	public java.lang.String getProcessName() {
		return _serviceProcess.getProcessName();
	}

	/**
	* Sets the process name of this service process.
	*
	* @param processName the process name of this service process
	*/
	@Override
	public void setProcessName(java.lang.String processName) {
		_serviceProcess.setProcessName(processName);
	}

	/**
	* Returns the description of this service process.
	*
	* @return the description of this service process
	*/
	@Override
	public java.lang.String getDescription() {
		return _serviceProcess.getDescription();
	}

	/**
	* Sets the description of this service process.
	*
	* @param description the description of this service process
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_serviceProcess.setDescription(description);
	}

	/**
	* Returns the dossier template ID of this service process.
	*
	* @return the dossier template ID of this service process
	*/
	@Override
	public long getDossierTemplateId() {
		return _serviceProcess.getDossierTemplateId();
	}

	/**
	* Sets the dossier template ID of this service process.
	*
	* @param dossierTemplateId the dossier template ID of this service process
	*/
	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_serviceProcess.setDossierTemplateId(dossierTemplateId);
	}

	@Override
	public boolean isNew() {
		return _serviceProcess.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceProcess.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceProcess.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceProcess.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceProcess.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceProcess.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceProcess.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceProcess.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceProcess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceProcess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceProcess.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceProcessWrapper((ServiceProcess)_serviceProcess.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.ServiceProcess serviceProcess) {
		return _serviceProcess.compareTo(serviceProcess);
	}

	@Override
	public int hashCode() {
		return _serviceProcess.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ServiceProcess> toCacheModel() {
		return _serviceProcess.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ServiceProcess toEscapedModel() {
		return new ServiceProcessWrapper(_serviceProcess.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ServiceProcess toUnescapedModel() {
		return new ServiceProcessWrapper(_serviceProcess.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceProcess.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceProcess.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceProcess.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceProcessWrapper)) {
			return false;
		}

		ServiceProcessWrapper serviceProcessWrapper = (ServiceProcessWrapper)obj;

		if (Validator.equals(_serviceProcess,
					serviceProcessWrapper._serviceProcess)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceProcess getWrappedServiceProcess() {
		return _serviceProcess;
	}

	@Override
	public ServiceProcess getWrappedModel() {
		return _serviceProcess;
	}

	@Override
	public void resetOriginalValues() {
		_serviceProcess.resetOriginalValues();
	}

	private ServiceProcess _serviceProcess;
}