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

package org.opencps.servicemgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.opencps.servicemgt.service.ClpSerializer;
import org.opencps.servicemgt.service.ServiceFileTemplateLocalServiceUtil;
import org.opencps.servicemgt.service.persistence.ServiceFileTemplatePK;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class ServiceFileTemplateClp extends BaseModelImpl<ServiceFileTemplate>
	implements ServiceFileTemplate {
	public ServiceFileTemplateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ServiceFileTemplate.class;
	}

	@Override
	public String getModelClassName() {
		return ServiceFileTemplate.class.getName();
	}

	@Override
	public ServiceFileTemplatePK getPrimaryKey() {
		return new ServiceFileTemplatePK(_serviceinfoId, _templatefileId);
	}

	@Override
	public void setPrimaryKey(ServiceFileTemplatePK primaryKey) {
		setServiceinfoId(primaryKey.serviceinfoId);
		setTemplatefileId(primaryKey.templatefileId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new ServiceFileTemplatePK(_serviceinfoId, _templatefileId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((ServiceFileTemplatePK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceinfoId", getServiceinfoId());
		attributes.put("templatefileId", getTemplatefileId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceinfoId = (Long)attributes.get("serviceinfoId");

		if (serviceinfoId != null) {
			setServiceinfoId(serviceinfoId);
		}

		Long templatefileId = (Long)attributes.get("templatefileId");

		if (templatefileId != null) {
			setTemplatefileId(templatefileId);
		}
	}

	@Override
	public long getServiceinfoId() {
		return _serviceinfoId;
	}

	@Override
	public void setServiceinfoId(long serviceinfoId) {
		_serviceinfoId = serviceinfoId;

		if (_serviceFileTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serviceFileTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setServiceinfoId", long.class);

				method.invoke(_serviceFileTemplateRemoteModel, serviceinfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTemplatefileId() {
		return _templatefileId;
	}

	@Override
	public void setTemplatefileId(long templatefileId) {
		_templatefileId = templatefileId;

		if (_serviceFileTemplateRemoteModel != null) {
			try {
				Class<?> clazz = _serviceFileTemplateRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplatefileId", long.class);

				method.invoke(_serviceFileTemplateRemoteModel, templatefileId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getServiceFileTemplateRemoteModel() {
		return _serviceFileTemplateRemoteModel;
	}

	public void setServiceFileTemplateRemoteModel(
		BaseModel<?> serviceFileTemplateRemoteModel) {
		_serviceFileTemplateRemoteModel = serviceFileTemplateRemoteModel;
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

		Class<?> remoteModelClass = _serviceFileTemplateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_serviceFileTemplateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ServiceFileTemplateLocalServiceUtil.addServiceFileTemplate(this);
		}
		else {
			ServiceFileTemplateLocalServiceUtil.updateServiceFileTemplate(this);
		}
	}

	@Override
	public ServiceFileTemplate toEscapedModel() {
		return (ServiceFileTemplate)ProxyUtil.newProxyInstance(ServiceFileTemplate.class.getClassLoader(),
			new Class[] { ServiceFileTemplate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ServiceFileTemplateClp clone = new ServiceFileTemplateClp();

		clone.setServiceinfoId(getServiceinfoId());
		clone.setTemplatefileId(getTemplatefileId());

		return clone;
	}

	@Override
	public int compareTo(ServiceFileTemplate serviceFileTemplate) {
		ServiceFileTemplatePK primaryKey = serviceFileTemplate.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ServiceFileTemplateClp)) {
			return false;
		}

		ServiceFileTemplateClp serviceFileTemplate = (ServiceFileTemplateClp)obj;

		ServiceFileTemplatePK primaryKey = serviceFileTemplate.getPrimaryKey();

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

		sb.append("{serviceinfoId=");
		sb.append(getServiceinfoId());
		sb.append(", templatefileId=");
		sb.append(getTemplatefileId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("org.opencps.servicemgt.model.ServiceFileTemplate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>serviceinfoId</column-name><column-value><![CDATA[");
		sb.append(getServiceinfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templatefileId</column-name><column-value><![CDATA[");
		sb.append(getTemplatefileId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _serviceinfoId;
	private long _templatefileId;
	private BaseModel<?> _serviceFileTemplateRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.servicemgt.service.ClpSerializer.class;
}