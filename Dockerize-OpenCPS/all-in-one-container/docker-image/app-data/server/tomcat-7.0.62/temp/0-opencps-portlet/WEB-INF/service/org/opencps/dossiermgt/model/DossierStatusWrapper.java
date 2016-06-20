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
 * This class is a wrapper for {@link DossierStatus}.
 * </p>
 *
 * @author trungnt
 * @see DossierStatus
 * @generated
 */
public class DossierStatusWrapper implements DossierStatus,
	ModelWrapper<DossierStatus> {
	public DossierStatusWrapper(DossierStatus dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return DossierStatus.class;
	}

	@Override
	public String getModelClassName() {
		return DossierStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierStatusId", getDossierStatusId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierId", getDossierId());
		attributes.put("fileGroupId", getFileGroupId());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("actionInfo", getActionInfo());
		attributes.put("messageInfo", getMessageInfo());
		attributes.put("updateDatetime", getUpdateDatetime());
		attributes.put("syncStatus", getSyncStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierStatusId = (Long)attributes.get("dossierStatusId");

		if (dossierStatusId != null) {
			setDossierStatusId(dossierStatusId);
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

		Long fileGroupId = (Long)attributes.get("fileGroupId");

		if (fileGroupId != null) {
			setFileGroupId(fileGroupId);
		}

		Integer dossierStatus = (Integer)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		String actionInfo = (String)attributes.get("actionInfo");

		if (actionInfo != null) {
			setActionInfo(actionInfo);
		}

		String messageInfo = (String)attributes.get("messageInfo");

		if (messageInfo != null) {
			setMessageInfo(messageInfo);
		}

		Date updateDatetime = (Date)attributes.get("updateDatetime");

		if (updateDatetime != null) {
			setUpdateDatetime(updateDatetime);
		}

		Integer syncStatus = (Integer)attributes.get("syncStatus");

		if (syncStatus != null) {
			setSyncStatus(syncStatus);
		}
	}

	/**
	* Returns the primary key of this dossier status.
	*
	* @return the primary key of this dossier status
	*/
	@Override
	public long getPrimaryKey() {
		return _dossierStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dossier status.
	*
	* @param primaryKey the primary key of this dossier status
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dossierStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dossier status ID of this dossier status.
	*
	* @return the dossier status ID of this dossier status
	*/
	@Override
	public long getDossierStatusId() {
		return _dossierStatus.getDossierStatusId();
	}

	/**
	* Sets the dossier status ID of this dossier status.
	*
	* @param dossierStatusId the dossier status ID of this dossier status
	*/
	@Override
	public void setDossierStatusId(long dossierStatusId) {
		_dossierStatus.setDossierStatusId(dossierStatusId);
	}

	/**
	* Returns the company ID of this dossier status.
	*
	* @return the company ID of this dossier status
	*/
	@Override
	public long getCompanyId() {
		return _dossierStatus.getCompanyId();
	}

	/**
	* Sets the company ID of this dossier status.
	*
	* @param companyId the company ID of this dossier status
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dossierStatus.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dossier status.
	*
	* @return the group ID of this dossier status
	*/
	@Override
	public long getGroupId() {
		return _dossierStatus.getGroupId();
	}

	/**
	* Sets the group ID of this dossier status.
	*
	* @param groupId the group ID of this dossier status
	*/
	@Override
	public void setGroupId(long groupId) {
		_dossierStatus.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dossier status.
	*
	* @return the user ID of this dossier status
	*/
	@Override
	public long getUserId() {
		return _dossierStatus.getUserId();
	}

	/**
	* Sets the user ID of this dossier status.
	*
	* @param userId the user ID of this dossier status
	*/
	@Override
	public void setUserId(long userId) {
		_dossierStatus.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dossier status.
	*
	* @return the user uuid of this dossier status
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierStatus.getUserUuid();
	}

	/**
	* Sets the user uuid of this dossier status.
	*
	* @param userUuid the user uuid of this dossier status
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dossierStatus.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dossier status.
	*
	* @return the create date of this dossier status
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dossierStatus.getCreateDate();
	}

	/**
	* Sets the create date of this dossier status.
	*
	* @param createDate the create date of this dossier status
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dossierStatus.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dossier status.
	*
	* @return the modified date of this dossier status
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dossierStatus.getModifiedDate();
	}

	/**
	* Sets the modified date of this dossier status.
	*
	* @param modifiedDate the modified date of this dossier status
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dossierStatus.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dossier ID of this dossier status.
	*
	* @return the dossier ID of this dossier status
	*/
	@Override
	public long getDossierId() {
		return _dossierStatus.getDossierId();
	}

	/**
	* Sets the dossier ID of this dossier status.
	*
	* @param dossierId the dossier ID of this dossier status
	*/
	@Override
	public void setDossierId(long dossierId) {
		_dossierStatus.setDossierId(dossierId);
	}

	/**
	* Returns the file group ID of this dossier status.
	*
	* @return the file group ID of this dossier status
	*/
	@Override
	public long getFileGroupId() {
		return _dossierStatus.getFileGroupId();
	}

	/**
	* Sets the file group ID of this dossier status.
	*
	* @param fileGroupId the file group ID of this dossier status
	*/
	@Override
	public void setFileGroupId(long fileGroupId) {
		_dossierStatus.setFileGroupId(fileGroupId);
	}

	/**
	* Returns the dossier status of this dossier status.
	*
	* @return the dossier status of this dossier status
	*/
	@Override
	public int getDossierStatus() {
		return _dossierStatus.getDossierStatus();
	}

	/**
	* Sets the dossier status of this dossier status.
	*
	* @param dossierStatus the dossier status of this dossier status
	*/
	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossierStatus.setDossierStatus(dossierStatus);
	}

	/**
	* Returns the action info of this dossier status.
	*
	* @return the action info of this dossier status
	*/
	@Override
	public java.lang.String getActionInfo() {
		return _dossierStatus.getActionInfo();
	}

	/**
	* Sets the action info of this dossier status.
	*
	* @param actionInfo the action info of this dossier status
	*/
	@Override
	public void setActionInfo(java.lang.String actionInfo) {
		_dossierStatus.setActionInfo(actionInfo);
	}

	/**
	* Returns the message info of this dossier status.
	*
	* @return the message info of this dossier status
	*/
	@Override
	public java.lang.String getMessageInfo() {
		return _dossierStatus.getMessageInfo();
	}

	/**
	* Sets the message info of this dossier status.
	*
	* @param messageInfo the message info of this dossier status
	*/
	@Override
	public void setMessageInfo(java.lang.String messageInfo) {
		_dossierStatus.setMessageInfo(messageInfo);
	}

	/**
	* Returns the update datetime of this dossier status.
	*
	* @return the update datetime of this dossier status
	*/
	@Override
	public java.util.Date getUpdateDatetime() {
		return _dossierStatus.getUpdateDatetime();
	}

	/**
	* Sets the update datetime of this dossier status.
	*
	* @param updateDatetime the update datetime of this dossier status
	*/
	@Override
	public void setUpdateDatetime(java.util.Date updateDatetime) {
		_dossierStatus.setUpdateDatetime(updateDatetime);
	}

	/**
	* Returns the sync status of this dossier status.
	*
	* @return the sync status of this dossier status
	*/
	@Override
	public int getSyncStatus() {
		return _dossierStatus.getSyncStatus();
	}

	/**
	* Sets the sync status of this dossier status.
	*
	* @param syncStatus the sync status of this dossier status
	*/
	@Override
	public void setSyncStatus(int syncStatus) {
		_dossierStatus.setSyncStatus(syncStatus);
	}

	@Override
	public boolean isNew() {
		return _dossierStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dossierStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dossierStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dossierStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dossierStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dossierStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dossierStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dossierStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dossierStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dossierStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dossierStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DossierStatusWrapper((DossierStatus)_dossierStatus.clone());
	}

	@Override
	public int compareTo(
		org.opencps.dossiermgt.model.DossierStatus dossierStatus) {
		return _dossierStatus.compareTo(dossierStatus);
	}

	@Override
	public int hashCode() {
		return _dossierStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.DossierStatus> toCacheModel() {
		return _dossierStatus.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.DossierStatus toEscapedModel() {
		return new DossierStatusWrapper(_dossierStatus.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.DossierStatus toUnescapedModel() {
		return new DossierStatusWrapper(_dossierStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dossierStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dossierStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dossierStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierStatusWrapper)) {
			return false;
		}

		DossierStatusWrapper dossierStatusWrapper = (DossierStatusWrapper)obj;

		if (Validator.equals(_dossierStatus, dossierStatusWrapper._dossierStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DossierStatus getWrappedDossierStatus() {
		return _dossierStatus;
	}

	@Override
	public DossierStatus getWrappedModel() {
		return _dossierStatus;
	}

	@Override
	public void resetOriginalValues() {
		_dossierStatus.resetOriginalValues();
	}

	private DossierStatus _dossierStatus;
}