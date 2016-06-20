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
 * This class is a wrapper for {@link DossierFile}.
 * </p>
 *
 * @author trungnt
 * @see DossierFile
 * @generated
 */
public class DossierFileWrapper implements DossierFile,
	ModelWrapper<DossierFile> {
	public DossierFileWrapper(DossierFile dossierFile) {
		_dossierFile = dossierFile;
	}

	@Override
	public Class<?> getModelClass() {
		return DossierFile.class;
	}

	@Override
	public String getModelClassName() {
		return DossierFile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierFileId", getDossierFileId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("uuid", getUuid());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("templateFileNo", getTemplateFileNo());
		attributes.put("groupFileId", getGroupFileId());
		attributes.put("ownerUserId", getOwnerUserId());
		attributes.put("ownerOrganizationId", getOwnerOrganizationId());
		attributes.put("displayName", getDisplayName());
		attributes.put("formData", getFormData());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("dossierFileMark", getDossierFileMark());
		attributes.put("dossierFileType", getDossierFileType());
		attributes.put("dossierFileNo", getDossierFileNo());
		attributes.put("dossierFileDate", getDossierFileDate());
		attributes.put("removed", getRemoved());
		attributes.put("original", getOriginal());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierFileId = (Long)attributes.get("dossierFileId");

		if (dossierFileId != null) {
			setDossierFileId(dossierFileId);
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

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		String templateFileNo = (String)attributes.get("templateFileNo");

		if (templateFileNo != null) {
			setTemplateFileNo(templateFileNo);
		}

		Long groupFileId = (Long)attributes.get("groupFileId");

		if (groupFileId != null) {
			setGroupFileId(groupFileId);
		}

		Long ownerUserId = (Long)attributes.get("ownerUserId");

		if (ownerUserId != null) {
			setOwnerUserId(ownerUserId);
		}

		Long ownerOrganizationId = (Long)attributes.get("ownerOrganizationId");

		if (ownerOrganizationId != null) {
			setOwnerOrganizationId(ownerOrganizationId);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String formData = (String)attributes.get("formData");

		if (formData != null) {
			setFormData(formData);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Integer dossierFileMark = (Integer)attributes.get("dossierFileMark");

		if (dossierFileMark != null) {
			setDossierFileMark(dossierFileMark);
		}

		Integer dossierFileType = (Integer)attributes.get("dossierFileType");

		if (dossierFileType != null) {
			setDossierFileType(dossierFileType);
		}

		String dossierFileNo = (String)attributes.get("dossierFileNo");

		if (dossierFileNo != null) {
			setDossierFileNo(dossierFileNo);
		}

		Date dossierFileDate = (Date)attributes.get("dossierFileDate");

		if (dossierFileDate != null) {
			setDossierFileDate(dossierFileDate);
		}

		Integer removed = (Integer)attributes.get("removed");

		if (removed != null) {
			setRemoved(removed);
		}

		Integer original = (Integer)attributes.get("original");

		if (original != null) {
			setOriginal(original);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	/**
	* Returns the primary key of this dossier file.
	*
	* @return the primary key of this dossier file
	*/
	@Override
	public long getPrimaryKey() {
		return _dossierFile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dossier file.
	*
	* @param primaryKey the primary key of this dossier file
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dossierFile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dossier file ID of this dossier file.
	*
	* @return the dossier file ID of this dossier file
	*/
	@Override
	public long getDossierFileId() {
		return _dossierFile.getDossierFileId();
	}

	/**
	* Sets the dossier file ID of this dossier file.
	*
	* @param dossierFileId the dossier file ID of this dossier file
	*/
	@Override
	public void setDossierFileId(long dossierFileId) {
		_dossierFile.setDossierFileId(dossierFileId);
	}

	/**
	* Returns the company ID of this dossier file.
	*
	* @return the company ID of this dossier file
	*/
	@Override
	public long getCompanyId() {
		return _dossierFile.getCompanyId();
	}

	/**
	* Sets the company ID of this dossier file.
	*
	* @param companyId the company ID of this dossier file
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dossierFile.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dossier file.
	*
	* @return the group ID of this dossier file
	*/
	@Override
	public long getGroupId() {
		return _dossierFile.getGroupId();
	}

	/**
	* Sets the group ID of this dossier file.
	*
	* @param groupId the group ID of this dossier file
	*/
	@Override
	public void setGroupId(long groupId) {
		_dossierFile.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dossier file.
	*
	* @return the user ID of this dossier file
	*/
	@Override
	public long getUserId() {
		return _dossierFile.getUserId();
	}

	/**
	* Sets the user ID of this dossier file.
	*
	* @param userId the user ID of this dossier file
	*/
	@Override
	public void setUserId(long userId) {
		_dossierFile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dossier file.
	*
	* @return the user uuid of this dossier file
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierFile.getUserUuid();
	}

	/**
	* Sets the user uuid of this dossier file.
	*
	* @param userUuid the user uuid of this dossier file
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dossierFile.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dossier file.
	*
	* @return the create date of this dossier file
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dossierFile.getCreateDate();
	}

	/**
	* Sets the create date of this dossier file.
	*
	* @param createDate the create date of this dossier file
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dossierFile.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dossier file.
	*
	* @return the modified date of this dossier file
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dossierFile.getModifiedDate();
	}

	/**
	* Sets the modified date of this dossier file.
	*
	* @param modifiedDate the modified date of this dossier file
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dossierFile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dossier ID of this dossier file.
	*
	* @return the dossier ID of this dossier file
	*/
	@Override
	public long getDossierId() {
		return _dossierFile.getDossierId();
	}

	/**
	* Sets the dossier ID of this dossier file.
	*
	* @param dossierId the dossier ID of this dossier file
	*/
	@Override
	public void setDossierId(long dossierId) {
		_dossierFile.setDossierId(dossierId);
	}

	/**
	* Returns the uuid of this dossier file.
	*
	* @return the uuid of this dossier file
	*/
	@Override
	public java.lang.String getUuid() {
		return _dossierFile.getUuid();
	}

	/**
	* Sets the uuid of this dossier file.
	*
	* @param uuid the uuid of this dossier file
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_dossierFile.setUuid(uuid);
	}

	/**
	* Returns the dossier part ID of this dossier file.
	*
	* @return the dossier part ID of this dossier file
	*/
	@Override
	public long getDossierPartId() {
		return _dossierFile.getDossierPartId();
	}

	/**
	* Sets the dossier part ID of this dossier file.
	*
	* @param dossierPartId the dossier part ID of this dossier file
	*/
	@Override
	public void setDossierPartId(long dossierPartId) {
		_dossierFile.setDossierPartId(dossierPartId);
	}

	/**
	* Returns the template file no of this dossier file.
	*
	* @return the template file no of this dossier file
	*/
	@Override
	public java.lang.String getTemplateFileNo() {
		return _dossierFile.getTemplateFileNo();
	}

	/**
	* Sets the template file no of this dossier file.
	*
	* @param templateFileNo the template file no of this dossier file
	*/
	@Override
	public void setTemplateFileNo(java.lang.String templateFileNo) {
		_dossierFile.setTemplateFileNo(templateFileNo);
	}

	/**
	* Returns the group file ID of this dossier file.
	*
	* @return the group file ID of this dossier file
	*/
	@Override
	public long getGroupFileId() {
		return _dossierFile.getGroupFileId();
	}

	/**
	* Sets the group file ID of this dossier file.
	*
	* @param groupFileId the group file ID of this dossier file
	*/
	@Override
	public void setGroupFileId(long groupFileId) {
		_dossierFile.setGroupFileId(groupFileId);
	}

	/**
	* Returns the owner user ID of this dossier file.
	*
	* @return the owner user ID of this dossier file
	*/
	@Override
	public long getOwnerUserId() {
		return _dossierFile.getOwnerUserId();
	}

	/**
	* Sets the owner user ID of this dossier file.
	*
	* @param ownerUserId the owner user ID of this dossier file
	*/
	@Override
	public void setOwnerUserId(long ownerUserId) {
		_dossierFile.setOwnerUserId(ownerUserId);
	}

	/**
	* Returns the owner user uuid of this dossier file.
	*
	* @return the owner user uuid of this dossier file
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getOwnerUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierFile.getOwnerUserUuid();
	}

	/**
	* Sets the owner user uuid of this dossier file.
	*
	* @param ownerUserUuid the owner user uuid of this dossier file
	*/
	@Override
	public void setOwnerUserUuid(java.lang.String ownerUserUuid) {
		_dossierFile.setOwnerUserUuid(ownerUserUuid);
	}

	/**
	* Returns the owner organization ID of this dossier file.
	*
	* @return the owner organization ID of this dossier file
	*/
	@Override
	public long getOwnerOrganizationId() {
		return _dossierFile.getOwnerOrganizationId();
	}

	/**
	* Sets the owner organization ID of this dossier file.
	*
	* @param ownerOrganizationId the owner organization ID of this dossier file
	*/
	@Override
	public void setOwnerOrganizationId(long ownerOrganizationId) {
		_dossierFile.setOwnerOrganizationId(ownerOrganizationId);
	}

	/**
	* Returns the display name of this dossier file.
	*
	* @return the display name of this dossier file
	*/
	@Override
	public java.lang.String getDisplayName() {
		return _dossierFile.getDisplayName();
	}

	/**
	* Sets the display name of this dossier file.
	*
	* @param displayName the display name of this dossier file
	*/
	@Override
	public void setDisplayName(java.lang.String displayName) {
		_dossierFile.setDisplayName(displayName);
	}

	/**
	* Returns the form data of this dossier file.
	*
	* @return the form data of this dossier file
	*/
	@Override
	public java.lang.String getFormData() {
		return _dossierFile.getFormData();
	}

	/**
	* Sets the form data of this dossier file.
	*
	* @param formData the form data of this dossier file
	*/
	@Override
	public void setFormData(java.lang.String formData) {
		_dossierFile.setFormData(formData);
	}

	/**
	* Returns the file entry ID of this dossier file.
	*
	* @return the file entry ID of this dossier file
	*/
	@Override
	public long getFileEntryId() {
		return _dossierFile.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this dossier file.
	*
	* @param fileEntryId the file entry ID of this dossier file
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_dossierFile.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the dossier file mark of this dossier file.
	*
	* @return the dossier file mark of this dossier file
	*/
	@Override
	public int getDossierFileMark() {
		return _dossierFile.getDossierFileMark();
	}

	/**
	* Sets the dossier file mark of this dossier file.
	*
	* @param dossierFileMark the dossier file mark of this dossier file
	*/
	@Override
	public void setDossierFileMark(int dossierFileMark) {
		_dossierFile.setDossierFileMark(dossierFileMark);
	}

	/**
	* Returns the dossier file type of this dossier file.
	*
	* @return the dossier file type of this dossier file
	*/
	@Override
	public int getDossierFileType() {
		return _dossierFile.getDossierFileType();
	}

	/**
	* Sets the dossier file type of this dossier file.
	*
	* @param dossierFileType the dossier file type of this dossier file
	*/
	@Override
	public void setDossierFileType(int dossierFileType) {
		_dossierFile.setDossierFileType(dossierFileType);
	}

	/**
	* Returns the dossier file no of this dossier file.
	*
	* @return the dossier file no of this dossier file
	*/
	@Override
	public java.lang.String getDossierFileNo() {
		return _dossierFile.getDossierFileNo();
	}

	/**
	* Sets the dossier file no of this dossier file.
	*
	* @param dossierFileNo the dossier file no of this dossier file
	*/
	@Override
	public void setDossierFileNo(java.lang.String dossierFileNo) {
		_dossierFile.setDossierFileNo(dossierFileNo);
	}

	/**
	* Returns the dossier file date of this dossier file.
	*
	* @return the dossier file date of this dossier file
	*/
	@Override
	public java.util.Date getDossierFileDate() {
		return _dossierFile.getDossierFileDate();
	}

	/**
	* Sets the dossier file date of this dossier file.
	*
	* @param dossierFileDate the dossier file date of this dossier file
	*/
	@Override
	public void setDossierFileDate(java.util.Date dossierFileDate) {
		_dossierFile.setDossierFileDate(dossierFileDate);
	}

	/**
	* Returns the removed of this dossier file.
	*
	* @return the removed of this dossier file
	*/
	@Override
	public int getRemoved() {
		return _dossierFile.getRemoved();
	}

	/**
	* Sets the removed of this dossier file.
	*
	* @param removed the removed of this dossier file
	*/
	@Override
	public void setRemoved(int removed) {
		_dossierFile.setRemoved(removed);
	}

	/**
	* Returns the original of this dossier file.
	*
	* @return the original of this dossier file
	*/
	@Override
	public int getOriginal() {
		return _dossierFile.getOriginal();
	}

	/**
	* Sets the original of this dossier file.
	*
	* @param original the original of this dossier file
	*/
	@Override
	public void setOriginal(int original) {
		_dossierFile.setOriginal(original);
	}

	/**
	* Returns the sync status of this dossier file.
	*
	* @return the sync status of this dossier file
	*/
	@Override
	public int getSyncStatus() {
		return _dossierFile.getSyncStatus();
	}

	/**
	* Sets the sync status of this dossier file.
	*
	* @param syncStatus the sync status of this dossier file
	*/
	@Override
	public void setSyncStatus(int syncStatus) {
		_dossierFile.setSyncStatus(syncStatus);
	}

	@Override
	public boolean isNew() {
		return _dossierFile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dossierFile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dossierFile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dossierFile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dossierFile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dossierFile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dossierFile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dossierFile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dossierFile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dossierFile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dossierFile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DossierFileWrapper((DossierFile)_dossierFile.clone());
	}

	@Override
	public int compareTo(org.opencps.dossiermgt.model.DossierFile dossierFile) {
		return _dossierFile.compareTo(dossierFile);
	}

	@Override
	public int hashCode() {
		return _dossierFile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.DossierFile> toCacheModel() {
		return _dossierFile.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.DossierFile toEscapedModel() {
		return new DossierFileWrapper(_dossierFile.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.DossierFile toUnescapedModel() {
		return new DossierFileWrapper(_dossierFile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dossierFile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dossierFile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dossierFile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierFileWrapper)) {
			return false;
		}

		DossierFileWrapper dossierFileWrapper = (DossierFileWrapper)obj;

		if (Validator.equals(_dossierFile, dossierFileWrapper._dossierFile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DossierFile getWrappedDossierFile() {
		return _dossierFile;
	}

	@Override
	public DossierFile getWrappedModel() {
		return _dossierFile;
	}

	@Override
	public void resetOriginalValues() {
		_dossierFile.resetOriginalValues();
	}

	private DossierFile _dossierFile;
}