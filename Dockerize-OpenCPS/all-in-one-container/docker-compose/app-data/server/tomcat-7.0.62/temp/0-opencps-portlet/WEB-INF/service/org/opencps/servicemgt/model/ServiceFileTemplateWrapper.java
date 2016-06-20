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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceFileTemplate}.
 * </p>
 *
 * @author khoavd
 * @see ServiceFileTemplate
 * @generated
 */
public class ServiceFileTemplateWrapper implements ServiceFileTemplate,
	ModelWrapper<ServiceFileTemplate> {
	public ServiceFileTemplateWrapper(ServiceFileTemplate serviceFileTemplate) {
		_serviceFileTemplate = serviceFileTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceFileTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceFileTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceinfoId", getServiceinfoId());
		attributes.put("templatefileId", getTemplatefileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
		}

		Long templatefileId = (Long)attributes.get("templatefileId");

		if (templatefileId != null) {
			setTemplatefileId(templatefileId);
		}
	}

	/**
	* Returns the primary key of this service file template.
	*
	* @return the primary key of this service file template
	*/
	@Override
	public org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK getPrimaryKey() {
		return _serviceFileTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this service file template.
	*
	* @param primaryKey the primary key of this service file template
	*/
	@Override
	public void setPrimaryKey(
		org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK primaryKey) {
		_serviceFileTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the serviceinfo ID of this service file template.
	*
	* @return the serviceinfo ID of this service file template
	*/
	@Override
	public long getServiceinfoId() {
		return _serviceFileTemplate.getServiceinfoId();
	}

	/**
	* Sets the serviceinfo ID of this service file template.
	*
	* @param serviceinfoId the serviceinfo ID of this service file template
	*/
	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceFileTemplate.setServiceinfoId(serviceinfoId);
	}

	/**
	* Returns the templatefile ID of this service file template.
	*
	* @return the templatefile ID of this service file template
	*/
	@Override
	public long getTemplatefileId() {
		return _serviceFileTemplate.getTemplatefileId();
	}

	/**
	* Sets the templatefile ID of this service file template.
	*
	* @param templatefileId the templatefile ID of this service file template
	*/
	@Override
	public void setTemplatefileId(long templatefileId) {
		_serviceFileTemplate.setTemplatefileId(templatefileId);
	}

	@Override
	public boolean isNew() {
		return _serviceFileTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_serviceFileTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _serviceFileTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_serviceFileTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _serviceFileTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _serviceFileTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_serviceFileTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _serviceFileTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_serviceFileTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_serviceFileTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_serviceFileTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ServiceFileTemplateWrapper((ServiceFileTemplate)_serviceFileTemplate.clone());
	}

	@Override
	public int compareTo(
		org.opencps.servicemgt.model.ServiceFileTemplate serviceFileTemplate) {
		return _serviceFileTemplate.compareTo(serviceFileTemplate);
	}

	@Override
	public int hashCode() {
		return _serviceFileTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.servicemgt.model.ServiceFileTemplate> toCacheModel() {
		return _serviceFileTemplate.toCacheModel();
	}

	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate toEscapedModel() {
		return new ServiceFileTemplateWrapper(_serviceFileTemplate.toEscapedModel());
	}

	@Override
	public org.opencps.servicemgt.model.ServiceFileTemplate toUnescapedModel() {
		return new ServiceFileTemplateWrapper(_serviceFileTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _serviceFileTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _serviceFileTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_serviceFileTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceFileTemplateWrapper)) {
			return false;
		}

		ServiceFileTemplateWrapper serviceFileTemplateWrapper = (ServiceFileTemplateWrapper)obj;

		if (Validator.equals(_serviceFileTemplate,
					serviceFileTemplateWrapper._serviceFileTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ServiceFileTemplate getWrappedServiceFileTemplate() {
		return _serviceFileTemplate;
	}

	@Override
	public ServiceFileTemplate getWrappedModel() {
		return _serviceFileTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_serviceFileTemplate.resetOriginalValues();
	}

	private ServiceFileTemplate _serviceFileTemplate;
}