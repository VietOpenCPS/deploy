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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.processmgt.service.ActionHistoryLocalServiceUtil;
import org.opencps.processmgt.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ActionHistoryClp extends BaseModelImpl<ActionHistory>
	implements ActionHistory {
	public ActionHistoryClp() {
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
	public long getPrimaryKey() {
		return _actionHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setActionHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _actionHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getActionHistoryId() {
		return _actionHistoryId;
	}

	@Override
	public void setActionHistoryId(long actionHistoryId) {
		_actionHistoryId = actionHistoryId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActionHistoryId", long.class);

				method.invoke(_actionHistoryRemoteModel, actionHistoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_actionHistoryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_actionHistoryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_actionHistoryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_actionHistoryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_actionHistoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProcessOrderId() {
		return _processOrderId;
	}

	@Override
	public void setProcessOrderId(long processOrderId) {
		_processOrderId = processOrderId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessOrderId", long.class);

				method.invoke(_actionHistoryRemoteModel, processOrderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessWorkflowId",
						long.class);

				method.invoke(_actionHistoryRemoteModel, processWorkflowId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getActionDatetime() {
		return _actionDatetime;
	}

	@Override
	public void setActionDatetime(Date actionDatetime) {
		_actionDatetime = actionDatetime;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActionDatetime", Date.class);

				method.invoke(_actionHistoryRemoteModel, actionDatetime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStepName() {
		return _stepName;
	}

	@Override
	public void setStepName(String stepName) {
		_stepName = stepName;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStepName", String.class);

				method.invoke(_actionHistoryRemoteModel, stepName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionName() {
		return _actionName;
	}

	@Override
	public void setActionName(String actionName) {
		_actionName = actionName;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActionName", String.class);

				method.invoke(_actionHistoryRemoteModel, actionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionNote() {
		return _actionNote;
	}

	@Override
	public void setActionNote(String actionNote) {
		_actionNote = actionNote;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActionNote", String.class);

				method.invoke(_actionHistoryRemoteModel, actionNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getActionUserId() {
		return _actionUserId;
	}

	@Override
	public void setActionUserId(long actionUserId) {
		_actionUserId = actionUserId;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActionUserId", long.class);

				method.invoke(_actionHistoryRemoteModel, actionUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getActionUserId(), "uuid",
			_actionUserUuid);
	}

	@Override
	public void setActionUserUuid(String actionUserUuid) {
		_actionUserUuid = actionUserUuid;
	}

	@Override
	public int getDaysDoing() {
		return _daysDoing;
	}

	@Override
	public void setDaysDoing(int daysDoing) {
		_daysDoing = daysDoing;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDaysDoing", int.class);

				method.invoke(_actionHistoryRemoteModel, daysDoing);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDaysDelay() {
		return _daysDelay;
	}

	@Override
	public void setDaysDelay(int daysDelay) {
		_daysDelay = daysDelay;

		if (_actionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _actionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDaysDelay", int.class);

				method.invoke(_actionHistoryRemoteModel, daysDelay);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getActionHistoryRemoteModel() {
		return _actionHistoryRemoteModel;
	}

	public void setActionHistoryRemoteModel(
		BaseModel<?> actionHistoryRemoteModel) {
		_actionHistoryRemoteModel = actionHistoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _actionHistoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_actionHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ActionHistoryLocalServiceUtil.addActionHistory(this);
		}
		else {
			ActionHistoryLocalServiceUtil.updateActionHistory(this);
		}
	}

	@Override
	public ActionHistory toEscapedModel() {
		return (ActionHistory)ProxyUtil.newProxyInstance(ActionHistory.class.getClassLoader(),
			new Class[] { ActionHistory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ActionHistoryClp clone = new ActionHistoryClp();

		clone.setActionHistoryId(getActionHistoryId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setProcessOrderId(getProcessOrderId());
		clone.setProcessWorkflowId(getProcessWorkflowId());
		clone.setActionDatetime(getActionDatetime());
		clone.setStepName(getStepName());
		clone.setActionName(getActionName());
		clone.setActionNote(getActionNote());
		clone.setActionUserId(getActionUserId());
		clone.setDaysDoing(getDaysDoing());
		clone.setDaysDelay(getDaysDelay());

		return clone;
	}

	@Override
	public int compareTo(ActionHistory actionHistory) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				actionHistory.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActionHistoryClp)) {
			return false;
		}

		ActionHistoryClp actionHistory = (ActionHistoryClp)obj;

		long primaryKey = actionHistory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{actionHistoryId=");
		sb.append(getActionHistoryId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", processOrderId=");
		sb.append(getProcessOrderId());
		sb.append(", processWorkflowId=");
		sb.append(getProcessWorkflowId());
		sb.append(", actionDatetime=");
		sb.append(getActionDatetime());
		sb.append(", stepName=");
		sb.append(getStepName());
		sb.append(", actionName=");
		sb.append(getActionName());
		sb.append(", actionNote=");
		sb.append(getActionNote());
		sb.append(", actionUserId=");
		sb.append(getActionUserId());
		sb.append(", daysDoing=");
		sb.append(getDaysDoing());
		sb.append(", daysDelay=");
		sb.append(getDaysDelay());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ActionHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>actionHistoryId</column-name><column-value><![CDATA[");
		sb.append(getActionHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processOrderId</column-name><column-value><![CDATA[");
		sb.append(getProcessOrderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getProcessWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionDatetime</column-name><column-value><![CDATA[");
		sb.append(getActionDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stepName</column-name><column-value><![CDATA[");
		sb.append(getStepName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionName</column-name><column-value><![CDATA[");
		sb.append(getActionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionNote</column-name><column-value><![CDATA[");
		sb.append(getActionNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionUserId</column-name><column-value><![CDATA[");
		sb.append(getActionUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daysDoing</column-name><column-value><![CDATA[");
		sb.append(getDaysDoing());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daysDelay</column-name><column-value><![CDATA[");
		sb.append(getDaysDelay());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _actionHistoryId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _processOrderId;
	private long _processWorkflowId;
	private Date _actionDatetime;
	private String _stepName;
	private String _actionName;
	private String _actionNote;
	private long _actionUserId;
	private String _actionUserUuid;
	private int _daysDoing;
	private int _daysDelay;
	private BaseModel<?> _actionHistoryRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}