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
import org.opencps.processmgt.service.ProcessOrderLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ProcessOrderClp extends BaseModelImpl<ProcessOrder>
	implements ProcessOrder {
	public ProcessOrderClp() {
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
	public long getPrimaryKey() {
		return _processOrderId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcessOrderId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _processOrderId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getProcessOrderId() {
		return _processOrderId;
	}

	@Override
	public void setProcessOrderId(long processOrderId) {
		_processOrderId = processOrderId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessOrderId", long.class);

				method.invoke(_processOrderRemoteModel, processOrderId);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_processOrderRemoteModel, companyId);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_processOrderRemoteModel, groupId);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_processOrderRemoteModel, userId);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_processOrderRemoteModel, createDate);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_processOrderRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceInfoId() {
		return _serviceInfoId;
	}

	@Override
	public void setServiceInfoId(long serviceInfoId) {
		_serviceInfoId = serviceInfoId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceInfoId", long.class);

				method.invoke(_processOrderRemoteModel, serviceInfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	@Override
	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierTemplateId",
						long.class);

				method.invoke(_processOrderRemoteModel, dossierTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGovAgencyCode() {
		return _govAgencyCode;
	}

	@Override
	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyCode", String.class);

				method.invoke(_processOrderRemoteModel, govAgencyCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGovAgencyName() {
		return _govAgencyName;
	}

	@Override
	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyName", String.class);

				method.invoke(_processOrderRemoteModel, govAgencyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGovAgencyOrganizationId() {
		return _govAgencyOrganizationId;
	}

	@Override
	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_govAgencyOrganizationId = govAgencyOrganizationId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setGovAgencyOrganizationId",
						long.class);

				method.invoke(_processOrderRemoteModel, govAgencyOrganizationId);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceProcessId",
						long.class);

				method.invoke(_processOrderRemoteModel, serviceProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDossierId() {
		return _dossierId;
	}

	@Override
	public void setDossierId(long dossierId) {
		_dossierId = dossierId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierId", long.class);

				method.invoke(_processOrderRemoteModel, dossierId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileGroupId() {
		return _fileGroupId;
	}

	@Override
	public void setFileGroupId(long fileGroupId) {
		_fileGroupId = fileGroupId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setFileGroupId", long.class);

				method.invoke(_processOrderRemoteModel, fileGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProcessStepId() {
		return _processStepId;
	}

	@Override
	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessStepId", long.class);

				method.invoke(_processOrderRemoteModel, processStepId);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setActionUserId", long.class);

				method.invoke(_processOrderRemoteModel, actionUserId);
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
	public Date getActionDatetime() {
		return _actionDatetime;
	}

	@Override
	public void setActionDatetime(Date actionDatetime) {
		_actionDatetime = actionDatetime;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setActionDatetime", Date.class);

				method.invoke(_processOrderRemoteModel, actionDatetime);
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

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setActionNote", String.class);

				method.invoke(_processOrderRemoteModel, actionNote);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssignToUserId() {
		return _assignToUserId;
	}

	@Override
	public void setAssignToUserId(long assignToUserId) {
		_assignToUserId = assignToUserId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setAssignToUserId", long.class);

				method.invoke(_processOrderRemoteModel, assignToUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAssignToUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAssignToUserId(), "uuid",
			_assignToUserUuid);
	}

	@Override
	public void setAssignToUserUuid(String assignToUserUuid) {
		_assignToUserUuid = assignToUserUuid;
	}

	@Override
	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	@Override
	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessWorkflowId",
						long.class);

				method.invoke(_processOrderRemoteModel, processWorkflowId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDossierStatus() {
		return _dossierStatus;
	}

	@Override
	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierStatus", int.class);

				method.invoke(_processOrderRemoteModel, dossierStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrorInfo() {
		return _errorInfo;
	}

	@Override
	public void setErrorInfo(String errorInfo) {
		_errorInfo = errorInfo;

		if (_processOrderRemoteModel != null) {
			try {
				Class<?> clazz = _processOrderRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorInfo", String.class);

				method.invoke(_processOrderRemoteModel, errorInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProcessOrderRemoteModel() {
		return _processOrderRemoteModel;
	}

	public void setProcessOrderRemoteModel(BaseModel<?> processOrderRemoteModel) {
		_processOrderRemoteModel = processOrderRemoteModel;
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

		Class<?> remoteModelClass = _processOrderRemoteModel.getClass();

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

		Object returnValue = method.invoke(_processOrderRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProcessOrderLocalServiceUtil.addProcessOrder(this);
		}
		else {
			ProcessOrderLocalServiceUtil.updateProcessOrder(this);
		}
	}

	@Override
	public ProcessOrder toEscapedModel() {
		return (ProcessOrder)ProxyUtil.newProxyInstance(ProcessOrder.class.getClassLoader(),
			new Class[] { ProcessOrder.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProcessOrderClp clone = new ProcessOrderClp();

		clone.setProcessOrderId(getProcessOrderId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setServiceInfoId(getServiceInfoId());
		clone.setDossierTemplateId(getDossierTemplateId());
		clone.setGovAgencyCode(getGovAgencyCode());
		clone.setGovAgencyName(getGovAgencyName());
		clone.setGovAgencyOrganizationId(getGovAgencyOrganizationId());
		clone.setServiceProcessId(getServiceProcessId());
		clone.setDossierId(getDossierId());
		clone.setFileGroupId(getFileGroupId());
		clone.setProcessStepId(getProcessStepId());
		clone.setActionUserId(getActionUserId());
		clone.setActionDatetime(getActionDatetime());
		clone.setActionNote(getActionNote());
		clone.setAssignToUserId(getAssignToUserId());
		clone.setProcessWorkflowId(getProcessWorkflowId());
		clone.setDossierStatus(getDossierStatus());
		clone.setErrorInfo(getErrorInfo());

		return clone;
	}

	@Override
	public int compareTo(ProcessOrder processOrder) {
		long primaryKey = processOrder.getPrimaryKey();

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

		if (!(obj instanceof ProcessOrderClp)) {
			return false;
		}

		ProcessOrderClp processOrder = (ProcessOrderClp)obj;

		long primaryKey = processOrder.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{processOrderId=");
		sb.append(getProcessOrderId());
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
		sb.append(", serviceInfoId=");
		sb.append(getServiceInfoId());
		sb.append(", dossierTemplateId=");
		sb.append(getDossierTemplateId());
		sb.append(", govAgencyCode=");
		sb.append(getGovAgencyCode());
		sb.append(", govAgencyName=");
		sb.append(getGovAgencyName());
		sb.append(", govAgencyOrganizationId=");
		sb.append(getGovAgencyOrganizationId());
		sb.append(", serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", dossierId=");
		sb.append(getDossierId());
		sb.append(", fileGroupId=");
		sb.append(getFileGroupId());
		sb.append(", processStepId=");
		sb.append(getProcessStepId());
		sb.append(", actionUserId=");
		sb.append(getActionUserId());
		sb.append(", actionDatetime=");
		sb.append(getActionDatetime());
		sb.append(", actionNote=");
		sb.append(getActionNote());
		sb.append(", assignToUserId=");
		sb.append(getAssignToUserId());
		sb.append(", processWorkflowId=");
		sb.append(getProcessWorkflowId());
		sb.append(", dossierStatus=");
		sb.append(getDossierStatus());
		sb.append(", errorInfo=");
		sb.append(getErrorInfo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ProcessOrder");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processOrderId</column-name><column-value><![CDATA[");
		sb.append(getProcessOrderId());
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
			"<column><column-name>serviceInfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDossierTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyCode</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyName</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>govAgencyOrganizationId</column-name><column-value><![CDATA[");
		sb.append(getGovAgencyOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierId</column-name><column-value><![CDATA[");
		sb.append(getDossierId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileGroupId</column-name><column-value><![CDATA[");
		sb.append(getFileGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processStepId</column-name><column-value><![CDATA[");
		sb.append(getProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionUserId</column-name><column-value><![CDATA[");
		sb.append(getActionUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionDatetime</column-name><column-value><![CDATA[");
		sb.append(getActionDatetime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionNote</column-name><column-value><![CDATA[");
		sb.append(getActionNote());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assignToUserId</column-name><column-value><![CDATA[");
		sb.append(getAssignToUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getProcessWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorInfo</column-name><column-value><![CDATA[");
		sb.append(getErrorInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _processOrderId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceInfoId;
	private long _dossierTemplateId;
	private String _govAgencyCode;
	private String _govAgencyName;
	private long _govAgencyOrganizationId;
	private long _serviceProcessId;
	private long _dossierId;
	private long _fileGroupId;
	private long _processStepId;
	private long _actionUserId;
	private String _actionUserUuid;
	private Date _actionDatetime;
	private String _actionNote;
	private long _assignToUserId;
	private String _assignToUserUuid;
	private long _processWorkflowId;
	private int _dossierStatus;
	private String _errorInfo;
	private BaseModel<?> _processOrderRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}