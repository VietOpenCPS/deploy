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
import org.opencps.processmgt.service.ServiceInfoProcessLocalServiceUtil;
import org.opencps.processmgt.service.persistence.ServiceInfoProcessPK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ServiceInfoProcessClp extends BaseModelImpl<ServiceInfoProcess>
	implements ServiceInfoProcess {
	public ServiceInfoProcessClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceInfoProcess.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceInfoProcess.class.getName();
	}

	@Override
	public ServiceInfoProcessPK getPrimaryKey() {
		return new ServiceInfoProcessPK(_serviceProcessId, _serviceinfoId);
	}

	@Override
	public void setPrimaryKey(ServiceInfoProcessPK primaryKey) {
		setServiceProcessId(primaryKey.serviceProcessId);
		setServiceinfoId(primaryKey.serviceinfoId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ServiceInfoProcessPK(_serviceProcessId, _serviceinfoId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ServiceInfoProcessPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceProcessId", getServiceProcessId());
		attributes.put("serviceinfoId", getServiceinfoId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceProcessId = (Long)attributes.get("serviceProcessId");

		if (serviceProcessId != null) {
			setServiceProcessId(serviceProcessId);
		}

		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
		}
	}

	@Override
	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	@Override
	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;

		if (_serviceInfoProcessRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceProcessId",
						long.class);

				method.invoke(_serviceInfoProcessRemoteModel, serviceProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;

		if (_serviceInfoProcessRemoteModel != null) {
			try {
				Class<?> clazz = _serviceInfoProcessRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceinfoId", long.class);

				method.invoke(_serviceInfoProcessRemoteModel, serviceinfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getServiceInfoProcessRemoteModel() {
		return _serviceInfoProcessRemoteModel;
	}

	public void setServiceInfoProcessRemoteModel(
		BaseModel<?> serviceInfoProcessRemoteModel) {
		_serviceInfoProcessRemoteModel = serviceInfoProcessRemoteModel;
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

		Class<?> remoteModelClass = _serviceInfoProcessRemoteModel.getClass();

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

		Object returnValue = method.invoke(_serviceInfoProcessRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceInfoProcessLocalServiceUtil.addServiceInfoProcess(this);
		}
		else {
			ServiceInfoProcessLocalServiceUtil.updateServiceInfoProcess(this);
		}
	}

	@Override
	public ServiceInfoProcess toEscapedModel() {
		return (ServiceInfoProcess)ProxyUtil.newProxyInstance(ServiceInfoProcess.class.getClassLoader(),
			new Class[] { ServiceInfoProcess.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceInfoProcessClp clone = new ServiceInfoProcessClp();

		clone.setServiceProcessId(getServiceProcessId());
		clone.setServiceinfoId(getServiceinfoId());

		return clone;
	}

	@Override
	public int compareTo(ServiceInfoProcess serviceInfoProcess) {
		ServiceInfoProcessPK primaryKey = serviceInfoProcess.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceInfoProcessClp)) {
			return false;
		}

		ServiceInfoProcessClp serviceInfoProcess = (ServiceInfoProcessClp)obj;

		ServiceInfoProcessPK primaryKey = serviceInfoProcess.getPrimaryKey();

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

		sb.append("{serviceProcessId=");
		sb.append(getServiceProcessId());
		sb.append(", serviceinfoId=");
		sb.append(getServiceinfoId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.opencps.processmgt.model.ServiceInfoProcess");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serviceProcessId</column-name><column-value><![CDATA[");
		sb.append(getServiceProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>serviceinfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceinfoId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _serviceProcessId;
	private long _serviceinfoId;
	private BaseModel<?> _serviceInfoProcessRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.processmgt.service.ClpSerializer.class;
}