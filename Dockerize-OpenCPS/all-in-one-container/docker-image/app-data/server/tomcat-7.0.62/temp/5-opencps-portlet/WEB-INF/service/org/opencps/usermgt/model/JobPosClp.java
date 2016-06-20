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

package org.opencps.usermgt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import org.opencps.usermgt.service.ClpSerializer;
import org.opencps.usermgt.service.JobPosLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author khoavd
 */
public class JobPosClp extends BaseModelImpl<JobPos> implements JobPos {
	public JobPosClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return JobPos.class;
	}

	@Override
	public String getModelClassName() {
		return JobPos.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _jobPosId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setJobPosId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _jobPosId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("jobPosId", getJobPosId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("workingUnitId", getWorkingUnitId());
		attributes.put("directWorkingUnitId", getDirectWorkingUnitId());
		attributes.put("leader", getLeader());
		attributes.put("mappingRoleId", getMappingRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long jobPosId = (Long)attributes.get("jobPosId");

		if (jobPosId != null) {
			setJobPosId(jobPosId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long workingUnitId = (Long)attributes.get("workingUnitId");

		if (workingUnitId != null) {
			setWorkingUnitId(workingUnitId);
		}

		Long directWorkingUnitId = (Long)attributes.get("directWorkingUnitId");

		if (directWorkingUnitId != null) {
			setDirectWorkingUnitId(directWorkingUnitId);
		}

		Integer leader = (Integer)attributes.get("leader");

		if (leader != null) {
			setLeader(leader);
		}

		Long mappingRoleId = (Long)attributes.get("mappingRoleId");

		if (mappingRoleId != null) {
			setMappingRoleId(mappingRoleId);
		}
	}

	@Override
	public long getJobPosId() {
		return _jobPosId;
	}

	@Override
	public void setJobPosId(long jobPosId) {
		_jobPosId = jobPosId;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setJobPosId", long.class);

				method.invoke(_jobPosRemoteModel, jobPosId);
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

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_jobPosRemoteModel, companyId);
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

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_jobPosRemoteModel, groupId);
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

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_jobPosRemoteModel, userId);
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

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_jobPosRemoteModel, createDate);
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

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_jobPosRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_jobPosRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_jobPosRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkingUnitId() {
		return _workingUnitId;
	}

	@Override
	public void setWorkingUnitId(long workingUnitId) {
		_workingUnitId = workingUnitId;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingUnitId", long.class);

				method.invoke(_jobPosRemoteModel, workingUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDirectWorkingUnitId() {
		return _directWorkingUnitId;
	}

	@Override
	public void setDirectWorkingUnitId(long directWorkingUnitId) {
		_directWorkingUnitId = directWorkingUnitId;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setDirectWorkingUnitId",
						long.class);

				method.invoke(_jobPosRemoteModel, directWorkingUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLeader() {
		return _leader;
	}

	@Override
	public void setLeader(int leader) {
		_leader = leader;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setLeader", int.class);

				method.invoke(_jobPosRemoteModel, leader);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMappingRoleId() {
		return _mappingRoleId;
	}

	@Override
	public void setMappingRoleId(long mappingRoleId) {
		_mappingRoleId = mappingRoleId;

		if (_jobPosRemoteModel != null) {
			try {
				Class<?> clazz = _jobPosRemoteModel.getClass();

				Method method = clazz.getMethod("setMappingRoleId", long.class);

				method.invoke(_jobPosRemoteModel, mappingRoleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getJobPosRemoteModel() {
		return _jobPosRemoteModel;
	}

	public void setJobPosRemoteModel(BaseModel<?> jobPosRemoteModel) {
		_jobPosRemoteModel = jobPosRemoteModel;
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

		Class<?> remoteModelClass = _jobPosRemoteModel.getClass();

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

		Object returnValue = method.invoke(_jobPosRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			JobPosLocalServiceUtil.addJobPos(this);
		}
		else {
			JobPosLocalServiceUtil.updateJobPos(this);
		}
	}

	@Override
	public JobPos toEscapedModel() {
		return (JobPos)ProxyUtil.newProxyInstance(JobPos.class.getClassLoader(),
			new Class[] { JobPos.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		JobPosClp clone = new JobPosClp();

		clone.setJobPosId(getJobPosId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setWorkingUnitId(getWorkingUnitId());
		clone.setDirectWorkingUnitId(getDirectWorkingUnitId());
		clone.setLeader(getLeader());
		clone.setMappingRoleId(getMappingRoleId());

		return clone;
	}

	@Override
	public int compareTo(JobPos jobPos) {
		long primaryKey = jobPos.getPrimaryKey();

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

		if (!(obj instanceof JobPosClp)) {
			return false;
		}

		JobPosClp jobPos = (JobPosClp)obj;

		long primaryKey = jobPos.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{jobPosId=");
		sb.append(getJobPosId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", workingUnitId=");
		sb.append(getWorkingUnitId());
		sb.append(", directWorkingUnitId=");
		sb.append(getDirectWorkingUnitId());
		sb.append(", leader=");
		sb.append(getLeader());
		sb.append(", mappingRoleId=");
		sb.append(getMappingRoleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("org.opencps.usermgt.model.JobPos");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>jobPosId</column-name><column-value><![CDATA[");
		sb.append(getJobPosId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingUnitId</column-name><column-value><![CDATA[");
		sb.append(getWorkingUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>directWorkingUnitId</column-name><column-value><![CDATA[");
		sb.append(getDirectWorkingUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leader</column-name><column-value><![CDATA[");
		sb.append(getLeader());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mappingRoleId</column-name><column-value><![CDATA[");
		sb.append(getMappingRoleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _jobPosId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private long _workingUnitId;
	private long _directWorkingUnitId;
	private int _leader;
	private long _mappingRoleId;
	private BaseModel<?> _jobPosRemoteModel;
	private Class<?> _clpSerializerClass = org.opencps.usermgt.service.ClpSerializer.class;
}