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
 * This class is a wrapper for {@link ProcessStep}.
 * </p>
 *
 * @author khoavd
 * @see ProcessStep
 * @generated
 */
public class ProcessStepWrapper implements ProcessStep,
	ModelWrapper<ProcessStep> {
	public ProcessStepWrapper(ProcessStep processStep) {
		_processStep = processStep;
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessStep.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessStep.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("processStepId", getProcessStepId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("stepName", getStepName());
		attributes.put("sequenceNo", getSequenceNo());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("daysDuration", getDaysDuration());
		attributes.put("referenceDossierPartId", getReferenceDossierPartId());
		attributes.put("externalAppUrl", getExternalAppUrl());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
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

		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		String stepName = (String)attributes.get("stepName");

		if (stepName != null) {
			setStepName(stepName);
		}

		Integer sequenceNo = (Integer)attributes.get("sequenceNo");

		if (sequenceNo != null) {
			setSequenceNo(sequenceNo);
		}

		String dossierStatus = (String)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		Integer daysDuration = (Integer)attributes.get("daysDuration");

		if (daysDuration != null) {
			setDaysDuration(daysDuration);
		}

		Long referenceDossierPartId = (Long)attributes.get(
				"referenceDossierPartId");

		if (referenceDossierPartId != null) {
			setReferenceDossierPartId(referenceDossierPartId);
		}

		String externalAppUrl = (String)attributes.get("externalAppUrl");

		if (externalAppUrl != null) {
			setExternalAppUrl(externalAppUrl);
		}
	}

	/**
	* Returns the primary key of this process step.
	*
	* @return the primary key of this process step
	*/
	@Override
	public long getPrimaryKey() {
		return _processStep.getPrimaryKey();
	}

	/**
	* Sets the primary key of this process step.
	*
	* @param primaryKey the primary key of this process step
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_processStep.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the process step ID of this process step.
	*
	* @return the process step ID of this process step
	*/
	@Override
	public long getProcessStepId() {
		return _processStep.getProcessStepId();
	}

	/**
	* Sets the process step ID of this process step.
	*
	* @param processStepId the process step ID of this process step
	*/
	@Override
	public void setProcessStepId(long processStepId) {
		_processStep.setProcessStepId(processStepId);
	}

	/**
	* Returns the company ID of this process step.
	*
	* @return the company ID of this process step
	*/
	@Override
	public long getCompanyId() {
		return _processStep.getCompanyId();
	}

	/**
	* Sets the company ID of this process step.
	*
	* @param companyId the company ID of this process step
	*/
	@Override
	public void setCompanyId(long companyId) {
		_processStep.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this process step.
	*
	* @return the group ID of this process step
	*/
	@Override
	public long getGroupId() {
		return _processStep.getGroupId();
	}

	/**
	* Sets the group ID of this process step.
	*
	* @param groupId the group ID of this process step
	*/
	@Override
	public void setGroupId(long groupId) {
		_processStep.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this process step.
	*
	* @return the user ID of this process step
	*/
	@Override
	public long getUserId() {
		return _processStep.getUserId();
	}

	/**
	* Sets the user ID of this process step.
	*
	* @param userId the user ID of this process step
	*/
	@Override
	public void setUserId(long userId) {
		_processStep.setUserId(userId);
	}

	/**
	* Returns the user uuid of this process step.
	*
	* @return the user uuid of this process step
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processStep.getUserUuid();
	}

	/**
	* Sets the user uuid of this process step.
	*
	* @param userUuid the user uuid of this process step
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_processStep.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this process step.
	*
	* @return the create date of this process step
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _processStep.getCreateDate();
	}

	/**
	* Sets the create date of this process step.
	*
	* @param createDate the create date of this process step
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_processStep.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this process step.
	*
	* @return the modified date of this process step
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _processStep.getModifiedDate();
	}

	/**
	* Sets the modified date of this process step.
	*
	* @param modifiedDate the modified date of this process step
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_processStep.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the service process ID of this process step.
	*
	* @return the service process ID of this process step
	*/
	@Override
	public long getServiceProcessId() {
		return _processStep.getServiceProcessId();
	}

	/**
	* Sets the service process ID of this process step.
	*
	* @param serviceProcessId the service process ID of this process step
	*/
	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_processStep.setServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the step name of this process step.
	*
	* @return the step name of this process step
	*/
	@Override
	public java.lang.String getStepName() {
		return _processStep.getStepName();
	}

	/**
	* Sets the step name of this process step.
	*
	* @param stepName the step name of this process step
	*/
	@Override
	public void setStepName(java.lang.String stepName) {
		_processStep.setStepName(stepName);
	}

	/**
	* Returns the sequence no of this process step.
	*
	* @return the sequence no of this process step
	*/
	@Override
	public int getSequenceNo() {
		return _processStep.getSequenceNo();
	}

	/**
	* Sets the sequence no of this process step.
	*
	* @param sequenceNo the sequence no of this process step
	*/
	@Override
	public void setSequenceNo(int sequenceNo) {
		_processStep.setSequenceNo(sequenceNo);
	}

	/**
	* Returns the dossier status of this process step.
	*
	* @return the dossier status of this process step
	*/
	@Override
	public java.lang.String getDossierStatus() {
		return _processStep.getDossierStatus();
	}

	/**
	* Sets the dossier status of this process step.
	*
	* @param dossierStatus the dossier status of this process step
	*/
	@Override
	public void setDossierStatus(java.lang.String dossierStatus) {
		_processStep.setDossierStatus(dossierStatus);
	}

	/**
	* Returns the days duration of this process step.
	*
	* @return the days duration of this process step
	*/
	@Override
	public int getDaysDuration() {
		return _processStep.getDaysDuration();
	}

	/**
	* Sets the days duration of this process step.
	*
	* @param daysDuration the days duration of this process step
	*/
	@Override
	public void setDaysDuration(int daysDuration) {
		_processStep.setDaysDuration(daysDuration);
	}

	/**
	* Returns the reference dossier part ID of this process step.
	*
	* @return the reference dossier part ID of this process step
	*/
	@Override
	public long getReferenceDossierPartId() {
		return _processStep.getReferenceDossierPartId();
	}

	/**
	* Sets the reference dossier part ID of this process step.
	*
	* @param referenceDossierPartId the reference dossier part ID of this process step
	*/
	@Override
	public void setReferenceDossierPartId(long referenceDossierPartId) {
		_processStep.setReferenceDossierPartId(referenceDossierPartId);
	}

	/**
	* Returns the external app url of this process step.
	*
	* @return the external app url of this process step
	*/
	@Override
	public java.lang.String getExternalAppUrl() {
		return _processStep.getExternalAppUrl();
	}

	/**
	* Sets the external app url of this process step.
	*
	* @param externalAppUrl the external app url of this process step
	*/
	@Override
	public void setExternalAppUrl(java.lang.String externalAppUrl) {
		_processStep.setExternalAppUrl(externalAppUrl);
	}

	@Override
	public boolean isNew() {
		return _processStep.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_processStep.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _processStep.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_processStep.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _processStep.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _processStep.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_processStep.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _processStep.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_processStep.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_processStep.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_processStep.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProcessStepWrapper((ProcessStep)_processStep.clone());
	}

	@Override
	public int compareTo(org.opencps.processmgt.model.ProcessStep processStep) {
		return _processStep.compareTo(processStep);
	}

	@Override
	public int hashCode() {
		return _processStep.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ProcessStep> toCacheModel() {
		return _processStep.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ProcessStep toEscapedModel() {
		return new ProcessStepWrapper(_processStep.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ProcessStep toUnescapedModel() {
		return new ProcessStepWrapper(_processStep.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _processStep.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _processStep.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_processStep.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessStepWrapper)) {
			return false;
		}

		ProcessStepWrapper processStepWrapper = (ProcessStepWrapper)obj;

		if (Validator.equals(_processStep, processStepWrapper._processStep)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProcessStep getWrappedProcessStep() {
		return _processStep;
	}

	@Override
	public ProcessStep getWrappedModel() {
		return _processStep;
	}

	@Override
	public void resetOriginalValues() {
		_processStep.resetOriginalValues();
	}

	private ProcessStep _processStep;
}