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

package org.opencps.dossiermgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.dossiermgt.service.ClpSerializer;
import org.opencps.dossiermgt.service.DossierPartLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author trungnt
 */
public class DossierPartClp extends BaseModelImpl<DossierPart>
	implements DossierPart {
	public DossierPartClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DossierPart.class;
	}

	@Override
	public String getModelClassName() {
		return DossierPart.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _dossierpartId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDossierpartId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dossierpartId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("dossierpartId", getDossierpartId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dossierTemplateId", getDossierTemplateId());
		attributes.put("partNo", getPartNo());
		attributes.put("partName", getPartName());
		attributes.put("partTip", getPartTip());
		attributes.put("partType", getPartType());
		attributes.put("parentId", getParentId());
		attributes.put("sibling", getSibling());
		attributes.put("treeIndex", getTreeIndex());
		attributes.put("formScript", getFormScript());
		attributes.put("formReport", getFormReport());
		attributes.put("sampleData", getSampleData());
		attributes.put("required", getRequired());
		attributes.put("templateFileNo", getTemplateFileNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long dossierpartId = (Long)attributes.get("dossierpartId");

		if (dossierpartId != null) {
			setDossierpartId(dossierpartId);
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

		Long dossierTemplateId = (Long)attributes.get("dossierTemplateId");

		if (dossierTemplateId != null) {
			setDossierTemplateId(dossierTemplateId);
		}

		String partNo = (String)attributes.get("partNo");

		if (partNo != null) {
			setPartNo(partNo);
		}

		String partName = (String)attributes.get("partName");

		if (partName != null) {
			setPartName(partName);
		}

		String partTip = (String)attributes.get("partTip");

		if (partTip != null) {
			setPartTip(partTip);
		}

		Integer partType = (Integer)attributes.get("partType");

		if (partType != null) {
			setPartType(partType);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Double sibling = (Double)attributes.get("sibling");

		if (sibling != null) {
			setSibling(sibling);
		}

		String treeIndex = (String)attributes.get("treeIndex");

		if (treeIndex != null) {
			setTreeIndex(treeIndex);
		}

		String formScript = (String)attributes.get("formScript");

		if (formScript != null) {
			setFormScript(formScript);
		}

		String formReport = (String)attributes.get("formReport");

		if (formReport != null) {
			setFormReport(formReport);
		}

		String sampleData = (String)attributes.get("sampleData");

		if (sampleData != null) {
			setSampleData(sampleData);
		}

		Boolean required = (Boolean)attributes.get("required");

		if (required != null) {
			setRequired(required);
		}

		String templateFileNo = (String)attributes.get("templateFileNo");

		if (templateFileNo != null) {
			setTemplateFileNo(templateFileNo);
		}
	}

	@Override
	public long getDossierpartId() {
		return _dossierpartId;
	}

	@Override
	public void setDossierpartId(long dossierpartId) {
		_dossierpartId = dossierpartId;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierpartId", long.class);

				method.invoke(_dossierPartRemoteModel, dossierpartId);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_dossierPartRemoteModel, companyId);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_dossierPartRemoteModel, groupId);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_dossierPartRemoteModel, userId);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_dossierPartRemoteModel, createDate);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_dossierPartRemoteModel, modifiedDate);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setDossierTemplateId",
						long.class);

				method.invoke(_dossierPartRemoteModel, dossierTemplateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPartNo() {
		return _partNo;
	}

	@Override
	public void setPartNo(String partNo) {
		_partNo = partNo;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setPartNo", String.class);

				method.invoke(_dossierPartRemoteModel, partNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPartName() {
		return _partName;
	}

	@Override
	public void setPartName(String partName) {
		_partName = partName;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setPartName", String.class);

				method.invoke(_dossierPartRemoteModel, partName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPartTip() {
		return _partTip;
	}

	@Override
	public void setPartTip(String partTip) {
		_partTip = partTip;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setPartTip", String.class);

				method.invoke(_dossierPartRemoteModel, partTip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPartType() {
		return _partType;
	}

	@Override
	public void setPartType(int partType) {
		_partType = partType;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setPartType", int.class);

				method.invoke(_dossierPartRemoteModel, partType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_dossierPartRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getSibling() {
		return _sibling;
	}

	@Override
	public void setSibling(double sibling) {
		_sibling = sibling;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setSibling", double.class);

				method.invoke(_dossierPartRemoteModel, sibling);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTreeIndex() {
		return _treeIndex;
	}

	@Override
	public void setTreeIndex(String treeIndex) {
		_treeIndex = treeIndex;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setTreeIndex", String.class);

				method.invoke(_dossierPartRemoteModel, treeIndex);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormScript() {
		return _formScript;
	}

	@Override
	public void setFormScript(String formScript) {
		_formScript = formScript;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setFormScript", String.class);

				method.invoke(_dossierPartRemoteModel, formScript);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFormReport() {
		return _formReport;
	}

	@Override
	public void setFormReport(String formReport) {
		_formReport = formReport;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setFormReport", String.class);

				method.invoke(_dossierPartRemoteModel, formReport);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSampleData() {
		return _sampleData;
	}

	@Override
	public void setSampleData(String sampleData) {
		_sampleData = sampleData;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setSampleData", String.class);

				method.invoke(_dossierPartRemoteModel, sampleData);
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

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setRequired", boolean.class);

				method.invoke(_dossierPartRemoteModel, required);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTemplateFileNo() {
		return _templateFileNo;
	}

	@Override
	public void setTemplateFileNo(String templateFileNo) {
		_templateFileNo = templateFileNo;

		if (_dossierPartRemoteModel != null) {
			try {
				Class<?> clazz = _dossierPartRemoteModel.getClass();

				Method method = clazz.getMethod("setTemplateFileNo",
						String.class);

				method.invoke(_dossierPartRemoteModel, templateFileNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDossierPartRemoteModel() {
		return _dossierPartRemoteModel;
	}

	public void setDossierPartRemoteModel(BaseModel<?> dossierPartRemoteModel) {
		_dossierPartRemoteModel = dossierPartRemoteModel;
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

		Class<?> remoteModelClass = _dossierPartRemoteModel.getClass();

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

		Object returnValue = method.invoke(_dossierPartRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DossierPartLocalServiceUtil.addDossierPart(this);
		}
		else {
			DossierPartLocalServiceUtil.updateDossierPart(this);
		}
	}

	@Override
	public DossierPart toEscapedModel() {
		return (DossierPart)ProxyUtil.newProxyInstance(DossierPart.class.getClassLoader(),
			new Class[] { DossierPart.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DossierPartClp clone = new DossierPartClp();

		clone.setDossierpartId(getDossierpartId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDossierTemplateId(getDossierTemplateId());
		clone.setPartNo(getPartNo());
		clone.setPartName(getPartName());
		clone.setPartTip(getPartTip());
		clone.setPartType(getPartType());
		clone.setParentId(getParentId());
		clone.setSibling(getSibling());
		clone.setTreeIndex(getTreeIndex());
		clone.setFormScript(getFormScript());
		clone.setFormReport(getFormReport());
		clone.setSampleData(getSampleData());
		clone.setRequired(getRequired());
		clone.setTemplateFileNo(getTemplateFileNo());

		return clone;
	}

	@Override
	public int compareTo(DossierPart dossierPart) {
		int value = 0;

		if (getSibling() < dossierPart.getSibling()) {
			value = -1;
		}
		else if (getSibling() > dossierPart.getSibling()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof DossierPartClp)) {
			return false;
		}

		DossierPartClp dossierPart = (DossierPartClp)obj;

		long primaryKey = dossierPart.getPrimaryKey();

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

		sb.append("{dossierpartId=");
		sb.append(getDossierpartId());
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
		sb.append(", dossierTemplateId=");
		sb.append(getDossierTemplateId());
		sb.append(", partNo=");
		sb.append(getPartNo());
		sb.append(", partName=");
		sb.append(getPartName());
		sb.append(", partTip=");
		sb.append(getPartTip());
		sb.append(", partType=");
		sb.append(getPartType());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", sibling=");
		sb.append(getSibling());
		sb.append(", treeIndex=");
		sb.append(getTreeIndex());
		sb.append(", formScript=");
		sb.append(getFormScript());
		sb.append(", formReport=");
		sb.append(getFormReport());
		sb.append(", sampleData=");
		sb.append(getSampleData());
		sb.append(", required=");
		sb.append(getRequired());
		sb.append(", templateFileNo=");
		sb.append(getTemplateFileNo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(61);

		sb.append("<model><model-name>");
		sb.append("org.opencps.dossiermgt.model.DossierPart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>dossierpartId</column-name><column-value><![CDATA[");
		sb.append(getDossierpartId());
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
			"<column><column-name>dossierTemplateId</column-name><column-value><![CDATA[");
		sb.append(getDossierTemplateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partNo</column-name><column-value><![CDATA[");
		sb.append(getPartNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partName</column-name><column-value><![CDATA[");
		sb.append(getPartName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partTip</column-name><column-value><![CDATA[");
		sb.append(getPartTip());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>partType</column-name><column-value><![CDATA[");
		sb.append(getPartType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sibling</column-name><column-value><![CDATA[");
		sb.append(getSibling());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>treeIndex</column-name><column-value><![CDATA[");
		sb.append(getTreeIndex());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formScript</column-name><column-value><![CDATA[");
		sb.append(getFormScript());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>formReport</column-name><column-value><![CDATA[");
		sb.append(getFormReport());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sampleData</column-name><column-value><![CDATA[");
		sb.append(getSampleData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>required</column-name><column-value><![CDATA[");
		sb.append(getRequired());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>templateFileNo</column-name><column-value><![CDATA[");
		sb.append(getTemplateFileNo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _dossierpartId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _dossierTemplateId;
	private String _partNo;
	private String _partName;
	private String _partTip;
	private int _partType;
	private long _parentId;
	private double _sibling;
	private String _treeIndex;
	private String _formScript;
	private String _formReport;
	private String _sampleData;
	private boolean _required;
	private String _templateFileNo;
	private BaseModel<?> _dossierPartRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.dossiermgt.service.ClpSerializer.class;
}