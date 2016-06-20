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
 * This class is used by SOAP remote services, specifically {@link org.opencps.processmgt.service.http.ProcessOrderServiceSoap}.
 *
 * @author khoavd
 * @see org.opencps.processmgt.service.http.ProcessOrderServiceSoap
 * @generated
 */
public class ProcessOrderSoap implements Serializable {
	public static ProcessOrderSoap toSoapModel(ProcessOrder model) {
		ProcessOrderSoap soapModel = new ProcessOrderSoap();

		soapModel.setProcessOrderId(model.getProcessOrderId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setServiceInfoId(model.getServiceInfoId());
		soapModel.setDossierTemplateId(model.getDossierTemplateId());
		soapModel.setGovAgencyCode(model.getGovAgencyCode());
		soapModel.setGovAgencyName(model.getGovAgencyName());
		soapModel.setGovAgencyOrganizationId(model.getGovAgencyOrganizationId());
		soapModel.setServiceProcessId(model.getServiceProcessId());
		soapModel.setDossierId(model.getDossierId());
		soapModel.setFileGroupId(model.getFileGroupId());
		soapModel.setProcessStepId(model.getProcessStepId());
		soapModel.setActionUserId(model.getActionUserId());
		soapModel.setActionDatetime(model.getActionDatetime());
		soapModel.setActionNote(model.getActionNote());
		soapModel.setAssignToUserId(model.getAssignToUserId());
		soapModel.setProcessWorkflowId(model.getProcessWorkflowId());
		soapModel.setDossierStatus(model.getDossierStatus());
		soapModel.setErrorInfo(model.getErrorInfo());

		return soapModel;
	}

	public static ProcessOrderSoap[] toSoapModels(ProcessOrder[] models) {
		ProcessOrderSoap[] soapModels = new ProcessOrderSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProcessOrderSoap[][] toSoapModels(ProcessOrder[][] models) {
		ProcessOrderSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProcessOrderSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProcessOrderSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProcessOrderSoap[] toSoapModels(List<ProcessOrder> models) {
		List<ProcessOrderSoap> soapModels = new ArrayList<ProcessOrderSoap>(models.size());

		for (ProcessOrder model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProcessOrderSoap[soapModels.size()]);
	}

	public ProcessOrderSoap() {
	}

	public long getPrimaryKey() {
		return _processOrderId;
	}

	public void setPrimaryKey(long pk) {
		setProcessOrderId(pk);
	}

	public long getProcessOrderId() {
		return _processOrderId;
	}

	public void setProcessOrderId(long processOrderId) {
		_processOrderId = processOrderId;
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

	public long getServiceInfoId() {
		return _serviceInfoId;
	}

	public void setServiceInfoId(long serviceInfoId) {
		_serviceInfoId = serviceInfoId;
	}

	public long getDossierTemplateId() {
		return _dossierTemplateId;
	}

	public void setDossierTemplateId(long dossierTemplateId) {
		_dossierTemplateId = dossierTemplateId;
	}

	public String getGovAgencyCode() {
		return _govAgencyCode;
	}

	public void setGovAgencyCode(String govAgencyCode) {
		_govAgencyCode = govAgencyCode;
	}

	public String getGovAgencyName() {
		return _govAgencyName;
	}

	public void setGovAgencyName(String govAgencyName) {
		_govAgencyName = govAgencyName;
	}

	public long getGovAgencyOrganizationId() {
		return _govAgencyOrganizationId;
	}

	public void setGovAgencyOrganizationId(long govAgencyOrganizationId) {
		_govAgencyOrganizationId = govAgencyOrganizationId;
	}

	public long getServiceProcessId() {
		return _serviceProcessId;
	}

	public void setServiceProcessId(long serviceProcessId) {
		_serviceProcessId = serviceProcessId;
	}

	public long getDossierId() {
		return _dossierId;
	}

	public void setDossierId(long dossierId) {
		_dossierId = dossierId;
	}

	public long getFileGroupId() {
		return _fileGroupId;
	}

	public void setFileGroupId(long fileGroupId) {
		_fileGroupId = fileGroupId;
	}

	public long getProcessStepId() {
		return _processStepId;
	}

	public void setProcessStepId(long processStepId) {
		_processStepId = processStepId;
	}

	public long getActionUserId() {
		return _actionUserId;
	}

	public void setActionUserId(long actionUserId) {
		_actionUserId = actionUserId;
	}

	public Date getActionDatetime() {
		return _actionDatetime;
	}

	public void setActionDatetime(Date actionDatetime) {
		_actionDatetime = actionDatetime;
	}

	public String getActionNote() {
		return _actionNote;
	}

	public void setActionNote(String actionNote) {
		_actionNote = actionNote;
	}

	public long getAssignToUserId() {
		return _assignToUserId;
	}

	public void setAssignToUserId(long assignToUserId) {
		_assignToUserId = assignToUserId;
	}

	public long getProcessWorkflowId() {
		return _processWorkflowId;
	}

	public void setProcessWorkflowId(long processWorkflowId) {
		_processWorkflowId = processWorkflowId;
	}

	public int getDossierStatus() {
		return _dossierStatus;
	}

	public void setDossierStatus(int dossierStatus) {
		_dossierStatus = dossierStatus;
	}

	public String getErrorInfo() {
		return _errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		_errorInfo = errorInfo;
	}

	private long _processOrderId;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _serviceInfoId;
	private long _dossierTemplateId;
	private String _govAgencyCode;
	private String _govAgencyName;
	private long _govAgencyOrganizationId;
	private long _serviceProcessId;
	private long _dossierId;
	private long _fileGroupId;
	private long _processStepId;
	private long _actionUserId;
	private Date _actionDatetime;
	private String _actionNote;
	private long _assignToUserId;
	private long _processWorkflowId;
	private int _dossierStatus;
	private String _errorInfo;
}