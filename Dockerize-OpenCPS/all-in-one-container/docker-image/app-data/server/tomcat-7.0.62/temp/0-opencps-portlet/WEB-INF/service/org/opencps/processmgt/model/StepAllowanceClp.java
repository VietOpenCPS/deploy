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

import org.opencps.processmgt.service.ClpSerializer;
import org.opencps.processmgt.service.StepAllowanceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class StepAllowanceClp extends BaseModelImpl<StepAllowance>
	implements StepAllowance {
	public StepAllowanceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StepAllowance.class;
	}

	@Override
	public String getModelClassName() {
		return StepAllowance.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stepAllowanceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStepAllowanceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stepAllowanceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stepAllowanceId", getStepAllowanceId());
		attributes.put("processStepId", getProcessStepId());
		attributes.put("roleId", getRoleId());
		attributes.put("readOnly", getReadOnly());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stepAllowanceId = (Long)attributes.get("stepAllowanceId");

		if (stepAllowanceId != null) {
			setStepAllowanceId(stepAllowanceId);
		}

		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Boolean readOnly = (Boolean)attributes.get("readOnly");

		if (readOnly != null) {
			setReadOnly(readOnly);
		}
	}

	@Override
	public long getStepAllowanceId() {
		return _stepAllowanceId;
	}

	@Override
	public void setStepAllowanceId(long stepAllowanceId) {
		_stepAllowanceId = stepAllowanceId;

		if (_stepAllowanceRemoteModel != null) {
			try {
				Class<?> clazz = _stepAllowanceRemoteModel.getClass();

				Method method = clazz.getMethod("setStepAllowanceId", long.class);

				method.invoke(_stepAllowanceRemoteModel, stepAllowanceId);
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

		if (_stepAllowanceRemoteModel != null) {
			try {
				Class<?> clazz = _stepAllowanceRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessStepId", long.class);

				method.invoke(_stepAllowanceRemoteModel, processStepId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_stepAllowanceRemoteModel != null) {
			try {
				Class<?> clazz = _stepAllowanceRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_stepAllowanceRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getReadOnly() {
		return _readOnly;
	}

	@Override
	public boolean isReadOnly() {
		return _readOnly;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		_readOnly = readOnly;

		if (_stepAllowanceRemoteModel != null) {
			try {
				Class<?> clazz = _stepAllowanceRemoteModel.getClass();

				Method method = clazz.getMethod("setReadOnly", boolean.class);

				method.invoke(_stepAllowanceRemoteModel, readOnly);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStepAllowanceRemoteModel() {
		return _stepAllowanceRemoteModel;
	}

	public void setStepAllowanceRemoteModel(
		BaseModel<?> stepAllowanceRemoteModel) {
		_stepAllowanceRemoteModel = stepAllowanceRemoteModel;
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

		Class<?> remoteModelClass = _stepAllowanceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_stepAllowanceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StepAllowanceLocalServiceUtil.addStepAllowance(this);
		}
		else {
			StepAllowanceLocalServiceUtil.updateStepAllowance(this);
		}
	}

	@Override
	public StepAllowance toEscapedModel() {
		return (StepAllowance)ProxyUtil.newProxyInstance(StepAllowance.class.getClassLoader(),
			new Class[] { StepAllowance.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StepAllowanceClp clone = new StepAllowanceClp();

		clone.setStepAllowanceId(getStepAllowanceId());
		clone.setProcessStepId(getProcessStepId());
		clone.setRoleId(getRoleId());
		clone.setReadOnly(getReadOnly());

		return clone;
	}

	@Override
	public int compareTo(StepAllowance stepAllowance) {
		long primaryKey = stepAllowance.getPrimaryKey();

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

		if (!(obj instanceof StepAllowanceClp)) {
			return false;
		}

		StepAllowanceClp stepAllowance = (StepAllowanceClp)obj;

		long primaryKey = stepAllowance.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{stepAllowanceId=");
		sb.append(getStepAllowanceId());
		sb.append(", processStepId=");
		sb.append(getProcessStepId());
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", readOnly=");
		sb.append(getReadOnly());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.StepAllowance");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stepAllowanceId</column-name><column-value><![CDATA[");
		sb.append(getStepAllowanceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processStepId</column-name><column-value><![CDATA[");
		sb.append(getProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>readOnly</column-name><column-value><![CDATA[");
		sb.append(getReadOnly());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stepAllowanceId;
	private long _processStepId;
	private long _roleId;
	private boolean _readOnly;
	private BaseModel<?> _stepAllowanceRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}