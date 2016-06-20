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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TemplateFile}.
 * </p>
 *
 * @author khoavd
 * @see TemplateFile
 * @generated
 */
public class TemplateFileWrapper implements TemplateFile,
	ModelWrapper<TemplateFile> {
	public TemplateFileWrapper(TemplateFile templateFile) {
		_templateFile = templateFile;
	}

	@Override
	public Class<?> getModelClass() {
		return TemplateFile.class;
	}

	@Override
	public String getModelClassName() {
		return TemplateFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("templatefileId", getTemplatefileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileName", getFileName());
		attributes.put("fileNo", getFileNo());
		attributes.put("fileEntryId", getFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long templatefileId = (Long)attributes.get("templatefileId");

		if (templatefileId != null) {
			setTemplatefileId(templatefileId);
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

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		String fileNo = (String)attributes.get("fileNo");

		if (fileNo != null) {
			setFileNo(fileNo);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}
	}

	/**
	* Returns the primary key of this template file.
	*
	* @return the primary key of this template file
	*/
	@Override
	public long getPrimaryKey() {
		return _templateFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this template file.
	*
	* @param primaryKey the primary key of this template file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_templateFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the templatefile ID of this template file.
	*
	* @return the templatefile ID of this template file
	*/
	@Override
	public long getTemplatefileId() {
		return _templateFile.getTemplatefileId();
	}

	/**
	* Sets the templatefile ID of this template file.
	*
	* @param templatefileId the templatefile ID of this template file
	*/
	@Override
	public void setTemplatefileId(long templatefileId) {
		_templateFile.setTemplatefileId(templatefileId);
	}

	/**
	* Returns the company ID of this template file.
	*
	* @return the company ID of this template file
	*/
	@Override
	public long getCompanyId() {
		return _templateFile.getCompanyId();
	}

	/**
	* Sets the company ID of this template file.
	*
	* @param companyId the company ID of this template file
	*/
	@Override
	public void setCompanyId(long companyId) {
		_templateFile.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this template file.
	*
	* @return the group ID of this template file
	*/
	@Override
	public long getGroupId() {
		return _templateFile.getGroupId();
	}

	/**
	* Sets the group ID of this template file.
	*
	* @param groupId the group ID of this template file
	*/
	@Override
	public void setGroupId(long groupId) {
		_templateFile.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this template file.
	*
	* @return the user ID of this template file
	*/
	@Override
	public long getUserId() {
		return _templateFile.getUserId();
	}

	/**
	* Sets the user ID of this template file.
	*
	* @param userId the user ID of this template file
	*/
	@Override
	public void setUserId(long userId) {
		_templateFile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this template file.
	*
	* @return the user uuid of this template file
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _templateFile.getUserUuid();
	}

	/**
	* Sets the user uuid of this template file.
	*
	* @param userUuid the user uuid of this template file
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_templateFile.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this template file.
	*
	* @return the create date of this template file
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _templateFile.getCreateDate();
	}

	/**
	* Sets the create date of this template file.
	*
	* @param createDate the create date of this template file
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_templateFile.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this template file.
	*
	* @return the modified date of this template file
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _templateFile.getModifiedDate();
	}

	/**
	* Sets the modified date of this template file.
	*
	* @param modifiedDate the modified date of this template file
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_templateFile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the file name of this template file.
	*
	* @return the file name of this template file
	*/
	@Override
	public java.lang.String getFileName() {
		return _templateFile.getFileName();
	}

	/**
	* Sets the file name of this template file.
	*
	* @param fileName the file name of this template file
	*/
	@Override
	public void setFileName(java.lang.String fileName) {
		_templateFile.setFileName(fileName);
	}

	/**
	* Returns the file no of this template file.
	*
	* @return the file no of this template file
	*/
	@Override
	public java.lang.String getFileNo() {
		return _templateFile.getFileNo();
	}

	/**
	* Sets the file no of this template file.
	*
	* @param fileNo the file no of this template file
	*/
	@Override
	public void setFileNo(java.lang.String fileNo) {
		_templateFile.setFileNo(fileNo);
	}

	/**
	* Returns the file entry ID of this template file.
	*
	* @return the file entry ID of this template file
	*/
	@Override
	public long getFileEntryId() {
		return _templateFile.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this template file.
	*
	* @param fileEntryId the file entry ID of this template file
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_templateFile.setFileEntryId(fileEntryId);
	}

	@Override
	public boolean isNew() {
		return _templateFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_templateFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _templateFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_templateFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _templateFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _templateFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_templateFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _templateFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_templateFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_templateFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_templateFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TemplateFileWrapper((TemplateFile)_templateFile.clone());
	}

	@Override
	public int compareTo(org.opencps.servicemgt.model.TemplateFile templateFile) {
		return _templateFile.compareTo(templateFile);
	}

	@Override
	public int hashCode() {
		return _templateFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.servicemgt.model.TemplateFile> toCacheModel() {
		return _templateFile.toCacheModel();
	}

	@Override
	public org.opencps.servicemgt.model.TemplateFile toEscapedModel() {
		return new TemplateFileWrapper(_templateFile.toEscapedModel());
	}

	@Override
	public org.opencps.servicemgt.model.TemplateFile toUnescapedModel() {
		return new TemplateFileWrapper(_templateFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _templateFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _templateFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_templateFile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TemplateFileWrapper)) {
			return false;
		}

		TemplateFileWrapper templateFileWrapper = (TemplateFileWrapper)obj;

		if (Validator.equals(_templateFile, templateFileWrapper._templateFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TemplateFile getWrappedTemplateFile() {
		return _templateFile;
	}

	@Override
	public TemplateFile getWrappedModel() {
		return _templateFile;
	}

	@Override
	public void resetOriginalValues() {
		_templateFile.resetOriginalValues();
	}

	private TemplateFile _templateFile;
}