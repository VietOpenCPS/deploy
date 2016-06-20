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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.usermgt.service.http.JobPosServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.usermgt.service.http.JobPosServiceSoap
 * @generated
 */
public class JobPosSoap implements Serializable {
	public static JobPosSoap toSoapModel(JobPos model) {
		JobPosSoap soapModel = new JobPosSoap();

		soapModel.setJobPosId(model.getJobPosId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setWorkingUnitId(model.getWorkingUnitId());
		soapModel.setDirectWorkingUnitId(model.getDirectWorkingUnitId());
		soapModel.setLeader(model.getLeader());
		soapModel.setMappingRoleId(model.getMappingRoleId());

		return soapModel;
	}

	public static JobPosSoap[] toSoapModels(JobPos[] models) {
		JobPosSoap[] soapModels = new JobPosSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static JobPosSoap[][] toSoapModels(JobPos[][] models) {
		JobPosSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new JobPosSoap[models.length][models[0].length];
		}
		else {
			soapModels = new JobPosSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static JobPosSoap[] toSoapModels(List<JobPos> models) {
		List<JobPosSoap> soapModels = new ArrayList<JobPosSoap>(models.size());

		for (JobPos model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new JobPosSoap[soapModels.size()]);
	}

	public JobPosSoap() {
	}

	public long getPrimaryKey() {
		return _jobPosId;
	}

	public void setPrimaryKey(long pk) {
		setJobPosId(pk);
	}

	public long getJobPosId() {
		return _jobPosId;
	}

	public void setJobPosId(long jobPosId) {
		_jobPosId = jobPosId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getWorkingUnitId() {
		return _workingUnitId;
	}

	public void setWorkingUnitId(long workingUnitId) {
		_workingUnitId = workingUnitId;
	}

	public long getDirectWorkingUnitId() {
		return _directWorkingUnitId;
	}

	public void setDirectWorkingUnitId(long directWorkingUnitId) {
		_directWorkingUnitId = directWorkingUnitId;
	}

	public int getLeader() {
		return _leader;
	}

	public void setLeader(int leader) {
		_leader = leader;
	}

	public long getMappingRoleId() {
		return _mappingRoleId;
	}

	public void setMappingRoleId(long mappingRoleId) {
		_mappingRoleId = mappingRoleId;
	}

	private long _jobPosId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private long _workingUnitId;
	private long _directWorkingUnitId;
	private int _leader;
	private long _mappingRoleId;
}