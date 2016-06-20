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
import org.opencps.processmgt.service.ProcessStepLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ProcessStepClp extends BaseModelImpl<ProcessStep>
	implements ProcessStep {
	public ProcessStepClp() {
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
	public long getPrimaryKey() {
		return _processStepId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProcessStepId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _processStepId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getProcessStepId() {
		return _processStepId;
	}

	@Override
	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessStepId", long.class);

				method.invoke(_processStepRemoteModel, processStepId);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_processStepRemoteModel, companyId);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_processStepRemoteModel, groupId);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_processStepRemoteModel, userId);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_processStepRemoteModel, createDate);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_processStepRemoteModel, modifiedDate);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceProcessId",
						long.class);

				method.invoke(_processStepRemoteModel, serviceProcessId);
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

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setStepName", String.class);

				method.invoke(_processStepRemoteModel, stepName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSequenceNo() {
		return _sequenceNo;
	}

	@Override
	public void setSequenceNo(int sequenceNo) {
		_sequenceNo = sequenceNo;

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setSequenceNo", int.class);

				method.invoke(_processStepRemoteModel, sequenceNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDossierStatus() {
		return _dossierStatus;
	}

	@Override
	public void setDossierStatus(String dossierStatus) {
		_dossierStatus = dossierStatus;

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierStatus", String.class);

				method.invoke(_processStepRemoteModel, dossierStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getDaysDuration() {
		return _daysDuration;
	}

	@Override
	public void setDaysDuration(int daysDuration) {
		_daysDuration = daysDuration;

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setDaysDuration", int.class);

				method.invoke(_processStepRemoteModel, daysDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getReferenceDossierPartId() {
		return _referenceDossierPartId;
	}

	@Override
	public void setReferenceDossierPartId(long referenceDossierPartId) {
		_referenceDossierPartId = referenceDossierPartId;

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setReferenceDossierPartId",
						long.class);

				method.invoke(_processStepRemoteModel, referenceDossierPartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExternalAppUrl() {
		return _externalAppUrl;
	}

	@Override
	public void setExternalAppUrl(String externalAppUrl) {
		_externalAppUrl = externalAppUrl;

		if (_processStepRemoteModel != null) {
			try {
				Class<?> clazz = _processStepRemoteModel.getClass();

				Method method = clazz.getMethod("setExternalAppUrl",
						String.class);

				method.invoke(_processStepRemoteModel, externalAppUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProcessStepRemoteModel() {
		return _processStepRemoteModel;
	}

	public void setProcessStepRemoteModel(BaseModel<?> processStepRemoteModel) {
		_processStepRemoteModel = processStepRemoteModel;
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

		Class<?> remoteModelClass = _processStepRemoteModel.getClass();

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

		Object returnValue = method.invoke(_processStepRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProcessStepLocalServiceUtil.addProcessStep(this);
		}
		else {
			ProcessStepLocalServiceUtil.updateProcessStep(this);
		}
	}

	@Override
	public ProcessStep toEscapedModel() {
		return (ProcessStep)ProxyUtil.newProxyInstance(ProcessStep.class.getClassLoader(),
			new Class[] { ProcessStep.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProcessStepClp clone = new ProcessStepClp();

		clone.setProcessStepId(getProcessStepId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setServiceProcessId(getServiceProcessId());
		clone.setStepName(getStepName());
		clone.setSequenceNo(getSequenceNo());
		clone.setDossierStatus(getDossierStatus());
		clone.setDaysDuration(getDaysDuration());
		clone.setReferenceDossierPartId(getReferenceDossierPartId());
		clone.setExternalAppUrl(getExternalAppUrl());

		return clone;
	}

	@Override
	public int compareTo(ProcessStep processStep) {
		int value = 0;

		if (getSequenceNo() < processStep.getSequenceNo()) {
			value = -1;
		}
		else if (getSequenceNo() > processStep.getSequenceNo()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ProcessStepClp)) {
			return false;
		}

		ProcessStepClp processStep = (ProcessStepClp)obj;

		long primaryKey = processStep.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{processStepId=");
		sb.append(getProcessStepId());
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
		sb.append(", stepName=");
		sb.append(getStepName());
		sb.append(", sequenceNo=");
		sb.append(getSequenceNo());
		sb.append(", dossierStatus=");
		sb.append(getDossierStatus());
		sb.append(", daysDuration=");
		sb.append(getDaysDuration());
		sb.append(", referenceDossierPartId=");
		sb.append(getReferenceDossierPartId());
		sb.append(", externalAppUrl=");
		sb.append(getExternalAppUrl());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ProcessStep");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processStepId</column-name><column-value><![CDATA[");
		sb.append(getProcessStepId());
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
			"<column><column-name>stepName</column-name><column-value><![CDATA[");
		sb.append(getStepName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sequenceNo</column-name><column-value><![CDATA[");
		sb.append(getSequenceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierStatus</column-name><column-value><![CDATA[");
		sb.append(getDossierStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>daysDuration</column-name><column-value><![CDATA[");
		sb.append(getDaysDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referenceDossierPartId</column-name><column-value><![CDATA[");
		sb.append(getReferenceDossierPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>externalAppUrl</column-name><column-value><![CDATA[");
		sb.append(getExternalAppUrl());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _processStepId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceProcessId;
	private String _stepName;
	private int _sequenceNo;
	private String _dossierStatus;
	private int _daysDuration;
	private long _referenceDossierPartId;
	private String _externalAppUrl;
	private BaseModel<?> _processStepRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}