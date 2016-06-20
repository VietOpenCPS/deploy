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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceInfoProcess}.
 * </p>
 *
 * @author khoavd
 * @see ServiceInfoProcess
 * @generated
 */
public class ServiceInfoProcessWrapper implements ServiceInfoProcess,
	ModelWrapper<ServiceInfoProcess> {
	public ServiceInfoProcessWrapper(ServiceInfoProcess serviceInfoProcess) {
		_serviceInfoProcess = serviceInfoProcess;
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceInfoProcess.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceInfoProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("serviceinfoId", getServiceinfoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
		}
	}

	/**
	* Returns the primary key of this service info process.
	*
	* @return the primary key of this service info process
	*/
	@Override
	public org.opencps.processmgt.service.persistence.ServiceInfoProcessPK getPrimaryKey() {
		return _serviceInfoProcess.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service info process.
	*
	* @param primaryKey the primary key of this service info process
	*/
	@Override
	public void setPrimaryKey(
		org.opencps.processmgt.service.persistence.ServiceInfoProcessPK primaryKey) {
		_serviceInfoProcess.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the service process ID of this service info process.
	*
	* @return the service process ID of this service info process
	*/
	@Override
	public long getServiceProcessId() {
		return _serviceInfoProcess.getServiceProcessId();
	}

	/**
	* Sets the service process ID of this service info process.
	*
	* @param serviceProcessId the service process ID of this service info process
	*/
	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceInfoProcess.setServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the serviceinfo ID of this service info process.
	*
	* @return the serviceinfo ID of this service info process
	*/
	@Override
	public long getServiceinfoId() {
		return _serviceInfoProcess.getServiceinfoId();
	}

	/**
	* Sets the serviceinfo ID of this service info process.
	*
	* @param serviceinfoId the serviceinfo ID of this service info process
	*/
	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceInfoProcess.setServiceinfoId(serviceinfoId);
	}

	@Override
	public boolean isNew() {
		return _serviceInfoProcess.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceInfoProcess.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceInfoProcess.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceInfoProcess.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceInfoProcess.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceInfoProcess.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceInfoProcess.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceInfoProcess.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceInfoProcess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceInfoProcess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceInfoProcess.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceInfoProcessWrapper((ServiceInfoProcess)_serviceInfoProcess.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.ServiceInfoProcess serviceInfoProcess) {
		return _serviceInfoProcess.compareTo(serviceInfoProcess);
	}

	@Override
	public int hashCode() {
		return _serviceInfoProcess.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ServiceInfoProcess> toCacheModel() {
		return _serviceInfoProcess.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess toEscapedModel() {
		return new ServiceInfoProcessWrapper(_serviceInfoProcess.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ServiceInfoProcess toUnescapedModel() {
		return new ServiceInfoProcessWrapper(_serviceInfoProcess.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceInfoProcess.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceInfoProcess.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceInfoProcess.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceInfoProcessWrapper)) {
			return false;
		}

		ServiceInfoProcessWrapper serviceInfoProcessWrapper = (ServiceInfoProcessWrapper)obj;

		if (Validator.equals(_serviceInfoProcess,
					serviceInfoProcessWrapper._serviceInfoProcess)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceInfoProcess getWrappedServiceInfoProcess() {
		return _serviceInfoProcess;
	}

	@Override
	public ServiceInfoProcess getWrappedModel() {
		return _serviceInfoProcess;
	}

	@Override
	public void resetOriginalValues() {
		_serviceInfoProcess.resetOriginalValues();
	}

	private ServiceInfoProcess _serviceInfoProcess;
}