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

package org.opencps.datamgt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DictVersion}.
 * </p>
 *
 * @author khoavd
 * @see DictVersion
 * @generated
 */
public class DictVersionWrapper implements DictVersion,
	ModelWrapper<DictVersion> {
	public DictVersionWrapper(DictVersion dictVersion) {
		_dictVersion = dictVersion;
	}

	@Override
	public Class<?> getModelClass() {
		return DictVersion.class;
	}

	@Override
	public String getModelClassName() {
		return DictVersion.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dictVersionId", getDictVersionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dictCollectionId", getDictCollectionId());
		attributes.put("version", getVersion());
		attributes.put("description", getDescription());
		attributes.put("validatedFrom", getValidatedFrom());
		attributes.put("validatedTo", getValidatedTo());
		attributes.put("issueStatus", getIssueStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dictVersionId = (Long)attributes.get("dictVersionId");

		if (dictVersionId != null) {
			setDictVersionId(dictVersionId);
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

		Long dictCollectionId = (Long)attributes.get("dictCollectionId");

		if (dictCollectionId != null) {
			setDictCollectionId(dictCollectionId);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date validatedFrom = (Date)attributes.get("validatedFrom");

		if (validatedFrom != null) {
			setValidatedFrom(validatedFrom);
		}

		Date validatedTo = (Date)attributes.get("validatedTo");

		if (validatedTo != null) {
			setValidatedTo(validatedTo);
		}

		Integer issueStatus = (Integer)attributes.get("issueStatus");

		if (issueStatus != null) {
			setIssueStatus(issueStatus);
		}
	}

	/**
	* Returns the primary key of this dict version.
	*
	* @return the primary key of this dict version
	*/
	@Override
	public long getPrimaryKey() {
		return _dictVersion.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dict version.
	*
	* @param primaryKey the primary key of this dict version
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dictVersion.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dict version ID of this dict version.
	*
	* @return the dict version ID of this dict version
	*/
	@Override
	public long getDictVersionId() {
		return _dictVersion.getDictVersionId();
	}

	/**
	* Sets the dict version ID of this dict version.
	*
	* @param dictVersionId the dict version ID of this dict version
	*/
	@Override
	public void setDictVersionId(long dictVersionId) {
		_dictVersion.setDictVersionId(dictVersionId);
	}

	/**
	* Returns the company ID of this dict version.
	*
	* @return the company ID of this dict version
	*/
	@Override
	public long getCompanyId() {
		return _dictVersion.getCompanyId();
	}

	/**
	* Sets the company ID of this dict version.
	*
	* @param companyId the company ID of this dict version
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dictVersion.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dict version.
	*
	* @return the group ID of this dict version
	*/
	@Override
	public long getGroupId() {
		return _dictVersion.getGroupId();
	}

	/**
	* Sets the group ID of this dict version.
	*
	* @param groupId the group ID of this dict version
	*/
	@Override
	public void setGroupId(long groupId) {
		_dictVersion.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dict version.
	*
	* @return the user ID of this dict version
	*/
	@Override
	public long getUserId() {
		return _dictVersion.getUserId();
	}

	/**
	* Sets the user ID of this dict version.
	*
	* @param userId the user ID of this dict version
	*/
	@Override
	public void setUserId(long userId) {
		_dictVersion.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dict version.
	*
	* @return the user uuid of this dict version
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dictVersion.getUserUuid();
	}

	/**
	* Sets the user uuid of this dict version.
	*
	* @param userUuid the user uuid of this dict version
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dictVersion.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dict version.
	*
	* @return the create date of this dict version
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dictVersion.getCreateDate();
	}

	/**
	* Sets the create date of this dict version.
	*
	* @param createDate the create date of this dict version
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dictVersion.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dict version.
	*
	* @return the modified date of this dict version
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dictVersion.getModifiedDate();
	}

	/**
	* Sets the modified date of this dict version.
	*
	* @param modifiedDate the modified date of this dict version
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dictVersion.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dict collection ID of this dict version.
	*
	* @return the dict collection ID of this dict version
	*/
	@Override
	public long getDictCollectionId() {
		return _dictVersion.getDictCollectionId();
	}

	/**
	* Sets the dict collection ID of this dict version.
	*
	* @param dictCollectionId the dict collection ID of this dict version
	*/
	@Override
	public void setDictCollectionId(long dictCollectionId) {
		_dictVersion.setDictCollectionId(dictCollectionId);
	}

	/**
	* Returns the version of this dict version.
	*
	* @return the version of this dict version
	*/
	@Override
	public java.lang.String getVersion() {
		return _dictVersion.getVersion();
	}

	/**
	* Sets the version of this dict version.
	*
	* @param version the version of this dict version
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_dictVersion.setVersion(version);
	}

	/**
	* Returns the description of this dict version.
	*
	* @return the description of this dict version
	*/
	@Override
	public java.lang.String getDescription() {
		return _dictVersion.getDescription();
	}

	/**
	* Sets the description of this dict version.
	*
	* @param description the description of this dict version
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_dictVersion.setDescription(description);
	}

	/**
	* Returns the validated from of this dict version.
	*
	* @return the validated from of this dict version
	*/
	@Override
	public java.util.Date getValidatedFrom() {
		return _dictVersion.getValidatedFrom();
	}

	/**
	* Sets the validated from of this dict version.
	*
	* @param validatedFrom the validated from of this dict version
	*/
	@Override
	public void setValidatedFrom(java.util.Date validatedFrom) {
		_dictVersion.setValidatedFrom(validatedFrom);
	}

	/**
	* Returns the validated to of this dict version.
	*
	* @return the validated to of this dict version
	*/
	@Override
	public java.util.Date getValidatedTo() {
		return _dictVersion.getValidatedTo();
	}

	/**
	* Sets the validated to of this dict version.
	*
	* @param validatedTo the validated to of this dict version
	*/
	@Override
	public void setValidatedTo(java.util.Date validatedTo) {
		_dictVersion.setValidatedTo(validatedTo);
	}

	/**
	* Returns the issue status of this dict version.
	*
	* @return the issue status of this dict version
	*/
	@Override
	public int getIssueStatus() {
		return _dictVersion.getIssueStatus();
	}

	/**
	* Sets the issue status of this dict version.
	*
	* @param issueStatus the issue status of this dict version
	*/
	@Override
	public void setIssueStatus(int issueStatus) {
		_dictVersion.setIssueStatus(issueStatus);
	}

	@Override
	public boolean isNew() {
		return _dictVersion.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dictVersion.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dictVersion.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dictVersion.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dictVersion.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dictVersion.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dictVersion.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dictVersion.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dictVersion.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dictVersion.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dictVersion.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DictVersionWrapper((DictVersion)_dictVersion.clone());
	}

	@Override
	public int compareTo(org.opencps.datamgt.model.DictVersion dictVersion) {
		return _dictVersion.compareTo(dictVersion);
	}

	@Override
	public int hashCode() {
		return _dictVersion.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.datamgt.model.DictVersion> toCacheModel() {
		return _dictVersion.toCacheModel();
	}

	@Override
	public org.opencps.datamgt.model.DictVersion toEscapedModel() {
		return new DictVersionWrapper(_dictVersion.toEscapedModel());
	}

	@Override
	public org.opencps.datamgt.model.DictVersion toUnescapedModel() {
		return new DictVersionWrapper(_dictVersion.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dictVersion.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dictVersion.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dictVersion.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DictVersionWrapper)) {
			return false;
		}

		DictVersionWrapper dictVersionWrapper = (DictVersionWrapper)obj;

		if (Validator.equals(_dictVersion, dictVersionWrapper._dictVersion)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DictVersion getWrappedDictVersion() {
		return _dictVersion;
	}

	@Override
	public DictVersion getWrappedModel() {
		return _dictVersion;
	}

	@Override
	public void resetOriginalValues() {
		_dictVersion.resetOriginalValues();
	}

	private DictVersion _dictVersion;
}