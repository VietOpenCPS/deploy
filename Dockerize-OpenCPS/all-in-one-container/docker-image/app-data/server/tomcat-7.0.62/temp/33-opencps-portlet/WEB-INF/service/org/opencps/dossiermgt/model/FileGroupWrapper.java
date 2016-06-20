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
 * This class is a wrapper for {@link FileGroup}.
 * </p>
 *
 * @author trungnt
 * @see FileGroup
 * @generated
 */
public class FileGroupWrapper implements FileGroup, ModelWrapper<FileGroup> {
	public FileGroupWrapper(FileGroup fileGroup) {
		_fileGroup = fileGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return FileGroup.class;
	}

	@Override
	public String getModelClassName() {
		return FileGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileGroupId", getFileGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("uuid", getUuid());
		attributes.put("dossierId", getDossierId());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("displayName", getDisplayName());
		attributes.put("removed", getRemoved());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileGroupId = (Long)attributes.get("fileGroupId");

		if (fileGroupId != null) {
			setFileGroupId(fileGroupId);
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

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		Integer removed = (Integer)attributes.get("removed");

		if (removed != null) {
			setRemoved(removed);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	/**
	* Returns the primary key of this file group.
	*
	* @return the primary key of this file group
	*/
	@Override
	public long getPrimaryKey() {
		return _fileGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this file group.
	*
	* @param primaryKey the primary key of this file group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fileGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the file group ID of this file group.
	*
	* @return the file group ID of this file group
	*/
	@Override
	public long getFileGroupId() {
		return _fileGroup.getFileGroupId();
	}

	/**
	* Sets the file group ID of this file group.
	*
	* @param fileGroupId the file group ID of this file group
	*/
	@Override
	public void setFileGroupId(long fileGroupId) {
		_fileGroup.setFileGroupId(fileGroupId);
	}

	/**
	* Returns the company ID of this file group.
	*
	* @return the company ID of this file group
	*/
	@Override
	public long getCompanyId() {
		return _fileGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this file group.
	*
	* @param companyId the company ID of this file group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_fileGroup.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this file group.
	*
	* @return the group ID of this file group
	*/
	@Override
	public long getGroupId() {
		return _fileGroup.getGroupId();
	}

	/**
	* Sets the group ID of this file group.
	*
	* @param groupId the group ID of this file group
	*/
	@Override
	public void setGroupId(long groupId) {
		_fileGroup.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this file group.
	*
	* @return the user ID of this file group
	*/
	@Override
	public long getUserId() {
		return _fileGroup.getUserId();
	}

	/**
	* Sets the user ID of this file group.
	*
	* @param userId the user ID of this file group
	*/
	@Override
	public void setUserId(long userId) {
		_fileGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this file group.
	*
	* @return the user uuid of this file group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this file group.
	*
	* @param userUuid the user uuid of this file group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_fileGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this file group.
	*
	* @return the create date of this file group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _fileGroup.getCreateDate();
	}

	/**
	* Sets the create date of this file group.
	*
	* @param createDate the create date of this file group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_fileGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this file group.
	*
	* @return the modified date of this file group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _fileGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this file group.
	*
	* @param modifiedDate the modified date of this file group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_fileGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the uuid of this file group.
	*
	* @return the uuid of this file group
	*/
	@Override
	public java.lang.String getUuid() {
		return _fileGroup.getUuid();
	}

	/**
	* Sets the uuid of this file group.
	*
	* @param uuid the uuid of this file group
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_fileGroup.setUuid(uuid);
	}

	/**
	* Returns the dossier ID of this file group.
	*
	* @return the dossier ID of this file group
	*/
	@Override
	public long getDossierId() {
		return _fileGroup.getDossierId();
	}

	/**
	* Sets the dossier ID of this file group.
	*
	* @param dossierId the dossier ID of this file group
	*/
	@Override
	public void setDossierId(long dossierId) {
		_fileGroup.setDossierId(dossierId);
	}

	/**
	* Returns the dossier part ID of this file group.
	*
	* @return the dossier part ID of this file group
	*/
	@Override
	public long getDossierPartId() {
		return _fileGroup.getDossierPartId();
	}

	/**
	* Sets the dossier part ID of this file group.
	*
	* @param dossierPartId the dossier part ID of this file group
	*/
	@Override
	public void setDossierPartId(long dossierPartId) {
		_fileGroup.setDossierPartId(dossierPartId);
	}

	/**
	* Returns the display name of this file group.
	*
	* @return the display name of this file group
	*/
	@Override
	public java.lang.String getDisplayName() {
		return _fileGroup.getDisplayName();
	}

	/**
	* Sets the display name of this file group.
	*
	* @param displayName the display name of this file group
	*/
	@Override
	public void setDisplayName(java.lang.String displayName) {
		_fileGroup.setDisplayName(displayName);
	}

	/**
	* Returns the removed of this file group.
	*
	* @return the removed of this file group
	*/
	@Override
	public int getRemoved() {
		return _fileGroup.getRemoved();
	}

	/**
	* Sets the removed of this file group.
	*
	* @param removed the removed of this file group
	*/
	@Override
	public void setRemoved(int removed) {
		_fileGroup.setRemoved(removed);
	}

	/**
	* Returns the sync status of this file group.
	*
	* @return the sync status of this file group
	*/
	@Override
	public int getSyncStatus() {
		return _fileGroup.getSyncStatus();
	}

	/**
	* Sets the sync status of this file group.
	*
	* @param syncStatus the sync status of this file group
	*/
	@Override
	public void setSyncStatus(int syncStatus) {
		_fileGroup.setSyncStatus(syncStatus);
	}

	@Override
	public boolean isNew() {
		return _fileGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fileGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fileGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fileGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fileGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fileGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fileGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fileGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fileGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fileGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fileGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FileGroupWrapper((FileGroup)_fileGroup.clone());
	}

	@Override
	public int compareTo(org.opencps.dossiermgt.model.FileGroup fileGroup) {
		return _fileGroup.compareTo(fileGroup);
	}

	@Override
	public int hashCode() {
		return _fileGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.FileGroup> toCacheModel() {
		return _fileGroup.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.FileGroup toEscapedModel() {
		return new FileGroupWrapper(_fileGroup.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.FileGroup toUnescapedModel() {
		return new FileGroupWrapper(_fileGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fileGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fileGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fileGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileGroupWrapper)) {
			return false;
		}

		FileGroupWrapper fileGroupWrapper = (FileGroupWrapper)obj;

		if (Validator.equals(_fileGroup, fileGroupWrapper._fileGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FileGroup getWrappedFileGroup() {
		return _fileGroup;
	}

	@Override
	public FileGroup getWrappedModel() {
		return _fileGroup;
	}

	@Override
	public void resetOriginalValues() {
		_fileGroup.resetOriginalValues();
	}

	private FileGroup _fileGroup;
}