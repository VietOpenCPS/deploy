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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.ServiceProcessServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.ServiceProcessServiceSoap
 * @generated
 */
public class ServiceProcessSoap implements Serializable {
	public static ServiceProcessSoap toSoapModel(ServiceProcess model) {
		ServiceProcessSoap soapModel = new ServiceProcessSoap();

		soapModel.setServiceProcessId(model.getServiceProcessId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setProcessNo(model.getProcessNo());
		soapModel.setProcessName(model.getProcessName());
		soapModel.setDescription(model.getDescription());
		soapModel.setDossierTemplateId(model.getDossierTemplateId());

		return soapModel;
	}

	public static ServiceProcessSoap[] toSoapModels(ServiceProcess[] models) {
		ServiceProcessSoap[] soapModels = new ServiceProcessSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceProcessSoap[][] toSoapModels(ServiceProcess[][] models) {
		ServiceProcessSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ServiceProcessSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceProcessSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceProcessSoap[] toSoapModels(List<ServiceProcess> models) {
		List<ServiceProcessSoap> soapModels = new ArrayList<ServiceProcessSoap>(models.size());

		for (ServiceProcess model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ServiceProcessSoap[soapModels.size()]);
	}

	public ServiceProcessSoap() {
	}

	public long getPrimaryKey() {
		return _serviceProcessId;
	}

	public void setPrimaryKey(long pk) {
		setServiceProcessId(pk);
	}

	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
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

	public String getProcessNo() {
		return _processNo;
	}

	public void setProcessNo(String processNo) {
		_processNo = processNo;
	}

	public String getProcessName() {
		return _processName;
	}

	public void setProcessName(String processName) {
		_processName = processName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;
	}

	private long _serviceProcessId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _processNo;
	private String _processName;
	private String _description;
	private long _dossierTemplateId;
}