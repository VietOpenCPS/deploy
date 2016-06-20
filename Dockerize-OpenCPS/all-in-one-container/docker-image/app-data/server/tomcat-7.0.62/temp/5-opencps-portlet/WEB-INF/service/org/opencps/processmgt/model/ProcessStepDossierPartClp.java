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
import org.opencps.processmgt.service.ProcessStepDossierPartLocalServiceUtil;
import org.opencps.processmgt.service.persistence.ProcessStepDossierPartPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ProcessStepDossierPartClp extends BaseModelImpl<ProcessStepDossierPart>
	implements ProcessStepDossierPart {
	public ProcessStepDossierPartClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProcessStepDossierPart.class;
	}

	@Override
	public String getModelClassName() {
		return ProcessStepDossierPart.class.getName();
	}

	@Override
	public ProcessStepDossierPartPK getPrimaryKey() {
		return new ProcessStepDossierPartPK(_processStepId, _dossierPartId);
	}

	@Override
	public void setPrimaryKey(ProcessStepDossierPartPK primaryKey) {
		setProcessStepId(primaryKey.processStepId);
		setDossierPartId(primaryKey.dossierPartId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ProcessStepDossierPartPK(_processStepId, _dossierPartId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ProcessStepDossierPartPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("processStepId", getProcessStepId());
		attributes.put("dossierPartId", getDossierPartId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long processStepId = (Long)attributes.get("processStepId");

		if (processStepId != null) {
			setProcessStepId(processStepId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}
	}

	@Override
	public long getProcessStepId() {
		return _processStepId;
	}

	@Override
	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;

		if (_processStepDossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _processStepDossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessStepId", long.class);

				method.invoke(_processStepDossierPartRemoteModel, processStepId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDossierPartId() {
		return _dossierPartId;
	}

	@Override
	public void setDossierPartId(long dossierPartId) {
		_dossierPartId = dossierPartId;

		if (_processStepDossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _processStepDossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierPartId", long.class);

				method.invoke(_processStepDossierPartRemoteModel, dossierPartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProcessStepDossierPartRemoteModel() {
		return _processStepDossierPartRemoteModel;
	}

	public void setProcessStepDossierPartRemoteModel(
		BaseModel<?> processStepDossierPartRemoteModel) {
		_processStepDossierPartRemoteModel = processStepDossierPartRemoteModel;
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

		Class<?> remoteModelClass = _processStepDossierPartRemoteModel.getClass();

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

		Object returnValue = method.invoke(_processStepDossierPartRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProcessStepDossierPartLocalServiceUtil.addProcessStepDossierPart(this);
		}
		else {
			ProcessStepDossierPartLocalServiceUtil.updateProcessStepDossierPart(this);
		}
	}

	@Override
	public ProcessStepDossierPart toEscapedModel() {
		return (ProcessStepDossierPart)ProxyUtil.newProxyInstance(ProcessStepDossierPart.class.getClassLoader(),
			new Class[] { ProcessStepDossierPart.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProcessStepDossierPartClp clone = new ProcessStepDossierPartClp();

		clone.setProcessStepId(getProcessStepId());
		clone.setDossierPartId(getDossierPartId());

		return clone;
	}

	@Override
	public int compareTo(ProcessStepDossierPart processStepDossierPart) {
		ProcessStepDossierPartPK primaryKey = processStepDossierPart.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProcessStepDossierPartClp)) {
			return false;
		}

		ProcessStepDossierPartClp processStepDossierPart = (ProcessStepDossierPartClp)obj;

		ProcessStepDossierPartPK primaryKey = processStepDossierPart.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
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
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{processStepId=");
		sb.append(getProcessStepId());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ProcessStepDossierPart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>processStepId</column-name><column-value><![CDATA[");
		sb.append(getProcessStepId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _processStepId;
	private long _dossierPartId;
	private BaseModel<?> _processStepDossierPartRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}