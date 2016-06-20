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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link JobPos}.
 * </p>
 *
 * @author khoavd
 * @see JobPos
 * @generated
 */
public class JobPosWrapper implements JobPos, ModelWrapper<JobPos> {
	public JobPosWrapper(JobPos jobPos) {
		_jobPos = jobPos;
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

	/**
	* Returns the primary key of this job pos.
	*
	* @return the primary key of this job pos
	*/
	@Override
	public long getPrimaryKey() {
		return _jobPos.getPrimaryKey();
	}

	/**
	* Sets the primary key of this job pos.
	*
	* @param primaryKey the primary key of this job pos
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_jobPos.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the job pos ID of this job pos.
	*
	* @return the job pos ID of this job pos
	*/
	@Override
	public long getJobPosId() {
		return _jobPos.getJobPosId();
	}

	/**
	* Sets the job pos ID of this job pos.
	*
	* @param jobPosId the job pos ID of this job pos
	*/
	@Override
	public void setJobPosId(long jobPosId) {
		_jobPos.setJobPosId(jobPosId);
	}

	/**
	* Returns the company ID of this job pos.
	*
	* @return the company ID of this job pos
	*/
	@Override
	public long getCompanyId() {
		return _jobPos.getCompanyId();
	}

	/**
	* Sets the company ID of this job pos.
	*
	* @param companyId the company ID of this job pos
	*/
	@Override
	public void setCompanyId(long companyId) {
		_jobPos.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this job pos.
	*
	* @return the group ID of this job pos
	*/
	@Override
	public long getGroupId() {
		return _jobPos.getGroupId();
	}

	/**
	* Sets the group ID of this job pos.
	*
	* @param groupId the group ID of this job pos
	*/
	@Override
	public void setGroupId(long groupId) {
		_jobPos.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this job pos.
	*
	* @return the user ID of this job pos
	*/
	@Override
	public long getUserId() {
		return _jobPos.getUserId();
	}

	/**
	* Sets the user ID of this job pos.
	*
	* @param userId the user ID of this job pos
	*/
	@Override
	public void setUserId(long userId) {
		_jobPos.setUserId(userId);
	}

	/**
	* Returns the user uuid of this job pos.
	*
	* @return the user uuid of this job pos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _jobPos.getUserUuid();
	}

	/**
	* Sets the user uuid of this job pos.
	*
	* @param userUuid the user uuid of this job pos
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_jobPos.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this job pos.
	*
	* @return the create date of this job pos
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _jobPos.getCreateDate();
	}

	/**
	* Sets the create date of this job pos.
	*
	* @param createDate the create date of this job pos
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_jobPos.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this job pos.
	*
	* @return the modified date of this job pos
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _jobPos.getModifiedDate();
	}

	/**
	* Sets the modified date of this job pos.
	*
	* @param modifiedDate the modified date of this job pos
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_jobPos.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this job pos.
	*
	* @return the title of this job pos
	*/
	@Override
	public java.lang.String getTitle() {
		return _jobPos.getTitle();
	}

	/**
	* Sets the title of this job pos.
	*
	* @param title the title of this job pos
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_jobPos.setTitle(title);
	}

	/**
	* Returns the description of this job pos.
	*
	* @return the description of this job pos
	*/
	@Override
	public java.lang.String getDescription() {
		return _jobPos.getDescription();
	}

	/**
	* Sets the description of this job pos.
	*
	* @param description the description of this job pos
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_jobPos.setDescription(description);
	}

	/**
	* Returns the working unit ID of this job pos.
	*
	* @return the working unit ID of this job pos
	*/
	@Override
	public long getWorkingUnitId() {
		return _jobPos.getWorkingUnitId();
	}

	/**
	* Sets the working unit ID of this job pos.
	*
	* @param workingUnitId the working unit ID of this job pos
	*/
	@Override
	public void setWorkingUnitId(long workingUnitId) {
		_jobPos.setWorkingUnitId(workingUnitId);
	}

	/**
	* Returns the direct working unit ID of this job pos.
	*
	* @return the direct working unit ID of this job pos
	*/
	@Override
	public long getDirectWorkingUnitId() {
		return _jobPos.getDirectWorkingUnitId();
	}

	/**
	* Sets the direct working unit ID of this job pos.
	*
	* @param directWorkingUnitId the direct working unit ID of this job pos
	*/
	@Override
	public void setDirectWorkingUnitId(long directWorkingUnitId) {
		_jobPos.setDirectWorkingUnitId(directWorkingUnitId);
	}

	/**
	* Returns the leader of this job pos.
	*
	* @return the leader of this job pos
	*/
	@Override
	public int getLeader() {
		return _jobPos.getLeader();
	}

	/**
	* Sets the leader of this job pos.
	*
	* @param leader the leader of this job pos
	*/
	@Override
	public void setLeader(int leader) {
		_jobPos.setLeader(leader);
	}

	/**
	* Returns the mapping role ID of this job pos.
	*
	* @return the mapping role ID of this job pos
	*/
	@Override
	public long getMappingRoleId() {
		return _jobPos.getMappingRoleId();
	}

	/**
	* Sets the mapping role ID of this job pos.
	*
	* @param mappingRoleId the mapping role ID of this job pos
	*/
	@Override
	public void setMappingRoleId(long mappingRoleId) {
		_jobPos.setMappingRoleId(mappingRoleId);
	}

	@Override
	public boolean isNew() {
		return _jobPos.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_jobPos.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _jobPos.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_jobPos.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _jobPos.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _jobPos.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_jobPos.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _jobPos.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_jobPos.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_jobPos.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_jobPos.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new JobPosWrapper((JobPos)_jobPos.clone());
	}

	@Override
	public int compareTo(org.opencps.usermgt.model.JobPos jobPos) {
		return _jobPos.compareTo(jobPos);
	}

	@Override
	public int hashCode() {
		return _jobPos.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<org.opencps.usermgt.model.JobPos> toCacheModel() {
		return _jobPos.toCacheModel();
	}

	@Override
	public org.opencps.usermgt.model.JobPos toEscapedModel() {
		return new JobPosWrapper(_jobPos.toEscapedModel());
	}

	@Override
	public org.opencps.usermgt.model.JobPos toUnescapedModel() {
		return new JobPosWrapper(_jobPos.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _jobPos.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _jobPos.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_jobPos.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof JobPosWrapper)) {
			return false;
		}

		JobPosWrapper jobPosWrapper = (JobPosWrapper)obj;

		if (Validator.equals(_jobPos, jobPosWrapper._jobPos)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public JobPos getWrappedJobPos() {
		return _jobPos;
	}

	@Override
	public JobPos getWrappedModel() {
		return _jobPos;
	}

	@Override
	public void resetOriginalValues() {
		_jobPos.resetOriginalValues();
	}

	private JobPos _jobPos;
}