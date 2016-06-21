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
 * This class is a wrapper for {@link DossierLog}.
 * </p>
 *
 * @author trungnt
 * @see DossierLog
 * @generated
 */
public class DossierLogWrapper implements DossierLog, ModelWrapper<DossierLog> {
	public DossierLogWrapper(DossierLog dossierLog) {
		_dossierLog = dossierLog;
	}

	@Override
	public Class<?> getModelClass() {
		return DossierLog.class;
	}

	@Override
	public String getModelClassName() {
		return DossierLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierLogId", getDossierLogId());
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
		attributes.put("level", getLevel());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierLogId = (Long)attributes.get("dossierLogId");

		if (dossierLogId != null) {
			setDossierLogId(dossierLogId);
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

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}
	}

	/**
	* Returns the primary key of this dossier log.
	*
	* @return the primary key of this dossier log
	*/
	@Override
	public long getPrimaryKey() {
		return _dossierLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this dossier log.
	*
	* @param primaryKey the primary key of this dossier log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_dossierLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the dossier log ID of this dossier log.
	*
	* @return the dossier log ID of this dossier log
	*/
	@Override
	public long getDossierLogId() {
		return _dossierLog.getDossierLogId();
	}

	/**
	* Sets the dossier log ID of this dossier log.
	*
	* @param dossierLogId the dossier log ID of this dossier log
	*/
	@Override
	public void setDossierLogId(long dossierLogId) {
		_dossierLog.setDossierLogId(dossierLogId);
	}

	/**
	* Returns the company ID of this dossier log.
	*
	* @return the company ID of this dossier log
	*/
	@Override
	public long getCompanyId() {
		return _dossierLog.getCompanyId();
	}

	/**
	* Sets the company ID of this dossier log.
	*
	* @param companyId the company ID of this dossier log
	*/
	@Override
	public void setCompanyId(long companyId) {
		_dossierLog.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this dossier log.
	*
	* @return the group ID of this dossier log
	*/
	@Override
	public long getGroupId() {
		return _dossierLog.getGroupId();
	}

	/**
	* Sets the group ID of this dossier log.
	*
	* @param groupId the group ID of this dossier log
	*/
	@Override
	public void setGroupId(long groupId) {
		_dossierLog.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this dossier log.
	*
	* @return the user ID of this dossier log
	*/
	@Override
	public long getUserId() {
		return _dossierLog.getUserId();
	}

	/**
	* Sets the user ID of this dossier log.
	*
	* @param userId the user ID of this dossier log
	*/
	@Override
	public void setUserId(long userId) {
		_dossierLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this dossier log.
	*
	* @return the user uuid of this dossier log
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _dossierLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this dossier log.
	*
	* @param userUuid the user uuid of this dossier log
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_dossierLog.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this dossier log.
	*
	* @return the create date of this dossier log
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _dossierLog.getCreateDate();
	}

	/**
	* Sets the create date of this dossier log.
	*
	* @param createDate the create date of this dossier log
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_dossierLog.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this dossier log.
	*
	* @return the modified date of this dossier log
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _dossierLog.getModifiedDate();
	}

	/**
	* Sets the modified date of this dossier log.
	*
	* @param modifiedDate the modified date of this dossier log
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_dossierLog.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dossier ID of this dossier log.
	*
	* @return the dossier ID of this dossier log
	*/
	@Override
	public long getDossierId() {
		return _dossierLog.getDossierId();
	}

	/**
	* Sets the dossier ID of this dossier log.
	*
	* @param dossierId the dossier ID of this dossier log
	*/
	@Override
	public void setDossierId(long dossierId) {
		_dossierLog.setDossierId(dossierId);
	}

	/**
	* Returns the file group ID of this dossier log.
	*
	* @return the file group ID of this dossier log
	*/
	@Override
	public long getFileGroupId() {
		return _dossierLog.getFileGroupId();
	}

	/**
	* Sets the file group ID of this dossier log.
	*
	* @param fileGroupId the file group ID of this dossier log
	*/
	@Override
	public void setFileGroupId(long fileGroupId) {
		_dossierLog.setFileGroupId(fileGroupId);
	}

	/**
	* Returns the dossier status of this dossier log.
	*
	* @return the dossier status of this dossier log
	*/
	@Override
	public int getDossierStatus() {
		return _dossierLog.getDossierStatus();
	}

	/**
	* Sets the dossier status of this dossier log.
	*
	* @param dossierStatus the dossier status of this dossier log
	*/
	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossierLog.setDossierStatus(dossierStatus);
	}

	/**
	* Returns the action info of this dossier log.
	*
	* @return the action info of this dossier log
	*/
	@Override
	public java.lang.String getActionInfo() {
		return _dossierLog.getActionInfo();
	}

	/**
	* Sets the action info of this dossier log.
	*
	* @param actionInfo the action info of this dossier log
	*/
	@Override
	public void setActionInfo(java.lang.String actionInfo) {
		_dossierLog.setActionInfo(actionInfo);
	}

	/**
	* Returns the message info of this dossier log.
	*
	* @return the message info of this dossier log
	*/
	@Override
	public java.lang.String getMessageInfo() {
		return _dossierLog.getMessageInfo();
	}

	/**
	* Sets the message info of this dossier log.
	*
	* @param messageInfo the message info of this dossier log
	*/
	@Override
	public void setMessageInfo(java.lang.String messageInfo) {
		_dossierLog.setMessageInfo(messageInfo);
	}

	/**
	* Returns the update datetime of this dossier log.
	*
	* @return the update datetime of this dossier log
	*/
	@Override
	public java.util.Date getUpdateDatetime() {
		return _dossierLog.getUpdateDatetime();
	}

	/**
	* Sets the update datetime of this dossier log.
	*
	* @param updateDatetime the update datetime of this dossier log
	*/
	@Override
	public void setUpdateDatetime(java.util.Date updateDatetime) {
		_dossierLog.setUpdateDatetime(updateDatetime);
	}

	/**
	* Returns the level of this dossier log.
	*
	* @return the level of this dossier log
	*/
	@Override
	public int getLevel() {
		return _dossierLog.getLevel();
	}

	/**
	* Sets the level of this dossier log.
	*
	* @param level the level of this dossier log
	*/
	@Override
	public void setLevel(int level) {
		_dossierLog.setLevel(level);
	}

	@Override
	public boolean isNew() {
		return _dossierLog.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_dossierLog.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _dossierLog.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_dossierLog.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _dossierLog.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _dossierLog.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_dossierLog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _dossierLog.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_dossierLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_dossierLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_dossierLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DossierLogWrapper((DossierLog)_dossierLog.clone());
	}

	@Override
	public int compareTo(org.opencps.dossiermgt.model.DossierLog dossierLog) {
		return _dossierLog.compareTo(dossierLog);
	}

	@Override
	public int hashCode() {
		return _dossierLog.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.dossiermgt.model.DossierLog> toCacheModel() {
		return _dossierLog.toCacheModel();
	}

	@Override
	public org.opencps.dossiermgt.model.DossierLog toEscapedModel() {
		return new DossierLogWrapper(_dossierLog.toEscapedModel());
	}

	@Override
	public org.opencps.dossiermgt.model.DossierLog toUnescapedModel() {
		return new DossierLogWrapper(_dossierLog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _dossierLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _dossierLog.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_dossierLog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DossierLogWrapper)) {
			return false;
		}

		DossierLogWrapper dossierLogWrapper = (DossierLogWrapper)obj;

		if (Validator.equals(_dossierLog, dossierLogWrapper._dossierLog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DossierLog getWrappedDossierLog() {
		return _dossierLog;
	}

	@Override
	public DossierLog getWrappedModel() {
		return _dossierLog;
	}

	@Override
	public void resetOriginalValues() {
		_dossierLog.resetOriginalValues();
	}

	private DossierLog _dossierLog;
}