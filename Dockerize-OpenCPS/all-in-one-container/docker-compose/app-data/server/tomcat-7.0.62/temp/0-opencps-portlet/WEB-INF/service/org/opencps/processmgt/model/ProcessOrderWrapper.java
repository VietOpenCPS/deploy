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
 * This class is a wrapper for {@link ProcessOrder}.
 * </p>
 *
 * @author khoavd
 * @see ProcessOrder
 * @generated
 */
public class ProcessOrderWrapper implements ProcessOrder,
	ModelWrapper<ProcessOrder> {
	public ProcessOrderWrapper(ProcessOrder processOrder) {
		_processOrder = processOrder;
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessOrder.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessOrder.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("processOrderId", getProcessOrderId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceInfoId", getServiceInfoId());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("govAgencyCode", getGovAgencyCode());
		attributes.put("govAgencyName", getGovAgencyName());
		attributes.put("govAgencyOrganizationId", getGovAgencyOrganizationId());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("dossierId", getDossierId());
		attributes.put("fileGroupId", getFileGroupId());
		attributes.put("processStepId", getProcessStepId());
		attributes.put("actionUserId", getActionUserId());
		attributes.put("actionDatetime", getActionDatetime());
		attributes.put("actionNote", getActionNote());
		attributes.put("assignToUserId", getAssignToUserId());
		attributes.put("processWorkflowId", getProcessWorkflowId());
		attributes.put("dossierStatus", getDossierStatus());
		attributes.put("errorInfo", getErrorInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long processOrderId = (Long)attributes.get("processOrderId");

		if (processOrderId != null) {
			setProcessOrderId(processOrderId);
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

		Long serviceInfoId = (Long)attributes.get("serviceInfoId");

		if (serviceInfoId != null) {
			setServiceInfoId(serviceInfoId);
		}

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		String govAgencyCode = (String)attributes.get("govAgencyCode");

		if (govAgencyCode != null) {
			setGovAgencyCode(govAgencyCode);
		}

		String govAgencyName = (String)attributes.get("govAgencyName");

		if (govAgencyName != null) {
			setGovAgencyName(govAgencyName);
		}

		Long govAgencyOrganizationId = (Long)attributes.get(
				"govAgencyOrganizationId");

		if (govAgencyOrganizationId != null) {
			setGovAgencyOrganizationId(govAgencyOrganizationId);
		}

		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		Long dossierId = (Long)attributes.get("dossierId");

		if (dossierId != null) {
			setDossierId(dossierId);
		}

		Long fileGroupId = (Long)attributes.get("fileGroupId");

		if (fileGroupId != null) {
			setFileGroupId(fileGroupId);
		}

		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long actionUserId = (Long)attributes.get("actionUserId");

		if (actionUserId != null) {
			setActionUserId(actionUserId);
		}

		Date actionDatetime = (Date)attributes.get("actionDatetime");

		if (actionDatetime != null) {
			setActionDatetime(actionDatetime);
		}

		String actionNote = (String)attributes.get("actionNote");

		if (actionNote != null) {
			setActionNote(actionNote);
		}

		Long assignToUserId = (Long)attributes.get("assignToUserId");

		if (assignToUserId != null) {
			setAssignToUserId(assignToUserId);
		}

		Long processWorkflowId = (Long)attributes.get("processWorkflowId");

		if (processWorkflowId != null) {
			setProcessWorkflowId(processWorkflowId);
		}

		Integer dossierStatus = (Integer)attributes.get("dossierStatus");

		if (dossierStatus != null) {
			setDossierStatus(dossierStatus);
		}

		String errorInfo = (String)attributes.get("errorInfo");

		if (errorInfo != null) {
			setErrorInfo(errorInfo);
		}
	}

	/**
	* Returns the primary key of this process order.
	*
	* @return the primary key of this process order
	*/
	@Override
	public long getPrimaryKey() {
		return _processOrder.getPrimaryKey();
	}

	/**
	* Sets the primary key of this process order.
	*
	* @param primaryKey the primary key of this process order
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_processOrder.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the process order ID of this process order.
	*
	* @return the process order ID of this process order
	*/
	@Override
	public long getProcessOrderId() {
		return _processOrder.getProcessOrderId();
	}

	/**
	* Sets the process order ID of this process order.
	*
	* @param processOrderId the process order ID of this process order
	*/
	@Override
	public void setProcessOrderId(long processOrderId) {
		_processOrder.setProcessOrderId(processOrderId);
	}

	/**
	* Returns the company ID of this process order.
	*
	* @return the company ID of this process order
	*/
	@Override
	public long getCompanyId() {
		return _processOrder.getCompanyId();
	}

	/**
	* Sets the company ID of this process order.
	*
	* @param companyId the company ID of this process order
	*/
	@Override
	public void setCompanyId(long companyId) {
		_processOrder.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this process order.
	*
	* @return the group ID of this process order
	*/
	@Override
	public long getGroupId() {
		return _processOrder.getGroupId();
	}

	/**
	* Sets the group ID of this process order.
	*
	* @param groupId the group ID of this process order
	*/
	@Override
	public void setGroupId(long groupId) {
		_processOrder.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this process order.
	*
	* @return the user ID of this process order
	*/
	@Override
	public long getUserId() {
		return _processOrder.getUserId();
	}

	/**
	* Sets the user ID of this process order.
	*
	* @param userId the user ID of this process order
	*/
	@Override
	public void setUserId(long userId) {
		_processOrder.setUserId(userId);
	}

	/**
	* Returns the user uuid of this process order.
	*
	* @return the user uuid of this process order
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrder.getUserUuid();
	}

	/**
	* Sets the user uuid of this process order.
	*
	* @param userUuid the user uuid of this process order
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_processOrder.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this process order.
	*
	* @return the create date of this process order
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _processOrder.getCreateDate();
	}

	/**
	* Sets the create date of this process order.
	*
	* @param createDate the create date of this process order
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_processOrder.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this process order.
	*
	* @return the modified date of this process order
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _processOrder.getModifiedDate();
	}

	/**
	* Sets the modified date of this process order.
	*
	* @param modifiedDate the modified date of this process order
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_processOrder.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the service info ID of this process order.
	*
	* @return the service info ID of this process order
	*/
	@Override
	public long getServiceInfoId() {
		return _processOrder.getServiceInfoId();
	}

	/**
	* Sets the service info ID of this process order.
	*
	* @param serviceInfoId the service info ID of this process order
	*/
	@Override
	public void setServiceInfoId(long serviceInfoId) {
		_processOrder.setServiceInfoId(serviceInfoId);
	}

	/**
	* Returns the dossier template ID of this process order.
	*
	* @return the dossier template ID of this process order
	*/
	@Override
	public long getDossierTemplateId() {
		return _processOrder.getDossierTemplateId();
	}

	/**
	* Sets the dossier template ID of this process order.
	*
	* @param dossierTemplateId the dossier template ID of this process order
	*/
	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_processOrder.setDossierTemplateId(dossierTemplateId);
	}

	/**
	* Returns the gov agency code of this process order.
	*
	* @return the gov agency code of this process order
	*/
	@Override
	public java.lang.String getGovAgencyCode() {
		return _processOrder.getGovAgencyCode();
	}

	/**
	* Sets the gov agency code of this process order.
	*
	* @param govAgencyCode the gov agency code of this process order
	*/
	@Override
	public void setGovAgencyCode(java.lang.String govAgencyCode) {
		_processOrder.setGovAgencyCode(govAgencyCode);
	}

	/**
	* Returns the gov agency name of this process order.
	*
	* @return the gov agency name of this process order
	*/
	@Override
	public java.lang.String getGovAgencyName() {
		return _processOrder.getGovAgencyName();
	}

	/**
	* Sets the gov agency name of this process order.
	*
	* @param govAgencyName the gov agency name of this process order
	*/
	@Override
	public void setGovAgencyName(java.lang.String govAgencyName) {
		_processOrder.setGovAgencyName(govAgencyName);
	}

	/**
	* Returns the gov agency organization ID of this process order.
	*
	* @return the gov agency organization ID of this process order
	*/
	@Override
	public long getGovAgencyOrganizationId() {
		return _processOrder.getGovAgencyOrganizationId();
	}

	/**
	* Sets the gov agency organization ID of this process order.
	*
	* @param govAgencyOrganizationId the gov agency organization ID of this process order
	*/
	@Override
	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_processOrder.setGovAgencyOrganizationId(govAgencyOrganizationId);
	}

	/**
	* Returns the service process ID of this process order.
	*
	* @return the service process ID of this process order
	*/
	@Override
	public long getServiceProcessId() {
		return _processOrder.getServiceProcessId();
	}

	/**
	* Sets the service process ID of this process order.
	*
	* @param serviceProcessId the service process ID of this process order
	*/
	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_processOrder.setServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the dossier ID of this process order.
	*
	* @return the dossier ID of this process order
	*/
	@Override
	public long getDossierId() {
		return _processOrder.getDossierId();
	}

	/**
	* Sets the dossier ID of this process order.
	*
	* @param dossierId the dossier ID of this process order
	*/
	@Override
	public void setDossierId(long dossierId) {
		_processOrder.setDossierId(dossierId);
	}

	/**
	* Returns the file group ID of this process order.
	*
	* @return the file group ID of this process order
	*/
	@Override
	public long getFileGroupId() {
		return _processOrder.getFileGroupId();
	}

	/**
	* Sets the file group ID of this process order.
	*
	* @param fileGroupId the file group ID of this process order
	*/
	@Override
	public void setFileGroupId(long fileGroupId) {
		_processOrder.setFileGroupId(fileGroupId);
	}

	/**
	* Returns the process step ID of this process order.
	*
	* @return the process step ID of this process order
	*/
	@Override
	public long getProcessStepId() {
		return _processOrder.getProcessStepId();
	}

	/**
	* Sets the process step ID of this process order.
	*
	* @param processStepId the process step ID of this process order
	*/
	@Override
	public void setProcessStepId(long processStepId) {
		_processOrder.setProcessStepId(processStepId);
	}

	/**
	* Returns the action user ID of this process order.
	*
	* @return the action user ID of this process order
	*/
	@Override
	public long getActionUserId() {
		return _processOrder.getActionUserId();
	}

	/**
	* Sets the action user ID of this process order.
	*
	* @param actionUserId the action user ID of this process order
	*/
	@Override
	public void setActionUserId(long actionUserId) {
		_processOrder.setActionUserId(actionUserId);
	}

	/**
	* Returns the action user uuid of this process order.
	*
	* @return the action user uuid of this process order
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getActionUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrder.getActionUserUuid();
	}

	/**
	* Sets the action user uuid of this process order.
	*
	* @param actionUserUuid the action user uuid of this process order
	*/
	@Override
	public void setActionUserUuid(java.lang.String actionUserUuid) {
		_processOrder.setActionUserUuid(actionUserUuid);
	}

	/**
	* Returns the action datetime of this process order.
	*
	* @return the action datetime of this process order
	*/
	@Override
	public java.util.Date getActionDatetime() {
		return _processOrder.getActionDatetime();
	}

	/**
	* Sets the action datetime of this process order.
	*
	* @param actionDatetime the action datetime of this process order
	*/
	@Override
	public void setActionDatetime(java.util.Date actionDatetime) {
		_processOrder.setActionDatetime(actionDatetime);
	}

	/**
	* Returns the action note of this process order.
	*
	* @return the action note of this process order
	*/
	@Override
	public java.lang.String getActionNote() {
		return _processOrder.getActionNote();
	}

	/**
	* Sets the action note of this process order.
	*
	* @param actionNote the action note of this process order
	*/
	@Override
	public void setActionNote(java.lang.String actionNote) {
		_processOrder.setActionNote(actionNote);
	}

	/**
	* Returns the assign to user ID of this process order.
	*
	* @return the assign to user ID of this process order
	*/
	@Override
	public long getAssignToUserId() {
		return _processOrder.getAssignToUserId();
	}

	/**
	* Sets the assign to user ID of this process order.
	*
	* @param assignToUserId the assign to user ID of this process order
	*/
	@Override
	public void setAssignToUserId(long assignToUserId) {
		_processOrder.setAssignToUserId(assignToUserId);
	}

	/**
	* Returns the assign to user uuid of this process order.
	*
	* @return the assign to user uuid of this process order
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getAssignToUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processOrder.getAssignToUserUuid();
	}

	/**
	* Sets the assign to user uuid of this process order.
	*
	* @param assignToUserUuid the assign to user uuid of this process order
	*/
	@Override
	public void setAssignToUserUuid(java.lang.String assignToUserUuid) {
		_processOrder.setAssignToUserUuid(assignToUserUuid);
	}

	/**
	* Returns the process workflow ID of this process order.
	*
	* @return the process workflow ID of this process order
	*/
	@Override
	public long getProcessWorkflowId() {
		return _processOrder.getProcessWorkflowId();
	}

	/**
	* Sets the process workflow ID of this process order.
	*
	* @param processWorkflowId the process workflow ID of this process order
	*/
	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_processOrder.setProcessWorkflowId(processWorkflowId);
	}

	/**
	* Returns the dossier status of this process order.
	*
	* @return the dossier status of this process order
	*/
	@Override
	public int getDossierStatus() {
		return _processOrder.getDossierStatus();
	}

	/**
	* Sets the dossier status of this process order.
	*
	* @param dossierStatus the dossier status of this process order
	*/
	@Override
	public void setDossierStatus(int dossierStatus) {
		_processOrder.setDossierStatus(dossierStatus);
	}

	/**
	* Returns the error info of this process order.
	*
	* @return the error info of this process order
	*/
	@Override
	public java.lang.String getErrorInfo() {
		return _processOrder.getErrorInfo();
	}

	/**
	* Sets the error info of this process order.
	*
	* @param errorInfo the error info of this process order
	*/
	@Override
	public void setErrorInfo(java.lang.String errorInfo) {
		_processOrder.setErrorInfo(errorInfo);
	}

	@Override
	public boolean isNew() {
		return _processOrder.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_processOrder.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _processOrder.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_processOrder.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _processOrder.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _processOrder.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_processOrder.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _processOrder.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_processOrder.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_processOrder.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_processOrder.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProcessOrderWrapper((ProcessOrder)_processOrder.clone());
	}

	@Override
	public int compareTo(org.opencps.processmgt.model.ProcessOrder processOrder) {
		return _processOrder.compareTo(processOrder);
	}

	@Override
	public int hashCode() {
		return _processOrder.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ProcessOrder> toCacheModel() {
		return _processOrder.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder toEscapedModel() {
		return new ProcessOrderWrapper(_processOrder.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ProcessOrder toUnescapedModel() {
		return new ProcessOrderWrapper(_processOrder.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _processOrder.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _processOrder.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_processOrder.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessOrderWrapper)) {
			return false;
		}

		ProcessOrderWrapper processOrderWrapper = (ProcessOrderWrapper)obj;

		if (Validator.equals(_processOrder, processOrderWrapper._processOrder)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProcessOrder getWrappedProcessOrder() {
		return _processOrder;
	}

	@Override
	public ProcessOrder getWrappedModel() {
		return _processOrder;
	}

	@Override
	public void resetOriginalValues() {
		_processOrder.resetOriginalValues();
	}

	private ProcessOrder _processOrder;
}