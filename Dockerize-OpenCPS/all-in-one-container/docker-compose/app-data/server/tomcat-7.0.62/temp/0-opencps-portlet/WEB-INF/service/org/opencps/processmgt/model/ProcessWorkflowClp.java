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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.processmgt.service.ClpSerializer;
import org.opencps.processmgt.service.ProcessWorkflowLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ProcessWorkflowClp extends BaseModelImpl<ProcessWorkflow>
	implements ProcessWorkflow {
	public ProcessWorkflowClp() {
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
	public long getPrimaryKey() {
		return _processWorkflowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcessWorkflowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _processWorkflowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessWorkflowId",
						long.class);

				method.invoke(_processWorkflowRemoteModel, processWorkflowId);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_processWorkflowRemoteModel, companyId);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_processWorkflowRemoteModel, groupId);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_processWorkflowRemoteModel, userId);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_processWorkflowRemoteModel, createDate);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_processWorkflowRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceProcessId",
						long.class);

				method.invoke(_processWorkflowRemoteModel, serviceProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPreProcessStepId() {
		return _preProcessStepId;
	}

	@Override
	public void setPreProcessStepId(long preProcessStepId) {
		_preProcessStepId = preProcessStepId;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setPreProcessStepId",
						long.class);

				method.invoke(_processWorkflowRemoteModel, preProcessStepId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPostProcessStepId() {
		return _postProcessStepId;
	}

	@Override
	public void setPostProcessStepId(long postProcessStepId) {
		_postProcessStepId = postProcessStepId;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setPostProcessStepId",
						long.class);

				method.invoke(_processWorkflowRemoteModel, postProcessStepId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAutoEvent() {
		return _autoEvent;
	}

	@Override
	public void setAutoEvent(String autoEvent) {
		_autoEvent = autoEvent;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setAutoEvent", String.class);

				method.invoke(_processWorkflowRemoteModel, autoEvent);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setActionName", String.class);

				method.invoke(_processWorkflowRemoteModel, actionName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAssignUser() {
		return _assignUser;
	}

	@Override
	public boolean isAssignUser() {
		return _assignUser;
	}

	@Override
	public void setAssignUser(boolean assignUser) {
		_assignUser = assignUser;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignUser", boolean.class);

				method.invoke(_processWorkflowRemoteModel, assignUser);
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

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setActionUserId", long.class);

				method.invoke(_processWorkflowRemoteModel, actionUserId);
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
	public boolean getRequestPayment() {
		return _requestPayment;
	}

	@Override
	public boolean isRequestPayment() {
		return _requestPayment;
	}

	@Override
	public void setRequestPayment(boolean requestPayment) {
		_requestPayment = requestPayment;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setRequestPayment",
						boolean.class);

				method.invoke(_processWorkflowRemoteModel, requestPayment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPaymentFee() {
		return _paymentFee;
	}

	@Override
	public void setPaymentFee(double paymentFee) {
		_paymentFee = paymentFee;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setPaymentFee", double.class);

				method.invoke(_processWorkflowRemoteModel, paymentFee);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGenerateReceptionNo() {
		return _generateReceptionNo;
	}

	@Override
	public void setGenerateReceptionNo(String generateReceptionNo) {
		_generateReceptionNo = generateReceptionNo;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setGenerateReceptionNo",
						String.class);

				method.invoke(_processWorkflowRemoteModel, generateReceptionNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReceptionNoPattern() {
		return _receptionNoPattern;
	}

	@Override
	public void setReceptionNoPattern(String receptionNoPattern) {
		_receptionNoPattern = receptionNoPattern;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setReceptionNoPattern",
						String.class);

				method.invoke(_processWorkflowRemoteModel, receptionNoPattern);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getGenerateDeadline() {
		return _generateDeadline;
	}

	@Override
	public boolean isGenerateDeadline() {
		return _generateDeadline;
	}

	@Override
	public void setGenerateDeadline(boolean generateDeadline) {
		_generateDeadline = generateDeadline;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setGenerateDeadline",
						boolean.class);

				method.invoke(_processWorkflowRemoteModel, generateDeadline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeadlinePattern() {
		return _deadlinePattern;
	}

	@Override
	public boolean isDeadlinePattern() {
		return _deadlinePattern;
	}

	@Override
	public void setDeadlinePattern(boolean deadlinePattern) {
		_deadlinePattern = deadlinePattern;

		if (_processWorkflowRemoteModel != null) {
			try {
				Class<?> clazz = _processWorkflowRemoteModel.getClass();

				Method method = clazz.getMethod("setDeadlinePattern",
						boolean.class);

				method.invoke(_processWorkflowRemoteModel, deadlinePattern);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProcessWorkflowRemoteModel() {
		return _processWorkflowRemoteModel;
	}

	public void setProcessWorkflowRemoteModel(
		BaseModel<?> processWorkflowRemoteModel) {
		_processWorkflowRemoteModel = processWorkflowRemoteModel;
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

		Class<?> remoteModelClass = _processWorkflowRemoteModel.getClass();

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

		Object returnValue = method.invoke(_processWorkflowRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProcessWorkflowLocalServiceUtil.addProcessWorkflow(this);
		}
		else {
			ProcessWorkflowLocalServiceUtil.updateProcessWorkflow(this);
		}
	}

	@Override
	public ProcessWorkflow toEscapedModel() {
		return (ProcessWorkflow)ProxyUtil.newProxyInstance(ProcessWorkflow.class.getClassLoader(),
			new Class[] { ProcessWorkflow.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProcessWorkflowClp clone = new ProcessWorkflowClp();

		clone.setProcessWorkflowId(getProcessWorkflowId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setServiceProcessId(getServiceProcessId());
		clone.setPreProcessStepId(getPreProcessStepId());
		clone.setPostProcessStepId(getPostProcessStepId());
		clone.setAutoEvent(getAutoEvent());
		clone.setActionName(getActionName());
		clone.setAssignUser(getAssignUser());
		clone.setActionUserId(getActionUserId());
		clone.setRequestPayment(getRequestPayment());
		clone.setPaymentFee(getPaymentFee());
		clone.setGenerateReceptionNo(getGenerateReceptionNo());
		clone.setReceptionNoPattern(getReceptionNoPattern());
		clone.setGenerateDeadline(getGenerateDeadline());
		clone.setDeadlinePattern(getDeadlinePattern());

		return clone;
	}

	@Override
	public int compareTo(ProcessWorkflow processWorkflow) {
		long primaryKey = processWorkflow.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessWorkflowClp)) {
			return false;
		}

		ProcessWorkflowClp processWorkflow = (ProcessWorkflowClp)obj;

		long primaryKey = processWorkflow.getPrimaryKey();

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
		StringBundler sb = new StringBundler(39);

		sb.append("{processWorkflowId=");
		sb.append(getProcessWorkflowId());
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
		sb.append(", serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", preProcessStepId=");
		sb.append(getPreProcessStepId());
		sb.append(", postProcessStepId=");
		sb.append(getPostProcessStepId());
		sb.append(", autoEvent=");
		sb.append(getAutoEvent());
		sb.append(", actionName=");
		sb.append(getActionName());
		sb.append(", assignUser=");
		sb.append(getAssignUser());
		sb.append(", actionUserId=");
		sb.append(getActionUserId());
		sb.append(", requestPayment=");
		sb.append(getRequestPayment());
		sb.append(", paymentFee=");
		sb.append(getPaymentFee());
		sb.append(", generateReceptionNo=");
		sb.append(getGenerateReceptionNo());
		sb.append(", receptionNoPattern=");
		sb.append(getReceptionNoPattern());
		sb.append(", generateDeadline=");
		sb.append(getGenerateDeadline());
		sb.append(", deadlinePattern=");
		sb.append(getDeadlinePattern());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ProcessWorkflow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getProcessWorkflowId());
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
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>preProcessStepId</column-name><column-value><![CDATA[");
		sb.append(getPreProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postProcessStepId</column-name><column-value><![CDATA[");
		sb.append(getPostProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autoEvent</column-name><column-value><![CDATA[");
		sb.append(getAutoEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionName</column-name><column-value><![CDATA[");
		sb.append(getActionName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignUser</column-name><column-value><![CDATA[");
		sb.append(getAssignUser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionUserId</column-name><column-value><![CDATA[");
		sb.append(getActionUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requestPayment</column-name><column-value><![CDATA[");
		sb.append(getRequestPayment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>paymentFee</column-name><column-value><![CDATA[");
		sb.append(getPaymentFee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generateReceptionNo</column-name><column-value><![CDATA[");
		sb.append(getGenerateReceptionNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>receptionNoPattern</column-name><column-value><![CDATA[");
		sb.append(getReceptionNoPattern());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generateDeadline</column-name><column-value><![CDATA[");
		sb.append(getGenerateDeadline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deadlinePattern</column-name><column-value><![CDATA[");
		sb.append(getDeadlinePattern());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _processWorkflowId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceProcessId;
	private long _preProcessStepId;
	private long _postProcessStepId;
	private String _autoEvent;
	private String _actionName;
	private boolean _assignUser;
	private long _actionUserId;
	private String _actionUserUuid;
	private boolean _requestPayment;
	private double _paymentFee;
	private String _generateReceptionNo;
	private String _receptionNoPattern;
	private boolean _generateDeadline;
	private boolean _deadlinePattern;
	private BaseModel<?> _processWorkflowRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}