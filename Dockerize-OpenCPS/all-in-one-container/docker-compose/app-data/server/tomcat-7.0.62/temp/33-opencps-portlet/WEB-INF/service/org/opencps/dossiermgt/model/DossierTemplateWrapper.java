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

package org.opencps.dossiermgt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DossierTemplate}.
 * </p>
 *
 * @author trungnt
 * @see DossierTemplate
 * @generated
 */
public class DossierTemplateWrapper implements DossierTemplate,
	ModelWrapper<DossierTemplate> {
	public DossierTemplateWrapper(DossierTemplate dossierTemplate) {
		_dossierTemplate = dossierTemplate;
	}

	@Override
	public Class<?> getModelClass() {
		return DossierTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return DossierTemplate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("templateName", getTemplateName());
		attributes.put("description", getDescription());
		attributes.put("templateNo", getTemplateNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
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

		String templateName = (String)attributes.get("templateName");

		if (templateName != null) {
			setTemplateName(templateName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String templateNo = (String)attributes.get("templateNo");

		if (templateNo != null) {
			setTemplateNo(templateNo);
		}
	}

	/**
	* Returns the primary key of this dossier template.
	*
	* @return the primary key of this dossier template
	*/
	@Override
	public long getPrimaryKey() {
		return _dossierTemplate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dossier template.
	*
	* @param primaryKey the primary key of this dossier template
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dossierTemplate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dossier template ID of this dossier template.
	*
	* @return the dossier template ID of this dossier template
	*/
	@Override
	public long getDossierTemplateId() {
		return _dossierTemplate.getDossierTemplateId();
	}

	/**
	* Sets the dossier template ID of this dossier template.
	*
	* @param dossierTemplateId the dossier template ID of this dossier template
	*/
	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplate.setDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns the company ID of this dossier template.
	*
	* @return the company ID of this dossier template
	*/
	@Override
	public long getCompanyId() {
		return _dossierTemplate.getCompanyId();
	}

	/**
	* Sets the company ID of this dossier template.
	*
	* @param companyId the company ID of this dossier template
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dossierTemplate.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dossier template.
	*
	* @return the group ID of this dossier template
	*/
	@Override
	public long getGroupId() {
		return _dossierTemplate.getGroupId();
	}

	/**
	* Sets the group ID of this dossier template.
	*
	* @param groupId the group ID of this dossier template
	*/
	@Override
	public void setGroupId(long groupId) {
		_dossierTemplate.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dossier template.
	*
	* @return the user ID of this dossier template
	*/
	@Override
	public long getUserId() {
		return _dossierTemplate.getUserId();
	}

	/**
	* Sets the user ID of this dossier template.
	*
	* @param userId the user ID of this dossier template
	*/
	@Override
	public void setUserId(long userId) {
		_dossierTemplate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dossier template.
	*
	* @return the user uuid of this dossier template
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierTemplate.getUserUuid();
	}

	/**
	* Sets the user uuid of this dossier template.
	*
	* @param userUuid the user uuid of this dossier template
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dossierTemplate.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dossier template.
	*
	* @return the create date of this dossier template
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dossierTemplate.getCreateDate();
	}

	/**
	* Sets the create date of this dossier template.
	*
	* @param createDate the create date of this dossier template
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dossierTemplate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dossier template.
	*
	* @return the modified date of this dossier template
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dossierTemplate.getModifiedDate();
	}

	/**
	* Sets the modified date of this dossier template.
	*
	* @param modifiedDate the modified date of this dossier template
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dossierTemplate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the template name of this dossier template.
	*
	* @return the template name of this dossier template
	*/
	@Override
	public java.lang.String getTemplateName() {
		return _dossierTemplate.getTemplateName();
	}

	/**
	* Sets the template name of this dossier template.
	*
	* @param templateName the template name of this dossier template
	*/
	@Override
	public void setTemplateName(java.lang.String templateName) {
		_dossierTemplate.setTemplateName(templateName);
	}

	/**
	* Returns the description of this dossier template.
	*
	* @return the description of this dossier template
	*/
	@Override
	public java.lang.String getDescription() {
		return _dossierTemplate.getDescription();
	}

	/**
	* Sets the description of this dossier template.
	*
	* @param description the description of this dossier template
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_dossierTemplate.setDescription(description);
	}

	/**
	* Returns the template no of this dossier template.
	*
	* @return the template no of this dossier template
	*/
	@Override
	public java.lang.String getTemplateNo() {
		return _dossierTemplate.getTemplateNo();
	}

	/**
	* Sets the template no of this dossier template.
	*
	* @param templateNo the template no of this dossier template
	*/
	@Override
	public void setTemplateNo(java.lang.String templateNo) {
		_dossierTemplate.setTemplateNo(templateNo);
	}

	@Override
	public boolean isNew() {
		return _dossierTemplate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dossierTemplate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dossierTemplate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dossierTemplate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dossierTemplate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dossierTemplate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dossierTemplate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dossierTemplate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dossierTemplate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dossierTemplate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dossierTemplate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DossierTemplateWrapper((DossierTemplate)_dossierTemplate.clone());
	}

	@Override
	public int compareTo(
		org.opencps.dossiermgt.model.DossierTemplate dossierTemplate) {
		return _dossierTemplate.compareTo(dossierTemplate);
	}

	@Override
	public int hashCode() {
		return _dossierTemplate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.DossierTemplate> toCacheModel() {
		return _dossierTemplate.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate toEscapedModel() {
		return new DossierTemplateWrapper(_dossierTemplate.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.DossierTemplate toUnescapedModel() {
		return new DossierTemplateWrapper(_dossierTemplate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dossierTemplate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dossierTemplate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dossierTemplate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierTemplateWrapper)) {
			return false;
		}

		DossierTemplateWrapper dossierTemplateWrapper = (DossierTemplateWrapper)obj;

		if (Validator.equals(_dossierTemplate,
					dossierTemplateWrapper._dossierTemplate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DossierTemplate getWrappedDossierTemplate() {
		return _dossierTemplate;
	}

	@Override
	public DossierTemplate getWrappedModel() {
		return _dossierTemplate;
	}

	@Override
	public void resetOriginalValues() {
		_dossierTemplate.resetOriginalValues();
	}

	private DossierTemplate _dossierTemplate;
}