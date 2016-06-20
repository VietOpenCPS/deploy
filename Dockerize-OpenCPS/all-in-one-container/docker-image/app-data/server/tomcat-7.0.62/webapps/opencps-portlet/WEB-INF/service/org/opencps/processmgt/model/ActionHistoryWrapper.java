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
 * This class is a wrapper for {@link ActionHistory}.
 * </p>
 *
 * @author khoavd
 * @see ActionHistory
 * @generated
 */
public class ActionHistoryWrapper implements ActionHistory,
	ModelWrapper<ActionHistory> {
	public ActionHistoryWrapper(ActionHistory actionHistory) {
		_actionHistory = actionHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return ActionHistory.class;
	}

	@Override
	public String getModelClassName() {
		return ActionHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionHistoryId", getActionHistoryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("processOrderId", getProcessOrderId());
		attributes.put("processWorkflowId", getProcessWorkflowId());
		attributes.put("actionDatetime", getActionDatetime());
		attributes.put("stepName", getStepName());
		attributes.put("actionName", getActionName());
		attributes.put("actionNote", getActionNote());
		attributes.put("actionUserId", getActionUserId());
		attributes.put("daysDoing", getDaysDoing());
		attributes.put("daysDelay", getDaysDelay());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long actionHistoryId = (Long)attributes.get("actionHistoryId");

		if (actionHistoryId != null) {
			setActionHistoryId(actionHistoryId);
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

		Long processOrderId = (Long)attributes.get("processOrderId");

		if (processOrderId != null) {
			setProcessOrderId(processOrderId);
		}

		Long processWorkflowId = (Long)attributes.get("processWorkflowId");

		if (processWorkflowId != null) {
			setProcessWorkflowId(processWorkflowId);
		}

		Date actionDatetime = (Date)attributes.get("actionDatetime");

		if (actionDatetime != null) {
			setActionDatetime(actionDatetime);
		}

		String stepName = (String)attributes.get("stepName");

		if (stepName != null) {
			setStepName(stepName);
		}

		String actionName = (String)attributes.get("actionName");

		if (actionName != null) {
			setActionName(actionName);
		}

		String actionNote = (String)attributes.get("actionNote");

		if (actionNote != null) {
			setActionNote(actionNote);
		}

		Long actionUserId = (Long)attributes.get("actionUserId");

		if (actionUserId != null) {
			setActionUserId(actionUserId);
		}

		Integer daysDoing = (Integer)attributes.get("daysDoing");

		if (daysDoing != null) {
			setDaysDoing(daysDoing);
		}

		Integer daysDelay = (Integer)attributes.get("daysDelay");

		if (daysDelay != null) {
			setDaysDelay(daysDelay);
		}
	}

	/**
	* Returns the primary key of this action history.
	*
	* @return the primary key of this action history
	*/
	@Override
	public long getPrimaryKey() {
		return _actionHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this action history.
	*
	* @param primaryKey the primary key of this action history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_actionHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the action history ID of this action history.
	*
	* @return the action history ID of this action history
	*/
	@Override
	public long getActionHistoryId() {
		return _actionHistory.getActionHistoryId();
	}

	/**
	* Sets the action history ID of this action history.
	*
	* @param actionHistoryId the action history ID of this action history
	*/
	@Override
	public void setActionHistoryId(long actionHistoryId) {
		_actionHistory.setActionHistoryId(actionHistoryId);
	}

	/**
	* Returns the company ID of this action history.
	*
	* @return the company ID of this action history
	*/
	@Override
	public long getCompanyId() {
		return _actionHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this action history.
	*
	* @param companyId the company ID of this action history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_actionHistory.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this action history.
	*
	* @return the group ID of this action history
	*/
	@Override
	public long getGroupId() {
		return _actionHistory.getGroupId();
	}

	/**
	* Sets the group ID of this action history.
	*
	* @param groupId the group ID of this action history
	*/
	@Override
	public void setGroupId(long groupId) {
		_actionHistory.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this action history.
	*
	* @return the user ID of this action history
	*/
	@Override
	public long getUserId() {
		return _actionHistory.getUserId();
	}

	/**
	* Sets the user ID of this action history.
	*
	* @param userId the user ID of this action history
	*/
	@Override
	public void setUserId(long userId) {
		_actionHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this action history.
	*
	* @return the user uuid of this action history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _actionHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this action history.
	*
	* @param userUuid the user uuid of this action history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_actionHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this action history.
	*
	* @return the create date of this action history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _actionHistory.getCreateDate();
	}

	/**
	* Sets the create date of this action history.
	*
	* @param createDate the create date of this action history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_actionHistory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this action history.
	*
	* @return the modified date of this action history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _actionHistory.getModifiedDate();
	}

	/**
	* Sets the modified date of this action history.
	*
	* @param modifiedDate the modified date of this action history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_actionHistory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the process order ID of this action history.
	*
	* @return the process order ID of this action history
	*/
	@Override
	public long getProcessOrderId() {
		return _actionHistory.getProcessOrderId();
	}

	/**
	* Sets the process order ID of this action history.
	*
	* @param processOrderId the process order ID of this action history
	*/
	@Override
	public void setProcessOrderId(long processOrderId) {
		_actionHistory.setProcessOrderId(processOrderId);
	}

	/**
	* Returns the process workflow ID of this action history.
	*
	* @return the process workflow ID of this action history
	*/
	@Override
	public long getProcessWorkflowId() {
		return _actionHistory.getProcessWorkflowId();
	}

	/**
	* Sets the process workflow ID of this action history.
	*
	* @param processWorkflowId the process workflow ID of this action history
	*/
	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_actionHistory.setProcessWorkflowId(processWorkflowId);
	}

	/**
	* Returns the action datetime of this action history.
	*
	* @return the action datetime of this action history
	*/
	@Override
	public java.util.Date getActionDatetime() {
		return _actionHistory.getActionDatetime();
	}

	/**
	* Sets the action datetime of this action history.
	*
	* @param actionDatetime the action datetime of this action history
	*/
	@Override
	public void setActionDatetime(java.util.Date actionDatetime) {
		_actionHistory.setActionDatetime(actionDatetime);
	}

	/**
	* Returns the step name of this action history.
	*
	* @return the step name of this action history
	*/
	@Override
	public java.lang.String getStepName() {
		return _actionHistory.getStepName();
	}

	/**
	* Sets the step name of this action history.
	*
	* @param stepName the step name of this action history
	*/
	@Override
	public void setStepName(java.lang.String stepName) {
		_actionHistory.setStepName(stepName);
	}

	/**
	* Returns the action name of this action history.
	*
	* @return the action name of this action history
	*/
	@Override
	public java.lang.String getActionName() {
		return _actionHistory.getActionName();
	}

	/**
	* Sets the action name of this action history.
	*
	* @param actionName the action name of this action history
	*/
	@Override
	public void setActionName(java.lang.String actionName) {
		_actionHistory.setActionName(actionName);
	}

	/**
	* Returns the action note of this action history.
	*
	* @return the action note of this action history
	*/
	@Override
	public java.lang.String getActionNote() {
		return _actionHistory.getActionNote();
	}

	/**
	* Sets the action note of this action history.
	*
	* @param actionNote the action note of this action history
	*/
	@Override
	public void setActionNote(java.lang.String actionNote) {
		_actionHistory.setActionNote(actionNote);
	}

	/**
	* Returns the action user ID of this action history.
	*
	* @return the action user ID of this action history
	*/
	@Override
	public long getActionUserId() {
		return _actionHistory.getActionUserId();
	}

	/**
	* Sets the action user ID of this action history.
	*
	* @param actionUserId the action user ID of this action history
	*/
	@Override
	public void setActionUserId(long actionUserId) {
		_actionHistory.setActionUserId(actionUserId);
	}

	/**
	* Returns the action user uuid of this action history.
	*
	* @return the action user uuid of this action history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getActionUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _actionHistory.getActionUserUuid();
	}

	/**
	* Sets the action user uuid of this action history.
	*
	* @param actionUserUuid the action user uuid of this action history
	*/
	@Override
	public void setActionUserUuid(java.lang.String actionUserUuid) {
		_actionHistory.setActionUserUuid(actionUserUuid);
	}

	/**
	* Returns the days doing of this action history.
	*
	* @return the days doing of this action history
	*/
	@Override
	public int getDaysDoing() {
		return _actionHistory.getDaysDoing();
	}

	/**
	* Sets the days doing of this action history.
	*
	* @param daysDoing the days doing of this action history
	*/
	@Override
	public void setDaysDoing(int daysDoing) {
		_actionHistory.setDaysDoing(daysDoing);
	}

	/**
	* Returns the days delay of this action history.
	*
	* @return the days delay of this action history
	*/
	@Override
	public int getDaysDelay() {
		return _actionHistory.getDaysDelay();
	}

	/**
	* Sets the days delay of this action history.
	*
	* @param daysDelay the days delay of this action history
	*/
	@Override
	public void setDaysDelay(int daysDelay) {
		_actionHistory.setDaysDelay(daysDelay);
	}

	@Override
	public boolean isNew() {
		return _actionHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_actionHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _actionHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_actionHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _actionHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _actionHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_actionHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _actionHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_actionHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_actionHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_actionHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ActionHistoryWrapper((ActionHistory)_actionHistory.clone());
	}

	@Override
	public int compareTo(
		org.opencps.processmgt.model.ActionHistory actionHistory) {
		return _actionHistory.compareTo(actionHistory);
	}

	@Override
	public int hashCode() {
		return _actionHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.processmgt.model.ActionHistory> toCacheModel() {
		return _actionHistory.toCacheModel();
	}

	@Override
	public org.opencps.processmgt.model.ActionHistory toEscapedModel() {
		return new ActionHistoryWrapper(_actionHistory.toEscapedModel());
	}

	@Override
	public org.opencps.processmgt.model.ActionHistory toUnescapedModel() {
		return new ActionHistoryWrapper(_actionHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _actionHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _actionHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_actionHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActionHistoryWrapper)) {
			return false;
		}

		ActionHistoryWrapper actionHistoryWrapper = (ActionHistoryWrapper)obj;

		if (Validator.equals(_actionHistory, actionHistoryWrapper._actionHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ActionHistory getWrappedActionHistory() {
		return _actionHistory;
	}

	@Override
	public ActionHistory getWrappedModel() {
		return _actionHistory;
	}

	@Override
	public void resetOriginalValues() {
		_actionHistory.resetOriginalValues();
	}

	private ActionHistory _actionHistory;
}