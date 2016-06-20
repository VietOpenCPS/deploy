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
 * This class is a wrapper for {@link ProcessWorkflow}.
 * </p>
 *
 * @author khoavd
 * @see ProcessWorkflow
 * @generated
 */
public class ProcessWorkflowWrapper implements ProcessWorkflow,
	ModelWrapper<ProcessWorkflow> {
	public ProcessWorkflowWrapper(ProcessWorkflow processWorkflow) {
		_processWorkflow = processWorkflow;
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessWorkflow.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessWorkflow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("processWorkflowId", getProcessWorkflowId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("preProcessStepId", getPreProcessStepId());
		attributes.put("postProcessStepId", getPostProcessStepId());
		attributes.put("autoEvent", getAutoEvent());
		attributes.put("actionName", getActionName());
		attributes.put("assignUser", getAssignUser());
		attributes.put("actionUserId", getActionUserId());
		attributes.put("requestPayment", getRequestPayment());
		attributes.put("paymentFee", getPaymentFee());
		attributes.put("generateReceptionNo", getGenerateReceptionNo());
		attributes.put("receptionNoPattern", getReceptionNoPattern());
		attributes.put("generateDeadline", getGenerateDeadline());
		attributes.put("deadlinePattern", getDeadlinePattern());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long processWorkflowId = (Long)attributes.get("processWorkflowId");

		if (processWorkflowId != null) {
			setProcessWorkflowId(processWorkflowId);
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

		Long preProcessStepId = (Long)attributes.get("preProcessStepId");

		if (preProcessStepId != null) {
			setPreProcessStepId(preProcessStepId);
		}

		Long postProcessStepId = (Long)attributes.get("postProcessStepId");

		if (postProcessStepId != null) {
			setPostProcessStepId(postProcessStepId);
		}

		String autoEvent = (String)attributes.get("autoEvent");

		if (autoEvent != null) {
			setAutoEvent(autoEvent);
		}

		String actionName = (String)attributes.get("actionName");

		if (actionName != null) {
			setActionName(actionName);
		}

		Boolean assignUser = (Boolean)attributes.get("assignUser");

		if (assignUser != null) {
			setAssignUser(assignUser);
		}

		Long actionUserId = (Long)attributes.get("actionUserId");

		if (actionUserId != null) {
			setActionUserId(actionUserId);
		}

		Boolean requestPayment = (Boolean)attributes.get("requestPayment");

		if (requestPayment != null) {
			setRequestPayment(requestPayment);
		}

		Double paymentFee = (Double)attributes.get("paymentFee");

		if (paymentFee != null) {
			setPaymentFee(paymentFee);
		}

		String generateReceptionNo = (String)attributes.get(
				"generateReceptionNo");

		if (generateReceptionNo != null) {
			setGenerateReceptionNo(generateReceptionNo);
		}

		String receptionNoPattern = (String)attributes.get("receptionNoPattern");

		if (receptionNoPattern != null) {
			setReceptionNoPattern(receptionNoPattern);
		}

		Boolean generateDeadline = (Boolean)attributes.get("generateDeadline");

		if (generateDeadline != null) {
			setGenerateDeadline(generateDeadline);
		}

		Boolean deadlinePattern = (Boolean)attributes.get("deadlinePattern");

		if (deadlinePattern != null) {
			setDeadlinePattern(deadlinePattern);
		}
	}

	/**
	* Returns the primary key of this process workflow.
	*
	* @return the primary key of this process workflow
	*/
	@Override
	public long getPrimaryKey() {
		return _processWorkflow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this process workflow.
	*
	* @param primaryKey the primary key of this process workflow
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_processWorkflow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the process workflow ID of this process workflow.
	*
	* @return the process workflow ID of this process workflow
	*/
	@Override
	public long getProcessWorkflowId() {
		return _processWorkflow.getProcessWorkflowId();
	}

	/**
	* Sets the process workflow ID of this process workflow.
	*
	* @param processWorkflowId the process workflow ID of this process workflow
	*/
	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflow.setProcessWorkflowId(processWorkflowId);
	}

	/**
	* Returns the company ID of this process workflow.
	*
	* @return the company ID of this process workflow
	*/
	@Override
	public long getCompanyId() {
		return _processWorkflow.getCompanyId();
	}

	/**
	* Sets the company ID of this process workflow.
	*
	* @param companyId the company ID of this process workflow
	*/
	@Override
	public void setCompanyId(long companyId) {
		_processWorkflow.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this process workflow.
	*
	* @return the group ID of this process workflow
	*/
	@Override
	public long getGroupId() {
		return _processWorkflow.getGroupId();
	}

	/**
	* Sets the group ID of this process workflow.
	*
	* @param groupId the group ID of this process workflow
	*/
	@Override
	public void setGroupId(long groupId) {
		_processWorkflow.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this process workflow.
	*
	* @return the user ID of this process workflow
	*/
	@Override
	public long getUserId() {
		return _processWorkflow.getUserId();
	}

	/**
	* Sets the user ID of this process workflow.
	*
	* @param userId the user ID of this process workflow
	*/
	@Override
	public void setUserId(long userId) {
		_processWorkflow.setUserId(userId);
	}

	/**
	* Returns the user uuid of this process workflow.
	*
	* @return the user uuid of this process workflow
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflow.getUserUuid();
	}

	/**
	* Sets the user uuid of this process workflow.
	*
	* @param userUuid the user uuid of this process workflow
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_processWorkflow.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this process workflow.
	*
	* @return the create date of this process workflow
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _processWorkflow.getCreateDate();
	}

	/**
	* Sets the create date of this process workflow.
	*
	* @param createDate the create date of this process workflow
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_processWorkflow.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this process workflow.
	*
	* @return the modified date of this process workflow
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _processWorkflow.getModifiedDate();
	}

	/**
	* Sets the modified date of this process workflow.
	*
	* @param modifiedDate the modified date of this process workflow
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_processWorkflow.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the service process ID of this process workflow.
	*
	* @return the service process ID of this process workflow
	*/
	@Override
	public long getServiceProcessId() {
		return _processWorkflow.getServiceProcessId();
	}

	/**
	* Sets the service process ID of this process workflow.
	*
	* @param serviceProcessId the service process ID of this process workflow
	*/
	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_processWorkflow.setServiceProcessId(serviceProcessId);
	}

	/**
	* Returns the pre process step ID of this process workflow.
	*
	* @return the pre process step ID of this process workflow
	*/
	@Override
	public long getPreProcessStepId() {
		return _processWorkflow.getPreProcessStepId();
	}

	/**
	* Sets the pre process step ID of this process workflow.
	*
	* @param preProcessStepId the pre process step ID of this process workflow
	*/
	@Override
	public void setPreProcessStepId(long preProcessStepId) {
		_processWorkflow.setPreProcessStepId(preProcessStepId);
	}

	/**
	* Returns the post process step ID of this process workflow.
	*
	* @return the post process step ID of this process workflow
	*/
	@Override
	public long getPostProcessStepId() {
		return _processWorkflow.getPostProcessStepId();
	}

	/**
	* Sets the post process step ID of this process workflow.
	*
	* @param postProcessStepId the post process step ID of this process workflow
	*/
	@Override
	public void setPostProcessStepId(long postProcessStepId) {
		_processWorkflow.setPostProcessStepId(postProcessStepId);
	}

	/**
	* Returns the auto event of this process workflow.
	*
	* @return the auto event of this process workflow
	*/
	@Override
	public java.lang.String getAutoEvent() {
		return _processWorkflow.getAutoEvent();
	}

	/**
	* Sets the auto event of this process workflow.
	*
	* @param autoEvent the auto event of this process workflow
	*/
	@Override
	public void setAutoEvent(java.lang.String autoEvent) {
		_processWorkflow.setAutoEvent(autoEvent);
	}

	/**
	* Returns the action name of this process workflow.
	*
	* @return the action name of this process workflow
	*/
	@Override
	public java.lang.String getActionName() {
		return _processWorkflow.getActionName();
	}

	/**
	* Sets the action name of this process workflow.
	*
	* @param actionName the action name of this process workflow
	*/
	@Override
	public void setActionName(java.lang.String actionName) {
		_processWorkflow.setActionName(actionName);
	}

	/**
	* Returns the assign user of this process workflow.
	*
	* @return the assign user of this process workflow
	*/
	@Override
	public boolean getAssignUser() {
		return _processWorkflow.getAssignUser();
	}

	/**
	* Returns <code>true</code> if this process workflow is assign user.
	*
	* @return <code>true</code> if this process workflow is assign user; <code>false</code> otherwise
	*/
	@Override
	public boolean isAssignUser() {
		return _processWorkflow.isAssignUser();
	}

	/**
	* Sets whether this process workflow is assign user.
	*
	* @param assignUser the assign user of this process workflow
	*/
	@Override
	public void setAssignUser(boolean assignUser) {
		_processWorkflow.setAssignUser(assignUser);
	}

	/**
	* Returns the action user ID of this process workflow.
	*
	* @return the action user ID of this process workflow
	*/
	@Override
	public long getActionUserId() {
		return _processWorkflow.getActionUserId();
	}

	/**
	* Sets the action user ID of this process workflow.
	*
	* @param actionUserId the action user ID of this process workflow
	*/
	@Override
	public void setActionUserId(long actionUserId) {
		_processWorkflow.setActionUserId(actionUserId);
	}

	/**
	* Returns the action user uuid of this process workflow.
	*
	* @return the action user uuid of this process workflow
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getActionUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _processWorkflow.getActionUserUuid();
	}

	/**
	* Sets the action user uuid of this process workflow.
	*
	* @param actionUserUuid the action user uuid of this process workflow
	*/
	@Override
	public void setActionUserUuid(java.lang.String actionUserUuid) {
		_processWorkflow.setActionUserUuid(actionUserUuid);
	}

	/**
	* Returns the request payment of this process workflow.
	*
	* @return the request payment of this process workflow
	*/
	@Override
	public boolean getRequestPayment() {
		return _processWorkflow.getRequestPayment();
	}

	/**
	* Returns <code>true</code> if this process workflow is request payment.
	*
	* @return <code>true</code> if this process workflow is request payment; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequestPayment() {
		return _processWorkflow.isRequestPayment();
	}

	/**
	* Sets whether this process workflow is request payment.
	*
	* @param requestPayment the request payment of this process workflow
	*/
	@Override
	public void setRequestPayment(boolean requestPayment) {
		_processWorkflow.setRequestPayment(requestPayment);
	}

	/**
	* Returns the payment fee of this process workflow.
	*
	* @return the payment fee of this process workflow
	*/
	@Override
	public double getPaymentFee() {
		return _processWorkflow.getPaymentFee();
	}

	/**
	* Sets the payment fee of this process workflow.
	*
	* @param paymentFee the payment fee of this process workflow
	*/
	@Override
	public void setPaymentFee(double paymentFee) {
		_processWorkflow.setPaymentFee(paymentFee);
	}

	/**
	* Returns the generate reception no of this process workflow.
	*
	* @return the generate reception no of this process workflow
	*/
	@Override
	public java.lang.String getGenerateReceptionNo() {
		return _processWorkflow.getGenerateReceptionNo();
	}

	/**
	* Sets the generate reception no of this process workflow.
	*
	* @param generateReceptionNo the generate reception no of this process workflow
	*/
	@Override
	public void setGenerateReceptionNo(java.lang.String generateReceptionNo) {
		_processWorkflow.setGenerateReceptionNo(generateReceptionNo);
	}

	/**
	* Returns the reception no pattern of this process workflow.
	*
	* @return the reception no pattern of this process workflow
	*/
	@Override
	public java.lang.String getReceptionNoPattern() {
		return _processWorkflow.getReceptionNoPattern();
	}

	/**
	* Sets the reception no pattern of this process workflow.
	*
	* @param receptionNoPattern the reception no pattern of this process workflow
	*/
	@Override
	public void setReceptionNoPattern(java.lang.String receptionNoPattern) {
		_processWorkflow.setReceptionNoPattern(receptionNoPattern);
	}

	/**
	* Returns the generate deadline of this process workflow.
	*
	* @return the generate deadline of this process workflow
	*/
	@Override
	public boolean getGenerateDeadline() {
		return _processWorkflow.getGenerateDeadline();
	}

	/**
	* Returns <code>true</code> if this process workflow is generate deadline.
	*
	* @return <code>true</code> if this process workflow is generate deadline; <code>false</code> otherwise
	*/
	@Override
	public boolean isGenerateDeadline() {
		return _processWorkflow.isGenerateDeadline();
	}

	/**
	* Sets whether this process workflow is generate deadline.
	*
	* @param generateDeadline the generate deadline of this process workflow
	*/
	@Override
	public void setGenerateDeadline(boolean generateDeadline) {
		_processWorkflow.setGenerateDeadline(generateDeadline);
	}

	/**
	* Returns the deadline pattern of this process workflow.
	*
	* @return the deadline pattern of this process workflow
	*/
	@Override
	public boolean getDeadlinePattern() {
		return _processWorkflow.getDeadlinePattern();
	}

	/**
	* Returns <code>true</code> if this process workflow is deadline pattern.
	*
	* @return <code>true</code> if this process workflow is deadline pattern; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeadlinePattern() {
		return _processWorkflow.isDeadlinePattern();
	}

	/**
	* Sets whether this process workflow is deadline pattern.
	*
	* @param deadlinePattern the deadline pattern of this process workflow
	*/
	@Override
	public void setDeadlinePattern(boolean deadlinePattern) {
		_processWorkflow.setDeadlinePattern(deadlinePattern);
	}

	@Override
	public boolean isNew() {
		return _processWorkflow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_processWorkflow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _processWorkflow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_processWorkflow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _processWorkflow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _processWorkflow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_processWorkflow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _processWorkflow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_processWorkflow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_processWorkflow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_processWorkflow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProcessWorkflowWrapper((ProcessWorkflow)_processWorkflow.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.ProcessWorkflow processWorkflow) {
		return _processWorkflow.compareTo(processWorkflow);
	}

	@Override
	public int hashCode() {
		return _processWorkflow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ProcessWorkflow> toCacheModel() {
		return _processWorkflow.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ProcessWorkflow toEscapedModel() {
		return new ProcessWorkflowWrapper(_processWorkflow.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ProcessWorkflow toUnescapedModel() {
		return new ProcessWorkflowWrapper(_processWorkflow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _processWorkflow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _processWorkflow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_processWorkflow.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessWorkflowWrapper)) {
			return false;
		}

		ProcessWorkflowWrapper processWorkflowWrapper = (ProcessWorkflowWrapper)obj;

		if (Validator.equals(_processWorkflow,
					processWorkflowWrapper._processWorkflow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProcessWorkflow getWrappedProcessWorkflow() {
		return _processWorkflow;
	}

	@Override
	public ProcessWorkflow getWrappedModel() {
		return _processWorkflow;
	}

	@Override
	public void resetOriginalValues() {
		_processWorkflow.resetOriginalValues();
	}

	private ProcessWorkflow _processWorkflow;
}