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
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.ProcessStepServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.ProcessStepServiceSoap
 * @generated
 */
public class ProcessStepSoap implements Serializable {
	public static ProcessStepSoap toSoapModel(ProcessStep model) {
		ProcessStepSoap soapModel = new ProcessStepSoap();

		soapModel.setProcessStepId(model.getProcessStepId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceProcessId(model.getServiceProcessId());
		soapModel.setStepName(model.getStepName());
		soapModel.setSequenceNo(model.getSequenceNo());
		soapModel.setDossierStatus(model.getDossierStatus());
		soapModel.setDaysDuration(model.getDaysDuration());
		soapModel.setReferenceDossierPartId(model.getReferenceDossierPartId());
		soapModel.setExternalAppUrl(model.getExternalAppUrl());

		return soapModel;
	}

	public static ProcessStepSoap[] toSoapModels(ProcessStep[] models) {
		ProcessStepSoap[] soapModels = new ProcessStepSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProcessStepSoap[][] toSoapModels(ProcessStep[][] models) {
		ProcessStepSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProcessStepSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProcessStepSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProcessStepSoap[] toSoapModels(List<ProcessStep> models) {
		List<ProcessStepSoap> soapModels = new ArrayList<ProcessStepSoap>(models.size());

		for (ProcessStep model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProcessStepSoap[soapModels.size()]);
	}

	public ProcessStepSoap() {
	}

	public long getPrimaryKey() {
		return _processStepId;
	}

	public void setPrimaryKey(long pk) {
		setProcessStepId(pk);
	}

	public long getProcessStepId() {
		return _processStepId;
	}

	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;
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

	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	public String getStepName() {
		return _stepName;
	}

	public void setStepName(String stepName) {
		_stepName = stepName;
	}

	public int getSequenceNo() {
		return _sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		_sequenceNo = sequenceNo;
	}

	public String getDossierStatus() {
		return _dossierStatus;
	}

	public void setDossierStatus(String dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	public int getDaysDuration() {
		return _daysDuration;
	}

	public void setDaysDuration(int daysDuration) {
		_daysDuration = daysDuration;
	}

	public long getReferenceDossierPartId() {
		return _referenceDossierPartId;
	}

	public void setReferenceDossierPartId(long referenceDossierPartId) {
		_referenceDossierPartId = referenceDossierPartId;
	}

	public String getExternalAppUrl() {
		return _externalAppUrl;
	}

	public void setExternalAppUrl(String externalAppUrl) {
		_externalAppUrl = externalAppUrl;
	}

	private long _processStepId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceProcessId;
	private String _stepName;
	private int _sequenceNo;
	private String _dossierStatus;
	private int _daysDuration;
	private long _referenceDossierPartId;
	private String _externalAppUrl;
}