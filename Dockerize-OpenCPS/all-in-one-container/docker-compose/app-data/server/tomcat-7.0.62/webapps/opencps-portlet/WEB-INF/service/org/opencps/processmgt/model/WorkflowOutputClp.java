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
import org.opencps.processmgt.service.WorkflowOutputLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class WorkflowOutputClp extends BaseModelImpl<WorkflowOutput>
	implements WorkflowOutput {
	public WorkflowOutputClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return WorkflowOutput.class;
	}

	@Override
	public String getModelClassName() {
		return WorkflowOutput.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _workflowOutputId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setWorkflowOutputId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _workflowOutputId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workflowOutputId", getWorkflowOutputId());
		attributes.put("processWorkflowId", getProcessWorkflowId());
		attributes.put("dossierPartId", getDossierPartId());
		attributes.put("required", getRequired());
		attributes.put("esign", getEsign());
		attributes.put("postback", getPostback());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long workflowOutputId = (Long)attributes.get("workflowOutputId");

		if (workflowOutputId != null) {
			setWorkflowOutputId(workflowOutputId);
		}

		Long processWorkflowId = (Long)attributes.get("processWorkflowId");

		if (processWorkflowId != null) {
			setProcessWorkflowId(processWorkflowId);
		}

		Long dossierPartId = (Long)attributes.get("dossierPartId");

		if (dossierPartId != null) {
			setDossierPartId(dossierPartId);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}

		Boolean esign = (Boolean)attributes.get("esign");

		if (esign != null) {
			setEsign(esign);
		}

		Boolean postback = (Boolean)attributes.get("postback");

		if (postback != null) {
			setPostback(postback);
		}
	}

	@Override
	public long getWorkflowOutputId() {
		return _workflowOutputId;
	}

	@Override
	public void setWorkflowOutputId(long workflowOutputId) {
		_workflowOutputId = workflowOutputId;

		if (_workflowOutputRemoteModel != null) {
			try {
				Class<?> clazz = _workflowOutputRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkflowOutputId",
						long.class);

				method.invoke(_workflowOutputRemoteModel, workflowOutputId);
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

		if (_workflowOutputRemoteModel != null) {
			try {
				Class<?> clazz = _workflowOutputRemoteModel.getClass();

				Method method = clazz.getMethod("setProcessWorkflowId",
						long.class);

				method.invoke(_workflowOutputRemoteModel, processWorkflowId);
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

		if (_workflowOutputRemoteModel != null) {
			try {
				Class<?> clazz = _workflowOutputRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierPartId", long.class);

				method.invoke(_workflowOutputRemoteModel, dossierPartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getRequired() {
		return _required;
	}

	@Override
	public boolean isRequired() {
		return _required;
	}

	@Override
	public void setRequired(boolean required) {
		_required = required;

		if (_workflowOutputRemoteModel != null) {
			try {
				Class<?> clazz = _workflowOutputRemoteModel.getClass();

				Method method = clazz.getMethod("setRequired", boolean.class);

				method.invoke(_workflowOutputRemoteModel, required);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getEsign() {
		return _esign;
	}

	@Override
	public boolean isEsign() {
		return _esign;
	}

	@Override
	public void setEsign(boolean esign) {
		_esign = esign;

		if (_workflowOutputRemoteModel != null) {
			try {
				Class<?> clazz = _workflowOutputRemoteModel.getClass();

				Method method = clazz.getMethod("setEsign", boolean.class);

				method.invoke(_workflowOutputRemoteModel, esign);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPostback() {
		return _postback;
	}

	@Override
	public boolean isPostback() {
		return _postback;
	}

	@Override
	public void setPostback(boolean postback) {
		_postback = postback;

		if (_workflowOutputRemoteModel != null) {
			try {
				Class<?> clazz = _workflowOutputRemoteModel.getClass();

				Method method = clazz.getMethod("setPostback", boolean.class);

				method.invoke(_workflowOutputRemoteModel, postback);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getWorkflowOutputRemoteModel() {
		return _workflowOutputRemoteModel;
	}

	public void setWorkflowOutputRemoteModel(
		BaseModel<?> workflowOutputRemoteModel) {
		_workflowOutputRemoteModel = workflowOutputRemoteModel;
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

		Class<?> remoteModelClass = _workflowOutputRemoteModel.getClass();

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

		Object returnValue = method.invoke(_workflowOutputRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkflowOutputLocalServiceUtil.addWorkflowOutput(this);
		}
		else {
			WorkflowOutputLocalServiceUtil.updateWorkflowOutput(this);
		}
	}

	@Override
	public WorkflowOutput toEscapedModel() {
		return (WorkflowOutput)ProxyUtil.newProxyInstance(WorkflowOutput.class.getClassLoader(),
			new Class[] { WorkflowOutput.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		WorkflowOutputClp clone = new WorkflowOutputClp();

		clone.setWorkflowOutputId(getWorkflowOutputId());
		clone.setProcessWorkflowId(getProcessWorkflowId());
		clone.setDossierPartId(getDossierPartId());
		clone.setRequired(getRequired());
		clone.setEsign(getEsign());
		clone.setPostback(getPostback());

		return clone;
	}

	@Override
	public int compareTo(WorkflowOutput workflowOutput) {
		long primaryKey = workflowOutput.getPrimaryKey();

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

		if (!(obj instanceof WorkflowOutputClp)) {
			return false;
		}

		WorkflowOutputClp workflowOutput = (WorkflowOutputClp)obj;

		long primaryKey = workflowOutput.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{workflowOutputId=");
		sb.append(getWorkflowOutputId());
		sb.append(", processWorkflowId=");
		sb.append(getProcessWorkflowId());
		sb.append(", dossierPartId=");
		sb.append(getDossierPartId());
		sb.append(", required=");
		sb.append(getRequired());
		sb.append(", esign=");
		sb.append(getEsign());
		sb.append(", postback=");
		sb.append(getPostback());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.WorkflowOutput");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>workflowOutputId</column-name><column-value><![CDATA[");
		sb.append(getWorkflowOutputId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>processWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getProcessWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dossierPartId</column-name><column-value><![CDATA[");
		sb.append(getDossierPartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>required</column-name><column-value><![CDATA[");
		sb.append(getRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>esign</column-name><column-value><![CDATA[");
		sb.append(getEsign());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postback</column-name><column-value><![CDATA[");
		sb.append(getPostback());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _workflowOutputId;
	private long _processWorkflowId;
	private long _dossierPartId;
	private boolean _required;
	private boolean _esign;
	private boolean _postback;
	private BaseModel<?> _workflowOutputRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}